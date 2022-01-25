/***********************************************************************
 * Module:  Court.java
 * Author:  P2003521
 * Purpose: Defines the Class Court
 ***********************************************************************/

package planning.metier;

public enum Court {

	CENTRAL(1, "Court central"), ANNEXE1(2, "Court annexe 1"), ANNEXE2(3, "Court annexe 2"),
	ANNEXE3(4, "Court annexe 3");

	private int courtId;
	private String nom;

	Court(int courtId, String nom) {
		this.courtId = courtId;
		this.nom = nom;
	}

	public int getCourtId() {
		return courtId;
	}

	public String getNom() {
		return nom;
	}

	public static Court getCourtById(int id) {
		switch (id) {
		case 1:
			return CENTRAL;
		case 2:
			return ANNEXE1;
		case 3:
			return ANNEXE2;
		case 4:
			return ANNEXE3;
		default:
			return null;
		}
	}

	public String toString() {
		return nom;
	}

}