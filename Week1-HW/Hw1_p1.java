import java.util.Arrays;

public class Hw1_p1 {
	
	public static void find(int[] a, int x) {
		int counter = 0;	//use counter to count whether we get the int x or not in the array a
		for (int i = 0; i < a.length; i++) {	//using index to loop through each element in the array a
			if (x == a[i]) {	//if int x exits in the array a
				counter++;		//counter increase by one if int x in the array a
				System.out.println( x + " is in a[" + i + "]" );
			}
		}
		if (counter == 0) {		//counter remains as 0 when no int x found in the array a
			System.out.println(x + " does not exist.");
		}
	}
	
	public static boolean isPrefix(String s1, String s2) {
		for (int i = 0; i < s1.length(); i++) {		//assuming string s1 is shorter than s2, create a loop with index less than s1 length
			if (s1.charAt(i) != s2.charAt(i)) {		//loop through index char for the string, and check the char at the same index
				return false;	//return false when there a char is different
			}
		}
		return true;	//return true when there all chars pass the check
	}
	
	
	public static void main(String[] args) {
		
		int[] a = {5, 3, 5, 6, 1, 2, 12, 5, 6, 1};
		
		find(a, 5);
		find(a, 10);
		System.out.println();
		
		String s1 = "abc";
		String s2 = "abcde";
		String s3 = "abdef";
		
		if (isPrefix(s1,s2)) {
			System.out.println(s1 + " is a prefix of " + s2);
		}
		else {
			System.out.println(s1 + " is not a prefix of " + s2);
		}
		
		if (isPrefix(s1,s3)) {
			System.out.println(s1 + " is a prefix of " + s3);
		}
		else {
			System.out.println(s1 + " is not a prefix of " + s3);
		}
	}
}
