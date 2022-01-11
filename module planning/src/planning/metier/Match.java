/***********************************************************************
 * Module:  Match.java
 * Author:  P2003521
 * Purpose: Defines the Class Match
 ***********************************************************************/

package planning.metier;

import java.util.*;

public class Match {
   private int matchId;
   private int courtId;
   private int jourId;
   private int typeTournoiId;
   private int trancheId;
   
	public Match(int matchId, int courtId, int jourId, int typeTournoiId, int trancheId) {
		super();
		this.matchId = matchId;
		this.courtId = courtId;
		this.jourId = jourId;
		this.typeTournoiId = typeTournoiId;
		this.trancheId = trancheId;
	}

	public int getMatchId() {
		return matchId;
	}

	public int getCourtId() {
		return courtId;
	}

	public int getJourId() {
		return jourId;
	}

	public int getTypeTournoiId() {
		return typeTournoiId;
	}

	public int getTrancheId() {
		return trancheId;
	}

	@Override
	public String toString() {
		return "Match -> matchId : " + matchId + ", courtId : " + courtId + ", jourId : " + jourId
				+ ", typeTournoiId : " + typeTournoiId + ", trancheId : " + trancheId;
	}
	
	

}