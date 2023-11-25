import java.util.*;

class topKFrequent{
    public static void main(String[] args){
        int[] test1 = {1,1,1,2,2,3};
        int[] test2 = {1};
        int[] test3 = {1,2};
        int[] test4 = {1,2,2,3,3,3};
        int k1 = 2;
        int k2 = 1;
        int k3 = 2;
        int k4 = 2;
        // Intitial Solution
        System.out.println("Initial Solution Result:");
        System.out.println(Arrays.toString(topFreq(test1, k1)));
        System.out.println(Arrays.toString(topFreq(test2, k2)));
        System.out.println(Arrays.toString(topFreq(test3, k3)));
        System.out.println(Arrays.toString(topFreq(test4, k4)));
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    /*
    Logic:
       1. We will create a map of number and its frequency.
       2. We will create an array of lists of integers. The index of the array will be the frequency of the number and the list will contain the numbers with that frequency.
       3. We will iterate over the array of numbers and add the number and its frequency to the map.
       4. We will iterate over the map and add the number to the list of numbers with the frequency as the index of the array.
       5. We will iterate over the array of lists from the end and add the numbers to the result list until the size of the result list is less than k.
       6. We will return the result list.
     */
    private static int[] topFreq(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] freqList = new List[nums.length+1];
        List<Integer> res = new ArrayList<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(int key: map.keySet()){
            if(freqList[map.get(key)] == null){
                freqList[map.get(key)] = new ArrayList<>();
            }
            freqList[map.get(key)].add(key);
        }

        for(int i = freqList.length-1; i >= 0 && res.size() < k; i--){
            if(freqList[i] == null) continue;
            List<Integer> currList = freqList[i];
            for(int j = 0; j < currList.size(); j++){
                res.add(currList.get(j));
            }
        }

        return res.stream().mapToInt(i->i).toArray();
    }
}