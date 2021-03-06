package planning.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import planning.dao.interfacedao.IArbitreDAO;
import planning.metier.Arbitre;
import planning.metier.Creneau;
import planning.metier.Jour;
import planning.metier.Match;
import planning.metier.TrancheHoraire;

public class ArbitreDaoSql implements IArbitreDAO {

	private Connection connexionBD;

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
	public Arbitre getById(int idArbitre) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = "SELECT arbitreid, nomarbitre, prenomarbitre, categorie, nationalite FROM arbitre WHERE arbitreid = ?";
		Arbitre arbitre = null;

		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, idArbitre);
			rset = stmt.executeQuery();

			if (rset.next()) {
				arbitre = new Arbitre(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5));
			}
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}

		return arbitre;
	}

	@Override
	public List<Arbitre> getArbitres() {
		ResultSet rset = null;
		Statement stmt = null;
		List<Arbitre> listArbitre = null;
		String query = "SELECT arbitreid, nomarbitre, prenomarbitre, categorie, nationalite FROM arbitre WHERE categorie = 'ITT1'";
		Arbitre arbitre;

		try {
			stmt = this.connexionBD.createStatement();
			listArbitre = new ArrayList<Arbitre>();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				arbitre = new Arbitre(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5));
				listArbitre.add(arbitre);
			}
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}

		return listArbitre;
	}

	@Override
	public List<Arbitre> getArbitresDispo(Jour jour, TrancheHoraire tranche) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		List<Arbitre> listArbitre = null;
		String query = "SELECT arbitreid, nomarbitre, prenomarbitre, categorie, nationalite FROM arbitre "
				+ "WHERE categorie = 'ITT1' AND arbitreid NOT IN (SELECT arbitreid FROM arbitrer "
				+ "WHERE matchid IN (SELECT matchid FROM matchs WHERE jourid = ? AND trancheid = ?))";
		Arbitre arbitre;

		try {
			stmt = this.connexionBD.prepareStatement(query);
			stmt.setInt(1, jour.getJourId());
			stmt.setInt(2, tranche.getTrancheId());
			listArbitre = new ArrayList<Arbitre>();
			System.out.println(stmt);
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				arbitre = new Arbitre(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5));
				listArbitre.add(arbitre);
			}
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}

		return listArbitre;
	}

	@Override
	public void addMatch(Match match) {
	}

	@Override
	public Arbitre getByMatch(Match match) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = "SELECT arbitreid, nomarbitre, prenomarbitre, categorie, nationalite FROM arbitre "
				+ "WHERE categorie = 'ITT1' AND arbitreid IN (SELECT arbitreid FROM arbitrer WHERE matchid = ?)";
		Arbitre arbitre = null;

		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, match.getMatchId());
			rset = stmt.executeQuery();

			if (rset.next()) {
				arbitre = new Arbitre(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5));
			}
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}

		return arbitre;
	}

	@Override
	public int[] getNombreMatchArbitre(Arbitre arbitre) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String querySimple = "SELECT count(*) FROM matchs m JOIN arbitrer ar ON m.matchid = ar.matchId "
				+ "WHERE m.typeTournoiId = 2 AND ar.arbitreid = ?"; // tournoi simple
		String queryDouble = "SELECT count(*) FROM matchs m JOIN arbitrer ar ON m.matchid = ar.matchId "
				+ "WHERE m.typeTournoiId = 3 AND ar.arbitreid = ?"; // tournoi double
		int[] nombreMatch = { 0, 0 };

		try {
			stmt = connexionBD.prepareStatement(querySimple);
			stmt.setInt(1, arbitre.getArbitreId());
			rset = stmt.executeQuery();

			if (rset.next()) {
				nombreMatch[0] = rset.getInt(1);
			}

			stmt = connexionBD.prepareStatement(queryDouble);
			stmt.setInt(1, arbitre.getArbitreId());
			rset = stmt.executeQuery();

			if (rset.next()) {
				nombreMatch[1] = rset.getInt(1);
			}
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}

		return nombreMatch;
	}

	@Override
	public boolean checkArbitreDispo(Arbitre arbitre, Creneau creneau, Match match) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = "SELECT matchid, typetournoiid, jourid, trancheid, courtid FROM matchs "
				+ "WHERE jourid = ? AND trancheid = ? "
				+ "AND matchid IN (SELECT matchid FROM arbitrer WHERE arbitreid = ?) " + "AND matchid != ?";
		boolean isOk = true;

		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, creneau.getJour().getJourId());
			stmt.setInt(2, creneau.getTranche().getTrancheId());
			stmt.setInt(3, arbitre.getArbitreId());
			stmt.setInt(4, match.getMatchId());
			rset = stmt.executeQuery();

			isOk = !rset.next();

		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}

		return isOk;
	}

}
