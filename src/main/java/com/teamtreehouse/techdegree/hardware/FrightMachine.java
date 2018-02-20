package com.teamtreehouse.techdegree.hardware;

import com.example.accessory.Accessory;
import com.example.motion.MotionDetector;

import java.util.HashMap;
import java.util.Map;

public class FrightMachine extends MotionDetector {

    private Map<String, Accessory> accessoryMap = new HashMap<>();

    public FrightMachine() {}

    public void addObserver(String name, Accessory accessory) {
        accessoryMap.put(name, accessory);
    }

    public void removeObserver(String name) {
        accessoryMap.remove(name);
    }

    public void notifyObservers() {
        accessoryMap.values().forEach(Accessory::activate);
    }
    
    @Override
    public void onMotionDetected() {
        notifyObservers();
    }
}
