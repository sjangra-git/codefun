package codefun;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PackageProblem
{
// 81 : (1,53.38,$45) (2,88.62,$98) (3,78.48,$3) (4,72.30,$76) (5,30.18,$9) (6,46.34,$48)
    public static void main(String[] args)
    {        
        System.out.println("Input: "+ args[0]);
        File file = new File(args[0]);
        
        try
        {
            // Read input file and populate the list of items available
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine())
            {
                // List of items available
                List<Item> items = new ArrayList<Item>();

                String newline = sc.nextLine();
                Scanner sc1 = new Scanner(newline);
                // Total package weight
                int weight = sc1.nextInt();
                
                sc1.next();
                while(sc1.hasNext()) 
                {
                    String next = sc1.next();
                    //System.out.println("DEBUG: " + next);
                    String[] str = next.split(",");
                    Item item = new Item(Integer.valueOf(str[0].substring(1)),
                            Float.valueOf(str[1]),
                            Integer.valueOf(str[2].substring(1, str[2].length()-1)));
                    
                    items.add(item);                                        
                }
                sc1.close();
                
                // Let's sort the items list by price/weight ratio
                Collections.sort(items);

                // Iterate over all items and add to package if weight permits
                List<Item> itemsInPackage = new ArrayList<Item>();
                float weightAvailable = weight;
                for(Item item : items)
                {
                    if(item.getWeight() <= weightAvailable)
                    {
                        itemsInPackage.add(item);
                        weightAvailable = weightAvailable - item.getWeight();
                    }
                }
                
                if(itemsInPackage.isEmpty())
                {
                    System.out.println("-");                
                }
                else 
                {
                    Item[] itemArr = new Item[1];
                    StringBuilder sb = new StringBuilder();
                    for(Item item : itemsInPackage)
                    {
                        sb.append(item.toString());
                        sb.append(",");                        
                    }
                    String output = sb.substring(0, sb.length()-1);
                    System.out.println(output);
                }                
                
            }
            sc.close();
            
            
        }
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        
    }
    
    public static class Item implements Comparable<Item>
    {
        int index;
        float weight;
        int price;
        float pricePerWeight;
        
        Item(int index, float weight, int price)
        {
            this.index = index;
            this.weight = weight;
            this.price = price;
            pricePerWeight = price/weight;
        }

        // Decreasing order comparator
        public int compareTo(Item o)
        {
            if(pricePerWeight > o.pricePerWeight && (weight < o.weight)) return -1;
            
            if(pricePerWeight < o.pricePerWeight && (weight > o.weight)) return 1;
            
            return 0;
        }

        public int getIndex()
        {
            return index;
        }

        public void setIndex(int index)
        {
            this.index = index;
        }

        public float getWeight()
        {
            return weight;
        }

        public void setWeight(float weight)
        {
            this.weight = weight;
        }

        public int getPrice()
        {
            return price;
        }

        public void setPrice(int price)
        {
            this.price = price;
        }

        @Override
        public String toString()
        {
            return Integer.toString(index);
        }
        
        
        
    }
}
