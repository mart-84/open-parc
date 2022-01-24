package planning.vue.organisation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import planning.dao.interfacedao.IEquipeDAO;
import planning.dao.sql.EquipeDaoSql;
import planning.metier.Arbitre;
import planning.metier.Court;
import planning.metier.Creneau;
import planning.metier.Equipe;
import planning.metier.Joueur;
import planning.metier.Jour;
import planning.metier.Match;
import planning.metier.TrancheHoraire;
import planning.metier.TypeDeTournoi;

public class FormulaireMatchDoubleAvecJoueurJFrame extends FormulaireMatchAvecJoueurJFrame {

	private JComboBox<Equipe> comboBoxE1;
	private JComboBox<Equipe> comboBoxE2;
	private Equipe equipe1;
	private Equipe equipe2;
	private List<Equipe> listEquipe;
	private IEquipeDAO equipeDAO;

	public FormulaireMatchDoubleAvecJoueurJFrame(Match match, List<Joueur> joueursMatch, Arbitre arbitre,
			List<Joueur> listJoueurs, List<Arbitre> listArbitres, Connection connection, PlanningOrga mainFrame) {
		super(match, joueursMatch, arbitre, listJoueurs, listArbitres, connection, mainFrame);
	}

	@Override
	protected void setupOthers() {
		equipeDAO = new EquipeDaoSql();
		equipeDAO.setConnection(connection);
		listEquipe = equipeDAO.getEquipes();
		List<Equipe> listEquipeMatch = equipeDAO.getByMatch(match);
		if (listEquipeMatch.size() == 2) {
			equipe1 = listEquipeMatch.get(0);
			equipe2 = listEquipeMatch.get(1);
		}
	}

	@Override
	protected void setupFormJoueurLabel() {
		JLabel lblNewLabel_1_2 = new JLabel("Equipe 1");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(21, 237, 70, 14);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Equipe 2");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(254, 237, 64, 14);
		contentPane.add(lblNewLabel_1_3);
	}

	@Override
	protected void setupFormJoueurData() {
		comboBoxE1 = new JComboBox<Equipe>();
		comboBoxE1.setModel(new DefaultComboBoxModel<Equipe>(listEquipe.toArray(new Equipe[0])));
		if (equipe1 != null) {
			comboBoxE1.setSelectedItem(equipe1);
		}
		comboBoxE1.setBounds(114, 235, 128, 22);
		contentPane.add(comboBoxE1);

		comboBoxE2 = new JComboBox<Equipe>();
		comboBoxE2.setModel(new DefaultComboBoxModel<Equipe>(listEquipe.toArray(new Equipe[0])));
		if (equipe2 != null) {
			comboBoxE2.setSelectedItem(equipe2);
		}
		comboBoxE2.setBounds(341, 235, 128, 22);
		contentPane.add(comboBoxE2);
	}

	@Override
	protected void setupValiderButton() {

		boutonValider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("\nPour le match " + match.getMatchId() + " du tournoi "
						+ TypeDeTournoi.getById(match.getTypeTournoiId())
						+ ", il faut enregistrer les données suivantes");
				System.out.println(comboBoxJour.getSelectedItem());
				System.out.println(comboBoxHeure.getSelectedItem());
				System.out.println(comboBoxCourt.getSelectedItem());
				System.out.println(comboBoxArbitre.getSelectedItem());
				System.out.println(comboBoxE1.getSelectedItem());
				System.out.println(comboBoxE2.getSelectedItem());

				Jour jour = (Jour) comboBoxJour.getSelectedItem();
				TrancheHoraire tranche = (TrancheHoraire) comboBoxHeure.getSelectedItem();
				Court court = (Court) comboBoxCourt.getSelectedItem();
				match = new Match(match.getMatchId(), match.getTypeTournoiId(), new Creneau(jour, tranche, court));
				arbitre = (Arbitre) comboBoxArbitre.getSelectedItem();
				equipe1 = (Equipe) comboBoxE1.getSelectedItem();
				equipe2 = (Equipe) comboBoxE2.getSelectedItem();
				if (verifierDonnees()) {
					// si toutes les contraintes sont vérifiées
					persisterDonnees();
					mainFrame.updatePanel();
					dispose();
				}
			}
		});
	}

	protected boolean verifierNationalites() {
		return !arbitre.getNationalite().toLowerCase().equals(equipe1.getJoueur1().getNationalite().toLowerCase())
				&& !arbitre.getNationalite().toLowerCase().equals(equipe1.getJoueur2().getNationalite().toLowerCase())
				&& !arbitre.getNationalite().toLowerCase().equals(equipe2.getJoueur1().getNationalite().toLowerCase())
				&& !arbitre.getNationalite().toLowerCase().equals(equipe2.getJoueur2().getNationalite().toLowerCase());
	}

	protected boolean verifierOccupationJoueur() {
		return joueurDAO.checkJoueurDispo(equipe1.getJoueur1(), match.getCreneau(), match)
				&& joueurDAO.checkJoueurDispo(equipe1.getJoueur2(), match.getCreneau(), match)
				&& joueurDAO.checkJoueurDispo(equipe2.getJoueur1(), match.getCreneau(), match)
				&& joueurDAO.checkJoueurDispo(equipe2.getJoueur2(), match.getCreneau(), match);
	}

	protected boolean verifierJoueurs() {
		return !equipe1.equals(equipe2);
	}

	protected boolean verifierJoueurTour() {
		List<Match> listMatchEquipe = matchDAO.getByEquipe(equipe1);
		for (Match match : listMatchEquipe) {
			if (match.getTypeTournoiId() == this.match.getTypeTournoiId() && matchDAO.isPremierTour(match)
					&& match.getMatchId() != this.match.getMatchId()) {
				return false;
			}
		}
		listMatchEquipe = matchDAO.getByEquipe(equipe2);
		for (Match match : listMatchEquipe) {
			if (match.getTypeTournoiId() == this.match.getTypeTournoiId() && matchDAO.isPremierTour(match)
					&& match.getMatchId() != this.match.getMatchId()) {
				return false;
			}
		}
		return true;
	}

	protected void persiterJoueurs() {
		matchDAO.ajouterEquipe(match, equipe1);
		matchDAO.ajouterEquipe(match, equipe2);
	}

}
