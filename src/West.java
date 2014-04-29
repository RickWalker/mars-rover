import java.awt.Point;


public class West implements Direction {

	@Override
	public Direction turnLeft() {
		return new South();
	}

	@Override
	public Direction turnRight() {
		return new North();
	}

	@Override
	public Point moveForward(Point p) {
		p.translate(-1, 0);
		return p;
	}

	@Override
	public Point moveBackward(Point p) {
		p.translate(1, 0);
		return p;
	}
	
	public char toChar(){
		return 'W';
	}

}
