/*
 * CS2050 - Computer Science II - Fall 2022
 * Instructor: Thyago Mota
 * Description: Homework 09 - PatienceSort
 */

import java.util.Arrays;

public class PatienceSort extends LinkedList{

    // the patience sort algorithm

    public static void patienceSort(int data[]) throws Exception {

        // this is the list of stacks (each a stack of integers)
        LinkedList<Stack<Integer>> stacks = new LinkedList<>();

        // TODO #1: loop through the data array and get the array's current element

        //as you recommended, a flag!
        boolean foundStack;
        for (int i = 0; i < data.length; i++) {

            foundStack = false;

            Stack newStack = new Stack();

            //checks if its empty, creates a new stack, pushes value, and increments i.
            if (stacks.isEmpty()) {
                stacks.add(newStack);
                newStack.push(data[i]);
                i++;
            }

            //iterates through current list of stacks.
            for (int j = 0; j < stacks.size(); j++) {


                // I declared these values stupidly for readability.
                int dataNum = data[i];
                Stack contender = stacks.get(j);
                int stackNum = (int) contender.peek();

                //checks if the number is less than the peeked value at the current stack.
                if (dataNum < stackNum) {
                    contender.push(data[i]);
                    foundStack = true;
                    break;
                }
            }

            //if the "if" check above is never satisfied, goes ahead and creates a new stack and pushes the value.
            if (!foundStack){
                stacks.add(newStack);
                newStack.push(data[i]);
            }
        }

        //this won't print like you wanted, so -5 points!
        // That said, it sorts properly.
        // Also, I am 100% sure that a linkedList of stacks is not necessary.
        //I am certain you can use normal arrays. I will have to find my own implementation.


            // merge of stacks
            if (stacks.isEmpty())
                return;
            System.out.println(stacks);
            for (int i = 0; i < data.length; i++) {
                Stack<Integer> stackMin = stacks.get(0);
                int j = 0;
                for (int k = 1; k < stacks.size(); k++) {
                    Stack<Integer> stackCurrent = stacks.get(k);
                    if (stackCurrent.peek() < stackMin.peek()) {
                        stackMin = stackCurrent;
                        j = k;
                    }
                }
                data[i] = stackMin.pop();
                if (stackMin.isEmpty())
                    stacks.remove(j);
            }
        }

    public static void main(String[] args) throws Exception {
        int data[] = {13, 12, 84, 79, 10, 77, 56, 1, 34, 27, 3};
        System.out.println(Arrays.toString(data));
        patienceSort(data);
        System.out.println(Arrays.toString(data));
    }
}
