package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Add operation.
 */
public class Add {
    // TODO - add your solution here.
    int sum;

    //gets sum of both numbers
    public Add(int argumentOne, int argumentTwo) {

        sum = argumentOne + argumentTwo;
    }

    //returns sum
    public String toString() {
        return String.valueOf(sum);
    }

}
