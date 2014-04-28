import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

//builder pattern for Rover, to avoid having to keep refactoring tests as well as code

public class RoverBuilder {
	// default values for tests
	Point position = new Point(0, 0);
	char direction = 'N';
	int gridSizeX = 10;
	int gridSizeY = 10;
	Set<Point> obstacles = new HashSet<Point>();

	public RoverBuilder withPosition(int x, int y) {
		this.position = new Point(x, y);
		return this;
	}

	public RoverBuilder withDirection(char c) {
		this.direction = c;
		return this;
	}

	public RoverBuilder withGridSize(int a, int b) {
		gridSizeX = a;
		gridSizeY = b;
		return this;
	}
	
	public RoverBuilder withObstacles(Set<Point> o){
		this.obstacles = o;
		return this;
	}

	public Rover build() {
		return new Rover(position, direction, gridSizeX, gridSizeY, obstacles);
	}

}
