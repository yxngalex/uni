public class Zadatak1 {

    public static void main(String[] args) {

        for (int i = 100; i <= 10000; i++) {
            for (int j = i + 1; j <= 10000; j++) {
                if (i == inverse(j)) {
                    if (isPalindrome(i, j)) {
                        System.out.println("Sum of elements" + i + " and " + j + " is " + (i + j) + " which is palindrome.");
                    }
                }
            }
        }

    }

    public static Integer inverse(int i) {
        int inv = 0;
        while (i != 0) {
            int digit = i % 10;
            inv = inv * 10 + digit;
            i /= 10;
        }
        return inv;
    }

    public static boolean isPalindrome(int i, int j) {
        int sum = i + j;
        int inverseSum = inverse(sum);

        if (sum == inverseSum) {
            return true;
        }
        return false;
    }
}
