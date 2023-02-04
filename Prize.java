/*
 * Written By Curtis Lynn
 */
public class Prize {
	private String name;
	private int value;
	public boolean beenSelected = false;
	
	public Prize(int value, String name) 
	{
		setValue(value);
		setName(name);
	}
	public void Reset() 
	{
		beenSelected = false;
	}
	public void setValue(int value) 
	{
		this.value = value;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public int getValue() 
	{
		return this.value;
	}
}
