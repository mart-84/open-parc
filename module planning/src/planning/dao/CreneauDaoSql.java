package planning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import planning.dao.interfacedao.ICreneauDAO;
import planning.metier.Court;
import planning.metier.Creneau;
import planning.metier.Jour;
import planning.metier.TrancheHoraire;

public class CreneauDaoSql implements ICreneauDAO {
	
	private Connection connexionBD;
	
	private static final String baseQuery =  "SELECT jourId, trancheId, courtId FROM jour, tranchehoraire, court "
			+ "WHERE (jourId, trancheId, courtId) NOT IN (SELECT jourId, trancheId, courtId FROM matchs) "
			+ "AND (jourId, trancheId, courtId) NOT IN (SELECT jourId, trancheId, courtId FROM reservation) ";
	
	@Override
	public void setDataSource(DataSource dataSource) {
		try {
			this.connexionBD = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void setConnection(Connection connexionBD) {
		this.connexionBD = connexionBD;

	}

	@Override
	public Creneau getCreneau(Jour jour, TrancheHoraire th, Court court) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = baseQuery + "AND jourId = ? AND trancheId = ? AND courtId = ?";
		Creneau creneau = null;
		
		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, jour.getJourId());
			stmt.setInt(2, th.getTrancheId());
			stmt.setInt(3, court.getCourtId());
			rset = stmt.executeQuery();
			
			if (rset.next()) {
				creneau = new Creneau(jour, th, court);
			}
			
		} catch (SQLException ex) {
            Logger.getLogger(CreneauDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return creneau;
	}

	@Override
	public List<Creneau> getCreneaux() {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = baseQuery;
		List<Creneau> listCreneau = null;
		Creneau creneau = null;
		
		try {
			stmt = connexionBD.prepareStatement(query);
			listCreneau = new ArrayList<Creneau>();
			rset = stmt.executeQuery();
			
			if (rset.next()) {
				creneau = new Creneau(Jour.getJourById(rset.getInt(1)), TrancheHoraire.getTrancheById(rset.getInt(2)), Court.getCourtById(rset.getInt(3)));
				listCreneau.add(creneau);
			}
			
		} catch (SQLException ex) {
            Logger.getLogger(CreneauDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return listCreneau;
	}

	@Override
	public List<Creneau> getCreneaux(Jour jour) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = baseQuery + "AND jourId = ?";
		List<Creneau> listCreneau = null;
		Creneau creneau = null;
		
		try {
			stmt = connexionBD.prepareStatement(query);
			listCreneau = new ArrayList<Creneau>();
			stmt.setInt(1, jour.getJourId());
			rset = stmt.executeQuery();
			
			if (rset.next()) {
				creneau = new Creneau(Jour.getJourById(rset.getInt(1)), TrancheHoraire.getTrancheById(rset.getInt(2)), Court.getCourtById(rset.getInt(3)));
				listCreneau.add(creneau);
			}
			
		} catch (SQLException ex) {
            Logger.getLogger(CreneauDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return listCreneau;
	}

	@Override
	public List<Creneau> getCreneaux(TrancheHoraire th) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Creneau> getCreneaux(Court court) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Creneau> getCreneaux(Jour jour, Court court) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Creneau> getCreneaux(Jour jour, TrancheHoraire th) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = baseQuery + "AND jourId = ? AND trancheId = ?";
		List<Creneau> listCreneau = null;
		Creneau creneau = null;
		
		try {
			stmt = connexionBD.prepareStatement(query);
			listCreneau = new ArrayList<Creneau>();
			stmt.setInt(1, jour.getJourId());
			stmt.setInt(2, th.getTrancheId());
			rset = stmt.executeQuery();
			
			while (rset.next()) {
				creneau = new Creneau(Jour.getJourById(rset.getInt(1)), TrancheHoraire.getTrancheById(rset.getInt(2)), Court.getCourtById(rset.getInt(3)));
				listCreneau.add(creneau);
			}
			
		} catch (SQLException ex) {
            Logger.getLogger(CreneauDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return listCreneau;
	}

}
