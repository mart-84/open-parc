package planning.vue;

import java.sql.Connection;
import java.sql.SQLException;

import planning.dao.interfacedao.IMatchDAO;
import planning.dao.mariadb.MariaDbDataSourceDao;
import planning.dao.sql.MatchDaoSql;
import planning.metier.Match;


public class Planning {

	public static void main(String[] args) {
		
		MariaDbDataSourceDao dataSource = MariaDbDataSourceDao.getMariaDBDataSourceDAO();
		
		
		try {
			Connection connexion = dataSource.getConnection();
			IMatchDAO matchDao = new MatchDaoSql();
			matchDao.setConnection(connexion);
			Match match = new Match();
			match = matchDao.getById(1);
			System.out.println(match);
			//List<Match> listMatchs = matchDao.getMatchs();

			//System.out.println(listMatchs.get(0));
			
			//matchDao.supprMatch(match);
			
			connexion.close();
			System.out.println("Connexion terminée");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
