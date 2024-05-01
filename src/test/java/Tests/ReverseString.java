package Tests;

public class ReverseString {
    public static void main(String[] args) {
        String s1 = "vinoth";
        String s2 = "";
        System.out.println("The Original String is: " + s1);
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            s2 = c+s2;

        }
        System.out.println("The reversed string is: " + s2);
    }
}
