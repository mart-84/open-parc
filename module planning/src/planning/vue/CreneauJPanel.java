package planning.vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class CreneauJPanel extends JComponent {

	/**
	 * Create the panel.
	 */
	public CreneauJPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("10h-12h");
		lblNewLabel.setBounds(75, 58, 83, 28);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Court annexe 2");
		btnNewButton.setBounds(349, 58, 133, 42);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Court annexe 1");
		btnNewButton_1.setBounds(349, 8, 133, 42);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Court annexe 3");
		btnNewButton_2.setBounds(349, 108, 133, 42);
		add(btnNewButton_2);

	}
}
