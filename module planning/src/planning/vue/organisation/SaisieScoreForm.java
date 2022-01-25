package planning.vue.organisation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;

import planning.dao.interfacedao.IJoueurDAO;
import planning.dao.interfacedao.IMatchDAO;
import planning.metier.Joueur;
import planning.metier.Match;

public class SaisieScoreForm extends JPanel {

	protected JPanel contentPane = new JPanel();
	protected Match match;
	protected Joueur joueur1;
	protected Joueur joueur2;
	protected IMatchDAO matchDAO;
	protected IJoueurDAO joueurDAO;
	protected FormulaireInfosMatch frame;
	protected PlanningOrga mainFrame;
	protected JSpinner scoreJ1M1;
	protected JSpinner scoreJ1M2;
	protected JSpinner scoreJ1M3;
	protected JSpinner scoreJ2M1;
	protected JSpinner scoreJ2M2;
	protected JSpinner scoreJ2M3;

	public SaisieScoreForm(Match match, Joueur joueur1, Joueur joueur2, IMatchDAO matchDAO, IJoueurDAO joueurDAO,
			FormulaireInfosMatch frame, PlanningOrga mainFrame) {
		super();
		this.frame = frame;
		this.mainFrame = mainFrame;
		this.joueurDAO = joueurDAO;
		this.match = match;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.matchDAO = matchDAO;
		createPanel();
	}

	private void createPanel() {
		setLayout(null);
		contentPane.setLayout(null);
		contentPane.setSize(490, 439);

		JLabel lblNewLabel = new JLabel("Match " + match.getMatchId());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(-25, 11, 551, 49);
		contentPane.add(lblNewLabel);

		createJoueurLabel();
		
		scoreJ1M1 = new JSpinner();
		scoreJ1M1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scoreJ1M1.setBounds(197, 218, 43, 20);
		contentPane.add(scoreJ1M1);

		scoreJ1M2 = new JSpinner();
		scoreJ1M2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scoreJ1M2.setBounds(197, 240, 43, 20);
		contentPane.add(scoreJ1M2);

		scoreJ1M3 = new JSpinner();
		scoreJ1M3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scoreJ1M3.setBounds(197, 262, 43, 20);
		contentPane.add(scoreJ1M3);

		scoreJ2M1 = new JSpinner();
		scoreJ2M1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scoreJ2M1.setBounds(267, 218, 43, 20);
		contentPane.add(scoreJ2M1);

		scoreJ2M2 = new JSpinner();
		scoreJ2M2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scoreJ2M2.setBounds(267, 240, 43, 20);
		contentPane.add(scoreJ2M2);

		scoreJ2M3 = new JSpinner();
		scoreJ2M3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scoreJ2M3.setBounds(267, 262, 43, 20);
		contentPane.add(scoreJ2M3);

		addLabelManche();

		JButton buttonValider = new JButton("Valider le score");
		buttonValider.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonValider.setBounds(176, 363, 150, 35);
		addButtonValiderAction(buttonValider);
		contentPane.add(buttonValider);
		add(contentPane);

	}

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
					Joueur gagnant, perdant;
					if (isJ1Gagnant(scores)) {
						gagnant = joueur1;
						perdant = joueur2;
					} else {
						gagnant = joueur2;
						perdant = joueur1;
					}
					matchDAO.ajouterGagnant(match, gagnant);
					Match suivant = matchDAO.getMatchSuivant(match);
					if (suivant != null) {
						matchDAO.ajouterJoueur(suivant, gagnant);
					}

					if (match.isQualif()) {
						// changer les statuts des joueurs
						joueurDAO.eliminerQualif(perdant);
						int idmatch = match.getMatchId();
						if (idmatch == 3 || idmatch == 6 || idmatch == 9 || idmatch == 12) {
							joueurDAO.qualifier(gagnant);
						}
					}

					mainFrame.updatePanel(mainFrame.getSelectTab());
					frame.dispose();
				}
			}

		});
	}

	protected void createJoueurLabel() {
		JLabel joueur1Label = new JLabel(joueur1 + "");
		joueur1Label.setHorizontalAlignment(SwingConstants.RIGHT);
		joueur1Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		joueur1Label.setBounds(86, 144, 150, 17);
		contentPane.add(joueur1Label);

		JLabel joueur2Label = new JLabel(joueur2 + "");
		joueur2Label.setHorizontalAlignment(SwingConstants.LEFT);
		joueur2Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		joueur2Label.setBounds(270, 144, 150, 17);
		contentPane.add(joueur2Label);
	}

	private void addLabelManche() {
		JLabel lblNewLabel_2 = new JLabel("Manche 1");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(112, 219, 84, 18);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Manche 2");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(112, 241, 84, 18);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Manche 3");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(112, 263, 84, 18);
		contentPane.add(lblNewLabel_2_2);
	}

	protected boolean checkValues(int[] scores) {
		for (int score : scores) {
			if (score > 7 || score < 0)
				return false;
		}

		// Manche 1
		int scoreJ1 = 0;
		if (checkManche(scores[0], scores[1])) {
			if (isJ1Gagnant(scores[0], scores[1]))
				scoreJ1++;
		} else {
			return false;
		}

		// Manche 2
		if (checkManche(scores[2], scores[3])) {
			if (isJ1Gagnant(scores[2], scores[3]))
				scoreJ1++;
		} else {
			return false;
		}

		// si un joueur a gagné les 2 premieres manches, pas besoin de vérifier la
		// derniere
		if (scoreJ1 == 2 || scoreJ1 == 0) {
			return true;
		}

		return checkManche(scores[4], scores[5]);
	}

	private boolean checkManche(int scoreJ1, int scoreJ2) {
		if (scoreJ1 == 7 && scoreJ2 == 5)
			return true;
		if (scoreJ1 == 5 && scoreJ2 == 7)
			return true;
		if (scoreJ1 == 6 && scoreJ2 <= 4)
			return true;
		if (scoreJ1 <= 4 && scoreJ2 == 6)
			return true;
		return false;
	}

	protected boolean isJ1Gagnant(int[] scores) {
		int scoreJ1 = 0;
		if (isJ1Gagnant(scores[0], scores[1]))
			scoreJ1++;
		if (isJ1Gagnant(scores[2], scores[3]))
			scoreJ1++;
		if (isJ1Gagnant(scores[4], scores[5]))
			scoreJ1++;

		return scoreJ1 >= 2;
	}

	private boolean isJ1Gagnant(int scoreJ1, int scoreJ2) {
		return (scoreJ1 == 7 && scoreJ2 == 5) || (scoreJ1 == 6 && scoreJ2 <= 4);
	}
}
