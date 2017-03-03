import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class No572A {
	// Solved.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sizeA = sc.nextInt();
		int sizeB = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arrayA = new int[sizeA];
		int[] arrayB = new int[sizeB];
		
		for (int i = 0; i < sizeA; i++) {
			arrayA[i] = sc.nextInt();
		}
		for (int j = 0; j < sizeB; j++) {
			arrayB[j] = sc.nextInt();
		}
		
		if (arrayA[k-1] < arrayB[arrayB.length - m]) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
