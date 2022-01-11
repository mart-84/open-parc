/***********************************************************************
 * Module:  Court.java
 * Author:  P2003521
 * Purpose: Defines the Class Court
 ***********************************************************************/

package planning.metier;

import java.util.*;

public class Court {
	private int courtId;
	private String nom;
	
	public Court(int courtId, String nom) {
		super();
		this.courtId = courtId;
		this.nom = nom;
	}
	
	public int getCourtId() {
		return courtId;
	}
	
	public String getNom() {
		return nom;
	}
   
   

}