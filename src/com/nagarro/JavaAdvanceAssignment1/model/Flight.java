package com.nagarro.JavaAdvanceAssignment1.model;

import java.util.Date;

public class Flight implements Constants {
    private final String flightNo;
    private final String depLoc;
    private final String arrLoc;
    private final Date validTill;
    private final String flightTime;
    private final Double flightDuration;
    private final int fare;
    private final boolean seatAvailability;
    private final String flightClass;


    public Flight(String flightNo, String depLoc, String arrLoc, int fare,
                  Date validTill, String flightTime, Double flightDuration,
                  boolean seatAvailability, String flightClass) {
        super();
        this.flightNo = flightNo;
        this.depLoc = depLoc;
        this.arrLoc = arrLoc;
        this.validTill = validTill;
        this.flightTime = flightTime;
        this.flightDuration = flightDuration;
        this.seatAvailability = seatAvailability;
        this.flightClass = flightClass;
        if (flightClass.equalsIgnoreCase("B"))
            fare = 140 * fare / 100;
        this.fare = fare;
    }


    public String getDepLoc() {
        return depLoc;
    }

    public String getArrLoc() {
        return arrLoc;
    }

    public int getFare() {
        return fare;
    }

    public Date getValidTill() {
        return validTill;
    }

    public Double getFlightDuration() {
        return flightDuration;
    }

    public boolean isSeatAvailability() {
        return seatAvailability;
    }

    public String getFlightClass() {
        return flightClass;
    }

    @Override
    public String toString() {
        return "flightNo=" + flightNo + ", depLoc=" + depLoc
                + ", arrLoc=" + arrLoc + ", validTill=" + dateFormat.format(validTill)
                + ", flightTime=" + flightTime + ", flightDuration="
                + String.format("%.2f", flightDuration) + ", fare=" + fare + ", seatAvailability="
                + seatAvailability + ", flightClass=" + flightClass;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((flightNo == null) ? 0 : flightNo.hashCode());
        return result;
    }


    public boolean equals(Object obj) {
        Flight other = (Flight) obj;
        if (arrLoc == null) {
            if (other.arrLoc != null)
                return false;
        } else if (!arrLoc.equals(other.arrLoc))
            return false;
        if (depLoc == null) {
            if (other.depLoc != null)
                return false;
        } else if (!depLoc.equals(other.depLoc))
            return false;
        if (flightNo == null) {
            if (other.flightNo != null)
                return false;
        } else if (!flightNo.equals(other.flightNo))
            return false;
        if (flightTime == null) {
            if (other.flightTime != null)
                return false;
        } else if (!flightTime.equals(other.flightTime))
            return false;
        if (seatAvailability != other.seatAvailability)
            return false;
        if (validTill == null) {
            return other.validTill == null;
        } else return validTill.equals(other.validTill);
    }
}
