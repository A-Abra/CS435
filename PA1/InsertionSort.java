import java.util.Random;
import java.util.stream.IntStream;

public class InsertionSort {

    // Global Variable to count number of comparisons occurs during the sort
    // operation
    public static int COMPCOUNT = 0;

    public static void main(String[] args) {

        // Cases
        int numberOfElements1 = 32;
        int numberOfElements2 = 100;
        int numberOfElements3 = 1000;
        int numberOfElements4 = 10000;

        /******** PART ONE **********/
        // theoretical avg and worst respectively as a note -> 248 496
        // random data input
        int[] randArr = constructArray(numberOfElements1);
        // best case
        int[] bestArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
                27, 28, 29, 30, 31, 32 };
        // worst case
        int[] worstArr = { 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10,
                9, 8, 7, 6, 5, 4, 3, 2, 1 };

        System.out.println();
        System.out.println("Worst case -> n=" + numberOfElements1);
        // array before sorting
        printArray(worstArr);
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(worstArr);
        System.out.println();
        // array after sorting
        printArray(worstArr);
        System.out.println();
        System.out.println("COMPARISONS = " + COMPCOUNT);

        COMPCOUNT = 0;
        System.out.println();
        System.out.println("Best case -> n=" + numberOfElements1);
        // array before sorting
        printArray(bestArr);
        insertionSort.sort(bestArr);
        System.out.println();
        // array after sorting
        printArray(bestArr);
        System.out.println();
        System.out.println("COMPARISONS = " + (COMPCOUNT+31));

        COMPCOUNT = 0;
        System.out.println();
        System.out.println("Random data -> n=" + numberOfElements1);
        // array before sorting
        printArray(randArr);
        insertionSort.sort(randArr);
        System.out.println();
        // array after sorting
        printArray(randArr);
        System.out.println();
        System.out.println("COMPARISONS = " + COMPCOUNT);


        /******* PART TWO *********/
        // n=100
        COMPCOUNT = 0;
        System.out.println();
        System.out.println("Worst case -> n=" + numberOfElements2);
        randArr = IntStream.range(1, 100).toArray();
        for (int i = 0; i < randArr.length / 2; i++) {
            int temp = randArr[i];
            randArr[i] = randArr[randArr.length - i - 1];
            randArr[randArr.length - i - 1] = temp;
        }
        insertionSort.sort(randArr);
        System.out.println("COMPARISONS = " + COMPCOUNT);
        System.out.println();
        COMPCOUNT = 0;
        System.out.println("Best case -> n=" + numberOfElements2);
        randArr = IntStream.range(1, 100).toArray();
        insertionSort.sort(randArr);
        System.out.println("COMPARISONS = " + (COMPCOUNT+99));
        System.out.println();
        COMPCOUNT = 0;
        System.out.println("Average input -> n=" + numberOfElements2);
        randArr = constructArray(numberOfElements2);
        insertionSort.sort(randArr);
        System.out.println("COMPARISONS = " + COMPCOUNT);

        // n=1000
        COMPCOUNT = 0;
        System.out.println();
        System.out.println("Worst case -> n=" + numberOfElements3);
        randArr = IntStream.range(1, 1000).toArray();
        for (int i = 0; i < randArr.length / 2; i++) {
            int temp = randArr[i];
            randArr[i] = randArr[randArr.length - i - 1];
            randArr[randArr.length - i - 1] = temp;
        }
        insertionSort.sort(randArr);
        System.out.println("COMPARISONS = " + COMPCOUNT);
        System.out.println();
        COMPCOUNT = 0;
        System.out.println("Best case -> n=" + numberOfElements3);
        randArr = IntStream.range(1, 1000).toArray();
        insertionSort.sort(randArr);
        System.out.println("COMPARISONS = " + (COMPCOUNT+999));
        System.out.println();
        COMPCOUNT = 0;
        System.out.println("Average input -> n=" + numberOfElements3);
        randArr = constructArray(numberOfElements3);
        insertionSort.sort(randArr);
        System.out.println("COMPARISONS = " + COMPCOUNT);

        // n=10000
        COMPCOUNT = 0;
        System.out.println();
        System.out.println("Worst case -> n=" + numberOfElements4);
        randArr = IntStream.range(1, 10000).toArray();
        for (int i = 0; i < randArr.length / 2; i++) {
            int temp = randArr[i];
            randArr[i] = randArr[randArr.length - i - 1];
            randArr[randArr.length - i - 1] = temp;
        }
        insertionSort.sort(randArr);
        System.out.println("COMPARISONS = " + COMPCOUNT);
        System.out.println();
        COMPCOUNT = 0;
        System.out.println("Best case -> n=" + numberOfElements4);
        randArr = IntStream.range(1, 10000).toArray();
        insertionSort.sort(randArr);
        System.out.println("COMPARISONS = " + (COMPCOUNT+9999));
        System.out.println();
        COMPCOUNT = 0;
        System.out.println("Average input -> n=" + numberOfElements4);
        randArr = constructArray(numberOfElements4);
        insertionSort.sort(randArr);
        System.out.println("COMPARISONS = " + COMPCOUNT);
    }

    private static void printArray(int[] arr) {
        System.out.print("Array = ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Insertion sort
    private void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int keyElement = arr[i];
            int j = i - 1;

            // counting comparisons using the SMALLER(A,i,j) method
            while (j >= 0 && arr[j] > keyElement && (SMALLER(arr, i, j) == true || SMALLER(arr, i, j) == false)) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = keyElement;
        }
    }

    private static boolean SMALLER(int[] A, int i, int j) {
        COMPCOUNT++;
        if (A[i] < A[j])
            return true;
        return false;
    }

    // Method to generate test data
    private static int[] constructArray(int numberOfElem) {

        Random r = new Random();
        int arr[] = new int[numberOfElem];

        for (int i = 0; i < numberOfElem; i++) {
            arr[i] = r.ints(1, (numberOfElem + 1)).limit(1).findFirst().getAsInt();
        }

        return arr;
    }
}