import java.util.Iterator;
import net.datastructures.Entry;
import net.datastructures.HeapAdaptablePriorityQueue;

public class ProcessScheduling {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!!!" + "\n" + "ProcessScheduling starts to run!!!" + "\n");

        ProcessPriorityQueue PQ = new ProcessPriorityQueue(); //call ProcessPriorityQueue class to initiate the program
        HeapAdaptablePriorityQueue<Integer, Process> myPriorityQueue = PQ.getPriorityQueue();

        final int MAX_WAIT_TIME = 30; //initiate the MaxWaitTime which value will not be changed
        int totalWaitTime = 1; //initiate the totalWaitTime as one for now
        int currentTime = 0; //initiate the currentTime as zero for now
        int myPriorityQueueSize = myPriorityQueue.size(); // get size to calculate average at the end
        PQ.writeFileAndPrintOut("\nMaximum wait time = " + MAX_WAIT_TIME + "\n");

        while (true) {
            while (!myPriorityQueue.isEmpty()) { //The while loop will be break until priority queue is empty when all processes are completed
                Integer minPriority = (Integer) myPriorityQueue.min().getKey(); //minimum priority number, which will change in the for loop if another process has lower priority
                Process currentProcess = (Process) myPriorityQueue.min().getValue(); //minimum Process to be executed
                Iterator<Entry<Integer, Process>> value = myPriorityQueue.iterator(); //initiate iterator
                PQ.writeFileAndPrintOut("Now running Process id = " + currentProcess.processId);
                PQ.writeFileAndPrintOut("Arrival = " + currentProcess.arrivalTime);
                PQ.writeFileAndPrintOut("Duration = " + currentProcess.duration);
                PQ.writeFileAndPrintOut("Run time left " + currentProcess.duration + " at time "
                        + currentTime);
                PQ.writeFileAndPrintOut("Executed process ID : " + currentProcess.getProcessId() + " at time "
                        + currentTime + " Remaining: " + currentProcess.getDuration()); //writing process details to file

                if (value.hasNext()) { // iterating through the myPriorityQueue
                    HeapAdaptablePriorityQueue.AdaptablePQEntry<Integer, Process> tempProcess = (HeapAdaptablePriorityQueue.AdaptablePQEntry<Integer, Process>) value
                            .next();
                    Process tempProcessValue = tempProcess.getValue();
                    if (tempProcessValue.getArrivalTime() <= currentTime) { // If the process arrives by the time and if its priority is less than the previous process selected, set its priority as the minProcess and set it as the currentProcess.
                        if (Integer.parseInt(minPriority.toString()) < tempProcessValue.getPriority()) {
                            System.out.println("tempProcessValue.getPriority() = " + tempProcessValue.getPriority());
                            minPriority = tempProcessValue.getPriority();
                            currentProcess = tempProcessValue;
                        }
                    }
                }
                // Displaying the values after iterating through the queue
                boolean processCompleted = false; // determine if a process is completed in this iteration

                if (currentProcess.getArrivalTime() <= currentTime) { //check if the process arrives by the time, if not, increment the time
                    PQ.writeFileAndPrintOut("Finished running Process id = " + currentProcess.processId);
                    PQ.writeFileAndPrintOut("Arrival = " + currentProcess.arrivalTime);
                    PQ.writeFileAndPrintOut("Duration = " + currentProcess.duration);
                    PQ.writeFileAndPrintOut("Run time left " + currentProcess.duration + " at time "
                            + currentTime);
                    currentTime += currentProcess.arrivalTime;
                    totalWaitTime += currentProcess.duration; // add process waiting time to the total overall waiting time
                    myPriorityQueue.removeMin(); // remove the process from the queue
                    processCompleted = true; // indicates that process has been completed

                    if (myPriorityQueue.isEmpty()) { // if the queue is empty, break the loop
                        break;
                    }

                } else {
                    currentProcess.duration--; // decrement the duration of the process
                    currentTime++; // increment the time
                }

                if (processCompleted) {
                    while (value.hasNext()) { // iterate through the queue
                        HeapAdaptablePriorityQueue.AdaptablePQEntry<Integer, Process> tempProcess = (HeapAdaptablePriorityQueue.AdaptablePQEntry<Integer, Process>) value
                                .next();
                        Process tempProcessValue = tempProcess.getValue();
                        int tempArrivalTime = tempProcessValue.getArrivalTime();

                        if (tempArrivalTime <= currentTime) { // if process arrives by the time, increment its waiting time
                            tempProcessValue.arrivalTime++;
                            tempProcessValue.duration--;

                        }

                        if (tempArrivalTime > MAX_WAIT_TIME) { // if process has been waiting for more than the max wait time, remove it from the queue
                            PQ.writeFileAndPrintOut("Process " + tempProcessValue.getProcessId()
                                    + " reached maximum wait time... decreasing priority to "
                                    + tempProcessValue.priority++); //writing process details to file
                            tempProcessValue.priority++; // increment the priority of the process
                        }
                    }
                }
            }
            if (myPriorityQueue.isEmpty()) {
                break;
            }
        }
        
        // writing the totalWaitTime and the avg. totalWaitTime to the op file
        PQ.writeFileAndPrintOut("---------------------------");
        PQ.writeFileAndPrintOut("Finished running all processes at time " + currentTime);
        PQ.writeFileAndPrintOut("Average wait time " + totalWaitTime / myPriorityQueueSize);
        PQ.writeFileAndPrintOut("---------------------------");
        PQ.closeWriter(); // close the writer
    }
}