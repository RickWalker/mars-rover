import java.awt.Point;


public class North implements Direction {

	@Override
	public Direction turnLeft() {
		return new West();
	}

	@Override
	public Direction turnRight() {
		return new East();
	}

	@Override
	public Point moveForward(Point p) {
		p.translate(0, 1);
		return p;
	}

	@Override
	public Point moveBackward(Point p) {
		p.translate(0, -1);
		return p;
	}
	
	public char toChar(){
		return 'N';
	}

}
