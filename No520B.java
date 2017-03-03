import java.util.Scanner;

public class No520B {
	// Solved.
	
	// The device can either *2 or -1. The shortest path from the start to end does *2 as much as 
	// possible. My solution works backward starting at the result, by dividing the number 
	// repeatedly until it is less than the beginning. If the number is odd, it is changed to even.
	// Finally, after the number is lower than the start, the difference between the two is the
	// number of times to press the -1 button. 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int presses = 0;
		// If m is odd, then make it even
		if (m%2 != 0) {
			m += 1;
			presses += 1;
		}
		// Keep dividing the desired result by two until it is smaller than the starting no.
		while (m > n){
			m /= 2;
			presses += 1;
			if (m == n) {
				break;
			}
			if (m%2 != 0) {
				m += 1;
				presses += 1;
			}
		}
		// Adds the number of times you would need to hit the subtract button
		presses += (n - m);
		System.out.println(presses);
	}
}
