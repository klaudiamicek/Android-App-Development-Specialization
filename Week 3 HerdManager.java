package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mWestGate;

    /**
     * The output Gate object.
     */
    private Gate mEastGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    public static final int HERD=24;

    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate gate1,
                       Gate gate2) {
        mOut = out;

        mWestGate = gate1;
        mWestGate.open(Gate.IN);

        mEastGate = gate2;
        mEastGate.open(Gate.OUT);
    }

    // TODO -- Fill your code in here
    public void simulateHerd(Random rand)
    {
        int pen_snails = HERD;
        int pasture_snails = 0;
        int randomNumber = 0;
        //all snails (herd) in pen and 0 in pasture
        mOut.println("There are currently " + HERD + " snails in the pen and " + pasture_snails + " snails in the pasture");
        //method will run ten iterations of the simulation
        for (int i =0; i<MAX_ITERATIONS;i++) {

            //snails can only move out
            if (pen_snails == 0) {
                //move random number of snails through gate
                randomNumber = rand.nextInt(pasture_snails)+1;
                pen_snails += mWestGate.thru(randomNumber);
            }
            //snails can only move out
            else if(pen_snails == HERD) {
                //move random number of snails through gate
                randomNumber = rand.nextInt(pen_snails)+1;
                pen_snails += mEastGate.thru(randomNumber);
            }
            else {
                //randomly selecting one of two gates
                int gate = rand.nextInt(2);
                //if through EastGate
                if(gate==1) {
                    randomNumber = rand.nextInt(pen_snails)+1;
                    pen_snails += mEastGate.thru(randomNumber);
                }
                else {
                    randomNumber = rand.nextInt(pasture_snails)+1;
                    pen_snails += mWestGate.thru(randomNumber);
                }
            }
            //total snails-snails in pen=snails in pasture
            pasture_snails = HERD - pen_snails;
            mOut.println("There are currently " + pen_snails + " snails in the pen and " + pasture_snails + " snails in the pasture");
        }

    }


}
