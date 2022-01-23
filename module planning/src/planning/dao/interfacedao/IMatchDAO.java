package planning.dao.interfacedao;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import planning.metier.Arbitre;
import planning.metier.Court;
import planning.metier.EquipeDeRamasseur;
import planning.metier.Joueur;
import planning.metier.Jour;
import planning.metier.Match;

public interface IMatchDAO {
	public void 			setDataSource(DataSource ds);
	public void 			setConnection(Connection connexionBD);
	public List<Match> 		getMatchs();
	public void 			addMatch(Match match);
	public boolean 			supprMatch(Match match);
	public Match 			getById(int numMatch);
	public List<Match> 		getByJoueur(Joueur joueur);
	public List<Match> 		getByJour(Jour jour);
	public List<Match> 		getByCourt(Court court);
	public boolean 			isPremierTour(Match match);
	public void 			updateMatch(Match match);
	public void 			enleverJoueurs(Match match);
	public void 			ajouterJoueur(Match match, Joueur joueur);
	public void				enleverArbitre(Match match);
	public void 			ajouterArbitre(Match match, Arbitre arbitre);
	public void 			ajouterArbitresLigne(Match match);
	public void 			enleverRamasseurs(Match match);
	public void 			ajouterRamasseurs(Match match);
	public void 			ajouterRamasseur(Match match, EquipeDeRamasseur equipeDeRamasseur);
}
