package PA2;

import java.util.Random;
import java.util.stream.IntStream;

public class SortComparisons {
    public static long COMPCOUNT = 0;
    public static void main(String[] args) {
        // Cases
        int numberOfElements1 = 32, numberOfElements2 = 1024, numberOfElements3 = 32768, numberOfElements4 = 1048576;
        // Test arrays
        int[] randArrOG = constructArray(numberOfElements1);
        int[] bestArr, worstArr;
        SortComparisons sorts = new SortComparisons();
        // Time variables
        long startTime = 0, endTime = 0;
        double elapsedTimeMilli;

        System.out.println("*******PART ONE*******");
        for (int j = 0; j < 3; j++) {
            System.out.println();
            // Arrays are modified so reset them at beginning of the loop
            int[] randArr = randArrOG.clone();
            //, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
            // 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32
            bestArr = new int[] { 1, 2, 3, 4, 5 };
            worstArr = new int[] { 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17,
                    16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
            for (int i = 0; i < 3; i++) {
                // if statements to test best, worst, and random input for each sort method
                if (i == 0) {
                    COMPCOUNT = 0;
                    if (j == 0) {
                        System.out.println("***MERGE SORT RESULTS***");
                        System.out.println("Reversed Array -> n=" + numberOfElements1);
                        System.out.print("\tOriginal ");
                        printArray(worstArr);
                        startTime = System.nanoTime();
                        sorts.mergeSort(worstArr, 0, worstArr.length - 1);
                        endTime = System.nanoTime();
                        System.out.println();
                        System.out.print("\tSorted ");
                        printArray(worstArr);
                    } else if (j == 1) {
                        System.out.println("***HEAP SORT RESULTS***");
                        System.out.println("Reversed Array -> n=" + numberOfElements1);
                        System.out.print("\tOriginal ");
                        printArray(worstArr);
                        startTime = System.nanoTime();
                        sorts.heapSort(worstArr);
                        endTime = System.nanoTime();
                        System.out.println();
                        System.out.print("\tSorted ");
                        printArray(worstArr);
                    } else if (j == 2) {
                        System.out.println("***QUICK SORT RESULTS***");
                        System.out.println("Reversed Array -> n=" + numberOfElements1);
                        System.out.print("\tOriginal ");
                        printArray(worstArr);
                        startTime = System.nanoTime();
                        sorts.quickSort(worstArr, 0, worstArr.length - 1);
                        endTime = System.nanoTime();
                        System.out.println();
                        System.out.print("\tSorted ");
                        printArray(worstArr);
                    }
                }
                if (i == 1) {
                    System.out.println("Pre-sorted Array -> n=" + numberOfElements1);
                    System.out.print("\tOriginal ");
                    printArray(bestArr);
                    COMPCOUNT = 0;
                    if (j == 0) {
                        startTime = System.nanoTime();
                        sorts.mergeSort(bestArr, 0, bestArr.length - 1);
                        endTime = System.nanoTime();
                        System.out.println();
                        System.out.print("\tSorted ");
                        printArray(bestArr);
                    } else if (j == 1) {
                        startTime = System.nanoTime();
                        sorts.heapSort(bestArr);
                        endTime = System.nanoTime();
                        System.out.println();
                        System.out.print("\tSorted ");
                        printArray(bestArr);
                    } else if (j == 2) {
                        startTime = System.nanoTime();
                        sorts.quickSort(bestArr, 0, bestArr.length - 1);
                        endTime = System.nanoTime();
                        System.out.println();
                        System.out.print("\tSorted ");
                        printArray(bestArr);
                    }
                }
                if (i == 2) {
                    System.out.println("Random Array -> n=" + numberOfElements1);
                    System.out.print("\tOriginal ");
                    printArray(randArr);
                    COMPCOUNT = 0;
                    if (j == 0) {
                        startTime = System.nanoTime();
                        sorts.mergeSort(randArr, 0, randArr.length - 1);
                        endTime = System.nanoTime();
                        System.out.println();
                        System.out.print("\tSorted ");
                        printArray(randArr);
                    } else if (j == 1) {
                        startTime = System.nanoTime();
                        sorts.heapSort(randArr);
                        endTime = System.nanoTime();
                        System.out.println();
                        System.out.print("\tSorted ");
                        printArray(randArr);
                    } else if (j == 2) {
                        startTime = System.nanoTime();
                        sorts.quickSort(randArr, 0, randArr.length - 1);
                        endTime = System.nanoTime();
                        System.out.println();
                        System.out.print("\tSorted ");
                        printArray(randArr);
                    }
                }
                System.out.println();
                System.out.println("\tCOMPARISONS = " + COMPCOUNT);
                // divide by a million to convert to milliseconds
                elapsedTimeMilli = (endTime - startTime) / 1_000_000.0;
                System.out.println("\tTIME TO SORT = " + elapsedTimeMilli + "ms");
            }
        }

        System.out.println("\n\n*******PART TWO*******");
        for (int i = 0; i < 3; i++) {
            System.out.println();
            System.out.print("Random Array -> n=");
            if (i == 0) {
                randArrOG = constructArray(numberOfElements2);
                System.out.println(numberOfElements2);
            } else if (i == 1) {
                randArrOG = constructArray(numberOfElements3);
                System.out.println(numberOfElements3);
            } else if (i == 2) {
                randArrOG = constructArray(numberOfElements4);
                System.out.println(numberOfElements4);
            }
            for (int j = 0; j < 3; j++) {
                int[] randArr = randArrOG.clone();
                if (j == 0) {
                    System.out.println("***MERGE SORT RESULTS***");
                    COMPCOUNT = 0;
                    startTime = System.nanoTime();
                    sorts.mergeSort(randArr, 0, randArr.length - 1);
                    endTime = System.nanoTime();
                } else if (j == 1) {
                    System.out.println("***HEAP SORT RESULTS***");
                    COMPCOUNT = 0;
                    startTime = System.nanoTime();
                    sorts.heapSort(randArr);
                    endTime = System.nanoTime();
                } else if (j == 2) {
                    System.out.println("***QUICK SORT RESULTS***");
                    COMPCOUNT = 0;
                    startTime = System.nanoTime();
                    sorts.quickSort(randArr, 0, randArr.length - 1);
                    endTime = System.nanoTime();
                }
                System.out.println("\tCOMPARISONS = " + COMPCOUNT);
                // divide by million to convert to milliseconds
                elapsedTimeMilli = (endTime - startTime) / 1_000_000.0;
                System.out.println("\tTIME TO SORT = " + elapsedTimeMilli + "ms");
            }
        }
    }

    private static void printArray(int[] arr) {
        System.out.print("Array = ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
    // Method to generate test data
    private static int[] constructArray(int numberOfElem) {
        Random r = new Random();
        int arr[] = new int[numberOfElem];
        for (int i = 0; i < numberOfElem; i++)
            arr[i] = r.ints(1, (numberOfElem + 1)).limit(1).findFirst().getAsInt();
        return arr;
    }
    // Method to count comparisons
    public static int COMPARE(int X, int Y) {
        COMPCOUNT++;
        if (X == Y)
            return 0;
        else if (X < Y)
            return -1;
        else
            return 1;
    }

    /***************************************
     * SORTING ALGOS
     ***************************************/
    // *******MERGE SORT*******
    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }
    public static void merge(int[] arr, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = middle + 1, k = 0;
        while (i <= middle && j <= right) {
            if (COMPARE(arr[i], arr[j]) <= 0) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (k = 0; k < temp.length; k++)
            arr[left + k] = temp[k];
    }

    // *******HEAP SORT*******
    public void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && COMPARE(arr[l], arr[largest]) > 0)
            largest = l;
        if (r < n && COMPARE(arr[r], arr[largest]) > 0)
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    // *******QUICK SORT*******
    public void quickSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int pivotIndex = partition(arr, left, right);
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);
    }
    public int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left;
        int j = right;
        for (int k = left + 1; k <= j;) {
            if (COMPARE(arr[k], pivot) < 0) {
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                i++;
                k++;
            } else if (COMPARE(arr[k], pivot) > 0) {
                int temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;
                j--;
            } else {
                k++;
            }
        }
        return i;
    }
}