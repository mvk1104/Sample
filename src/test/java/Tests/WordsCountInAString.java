package Tests;

public class WordsCountInAString {
    public static void main(String[] args) {
        int count = 0;
        String s1 = "My Name Is Vinoth Kumar";
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if(c != ' ');
            count++;

        }
        System.out.println(count);

    }


}
