package planning.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import planning.dao.interfacedao.IReservationDAO;
import planning.metier.Reservation;

public class ReservationDaoSql implements IReservationDAO {

	private Connection connexionBD;

	@Override
	public void setDataSource(DataSource dataSource) {
		try {
			this.connexionBD = dataSource.getConnection();
		} catch (SQLException ex) {
            Logger.getLogger(ReservationDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public void setConnection(Connection connexionBD) {
		this.connexionBD = connexionBD;

	}

	@Override
	public List<Reservation> getReservations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addReservation(Reservation reserv) {
		PreparedStatement stmt;
        try {
        	stmt = connexionBD.prepareStatement("INSERT INTO reservation(courtId, jourId, trancheId, nomJoueur) VALUES (?, ?, ?, ?)");
        	stmt.setInt(1, reserv.getCourt().getCourtId());
        	stmt.setInt(2, reserv.getJour().getJourId());
        	stmt.setInt(3, reserv.getTranche().getTrancheId());
        	stmt.setString(4, reserv.getNomJoueur());
        	stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDaoSql.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

}
