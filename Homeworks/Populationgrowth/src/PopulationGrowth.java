import java.util.Scanner;

public class PopulationGrowth {
    public static void main(String[] args) {
        Scanner skan = new Scanner(System.in);

        int year = 0;

        System.out.println("Enter initial population");
        int population = skan.nextInt();
        System.out.println("Enter birth rate");
        double birthRate = skan.nextDouble();
        System.out.println("Enter death rate");
        double deathRate = skan.nextDouble();
        System.out.println("Enter time frame");
        int timeFrame = skan.nextInt();

        System.out.printf("%-30.30s  %-30.30s%n", "Year", "Population");
        System.out.printf("%-30.30s  %-30.30s%n", year, population);

        double growthRate = (birthRate - deathRate);

        while (timeFrame > 1) {
            double populationChange = (population * growthRate);
            population = (int) (populationChange + population);
            ++year;
            System.out.printf("%-30d  %-30.30s%n", year, population);
            --timeFrame;
            if (population <= 0) {
                System.out.println("Population has gone extinct.");
                return;
            }
        }
        skan.close();
    }
}

