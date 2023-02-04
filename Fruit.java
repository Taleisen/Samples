/*
 * Curtis Lynn
 */
public class Fruit implements Comparable<Fruit> 
{
	private double weight = -1, defaultWeight = 1.0;
	private String type, defaultType = "apple";
	
	public Fruit() 
	{
		this.type = defaultType;
		this.weight = defaultWeight;
	}
	
	public Fruit(String type, double weight) 
	{
		this.type = verifyType(type);
		this.weight = verifyWeight(weight);
	}
	
	public String getType() 
	{
		return this.type;
	}
	
	public double getWeight() 
	{
		return this.weight;
	}
	
	public void setWeight(double input) 
	{
		this.weight = verifyWeight(input);
	}
	
	public void setType(String input) 
	{
		this.type = verifyType(input);
	}
	
	private String verifyType(String input) 
	{
		if(input.equalsIgnoreCase("apple") || input.equalsIgnoreCase("orange") || input.equalsIgnoreCase("banana") || input.equalsIgnoreCase("kiwi") || input.equalsIgnoreCase("tomato"))
			return input;
		else if(this.getType() == null)
			return defaultType;
		else
			return this.getType();
	}
	
	private double verifyWeight(double input) 
	{
		if(input > 0)
			return input;
		else if(this.getWeight() <= 0)
			return defaultWeight;
		else
			return this.getWeight();
	}
	
	public String toString() 
	{
		return ("Type: " + type + " Weight: " + weight);
	}
	
	public int compareTo(Fruit other) 
	{
		if(other == null) 
		{
			return -1;
		}
		else if(this.weight - other.weight > 0) 
		{
			return 1;
		}
		else if(this.weight - other.weight < 0) 
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
