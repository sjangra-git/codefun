package codefun;

import java.util.*;

public class ListOfListIterator
{
    private List<List<Integer>> listOfList = null;
    private int[] index = null;

    public static void main(String[] args)
    {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(3);
        list1.add(7);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(2);
        list2.add(4);

        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(2);
        list3.add(5);
        list3.add(6);
        list3.add(9);

        List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
        listOfLists.add(list1);
        listOfLists.add(list2);
        listOfLists.add(list3);

        ListOfListIterator sol = new ListOfListIterator(listOfLists);
        while (sol.hasNext())
        {
            System.out.print(sol.next());
            System.out.print(" ");
        }

    }

    ListOfListIterator(List<List<Integer>> lists)
    {
        listOfList = lists;
        index = new int[lists.size()];
        Arrays.fill(index, 0);
    }

    public boolean hasNext()
    {
        int i = 0;
        for (List<Integer> list : listOfList)
        {
            if (index[i] < list.size())
                return true;
            i++;
        }

        return false;
    }

    public int next()
    {
        int min = Integer.MAX_VALUE;

        int i = 0;
        int selectedList = -1;
        for (List<Integer> list : listOfList)
        {
            if (index[i] < list.size())
            {
                if (list.get(index[i]) < min)
                {
                    min = list.get(index[i]);
                    selectedList = i;
                }
            }
            i++;
        }

        // increment the position in the selected list only
        index[selectedList]++;
        return min;
    }
}
