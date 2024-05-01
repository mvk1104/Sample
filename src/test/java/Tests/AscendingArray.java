package Tests;

public class AscendingArray {
    public static void main(String[] args) {
        int[] a = {2, 10, 5, 50, 25};
        int i, j, temp;
        for (i = 0; i < a.length; i++) {
            for (j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        for (int x : a) {
            System.out.println(x);
        }

    }
}


