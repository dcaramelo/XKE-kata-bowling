package bowling;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComputeBowlingScoreImpl implements ComputeBowlingScore {

	public int compute(String allScores) {

		int score = 0;
		
		List<Shoot> convert = new FrameConvector(allScores).convert();
		List<Shoot> dataEnrichment = dataEnrichment(convert);
		List<Round> reduce = reduce(dataEnrichment);
		
		for(Round round : reduce) {
			score += round.computeScore();
		}

		return score;
	}
	
	private List<Shoot> dataEnrichment(List<Shoot> shoots) {
		
		List<Shoot> result = new ArrayList<Shoot>();
		
		for (int i=0;i < shoots.size(); i++) {
			Shoot shoot = shoots.get(i);
			if (shoot.getType() == Type.STRIKE) {
				shoot.addBonus(i+1 < shoots.size() ? shoots.get(i+1).getScore() : 0);
				shoot.addBonus(i+2 < shoots.size() ? shoots.get(i+2).getScore() : 0);
			} else if (shoot.getType() == Type.SPARE) {
				shoot.addBonus(i+1 < shoots.size() ? shoots.get(i+1).getScore() : 0);
			}
			result.add(shoot);
		}
		
		return result;
	}
	
	private List<Round> reduce(List<Shoot> shoots) {
		
		List<Round> result = new ArrayList<Round>();
		Iterator<Shoot> iterator = shoots.iterator();
		
		while (iterator.hasNext() && result.size() < 10) {
			Shoot shoot = iterator.next();
			
			Round round = new Round();
			if (shoot.getType() == Type.STRIKE) {
				round.add(shoot);
			} else {
				round.add(shoot);
				if (iterator.hasNext()) {
					round.add(iterator.next());
				}
			}
			result.add(round);
		}
		
		return result;
	}
}