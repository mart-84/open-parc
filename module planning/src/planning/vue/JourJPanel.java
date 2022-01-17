package planning.vue;

import java.awt.Component;
import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import planning.dao.CreneauDaoSql;
import planning.dao.interfacedao.ICreneauDAO;
import planning.metier.Creneau;
import planning.metier.Jour;
import planning.metier.TrancheHoraire;

public class JourJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private Jour jour;
	private ICreneauDAO creneauDAO;
	private ReservationJoueur mainFrame;
	private Connection connection;
	
	public JourJPanel(Jour jour, Connection connection, ReservationJoueur mainFrame) {
		this.jour = jour;
		this.mainFrame = mainFrame;
		this.connection = connection;
		this.creneauDAO = new CreneauDaoSql();
		this.creneauDAO.setConnection(connection);
		this.createPanel();
	}
	
	private void createPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(25);
		add(verticalStrut);
		
		for (TrancheHoraire th : TrancheHoraire.values()) {
			List<Creneau> listCreneau = creneauDAO.getCreneaux(jour, th);
			CreneauJPanel creneauJPanel = new CreneauJPanel(th, listCreneau, connection, mainFrame);
			creneauJPanel.setAlignmentX(0.5f);
			this.add(creneauJPanel);
		}
	}

}
