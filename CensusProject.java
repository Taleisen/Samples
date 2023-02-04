/*
 * Written By Curtis Lynn
 */
package WeekOne;

public class CensusProject {

	public static void main(String[] args) 
	{
		int secondPerYear = 31536000, births, deaths, immigrants, startingPopulation = 312032486, projectedPopulation = startingPopulation;
		
		for(int i = 1; i <= 5; i++) 
		{
			births = (secondPerYear * i)/7;
			deaths = (secondPerYear * i)/13;
			immigrants = (secondPerYear * i)/45;
			projectedPopulation = startingPopulation + births + immigrants - deaths;
			System.out.printf("The projected population after %d years is %d%n", i, projectedPopulation);
		}
	}

}
