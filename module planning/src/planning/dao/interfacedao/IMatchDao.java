package planning.dao.interfacedao;

import java.sql.Connection;
import java.util.List;
import javax.sql.DataSource;

import planning.metier.Court;
import planning.metier.Joueur;
import planning.metier.Jour;
import planning.metier.Match;

public interface IMatchDao {
	public List<Match> 		getMatchs();
	public int 				setMatchs(List<Match> matchs);
	public void 			addMatch(Match match);
	public boolean 			supprMatch(Match match);;
	public void 			setDataSource(DataSource ds);
	public void 			setConnection(Connection connexionBD);
	public Match			getById(int numMatch);
	public List<Match>		getByJoueur(Joueur joueur);
	public List<Match>		getByJour(Jour jour);
	public List<Match>		getByCourt(Court court);
}
