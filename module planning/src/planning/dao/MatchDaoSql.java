package planning.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import planning.dao.interfacedao.IMatchDao;
import planning.metier.Court;
import planning.metier.Joueur;
import planning.metier.Jour;
import planning.metier.Match;

public class MatchDaoSql implements IMatchDao {

	private Connection connexionBD;
	
	public MatchDaoSql(Connection connexionBD) {
		this.connexionBD = connexionBD;
	}
	
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
	public List<Match> getMatchs() {
		ResultSet rset = null;
		Statement stmt = null;
		List<Match> listMatchs = null;
		String query = "SELECT matchid, courtid, jourid, typetournoiid, trancheid FROM matchs";
		Match match;
		
		try {
			stmt = this.connexionBD.createStatement();
			listMatchs = new ArrayList<Match>();
			rset = stmt.executeQuery(query);
			
			while (rset.next()) {
				match = new Match(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5));
				listMatchs.add(match);
            }
		} catch(SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return listMatchs;
	}

	@Override
	public int setMatchs(List<Match> matchs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addMatch(Match match) {
		PreparedStatement stmt;
		String query = "INSERT INTO matchs(matchid, courtid, jourid, typetournoiid, trancheid) VALUES (?, ?, ?, ?, ?)";
		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, match.getMatchId());
			stmt.setInt(2, match.getCourtId());
			stmt.setInt(3, match.getJourId());
			stmt.setInt(4, match.getTypeTournoiId());
			stmt.setInt(5, match.getTrancheId());
			stmt.executeUpdate();
		} catch (SQLException ex) {
            Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	@Override
	public boolean supprMatch(Match match) {
		PreparedStatement stmt;
		String query = "DELETE FROM matchs WHERE matchid = ?";
		int n = 0;
		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, match.getMatchId());
			n = stmt.executeUpdate();
		} catch (SQLException ex) {
            Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
        }
		return n == 1;
	}

	@Override
	public Match getById(int numMatch) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = "SELECT matchid, courtid, jourid, typetournoiid, trancheid FROM matchs WHERE matchid = ?";
		Match match = null;
		
		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, numMatch);
			rset = stmt.executeQuery();
			
			while (rset.next()) {
				match = new Match(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5));
            }
		} catch (SQLException ex) {
            Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		return match;
	}

	@Override
	public List<Match> getByJoueur(Joueur joueur) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = "SELECT matchid, courtid, jourid, typetournoiid, trancheid FROM matchs WHERE matchid IN (SELECT matchid FROM jouer WHERE joueurid = ?";
		List<Match> listMatchs = null;
		Match match = null;
		
		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, joueur.getJoueurId());
			listMatchs = new ArrayList<Match>();
			rset = stmt.executeQuery();
			
			while (rset.next()) {
				match = new Match(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5));
				listMatchs.add(match);
            }
		} catch (SQLException ex) {
            Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		return listMatchs;
	}

	@Override
	public List<Match> getByJour(Jour jour) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = "SELECT matchid, courtid, jourid, typetournoiid, trancheid FROM matchs WHERE jourid  = ?";
		List<Match> listMatchs = null;
		Match match = null;
		
		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, jour.getJourId());
			listMatchs = new ArrayList<Match>();
			rset = stmt.executeQuery();
			
			while (rset.next()) {
				match = new Match(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5));
				listMatchs.add(match);
            }
		} catch (SQLException ex) {
            Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		return listMatchs;
	}

	@Override
	public List<Match> getByCourt(Court court) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = "SELECT matchid, courtid, jourid, typetournoiid, trancheid FROM matchs WHERE courtid  = ?";
		List<Match> listMatchs = null;
		Match match = null;
		
		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, court.getCourtId());
			listMatchs = new ArrayList<Match>();
			rset = stmt.executeQuery();
			
			while (rset.next()) {
				match = new Match(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5));
				listMatchs.add(match);
            }
		} catch (SQLException ex) {
            Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		return listMatchs;
	}

}
