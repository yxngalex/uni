public class Zadatak4 {

    public static void main(String[] args) {
        int[] a = {1, 5, 3, 6, 2, 8 , 4, 15};

        System.out.println("Non prime number:" + primeNumber(4));
        System.out.println("Prime number:" + primeNumber(1));
        System.out.println("Non prime number:" + primeNumber(10));
        System.out.println("Prime number:" + primeNumber(5));
        System.out.println("Analiza vremenske slozenosti je: " + compareSmallestNumber(a));
    }

    public static int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static int primeNumber(int n) {
        if (n == 1) return 1;
        for (int i = 2; i < n; i++) {
            if(n % i == 0) return factorial(n);
        }
        return n;
    }

    static int compareSmallestNumber (int array[]){
        int x, curMin;
        int count = 0;
        curMin = array[0];
        count++;
        for (x = 1; x < array.length; x++){
            count++;
            if( array[x] < curMin)  {
                count++;
                curMin = array[x];
                count++;
            }
        }
        count++;
        count++;
        return count;
    }


}
