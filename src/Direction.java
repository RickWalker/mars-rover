import java.awt.Point;

public interface Direction {

	Direction turnLeft();
	Direction turnRight();
	Point moveForward(Point p);
	Point moveBackward(Point p);
	
	char toChar();
	
}
