import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class No584A {
	// Solved.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		String answer = "";
		if (t == 10) {
			if (n == 1) {
				answer = "-1";
			}
			else {
				answer = "1";
				for (int i = 0; i < n-1; i++) {
					answer += "0";
				}
			}
		}
		else {
			for (int i = 0; i < n; i++) {
				answer += t;
			}
		}
		System.out.println(answer);
	}
}
