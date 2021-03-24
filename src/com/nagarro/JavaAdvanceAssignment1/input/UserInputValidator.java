package com.nagarro.JavaAdvanceAssignment1.input;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;

import com.nagarro.JavaAdvanceAssignment1.model.*;
import com.nagarro.JavaAdvanceAssignment1.controller.Utility;

/*
 * UserInput
 */
public class UserInputValidator implements Constants {
    public static Date validateDate(String str) {
        dateFormat.setLenient(false);
        Date validTill = null;
        try {
            validTill = dateFormat.parse(str);
        } catch (ParseException e) {
            System.err.print("Date not in appropriate(dd-MM-yyyy) format, Enter Again: ");
        }
        return validTill;
    }

    public static String validateSource(String src) {
        synchronized (Utility.flightsInfo) {
            for (HashSet<Flight> flightSet : Utility.flightsInfo.values()) {
                for (Flight f : flightSet) {
                    if (f.getDepLoc().equalsIgnoreCase(src))
                        return f.getDepLoc();
                }
            }
        }
        System.err.print("No Flights are depart from given location, Kindly Try Different Location : ");
        return null;
    }

    public static String validateDestination(String destination) {
        synchronized (Utility.flightsInfo) {
            for (HashSet<Flight> flightSet : Utility.flightsInfo.values()) {
                for (Flight f : flightSet) {
                    if (f.getArrLoc().equalsIgnoreCase(destination))
                        return f.getArrLoc();
                }
            }
        }
        System.err.print("No Flights are arrived from departure location to given location, Kindly Try Different Location : ");
        return null;
    }

    public static String validateFlightClass(String str) {
        if (str.equalsIgnoreCase("E")){
            return str.toUpperCase();
        }
        else if(str.equalsIgnoreCase("B")){
            return "EB";
        }
        else {
            System.err.print("Flight Class entered Inappropriately, Enter Again (E/B):");
            return null;
        }
    }

    public static int validateOutputPreference(int i) {
        if ((i == 1) || (i == 2))
            return i;
        else {
            System.err.print("Output preference entered Inappropriately, Enter Again : ");
            return 0;
        }
    }
}