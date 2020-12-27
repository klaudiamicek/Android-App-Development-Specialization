package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // TODO -- Fill in your code here
    //creating values to indicate swing direction

    //to swing outward
    public static final int OUT = -1;
    //to swing inward
    public static final int IN = 1;
    //to swing closed
    public static final int CLOSED = 0;

    int mSwing;

    public Gate(){
        mSwing = CLOSED;
    }
    //creates getter for the mSwing field
    public int getSwingDirection() {
        return mSwing;
    }
    //creates setter for the mSwing field
    public boolean setSwing(int direction) {
        //returns boolean value to indicate if swing direction parameter was valid
        if(direction == IN || direction == OUT || direction == CLOSED) {
            mSwing = direction;
            return true;
        }
        return false;
    }
//calls setSwing()helper method to set swing direction to passed value
    public boolean open(int direction) {
        // open gate to let snails in or out of the pen so check if direction IN or OUT
        if (direction == IN || direction == OUT) {
            this.setSwing(direction);
            return true;
        }
        return false;
    }

    public void close() {
        mSwing = 0;
    }


//creates method to control movement of snails in and out of pen
    public int thru(int count) {
        if(mSwing == IN)
            //number of snails in pen will increase by count
            return count;
        else if(mSwing == OUT)
            //count number of snails leave pen (so negative count is returned)
            return -count;
        else
            return 0;
    }

    @Override
    public String toString() {
        if(mSwing == 0)
            return "This gate is closed";
        else if(mSwing == IN)
            return "This gate is open and swings to enter the pen only";
        else if (mSwing == OUT)
            return "This gate is open and swings to exit the pen only";
        else
            return "This gate has an invalid swing direction";
    }
}
