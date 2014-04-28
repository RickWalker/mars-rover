import static org.junit.Assert.*;
import java.awt.Point;
import java.util.Set;
import java.util.HashSet;

import org.junit.Test;

public class TestMovementWithObstacles {

	@Test
	public void shouldNotChangePositionWhenMoveForwardIntoObstacle() {
		Set<Point> testObstacles = new HashSet<Point>();
		// create some obstacles
		testObstacles.add(new Point(0, 1));
		Rover testRover = new RoverBuilder().withObstacles(testObstacles)
				.build();

		boolean moveSuccessful = testRover.executeCommands("F");

		assertEquals(
				"Rover expected to be at 0 0 N, is at "
						+ testRover.getPosition() + " "
						+ testRover.getDirection() + " with moveSuccessful at "
						+ moveSuccessful, new Point(0, 0),
				testRover.getPosition());

		assertFalse("Move successful result expected was false", moveSuccessful);
	}
	
	@Test
	public void shouldNotChangePositionWhenMoveBackwardIntoObstacle(){
		Set<Point> testObstacles = new HashSet<Point>();
		// create some obstacles
		testObstacles.add(new Point(0, 0));
		Rover testRover = new RoverBuilder().withPosition(0,1).withObstacles(testObstacles)
				.build();

		boolean moveSuccessful = testRover.executeCommands("B");

		assertFalse("Move successful result expected was false", moveSuccessful);
		assertEquals(
				"Rover expected to be at 0 1 N, is at "
						+ testRover.getPosition() + " "
						+ testRover.getDirection() + " with moveSuccessful at "
						+ moveSuccessful, new Point(0, 1),
				testRover.getPosition());

		
	}
	
	@Test
	public void shouldMoveToLastPossiblePointWhenMovementStringLeadsToObstacle(){
		Set<Point> testObstacles = new HashSet<Point>();
		// create some obstacles
		testObstacles.add(new Point(2, 2));
		
		Rover testRover = new RoverBuilder().withObstacles(testObstacles).build();
		
		boolean moveSuccessful = testRover.executeCommands("FFRFF");
		
		assertFalse("Move successful result expected was false", moveSuccessful);
		
		assertEquals(
				"Rover expected to be at 1 2 E, is at "
						+ testRover.getPosition() + " "
						+ testRover.getDirection() + " with moveSuccessful at "
						+ moveSuccessful, new Point(1, 2),
				testRover.getPosition());

		
	}

}
