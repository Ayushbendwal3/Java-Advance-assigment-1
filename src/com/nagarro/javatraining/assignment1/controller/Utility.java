package com.nagarro.javatraining.assignment1.controller;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import com.nagarro.javatraining.assignment1.input.*;
import com.nagarro.javatraining.assignment1.model.*;


public class Utility {

    public static final HashMap<String, HashSet<Flight>> flightsInfo = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Flight> result = new ArrayList<>();
        String choice;
        UserInput uiObj;

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new ModificationWatcher(), 0, 3, TimeUnit.SECONDS);

        do {
            uiObj = InputAcceptor.enterInput();
            result.clear();
            synchronized (Utility.flightsInfo) {
                for (HashSet<Flight> set : flightsInfo.values()) {
                    for (Flight f : set) {
                        if (f.getDepLoc().equalsIgnoreCase(uiObj.getDepLoc())
                                && f.getArrLoc().equalsIgnoreCase(uiObj.getArrLoc())
                                && f.getFlightClass().equalsIgnoreCase(uiObj.getFlightClass())
                                && (uiObj.getFlightDate().compareTo(f.getValidTill()) <= 0)
                                && f.isSeatAvailability())
                            result.add(f);
                    }
                }
            }
            if (uiObj.getOutputPreference() == 1)
                result.sort(new FlightPriceComparator());
            else
                result.sort(new FlightDurationComparator());
            System.out.println("\nResult:");
            for (Flight f : result) {
                System.out.println(f);
            }
            System.out.print("\nWant to Exit (Enter Y/N)");
            while (!((choice = br.readLine()).equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")))
                System.out.print("I could not Understand Enter Again:");
        } while (choice.equalsIgnoreCase("n"));
        service.shutdown();
    }

}
