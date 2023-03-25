/*
 * CS2050 - Computer Science II - Fall 2022
 * Instructor: Thyago Mota
 * Student(s) Name(s):
 * Description: prg_03 - PokemonDriver
 */

import java.io.*;
import java.util.Scanner;

public class PokemonDriver {

    // TODOd #10: open the CSV filename and use it to create a return a PokemonCollection of the given type1
    static PokemonCollection load(String filename, String type1) throws IOException {


        PokemonCollection newCollection = new PokemonCollection(type1);
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        boolean isFirstLine = true;

        while ((line = reader.readLine()) != null) {

            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }

            String[] data = line.split(",");


            Pokemon currentPokemon = new Pokemon(data[1], data[2], data[3], Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]), Integer.parseInt(data[8]), Integer.parseInt(data[9]), Integer.parseInt(data[10]), Integer.parseInt(data[11]), Boolean.parseBoolean(data[12]));

            newCollection.filterAdd(currentPokemon);

        }
        reader.close();
        return newCollection;
    }

    // TODOd #11: create a PokemonCollection using "load" and then allow users to search for pokemon cards in the collection
    public static void main(String[] args) throws IOException {

        Scanner skan = new Scanner(System.in);
        PokemonCollection collection = new PokemonCollection();
        System.out.println("Preparing to load pokemon collection.");
        System.out.println("Enter file name.");
        String filename = skan.next();
        System.out.println("Enter a type, or enter \"skip\" to continue");
        String type = skan.next();

        if (type.equals("skip")) {
            collection = load(filename, null);
        } else {
            collection = load(filename, type);
        }

        System.out.println("Search for a card by entering its name");
        String name = skan.next();
        System.out.println(collection.search(name));
        System.out.println(collection);
    }
}
