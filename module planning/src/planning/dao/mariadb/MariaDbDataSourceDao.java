package planning.dao.mariadb;

import java.io.*;
import java.sql.SQLException;
import java.util.Properties;
import org.mariadb.jdbc.MariaDbDataSource;

public class MariaDbDataSourceDao extends MariaDbDataSource {

	private static MariaDbDataSourceDao dataSource;
	
	private MariaDbDataSourceDao() {}
	
	public static MariaDbDataSourceDao getMariaDBDataSourceDAO() {
		if (dataSource == null) {
			FileInputStream fichier = null;
			try {
				Properties prop = new Properties();
				fichier = new FileInputStream(".\\connexion.properties");
				prop.load(fichier);
				dataSource = new MariaDbDataSourceDao ();
				dataSource.setPortNumber(Integer.parseInt((prop.getProperty("port"))));
				dataSource.setServerName(prop.getProperty("serveur"));
				dataSource.setDatabaseName(prop.getProperty("base"));
				dataSource.setUser(prop.getProperty("user"));
				dataSource.setPassword(prop.getProperty("pwd"));
				System.out.println("Connexion a MariaDB réussie");
			} catch (FileNotFoundException ex1) {
				System.out.println("Fichier de proprietes non trouvé");
			} catch (IOException  | SQLException ex) {
				System.out.println("Erreur lors du chargement du fichier de proprietes mySQL");
			} finally {
				try {
					if (fichier != null) fichier.close();
				} catch (IOException ex) {
					System.out.print("Problème d'entree/sortie" + ex.getMessage());
				}
			}
			// pas de service à définir pour MariaDB
		} else System.out.println("---(la source de data existe deja)") ;

		 return dataSource;
	}
	
}
