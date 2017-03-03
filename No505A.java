import java.util.Scanner;

public class No505A {
	// Solved.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		boolean worked = false;
		for(int i = 0; i <= word.length(); i++) {
			String newword = word.substring(0, i) + "_" + word.substring(i, word.length());
			String guess = newword.replace('_', newword.charAt(newword.length() - 1 - newword.indexOf('_')));
			int counter = 0;
			for (int j = 0; j < guess.length()/2; j++) {
				if (guess.charAt(j) == guess.charAt(guess.length() - 1 - j)) {
					counter += 1;
				}
			}
			if (counter == guess.length()/2) {
				worked = true;
				System.out.println(guess);
				break;
			}
		}
		if (!worked) {
			System.out.println("NA");
		}
		
	}
}
