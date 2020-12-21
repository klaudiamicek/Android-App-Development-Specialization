package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Subtract operation.
 */
public class Subtract {
    // TODO - add your solution here.

    int difference;

    //gets difference of both numbers
    public Subtract(int argumentOne, int argumentTwo) {
        difference = argumentOne - argumentTwo;
    }

    //returns difference
    public String toString() {
            return String.valueOf(difference);

    }
}
