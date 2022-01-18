package planning.vue.reservation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mariadb.jdbc.MariaDbDataSource;

import planning.dao.mariadb.MariaDbDataSourceDao;
import planning.metier.Jour;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;

public class ReservationJoueurFrame extends JFrame {

	private JPanel contentPane;
	private static MariaDbDataSource dataSourceDAO;
	private static Connection connexionBD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dataSourceDAO = MariaDbDataSourceDao.getMariaDBDataSourceDAO();
					connexionBD = dataSourceDAO.getConnection();

					ReservationJoueurFrame frame = new ReservationJoueurFrame();
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
	public ReservationJoueurFrame() {
		this.createPanel();
	}

	private void createTitle() {
		setTitle("R\u00E9server un entrainement");
		JLabel title = new JLabel("R\u00E9server un entrainement");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.PLAIN, 40));
		title.setBounds(219, 21, 534, 47);
		contentPane.add(title);
	}
	
	public void updatePanel() {
		this.revalidate();
		this.repaint();
		this.createPanel();
		this.createTitle();
	}
	
	private void createPanel() {
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 682);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		createTitle();

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 109, 956, 523);
		contentPane.add(tabbedPane);

		for (Jour jour : Jour.values()) {
			JourJPanel panel = new JourJPanel(jour, connexionBD, this);
			tabbedPane.addTab(jour.getNom(), null, panel, null);
		}

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});
	}

	private void formWindowClosing(WindowEvent evt) {
		quitter();
	}

	private void quitter() {
		try {
			connexionBD.close();
			System.out.println("Connexion à la BD terminée");
			System.exit(0);
		} catch (SQLException ex) {
			Logger.getLogger(ReservationJoueurFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
