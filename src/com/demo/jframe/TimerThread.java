package com.demo.jframe;

import javax.swing.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

// Thread class implementing Runnable
class TimerThread implements Runnable {
    private JLabel label;
    private int delay;
    private final Object pauseLock = new Object();
    private boolean paused = false;

    private boolean stop = false; // set to true to stop the simulation

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy | HH:mm:ss zzz");
    private String time;

    public TimerThread(JLabel label, int delay) {
        this.label = label; // Reference to the JLabel
        this.delay = delay; // Delay between updates
    }

    @Override
    public void run() {
        while(!stop) {

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

            // Update time
            ZonedDateTime currentDateTime = ZonedDateTime.now();
            String formattedDateTime = currentDateTime.format(dateTimeFormatter);
            time = currentDateTime.toLocalTime().toString().substring(0, 8); // HH:mm:ss format

            SwingUtilities.invokeLater(() -> label.setText("Timer : " + formattedDateTime));


            try {
                Thread.sleep(delay); // Pause for the specified delay
            } catch (InterruptedException ex) {
//                ex.printStackTrace();
                System.out.println("Thread was interrupted." + ex.getMessage());
                stop = true;
                break;
            }
        }
    }

    public synchronized void cancel() {
        stop = true;
        System.out.println("TimerThread cancellation requested.");
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