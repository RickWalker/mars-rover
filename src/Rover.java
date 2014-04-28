import java.awt.Point;

public class Rover {
	Point position;
	char direction;

	Rover(Point p, char d) {
		this.position = new Point(p);
		this.direction = d;
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
		switch (this.direction) {
		case 'N':
			position.translate(0, 1);
			break;
		case 'S':
			position.translate(0, -1);
			break;
		case 'E':
			position.translate(1, 0);
			break;
		case 'W':
			position.translate(-1, 0);
			break;
		}
	}

	void moveBackward() {
		switch (this.direction) {
		case 'N':
			position.translate(0, -1);
			break;
		case 'S':
			position.translate(0, 1);
			break;
		case 'E':
			position.translate(-1, 0);
			break;
		case 'W':
			position.translate(1, 0);
			break;
		}
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
