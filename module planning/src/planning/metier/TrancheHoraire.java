/***********************************************************************
 * Module:  TrancheHorraire.java
 * Author:  P2003521
 * Purpose: Defines the Class TrancheHorraire
 ***********************************************************************/

package planning.metier;

public enum TrancheHoraire {
	
	H10(1, 10),
	H12(2, 12),
	H14(3, 14),
	H16(4, 16);
	
	private int trancheId;
   	private int heureDebut;
   	
	TrancheHoraire(int trancheId, int heureDebut) {
		this.trancheId = trancheId;
		this.heureDebut = heureDebut;
	}

	public int getTrancheId() {
		return trancheId;
	}

	public int getHeureDebut() {
		return heureDebut;
	}
   
	public static TrancheHoraire getTrancheById(int id) {
		switch (id) {
		case 1:		return H10;
		case 2:		return H12;
		case 3:		return H14;
		case 4:		return H16;
		default: 	return null;
		}
	}
	

}