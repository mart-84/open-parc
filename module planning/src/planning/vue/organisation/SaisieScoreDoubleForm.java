package planning.vue.organisation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import planning.dao.interfacedao.IJoueurDAO;
import planning.dao.interfacedao.IMatchDAO;
import planning.metier.Equipe;
import planning.metier.Joueur;
import planning.metier.Match;

public class SaisieScoreDoubleForm extends SaisieScoreForm {

	private Equipe equipe1;
	private Equipe equipe2;
	private JLabel joueur1Label;
	private JLabel joueur2Label;

	public SaisieScoreDoubleForm(Match match, Joueur joueur1, Joueur joueur2, IMatchDAO matchDAO, IJoueurDAO joueurDAO,
			FormulaireInfosMatch frame, PlanningOrga mainFrame) {
		super(match, joueur1, joueur2, matchDAO, joueurDAO, frame, mainFrame);
	}

	public SaisieScoreDoubleForm(Match match, Equipe equipe1, Equipe equipe2, IMatchDAO matchDAO, IJoueurDAO joueurDAO,
			FormulaireMatchDoubleAvecJoueurJFrame frame, PlanningOrga mainFrame) {
		super(match, null, null, matchDAO, joueurDAO, frame, mainFrame);
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
		joueur1Label.setText(equipe1.toString());
		joueur2Label.setText(equipe2.toString());
	}

	protected void createJoueurLabel() {
		joueur1Label = new JLabel(equipe1 + "");
		joueur1Label.setHorizontalAlignment(SwingConstants.RIGHT);
		joueur1Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		joueur1Label.setBounds(86, 144, 150, 17);
		contentPane.add(joueur1Label);

		joueur2Label = new JLabel(equipe2 + "");
		joueur2Label.setHorizontalAlignment(SwingConstants.LEFT);
		joueur2Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		joueur2Label.setBounds(270, 144, 150, 17);
		contentPane.add(joueur2Label);
	}

	@Override
	protected void addButtonValiderAction(JButton buttonValider) {
		buttonValider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int[] scores = { (int) scoreJ1M1.getValue(), (int) scoreJ2M1.getValue(), (int) scoreJ1M2.getValue(),
						(int) scoreJ2M2.getValue(), (int) scoreJ1M3.getValue(), (int) scoreJ2M3.getValue() };
				if (!checkValues(scores)) {
					JOptionPane.showMessageDialog(contentPane, "Les scores saisies ne sont pas valides",
							"Erreur de saisie", JOptionPane.ERROR_MESSAGE);
				} else {
					Equipe gagnant;
					if (isJ1Gagnant(scores)) {
						gagnant = equipe1;
					} else {
						gagnant = equipe2;
					}
					matchDAO.ajouterGagnant(match, gagnant);
					Match suivant = matchDAO.getMatchSuivant(match);
					if (suivant != null) {
						matchDAO.ajouterEquipe(suivant, gagnant);
					}

					mainFrame.updatePanel(mainFrame.getSelectTab());
					frame.dispose();
				}
			}

		});
	}

}
