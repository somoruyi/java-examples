package com.demo.jframe;


import javax.swing.*;

// Thread class implementing Runnable
class IntersectionThread implements Runnable {
    private JLabel label;
    private int delay;
    private final Object pauseLock = new Object();
    private boolean paused = false;

    private boolean stop = false; // set to true to stop the simulation
    private TrafficLightSimulator tls;
    private Intersection intersection;



    public IntersectionThread(JLabel label, int delay, TrafficLightSimulator tls, Intersection intersection) {
        this.label = label; // Reference to the JLabel
        this.delay = delay; // Delay between updates
        this.tls = tls;
        this.intersection = intersection;
    }

    @Override
    public void run() {
        while(!stop){
            // pause work
            synchronized (pauseLock) {
                while (paused) {
                    try {
                        pauseLock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); break;
                    }
                }
            }
            // Wait for the light to change
            System.out.println("intersection: " + intersection);

//            tls.waitForChange();

            SwingUtilities.invokeLater(() -> {
                intersection.setCurrentLight(tls.getColor().toString());
                label.setText(
                        intersection.intersectionName +
                        "     " +
                        intersection.getDistance() +
                        "     " +
                        intersection.getCurrentLight()
                );
                System.out.println("light changed");
            });

            tls.waitForChange();

        }
    }

    void cancel() {
        System.out.println("Stopping " + intersection.getIntersectionName());
        stop = true;

    }void pauseThread() {
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