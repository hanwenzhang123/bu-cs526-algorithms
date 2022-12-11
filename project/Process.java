//Process class used to create process objects and implements comparable to compare the processes for the Priority Queue

public class Process {
    public int processId;   // process id
    public int priority;    // priority number
    public int arrivalTime; // the time when the process arrives at the system
    public int duration;    // execution of the process takes this amount of time

    // Constructor
    public Process (int processId, int priority, int arrivalTime, int duration) {
        this.processId = processId;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
    }

    // Getters
    public int getProcessId() {
        return processId;
    }

    public int getPriority() {
        return priority;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getDuration() {
        return duration;
    }

    // Print Information for each process
    public String returnProcessInformation() {
        return ("Id = " + getProcessId()
                + ", priority = " + getPriority()
                + ", duration = " + getDuration()
                + ", arrival time = " + getArrivalTime()
        );
    }

    // Setters
    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
