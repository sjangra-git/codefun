package codefun.algorithms.dfs;

import java.util.*;

/**
 * Given an n*n matrix filled randomly with different colors (no limit on what the colors are), 
 * add up the total number of groups of each color - 
 * a group is adjacent cells of the same color touching each other.
 * 
 * Diagonals are not counted as adjacent
 */
public class CountColorGroups
{
    private static int R = 3;
    private static int C = 4;
    private static int RED = 0;
    private static int BLUE = 1;
    private static int YELLOW = 2;
    private static int GREEN = 3;
    
    private static boolean[][] marked = new boolean[R][C];    
    private static Map<Integer, Integer> colorGroups = new HashMap<Integer, Integer>();

    public static void main(String[] args)
    {
        int[][] colors = new int[][]{
                {RED, RED, BLUE, BLUE},
                {BLUE, RED, BLUE, YELLOW},
                {GREEN, GREEN, YELLOW, YELLOW}
                };
        
        Map<Integer, Integer> results = countGroups(colors);
        if(results.get(RED) != 1) System.out.println("RED count is incorrect");
        if(results.get(BLUE) != 2) System.out.println("BLUE count is incorrect");
        if(results.get(YELLOW) != 1) System.out.println("YELLOW count is incorrect");
        if(results.get(GREEN) != 1) System.out.println("GREEN count is incorrect");
        
        System.out.println(results.toString());
    }

    public static Map<Integer, Integer> countGroups(int[][] colors)
    {
        for (int i = 0; i < R; i++)
        {
            for (int j = 0; j < C; j++)
            {
                if (marked[i][j])
                    continue;

                markNodes(colors, i, j, colors[i][j]);

                Integer count = colorGroups.get(colors[i][j]);
                if (count == null)
                    count = 0;
                count++;
                colorGroups.put(colors[i][j], count);

            }
        }
        return colorGroups;
    }

    /** Traverse the graph in depth first search and keep marking the nodes that have not been visited yet 
     * and are of the same color as original root node
     */
    public static void markNodes(int[][] colors, int row, int col, int previousColor)
    {
        if (row < 0 || row >= R)
            return;
        if (col < 0 || col >= C)
            return;

        if (marked[row][col])
            return;

        if (colors[row][col] != previousColor)
            return;

        marked[row][col] = true;

        // Go up
        markNodes(colors, row - 1, col, previousColor);

        // Go below
        markNodes(colors, row + 1, col, previousColor);

        // Go left
        markNodes(colors, row, col - 1, previousColor);

        // Go right
        markNodes(colors, row, col + 1, previousColor);

        return;
    }
}

