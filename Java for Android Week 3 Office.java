package mooc.vandy.java4android.buildings.logic;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office
       extends Building {

    // TODO - Put your code here.
    private String mBusinessName;
    private int mParkingSpaces;
    //variable to keep track of the total number of Office objects created
    private static int sTotalOffices=0;

    //constructors


    public Office(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
        this.mBusinessName=null;
        this.mParkingSpaces=0;

        sTotalOffices++;
    }
    //constructor with String businessName
    public Office(int length, int width, int lotLength, int lotWidth, String businessName) {
        super(length, width, lotLength, lotWidth);
        this.mBusinessName = businessName;
        sTotalOffices++;
    }
    // constructor with int parkingSpaces
    public Office(int length, int width, int lotLength, int lotWidth, String businessName, int parkingSpaces) {
        super(length, width, lotLength, lotWidth);
        this.mBusinessName = businessName;
        this.mParkingSpaces = parkingSpaces;
        sTotalOffices++;
    }

    //getters
    public String getBusinessName() {
        return mBusinessName;
    }

    public int getParkingSpaces() {
        return mParkingSpaces;
    }

    public static int getTotalOffices(){
        return sTotalOffices;
    }

    //setters
    public void setBusinessName(String businessName) {
        this.mBusinessName = businessName;
    }

    public void setParkingSpaces(int parkingSpaces) {
        this.mParkingSpaces = parkingSpaces;
    }

    @Override
    public String toString() {
        return "Business: " +
                (mBusinessName != null ? mBusinessName : "unoccupied") +
                (mParkingSpaces != 0 ? "; has " + mParkingSpaces + " parking spaces" : "") +
                " (total offices: " + sTotalOffices + ")";
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Office)) return false;

        Office office = (Office) o;

        return (getParkingSpaces() == office.getParkingSpaces()) && (calcBuildingArea() == office.calcBuildingArea());
    }
}
