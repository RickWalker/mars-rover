import static org.junit.Assert.*;

import org.junit.Test;
import java.awt.Point;

public class TestRover {

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

	// now, test wrapping around grid
	// y values first
	@Test
	public void shouldWrapTo00NWhenFFFFOn5x5Grid() {
		Rover testRover = new RoverBuilder().withPosition(0, 0)
				.withDirection('N').withGridSize(5, 5).build();

		testRover.executeCommands("FFFFF");

		assertEquals(
				"Rover from 0,0N on 5x5 grid should be at 0 0 N after FFFFF, is at "
						+ testRover.getPosition(), new Point(0, 0),
				testRover.getPosition());
	}

	@Test
	public void shouldWrapOnGridYAxisMaxWhenMovingBackwardsSouth() {
		Rover testRover = new RoverBuilder().withPosition(0, 9)
				.withDirection('S').build();

		testRover.executeCommands("B");

		assertEquals(
				"Rover at 0 9 S on 10 x 10 grid should be at 0, 0 after B, is at "
						+ testRover.getPosition(), new Point(0, 0),
				testRover.getPosition());
	}

	@Test
	public void shouldWrapOnGridYAxisMinWhenMovingForwardsSouth() {
		Rover testRover = new RoverBuilder().withDirection('S').build();

		testRover.executeCommands("F");

		assertEquals(
				"Rover at 0 0 S on 10 x 10 grid should be at 0, 9 after F, is at "
						+ testRover.getPosition(), new Point(0, 9),
				testRover.getPosition());
	}

	@Test
	public void shouldWrapOnGridYAxisMaxWhenMovingForwardsNorth() {
		Rover testRover = new RoverBuilder().withPosition(0, 9).build();

		testRover.executeCommands("F");

		assertEquals(
				"Rover at 0 9 N on 10 x 10 grid should be at 0, 0 after F, is at "
						+ testRover.getPosition(), new Point(0, 0),
				testRover.getPosition());
	}

	@Test
	public void shouldWrapOnGridYAxisMinWhenMovingBackwardsNorth() {
		Rover testRover = new RoverBuilder().build();

		testRover.executeCommands("B");

		assertEquals(
				"Rover at 0 0 N on 10 x 10 grid should be at 0, 9 after B, is at "
						+ testRover.getPosition(), new Point(0, 9),
				testRover.getPosition());
	}

	// then x values
	@Test
	public void shouldWrapGridOnXAxisMaxWhenMovingForwardsEast() {
		Rover testRover = new RoverBuilder().withPosition(9, 0)
				.withDirection('E').build();

		testRover.executeCommands("F");

		assertEquals(
				"Rover at 9 0 E on 10 x 10 grid should be at 0, 0 after F, is at "
						+ testRover.getPosition(), new Point(0, 0),
				testRover.getPosition());
	}

	@Test
	public void shouldWrapGridOnXAxisMaxWhenMovingBackwardsWest() {
		Rover testRover = new RoverBuilder().withPosition(9, 0)
				.withDirection('W').build();

		testRover.executeCommands("B");

		assertEquals(
				"Rover at 9 0 W on 10 x 10 grid should be at 0, 0 after B, is at "
						+ testRover.getPosition(), new Point(0, 0),
				testRover.getPosition());
	}

	@Test
	public void shouldWrapGridOnXAxisMinWhenMovingForwardsWest() {
		Rover testRover = new RoverBuilder().withPosition(0, 0)
				.withDirection('W').build();

		testRover.executeCommands("F");

		assertEquals(
				"Rover at 0 0 W on 10 x 10 grid should be at 9, 0 after F, is at "
						+ testRover.getPosition(), new Point(9, 0),
				testRover.getPosition());
	}

	@Test
	public void shouldWrapGridOnXAxisMinWhenMovingBackwardsEast() {
		Rover testRover = new RoverBuilder().withPosition(0, 0)
				.withDirection('E').build();

		testRover.executeCommands("B");

		assertEquals(
				"Rover at 0 0 E on 10 x 10 grid should be at 9, 0 after B, is at "
						+ testRover.getPosition(), new Point(9, 0),
				testRover.getPosition());
	}

}
