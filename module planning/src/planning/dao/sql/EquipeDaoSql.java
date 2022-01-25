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

import planning.dao.interfacedao.IEquipeDAO;
import planning.dao.interfacedao.IJoueurDAO;
import planning.metier.Equipe;
import planning.metier.Joueur;
import planning.metier.Match;

public class EquipeDaoSql implements IEquipeDAO {

	private Connection connexionBD;
	private IJoueurDAO joueurDAO = new JoueurDaoSql();

	@Override
	public void setDataSource(DataSource dataSource) {
		try {
			this.connexionBD = dataSource.getConnection();
			joueurDAO.setConnection(connexionBD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setConnection(Connection connexionBD) {
		this.connexionBD = connexionBD;
		joueurDAO.setConnection(connexionBD);
	}

	@Override
	public List<Equipe> getEquipes() {
		ResultSet rset = null;
		Statement stmt = null;
		List<Equipe> listEquipe = null;
		String query = "SELECT equipeid, j1id, j2id FROM equipe";
		Equipe equipe;
		Joueur j1;
		Joueur j2;

		try {
			stmt = this.connexionBD.createStatement();
			listEquipe = new ArrayList<Equipe>();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				j1 = joueurDAO.getById(rset.getInt(2));
				j2 = joueurDAO.getById(rset.getInt(3));
				equipe = new Equipe(rset.getInt(1), j1, j2);
				listEquipe.add(equipe);
			}
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}

		return listEquipe;
	}

	@Override
	public Equipe getById(int idEquipe) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = "SELECT equipeid, j1id, j2id FROM equipe WHERE equipeid = ?";
		Equipe equipe = null;
		Joueur j1;
		Joueur j2;

		try {
			stmt = this.connexionBD.prepareStatement(query);
			stmt.setInt(1, idEquipe);
			rset = stmt.executeQuery();

			if (rset.next()) {
				j1 = joueurDAO.getById(rset.getInt(2));
				j2 = joueurDAO.getById(rset.getInt(3));
				equipe = new Equipe(rset.getInt(1), j1, j2);
			}
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}

		return equipe;
	}

	@Override
	public Equipe getByJoueur(Joueur joueur) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = "SELECT equipeid, j1id, j2id FROM equipe WHERE j1id = ? OR j2id = ?";
		Equipe equipe = null;
		Joueur j1;
		Joueur j2;

		try {
			stmt = this.connexionBD.prepareStatement(query);
			stmt.setInt(1, joueur.getJoueurId());
			stmt.setInt(2, joueur.getJoueurId());
			rset = stmt.executeQuery();

			if (rset.next()) {
				j1 = joueurDAO.getById(rset.getInt(2));
				j2 = joueurDAO.getById(rset.getInt(3));
				equipe = new Equipe(rset.getInt(1), j1, j2);
			}
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}

		return equipe;
	}

	@Override
	public List<Equipe> getByMatch(Match match) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		List<Equipe> listEquipe = null;
		String query = "SELECT equipeid, j1id, j2id FROM equipe WHERE equipeid IN (SELECT numequipe FROM jouer WHERE matchid = ?)";
		Equipe equipe;
		Joueur j1;
		Joueur j2;

		try {
			stmt = this.connexionBD.prepareStatement(query);
			stmt.setInt(1, match.getMatchId());
			listEquipe = new ArrayList<Equipe>();
			rset = stmt.executeQuery();

			while (rset.next()) {
				j1 = joueurDAO.getById(rset.getInt(2));
				j2 = joueurDAO.getById(rset.getInt(3));
				equipe = new Equipe(rset.getInt(1), j1, j2);
				listEquipe.add(equipe);
			}
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}

		return listEquipe;
	}

	@Override
	public boolean isGagnant(Equipe equipe, Match match) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = "SELECT gagnantid FROM matchs WHERE matchid = ?";
		boolean isGagnant = false;

		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, match.getMatchId());
			rset = stmt.executeQuery();

			if (rset.next()) {
				isGagnant = rset.getInt(1) == equipe.getEquipeId();
			}
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
		return isGagnant;
	}

}
