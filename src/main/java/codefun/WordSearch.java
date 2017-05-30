package codefun;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-search/
 * Given a 2D board and a word, find if the word exists in the grid.

  The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once. 
 *
 *[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
 */
public class WordSearch
{

    public static void main(String[] args)
    {
        char[][] input = new char[][]{{'A','B','C','E'},
                                      {'S','F','C','S'},
                                      {'A','D','E','E'}};
        String word = "SEE";
        
        WordSearch obj = new WordSearch();
        boolean found = obj.exist(input, word);
        if(found)
        {
            System.out.println("Found See");
        }
        else 
        {
            System.err.println("DID NOT Find See");
        }
        
        found = obj.exist(input, "ABCCED");
        if(found)
        {
            System.out.println("Found ABCCED");
        }
        else 
        {
            System.err.println("DID NOT Find ABCCED");
        }
        
        // ABCB
        found = obj.exist(input, "ABCB");
        if(found)
        {
            System.err.println("Found ABCB");
        }
        else 
        {
            System.out.println("DID not Find ABCB");
        }
        
        
    }
    
    public boolean exist(char[][] input, String word)
    {        
        assert input != null;
        assert input.length > 0;
        
        int rows = input.length;
        int col = input[0].length;
        boolean[][] visited = new boolean[rows][col];
        for(int i = 0; i<rows; i++)
        {
            for (int j = 0; j<col; j++)
            {
                if(input[i][j] == word.charAt(0))
                {
                    visited[i][j] = true;
                    boolean found = findWord(input, i, j, visited, word, 1, rows, col);
                    if(found)
                    {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        
        return false;
    }
    
    private boolean findWord(final char[][] input, int x, int y, boolean[][] visited, final String word, int wordPos, final int rows, final int col)
    {
        // Word Position has reached the length of the word, then we have found the word
        if(wordPos == word.length())
        {
            return true;
        }
        
        boolean found = false;

        // Check node UP
        if(x-1 > -1)
        {
            if(word.charAt(wordPos) == input[x-1][y])
            {
                // Never seen before
                if(!visited[x-1][y])
                {
                    visited[x-1][y] = true;
                    found = findWord(input, x-1, y, visited, word, wordPos + 1, rows, col);
                    if(found) return true;
                    visited[x-1][y] = false;
                }
            }
        }
        
        // Check down
        if(x+1 <= rows-1)
        {
            if(word.charAt(wordPos) == input[x+1][y])
            {
                if(!visited[x+1][y])
                {
                    visited[x+1][y] = true;
                    found = findWord(input, x+1, y, visited, word, wordPos + 1, rows, col);
                    if(found) return true;
                    visited[x+1][y] = false;
                }
            }
        }
        
        // Check left
        if(y-1 > -1)
        {
            if(word.charAt(wordPos) == input[x][y-1])
            {
                if(!visited[x][y-1])
                {
                    visited[x][y-1] = true;
                    found = findWord(input, x, y-1, visited, word, wordPos + 1, rows, col);
                    if(found) return true;
                    visited[x][y-1] = false;
                }
            }
        }

        // Check right
        if(y+1 <= col-1)
        {
            if(word.charAt(wordPos) == input[x][y+1])
            {
                if(!visited[x][y+1])
                {
                    visited[x][y+1] = true;
                    found = findWord(input, x, y+1, visited, word, wordPos + 1, rows, col);
                    if(found) return true;
                    visited[x][y+1] = false;
                }
            }
        }
        
        return found;
    }
}
