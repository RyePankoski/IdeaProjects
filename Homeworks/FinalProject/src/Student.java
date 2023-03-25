import java.util.ArrayList;

class Student {

    private String name;
    private String email;
    private int studentNumber;

    public Student(String name, String email, int stnum) {

        this.name = name;
        this.email = email;
        this.studentNumber = stnum;

    }

    public String getKidName() {
        return this.name;
    }

    public String toString() {

        String str = name + " " + email + " " + studentNumber;
        return str;

    }
}

class Book {

    private int bookId;
    private String bookName;
    private String author;

    public String getBookName() {
        return this.bookName;
    }


    public Book(int bookId, String name, String author) {

        this.bookId = bookId;
        this.bookName = name;
        this.author = author;

    }

    public String toString() {

        String str = bookId + " " + bookName + " " + author;
        return str;
    }
}

class Library {

    ArrayList<Student> roster = new ArrayList<Student>();
    ArrayList<Book> catalog = new ArrayList<Book>();

    public int searchMembers(String name) {

        for (int kidArrayIndex = 0; kidArrayIndex < roster.toArray().length - 1; ++kidArrayIndex) {

            Student kidThere = roster.get(kidArrayIndex);

            String thatKid = kidThere.getKidName();

            if (thatKid == name) {
                return kidArrayIndex;
            }
        }
        return -1;
    }


    public int addMember(String name, String email, int num) {

        boolean hasDotAndThree = false;

        boolean hasAt = email.contains("@");

        if ((email.charAt(email.length() - 4) == '.')) {
            hasDotAndThree = true;
        }

        if ((hasAt) && (hasDotAndThree)) {
            roster.add(new Student(name, email, num));
            return 1;
        } else
            return -1;
    }

    public void deleteMember(String name) {

        int index = searchMembers(name);

        if (index == -1) {
            return;
        }
        roster.remove(index);

    }

    public void addBook(int bookId, String bookName, String author) {

        Book CS1050 = new Book(bookId, bookName, author);
        catalog.add(CS1050);

    }

    public int searchbook(String bookName) {

        for (int bookArrayIndex = 0; bookArrayIndex < catalog.toArray().length - 1; ++bookArrayIndex) {

            Book bookThere = catalog.get(bookArrayIndex);

            String thatBook = bookThere.getBookName();

            if (thatBook == bookName) {
                return bookArrayIndex;
            }
        }
        return -1;
    }

    public void lendBook(String bookName) {

        int bookIndex = searchbook(bookName);

        if (bookIndex == -1) {
            return;
        }
        catalog.remove(bookIndex);
    }

    public void returnbook(Book toReturn) {

        catalog.add(toReturn);
    }

    public void prnstudents() {
        System.out.println(roster);
    }

    public void prnBook() {
        System.out.println(catalog);
    }
    public static void main(String[] args)
    {
        Library MSULibrary= new Library();
        int done = MSULibrary.addMember("Jeff", "jeff@gmail.com", 789012);
        done = MSULibrary.addMember("Michael","mwhitehill@gmail.com", 3254156);
        done = MSULibrary.addMember("Nick","nwhitehill@gmail.com",123456789);

        MSULibrary.deleteMember("Jeff");
        MSULibrary.addBook(1, "GRIT","Duckworth");
        MSULibrary.addBook(16745,"The boat","John Seaworthy");
        MSULibrary.addBook(1578,"Darkness rising","Alvin Tenebrous");

        int num= MSULibrary.searchbook("GRIT");

        MSULibrary.lendBook("The boat");

        Book myBook = new Book(16745, "The boat", "John Seaworthy");

        MSULibrary.returnbook(myBook);

        MSULibrary.prnstudents();
        MSULibrary.prnBook();
    }
}

