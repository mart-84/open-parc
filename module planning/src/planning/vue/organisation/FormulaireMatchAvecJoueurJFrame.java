package planning.vue.organisation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import planning.metier.Arbitre;
import planning.metier.Court;
import planning.metier.Creneau;
import planning.metier.Joueur;
import planning.metier.Jour;
import planning.metier.Match;
import planning.metier.TrancheHoraire;
import planning.metier.TypeDeTournoi;

public class FormulaireMatchAvecJoueurJFrame extends FormulaireInfosMatch {

	private JComboBox<Joueur> comboBoxJ1;
	private JComboBox<Joueur> comboBoxJ2;
	
	public FormulaireMatchAvecJoueurJFrame(Match match, List<Joueur> joueursMatch, Arbitre arbitre, List<Joueur> listJoueurs, List<Arbitre> listArbitres, Connection connection, PlanningOrga mainFrame) {
		super(match, joueursMatch, arbitre, listJoueurs, listArbitres, connection, mainFrame);
	}

	@Override
	protected void setupFormJoueurData() {
		comboBoxJ1 = new JComboBox<Joueur>();
		comboBoxJ1.setModel(new DefaultComboBoxModel<Joueur>(listJoueurs.toArray(new Joueur[0])));
		if (joueur1 != null) {
			comboBoxJ1.setSelectedItem(joueur1);
		}
		comboBoxJ1.setBounds(114, 235, 128, 22);
		contentPane.add(comboBoxJ1);
		
		comboBoxJ2 = new JComboBox<Joueur>();
		comboBoxJ2.setModel(new DefaultComboBoxModel<Joueur>(listJoueurs.toArray(new Joueur[0])));
		if (joueur2 != null) {
			comboBoxJ2.setSelectedItem(joueur2);
		}
		comboBoxJ2.setBounds(341, 235, 128, 22);
		contentPane.add(comboBoxJ2);
	}

	@Override
	protected void setupValiderButton() {
		
		boutonValider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("\nPour le match " + match.getMatchId() + " du tournoi " + TypeDeTournoi.getById(match.getTypeTournoiId()) + ", il faut enregistrer les données suivantes");
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
				if (verifierDonnees()) {
					// si toutes les contraintes sont vérifiées
					persisterDonnees();
					mainFrame.updatePanel();
					dispose(); 
				}
			}
		});
	}
	


	
}
