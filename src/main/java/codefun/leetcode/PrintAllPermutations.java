package codefun.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutations {

	public static void main(String[] args) {

		int[] nums = new int[] {1,2,3};

		List<Integer> arr = new ArrayList<>();

		List<Integer> out = new ArrayList<Integer>(arr.size());
		printAllPerms(arr, out);

	}

	public static void printAllPerms(List<Integer> list, List<Integer> out)
	{
		if(list.isEmpty())
		{
			// print set
			out.forEach(System.out::print);
			System.out.println();
			return;
		}

		for (int i = 0; i < list.size(); i++)
		{
			int curr = list.get(i);

			out.add(curr);
			list.remove(i);

			// printAllPerms()
			printAllPerms(list, out);

			// add the number back to list
			out.remove(out.size() - 1);
			list.add(i, curr);
		}
	}

	
}
