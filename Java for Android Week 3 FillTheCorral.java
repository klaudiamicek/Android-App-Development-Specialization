package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }

    // TODO -- Fill your code in here
    //randomly sets each gate to swing IN (1), be CLOSED (0), or swing OUT (-1)
    public void setCorralGates(Gate[] gate,Random rand) {
        mOut.println("Initial gate setup:");
        for(int i=0;i<gate.length;i++){
            //generates random integer in range 0-2 and then -1
            gate[i].setSwing(rand.nextInt(3)-1);
            mOut.println("Gate " + i + ": " + gate[i].toString() );
        }
    }

    public boolean anyCorralAvailable(Gate[] corral){
        for(int i=0;i<corral.length;i++){
            //returns true if at least one gate in array set to swing IN
            if(corral[i].getSwingDirection() == Gate.IN)
                return true;
        }
        //returns false if all gates are set to OUT or CLOSED
        return false;
    }

    public int corralSnails(Gate[] corral,Random rand){
        int pasture_snails = 5;
        int count = 0;
        int s = 0;
        int G = 0;
        //simulation ends when all of the snails have been corralled
        while(pasture_snails > 0){
            //randomly selects gate
            G = rand.nextInt(corral.length);
            //generates random number of snails to attempt to move (1-pasture_snails)
            s = rand.nextInt(pasture_snails)+1;
            mOut.println(s + " are trying to move through corral " + G);
            pasture_snails-=corral[G].thru(s);
            count++;
        }
        mOut.println("It took " + count + " attempts to corral all of the snails.");
        return count;
    }
}
