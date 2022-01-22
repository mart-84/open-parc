package planning.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MatchDoubleComponent extends MatchComponent {

	/**
	 * Create the panel.
	 */
	public MatchDoubleComponent(Connection connection) {
		super(connection);
		createPanel();
	}
	
	public void createPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel);
		
		JPanel joueursPanel = new JPanel();
		panel.add(joueursPanel);
		joueursPanel.setLayout(new BoxLayout(joueursPanel, BoxLayout.Y_AXIS));
		
		JLabel Joueur1Label = new JLabel("Joueur 1 - Joueur 2");
		Joueur1Label.setAlignmentX(Component.CENTER_ALIGNMENT);
		Joueur1Label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		joueursPanel.add(Joueur1Label);
		
		JLabel Joueur2Label = new JLabel("Joueur 3 - Joueur 4");
		Joueur2Label.setAlignmentX(Component.CENTER_ALIGNMENT);
		Joueur2Label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		joueursPanel.add(Joueur2Label);
		
		JPanel datePanel = new JPanel();
		panel.add(datePanel);
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
