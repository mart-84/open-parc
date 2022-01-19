/***********************************************************************
 * Module:  Match.java
 * Author:  P2003521
 * Purpose: Defines the Class Match
 ***********************************************************************/

package planning.metier;


public class Match {
	private int matchId;
   	private int typeTournoiId;
   	private Creneau creneau;
   
   	public Match() {
   		
   	}
   	
	public Match(int matchId, int typeTournoiId, Creneau creneau) {
		this.matchId = matchId;
		this.typeTournoiId = typeTournoiId;
		this.creneau = creneau;
	}

	public Match(int matchId, int typeTournoiId, int jourId, int trancheId, int courtId) {
		this.matchId = matchId;
		this.typeTournoiId = typeTournoiId;
		this.creneau = new Creneau(Jour.getJourById(jourId), TrancheHoraire.getTrancheById(trancheId), Court.getCourtById(courtId));
	}
	
	public int getMatchId() {
		return matchId;
	}

	public int getTypeTournoiId() {
		return typeTournoiId;
	}

	public Creneau getCreneau() {
		return creneau;
	}

	@Override
	public String toString() {
		return "Match -> matchId : " + matchId + ", typeTournoiId : " + typeTournoiId + ", creneau : " + creneau;
	}

	
}