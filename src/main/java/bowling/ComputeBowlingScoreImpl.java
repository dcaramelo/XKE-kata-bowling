package bowling;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComputeBowlingScoreImpl implements ComputeBowlingScore {

	public int compute(String allScores) {

		int score = 0;
		List<Round> rounds = parseScoreInRoundsList(allScores);

		for (int roundNumber = 0; roundNumber < 10; roundNumber++) {

			Round currentRound = rounds.get(roundNumber);
			score = score + currentRound.computeRoundScore();
		}
		return score;
	}

	public List<Round> parseScoreInRoundsList(String allScores) {
		List<Round> rounds = new ArrayList<Round>();

		List<Character> scoreList = createIteratorOnScoresChars(allScores);
		Iterator<Character> it = scoreList.iterator();

		int throwNumber = 0;
		while (it.hasNext() && throwNumber < 10) {

			Character currentThrow = it.next();
			int position = currentThrow == 'X' ? throwNumber : throwNumber * 2;
			Character nextThrow = position + 1 < scoreList.size() ? scoreList.get(position + 1) : '-';
			Character afterNextThrow = position + 2 < scoreList.size() ? scoreList.get(position + 2) : '-';
			Round round = new Round(nextThrow, afterNextThrow); 
			throwNumber++;

			switch (currentThrow) {
			case 'X':
				round.beAStrike();
				break;

			default:
				Character next = it.next();
				switch (next) {
				case '/':
					round.beASpare();
					break;
				case '-': 
				default:
					round.beNormal(currentThrow, next);
					break;
				}

				break;
			}
			rounds.add(round);

		}
		return rounds;
	}

	private List<Character> createIteratorOnScoresChars(String allScores) {
		List<Character> scoreList = new ArrayList<Character>();
		char[] scoresArray = allScores.toCharArray();
		
		for (char scoreInChar : scoresArray) {
			scoreList.add(new Character(scoreInChar));
		}

		return scoreList;
	}
}