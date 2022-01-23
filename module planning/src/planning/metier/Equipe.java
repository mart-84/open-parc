package planning.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipe {

	private int equipeId;
	private Joueur joueur1;
	private Joueur joueur2;

	public Equipe(int equipeId, Joueur joueur1, Joueur joueur2) {
		super();
		this.equipeId = equipeId;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}

	public int getEquipeId() {
		return equipeId;
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public List<Joueur> getJoueurs() {
		List<Joueur> list = new ArrayList<Joueur>();
		list.add(joueur1);
		list.add(joueur2);
		return list;
	}

	public String toString() {
		return joueur1 + "/" + joueur2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipe other = (Equipe) obj;
		return equipeId == other.equipeId;
	}
	
	
}
