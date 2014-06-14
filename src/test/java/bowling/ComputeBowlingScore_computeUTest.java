package bowling;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@SuppressWarnings({"unused", "rawtypes"})
@RunWith(Parameterized.class)
public class ComputeBowlingScore_computeUTest {

	private ComputeBowlingScore computeBowlingScore;
	
	private String testDescription;
	private String inputResult;
	private int expectedScore;
	
	public ComputeBowlingScore_computeUTest(String testDescription, String inputResult, int expectedScore) {
		this.testDescription = testDescription;
		this.inputResult = inputResult;
		this.expectedScore = expectedScore;
	}

	@Before
	public void setup() {
		computeBowlingScore = new ComputeBowlingScoreImpl();
	}
	
	@Parameters(name = "{0}")
    public static Collection parameters() {
        return Arrays.asList(new Object[][] {
                { "With everything missed Should return zero", "--------------------", Integer.valueOf(0)},
                { "With one pin down each time should return 20", "11111111111111111111", Integer.valueOf(20)},
                { "With one spare all pins on second shoot should return 10", "-------/------------", Integer.valueOf(10)},
                { "With one spare in two times should return 10", "------4/------------", Integer.valueOf(10)},
                { "With two spare should return 20", "------4/-----/------", Integer.valueOf(20)},
                { "With one strike should return 10", "--------X----------", Integer.valueOf(10)},
                { "With two strike in row should return 30", "------XX----------", Integer.valueOf(30)},
                { "With one spare followed by strike should return 30", "--------4/X--------", Integer.valueOf(30)},
                { "With Spare Bonus should return 150", "5/5/5/5/5/5/5/5/5/5/5", Integer.valueOf(150)},
                { "With perfect game should return 300", "XXXXXXXXXXXX", Integer.valueOf(300)}
        });
	}

	@Test
	public void computeScore() {
		// Test
		int computedScore = computeBowlingScore.compute(inputResult);

		// assert
		Assert.assertEquals(expectedScore, computedScore);
	}
	
}