package bowling;

import java.util.List;

public class ComputeBowlingScoreImpl implements ComputeBowlingScore {

	public int compute(String allScores) {
		List<Shoot> shoots = new ShootConvector(allScores).convert();

		return new Frame(shoots).computeScore();
	}
	
}