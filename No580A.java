import java.math.BigInteger;
import java.util.Scanner;

public class No580A {
	// Solved.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int maxStreak = 0;
		int currentStreak = 0;
		int last = 0;
		
		for (int i = 0; i < n; i++) {
			int next = sc.nextInt();
			if (next >= last) {
				currentStreak ++;
				if (currentStreak > maxStreak) {
					maxStreak = currentStreak;
				}
			}
			else {
				currentStreak = 1;
			}
			last = next;
			
		}
		System.out.println(maxStreak);
	}
}
