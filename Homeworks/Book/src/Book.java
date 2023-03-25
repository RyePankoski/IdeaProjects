import java.util.Objects;
import java.util.Scanner;

public class Book {

    static final int maxPages = 300;
    String title;
    String author;
    String genre;
    int num_of_page;
    static boolean isLong = false;

    public String toString() {
        return "Title:" + title + "|" + "Author:" + author + "|" + "Genre:" + genre + "|" + "Number of Pages:" + num_of_page;
    }

    public Book(String title, String author, String genre, int num_of_page) {

        this.title = title;
        this.author = author;
        this.genre = genre;
        this.num_of_page = num_of_page;

        if (!(Objects.equals(genre, "fiction") || (Objects.equals(genre, "non-fiction") || (Objects.equals(genre, "technical") || (Objects.equals(genre, "biography")))))) {
            this.genre = "fiction";
            System.out.println("This is not a valid genre, book genre has been set to \"fiction\"");
        }
    }

    static void isLong(int pageNumber) {

        if (pageNumber > maxPages) {
            isLong = true;
        }
    }

    public static void main(String[] args) {

        Scanner skan = new Scanner(System.in);

        String title;
        String author;
        String genre;
        int num_of_page;

        System.out.println("Please enter a title.");
        title = skan.nextLine();

        System.out.println("Please enter an author.");
        author = skan.nextLine();

        System.out.println("Please enter a genre.");
        genre = skan.nextLine();

        System.out.println("Please enter the number of pages.");
        num_of_page = skan.nextInt();
        isLong(num_of_page);

        Book userBook = new Book(title, author, genre, num_of_page);

        System.out.print(userBook);
        System.out.println();
        System.out.println("Longer than 300 pages?" + " " + isLong);
    }
}
