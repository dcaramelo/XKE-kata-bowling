package bowling;

import java.util.ArrayList;
import java.util.List;

public class Round {
	
	private List<Shoot> shoots = new ArrayList<Shoot>(22);
	
	public void add(Shoot lance) {
		shoots.add(lance);
	}
	
	public int computeScore() {
		
		Shoot firstShoot = shoots.get(0);
		
		if (shoots.size() > 1) {
			Shoot secondShoot = shoots.get(1);
			if (secondShoot.getType() == Type.SPARE) {
				return secondShoot.getFinalScore();
			} else {
				return firstShoot.getFinalScore() + secondShoot.getFinalScore();
			}
		}
		
		return firstShoot.getFinalScore();
	}
}
