package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Divide operation.
 */
public class Divide {
    // TODO - add your solution here.
    int quotient;
    int remainder;

    public Divide(int argumentOne, int argumentTwo) {

    // try dividing number1/number2 and number1%number2 (remainder)
       try {
        quotient = argumentOne / argumentTwo;
        remainder = argumentOne % argumentTwo;

    //catch error (dividing by 0)
    } catch (ArithmeticException e) {

           System.out.println("Cannot divide by 0! " + e);
    }

}


    //returns quotient and remainder
    public String toString() {

        return String.valueOf(quotient) + " R:" + String.valueOf(remainder);}

//returns text if second number=0
    public String Error() {

        return " Cannot divide by 0!";}
}
