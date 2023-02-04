/*
 * Written by Curtis Lynn 
 */
public class Process 
{
	private String name = "none";
	private double compTime = 0.0;
	
	public Process(String name, double time) //initializes data
	{
		setName(name);
		setCompletionTime(time);
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public double getCompletionTime() 
	{
		return this.compTime;
	}
	
	public void setName(String name) 
	{
		if(name.isBlank() || name == null)
			return;
		else
			this.name = name;
	}
	
	public void setCompletionTime(double time) 
	{
		if(time > 0)
			this.compTime = time;
		else
			this.compTime = 0;
	}
	
	public String toString() 
	{
		return ("Process Name: " + this.getName() + " Completion Time " + this.getCompletionTime());
	}
}
