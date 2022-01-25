package planning.dao.interfacedao;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import planning.metier.Arbitre;
import planning.metier.Creneau;
import planning.metier.Jour;
import planning.metier.Match;
import planning.metier.TrancheHoraire;

public interface IArbitreDAO {
	public void setDataSource(DataSource ds);

	public void setConnection(Connection connexionBD);

	public Arbitre getById(int idArbitre);

	public Arbitre getByMatch(Match match);

	public List<Arbitre> getArbitres();

	public List<Arbitre> getArbitresDispo(Jour jour, TrancheHoraire tranche);

	public void addMatch(Match match);

	public int[] getNombreMatchArbitre(Arbitre arbitre);

	public boolean checkArbitreDispo(Arbitre arbitre, Creneau creneau, Match match);
}
