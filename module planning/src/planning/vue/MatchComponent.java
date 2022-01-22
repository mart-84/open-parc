package planning.vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
					form = new FormulaireMatchAvecJoueurJFrame(match, joueursMatch, arbitre, listJoueurs, listArbitres, connection, mainFrame);
				} else {
					form = new FormulaireMatchJFrame(match, joueursMatch, arbitre, listJoueurs, listArbitres, connection, mainFrame);					
				}
				form.setVisible(true);
			}
		});
	}
	
	public void createPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel joueursPanel = new JPanel();
		add(joueursPanel);
		joueursPanel.setLayout(new BoxLayout(joueursPanel, BoxLayout.Y_AXIS));
		
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
		joueursPanel.add(Joueur1Label);
		
		style = Font.PLAIN;
		if (joueur2.equals("Joueur 2")) {
			style = Font.ITALIC;
		}
		JLabel Joueur2Label = new JLabel(joueur2);
		Joueur2Label.setFont(new Font("Tahoma", style, 12));
		joueursPanel.add(Joueur2Label);
		
		
		
		JPanel datePanel = new JPanel();
		add(datePanel);
		datePanel.setLayout(new BoxLayout(datePanel, BoxLayout.Y_AXIS));
		
		Jour jour = match.getCreneau().getJour();
		String jourString = "Date";
		if (jour != null) {
			jourString = jour.toString();
		}
		JLabel dateLabel = new JLabel(jourString);
		dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		datePanel.add(dateLabel);
		
		TrancheHoraire tranche = match.getCreneau().getTranche();
		String heureString = "Heure";
		if (tranche != null) {
			heureString = tranche.getHeureDebut() + "h";
		}
		JLabel heureLabel = new JLabel(heureString);
		heureLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		heureLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		datePanel.add(heureLabel);

	}

}
