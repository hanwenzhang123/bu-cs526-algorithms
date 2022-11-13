import LinkedList.DoublyLinkedList;

public class Hw2_p3 {

	// implement reverse method
	// you may want to write a separate method with additional parameters, which is recursive

	/**
	 * This method is used as the recursion method
	 * - a function that defined itself by implementing repeated execution of statements
	 * - where a method invokes itself until the condition meets its baseline and recursion stops
	 * - it also uses a callstack structure that follows LIFO which we can reverse the intList
	 * - the call stack windup before the recursive call, then after the recursive call meets its baseline
	 * - the call stack unwinds down due to its call stack nature
	 * - where recursion happened and then something happened after the recursive call.
	 * @param intList - takes the initial DoublyLinkedList intList from the main method
	 */
	public static void reverse(DoublyLinkedList<Integer> intList) {
		// complete this method
		if(!intList.isEmpty()) {	//base condition that stops the recursion execution
			int storedEle = intList.first();	//store the element to variable storedEle
			intList.removeFirst();	//remove the first element off from the intList
			reverse(intList);	//recursion method - call itself until the baseline met
			intList.addLast(storedEle);		//unwinding down the storedEle after the recursion call, and add it back to  the intList
		}									//since recursion uses callstack and follows a LIFO (Last-In-First-Out) approach
	}										//the storedEle will be added to intList as reverse order compared to the original intList

	// use the main method for testing
	// test with arrays of different lenghts
	public static void main(String[] args) {
		
		DoublyLinkedList<Integer> intList = new DoublyLinkedList<>();
		
		int[] a = {10, 20, 30, 40, 50};
		for (int i=0; i<a.length; i++) {
			intList.addLast(a[i]);
		}
		System.out.println("Initial list: size = " + intList.size() + ", " + intList.toString());
		
		// Here, invoke the reverse method you implemented above
		reverse(intList);
		
		System.out.println("After reverse: " + intList.toString());
		
		intList = new DoublyLinkedList<>();
		int[] b = {10, 20, 30, 40, 50, 60};
		for (int i=0; i<b.length; i++) {
			intList.addLast(b[i]);
		}
		System.out.println();
		System.out.println("Initial list: size = " + intList.size() + ", " + intList.toString());
		
		// Here, invoke the reverse method you implemented above
		reverse(intList);
		
		System.out.println("After reverse: " + intList.toString());

	}

}
