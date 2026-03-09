
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
public class Fundamentals {
    public static void analyzeString(String s){
        int vowcnt=0;
        int conscnt=0;
        HashMap<Character,Integer> mpp= new HashMap<>();
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        for(int i=0;i<s.length();i++){
            mpp.put(s.charAt(i), mpp.getOrDefault(s.charAt(i),0)+1);
            if(vowels.contains(s.charAt(i))){
                vowcnt++;
            }
            else{
                conscnt++;
            }
        }
        System.out.println("Vowels count : "+vowcnt);
        System.out.println("Consonants count :"+conscnt);
        for(HashMap.Entry<Character, Integer> entry : mpp.entrySet()){
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }
        for(int i=0;i<s.length();i++){
            if(mpp.get(s.charAt(i))==1){
                System.out.println("First non-repetiting character in the given string is: "+s.charAt(i));
                return;
            }
        }
    }
    public static boolean isPalindrome(String s){
        int l=0;
        int r=s.length()-1;
        while(l<r){
            while(l<r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while(l<r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            //if(Character.isLetterOrDigit(s.charAt(l)) && Character.isLetterOrDigit(s.charAt(r))){
            char left=Character.toLowerCase(s.charAt(l));
            char right=Character.toLowerCase(s.charAt(r));
            if(left!=right){
                return false;
            }
            l++;
            r--;
    }
    return true;
    }
    
    public static void main(String[] args) {
        // String s="A man, a plan, a canal: Panama";
        // if(isPalindrome(s)){
        //     System.out.println("is a palindrome");
        // }
        // else{
        //     System.out.println("not a palindrome");
        // }
        // String s="abaesshfbd";
        // analyzeString(s);
    }
}
