package planning.vue;

import java.awt.Dimension;
import java.awt.Point;

public class MatchComponentData {
	private int id;
	private Point point;
	private Dimension dim;
	
	public MatchComponentData(int id, Point point, Dimension dim) {
		super();
		this.id = id;
		this.point = point;
		this.dim = dim;
	}

	public void setUpMatchComponent(MatchComponent matchC) {
		matchC.setLocation(point);
		matchC.setSize(dim);
		matchC.setIdMatch(id);
		matchC.createPanel();
	}
	
	
}
