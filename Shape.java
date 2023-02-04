/*
 * Curtis Lynn
 */
public class Shape implements Comparable<Shape>
{
	private String type;
	private double radius = 0, length = 0, width = 0, height = 0, base = 0, area = 0;
	private static final double PI = 3.14;
	
	public Shape(double aArea) 
	{
		type = "Seeker";
		area = aArea;
	}
	
	public Shape(String shape, double aRadius) 
	{
		type = shape;
		radius = aRadius;
		area = radius * radius * PI;
	}
	
	public Shape(String shape, double aLength, double aWidth) 
	{
		type = shape;
		length = aLength;
		width = aWidth;
		area = length * width;
	}
	
	public Shape(double aBase, String shape, double aHeight) 
	{
		type = shape;
		base = aBase;
		height = aHeight;
		area = (base / 2) * height;
	}
	
	public String toString() 
	{
		if(this.type.equalsIgnoreCase("Circle"))
			return ("Circle\t" + this.radius + "\n");
		else if(this.type.equalsIgnoreCase("Rectangle"))
			return("Rectangle\t" + this.length + "\t" + this.width + "\n");
		else if(this.type.equalsIgnoreCase("Right Triangle")) 
		{
			return("Right Triangle\t" + this.base + "\t" + this.height + "\n");
		}
		else
			return ("This tree is empty");
	}
	
	public String getType() 
	{
		return this.type;
	}
	
	public double getRadius() 
	{
		return this.radius;
	}
	
	public double getLength() 
	{
		return this.length;
	}
	
	public double getWidth() 
	{
		return this.width;
	}
	
	public double getBase() 
	{
		return this.base;
	}
	
	public double getHeight() 
	{
		return this.height;
	}
	
	public double getArea() 
	{
		return this.area;
	}
	
	public void setArea(double myArea) 
	{
		this.area = myArea;
	}
	
	public int compareTo(Shape other) 
	{
		if(other == null) 
		{
			return -1;
		}
		else if(this.area - other.area > 0) 
		{
			return 1;
		}
		else if(this.area - other.area < 0) 
		{
			return -1;
		}
		else if(this.type.compareTo(other.type) > 0) 
		{
			return 1;
		}
		else if(this.type.compareTo(other.type) < 0) 
		{
			return -1;
		}
		else 
		{
			return 0;
		}
	}
}
