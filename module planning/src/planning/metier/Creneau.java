package planning.metier;

public class Creneau {
	private Jour jour;
	private TrancheHoraire tranche;
	private Court court;

	public Creneau(Jour jour, TrancheHoraire tranche, Court court) {
		super();
		this.jour = jour;
		this.tranche = tranche;
		this.court = court;
	}

	public Jour getJour() {
		return jour;
	}

	public TrancheHoraire getTranche() {
		return tranche;
	}

	public Court getCourt() {
		return court;
	}

	@Override
	public String toString() {
		return "Creneau -> jour : " + jour + ", tranche : " + tranche + ", court : " + court;
	}

}
