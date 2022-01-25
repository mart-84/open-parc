/***********************************************************************
 * Module:  Reservation.java
 * Author:  P2003521
 * Purpose: Defines the Class Reservation
 ***********************************************************************/

package planning.metier;

public class Reservation {
	private int reservationId;
	private Creneau creneau;
	private String nomJoueur;

	public Reservation(Creneau creneau, String nomJoueur) {
		super();
		this.creneau = creneau;
		this.nomJoueur = nomJoueur;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public Court getCourt() {
		return creneau.getCourt();
	}

	public Jour getJour() {
		return creneau.getJour();
	}

	public TrancheHoraire getTranche() {
		return creneau.getTranche();
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

}