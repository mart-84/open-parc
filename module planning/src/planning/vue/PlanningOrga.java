package planning.vue;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.mariadb.jdbc.MariaDbDataSource;

import planning.dao.mariadb.MariaDbDataSourceDao;
import planning.vue.reservation.ReservationJoueurFrame;

public class PlanningOrga extends JFrame {

	private JPanel contentPane;
	private final Dimension matchDimension = new Dimension(140, 40);
	private final Dimension matchDoubleDimension = new Dimension(158, 42);
	
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
		createPanel();
	}
	
	public void updatePanel() {
		this.revalidate();
		this.repaint();
		this.createPanel();
	}

	
	private void createPanel() {
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
		
		createMatchs(tabbedPane);

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});
	}
	
	private void createMatchs(JTabbedPane tabbedPane) {
		JPanel qualificationPanel = new JPanel();
		tabbedPane.addTab("Tournoi Qualification", null, qualificationPanel, null);
		qualificationPanel.setLayout(null);
		
		List<MatchComponentData> matchComponentDataList = new ArrayList<MatchComponentData>();
		matchComponentDataList.add(new MatchComponentData(1, new Point(278, 187), matchDimension));
		matchComponentDataList.add(new MatchComponentData(2, new Point(278, 265), matchDimension));
		matchComponentDataList.add(new MatchComponentData(3, new Point(487, 226), matchDimension));
		matchComponentDataList.add(new MatchComponentData(4, new Point(278, 369), matchDimension));
		matchComponentDataList.add(new MatchComponentData(5, new Point(278, 447), matchDimension));
		matchComponentDataList.add(new MatchComponentData(6, new Point(487, 408), matchDimension));
		matchComponentDataList.add(new MatchComponentData(7, new Point(749, 187), matchDimension));
		matchComponentDataList.add(new MatchComponentData(8, new Point(749, 265), matchDimension));
		matchComponentDataList.add(new MatchComponentData(9, new Point(958, 226), matchDimension));
		matchComponentDataList.add(new MatchComponentData(10, new Point(749, 369), matchDimension));
		matchComponentDataList.add(new MatchComponentData(11, new Point(749, 447), matchDimension));
		matchComponentDataList.add(new MatchComponentData(12, new Point(958, 408), matchDimension));
	
		for(MatchComponentData matchComponentData : matchComponentDataList) {
			MatchComponent matchC = new MatchComponent(connexionBD, this);
			matchComponentData.setUpMatchComponent(matchC);
			qualificationPanel.add(matchC);
		}
		
		JPanel tournoiSimplePanel = new JPanel();
		tabbedPane.addTab("Tournoi Simple", null, tournoiSimplePanel, null);
		tournoiSimplePanel.setLayout(null);
		
		matchComponentDataList = new ArrayList<MatchComponentData>();
		matchComponentDataList.add(new MatchComponentData(101, new Point(38, 46), matchDimension));
		matchComponentDataList.add(new MatchComponentData(102, new Point(38, 134), matchDimension));
		matchComponentDataList.add(new MatchComponentData(103, new Point(38, 222), matchDimension));
		matchComponentDataList.add(new MatchComponentData(104, new Point(38, 310), matchDimension));
		matchComponentDataList.add(new MatchComponentData(105, new Point(38, 398), matchDimension));
		matchComponentDataList.add(new MatchComponentData(106, new Point(38, 486), matchDimension));
		matchComponentDataList.add(new MatchComponentData(107, new Point(38, 574), matchDimension));
		matchComponentDataList.add(new MatchComponentData(108, new Point(38, 662), matchDimension));
		matchComponentDataList.add(new MatchComponentData(109, new Point(1231, 46), matchDimension));
		matchComponentDataList.add(new MatchComponentData(110, new Point(1231, 134), matchDimension));
		matchComponentDataList.add(new MatchComponentData(111, new Point(1231, 222), matchDimension));
		matchComponentDataList.add(new MatchComponentData(112, new Point(1231, 310), matchDimension));
		matchComponentDataList.add(new MatchComponentData(113, new Point(1231, 398), matchDimension));
		matchComponentDataList.add(new MatchComponentData(114, new Point(1231, 486), matchDimension));
		matchComponentDataList.add(new MatchComponentData(115, new Point(1231, 574), matchDimension));
		matchComponentDataList.add(new MatchComponentData(116, new Point(1231, 662), matchDimension));
		matchComponentDataList.add(new MatchComponentData(117, new Point(198, 92), matchDimension));
		matchComponentDataList.add(new MatchComponentData(118, new Point(198, 268), matchDimension));
		matchComponentDataList.add(new MatchComponentData(119, new Point(198, 444), matchDimension));
		matchComponentDataList.add(new MatchComponentData(120, new Point(198, 620), matchDimension));
		matchComponentDataList.add(new MatchComponentData(121, new Point(1072, 92), matchDimension));
		matchComponentDataList.add(new MatchComponentData(122, new Point(1072, 268), matchDimension));
		matchComponentDataList.add(new MatchComponentData(123, new Point(1072, 444), matchDimension));
		matchComponentDataList.add(new MatchComponentData(124, new Point(1072, 620), matchDimension));
		matchComponentDataList.add(new MatchComponentData(125, new Point(354, 181), matchDimension));
		matchComponentDataList.add(new MatchComponentData(126, new Point(354, 527), matchDimension));
		matchComponentDataList.add(new MatchComponentData(127, new Point(897, 181), matchDimension));
		matchComponentDataList.add(new MatchComponentData(128, new Point(897, 527), matchDimension));
		matchComponentDataList.add(new MatchComponentData(129, new Point(490, 336), matchDimension));
		matchComponentDataList.add(new MatchComponentData(130, new Point(765, 336), matchDimension));
		matchComponentDataList.add(new MatchComponentData(131, new Point(623, 201), matchDimension));
                  
		for(MatchComponentData matchComponentData : matchComponentDataList) {
			MatchComponent matchC = new MatchComponent(connexionBD, this);
			matchComponentData.setUpMatchComponent(matchC);
			tournoiSimplePanel.add(matchC);
		}
		
		JLabel theBigMatchLabel = new JLabel("The Big Match");
		theBigMatchLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		theBigMatchLabel.setBounds(623, 158, 108, 32);
		tournoiSimplePanel.add(theBigMatchLabel);
		 
		JPanel tournoiDoublePanel = new JPanel();
		tabbedPane.addTab("Tournoi Double", null, tournoiDoublePanel, null);
		tournoiDoublePanel.setLayout(null);
		
		matchComponentDataList = new ArrayList<MatchComponentData>();
		matchComponentDataList.add(new MatchComponentData(201, new Point(100, 120), matchDoubleDimension));
		matchComponentDataList.add(new MatchComponentData(202, new Point(100, 279), matchDoubleDimension));
		matchComponentDataList.add(new MatchComponentData(203, new Point(100, 438), matchDoubleDimension));
		matchComponentDataList.add(new MatchComponentData(204, new Point(100, 597), matchDoubleDimension));
		matchComponentDataList.add(new MatchComponentData(205, new Point(1134, 120), matchDoubleDimension));
		matchComponentDataList.add(new MatchComponentData(206, new Point(1134, 279), matchDoubleDimension));
		matchComponentDataList.add(new MatchComponentData(207, new Point(1134, 438), matchDoubleDimension));
		matchComponentDataList.add(new MatchComponentData(208, new Point(1134, 597), matchDoubleDimension));
		matchComponentDataList.add(new MatchComponentData(209, new Point(330, 226), matchDoubleDimension));
		matchComponentDataList.add(new MatchComponentData(210, new Point(330, 491), matchDoubleDimension));
		matchComponentDataList.add(new MatchComponentData(211, new Point(887, 226), matchDoubleDimension));
		matchComponentDataList.add(new MatchComponentData(212, new Point(887, 491), matchDoubleDimension));
		matchComponentDataList.add(new MatchComponentData(213, new Point(479, 358), matchDoubleDimension));
		matchComponentDataList.add(new MatchComponentData(214, new Point(726, 358), matchDoubleDimension));
		matchComponentDataList.add(new MatchComponentData(215, new Point(612, 184), matchDoubleDimension));
		
		for(MatchComponentData matchComponentData : matchComponentDataList) {
			MatchComponent matchC = new MatchDoubleComponent(connexionBD, this);
			matchComponentData.setUpMatchComponent(matchC);
			tournoiDoublePanel.add(matchC);
		}
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
