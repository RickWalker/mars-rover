import java.awt.Point;

public class Rover {
	Point position;
	char direction;
	int gridSizeX;
	int gridSizeY;

	Rover(Point p, char d, int xgrid, int ygrid) {
		this.position = new Point(p);
		this.direction = d;
		this.gridSizeX = xgrid;
		this.gridSizeY = ygrid;
	}

	public char getDirection() {
		return direction;
	}

	public void executeCommands(String commandString) {
		// execute each of the commands in turn
		for (char c : commandString.toCharArray()) {
			// process command
			switch (c) {
			case 'F':
				moveForward();
				break;
			case 'B':
				moveBackward();
				break;
			case 'L':
				turnLeft();
				break;
			case 'R':
				turnRight();
				break;
			}
		}
	}

	void moveForward() {
		// work out new position
		Point newPosition = new Point(position);
		switch (this.direction) {
		case 'N':
			newPosition.translate(0, 1);
			break;
		case 'S':
			newPosition.translate(0, -1);
			break;
		case 'E':
			newPosition.translate(1, 0);
			break;
		case 'W':
			newPosition.translate(-1, 0);
			break;
		}
		wrapMovement(newPosition);
		position.setLocation(newPosition.x, newPosition.y);
	}

	private void wrapMovement(Point newPosition) {
		newPosition.x = wrapMovement(newPosition.x, gridSizeX);
		newPosition.y = wrapMovement(newPosition.y, gridSizeY);		
	}

	int wrapMovement(int value, int maxValue) {
		if (value < 0) {
			value = maxValue + value;
		} else if (value >= maxValue) {
			value = value % (maxValue); // make sure to reset to 0
		}
		return value;
	}

	void moveBackward() {
		Point newPosition = new Point(position);
		switch (this.direction) {
		case 'N':
			newPosition.translate(0, -1);
			break;
		case 'S':
			newPosition.translate(0, 1);
			break;
		case 'E':
			newPosition.translate(-1, 0);
			break;
		case 'W':
			newPosition.translate(1, 0);
			break;
		}
		
		wrapMovement(newPosition);
		position.setLocation(newPosition.x, newPosition.y);
	}

	void turnLeft() {
		switch (this.direction) {
		case 'N':
			this.direction = 'W';
			break;
		case 'W':
			this.direction = 'S';
			break;
		case 'S':
			this.direction = 'E';
			break;
		case 'E':
			this.direction = 'N';
			break;
		}
	}

	void turnRight() {
		switch (this.direction) {
		case 'N':
			this.direction = 'E';
			break;
		case 'E':
			this.direction = 'S';
			break;
		case 'S':
			this.direction = 'W';
			break;
		case 'W':
			this.direction = 'N';
			break;
		}
	}

	public Point getPosition() {
		return position;
	}
}
