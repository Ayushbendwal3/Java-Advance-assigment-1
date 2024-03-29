package com.nagarro.JavaAdvanceAssignment1.model;

import java.util.Date;

public class UserInput implements Constants {
    private final String depLoc;
    private final String arrLoc;
    private final Date flightDate;
    private final String flightClass;
    private final int outputPreference;

    public UserInput(String depLoc, String arrLoc, Date flightDate,
                     String flightClass, int outputPreference) {
        super();
        this.depLoc = depLoc;
        this.arrLoc = arrLoc;
        this.flightDate = flightDate;
        this.flightClass = flightClass;
        this.outputPreference = outputPreference;
    }

    public String getDepLoc() {
        return depLoc;
    }

    public String getArrLoc() {
        return arrLoc;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public int getOutputPreference() {
        return outputPreference;
    }

    @Override
    public String toString() {
        return "depLoc=" + depLoc + ", arrLoc=" + arrLoc
                + ", flightDate=" + dateFormat.format(flightDate) + ", flightClass=" + flightClass
                + ", outputPreference=" + outputPreference;
    }
}
