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

import planning.dao.interfacedao.IMatchDAO;
import planning.metier.Arbitre;
import planning.metier.Court;
import planning.metier.Equipe;
import planning.metier.EquipeDeRamasseur;
import planning.metier.Joueur;
import planning.metier.Jour;
import planning.metier.Match;

public class MatchDaoSql implements IMatchDAO {

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
	public List<Match> getMatchs() {
		ResultSet rset = null;
		Statement stmt = null;
		List<Match> listMatchs = null;
		String query = "SELECT matchid, typetournoiid, jourid, trancheid, courtid FROM matchs";
		Match match;

		try {
			stmt = this.connexionBD.createStatement();
			listMatchs = new ArrayList<Match>();
			rset = stmt.executeQuery(query);

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
	public void addMatch(Match match) {
		PreparedStatement stmt;
		String query = "INSERT INTO matchs(matchid, typetournoiid, courtid, jourid, trancheid) VALUES (?, ?, ?, ?, ?)";
		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, match.getMatchId());
			stmt.setInt(2, match.getTypeTournoiId());
			stmt.setInt(3, match.getCreneau().getCourt().getCourtId());
			stmt.setInt(4, match.getCreneau().getJour().getJourId());
			stmt.setInt(5, match.getCreneau().getTranche().getTrancheId());
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
		String query = "SELECT matchid, typetournoiid, jourid, trancheid, courtid FROM matchs WHERE matchid = ?";
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
		String query = "SELECT matchid, typetournoiid, jourid, trancheid, courtid FROM matchs WHERE matchid IN (SELECT matchid FROM jouer WHERE joueurid = ?)";
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
		String query = "SELECT matchid, typetournoiid, jourid, trancheid, courtid FROM matchs WHERE jourid  = ?";
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
		String query = "SELECT matchid, typetournoiid, jourid, trancheid, courtid FROM matchs WHERE courtid  = ?";
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

	@Override
	public boolean isPremierTour(Match match) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = "SELECT matchid, typetournoiid, jourid, trancheid, courtid FROM matchs WHERE matchsuivant = ?";
		boolean isPremierTour = true;

		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, match.getMatchId());
			rset = stmt.executeQuery();

			isPremierTour = !rset.next();
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}

		return isPremierTour;
	}

	@Override
	public void updateMatch(Match match) {
		PreparedStatement stmt;
		String query = "UPDATE matchs SET jourid = ?, trancheid = ?, courtid = ? WHERE matchid = ?";
		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, match.getCreneau().getJour().getJourId());
			stmt.setInt(2, match.getCreneau().getTranche().getTrancheId());
			stmt.setInt(3, match.getCreneau().getCourt().getCourtId());
			stmt.setInt(4, match.getMatchId());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void enleverJoueurs(Match match) {
		PreparedStatement stmt;
		String query = "DELETE FROM jouer WHERE matchid = ?";
		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, match.getMatchId());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void ajouterJoueur(Match match, Joueur joueur) {
		PreparedStatement stmt;
		String query = "INSERT INTO jouer(matchid, joueurid) VALUES (?, ?)";
		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, match.getMatchId());
			stmt.setInt(2, joueur.getJoueurId());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void enleverArbitre(Match match) {
		PreparedStatement stmt;
		String query = "DELETE FROM arbitrer WHERE matchid = ?";
		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, match.getMatchId());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void ajouterArbitre(Match match, Arbitre arbitre) {
		PreparedStatement stmt;
		String query = "INSERT INTO arbitrer(matchid, arbitreid) VALUES (?, ?)";
		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, match.getMatchId());
			stmt.setInt(2, arbitre.getArbitreId());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void ajouterArbitresLigne(Match match) {
		ResultSet rset = null;
		PreparedStatement stmt;
		String query = "SELECT arbitreid, nomarbitre, prenomarbitre, categorie, nationalite FROM arbitre "
				+ "WHERE categorie = 'JAT2' AND arbitreId NOT IN (SELECT A.arbitreId FROM arbitre A JOIN arbitrer AR ON A.arbitreId = AR.arbitreId JOIN matchs M ON AR.matchId = M.matchId "
				+ "WHERE categorie = 'JAT2' AND M.courtId = ? AND M.jourId = ? AND M.trancheId = ?)";
		Arbitre arbitre = null;

		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, match.getCreneau().getCourt().getCourtId());
			stmt.setInt(2, match.getCreneau().getJour().getJourId());
			stmt.setInt(3, match.getCreneau().getTranche().getTrancheId());

			for (int i = 0; i < 8; i++) {
				rset = stmt.executeQuery();

				if (rset.next()) {
					arbitre = new Arbitre(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
							rset.getString(5));
					this.ajouterArbitre(match, arbitre);
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void enleverRamasseurs(Match match) {
		PreparedStatement stmt;
		String query = "DELETE FROM ramasser WHERE matchid = ?";
		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, match.getMatchId());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void ajouterRamasseurs(Match match) {
		ResultSet rset = null;
		PreparedStatement stmt;
		String query = "SELECT E.equipeRamasseursId FROM equipederamasseur E "
				+ "WHERE equipeRamasseursId NOT IN (SELECT R.equipeRamasseursId FROM equipederamasseur R JOIN ramasser RR ON R.equipeRamasseursId = RR.equipeRamasseursId JOIN matchs M ON RR.matchId = M.matchId "
				+ "WHERE M.courtId = ? AND M.jourId = ? AND M.trancheId = ?)";
		EquipeDeRamasseur equipeDeRamasseur = null;

		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, match.getCreneau().getCourt().getCourtId());
			stmt.setInt(2, match.getCreneau().getJour().getJourId());
			stmt.setInt(3, match.getCreneau().getTranche().getTrancheId());

			for (int i = 0; i < 2; i++) {
				rset = stmt.executeQuery();

				if (rset.next()) {
					equipeDeRamasseur = new EquipeDeRamasseur(rset.getInt(1));
					this.ajouterRamasseur(match, equipeDeRamasseur);
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void ajouterRamasseur(Match match, EquipeDeRamasseur equipeDeRamasseur) {
		PreparedStatement stmt;
		String query = "INSERT INTO ramasser(matchid, equipeRamasseursId) VALUES (?, ?)";
		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, match.getMatchId());
			stmt.setInt(2, equipeDeRamasseur.getEquipeRamasseursId());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public List<Match> getByEquipe(Equipe equipe) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = "SELECT matchid, typetournoiid, jourid, trancheid, courtid FROM matchs WHERE matchid IN (SELECT matchid FROM jouer WHERE numequipe = ?)";
		List<Match> listMatchs = null;
		Match match = null;

		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, equipe.getEquipeId());
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
	public void ajouterEquipe(Match match, Equipe equipe) {
		PreparedStatement stmt;
		String query = "INSERT INTO jouer(matchid, numequipe) VALUES (?, ?)";
		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, match.getMatchId());
			stmt.setInt(2, equipe.getEquipeId());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void ajouterGagnant(Match match, Joueur joueur) {
		PreparedStatement stmt;
		String query = "UPDATE matchs SET gagnantid = ? WHERE matchid = ?";
		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, joueur.getJoueurId());
			stmt.setInt(2, match.getMatchId());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public Match getMatchSuivant(Match match) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = "SELECT matchid, typetournoiid, jourid, trancheid, courtid FROM matchs WHERE matchid = (SELECT matchsuivant FROM matchs WHERE matchid = ?)";
		Match suivant = null;

		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, match.getMatchId());
			rset = stmt.executeQuery();

			while (rset.next()) {
				suivant = new Match(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5));
			}
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}

		return suivant;
	}

	@Override
	public void ajouterGagnant(Match match, Equipe equipe) {
		PreparedStatement stmt;
		String query = "UPDATE matchs SET gagnantid = ? WHERE matchid = ?";
		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, equipe.getEquipeId());
			stmt.setInt(2, match.getMatchId());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public boolean isTermine(Match match) {
		ResultSet rset = null;
		PreparedStatement stmt = null;
		String query = "SELECT gagnantid FROM matchs WHERE matchid = ?";
		boolean isTermine = false;

		try {
			stmt = connexionBD.prepareStatement(query);
			stmt.setInt(1, match.getMatchId());
			rset = stmt.executeQuery();

			if (rset.next()) {
				isTermine = rset.getInt(1) != 0;
			}
		} catch (SQLException ex) {
			Logger.getLogger(MatchDaoSql.class.getName()).log(Level.SEVERE, null, ex);
		}
		return isTermine;
	}

}
