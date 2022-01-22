/***********************************************************************
 * Module:  TypeDeTournoi.java
 * Author:  P2003521
 * Purpose: Defines the Class TypeDeTournoi
 ***********************************************************************/

package planning.metier;


public enum TypeDeTournoi {
	QUALIFICATION(1, "Qualification"),
	SIMPLE(2, "Simple"),
	DOUBLE(3, "Double");
	
	private int typeTournoiId;
	private String nom;
	
	TypeDeTournoi(int typeTournoiId, String nom) {
		this.typeTournoiId = typeTournoiId;
		this.nom = nom;
	}

	public int getTypeTournoiId() {
		return typeTournoiId;
	}

	public String getNom() {
		return nom;
	}

	public static TypeDeTournoi getTypeDeTournoiById(int id) {
		switch (id) {
		case 1:		return QUALIFICATION;
		case 2:		return SIMPLE;
		case 3:		return DOUBLE;
		default: 	return null;
		}
	}
	
	public String toString() {
		return this.nom;
	}
	
}