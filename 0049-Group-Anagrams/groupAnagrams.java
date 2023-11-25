// Problem Link: https://leetcode.com/problems/group-anagrams/
import java.util.*;

class groupAnagrams{
    public static void main(String[] args){
        String[] test1 = {"eat","tea","tan","ate","nat","bat"};
        String[] test2 = {""};
        String[] test3 = {"a"};
        // Intitial Solution
        System.out.println("Initial Solution Result:");
        List<List<String>> result1 = groupAnagramsInit(test1);
        System.out.println("Result for 1st Test Case");
        for(List<String> list : result1){
            System.out.println(list);
        }
        List<List<String>> result2 = groupAnagramsInit(test2);
        System.out.println("Result for 2nd Test Case");
        for(List<String> list : result2){
            System.out.println(list);
        }
        List<List<String>> result3 = groupAnagramsInit(test3);
        System.out.println("Result for 3rd Test Case");
        for(List<String> list : result3){
            System.out.println(list);
        }
    }

    // Time Complexity : O(n * k * log(k))
    // Space Complexity : O(n * k)
    /* Logic:
        1. We will create a map of string and list of strings. The key will be the sorted string and the value will be the list of strings which are anagrams of the key.
        2. We will iterate over the array of strings and sort each string. If the sorted string is not present in the map, we will add it to the map and create a new list of strings and add the current string to the list.
        3. If the sorted string is present in the map, we will get the list of strings and add the current string to the list.
        4. At the end we will return the list of values of the map.
     */
    private static List<List<String>> groupAnagramsInit(String[] strs){
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] currSet = str.toCharArray();
            Arrays.sort(currSet);
            String key = new String(currSet);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}