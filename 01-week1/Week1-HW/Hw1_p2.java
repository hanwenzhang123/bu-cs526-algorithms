import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Hw1_p2 {

	public static void findByMake(Car[] cars, String make) {
		int counter = 0;	//use counter to count whether we have the make of the car in the array
		for (int i = 0; i < cars.length; i++) {		//loop through each car in the cars array by index
			String carMake = cars[i].getMake();		//get the make of the car for each car in the cars array
			if (carMake.equals(make)) {		//when we found a car has the make we are looking for
				counter++;			//counter plus one
				System.out.println(cars[i]);
			}
		}
		if (counter == 0) {	   //counter remains as 0 when no car has the make we are looking for
			System.out.println(make + " does not exist in cars");
		}
	}
	
	public static void olderThan(Car[] cars, int year) {
		int counter = 0;	//use counter to count whether there is a car has the year greater or equal to the year we are looking for
		for (int i = 0; i < cars.length; i++) {		//loop through each car in the cars array by index
			int carYear = cars[i].getYear();		//get the year of the car for each car in the cars array
			if (carYear >= year) {		//when we found a car has the year greater or equal to the year we are looking for
				counter++;		//counter plus one
				System.out.println(cars[i]);
			}
		}
		if (counter == 0) {
			System.out.println("No cars are greater than or equal to year " + year);   //counter remains as 0 when no car has the year greater or equal to the year we are looking for
		}
	}
	
	public static void main(String[] args) throws IOException {

		// complete this part
		// create an array of Car objects, cars, of size 10
		// read input file and store 10 car Objects in the array
		Car[] cars = new Car[10];		//declare an array of Car objects called cars with size 10
		File file = new File("CS526_car_input.txt");	//create new file instance with car input file
		Scanner input = new Scanner(file);		//initialize the scanner to read from the specified file

		for (int i = 0; i < cars.length; i++) {
			String readLine = input.nextLine();			// store current line being read to the variable readLine, each loop just go to next one
			String[] arrayL = readLine.split(",\\s+");	// use split function to use ", " as a separator to separate each element stores in an array
			String make = arrayL[0];					// the first element is the make; store the make into its own string variable
			int price = Integer.parseInt(arrayL[1]);	// the second element is the price; convert it from string to int and store into its own int variable
			int year = Integer.parseInt(arrayL[2]);		// the third element is the year; convert it from string to int and store into its own int variable
			Car newCar = new Car(make, year, price);	// create a new object based on the Car class
			cars[i] = newCar;							// store the new car object into the cars array we declared above
		}

		input.close();		//Close the file, free resources

		System.out.println("\nAll cars:");
		for (int i=0; i<cars.length; i++) {
			System.out.println(cars[i]);
		}

		String make = "Honda";
		int year = 2017;

		System.out.println("\nAll cars made by " + make);
		findByMake(cars, make);
		System.out.println("\nAll cars made before " + year);
		olderThan(cars, year);
	}

}
