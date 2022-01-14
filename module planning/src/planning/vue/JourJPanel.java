package planning.vue;

import java.awt.Component;
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
	private DataSource dataSource;
	
	public JourJPanel(Jour jour, DataSource dataSource) {
		this.jour = jour;
		this.dataSource = dataSource;
		this.creneauDAO = new CreneauDaoSql();
		this.creneauDAO.setDataSource(dataSource);
		this.createPanel();
	}
	
	private void createPanel() {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(25);
		add(verticalStrut);
		
		for (TrancheHoraire th : TrancheHoraire.values()) {
			List<Creneau> listeCreneau = creneauDAO.getCreneaux(jour, th);
			CreneauJPanel creneauJPanel = new CreneauJPanel(th, listeCreneau, dataSource);
			creneauJPanel.setAlignmentX(0.5f);
			this.add(creneauJPanel);
		}
	}

}
