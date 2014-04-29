import java.awt.Point;
import java.util.Set;

public class Rover {
	Point position;
	//char direction;
	Direction direction;
	int gridSizeX;
	int gridSizeY;
	Set<Point> obstacles;

	Rover(Point p, Direction d, int xgrid, int ygrid, Set<Point> o) {
		this.position = new Point(p);
		this.direction = d;
		this.gridSizeX = xgrid;
		this.gridSizeY = ygrid;
		this.obstacles = o;
	}

	public char getDirection() {
		return direction.toChar();
	}

	public int getNumberOfObstacles() {
		return obstacles.size();
	}

	public boolean executeCommands(String commandString) {
		// execute each of the commands in turn
		// if hits an obstacle, stop there and return false
		// else return true
		for (char c : commandString.toCharArray()) {
			boolean isSuccessfulMove = true;
			// process command
			switch (c) {
			case 'F':
				isSuccessfulMove = moveForward();
				break;
			case 'B':
				isSuccessfulMove = moveBackward();
				break;
			case 'L':
				turnLeft();
				break;
			case 'R':
				turnRight();
				break;
			}

			if (!isSuccessfulMove) {
				return false;
			}
		}
		return true; //if it gets here, all moves were successful
	}

	boolean moveForward() {
		// work out new position
		Point newPosition = new Point(position);
		newPosition = direction.moveForward(newPosition);
		
		wrapMovement(newPosition);
		return checkValidAndMove(newPosition);
	}

	private void wrapMovement(Point newPosition) {
		// wrap point to gridsize
		newPosition.x = wrapMovement(newPosition.x, gridSizeX);
		newPosition.y = wrapMovement(newPosition.y, gridSizeY);
	}

	int wrapMovement(int value, int maxValue) {
		// wrap to range >=0, < maxValue
		if (value < 0) {
			value = maxValue + value;
		} else if (value >= maxValue) {
			value = value % (maxValue); // make sure to reset to 0
		}
		return value;
	}

	boolean moveBackward() {
		Point newPosition = new Point(position);
		newPosition = direction.moveBackward(newPosition);

		wrapMovement(newPosition);
		return checkValidAndMove(newPosition);
	}

	boolean checkValidAndMove(Point np) {
		// if the move is valid (not into an obstacle), make it and return true
		// else return false
		if (!obstacles.contains(np)) { // if it's not in the set...
			position.setLocation(np.x, np.y);
			return true;
		}
		//System.out.println("Obstacle in the way");
		return false;
	}

	void turnLeft() {
		direction = direction.turnLeft();
	}

	void turnRight() {
		direction = direction.turnRight();
	}

	public Point getPosition() {
		return position;
	}
}
