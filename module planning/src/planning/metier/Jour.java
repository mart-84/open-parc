/***********************************************************************
 * Module:  Journee.java
 * Author:  P2003521
 * Purpose: Defines the Class Journee
 ***********************************************************************/

package planning.metier;

import java.util.*;

public class Jour {
	private int jourId;
	private Date date;
	
	public Jour(int jourId, Date date) {
		super();
		this.jourId = jourId;
		this.date = date;
	}
	
	public int getJourId() {
		return jourId;
	}
	
	public Date getDate() {
		return date;
	}

}