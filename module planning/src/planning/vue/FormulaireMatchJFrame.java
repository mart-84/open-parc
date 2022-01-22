package planning.vue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import planning.dao.ArbitreDaoSql;
import planning.dao.CreneauDaoSql;
import planning.dao.JoueurDaoSql;
import planning.dao.interfacedao.IArbitreDAO;
import planning.dao.interfacedao.ICreneauDAO;
import planning.dao.interfacedao.IJoueurDAO;
import planning.metier.Arbitre;
import planning.metier.Court;
import planning.metier.Creneau;
import planning.metier.Joueur;
import planning.metier.Jour;
import planning.metier.Match;
import planning.metier.TrancheHoraire;
import planning.metier.TypeDeTournoi;

public class FormulaireMatchJFrame extends JFrame {

	private JPanel contentPane;
	private Match match;
	private Arbitre arbitre;
	private Joueur joueur1 = null, joueur2 = null;
	private List<Arbitre> listArbitres;
	private List<Joueur> listJoueurs;
	
	private JComboBox<Jour> comboBoxJour;
	private JComboBox<TrancheHoraire> comboBoxHeure;
	private JComboBox<Court> comboBoxCourt;
	private JComboBox<Arbitre> comboBoxArbitre;
	private JComboBox<Joueur> comboBoxJ1;
	private JComboBox<Joueur> comboBoxJ2;
	private Connection connection;
	
	/**
	 * Create the frame.
	 */
	public FormulaireMatchJFrame(Match match, List<Joueur> joueursMatch, Arbitre arbitre, List<Joueur> listJoueurs, List<Arbitre> listArbitres, Connection connection) {
		if (joueursMatch.size() == 2) {
			joueur1 = joueursMatch.get(0);
			joueur2 = joueursMatch.get(1);
		}
		this.match = match;
		this.arbitre = arbitre;
		this.listArbitres = listArbitres;
		this.listJoueurs = listJoueurs;
		this.connection = connection;
		createPanel();
	}
	
	private void createPanel() {
		setTitle("Match " + match.getMatchId());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 743, 607);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMatch = new JLabel("Match " + match.getMatchId());
		lblMatch.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatch.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblMatch.setAlignmentX(0.5f);
		lblMatch.setBounds(146, 23, 434, 49);
		contentPane.add(lblMatch);
		
		JButton boutonScore = new JButton("Saisir le score");
		boutonScore.setBounds(525, 82, 136, 33);
		contentPane.add(boutonScore);
		
		
		
		
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Jour");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(156, 154, 46, 14);
		contentPane.add(lblNewLabel_1_2_1);
		
		comboBoxJour = new JComboBox<Jour>();
		comboBoxJour.setModel(new DefaultComboBoxModel<Jour>(Jour.values()));
		if (match.getCreneau().getJour() != null) {
			comboBoxJour.setSelectedItem(match.getCreneau().getJour());
		}
		comboBoxJour.setBounds(225, 152, 109, 22);
		contentPane.add(comboBoxJour);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Heure");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(383, 154, 52, 14);
		contentPane.add(lblNewLabel_1_2_2);
		
		comboBoxHeure = new JComboBox<TrancheHoraire>();
		comboBoxHeure.setModel(new DefaultComboBoxModel<TrancheHoraire>(TrancheHoraire.values()));
		if (match.getCreneau().getTranche() != null) {
			comboBoxHeure.setSelectedItem(match.getCreneau().getTranche());
		}
		comboBoxHeure.setBounds(452, 152, 109, 22);
		contentPane.add(comboBoxHeure);
		
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Court");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(383, 342, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		comboBoxCourt = new JComboBox<Court>();
		comboBoxCourt.setModel(new DefaultComboBoxModel<Court>(Court.values()));
		if (match.getCreneau().getCourt() != null) {
			comboBoxCourt.setSelectedItem(match.getCreneau().getCourt());
		}
		comboBoxCourt.setBounds(452, 340, 109, 22);
		contentPane.add(comboBoxCourt);
		
		
		
		
				
		JLabel lblNewLabel_1_1 = new JLabel("Arbitre");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(156, 342, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		comboBoxArbitre = new JComboBox<Arbitre>();
		comboBoxArbitre.setModel(new DefaultComboBoxModel<Arbitre>(listArbitres.toArray(new Arbitre[0])));
		if (arbitre != null) {
			comboBoxArbitre.setSelectedItem(arbitre);
		}
		comboBoxArbitre.setBounds(225, 340, 109, 22);
		contentPane.add(comboBoxArbitre);
		
		
		
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Joueur 1");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(132, 249, 70, 14);
		contentPane.add(lblNewLabel_1_2);
		
		comboBoxJ1 = new JComboBox<Joueur>();
		comboBoxJ1.setModel(new DefaultComboBoxModel<Joueur>(listJoueurs.toArray(new Joueur[0])));
		if (joueur1 != null) {
			comboBoxJ1.setSelectedItem(joueur1);
		}
		comboBoxJ1.setBounds(225, 247, 109, 22);
		contentPane.add(comboBoxJ1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Joueur 2");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(365, 249, 64, 14);
		contentPane.add(lblNewLabel_1_3);
		
		comboBoxJ2 = new JComboBox<Joueur>();
		comboBoxJ2.setModel(new DefaultComboBoxModel<Joueur>(listJoueurs.toArray(new Joueur[0])));
		if (joueur2 != null) {
			comboBoxJ2.setSelectedItem(joueur2);
		}
		comboBoxJ2.setBounds(452, 247, 109, 22);
		contentPane.add(comboBoxJ2);
		
		
		
		JButton boutonValider = new JButton("Valider le match");
		boutonValider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("\nPour le match " + match.getMatchId() + " du tournoi " + TypeDeTournoi.getTypeDeTournoiById(match.getTypeTournoiId()) + ", il faut enregistrer les données suivantes");
				System.out.println(comboBoxJour.getSelectedItem());
				System.out.println(comboBoxHeure.getSelectedItem());
				System.out.println(comboBoxCourt.getSelectedItem());
				System.out.println(comboBoxArbitre.getSelectedItem());
				System.out.println(comboBoxJ1.getSelectedItem());
				System.out.println(comboBoxJ2.getSelectedItem());
				
				Jour jour = (Jour) comboBoxJour.getSelectedItem();
				TrancheHoraire tranche = (TrancheHoraire) comboBoxHeure.getSelectedItem();
				Court court = (Court) comboBoxCourt.getSelectedItem();
				match = new Match(match.getMatchId(), match.getTypeTournoiId(), new Creneau(jour, tranche, court));
				arbitre = (Arbitre) comboBoxArbitre.getSelectedItem();
				joueur1 = (Joueur) comboBoxJ1.getSelectedItem();
				joueur2 = (Joueur) comboBoxJ2.getSelectedItem();
				verifierDonnees();
			}
		});
		
		boutonValider.setBounds(382, 481, 126, 28);
		contentPane.add(boutonValider);
		
		JButton boutonAnnuler = new JButton("Annuler");
		boutonAnnuler.setBounds(237, 481, 126, 28);
		boutonAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(boutonAnnuler);
	}
	
	private void verifierDonnees() {
		/*
		 * Vérification à effectuer sur les données
		 * 
		 * - Nombre de matchs déjà juger par un arbitre de chaise : 4 au maximum (2 simples et 2 doubles) V
		 * - Arbitre pas déjà occupé dans un autre match
		 * - Nationalité de l'arbitre =!= nationalité des joueurs V
		 * - Joueur pas déjà occupé dans un autre match d'un des tournois V
		 * - Disponibilité du court
		 */
		
		if (!verifierNombreMatchArbitre()) {
			System.out.println("L'arbitre a déjà juger trop de matchs");
		}
		if (!verifierNationalites()) {
			System.out.println("L'arbitre doit etre de nationalité differente des joueurs");
		}
		if (!verifierOccupationJoueur()) {
			System.out.println("Les joueurs ne doivent pas déjà être occupés sur un autre match");
		}
		if (!verifierDispoCourt()) {
			System.out.println("Le court ne doit pas déjà être occupé");
		}
	}
	
	// renvoie true si l'arbitre peut juger le match
	private boolean verifierNombreMatchArbitre() {
		IArbitreDAO arbitreDAO = new ArbitreDaoSql();
		arbitreDAO.setConnection(connection);
		int[] nombreMatch = arbitreDAO.getNombreMatchArbitre(arbitre);
		return nombreMatch[0] < 2 && nombreMatch[1] < 2;
	}
	
	private boolean verifierNationalites() {
		return !arbitre.getNationalite().equals(joueur1.getNationalite()) && !arbitre.getNationalite().equals(joueur2.getNationalite());
	}
	
	private boolean verifierOccupationJoueur() {
		IJoueurDAO joueurDAO = new JoueurDaoSql();
		joueurDAO.setConnection(connection);
		return joueurDAO.checkJoueurDispo(joueur1, match.getCreneau(), match) && joueurDAO.checkJoueurDispo(joueur2, match.getCreneau(), match);
	}
	
	private boolean verifierDispoCourt() {
		ICreneauDAO creneauDAO = new CreneauDaoSql();
		creneauDAO.setConnection(connection);
		return creneauDAO.checkDispoCourt(match.getCreneau(), match.getMatchId());
	}
	
}
