/*
 * CS2050 - Computer Science II - Fall 2022
 * Instructor: Thyago Mota
 * Student(s) Name(s):
 * Description: prg_03 - Pokémon Collection
 */

public class PokemonCollection extends BST<Pokemon> {

    private final String type1;

    public PokemonCollection(String type1) {
        this.type1 = type1;
    }

    public PokemonCollection() {
        this("");
    }

    // TODOd #6: add the given Pokémon card to the collection; if type1 is defined, check if the given Pokémon card has the same type1
    public void filterAdd(final Pokemon pokemon) {

        if (type1 == null || type1.equals(pokemon.getType1())) {
            this.addRecursively(this.root, pokemon);
        }
    }

    // TODOd #7: similar to EST's searchRecursively, returning a Pokémon reference (instead of true/false); return null if the Pokémon card is not found
    public Pokemon searchRecursively(final BSTNode<Pokemon> current, final Pokemon value) {

        if (value.compareTo(current.getValue()) == 0)
            return current.getValue();
        else if (value.compareTo(current.getValue()) < 0) {
            if (current.getLeft() == null)
                return null;
            else
                return searchRecursively(current.getLeft(), value);
        } else {
            if (current.getRight() == null)
                return null;
            else
                return searchRecursively(current.getRight(), value);
        }
    }

    // TODOd #8: similar to EST's search; however, this method takes the name of a Pokémon, and it should return avPokemon reference (instead of true/false); return null if the Pokémon card is not
    public Pokemon search(final String name) {




        Pokemon newPokemon = new Pokemon(name);
        return searchRecursively(root, newPokemon);

    }

    // TODOc #9: return a string representation of a Pokémon collection according to specifications in README file
    @Override
    public String toString() {

        String toBeReturned;
        if (type1 == null) {
            toBeReturned = "Welcome to my Pokemon Cards collection!\n";
            toBeReturned += "There are" + " " + size() + " " + "pokemon cards.\n";
            toBeReturned += "The pokemon cards are stored in a BST for optimized search.\n";
            toBeReturned += "The current height of the BST is" + " " + height();
        } else {
            toBeReturned = "Welcome to my Pokemon Cards collection!\n";
            toBeReturned += "This collection has pokemon cards of" + " " + type1 + " " + "type only.\n";
            toBeReturned += "There are" + " " + size() + " " + "pokemon cards.\n";
            toBeReturned += "The pokemon cards are stored in a BST for optimized search.\n";
            toBeReturned += "The current height of the BST is" + " " + height();
        }
        return toBeReturned;
    }
}
