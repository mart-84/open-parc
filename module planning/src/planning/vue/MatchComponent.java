package planning.vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import planning.dao.interfacedao.IArbitreDAO;
import planning.dao.interfacedao.IJoueurDAO;
import planning.dao.interfacedao.IMatchDAO;
import planning.dao.sql.ArbitreDaoSql;
import planning.dao.sql.JoueurDaoSql;
import planning.dao.sql.MatchDaoSql;
import planning.metier.Arbitre;
import planning.metier.Joueur;
import planning.metier.Jour;
import planning.metier.Match;
import planning.metier.TrancheHoraire;

public class MatchComponent extends JPanel {

	private int idMatch;
	private Match match;
	private Arbitre arbitre;
	private List<Joueur> joueursMatch;
	private List<Arbitre> listArbitres;
	private List<Joueur> listJoueurs;
	private IMatchDAO matchDAO;
	private IJoueurDAO joueurDAO;
	private IArbitreDAO arbitreDAO;

	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
		this.setData();
	}

	private void setData() {
		match = matchDAO.getById(this.idMatch);
		listJoueurs = joueurDAO.getJoueurs();
		if (idMatch >= 1 && idMatch <= 12) {
			listJoueurs = joueurDAO.getJoueursQualif();
		} else if (idMatch >= 101 && idMatch <= 131) {
			listJoueurs = joueurDAO.getJoueursSimple();
		} else if (idMatch >= 201 && idMatch <= 215) {
			listJoueurs = joueurDAO.getJoueursDouble();
		}
		listArbitres = arbitreDAO.getArbitres();

		joueursMatch = joueurDAO.getByMatch(this.match);
		arbitre = arbitreDAO.getByMatch(this.match);

		createPanel();
	}

	/**
	 * Create the panel.
	 */
	public MatchComponent(Connection connection, PlanningOrga mainFrame) {
		this.matchDAO = new MatchDaoSql();
		this.matchDAO.setConnection(connection);
		this.joueurDAO = new JoueurDaoSql();
		this.joueurDAO.setConnection(connection);
		this.arbitreDAO = new ArbitreDaoSql();
		this.arbitreDAO.setConnection(connection);

		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				FormulaireInfosMatch form;
				if (matchDAO.isPremierTour(match)) {
					form = new FormulaireMatchAvecJoueurJFrame(match, joueursMatch, arbitre, listJoueurs, listArbitres,
							connection, mainFrame);
				} else {
					form = new FormulaireMatchJFrame(match, joueursMatch, arbitre, listJoueurs, listArbitres,
							connection, mainFrame);
				}
				form.setVisible(true);
			}
		});
	}

	public void createPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);

		String joueur1 = "Joueur 1";
		String joueur2 = "Joueur 2";

		if (joueursMatch.size() > 0) {
			joueur1 = joueursMatch.get(0).getNom();
			joueur2 = joueursMatch.get(1).getNom();
		}

		int style = Font.PLAIN;
		if (joueur1.equals("Joueur 1")) {
			style = Font.ITALIC;
		}
		JLabel Joueur1Label = new JLabel(joueur1);
		Joueur1Label.setFont(new Font("Tahoma", style, 12));
		Joueur1Label.setBounds(5, 0, 98, 21);
		add(Joueur1Label);

		style = Font.PLAIN;
		if (joueur2.equals("Joueur 2")) {
			style = Font.ITALIC;
		}
		JLabel Joueur2Label = new JLabel(joueur2);
		Joueur2Label.setFont(new Font("Tahoma", style, 12));
		Joueur2Label.setBounds(5, 20, 98, 21);
		add(Joueur2Label);

		Jour jour = match.getCreneau().getJour();
		String jourString = "Date";
		if (jour != null) {
			jourString = jour.toString();
		}
		JLabel dateLabel = new JLabel(jourString);
		dateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateLabel.setBounds(77, 0, 57, 21);
		add(dateLabel);

		TrancheHoraire tranche = match.getCreneau().getTranche();
		String heureString = "Heure";
		if (tranche != null) {
			heureString = tranche.getHeureDebut() + "h";
		}
		JLabel heureLabel = new JLabel(heureString);
		heureLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		heureLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		heureLabel.setBounds(77, 20, 57, 21);
		add(heureLabel);
	}
}
