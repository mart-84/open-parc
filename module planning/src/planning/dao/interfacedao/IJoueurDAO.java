package planning.dao.interfacedao;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import planning.metier.Creneau;
import planning.metier.Joueur;
import planning.metier.Jour;
import planning.metier.Match;
import planning.metier.TrancheHoraire;

public interface IJoueurDAO {
	public void setDataSource(DataSource ds);

	public void setConnection(Connection connexionBD);

	public Joueur getById(int idJoueur);

	public List<Joueur> getByMatch(Match match);

	public List<Joueur> getJoueurs();

	public List<Joueur> getJoueursQualif();

	public List<Joueur> getJoueursSimple();

	public List<Joueur> getJoueursDouble();

	public List<Joueur> getJoueursDispo(Jour jour, TrancheHoraire tranche);

	public boolean checkJoueurDispo(Joueur joueur, Creneau creneau, Match match);

	public void eliminerQualif(Joueur joueur);

	public void qualifier(Joueur joueur);

	public boolean isGagnant(Joueur joueur, Match match);
}
