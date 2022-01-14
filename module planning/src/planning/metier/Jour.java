/***********************************************************************
 * Module:  Journee.java
 * Author:  P2003521
 * Purpose: Defines the Class Journee
 ***********************************************************************/

package planning.metier;

import java.util.*;

public enum Jour {
	DIMANCHE1(1, "Dimanche"),
	LUNDI(2, "Lundi"),
	MARDI(3, "Mardi"),
	MERCREDI(4, "Mercredi"),
	JEUDI(5, "Jeudi"),
	VENDREDI(6, "Vendredi"),
	SAMEDI(7, "Samedi"),
	DIMANCHE2(8, "Dimanche");
	
	private int jourId;
	private String nom;
	
	Jour(int jourId, String nom) {
		this.jourId = jourId;
		this.nom = nom;
	}
	
	public int getJourId() {
		return jourId;
	}
	
	public String getNom() {
		return nom;
	}

	public static Jour getJourById(int id) {
		switch (id) {
		case 1:		return DIMANCHE1; 
		case 2:		return LUNDI;
		case 3:		return MARDI;
		case 4:		return MERCREDI;
		case 5:		return JEUDI;
		case 6:		return VENDREDI;
		case 7:		return SAMEDI;
		case 8:		return DIMANCHE2;
		default: 	return null;
		}
	}

}