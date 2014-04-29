import java.awt.Point;
import java.util.Set;

public class Rover {
	Point position;
	Direction direction;
	int gridSizeX;
	int gridSizeY;
	Set<Point> obstacles;

	Rover(Point p, Direction d, int xgrid, int ygrid, Set<Point> o) {
		//only called via RoverBuilder
		this.position = new Point(p);
		this.direction = d;
		this.gridSizeX = xgrid;
		this.gridSizeY = ygrid;
		this.obstacles = o;
	}
	
	public Point getPosition() {
		return position;
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
		return true; // if it gets here, all moves were successful
	}

	boolean moveForward() {
		//work out the predicted new position if move forward
		//wrap it, check it's valid, and if so update real position
		Point np = direction.moveForward(new Point(position));
		wrapMovement(np);
		
		boolean isValid = isValidPosition(np);
		if(isValid) position.setLocation(np.x, np.y);
		return isValid;
	}
	

	boolean moveBackward() {
		//work out the predicted new position if move backward
		//wrap it, check it's valid, and if so update real position
		Point np = direction.moveBackward(new Point(position));
		wrapMovement(np);
		
		boolean isValid = isValidPosition(np);
		if(isValid) position.setLocation(np.x, np.y);
		return isValid;
	}

	private void wrapMovement(Point newPosition) {
		// wrap point to gridsize
		newPosition.x = wrapValue(newPosition.x, gridSizeX);
		newPosition.y = wrapValue(newPosition.y, gridSizeY);
	}

	private int wrapValue(int value, int maxValue) {
		// wrap to range >=0, < maxValue
		if (value < 0) {
			value = maxValue + value;
		} else {
			value = value % (maxValue); 
		}
		
		return value;
	}
	
	private boolean isValidPosition(Point np){
		//can the rover move here, or is there an obstacle?
		return !obstacles.contains(np);
	}

	void turnLeft() {
		direction = direction.turnLeft();
	}

	void turnRight() {
		direction = direction.turnRight();
	}

}
