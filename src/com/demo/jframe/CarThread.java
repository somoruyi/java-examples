package com.demo.jframe;


import javax.swing.*;
import java.util.ArrayList;

// Thread class implementing Runnable
class CarThread implements Runnable {
    private JLabel label;
    private int delay;

    private boolean stop = false; // set to true to stop the simulation
    private TrafficLightSimulator tls;
    private ArrayList<Intersection> intersections;
    private Car car;
    private boolean changed = false;
    private final Object pauseLock = new Object();
    private boolean paused = false;



    public CarThread(JLabel label, int delay, ArrayList<Intersection> intersections, Car car) {
        this.label = label; // Reference to the JLabel
        this.delay = delay; // Delay between updates
        this.intersections = intersections;
        this.car = car;
    }

    @Override
    public void run() {
        car.setStatus("DRIVING");
        int speed = car.getSpeed();

        int x = 0;
        car.setSpeed(speed);
        car.setX(x);

        while(!stop){
            // pause work
            synchronized (pauseLock) {
                while (paused) {
                    try {
                        pauseLock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }


            // Wait for the light to change
            System.out.println("Car:\t" + car);
            System.out.println("Intersection:\t" + intersections);
            x = car.getX();
            speed = car.getSpeed();
            car.setX(x+speed);

            // stop at intersection
            if(x == 500 && intersections.size() >= 1) {
                checkLight(0, x);

            } else if (x == 1500 && intersections.size() >= 2) {
                checkLight(1, x);

            }else if (x == 2500 && intersections.size() >= 3){
                checkLight(2, x);

            }

            if (x >= 1000 && intersections.size() < 2){
                car.setX(x);
                car.setStatus("FINISHED");
                stop = true;
            }
            if (x >= 2000 && intersections.size() < 3){
                car.setX(x);
                car.setStatus("FINISHED");
                stop = true;
            }
            if (x >= 3000 && intersections.size() < 4){
                car.setX(x);
                car.setStatus("FINISHED");
                stop = true;
            }



            SwingUtilities.invokeLater(() -> {
                label.setText(
                        car.getName() + "      |     " +
                                car.getSpeed() +  "      |     " +
                                " (" + car.getX() + ", " + car.getY() + ") " + "      |     " +
                                car.getStatus()
                );

            });

            try {
                Thread.sleep(delay); // Pause for the specified delay
            } catch (InterruptedException ex) {
                System.out.println("Car Thread: " + ex.getMessage());
                stop = true;
                break;
            }

        }
    }

    void checkLight(int index, int x){
        String name = intersections.get(index).getIntersectionName();
        String lightStatus = intersections.get(index).getCurrentLight();

        car.setX(x);
        car.setStatus(name + " is " + lightStatus);

        System.out.println(name + " is " + lightStatus);



        label.setText(
                car.getName() + "      |     " +
                        car.getSpeed() +  "      |     " +
                        " (" + car.getX() + ", " + car.getY() + ") " + "      |     " +
                        car.getStatus()
        );


        while(lightStatus == "RED") {
            lightStatus = intersections.get(index).getCurrentLight();
            System.out.println("lightStatus: " + lightStatus + " stop = " + stop);
        }


        car.setStatus("DRIVING");
        car.setX(x+car.getSpeed());
    }



    void cancel() {
        System.out.println("Stopping " + car.getName());
        stop = true;
    }

    void pauseThread() {
        synchronized (pauseLock) {
            paused = true;
        }
    }

    void resumeThread() {
        synchronized (pauseLock) {
            paused = false;
            pauseLock.notifyAll();
        }
    }


}