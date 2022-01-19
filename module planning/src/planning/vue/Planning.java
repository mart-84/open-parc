package planning.vue;

import java.sql.Connection;
import java.sql.SQLException;

import planning.dao.MatchDaoSql;
import planning.dao.interfacedao.IMatchDao;
import planning.dao.mariadb.MariaDbDataSourceDao;
import planning.metier.Match;


public class Planning {

	public static void main(String[] args) {
		
		MariaDbDataSourceDao dataSource = MariaDbDataSourceDao.getMariaDBDataSourceDAO();
		
		
		try {
			Connection connexion = dataSource.getConnection();
			IMatchDao matchDao = new MatchDaoSql(connexion);
			Match match = new Match();
			match = matchDao.getById(1);
			System.out.println(match);
			//List<Match> listMatchs = matchDao.getMatchs();

			//System.out.println(listMatchs.get(0));
			
			//matchDao.supprMatch(match);
			
			connexion.close();
			System.out.println("Connexion termin�e");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
