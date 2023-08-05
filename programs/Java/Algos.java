import java.util.HashMap;
import java.util.Random;

public class Algos {
    String[] colors = {
        "\u001B[31m", // Red            0
        "\u001B[32m", // Green          1
        "\u001B[33m", // Yellow         2
        "\u001B[34m", // Blue           3
        "\u001B[35m", // Magenta        4
        "\u001B[36m"  // Cyan           5
    };
    String reset = "\u001B[0m";

    private String selectRandomColor() {
        Random random = new Random();
        CacheManager cacheManager = CacheManager.getInstance();
        int minIndex = 0;
        int maxIndex = this.colors.length - 1;
        int randomIndex = random.nextInt(maxIndex - minIndex + 1) + minIndex;
        
        if (cacheManager.getFromCache(randomIndex) != null) {
            cacheManager.addToCache(randomIndex, cacheManager.getFromCache(randomIndex) + 1);
        }
        
        return this.colors[randomIndex];
    }
    
    
    private void printForDebug(String outputString){
        System.out.println(selectRandomColor() + outputString + reset);
    }

    public boolean isAnagram(String s1, String s2) {
        String formattedString = String.format("  ====  S1 length %d and S2 length %d  ====  ", s1.length(), s2.length());
        printForDebug(formattedString);
        if(s1.length() != s2.length()){
            return false;
        }
        
        HashMap <Character, Integer> mapS1 = new HashMap<>();

        for (int i=0; i<s1.length(); i++){
            char character = s1.charAt(i);
            if(!mapS1.containsKey(character)){
                mapS1.put(character, 0);
            }
            mapS1.put(character, mapS1.get(character) + 1);
        }

        for (int j=0; j<s2.length(); j++){
            char character = s2.charAt(j);
            if(mapS1.containsKey(character)){
                mapS1.put(character, mapS1.get(character) - 1);
            }
            if(mapS1.get(character) == 0){
                mapS1.remove(character);
            }
        }

        return mapS1.isEmpty();
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        HashMap <Integer, Integer> sumMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(sumMap.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = sumMap.get(target - nums[i]);
                return result;
            }else {
                sumMap.put(nums[i], i);
            }
        }
        return result;
    }

    public int[] twoSum(int[] numbers, int target, String sorted) {
        int[] result = new int[] {-1, -1};
        int l = 0;
        int h = numbers.length - 1;
        while(l<h){
            if(numbers[l] + numbers[h] == target){
                return new int[] {l, h};
            } else if(numbers[l] + numbers[h] > target){
                h--;
            } else {
                l++;
            }
        }
        return result;
    }

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i = 0; i < nums.length; i++){
            if(currentSum < 0){
                currentSum = 0;
            }
            currentSum += nums[i];
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Integer.max(dp[i-1], (i == 1 ? 0 : dp[i-2]) + nums[i]);
        }
        return dp[nums.length - 1];
    }


    public static void main(String[] args) {
        new Algos();
    
        // CacheManager cacheManager = CacheManager.getInstance();
        // cacheManager.deserializeCache();
    
        // System.out.println("Cache contents after deserialization:");
        // cacheManager.printCache();
    
        // // cacheManager.addToCache(2, "testValue");
        // System.out.println("Cache contents after adding new entry:");
        // cacheManager.printColorsCache();
    
        // cacheManager.serializeCache();

        // InMemoryRedisStorage storage = InMemoryRedisStorage.getInstance();

        // // Set key-value pairs
        // storage.set("name", "John");
        // storage.set("age", "30");

        // // Get values by key
        // String name = storage.get("name");
        // String age = storage.get("age");
        // algos.printForInfo("Name: " + name);
        // algos.printForInfo("Age: " + age);

        // // Delete a key
        // storage.delete("age");
        // age = storage.get("age");
        // algos.printForInfo("Age after deletion: " + age);
    }
    
}
