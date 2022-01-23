package planning.dao.interfacedao;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import planning.metier.Equipe;
import planning.metier.Joueur;
import planning.metier.Match;

public interface IEquipeDAO {
	public void 			setDataSource(DataSource ds);
	public void 			setConnection(Connection connexionBD);
	public List<Equipe>		getEquipes();
	public Equipe			getById(int idEquipe);
	public Equipe			getByJoueur(Joueur joueur);
	public List<Equipe>		getByMatch(Match match);
}
