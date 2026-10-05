package JavaCode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    public static String longestSubString(String str){
        Set<Character> set=new HashSet<>();
        int left=0;
        int maxlength=0;
        int start=0;

        for(int right=0;right<str.length();right++){
            char ch=str.charAt(right);

            //remove duplicates and increment left
            while(set.contains(ch)){
                set.remove(str.charAt(left));
                left++;
            }
            set.add(ch);

            maxlength=Math.max(maxlength,right-left+1);

            /*Without Math BuiltIn function
            while(right-left+1>maxlength) {
                maxlength = right - left + 1;
                start = left;
            }*/
        }
        return str.substring(start,maxlength);
    }

    public static void main(String[] args){
        String str="abcdaabbccd";
        String res=longestSubString(str);
        System.out.println("longestSubString:"+ res);
        System.out.println("length of substring:" +res.length());
    }
}
