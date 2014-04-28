import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;


public class GridWrappingTests {

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
