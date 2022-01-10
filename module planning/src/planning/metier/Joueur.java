/***********************************************************************
 * Module:  Joueurs.java
 * Author:  P2003521
 * Purpose: Defines the Class Joueurs
 ***********************************************************************/

package planning.metier;

import java.util.*;

public class Joueur {
	private int joueurId;
   	private String nom;
   	private String prenom;
	
   	public Joueur(int joueurId, String nom, String prenom) {
		super();
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
   	
}