import java.util.Random;

//Calculate elapsed time for 10 different sizes using four sorting algorithms: insertion sort, mergesort, quicksort, and heapsort.

public class Hw5_P7 {
    public static void main(String[] args) {
        // initiate random from the library
        Random random = new Random();

        // initiate start/end/elapsed time
        long startTime;
        long endTime;
        long elapsedTime;

        // sizes of array of each execution
        final int arraySizes[] = { 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000 };

        // loop through each size of the 10 sizes declared above to measure sorting algorithms
        for (int i = 0; i < arraySizes.length; i++) {
            // creating a new array with a fixed size based on the current arraySizes
            int array[] = new int[arraySizes[i]];

            // generate random integers for each size of array
            for (int j = 0; j < array.length; j++) {
                // calling random to get a random number between 1 and 1,000,000
                int randomNumber = random.nextInt(1000000) + 1;
                boolean duplication = false;

                // check if the random number has already existed in the array
                for (int l = 0; l < j; l++) {
                    if (randomNumber == array[l]) {
                        duplication = true;

                        // decrement counter to get a new random number to fill the array
                        j--;
                    }
                }
                if (duplication == false) {
                    array[j] = randomNumber; // add the unique random number to array
                }
            }
            System.out.println("For Array Size " + array.length);

            //Calculating and printing elapsed time for insertion sort
            System.out.print("Elapsed Time for Insertion Sort: ");

            // creating temp1 array with same size of array
            int tmp1[] = new int[array.length];

            // copying array elements to temp1 array
            for (int k = 0; k < tmp1.length; k++) {
                tmp1[k] = array[k];
            }
            startTime = System.currentTimeMillis(); // Starting time of insertion sort
            insertionSort(tmp1); // Calling insertion Sort
            endTime = System.currentTimeMillis(); // Ending time of insertion sort
            elapsedTime = endTime - startTime; // Calculating elapsed time for insertion sort
            System.out.println(elapsedTime + " mils"); // print elapsed time

            //Calculating and printing elapsed time for merge sort
            System.out.print("Elapsed Time for Merge Sort: ");

            // creating temp2 array with same size of array
            int tmp2[] = new int[array.length]; // copying array elements to temp2 array
            for (int k = 0; k < tmp2.length; k++) {
                tmp2[k] = array[k];
            }
            startTime = System.currentTimeMillis(); // Starting time of merge sort
            mergeSort(tmp2); // Calling mergeSort
            endTime = System.currentTimeMillis(); // Ending time of merge sort
            elapsedTime = endTime - startTime; // Calculating elapsed time for merge sort
            System.out.println(elapsedTime + " mils"); // Printing elapsed time

            //Calculating and printing elapsed time for quick sort
            System.out.print("Elapsed Time for Quick Sort: ");

            // creating temp3 array with same size of array
            int tmp3[] = new int[array.length]; // copying array elements to temp3 array
            for (int k = 0; k < tmp3.length; k++) {
                tmp3[k] = array[k];
            }
            startTime = System.currentTimeMillis(); // Starting time of quick sort
            quickSort(tmp3); // Calling quick sort
            endTime = System.currentTimeMillis(); // Ending time of quick sort
            elapsedTime = endTime - startTime; // Calculating elapsed time for quick sort
            System.out.println(elapsedTime + " mils"); // Print elapsed time

            // Calculating and printing elapsed time for heap sort
            System.out.print("Elapsed Time for Heap Sort: ");

            // creating temp4 array with same size of array
            int tmp4[] = new int[array.length]; // copying array elements to temp4 array
            for (int k = 0; k < tmp4.length; k++) {
                tmp4[k] = array[k];
            }

            startTime = System.currentTimeMillis(); // Starting time of heap sort
            heapSort(tmp4); // Calling heap sort
            endTime = System.currentTimeMillis(); // Ending time of heap sort
            elapsedTime = endTime - startTime; // Calculating elapsed time for heap sort
            System.out.println(elapsedTime + " mills"); // Printing elapsed time
            System.out.println();
        }
    }

    // sorting using insertionSort
    // @param array of integers as argument.
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];

            // compare the current element to its predecessor
            int j = i - 1;

            // Move  greater elements one index up to make space for the swapped element
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // sorting using mergeSort
    // @param array of integers as argument.
    public static void mergeSort(int array[]) {
        mergeSort(array, 0, array.length - 1);
    }

    // helper method for mergeSort
    // @param array - array of integers as argument
    // @param first - first index of array size n
    // @param last  - last index of array size n
    private static void mergeSort(int[] array, int first, int last) {
        if (first < last) {
            // find the middle point to divide the array into two halves
            int mid = (first + last) / 2;

            // call mergesort for first half
            mergeSort(array, first, mid);

            // call mergesort for second half
            mergeSort(array, mid + 1, last);

            // merge the two halves sorted
            merge(array, first, mid, last);
        }
    }

    // Merge two sub-arrays of array[] => First subarray is arr[first..mid], Second subarray is arr[mid+1..last]
    // @param array - array of integers as argument
    // @param first - first position
    // @param mid   - middle position
    // @param last  - last position
    private static void merge(int array[], int first, int mid, int last) {
        int left = mid - first + 1;
        int right = last - mid;

        // Create temp arrays
        int leftarray[] = new int[left];
        int rightarray[] = new int[right];

        //Copy data to temp arrays
        for (int i = 0; i < left; i++) {
            leftarray[i] = array[first + i];
        }

        for (int i = 0; i < right; i++) {
            rightarray[i] = array[mid + i + 1];
        }

        int i = 0, j = 0, k = first;

        while (i < left && j < right) {
            if (leftarray[i] < rightarray[j]) {
                array[k] = leftarray[i];
                i++;
            } else {
                array[k] = rightarray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of Left if any
        while (i < left) {
            array[k] = leftarray[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < right) {
            array[k] = rightarray[j];
            k++;
            j++;
        }
    }

    // sorting using quickSort - using pivot to put all smaller element before x and put all greater elements after x.
    // @param array of integers as argument.
    public static void quickSort(int array[]) {
        quickSort(array, 0, array.length - 1);
    }

    // helper method for quickSort
    // @param array - array of integers as argument
    // @param first - first index of array size n
    // @param last - last index of array size n
    private static void quickSort(int array[], int first, int last) {
        if (first < last) {
            int part = partition(array, first, last);
            quickSort(array, first, part - 1);
            quickSort(array, part + 1, last);
        }
    }

    // Method to find the partition index
    // @param array - array of integers size n
    // @param first - first position
    // @param last  - last position
    // @return - integer
    private static int partition(int[] array, int first, int last) {
        int pivot = array[last];
        int j = first - 1;
        for (int i = first; i < last; i++) {
            if (array[i] < pivot) {
                j = j + 1;
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        j = j + 1;
        int temp = array[j];
        array[j] = array[last];
        array[last] = temp;
        return j;
    }

    // sorting using heapSort
    // @param array of integers as argument.
    public static void heapSort(int[] array) {

        int n = array.length;

        // to build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeap(array, n, i);
        }
        // Extract element one at a time from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // call max heapify on the reduced heap
            maxHeap(array, i, 0);
        }
    }

    // maxHeap method to heap a subtree rooted with node i which is an index in array[]. n is the size of heap.
    // @param array - array of integers as an argument
    // @param n     - argument from heapSort
    // @param i     - argument from heapSort
    private static void maxHeap(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            // Recursively heap the affected subtree
            maxHeap(array, n, largest);
        }
    }
}