package planning.vue.reservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;

import planning.dao.interfacedao.ICreneauDAO;
import planning.dao.sql.CreneauDaoSql;
import planning.metier.Creneau;

public class ReservationJButton extends JButton {

	private ICreneauDAO creneauDAO;
	
	public ReservationJButton(Creneau creneau, Connection connection, ReservationJoueurFrame mainFrame) {
		super(creneau.getCourt().getNom());
		this.creneauDAO = new CreneauDaoSql();
		this.creneauDAO.setConnection(connection);
				
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NomReservationDialog dialogNom = new NomReservationDialog(creneau, connection, mainFrame);  
				dialogNom.setVisible(true);
			}
			
		});
	}
}
