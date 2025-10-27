import java.util.*;

public class Solutions {

    public static int findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int num : arr){
            if(num > largest){
                secondLargest = largest;
                largest = num;
            } else if(num < largest && num > secondLargest){
                secondLargest = num;
            }
        }
        return secondLargest;
    }

    public static int[] sortArray(int[] arr) {
        for(int k = 0; k < arr.length; k++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int t = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = t;
                }
            }
        }
        return arr;
    }

    public static void moveZerosToEnd(int[] arr){
        int nonZeroIndex = 0;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] != 0){
                arr[nonZeroIndex] = arr[i];
                nonZeroIndex++;
            }
        }
        for (int i = nonZeroIndex; i < arr.length; i++) {
            arr[i] = 0;
        }
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static char firstUniqueChar(String str){
        for(int i = 0; i < str.length(); i++){
            int count = 0;
            for(int k = 0; k < str.length(); k++){
                if(str.charAt(i) == str.charAt(k)){
                    count++;
                }
            }
            if(count == 1) return str.charAt(i);
        }
        return '_';
    }

    public static char firstUniqueCharMap(String str){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                int count = map.get(str.charAt(i));
                count = count + 1;
                map.replace(str.charAt(i), count);
            } else {
                map.put(str.charAt(i), 1);
            }
        }

        for(int i = 0; i < str.length(); i++){
            int num = map.get(str.charAt(i));
            if(num == 1)
                return str.charAt(i);
        }
        return ' ';
    }

    public static void printFibonacci(int n){
        int a = 0;
        int b = 1;

        for (int i = 0; i < n; i++) {
            System.out.println(a);    // print the current number
            int next = a + b;
            a = b;
            b = next;
        }
    }

    public static boolean isSortedAscending(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasDuplicates(int[] arr){
        Set<Integer> s = new HashSet<Integer>();
        for(int i = 0; i < arr.length; i++){
            s.add(arr[i]);
        }
        return (s.size() < arr.length);
    }

    public static int removeDuplicates(int[] arr){ // array is sorted from smallest to biggest
        if (arr.length == 0) return 0;

        int index = 1; // position to write the next unique value

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1])  continue;
            arr[index] = arr[i];  // write unique value
            index++;
        }
        return index;
    }

    public static Map<Character, Integer> countCharRepetition(String s){
        Map<Character, Integer> m = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(m.containsKey(s.charAt(i))){
                int count = m.get(s.charAt(i));
                count = count+1;
                m.put(s.charAt(i), count);
            } else {
                m.put(s.charAt(i), 1);
            }
        }
        return m;
    }

    public static boolean isCleanPalindrome(String str){

        StringBuilder newString = new StringBuilder();
        for(char c : str.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                newString.append(Character.toLowerCase(c));
            }
        }

        for(int i = 0; i < newString.length()/2; i++){
            if(newString.charAt(i) != newString.charAt(newString.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static List<String> findPairsWithSum(int[] arr, int target){
        List<String> pairs = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if(seen.contains(complement)){
                int smaller = Math.min(num, complement);
                int bigger = Math.max(num, complement);
                String sum = smaller + " + " + bigger;
                pairs.add(sum);
            } else {
                seen.add(num);
            }
        }

        return pairs;
    }

    public static List<String> findPairsWithSum1(int[] arr, int target){
        List<String> pairs = new ArrayList<>();
        for(int j = 0; j < arr.length; j++){
            int complements = target - arr[j];
            for(int i = 0; i < j; i++){
                if(arr[i] == complements){
                    pairs.add(arr[j] + " + " + arr[i]);
                }
            }
        }
        return pairs;
    }

    public static boolean isValidPassword(String password){
        if(password.length() < 8){
            return false;
        }
        String specialChars = "!@#$%^&*()_+-={}[]|:;\"'<>,.?/";
        boolean specialChar = false;
        boolean lowerCase = false;
        boolean upperCase = false;
        boolean digit = false;

        for(int i = 0; i < password.length(); i++){
            if(Character.isUpperCase(password.charAt(i))){
                upperCase = true;
            }
            if(Character.isLowerCase(password.charAt(i))){
                lowerCase = true;
            }
            if(Character.isDigit(password.charAt(i))){
                digit = true;
            }
            if(specialChars.contains(String.valueOf(password.charAt(i)))){
                specialChar = true;
            }
        }

        return lowerCase && upperCase && digit && specialChar;
    }

    public static double calculateWaterBill(double gallonUsage){
        double basePrice = 18.84;
        double ccf = 0.748;
        double extraGallonUsage = gallonUsage - (ccf * 2);
        if(extraGallonUsage > 0){
            return basePrice + Math.ceil(extraGallonUsage / ccf) * 3.9;
        }

        return basePrice;
    }

    // method that takes a list of tel numbers (as Strings) and cleans them up by removing spaces, dashes and ()
    public static List<String> cleanPhoneNumbers(List<String> numbers){
        List<String> list = new ArrayList<>();
        for(String tel : numbers){
            list.add(tel.replaceAll("\\D+", ""));
        }
        return list;
    }

}
/*
Map<String, String> students = new HashMap<>();
        students.put("1", "Lisa");
        students.put("2", "Julia");
        students.put("3", "Sofia");

        for(Map.Entry m : students.entrySet()) {
        System.out.println("Entry num is " + m.getKey() + " and student name is " + m.getValue());
        }
*/