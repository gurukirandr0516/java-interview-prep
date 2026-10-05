package JavaCode;

public class reverseString {

    public static String reverse(String str) {
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }

    public static void main(String[] args){
        String str= "SpringBoot";
        String rev="";
        for(int i=str.length()-1;i>=0;i--){
            rev=rev+str.charAt(i);
        }
        System.out.println("Without built In function \n"+ rev);

        //Method calling implementation
        System.out.println("Using Chars[] reverse a string \n"+ reverse(str));
    }


}
