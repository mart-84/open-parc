package planning.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.swing.JButton;

import planning.dao.CreneauDaoSql;
import planning.dao.interfacedao.ICreneauDAO;
import planning.metier.Creneau;

public class ReservationJButton extends JButton {

	private ICreneauDAO creneauDAO;
	private ReservationJoueur mainFrame;
	
	public ReservationJButton(Creneau creneau, Connection connection, ReservationJoueur mainFrame) {
		super(creneau.getCourt().getNom());
		this.mainFrame = mainFrame;
		this.creneauDAO = new CreneauDaoSql();
		this.creneauDAO.setConnection(connection);
				
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NomReservation dialogNom = new NomReservation(creneau, connection, mainFrame);  
				dialogNom.setVisible(true);
			}
			
		});
	}
}
