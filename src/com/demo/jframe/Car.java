package com.demo.jframe;

public class Car {
    private String name;
    private int distance;
    private int speed;
    private int y = 0;
    private int x;
    private String status;

    public Car(String name, int x, String status){
        this.name = name;
        this.x = x;
        this.distance = 0;
        this.y = 0;
        this.speed = 0;
        this.status = status;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                ", speed=" + speed +
                ", y=" + y +
                ", x=" + x +
                ", status='" + status + '\'' +
                '}';
    }
}
