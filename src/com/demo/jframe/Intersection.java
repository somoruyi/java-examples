package com.demo.jframe;

public class Intersection {
    String intersectionName;
    int distance;
    String currentLight;


    public Intersection(String intersectionName, int distance, String currentLight) {
        this.intersectionName = intersectionName;
        this.distance = distance;
        this.currentLight = currentLight;
    }

    public String getCurrentLight() {
        return currentLight;
    }

    public void setCurrentLight(String currentLight) {
        this.currentLight = currentLight;
    }

    public String getIntersectionName() {
        return intersectionName;
    }

    public void setIntersectionName(String intersectionName) {
        this.intersectionName = intersectionName;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Intersections{" +
                "intersectionName='" + intersectionName + '\'' +
                ", distance=" + distance +
                ", currentLight='" + currentLight + '\'' +
                '}';
    }
}
