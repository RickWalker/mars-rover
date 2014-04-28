import java.awt.Point;

//builder pattern for Rover, to avoid having to keep refactoring tests as well as code

public class RoverBuilder {
	Point position = new Point(0, 0);
	char direction = 'N';

	public RoverBuilder withPosition(int x, int y) {
		this.position = new Point(x, y);
		return this;
	}

	public RoverBuilder withDirection(char c) {
		this.direction = c;
		return this;
	}
	
	public Rover build(){
			return new Rover(position, direction);
	}

}
