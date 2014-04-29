import java.awt.Point;


public class South implements Direction {

	@Override
	public Direction turnLeft() {
		return new East();
	}

	@Override
	public Direction turnRight() {
		return new West();
	}

	@Override
	public Point moveForward(Point p) {
		p.translate(0, -1);
		return p;
	}

	@Override
	public Point moveBackward(Point p) {
		p.translate(0, 1);
		return p;
	}
	
	public char toChar(){
		return 'S';
	}

}
