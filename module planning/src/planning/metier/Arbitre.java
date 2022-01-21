/***********************************************************************
 * Module:  Arbitre.java
 * Author:  P2003521
 * Purpose: Defines the Class Arbitre
 ***********************************************************************/
package planning.metier;

public class Arbitre {
	private int arbitreId;
	private String nom;
	private String prenom;
	private String categorie;
	private String nationalite;
	
	public Arbitre(int arbitreId, String nom, String prenom, String categorie, String nationalite) {
		super();
		this.arbitreId = arbitreId;
		this.nom = nom;
		this.prenom = prenom;
		this.categorie = categorie;
		this.nationalite = nationalite;
	}

	public int getArbitreId() {
		return arbitreId;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getCategorie() {
		return categorie;
	}

	public String getNationalite() {
		return nationalite;
	}
	
	public String toString() {
		return nom;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arbitre other = (Arbitre) obj;
		return arbitreId == other.arbitreId;
	}
	
	
	
	
	
}