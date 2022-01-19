package planning.vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MatchComponent extends JPanel {

	private int idMatch;
	
	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}

	/**
	 * Create the panel.
	 */
	public MatchComponent() {
		createPanel();
	}
	
	protected void createPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setMinimumSize(new Dimension(140, 45));
		setMaximumSize(new Dimension(140, 45));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel joueursPanel = new JPanel();
		add(joueursPanel);
		joueursPanel.setLayout(new BoxLayout(joueursPanel, BoxLayout.Y_AXIS));
		
		JLabel Joueur1Label = new JLabel("Joueur 1");
		Joueur1Label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		joueursPanel.add(Joueur1Label);
		
		JLabel Joueur2Label = new JLabel("Joueur 2");
		Joueur2Label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		joueursPanel.add(Joueur2Label);
		
		JPanel datePanel = new JPanel();
		add(datePanel);
		datePanel.setLayout(new BoxLayout(datePanel, BoxLayout.Y_AXIS));
		
		JLabel dateLabel = new JLabel("14/04");
		dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		datePanel.add(dateLabel);
		
		JLabel heureLabel = new JLabel("10h");
		heureLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		heureLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		datePanel.add(heureLabel);
	}

}
