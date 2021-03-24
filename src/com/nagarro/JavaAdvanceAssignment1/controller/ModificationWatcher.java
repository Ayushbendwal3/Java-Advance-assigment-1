package com.nagarro.JavaAdvanceAssignment1.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.nagarro.JavaAdvanceAssignment1.input.DirectoryReader;
import com.nagarro.JavaAdvanceAssignment1.model.Constants;


public class ModificationWatcher implements Runnable, Constants {

    HashMap<String, Long> lastModifiedAt = new HashMap<>();

    public void run() {
        File[] files = file.listFiles();
        ArrayList<String> l = new ArrayList<>();
        for (File f : files) {
            if ((!(lastModifiedAt.containsKey(f.getName()))) || (f.lastModified() > lastModifiedAt.get(f.getName()))) {
                lastModifiedAt.put(f.getName(), f.lastModified());
                synchronized (Utility.flightsInfo) {
                    Utility.flightsInfo.put(f.getName(), DirectoryReader.readFile(f));
                }
            }
            l.add(f.getName());
        }

        Set<String> fc = lastModifiedAt.keySet();
        Set<String> flightName = new HashSet<>(fc);

        if (fc.size() == l.size())
            return;
        for (String string : flightName) {
            if (!(l.contains(string))) {
                lastModifiedAt.remove(string);
                synchronized (Utility.flightsInfo) {
                    Utility.flightsInfo.remove(string);
                }
            }
        }
    }
}
