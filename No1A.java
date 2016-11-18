package Solved;

import java.math.BigInteger;
import java.util.Scanner;

public class No1A {
	// Solved.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a = sc.nextInt();
		
		BigInteger noHorizontal = new BigInteger("" + n/a);
		BigInteger noVertical = new BigInteger("" + m/a);

		if (n%a != 0) {
			noHorizontal = noHorizontal.add(new BigInteger("1"));
		}

		if (m%a != 0) {
			noVertical = noVertical.add(new BigInteger("1"));
		}
		
		
		System.out.println(noHorizontal.multiply(noVertical).toString());
	}
}
