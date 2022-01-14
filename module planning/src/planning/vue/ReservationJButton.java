package planning.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sql.DataSource;
import javax.swing.JButton;

import planning.dao.CreneauDaoSql;
import planning.dao.interfacedao.ICreneauDAO;
import planning.metier.Creneau;

public class ReservationJButton extends JButton {

	private Creneau creneau;
	private ICreneauDAO creneauDAO;
	
	public ReservationJButton(Creneau creneau, DataSource dataSource) {
		super(creneau.getCourt().getNom());
		this.creneau = creneau;
		this.creneauDAO = new CreneauDaoSql();
		this.creneauDAO.setDataSource(dataSource);
				
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Créneau réservé : " + creneau);
			}
			
		});
	}
	
}
