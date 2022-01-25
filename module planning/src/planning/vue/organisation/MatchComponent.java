package planning.vue.organisation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

	protected int idMatch;
	protected Match match;
	protected Arbitre arbitre;
	protected List<Joueur> joueursMatch;
	protected List<Arbitre> listArbitres;
	protected List<Joueur> listJoueurs;
	protected IMatchDAO matchDAO;
	protected IJoueurDAO joueurDAO;
	protected IArbitreDAO arbitreDAO;

	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
		this.setData();
	}

	protected void setData() {
		match = matchDAO.getById(this.idMatch);
		listJoueurs = joueurDAO.getJoueurs();
		if (idMatch >= 1 && idMatch <= 12) {
			listJoueurs = joueurDAO.getJoueursQualif();
		} else if (idMatch >= 101 && idMatch <= 131) {
			listJoueurs = joueurDAO.getJoueursSimple();
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
		addOnClickListener(connection, mainFrame);
	}

	protected void addOnClickListener(Connection connection, PlanningOrga mainFrame) {
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (!matchDAO.isTermine(match)) {
					FormulaireInfosMatch form;
					if (matchDAO.isPremierTour(match)) {
						form = new FormulaireMatchAvecJoueurJFrame(match, joueursMatch, arbitre, listJoueurs, listArbitres,
								connection, mainFrame);
					} else {
						form = new FormulaireMatchJFrame(match, joueursMatch, arbitre, listJoueurs, listArbitres,
								connection, mainFrame);
					}
					form.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(MatchComponent.this, "Vous ne pouvez plus modifier les informations d'un match déjà terminé",
							"Action Impossible", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}

	public void createPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);

		String joueur1 = "Joueur 1";
		String joueur2 = "Joueur 2";
		int style1 = Font.PLAIN, style2 = Font.PLAIN;
		
		if (joueursMatch.size() > 0) {
			joueur1 = joueursMatch.get(0).getNom();
			if (joueurDAO.isGagnant(joueursMatch.get(0), match)) {
				style1 = Font.BOLD;
			}
		} else {
			style1 = Font.ITALIC;
		}
		if (joueursMatch.size() > 1) {
			joueur2 = joueursMatch.get(1).getNom();
			if (joueurDAO.isGagnant(joueursMatch.get(1), match)) {
				style2 = Font.BOLD;
			}
		} else {
			style2 = Font.ITALIC;
		}
		JLabel Joueur1Label = new JLabel(joueur1);
		Joueur1Label.setFont(new Font("Tahoma", style1, 12));
		Joueur1Label.setBounds(5, 0, 98, 21);
		add(Joueur1Label);

		JLabel Joueur2Label = new JLabel(joueur2);
		Joueur2Label.setFont(new Font("Tahoma", style2, 12));
		Joueur2Label.setBounds(5, 20, 98, 21);
		add(Joueur2Label);

		addJourHeure(77);
	}
	
	protected void addJourHeure(int pos) {
		Jour jour = match.getCreneau().getJour();
		String jourString = "Date";
		if (jour != null) {
			jourString = jour.toString();
		}
		JLabel dateLabel = new JLabel(jourString);
		dateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateLabel.setBounds(pos, 0, 57, 21);
		add(dateLabel);

		TrancheHoraire tranche = match.getCreneau().getTranche();
		String heureString = "Heure";
		if (tranche != null) {
			heureString = tranche.getHeureDebut() + "h";
		}
		JLabel heureLabel = new JLabel(heureString);
		heureLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		heureLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		heureLabel.setBounds(pos, 20, 57, 21);
		add(heureLabel);
	}
}
