/*
 * CS2050 - Computer Science II - Fall 2022
 * Instructor: Thyago Mota
 * Student(s) Name(s):
 * Description: prg_01 - Element
 */

import java.sql.DataTruncation;
import java.util.Locale;

/**
 * A chemical element is a pure substance that consists of one type of atom and it is represented in this project by the Element class. Users can create an element by informing its atom letter, name, and amount (the last 2 have default values). Atom letters are always written in upper case. For example, element "C" is named "carbon". In this assignment, two element objects are considered to be equal if they have the same atom letter (regardless of their actual names and amounts).
 */
public class Element {

    private String atomLetter;
    private String name;
    private int amount;
    public static final int MIN_AMOUNT = 1;

    // TODOd: finish the generic constructor, making sure that atomLetter is (converted to) upper case, name is (converted to) lower case, and that element is at least MIN_AMOUNT
    public Element(String atomLetter, String name, int amount) {

        this.atomLetter = atomLetter.toUpperCase();
        this.name = name.toLowerCase();

        this.amount = amount < MIN_AMOUNT ? MIN_AMOUNT : amount;
    }

    // TODOd: finish this constructor, setting amount to MIN_AMOUNT; make sure that atomLetter is (converted to) upper case and that name is (converted to) lower case
    public Element(String atomLetter, String name) {

        this(atomLetter, name, MIN_AMOUNT);

    }

    // TODOd: finish this constructor, setting name to "" and amount to MIN_AMOUNT; make sure that atomLetter is (converted to) upper case
    public Element(String atomLetter) {

        this(atomLetter, "", MIN_AMOUNT);

    }

    // TODOd: implement getters and setters for all instance variables
    public String getAtomLetter() {
        return atomLetter;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAtomLetter(String atomLetter) {
        this.atomLetter = atomLetter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    // TODOd: override equals (two elements are considered to be equal if they have the same atom letter, regardless of their actual names and amounts)
    @Override
    public boolean equals(final Object obj) {

        Element other = (Element)obj;
        return atomLetter.equals(other.atomLetter);

    }

    // TODOd: override toString returning a string representation of an element
    @Override
    public String toString() {

        String element = atomLetter;

        if (amount > MIN_AMOUNT){
            element += "_" + amount;
        }

        return element;
    }

    // TODOd: override clone (return an exact copy of the element)
    @Override
    protected Object clone() {

        return new Element (this.atomLetter,this.name,this.amount);

    }

    public int compareTo(Element element){

        if (this.atomLetter.equals(element.getAtomLetter())){
            return 0;
        }
        if (element.atomLetter.equals("C")){
            return -1;
        }
        if (this.atomLetter.equals("C")){
            return 1;
        }
        if (element.atomLetter.equals("H")){
            return -1;
        }
        if (this.atomLetter.equals("H")){
            return 1;
        }
        return -1 * this.atomLetter.compareTo(element.atomLetter);

    }

}
