package bowling;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ComputeBowlingScore_parseScoreInRoundsListUTest {

	private ComputeBowlingScoreImpl computeBowlingScore;

	@Before
	public void setup() {
		computeBowlingScore = new ComputeBowlingScoreImpl();
	}

	@Test
	public void parseScoreInRoundsList_WithEverythingMissed_ShouldReturn10Round() {
		// setup

		// action
		List<Round> roundsList = computeBowlingScore
				.parseScoreInRoundsList("--------------------");

		// assert
		Assert.assertEquals(10, roundsList.size());
	}

	@Test
	public void parseScoreInRoundsList_WithAStrikeInTheMiddle_ShouldReturn10Rounds() {
		// setup

		// action
		List<Round> roundsList = computeBowlingScore
				.parseScoreInRoundsList("------X------------");

		// assert
		Assert.assertEquals(10, roundsList.size());
	}

	@Test
	public void parseScoreInRoundsList_With2StrikeInARowInTheMiddle_ShouldReturn10Rounds() {
		// setup

		// action
		List<Round> roundsList = computeBowlingScore
				.parseScoreInRoundsList("------XX----------");

		// assert
		Assert.assertEquals(10, roundsList.size());
	}

	@Test
	public void parseScoreInRoundsList_With2SpareInTheMiddle_ShouldReturn10Rounds() {
		// setup

		// action
		List<Round> roundsList = computeBowlingScore
				.parseScoreInRoundsList("------4/-----/------");

		// assert
		Assert.assertEquals(10, roundsList.size());
	}
}