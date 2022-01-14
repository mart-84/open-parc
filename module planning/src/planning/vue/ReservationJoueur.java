package planning.vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mariadb.jdbc.MariaDbDataSource;

import planning.dao.CreneauDaoSql;
import planning.dao.interfacedao.ICreneauDAO;
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
import javax.swing.BoxLayout;


public class ReservationJoueur extends JFrame {

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
					
					ReservationJoueur frame = new ReservationJoueur();
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
	public ReservationJoueur() {
		this.createPanel();
		this.createTitle();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 109, 956, 523);
		contentPane.add(tabbedPane);
		
		for (Jour jour : Jour.values()) {
			JourJPanel panel = new JourJPanel(jour, dataSourceDAO);
			tabbedPane.addTab(jour.getNom(), null, panel, null);
		}
	}
	
	private void createTitle() {
		JLabel title = new JLabel("R\u00E9server un entrainement");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.PLAIN, 40));
		title.setBounds(219, 21, 534, 47);
		contentPane.add(title);
	}

	private void createPanel() {
		setTitle("R\u00E9server un entrainement");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
            Logger.getLogger(ReservationJoueur.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}
