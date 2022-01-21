package planning.vue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import planning.metier.Arbitre;
import planning.metier.Court;
import planning.metier.Joueur;
import planning.metier.Jour;
import planning.metier.Match;
import planning.metier.TrancheHoraire;

public class FormulaireMatchJFrame extends JFrame {

	private JPanel contentPane;
	private Match match;
	private Arbitre arbitre;
	private Joueur joueur1 = null, joueur2 = null;
	private List<Arbitre> listArbitres;
	private List<Joueur> listJoueurs;
	
	/**
	 * Create the frame.
	 */
	public FormulaireMatchJFrame(Match match, List<Joueur> joueursMatch, Arbitre arbitre, List<Joueur> listJoueurs, List<Arbitre> listArbitres) {
		if (joueursMatch.size() == 2) {
			joueur1 = joueursMatch.get(0);
			joueur2 = joueursMatch.get(1);
		}
		this.match = match;
		this.arbitre = arbitre;
		this.listArbitres = listArbitres;
		this.listJoueurs = listJoueurs;
		
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
		
		JComboBox<Jour> comboBoxJour = new JComboBox<Jour>();
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
		
		JComboBox<TrancheHoraire> comboBoxHeure = new JComboBox<TrancheHoraire>();
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
		
		JComboBox<Court> comboBoxCourt = new JComboBox<Court>();
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
		
		JComboBox<Arbitre> comboBoxArbitre = new JComboBox<Arbitre>();
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
		
		JComboBox<Joueur> comboBoxJ1 = new JComboBox<Joueur>();
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
		
		JComboBox<Joueur> comboBoxJ2 = new JComboBox<Joueur>();
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
				System.out.println("Faut tout ajouter");
			}
		});
		
		boutonValider.setBounds(300, 483, 126, 28);
		contentPane.add(boutonValider);
	}
}
