package users;

public class Rectangle {
	private int height;
	private int width;
	private String colour;
	private Class class1;
	
	public Rectangle(int height, int width, String colour) {
		super();
		this.height = height;
		this.width = width;
		this.colour = colour;
	}
	
	public Rectangle(int height, int width, String colour, Class class1) {
		super();
		this.height = height;
		this.width = width;
		this.colour = colour;
		this.class1 = class1;
	}

	public Rectangle() {
		super();
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}

	

	@Override
	public String toString() {
		return "Rectangle [height=" + height + ", width=" + width + ", colour=" + colour + ", class1=" + class1 + "]";
	}

	public Class getClass1() {
		return class1;
	}

	public void setClass1(Class class1) {
		this.class1 = class1;
	}
	
}
