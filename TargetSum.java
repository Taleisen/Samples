/*
 * Written By Curtis Lynn
 */
package Curtis_Lynn;
import java.util.*;

public class TargetSum {

	
	public static void main(String[] args) 
	{
		ArrayList<Integer> candidateList = new ArrayList<>();
		int[] candidates = {2,3,6,7};
		int target = 7;
		for(int i: candidates) 
		{
			candidateList.add(i);
		}
		ArrayList<ArrayList<Integer>> results = process(candidateList, target);
		if(results.size() == 0) 
		{
			System.out.println("There are no combinations.");
		}
		System.out.println(results);
	}
	
	public static ArrayList<ArrayList<Integer>> process(ArrayList<Integer> array, int target) 
	{
		ArrayList<ArrayList<Integer>> response = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Set<Integer> hash = new HashSet<>(array);
		array.clear();
		array.addAll(hash);
		Collections.sort(array);
		
		process(response, array, target, 0, temp);
		return response;
	}
	
	public static void process(ArrayList<ArrayList<Integer>> response, ArrayList<Integer> array, int target, int index, ArrayList<Integer> temp) 
	{
		if(target == 0) 
		{
			response.add(new ArrayList<>(temp));
			return;
		}
		
		for(int i = index; i < array.size(); i++) 
		{
			if(target - array.get(i) >= 0) 
			{
				temp.add(array.get(i));
				process(response, array, target - array.get(i), i, temp);
				temp.remove(array.get(i));
			}
		}
	}
}
