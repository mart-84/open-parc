package planning.dao.interfacedao;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import planning.metier.Reservation;

public interface IReservationDAO {
	public void setDataSource(DataSource ds);

	public void setConnection(Connection connexionBD);

	public List<Reservation> getReservations();

	public void addReservation(Reservation reserv);
}
