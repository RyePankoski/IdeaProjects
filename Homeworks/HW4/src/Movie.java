public class Movie {

    private String title;
    private String studio;
    private String rating;

    public Movie(String title, String studio, String rating){
        this.title = title;
        this.studio = studio;
        this.rating = rating;
    }
    public Movie(String title, String studio){
        this(title, studio, "PG");
    }

    public String toString(){
        String stringProps = new String(title + " " + studio + " " + rating);
        return stringProps;
    }

    public static void main(String[] args){
        Movie casinoRoyale = new Movie("Casino Royale", "Eon Productions", "PG13");
        Movie casinoRoyale2 = new Movie("Casino Royale 2", "Eon Productions");

        System.out.println(casinoRoyale2);
    }
}
