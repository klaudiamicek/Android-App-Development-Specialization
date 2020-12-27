package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Multiply operation.
 */
public class Multiply {
    // TODO - add your solution here.
    int product;

    //gets product of both numbers
    public Multiply(int argumentOne, int argumentTwo) {
        product = argumentOne * argumentTwo;
    }

    //returns product
    public String toString() {
        return String.valueOf(product);
    }
}
