package planning.vue.organisation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

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

public class FormulaireMatchDoubleJFrame extends FormulaireMatchJFrame {

	private Equipe equipe1;
	private Equipe equipe2;
	private IEquipeDAO equipeDAO;

	public FormulaireMatchDoubleJFrame(Match match, List<Joueur> joueursMatch, Arbitre arbitre,
			List<Joueur> listJoueurs, List<Arbitre> listArbitres, Connection connection, PlanningOrga mainFrame) {
		super(match, joueursMatch, arbitre, listJoueurs, listArbitres, connection, mainFrame);
	}

	@Override
	protected void setupOthers() {
		equipeDAO = new EquipeDaoSql();
		equipeDAO.setConnection(connection);
		List<Equipe> listEquipeMatch = equipeDAO.getByMatch(match);
		if (listEquipeMatch.size() > 0) {
			equipe1 = listEquipeMatch.get(0);
		}
		if (listEquipeMatch.size() > 1) {
			equipe2 = listEquipeMatch.get(1);
		}
	}

	@Override
	protected void setupFormJoueurLabel() {
		JLabel lblNewLabel_1_2 = new JLabel("Equipe 1");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(21, 237, 70, 18);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Equipe 2");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(254, 237, 64, 18);
		contentPane.add(lblNewLabel_1_3);
	}

	@Override
	protected void setupFormJoueurData() {
		String label = "Equipe 1";
		if (equipe1 != null) {
			label = equipe1 + "";
		}
		JLabel labelJ1 = new JLabel(label);
		labelJ1.setBounds(114, 235, 128, 22);
		contentPane.add(labelJ1);

		label = "Equipe 2";
		if (equipe2 != null) {
			label = equipe2 + "";
		}
		JLabel labelJ2 = new JLabel(label);
		labelJ2.setBounds(341, 235, 128, 22);
		contentPane.add(labelJ2);
	}

	@Override
	protected void setupValiderButton() {
		boutonValider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Jour jour = (Jour) comboBoxJour.getSelectedItem();
				TrancheHoraire tranche = (TrancheHoraire) comboBoxHeure.getSelectedItem();
				Court court = (Court) comboBoxCourt.getSelectedItem();
				match = new Match(match.getMatchId(), match.getTypeTournoiId(), new Creneau(jour, tranche, court));
				arbitre = (Arbitre) comboBoxArbitre.getSelectedItem();
				if (verifierDonnees()) {
					// si toutes les contraintes sont vérifiées
					persisterDonnees();
					mainFrame.updatePanel(mainFrame.getSelectTab());
					dispose();
				}
			}
		});
	}

	protected boolean verifierNationalites() {
		boolean isOk = true;
		if (equipe1 != null) {
			isOk = !arbitre.getNationalite().toLowerCase().equals(equipe1.getJoueur1().getNationalite().toLowerCase())
				&& !arbitre.getNationalite().toLowerCase().equals(equipe1.getJoueur2().getNationalite().toLowerCase());
		}
		if (equipe2 != null) {
			isOk =  !arbitre.getNationalite().toLowerCase().equals(equipe2.getJoueur1().getNationalite().toLowerCase())
			&& !arbitre.getNationalite().toLowerCase().equals(equipe2.getJoueur2().getNationalite().toLowerCase());
		}
		return isOk;
	}

	protected boolean verifierOccupationJoueur() {
		boolean isOk = true;
		if (equipe1 != null) {
			isOk = joueurDAO.checkJoueurDispo(equipe1.getJoueur1(), match.getCreneau(), match)
					&& joueurDAO.checkJoueurDispo(equipe1.getJoueur2(), match.getCreneau(), match); 
		}
		if (equipe2 != null) {
			isOk = isOk && joueurDAO.checkJoueurDispo(equipe2.getJoueur1(), match.getCreneau(), match)
					&& joueurDAO.checkJoueurDispo(equipe2.getJoueur2(), match.getCreneau(), match);
		}
		return isOk;
	}

	protected boolean verifierJoueurs() {
		if (equipe1 == null || equipe2 == null) {
			return true;
		}
		return !equipe1.equals(equipe2);
	}

	protected boolean verifierJoueurTour() {
		List<Match> listMatchEquipe;
		if (equipe1 != null) {
			listMatchEquipe = matchDAO.getByEquipe(equipe1);
			for (Match match : listMatchEquipe) {
				if (match.getTypeTournoiId() == this.match.getTypeTournoiId() && matchDAO.isPremierTour(match)
						&& match.getMatchId() != this.match.getMatchId()) {
					return false;
				}
			}
		}
		if (equipe1 != null) {
			listMatchEquipe = matchDAO.getByEquipe(equipe2);
			for (Match match : listMatchEquipe) {
				if (match.getTypeTournoiId() == this.match.getTypeTournoiId() && matchDAO.isPremierTour(match)
						&& match.getMatchId() != this.match.getMatchId()) {
					return false;
				}
			}
		}
		return true;
	}

	protected void persiterJoueurs() {
		if (equipe1 != null) {
			matchDAO.ajouterEquipe(match, equipe1);
		}
		if (equipe2 != null) {
			matchDAO.ajouterEquipe(match, equipe2);
		}
	}
}
