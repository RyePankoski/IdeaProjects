public class Holiday {

    private String name;
    private String month;
    private int day;

   public Holiday(String name, String month, int day){
       this.name = name;
       this.month = month;
       this.day = day;
   }

   public boolean isSameMonth(Holiday other){
       boolean isSame = (this.month == other.month);
       return isSame;
   }

   public String toString(){
       String stringProps = new String(name + " " + month + " " + day);
       return stringProps;
   }

    public static void main(String[] args){
        Holiday halloween = new Holiday("Halloween","October",31 );
        Holiday independenceDay = new Holiday("independenceDay", "July", 4);
        System.out.println(halloween.isSameMonth(independenceDay));
    }
}
