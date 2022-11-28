import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
public class Hw4_P6 {
    public static void main (String[] args){
        // Create a HashMap instance myMap, an ArrayList instance myArrayList, a LinkedList instance myLinkedList
    	HashMap<Integer, Integer> myMap = new HashMap<Integer,Integer>();
        ArrayList<Integer> myArrayList = new ArrayList<Integer>();
        LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
        
        // variables to track insert time and search time for each data structures
        double mapInsert = 0.0, arrayInsert = 0.0, linkedInsert = 0.0;
        double mapSearch = 0.0, arraySearch = 0.0, linkedSearch = 0.0;

        // variables as counters to repeat the following loop 10 times
        int i, j, l;
        int iterations = 10;

        // repeat the following 10 times and calculate average total insertion time and average total search time for each data structure.
        for (i = 0; i < iterations; i++){
            // initialize double variables to count time
            double startTime, endTime, elapsedTime;

            // generate n random integers between 1 and N using Random
            Random r = new Random(System.currentTimeMillis());

            // INSERT
            // initialize arrays - generate 100,000 distinct random integers in the range [1, 1,000,000] and store them in the array of integers insertKeys[ ]
        	int[] insertKeys = new int[100000];

            // generate 100,000 distinct random integers in the range [1, 1,000,000] and store them in the array of integers insertKeys[ ]
            for(j = 0; j < insertKeys.length; j++) {
                int tempValue = r.nextInt(1000000)+1;
                boolean exist = false;
                // see if the random integer already exist in array to keep it unique
                for(l = 0; l < j; l++){
                	if(tempValue == insertKeys[l]) { // already exist, no longer unique
                        exist = true;
                        j--;    // decrement counter so that insertKeys filled with 100000 unique random numbers
                	}

                }
                if(exist == false){ // not exists yet, added tempValue to the key
                	insertKeys[j] = tempValue;
                }
            }
            System.out.println("insert keys: " + insertKeys.length);

	         // pass insertKeys to myMap and capture time taken to insert these 100000 keys
            startTime = System.currentTimeMillis();
            for(j = 0; j < insertKeys.length; j++) {
            	// insert key,value into myMap
            	myMap.put(insertKeys[j], insertKeys[j]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            mapInsert += elapsedTime;

            //print statement for tracking
            System.out.println("insert map: " + elapsedTime + "-" + myMap.size());
            
	         // pass insertKeys to myArrayList and capture time taken to insert these 100000 keys
            startTime = System.currentTimeMillis();
            for(j = 0; j < insertKeys.length; j++) {
            	// insert key into myArrayList
            	myArrayList.add(insertKeys[j]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            arrayInsert += elapsedTime;
            
            // print statement for tracking
            System.out.println("insert array: " + elapsedTime + "-" + myArrayList.size());
            
            // pass insertKeys to LinkedList and capture time taken to insert these 100000 keys
            startTime = System.currentTimeMillis();
            for(j = 0; j < insertKeys.length; j++) {
                 // insert key into myLinkedList
                 myLinkedList.add(insertKeys[j]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            linkedInsert += elapsedTime;

            // print statement for tracking
            System.out.println("insert LinkedList: " + elapsedTime + "-" + myLinkedList.size());
            
            // reset seed
            r.setSeed(System.currentTimeMillis());


            // SEARCH
            // initialize arrays - generate 100,000 distinct random integers in the range [1, 2,000,000] and store them in the array searchKeys[ ]
            int[] searchKeys = new int[100000];

            // generate 100,000 distinct random integers in the range [1, 2,000,000] and store them in the array searchKeys[ ].
            for(j = 0; j < searchKeys.length; j++){
                int tempValue = r.nextInt(2000000)+1;
                boolean exist = false;
                // see if the random integer already exist in array to keep it unique
                for(l = 0; l < j; l++){
                    if(tempValue == insertKeys[l]) { // already exist, no longer unique
                        exist = true;
                        j--;    // decrement counter so that insertKeys filled with 100000 unique random numbers
                    }

                }
                if(exist == false){ // not exists yet, added tempValue to the key
                    insertKeys[j] = tempValue;
                }
            }

            //print statement for tracking
            System.out.println("searchKeys: " + searchKeys.length);
            
	         // pass searchKeys to map to capture time taken to search these 100000 keys
            startTime = System.currentTimeMillis();
            for(j = 0; j < searchKeys.length; j++) {
            	// search myMap for key
            	myMap.containsKey(searchKeys[j]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            mapSearch += elapsedTime;

            // print statement for tracking
            System.out.println("search map: " + elapsedTime + "-" + myMap.size());
            
	         // pass searchKeys to Arraylist to capture time taken to search these 100000 keys
            startTime = System.currentTimeMillis();
            for(j = 0; j < searchKeys.length; j++) {
            	// search myArrayList for key
            	myArrayList.contains(searchKeys[j]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            arraySearch += elapsedTime;
            
            //print statement for tracking
            System.out.println("search ArrayList: " + elapsedTime + "-" + myArrayList.size());
            
            // pass searchKeys to LinkedList and capture time taken to search these 100000 keys
            startTime = System.currentTimeMillis();
            for(j = 0; j < searchKeys.length; j++) {
	            // search myLinkedList for key
	            myLinkedList.contains(searchKeys[j]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            linkedSearch += elapsedTime;

            //print statement for tracking
            System.out.println("search LinkedList: " + elapsedTime + "-" + myLinkedList.size());

            // reset seed
            r.setSeed(System.currentTimeMillis());
            
            //print statement for tracking
            System.out.println("Before Clear: " + myMap.size() + myArrayList.size() + myLinkedList.size());

            // clear all data structure
            myMap.clear();
            myArrayList.clear();
            myLinkedList.clear();
            insertKeys = null;
            searchKeys = null;
            
            //print statement for tracking
            System.out.println("After Clear: " + myMap.size() + myArrayList.size() + myLinkedList.size());
            System.out.println();
        }

        // Print out the average insertion time
        System.out.println("Number of keys = 100000");
        System.out.println();
        System.out.println("HashMap average insert time = " + String.format("%.2f",mapInsert/iterations));
        System.out.println("ArrayList average insert time = " + String.format("%.2f", arrayInsert/iterations));
        System.out.println("LinkedList average insert time = " + String.format("%.2f", linkedInsert/iterations));
        System.out.println();
        System.out.println("HashMap average search time = " + String.format("%.2f",mapSearch/iterations));
        System.out.println("ArrayList average search time = " + String.format("%.2f", arraySearch/iterations));
        System.out.println("LinkedList average search time = " + String.format("%.2f", linkedSearch/iterations));
    }
}