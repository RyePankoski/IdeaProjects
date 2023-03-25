/*
 * CS2050 - Computer Science II - Fall 2022
 * Instructor: Thyago Mota
 * Student(s) Name(s):
 * Description: prg_01 - Element
 */

import java.util.Objects;

/**
 * A Molecule is a specialized linked list that uses chain of Node objects carrying Elements. A Molecule has a name (for example, “Carbon Dioxide” or “Caffeine”).
 */
public class Molecule extends LinkedList<Element> {

    private final String name;

    // TODOd: initialize the molecule with the information provided by the user
    public Molecule(final String name) {
        super(); // leave it: need to call LinkedList parent's constructor
        this.name = name;
    }


    // TODO: provide an implementation consistent with the following:
    //  1. The elements in a molecule must be distinct; therefore, the add method should prevent adding an element that is already in the molecule
    //  2. The elements in a molecule must respect the Hill system, which states that carbon atoms are listed first, hydrogen atoms next, and then all other elements are added in alphabetical order.
    @Override
    public void add(final Element element) {
        Node<Element> node = super.head;

        if (element.getAtomLetter() == null){
            return;
        }

        if (head == null) {
            super.add(element);
            return;
        }

        int index = 0;
        while (node != null) {

            int weight = node.getValue().compareTo(element);

            if (weight == 0) {
                return;
            }

            if (weight < 0) {
                if (index == 0){
                    super.add(element);
                } else {
                    super.insert(index, element);
                }
                return;
            }

            node = node.getNext();
            index++;

        }
        super.append(element);
    }

//        Node<Element> node = super.head;
//
//        if (element.getAtomLetter() == null){
//            return;
//        }
//
//        if (head == null) {
//            super.add(element);
//            return;
//        }
//
//        do {
//            boolean isSame = node.getValue().getAtomLetter().equals(element.getAtomLetter());
//            if (isSame) {
//                return;
//            }
//                node = node.getNext();
//        } while (node != null && node.hasNext());
//
//        if ( "C".equals(element.getAtomLetter())) {
//            super.add(element);
//        } else if ("H".equals(element.getAtomLetter())) {
//            if (super.size() > 0 && !"C".equals(head.getValue().getAtomLetter())) {
//                super.add(element);
//            } else {
//                super.insert(1,element);
//            }
//        } else {
//            do {
//
//                node = super.head;
//
//                int weight = node.getValue().getAtomLetter().compareTo(element.getAtomLetter());
//
//                int index = 0;
//
//                if (weight > 0) {
//                    super.insert(index, element);
//                    return;
//                }
//                node = node.getNext();
//                ++index;
//            } while (node.hasNext());
//            super.append(element);
//        }
//    }


    // TODO: provide an implementation consistent with the following:
    // * the name of the molecule should be returned in double quotes followed by a colon and the molecule’s elements and amounts;
    // * only the atom letter of each element must be returned (do not return the name of the element);
    // * the amount follows the element’s atom letter with an underscore character in between;
    // * if the amount is one, it should be omitted.
    @Override
    public String toString() {
        if (super.head == null){
            return "Molecule Not Init";
        }

        String finalString = "\"" + name + "\"" + ":";
        Node<Element> node = super.head;

        do {
            finalString += node.getValue().toString();
            node = node.getNext();

        } while (node != null);

        return finalString;
    }
}
