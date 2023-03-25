import java.util.Scanner;

public class Acidity {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		double UI = input.nextDouble(); // UI = user input
		String x = null;

		if (UI <= 0)
			x = "not a valid";
		else if (UI > 0 && UI < 3)
			x = "a very acidic";
		else if (UI < 7)
			x = "an acidic";
		else if (UI == 7)
			x = "a neutral";
		else if (UI < 12)
			x = "an alkaline";
		else if (UI <= 14)
			x = "a very alkaline";
		else
			x = "not a valid";
			System.out.printf("Your rainwater has a pH of %.4f and is %s solution.\n", UI, x);
		input.close();
	}
}
