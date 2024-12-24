package HashMaps;

import java.util.*;
public class Hash 
{
    public static void main(String[] args) 
    {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Harsh", 100);
        map.put("Keshav", 95);
        map.put("Bonela", 90);

        System.out.println();
        System.out.println(map.get("Harsh"));
    }    
}
