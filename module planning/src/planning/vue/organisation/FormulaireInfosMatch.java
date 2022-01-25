package planning.vue.organisation;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import planning.dao.interfacedao.IArbitreDAO;
import planning.dao.interfacedao.ICreneauDAO;
import planning.dao.interfacedao.IJoueurDAO;
import planning.dao.interfacedao.IMatchDAO;
import planning.dao.sql.ArbitreDaoSql;
import planning.dao.sql.CreneauDaoSql;
import planning.dao.sql.JoueurDaoSql;
import planning.dao.sql.MatchDaoSql;
import planning.metier.Arbitre;
import planning.metier.Court;
import planning.metier.Joueur;
import planning.metier.Jour;
import planning.metier.Match;
import planning.metier.TrancheHoraire;
import planning.metier.TypeDeTournoi;

public abstract class FormulaireInfosMatch extends JFrame {

	protected Match match;
	protected Arbitre arbitre;
	protected Joueur joueur1 = null, joueur2 = null;
	protected List<Arbitre> listArbitres;
	protected List<Joueur> listJoueurs;
	protected JPanel contentPane;
	protected JComboBox<Jour> comboBoxJour;
	protected JComboBox<TrancheHoraire> comboBoxHeure;
	protected JComboBox<Court> comboBoxCourt;
	protected JComboBox<Arbitre> comboBoxArbitre;
	protected JButton boutonValider;
	protected Connection connection;
	protected PlanningOrga mainFrame;
	protected IMatchDAO matchDAO;
	protected IArbitreDAO arbitreDAO;
	protected IJoueurDAO joueurDAO;
	protected ICreneauDAO creneauDAO;

	public FormulaireInfosMatch(Match match, List<Joueur> joueursMatch, Arbitre arbitre, List<Joueur> listJoueurs,
			List<Arbitre> listArbitres, Connection connection, PlanningOrga mainFrame) {
		if (joueursMatch != null && joueursMatch.size() > 0) {
			joueur1 = joueursMatch.get(0);
		}
		if (joueursMatch != null && joueursMatch.size() > 1) {
			joueur2 = joueursMatch.get(1);
		}
		this.mainFrame = mainFrame;
		this.match = match;
		this.arbitre = arbitre;
		this.listArbitres = listArbitres;
		this.listJoueurs = listJoueurs;
		this.connection = connection;

		matchDAO = new MatchDaoSql();
		matchDAO.setConnection(connection);
		arbitreDAO = new ArbitreDaoSql();
		arbitreDAO.setConnection(connection);
		joueurDAO = new JoueurDaoSql();
		joueurDAO.setConnection(connection);
		creneauDAO = new CreneauDaoSql();
		creneauDAO.setConnection(connection);
		setupOthers();
		createPanel();
	}

	protected void setupOthers() {
	}

	protected void createPanel() {
		setupFrame();
		setupHeader();
		setupForm();
	}

	private void setupFrame() {
		setTitle("Match " + match.getMatchId());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 594, 570);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	private void setupHeader() {
		JLabel lblMatch = new JLabel("Match " + match.getMatchId());
		lblMatch.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatch.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblMatch.setAlignmentX(0.5f);
		lblMatch.setBounds(72, 11, 434, 49);
		contentPane.add(lblMatch);

		JLabel typeTournoiLabel = new JLabel(TypeDeTournoi.getById(match.getTypeTournoiId()).toString());
		typeTournoiLabel.setHorizontalAlignment(SwingConstants.CENTER);
		typeTournoiLabel.setBounds(214, 71, 149, 14);
		contentPane.add(typeTournoiLabel);
		setupScoreButton();
	}

	private void setupForm() {
		setupFormJour();
		setupFormHeure();
		setupFormArbitre();
		setupFormCourt();
		setupFormJoueurLabel();
		setupFormJoueurData();

		this.boutonValider = new JButton("Valider le match");
		boutonValider.setBounds(307, 467, 126, 28);
		contentPane.add(boutonValider);

		setupValiderButton();

		JButton boutonAnnuler = new JButton("Annuler");
		boutonAnnuler.setBounds(162, 467, 126, 28);
		boutonAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(boutonAnnuler);
	}

	protected abstract void setupFormJoueurData();

	protected abstract void setupValiderButton();

	protected void setupFormJoueurLabel() {
		JLabel lblNewLabel_1_2 = new JLabel("Joueur 1");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(21, 237, 70, 14);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Joueur 2");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(254, 237, 64, 14);
		contentPane.add(lblNewLabel_1_3);
	}

	private void setupScoreButton() {
		JButton boutonScore = new JButton("Saisir le score");
		setScoreButtonAction(boutonScore);
		boutonScore.setBounds(417, 71, 125, 28);
		contentPane.add(boutonScore);
	}
	
	protected void setScoreButtonAction(JButton button) {
		if (joueur1 != null && joueur2 != null) {
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					contentPane.removeAll();
					contentPane.repaint();
					SaisieScoreForm form = new SaisieScoreForm(match, joueur1, joueur2, matchDAO, joueurDAO, FormulaireInfosMatch.this, mainFrame);
					form.setSize(490, 439);
					setSize(490, 460);
					contentPane.add(form);
				}
				
			});
		} else {
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(contentPane, "Impossible de saisir le score d'un match dont les joueurs ne sont pas connus", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
				}
			});
		}
	}

	private void setupFormCourt() {
		JLabel lblNewLabel_1 = new JLabel("Court");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(272, 330, 46, 14);
		contentPane.add(lblNewLabel_1);

		comboBoxCourt = new JComboBox<Court>();
		comboBoxCourt.setModel(new DefaultComboBoxModel<Court>(Court.values()));
		if (match.getCreneau().getCourt() != null) {
			comboBoxCourt.setSelectedItem(match.getCreneau().getCourt());
		}
		comboBoxCourt.setBounds(341, 328, 128, 22);
		contentPane.add(comboBoxCourt);

	}

	private void setupFormArbitre() {
		JLabel lblNewLabel_1_1 = new JLabel("Arbitre");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(45, 330, 46, 14);
		contentPane.add(lblNewLabel_1_1);

		comboBoxArbitre = new JComboBox<Arbitre>();
		comboBoxArbitre.setModel(new DefaultComboBoxModel<Arbitre>(listArbitres.toArray(new Arbitre[0])));
		if (arbitre != null) {
			comboBoxArbitre.setSelectedItem(arbitre);
		}
		comboBoxArbitre.setBounds(114, 328, 128, 22);
		contentPane.add(comboBoxArbitre);

	}

	private void setupFormHeure() {
		JLabel lblNewLabel_1_2_2 = new JLabel("Heure");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(272, 142, 52, 14);
		contentPane.add(lblNewLabel_1_2_2);

		comboBoxHeure = new JComboBox<TrancheHoraire>();
		comboBoxHeure.setModel(new DefaultComboBoxModel<TrancheHoraire>(TrancheHoraire.values()));
		if (match.getCreneau().getTranche() != null) {
			comboBoxHeure.setSelectedItem(match.getCreneau().getTranche());
		}
		comboBoxHeure.setBounds(341, 140, 128, 22);
		contentPane.add(comboBoxHeure);

	}

	private void setupFormJour() {
		JLabel lblNewLabel_1_2_1 = new JLabel("Jour");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(45, 142, 46, 14);
		contentPane.add(lblNewLabel_1_2_1);

		comboBoxJour = new JComboBox<Jour>();
		comboBoxJour.setModel(new DefaultComboBoxModel<Jour>(Jour.values()));
		if (match.getCreneau().getJour() != null) {
			comboBoxJour.setSelectedItem(match.getCreneau().getJour());
		}
		comboBoxJour.setBounds(114, 140, 128, 22);
		contentPane.add(comboBoxJour);
	}

	// ---------------------------------------------------------------------

	protected boolean verifierDonnees() {
		/*
		 * Vérification à effectuer sur les données
		 * 
		 * - Nombre de matchs déjà juger par un arbitre de chaise : 4 au maximum (2
		 * simples et 2 doubles) V - Arbitre pas déjà occupé dans un autre match V -
		 * Nationalité de l'arbitre =!= nationalité des joueurs V - Joueur pas déjà
		 * occupé dans un autre match d'un des tournois V - Disponibilité du court V -
		 * Un joueur ne doit pas jouer plusieurs matchs du meme tour d'un tournoi V
		 */
		String message;
		if (!verifierNombreMatchArbitre()) {
			message = "Un arbitre ne peut pas juger plus de 4 matchs (2 simples et 2 doubles)";
		} else if (!verifierOccupationArbitre()) {
			message = "L'arbitre ne peut juger qu'un match à la fois";
		} else if (!verifierDispoCourt()) {
			message = "Le court ne doit pas déjà être occupé";
		} else if (!verifierNationalites()) {
			message = "L'arbitre doit etre de nationalité differente des joueurs";
		} else if (!verifierOccupationJoueur()) {
			message = "Les joueurs ne doivent pas déjà être occupés sur un autre match";
		} else if (!verifierJoueurs()) {
			message = "Les deux joueurs doivent être différents";
		} else if (!verifierJoueurTour()) {
			message = "Un joueur ne peut pas jouer plusieurs matchs du même tour";
		} else {
			System.out.println("On peut tout mettre dans la bd");
			return true;
		}
		JOptionPane.showMessageDialog(this, message, "Erreur de planning", JOptionPane.ERROR_MESSAGE);
		return false;
	}

	protected void persisterDonnees() {
		/*
		 * Mise à jour des données dans la bd
		 * 
		 * - update le match avec jour/heure/court V - enlever les joueurs qui jouaient
		 * le match V - ajouter les nouveaux joueurs V - enlever l'arbitre qui jugeait
		 * le match V - ajouter le nouvel arbitre V - attribuer automatiquement les
		 * arbitres de lignes et equipes de ramasseurs de balless
		 * 
		 */

		matchDAO.updateMatch(match);
		matchDAO.enleverJoueurs(match);
		persiterJoueurs();
		matchDAO.enleverArbitre(match);
		matchDAO.ajouterArbitre(match, arbitre);
		matchDAO.ajouterArbitresLigne(match);
		matchDAO.enleverRamasseurs(match);
		matchDAO.ajouterRamasseurs(match);
	}

	protected void persiterJoueurs() {
		if (joueur1 != null) {
			matchDAO.ajouterJoueur(match, joueur1);
		}
		if (joueur2 != null) {
			matchDAO.ajouterJoueur(match, joueur2);
		}
	}

	// renvoie true si l'arbitre peut juger le match
	private boolean verifierNombreMatchArbitre() {
		int[] nombreMatch = arbitreDAO.getNombreMatchArbitre(arbitre);
		return nombreMatch[0] < 2 && nombreMatch[1] < 2;
	}

	protected boolean verifierNationalites() {
		boolean isOk = true;
		if (joueur1 != null) {
			isOk = !arbitre.getNationalite().toLowerCase().equals(joueur1.getNationalite().toLowerCase());
		}
		if (joueur2 != null) {
			isOk = isOk && !arbitre.getNationalite().toLowerCase().equals(joueur2.getNationalite().toLowerCase());
		}
		return isOk;
	}

	private boolean verifierOccupationArbitre() {
		return arbitreDAO.checkArbitreDispo(arbitre, match.getCreneau(), match);
	}

	protected boolean verifierOccupationJoueur() {
		boolean isOk = true;
		if (joueur1 != null) {
			isOk = joueurDAO.checkJoueurDispo(joueur1, match.getCreneau(), match);
		}
		if (joueur2 != null) {
			isOk = isOk && joueurDAO.checkJoueurDispo(joueur2, match.getCreneau(), match);
		}
		return isOk;
	}

	protected boolean verifierJoueurs() {
		if (joueur1 == null || joueur2 == null) {
			return true;
		}
		return !joueur1.equals(joueur2);
	}

	private boolean verifierDispoCourt() {
		return creneauDAO.checkDispoCourt(match.getCreneau(), match.getMatchId());
	}

	protected boolean verifierJoueurTour() {
		List<Match> listMatchJoueur;
		if (joueur1 != null) {
			listMatchJoueur = matchDAO.getByJoueur(joueur1);
			for (Match match : listMatchJoueur) {
				if (match.getTypeTournoiId() == this.match.getTypeTournoiId() && matchDAO.isPremierTour(match)
						&& match.getMatchId() != this.match.getMatchId()) {
					return false;
				}
			}
		}
		if (joueur2 != null) {
			listMatchJoueur = matchDAO.getByJoueur(joueur2);
			for (Match match : listMatchJoueur) {
				if (match.getTypeTournoiId() == this.match.getTypeTournoiId() && matchDAO.isPremierTour(match)
						&& match.getMatchId() != this.match.getMatchId()) {
					return false;
				}
			}
		}
		return true;
	}
}
