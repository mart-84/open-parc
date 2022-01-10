package planning.vue;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
			Match match = new Match(2,1,1,1,1);
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
