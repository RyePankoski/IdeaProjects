import java.util.Scanner;

public class Acidityme {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		double UI = 0;

		do {
			UI = input.nextDouble(); // UI = user input
			String x = null;

			if (UI > 0 && UI < 3)
				x = "a very acidic";
			else if (UI >= 3 && UI < 7)
				x = "an acidic";
			else if (UI == 7)
				x = "a neutral";
			else if (UI > 7 && UI < 12)
				x = "an alkaline";
			else if (UI >= 12 && UI <= 14)
				x = "a very alkaline";

			if (UI >= 0 && UI <= 14)
				System.out.printf("Your rainwater has a pH of %.4f and is %s solution.\n", UI, x);
			else if (UI != -1)
				System.out.println("Value exceeds possible range.");
		} while (UI != -1);
		System.out.println("Goodbye world");
		input.close();
	}
}
