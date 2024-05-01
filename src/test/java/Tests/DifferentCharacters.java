package Tests;

public class DifferentCharacters {
    public static void main(String[] args) {
        int upperCase =0, digit = 0, lowerCase = 0, specialChar = 0;
        String s1 = "ViNo@123";
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (Character.isDigit(c)) {
                digit++;
            } else if (Character.isLowerCase(c)) {
                lowerCase++;
            } else if (Character.isUpperCase(c)) {
                upperCase++;
            } else {
                specialChar++;
            }
        }
        System.out.println("Uppercase count is: " + upperCase);
        System.out.println("digit count is: " + digit);
        System.out.println("lowerCase count is: " + lowerCase);
        System.out.println("specialChar count is: " + specialChar);

        }
    }

