/*
 * CS2050 - Computer Science II - Fall 2022
 * Instructor: Thyago Mota
 * Student(s) Name(s):
 * Description: prg_01 - MoleculeDriver
 */

public class MoleculeDriver {

    public static void main(String[] args) {

        // creating "Carbon Dioxide: CO_2"
        Element C = new Element("C", "carbon");
        Element O = new Element("O", "oxygen", 2);
        Molecule co2 = new Molecule("Carbon Dioxide");
        co2.add(O);
        co2.add(C);
        System.out.println(co2);

        // creating "Caffeine: C_8H_10N_4O_2"
        C = (Element) C.clone();
        C.setAmount(8);
        Element N = new Element("N", "nitrogen", 4);
        Element H = new Element("H", "hydrogen", 10);
        O = (Element) O.clone();
        O.setAmount(2);
        Molecule caffeine = new Molecule("Caffeine");
        caffeine.add(N);
        caffeine.add(O);
        caffeine.add(H);
        caffeine.add(C);
        System.out.println(caffeine);

        // TODO: create your favorite molecule

        //Creating Hemoglobin
        Molecule hemoglobin = new Molecule("Hemoglobin");
        C.setAmount(49);
        H.setAmount(56);
        O.setAmount(6);
        N.setAmount(4);
        Element Fe = new Element("Fe", "Iron", 1);
        hemoglobin.add(C);
        hemoglobin.add(H);
        hemoglobin.add(O);
        hemoglobin.add(N);
        hemoglobin.add(Fe);
        System.out.println(hemoglobin);





    }

}
