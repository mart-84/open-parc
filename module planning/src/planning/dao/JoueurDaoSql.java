package planning.dao;

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

import planning.dao.interfacedao.IJoueurDAO;
import planning.metier.Joueur;
import planning.metier.Jour;
import planning.metier.Match;
import planning.metier.TrancheHoraire;

public class JoueurDaoSql implements IJoueurDAO {

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
	public Joueur getById(int idJoueur) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = "SELECT joueurid, nomjoueur, prenomjoueur, nationalite FROM joueur WHERE joueurid = ?";
		Joueur joueur = null;
		
		try {
			stmt = this.connexionBD.prepareStatement(query);
			stmt.setInt(1, idJoueur);
			rset = stmt.executeQuery();
			
			if (rset.next()) {
				joueur = new Joueur(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4));
			}
		} catch(SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return joueur;
	}

	@Override
	public List<Joueur> getByMatch(Match match) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = "SELECT joueurid, nomjoueur, prenomjoueur, nationalite FROM joueur WHERE joueurid IN (SELECT joueurid FROM jouer WHERE matchid = ?)";
		List<Joueur> listJoueurs = null;
		Joueur joueur = null;
		
		try {
			stmt = this.connexionBD.prepareStatement(query);
			stmt.setInt(1, match.getMatchId());
			listJoueurs = new ArrayList<Joueur>();
			rset = stmt.executeQuery();
			
			while (rset.next()) {
				joueur = new Joueur(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4));
				listJoueurs.add(joueur);
            }
		} catch(SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return listJoueurs;
	}

	@Override
	public List<Joueur> getJoueurs() {
		ResultSet rset = null;
		Statement stmt = null;
		List<Joueur> listJoueurs = null;
		String query = "SELECT joueurid, nomjoueur, prenomjoueur, nationalite FROM joueur";
		Joueur joueur;
		
		try {
			stmt = this.connexionBD.createStatement();
			listJoueurs = new ArrayList<Joueur>();
			rset = stmt.executeQuery(query);
			
			while (rset.next()) {
				joueur = new Joueur(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4));
				listJoueurs.add(joueur);
            }
		} catch(SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return listJoueurs;
	}

	@Override
	public void addMatch(Joueur joueur, Match match) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Joueur> getJoueursDispo(Jour jour, TrancheHoraire tranche) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = "SELECT joueurid, nomjoueur, prenomjoueur, nationalite FROM joueur "
				+ "WHERE joueurid NOT IN (SELECT joueurid FROM jouer "
				+ "WHERE matchid IN (SELECT matchid FROM matchs WHERE jourid = ? AND trancheid = ?))";
		List<Joueur> listJoueurs = null;
		Joueur joueur = null;
		
		try {
			stmt = this.connexionBD.prepareStatement(query);
			stmt.setInt(1, jour.getJourId());
			stmt.setInt(2, tranche.getTrancheId());
			listJoueurs = new ArrayList<Joueur>();
			rset = stmt.executeQuery();
			
			while (rset.next()) {
				joueur = new Joueur(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4));
				listJoueurs.add(joueur);
            }
		} catch(SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return listJoueurs;
	}

}
