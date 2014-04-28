import static org.junit.Assert.*;

import org.junit.Test;
import java.awt.Point;

public class TestRoverMovementAndTurning {

	// simple creation tests first
	// probably don't need this, but in case I did something dumb
	@Test
	public void shouldPickUpZeroConstructorPositionAndDirection() {
		Rover testRover = new RoverBuilder().withPosition(0, 0)
				.withDirection('N').build();
		assertEquals("Position of new rover should be 0, 0", new Point(0, 0),
				testRover.getPosition());
		assertEquals("Direction of new rover should be N", 'N',
				testRover.getDirection());
	}

	@Test
	public void shouldPickUpNonZeroConstructorPositionAndDirection() {
		Rover testRover = new RoverBuilder().withPosition(1, 5)
				.withDirection('N').build();
		assertEquals("Position of new rover should be 1, 5", new Point(1, 5),
				testRover.getPosition());
		assertEquals("Direction of new rover should be N", 'N',
				testRover.getDirection());
	}

	// then some movement ones

	@Test
	public void shouldChangePositionWhenMovingForwardNorth() {
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
	public void shouldChangePositionWhenMovingBackwardsNorth() {
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
	public void shouldChangeDirectionAndNotMoveWhenTurningLeftFromNorth() {
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
	public void shouldChangeDirectionAndNotMoveWhenTurningLeftFromWest() {
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
	public void shouldChangeDirectionAndNotMoveWhenTurningLeftFromSouth() {
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
	public void shouldChangeDirectionAndNotMoveWhenTurningLeftFromEast() {
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
	public void shouldChangeDirectionAndNotMoveWhenTurningRightFromNorth() {
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
	public void shouldChangeDirectionAndNotMoveWhenTurningRightFromEast() {
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
	public void shouldChangeDirectionAndNotMoveWhenTurningRightFromSouth() {
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
	public void shouldChangeDirectionAndNotMoveWhenTurningRightFromWest() {
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
	public void shouldMoveTo22EWhenFFRFF_From_00N() {
		Rover testRover = new RoverBuilder().withPosition(0, 0)
				.withDirection('N').build();
		testRover.executeCommands("FFRFF");

		assertEquals("Rover from 00N after FFRFF should be at position 2,2",
				new Point(2, 2), testRover.getPosition());
		assertEquals("Rover from 00N after FFRFF should be pointing E", 'E',
				testRover.getDirection());
	}



}
