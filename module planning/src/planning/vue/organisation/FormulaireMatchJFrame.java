package planning.vue.organisation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.JLabel;

import planning.metier.Arbitre;
import planning.metier.Court;
import planning.metier.Creneau;
import planning.metier.Joueur;
import planning.metier.Jour;
import planning.metier.Match;
import planning.metier.TrancheHoraire;

public class FormulaireMatchJFrame extends FormulaireInfosMatch {

	public FormulaireMatchJFrame(Match match, List<Joueur> joueursMatch, Arbitre arbitre, List<Joueur> listJoueurs,
			List<Arbitre> listArbitres, Connection connection, PlanningOrga mainFrame) {
		super(match, joueursMatch, arbitre, listJoueurs, listArbitres, connection, mainFrame);
	}

	@Override
	protected void setupFormJoueurData() {
		String label = "Joueur 1";
		if (joueur1 != null) {
			label = joueur1 + "";
		}
		JLabel labelJ1 = new JLabel(label);
		labelJ1.setBounds(114, 235, 128, 22);
		contentPane.add(labelJ1);

		label = "Joueur 2";
		if (joueur2 != null) {
			label = joueur2 + "";
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
}
