import static org.junit.Assert.*;

import org.junit.Test;
import java.awt.Point;

public class TestRover {

	// simple creation tests first

	@Test
	public void WhenCreateRoverAt00North_ThenPositionDirectionAreCorrectAt00N() {
		Rover testRover = new RoverBuilder().withPosition(0, 0)
				.withDirection('N').build();
		assertEquals("Position of new rover should be 0, 0", new Point(0, 0),
				testRover.getPosition());
		assertEquals("Direction of new rover should be N", 'N',
				testRover.getDirection());
	}

	@Test
	public void WhenCreateRoverAt15North_ThenPositionDirectionAreCorrectAt15N() {
		Rover testRover = new RoverBuilder().withPosition(1, 5)
				.withDirection('N').build();
		assertEquals("Position of new rover should be 1, 5", new Point(1, 5),
				testRover.getPosition());
		assertEquals("Direction of new rover should be N", 'N',
				testRover.getDirection());
	}

	// then some movement ones

	@Test
	public void WhenMoveForwardFrom00N_ThenPositionDirectionAreCorrectAt01N() {
		Rover testRover = new RoverBuilder().withPosition(0, 0)
				.withDirection('N').build();
		testRover.executeCommands("F");
		assertEquals(
				"Position of rover after moving forwards from 0, 0 N should be 0, 1",
				new Point(0, 1), testRover.getPosition());
		assertEquals(
				"Direction of rover after moving forwards from 0, 0 N should be N",
				'N', testRover.getDirection());
	}

	@Test
	public void WhenMoveBackwardFrom01N_ThenPositionDirectionAreCorrectAt00N() {
		Rover testRover = new RoverBuilder().withPosition(0, 1)
				.withDirection('N').build();
		testRover.executeCommands("B");
		assertEquals(
				"Position of rover after moving backwards from 0, 1 N should be 0, 0",
				new Point(0, 0), testRover.getPosition());
		assertEquals(
				"Direction of rover after moving backwards from 0, 1 N should be N",
				'N', testRover.getDirection());
	}

	// then some turning ones
	@Test
	public void WhenTurnLeftFrom00N_ThenNewPositionDirectionIs00W() {
		Rover testRover = new RoverBuilder().withPosition(0, 0)
				.withDirection('N').build();
		testRover.executeCommands("L");

		assertEquals(
				"Position of rover after turning left from 0, 0 N should be 0, 0",
				new Point(0, 0), testRover.getPosition());
		assertEquals(
				"Direction of rover after turning left from 0, 0 N should be W",
				'W', testRover.getDirection());

	}

	@Test
	public void WhenTurnLeftFrom00W_ThenNewPositionDirectionIs00S() {
		Rover testRover = new RoverBuilder().withPosition(0, 0)
				.withDirection('W').build();
		testRover.executeCommands("L");

		assertEquals(
				"Position of rover after turning left from 0, 0 W should be 0, 0",
				new Point(0, 0), testRover.getPosition());
		assertEquals(
				"Direction of rover after turning left from 0, 0 W should be S",
				'S', testRover.getDirection());
	}

	@Test
	public void WhenTurnLeftFrom00S_ThenNewPositionDirectionIs00E() {
		Rover testRover = new RoverBuilder().withPosition(0, 0)
				.withDirection('S').build();
		testRover.executeCommands("L");

		assertEquals(
				"Position of rover after turning left from 0, 0 S should be 0, 0",
				new Point(0, 0), testRover.getPosition());
		assertEquals(
				"Direction of rover after turning left from 0, 0 S should be E",
				'E', testRover.getDirection());
	}

	@Test
	public void WhenTurnLeftFrom00E_ThenNewPositionDirectionIs00N() {
		Rover testRover = new RoverBuilder().withPosition(0, 0)
				.withDirection('E').build();
		testRover.executeCommands("L");

		assertEquals(
				"Position of rover after turning left from 0, 0 E should be 0, 0",
				new Point(0, 0), testRover.getPosition());
		assertEquals(
				"Direction of rover after turning left from 0, 0 E should be N",
				'N', testRover.getDirection());
	}

	@Test
	public void WhenTurnRightFrom00N_ThenNewPositionDirectionIs00E() {
		Rover testRover = new RoverBuilder().withPosition(0, 0)
				.withDirection('N').build();
		testRover.executeCommands("R");

		assertEquals(
				"Position of rover after turning right from 0, 0 N should be 0, 0",
				new Point(0, 0), testRover.getPosition());
		assertEquals(
				"Direction of rover after turning right from 0, 0 N should be E",
				'E', testRover.getDirection());

	}

	@Test
	public void WhenTurnRightFrom00E_ThenNewPositionDirectionIs00S() {
		Rover testRover = new RoverBuilder().withPosition(0, 0)
				.withDirection('E').build();
		testRover.executeCommands("R");

		assertEquals(
				"Position of rover after turning right from 0, 0 E should be 0, 0",
				new Point(0, 0), testRover.getPosition());
		assertEquals(
				"Direction of rover after turning right from 0, 0 E should be S",
				'S', testRover.getDirection());
	}

	@Test
	public void WhenTurnRightFrom00S_ThenNewPositionDirectionIs00W() {
		Rover testRover = new RoverBuilder().withPosition(0, 0)
				.withDirection('S').build();
		
		testRover.executeCommands("R");

		assertEquals(
				"Position of rover after turning right from 0, 0 S should be 0, 0",
				new Point(0, 0), testRover.getPosition());
		assertEquals(
				"Direction of rover after turning right from 0, 0 S should be W",
				'W', testRover.getDirection());
	}

	@Test
	public void WhenTurnRightFrom00W_ThenNewPositionDirectionIs00N() {
		Rover testRover = new RoverBuilder().withPosition(0, 0)
				.withDirection('W').build();
		testRover.executeCommands("R");

		assertEquals(
				"Position of rover after turning right from 0, 0 W should be 0, 0",
				new Point(0, 0), testRover.getPosition());
		assertEquals(
				"Direction of rover after turning right from 0, 0 W should be N",
				'N', testRover.getDirection());
	}

	// now, some combo tests
	@Test
	public void WhenFFRFF_From_00N_ThenPositionDirectionShouldBe22E() {
		Rover testRover = new RoverBuilder().withPosition(0, 0)
				.withDirection('N').build();
		testRover.executeCommands("FFRFF");

		assertEquals("Rover from 00N after FFRFF should be at position 2,2",
				new Point(2, 2), testRover.getPosition());
		assertEquals("Rover from 00N after FFRFF should be pointing E", 'E',
				testRover.getDirection());
	}

}
