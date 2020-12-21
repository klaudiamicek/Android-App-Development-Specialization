package mooc.vandy.java4android.calculator.logic;

import java.util.HashMap;

import mooc.vandy.java4android.calculator.ui.ActivityInterface;

/**
 * Performs an operation selected by the user.
 */
public class Logic implements LogicInterface {
    /**
     * Reference to the Activity output.
     */
    protected ActivityInterface mOut;

    
    /**
     * Constructor initializes the field.
     */
    public Logic(ActivityInterface out) {
        mOut = out;
        
    }


    /**
     * Perform the operation on argumentOne and argumentTwo.
     */
    public void process(int argumentOne, int argumentTwo, int operation) {
        // TODO - Put your code here.
        final int add = 1;
        final int subtract = 2;
        final int multiply = 3;


        //operations, creating object, printing solution

        //addition selected
        if(operation == add) {
                Add addition = new Add(argumentOne, argumentTwo);
                mOut.print(addition.toString());
            }
            //subtraction selected
            else if(operation == subtract) {
                Subtract subtraction = new Subtract(argumentOne, argumentTwo);
                mOut.print(subtraction.toString());
            }
            //multiplication selected
            else if (operation == multiply) {
                Multiply multiplication = new Multiply(argumentOne, argumentTwo);
                mOut.print(multiplication.toString());
            }
            //division selected
            else {
                //prints quotient if second number is not 0
                if (argumentTwo!=0)
                {Divide division = new Divide(argumentOne, argumentTwo);
                mOut.print(division.toString());}
                else{
                    //prints text (Cannot divide by 0!) if second number=0
                    {Divide division = new Divide(argumentOne, argumentTwo);
                        mOut.print(division.Error());}
                }
            }
    }
}
