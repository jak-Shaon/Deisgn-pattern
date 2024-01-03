interface Shape {
	void draw();
}

class Rectangle implements Shape {

	@Override public void draw()
	{
		System.out.println("Shape: Rectangle");
	}
}

abstract class ShapeDecorator implements Shape
{
	protected Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape)
	{
		this.decoratedShape = decoratedShape;
	}
	public void draw()
    { 
        decoratedShape.draw(); 
    }
}

// Concrete class extending the abstract class
class RedShapeDecorator extends ShapeDecorator
{
	public RedShapeDecorator(Shape decoratedShape)
	{
		super(decoratedShape);
	}

	private void setRedBorder(Shape decoratedShape)
	{
	// Display message whenever function is called 
		System.out.println("Border Color: Red");
	}
    
    @Override
    public void draw()
	{
		decoratedShape.draw();
		setRedBorder(decoratedShape);
	}
}

// Main class
class DecoratorPatternDemo
{
	public static void main(String[] args)
	{
		Shape rectangle = new Rectangle();
		Shape redRectangle = new RedShapeDecorator(new Rectangle());

		System.out.println("Rectangle with normal border");
		rectangle.draw();

		System.out.println("\nRectangle of red border");
		redRectangle.draw();
		
	}
}
