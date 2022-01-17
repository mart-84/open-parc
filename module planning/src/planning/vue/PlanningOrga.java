package planning.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;

public class PlanningOrga extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanningOrga frame = new PlanningOrga();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PlanningOrga() {
		setTitle("Planning - Open Parc Lyon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1414, 879);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel("Organisation des matchs");
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.PLAIN, 40));
		contentPane.add(title);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel qualificationPanel = new JPanel();
		tabbedPane.addTab("Tournoi Qualification", null, qualificationPanel, null);
		qualificationPanel.setLayout(null);
		
		MatchComponent matchComponent = new MatchComponent();
		matchComponent.setBounds(278, 187, 98, 42);
		qualificationPanel.add(matchComponent);
		
		MatchComponent matchComponent_1 = new MatchComponent();
		matchComponent_1.setBounds(278, 265, 98, 42);
		qualificationPanel.add(matchComponent_1);
		
		MatchComponent matchComponent_2 = new MatchComponent();
		matchComponent_2.setBounds(487, 226, 98, 42);
		qualificationPanel.add(matchComponent_2);
		
		MatchComponent matchComponent_3 = new MatchComponent();
		matchComponent_3.setBounds(278, 369, 98, 42);
		qualificationPanel.add(matchComponent_3);
		
		MatchComponent matchComponent_1_1 = new MatchComponent();
		matchComponent_1_1.setBounds(278, 447, 98, 42);
		qualificationPanel.add(matchComponent_1_1);
		
		MatchComponent matchComponent_2_1 = new MatchComponent();
		matchComponent_2_1.setBounds(487, 408, 98, 42);
		qualificationPanel.add(matchComponent_2_1);
		
		MatchComponent matchComponent_4 = new MatchComponent();
		matchComponent_4.setBounds(749, 191, 98, 42);
		qualificationPanel.add(matchComponent_4);
		
		MatchComponent matchComponent_1_2 = new MatchComponent();
		matchComponent_1_2.setBounds(749, 269, 98, 42);
		qualificationPanel.add(matchComponent_1_2);
		
		MatchComponent matchComponent_2_2 = new MatchComponent();
		matchComponent_2_2.setBounds(958, 230, 98, 42);
		qualificationPanel.add(matchComponent_2_2);
		
		MatchComponent matchComponent_5 = new MatchComponent();
		matchComponent_5.setBounds(749, 369, 98, 42);
		qualificationPanel.add(matchComponent_5);
		
		MatchComponent matchComponent_1_3 = new MatchComponent();
		matchComponent_1_3.setBounds(749, 447, 98, 42);
		qualificationPanel.add(matchComponent_1_3);
		
		MatchComponent matchComponent_2_3 = new MatchComponent();
		matchComponent_2_3.setBounds(958, 408, 98, 42);
		qualificationPanel.add(matchComponent_2_3);
		
		JPanel tournoiSimplePanel = new JPanel();
		tabbedPane.addTab("Tournoi Simple", null, tournoiSimplePanel, null);
		tournoiSimplePanel.setLayout(null);
		
		MatchComponent matchComponent_6 = new MatchComponent();
		matchComponent_6.setBounds(38, 30, 98, 42);
		tournoiSimplePanel.add(matchComponent_6);
		
		MatchComponent matchComponent_6_1 = new MatchComponent();
		matchComponent_6_1.setBounds(38, 121, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_1);
		
		MatchComponent matchComponent_6_2 = new MatchComponent();
		matchComponent_6_2.setBounds(38, 202, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_2);
		
		MatchComponent matchComponent_6_3 = new MatchComponent();
		matchComponent_6_3.setBounds(38, 293, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_3);
		
		MatchComponent matchComponent_6_4 = new MatchComponent();
		matchComponent_6_4.setBounds(38, 385, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_4);
		
		MatchComponent matchComponent_6_5 = new MatchComponent();
		matchComponent_6_5.setBounds(38, 475, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_5);
		
		MatchComponent matchComponent_6_6 = new MatchComponent();
		matchComponent_6_6.setBounds(38, 571, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_6);
		
		MatchComponent matchComponent_6_7 = new MatchComponent();
		matchComponent_6_7.setBounds(38, 661, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_7);
		
		MatchComponent matchComponent_6_8 = new MatchComponent();
		matchComponent_6_8.setBounds(198, 77, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_8);
		
		MatchComponent matchComponent_6_1_1 = new MatchComponent();
		matchComponent_6_1_1.setBounds(198, 249, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_1_1);
		
		MatchComponent matchComponent_6_2_1 = new MatchComponent();
		matchComponent_6_2_1.setBounds(198, 426, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_2_1);
		
		MatchComponent matchComponent_6_3_1 = new MatchComponent();
		matchComponent_6_3_1.setBounds(198, 613, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_3_1);
		
		MatchComponent matchComponent_6_2_1_1 = new MatchComponent();
		matchComponent_6_2_1_1.setBounds(354, 513, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_2_1_1);
		
		MatchComponent matchComponent_6_2_1_2 = new MatchComponent();
		matchComponent_6_2_1_2.setBounds(354, 170, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_2_1_2);
		
		MatchComponent matchComponent_6_2_1_3 = new MatchComponent();
		matchComponent_6_2_1_3.setBounds(490, 336, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_2_1_3);
		
		MatchComponent matchComponent_6_9 = new MatchComponent();
		matchComponent_6_9.setBounds(1231, 30, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_9);
		
		MatchComponent matchComponent_6_1_2 = new MatchComponent();
		matchComponent_6_1_2.setBounds(1231, 121, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_1_2);
		
		MatchComponent matchComponent_6_2_2 = new MatchComponent();
		matchComponent_6_2_2.setBounds(1231, 202, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_2_2);
		
		MatchComponent matchComponent_6_3_2 = new MatchComponent();
		matchComponent_6_3_2.setBounds(1231, 293, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_3_2);
		
		MatchComponent matchComponent_6_4_1 = new MatchComponent();
		matchComponent_6_4_1.setBounds(1231, 385, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_4_1);
		
		MatchComponent matchComponent_6_5_1 = new MatchComponent();
		matchComponent_6_5_1.setBounds(1231, 475, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_5_1);
		
		MatchComponent matchComponent_6_6_1 = new MatchComponent();
		matchComponent_6_6_1.setBounds(1231, 571, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_6_1);
		
		MatchComponent matchComponent_6_7_1 = new MatchComponent();
		matchComponent_6_7_1.setBounds(1231, 661, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_7_1);
		
		MatchComponent matchComponent_6_8_1 = new MatchComponent();
		matchComponent_6_8_1.setBounds(1072, 77, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_8_1);
		
		MatchComponent matchComponent_6_1_1_1 = new MatchComponent();
		matchComponent_6_1_1_1.setBounds(1072, 249, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_1_1_1);
		
		MatchComponent matchComponent_6_2_1_4 = new MatchComponent();
		matchComponent_6_2_1_4.setBounds(1072, 426, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_2_1_4);
		
		MatchComponent matchComponent_6_3_1_1 = new MatchComponent();
		matchComponent_6_3_1_1.setBounds(1072, 613, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_3_1_1);
		
		MatchComponent matchComponent_6_2_1_1_1 = new MatchComponent();
		matchComponent_6_2_1_1_1.setBounds(897, 513, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_2_1_1_1);
		
		MatchComponent matchComponent_6_2_1_2_1 = new MatchComponent();
		matchComponent_6_2_1_2_1.setBounds(897, 170, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_2_1_2_1);
		
		MatchComponent matchComponent_6_2_1_3_1 = new MatchComponent();
		matchComponent_6_2_1_3_1.setBounds(765, 336, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_2_1_3_1);
		
		MatchComponent matchComponent_6_2_1_3_2 = new MatchComponent();
		matchComponent_6_2_1_3_2.setBounds(623, 202, 98, 42);
		tournoiSimplePanel.add(matchComponent_6_2_1_3_2);
		 
		JPanel tournoiDoublePanel = new JPanel();
		tabbedPane.addTab("Tournoi Double", null, tournoiDoublePanel, null);
		tournoiDoublePanel.setLayout(null);
		
		MatchDoubleComponent matchDoubleComponent = new MatchDoubleComponent();
		matchDoubleComponent.setBounds(81, 87, 158, 42);
		tournoiDoublePanel.add(matchDoubleComponent);
		
		MatchDoubleComponent matchDoubleComponent_1 = new MatchDoubleComponent();
		matchDoubleComponent_1.setBounds(81, 220, 158, 42);
		tournoiDoublePanel.add(matchDoubleComponent_1);
		
		MatchDoubleComponent matchDoubleComponent_1_1 = new MatchDoubleComponent();
		matchDoubleComponent_1_1.setBounds(311, 153, 158, 42);
		tournoiDoublePanel.add(matchDoubleComponent_1_1);
		
		MatchDoubleComponent matchDoubleComponent_2 = new MatchDoubleComponent();
		matchDoubleComponent_2.setBounds(81, 378, 158, 42);
		tournoiDoublePanel.add(matchDoubleComponent_2);
		
		MatchDoubleComponent matchDoubleComponent_1_2 = new MatchDoubleComponent();
		matchDoubleComponent_1_2.setBounds(81, 511, 158, 42);
		tournoiDoublePanel.add(matchDoubleComponent_1_2);
		
		MatchDoubleComponent matchDoubleComponent_1_1_1 = new MatchDoubleComponent();
		matchDoubleComponent_1_1_1.setBounds(311, 444, 158, 42);
		tournoiDoublePanel.add(matchDoubleComponent_1_1_1);
		
		MatchDoubleComponent matchDoubleComponent_3 = new MatchDoubleComponent();
		matchDoubleComponent_3.setBounds(1115, 87, 158, 42);
		tournoiDoublePanel.add(matchDoubleComponent_3);
		
		MatchDoubleComponent matchDoubleComponent_1_3 = new MatchDoubleComponent();
		matchDoubleComponent_1_3.setBounds(1115, 220, 158, 42);
		tournoiDoublePanel.add(matchDoubleComponent_1_3);
		
		MatchDoubleComponent matchDoubleComponent_2_1 = new MatchDoubleComponent();
		matchDoubleComponent_2_1.setBounds(1115, 378, 158, 42);
		tournoiDoublePanel.add(matchDoubleComponent_2_1);
		
		MatchDoubleComponent matchDoubleComponent_1_2_1 = new MatchDoubleComponent();
		matchDoubleComponent_1_2_1.setBounds(1115, 511, 158, 42);
		tournoiDoublePanel.add(matchDoubleComponent_1_2_1);
		
		MatchDoubleComponent matchDoubleComponent_1_1_1_1 = new MatchDoubleComponent();
		matchDoubleComponent_1_1_1_1.setBounds(868, 444, 158, 42);
		tournoiDoublePanel.add(matchDoubleComponent_1_1_1_1);
		
		MatchDoubleComponent matchDoubleComponent_1_1_2 = new MatchDoubleComponent();
		matchDoubleComponent_1_1_2.setBounds(868, 153, 158, 42);
		tournoiDoublePanel.add(matchDoubleComponent_1_1_2);
		
		MatchDoubleComponent matchDoubleComponent_1_1_3 = new MatchDoubleComponent();
		matchDoubleComponent_1_1_3.setBounds(460, 298, 158, 42);
		tournoiDoublePanel.add(matchDoubleComponent_1_1_3);
		
		MatchDoubleComponent matchDoubleComponent_1_1_4 = new MatchDoubleComponent();
		matchDoubleComponent_1_1_4.setBounds(707, 298, 158, 42);
		tournoiDoublePanel.add(matchDoubleComponent_1_1_4);
		
		MatchDoubleComponent matchDoubleComponent_1_1_5 = new MatchDoubleComponent();
		matchDoubleComponent_1_1_5.setBounds(582, 184, 158, 42);
		tournoiDoublePanel.add(matchDoubleComponent_1_1_5);
	}
}
