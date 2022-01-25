package planning.dao.interfacedao;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import planning.metier.Court;
import planning.metier.Creneau;
import planning.metier.Jour;
import planning.metier.TrancheHoraire;

public interface ICreneauDAO {
	public void setDataSource(DataSource ds);

	public void setConnection(Connection connexionBD);

	public Creneau getCreneau(Jour jour, TrancheHoraire th, Court court);

	public List<Creneau> getCreneaux();

	public List<Creneau> getCreneaux(Jour jour);

	public List<Creneau> getCreneaux(TrancheHoraire th);

	public List<Creneau> getCreneaux(Court court);

	public List<Creneau> getCreneaux(Jour jour, Court court);

	public List<Creneau> getCreneaux(Jour jour, TrancheHoraire th);

	public boolean checkDispoCourt(Creneau creneau, int matchId);
}
