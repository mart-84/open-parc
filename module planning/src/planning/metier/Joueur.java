/***********************************************************************
 * Module:  Joueurs.java
 * Author:  P2003521
 * Purpose: Defines the Class Joueurs
 ***********************************************************************/

package planning.metier;

public class Joueur {
	private int joueurId;
	private String nom;
	private String prenom;
	private String nationalite;

	public Joueur(int joueurId, String nom, String prenom, String nationalite) {
		super();
		this.nationalite = nationalite;
		this.joueurId = joueurId;
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getJoueurId() {
		return joueurId;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getNationalite() {
		return nationalite;
	}

	@Override
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
		Joueur other = (Joueur) obj;
		return joueurId == other.joueurId;
	}

}