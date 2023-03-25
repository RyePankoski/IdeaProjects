/*
 * CS2050 - Computer Science II - Fall 2022
 * Instructor: Thyago Mota
 * Student(s) Name(s):
 * Description: prg_03 - BST
 */

public class BST<E extends Comparable<E>> {

    protected BSTNode<E> root;

    public BST() {
        root = null;
    }

    // TODOd #2: return the number of elements in the BST from the given current node
    private int sizeRecursively(BSTNode<E> current) {
        if (current == null) {
            return 0;
        }
        // count self + left child + right child
        return 1 + sizeRecursively(current.getLeft()) + sizeRecursively(current.getRight());
    }

    // TODOd #3: return the number of elements in the BST
    public int size() {
        return sizeRecursively(root);
    }

    // TODOd #4: return the height of the BST from the current node
    private int heightRecursively(BSTNode<E> current) {

        if (current == null) {
            return -1;
        }

        int left = heightRecursively(current.getLeft());
        int right = heightRecursively(current.getRight());

        if (left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }

    // TODOd #5: return the height of the BST
    public int height() {
        return heightRecursively(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    protected void addRecursively(BSTNode<E> current, final E value) {

        if (current == null) {
            root = new BSTNode<>(value);
        } else {

            if (value.compareTo(current.getValue()) < 0) {
                if (current.getLeft() == null)
                    current.setLeft(new BSTNode<>(value));
                else
                    addRecursively(current.getLeft(), value);
            } else if (value.compareTo(current.getValue()) > 0) {
                if (current.getRight() == null)
                    current.setRight(new BSTNode<>(value));
                else
                    addRecursively(current.getRight(), value);
            }
        }
    }

    public void add2(final E value) {
        if (isEmpty())
            root = new BSTNode<>(value);
        else
            addRecursively(root, value);
    }

    @Override
    public String toString() {
        String out = "";
        Queue<BSTNode<E>> qu = new Queue<>();
        if (root != null) {
            qu.push(root);
            while (!qu.isEmpty()) {
                try {
                    BSTNode<E> temp = qu.pop();
                    out += temp + " ";
                    if (temp.getLeft() != null)
                        qu.push(temp.getLeft());
                    if (temp.getRight() != null)
                        qu.push(temp.getRight());
                } catch (Exception e) {
                }
            }
        }
        return out;
    }

    private boolean searchRecursively(final BSTNode<E> current, final E value) {
        if (value.compareTo(current.getValue()) == 0)
            return true;
        else if (value.compareTo(current.getValue()) < 0) {
            if (current.getLeft() == null)
                return false;
            else
                return searchRecursively(current.getLeft(), value);
        } else {
            if (current.getRight() == null)
                return false;
            else
                return searchRecursively(current.getRight(), value);
        }
    }

    public boolean search(final E value) {
        if (isEmpty())
            return false;
        else
            return searchRecursively(root, value);
    }

    public String inOrder(final BSTNode<E> current) {
        if (current == null)
            return "";
        return inOrder(current.getLeft()) + " " + current + " " + inOrder(current.getRight());
    }

    public String preOrder(final BSTNode<E> current) {
        if (current == null)
            return "";
        return current + " " + preOrder(current.getLeft()) + " " + preOrder(current.getRight());
    }

    public String postOrder(final BSTNode<E> current) {
        if (current == null)
            return "";
        return postOrder(current.getLeft()) + " " + postOrder(current.getRight()) + " " + current;
    }

    private int numberChildren(final BSTNode<E> current) {
        if (current == null)
            return 0;
        if (current.getLeft() == null && current.getRight() == null)
            return 0;
        if (current.getLeft() != null && current.getRight() != null)
            return 2;
        return 1;
    }

    private BSTNode<E> getLeftMost(final BSTNode<E> current) {
        if (current.getLeft() == null)
            return current;
        return getLeftMost(current.getLeft());
    }

    private BSTNode<E> removeRecursively(final BSTNode<E> current, final E value) {
        if (value.compareTo(current.getValue()) == 0) {
            // 1st case
            if (numberChildren(current) == 0) {
                return null; // so the parent node sets its (left/right) to null
            }
            // 2nd case
            if (numberChildren(current) == 1) {
                BSTNode<E> toBeReturned = null;
                if (current.getLeft() != null) {
                    toBeReturned = current.getLeft();
                    current.setLeft(null);
                } else {
                    toBeReturned = current.getRight();
                    current.setRight(null);
                }
                return toBeReturned;
            }
            // 3rd case
            BSTNode<E> toBeReturned = current.getRight();
            BSTNode<E> leftMost = getLeftMost(toBeReturned);
            leftMost.setLeft(current.getLeft());
            current.setLeft(null);
            current.setRight(null);
            return toBeReturned;
        } else if (value.compareTo(current.getValue()) < 0)
            current.setLeft(removeRecursively(current.getLeft(), value));
        else
            current.setRight(removeRecursively(current.getRight(), value));
        return current;
    }

    public void remove(final E value) {
        root = removeRecursively(root, value);
    }
}