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


public class ArbreTournoi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArbreTournoi frame = new ArbreTournoi();
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
	public ArbreTournoi() {
		setTitle("R\u00E9server un entrainement");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("R\u00E9server un entrainement");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(219, 21, 534, 47);
		contentPane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 109, 956, 523);
		contentPane.add(tabbedPane);
		
		JPanel dimanche1 = new JPanel();
		tabbedPane.addTab("Dimanche", null, dimanche1, null);
		dimanche1.setLayout(new BorderLayout(0, 0));
		
		JPanel lundi = new JPanel();
		tabbedPane.addTab("Lundi", null, lundi, null);
		lundi.setLayout(null);
		
		CreneauJPanel creneauJPanel = new CreneauJPanel();
		creneauJPanel.setBounds(219, 224, 502, 161);
		lundi.add(creneauJPanel);
		
		CreneauJPanel creneauJPanel_1 = new CreneauJPanel();
		creneauJPanel_1.setBounds(219, 29, 502, 161);
		lundi.add(creneauJPanel_1);
		
		JPanel mardi = new JPanel();
		tabbedPane.addTab("Mardi", null, mardi, null);
		
		JPanel mercredi = new JPanel();
		tabbedPane.addTab("Mercredi", null, mercredi, null);
		
		JPanel jeudi = new JPanel();
		tabbedPane.addTab("Jeudi", null, jeudi, null);
		
		JPanel vendredi = new JPanel();
		tabbedPane.addTab("Vendredi", null, vendredi, null);
		
		JPanel samedi = new JPanel();
		tabbedPane.addTab("Samedi", null, samedi, null);
		
		JPanel dimanche2 = new JPanel();
		tabbedPane.addTab("Dimanche", null, dimanche2, null);
	}
}
