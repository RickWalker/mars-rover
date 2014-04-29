import java.awt.Point;


public class East implements Direction {

	@Override
	public Direction turnLeft() {
		return new North();
	}

	@Override
	public Direction turnRight() {
		// TODO Auto-generated method stub
		return new South();
	}

	@Override
	public Point moveForward(Point p) {
		p.translate(1, 0);
		return p;
	}

	@Override
	public Point moveBackward(Point p) {
		p.translate(-1, 0);
		return p;
	}
	
	public char toChar(){
		return 'E';
	}

}
