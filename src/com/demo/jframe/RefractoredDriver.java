package com.demo.jframe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RefractoredDriver extends JFrame {
    private Thread thread0;
    TimerThread countingThread0;

    TrafficLightSimulator tls1;
    Intersection intersection1;
    IntersectionThread countingThread1;
    Thread thread1;
    Thread tsThread1;

    TrafficLightSimulator tls2;
    Intersection intersection2;
    IntersectionThread countingThread2;
    Thread thread2;
    Thread tsThread2;

    TrafficLightSimulator tls3;
    Intersection intersection3;
    IntersectionThread countingThread3;
    Thread thread3;
    Thread tsThread3;

    // Car threads
    CarThread countingThread5;
    Thread thread5;

    CarThread countingThread6;
    Thread thread6;
    CarThread countingThread7;
    Thread thread7;


    ArrayList<Car> carList;
    int carCount;
    ArrayList<Intersection> interList;
    int interCount;

    public RefractoredDriver() {
        // Set up the JFrame
        setTitle("Counting Thread Example");
        setSize(600, 350); // Increased size to accommodate 5 labels
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);



//        ArrayList<JLabel> myLabels = new ArrayList<>();




        // LABELS - Set up a panel with GridLayout to hold the labels
        JPanel labelPanel = new JPanel(new GridLayout(11, 1)); // 5 rows, 1 column
        JLabel countLabel0 = new JLabel("Time: 00:00:00", SwingConstants.CENTER);
        JLabel interHeader = new JLabel("Name  | Distance | Light Status", SwingConstants.CENTER);
        JLabel countLabel1 = new JLabel(" -    |     -    |      OFF    ", SwingConstants.CENTER);
        JLabel countLabel2 = new JLabel(" -    |     -    |      OFF    ", SwingConstants.CENTER);
        JLabel countLabel3 = new JLabel(" -    |     -    |      OFF    ", SwingConstants.CENTER); // New label

        JLabel carHeader = new JLabel("CAR NAME | SPEED (METERS/SECOND) | POSITION (X, Y) | CAR STATUS", SwingConstants.CENTER);

        JLabel countLabel5 = new JLabel("-      |     0      |     (0, 0)      |     -", SwingConstants.CENTER);
        JLabel countLabel6 = new JLabel("-      |     0      |     (0, 0)      |     -", SwingConstants.CENTER);
        JLabel countLabel7 = new JLabel("-      |     0      |     (0, 0)      |     -", SwingConstants.CENTER);

        labelPanel.add(countLabel0);
        labelPanel.add(interHeader);

        labelPanel.add(countLabel1);
        labelPanel.add(countLabel2);
        labelPanel.add(countLabel3); // Add the fourth label

        labelPanel.add(carHeader); // Add the fourth label

        labelPanel.add(countLabel5); // Add the fifth label
        labelPanel.add(countLabel6);
        labelPanel.add(countLabel7);

        // Add the label panel to the center of the JFrame
        add(labelPanel, "Center");


        // BUTTONS
        JPanel buttonPanel = new JPanel(new FlowLayout()); // FlowLayout arranges buttons side by side
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        JButton pauseButton = new JButton("Pause");
        JButton continueButton = new JButton("Continue");
        JButton addCarButton = new JButton("Add Car");
        JButton addIntersectionButton = new JButton("Add Intersection");

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(continueButton);
        buttonPanel.add(addCarButton);
        buttonPanel.add(addIntersectionButton);

        // Add the button panel to the South region
        add(buttonPanel, "South");

        pauseButton.addActionListener(e -> {
            if (thread0 != null && thread0.isAlive()) {
                System.out.println("pause time");
                countingThread0.pauseThread();
            }
            if (thread1 != null && thread1.isAlive()) {
                System.out.println("pause intersection");
                countingThread1.pauseThread();
            }
            if (thread2 != null && thread2.isAlive()) {
                System.out.println("pause intersection");
                countingThread2.pauseThread();
            }
            if (thread3 != null && thread3.isAlive()) {
                System.out.println("pause intersection");
                countingThread3.pauseThread();
            }

            if (thread5 != null && thread5.isAlive()) {
                System.out.println("pause car");
                countingThread5.pauseThread();
            }
            if (thread6 != null && thread6.isAlive()) {
                System.out.println("pause car");
                countingThread6.pauseThread();
            }
            if (thread7 != null && thread7.isAlive()) {
                System.out.println("pause car");
                countingThread7.pauseThread();
            }
        });

        continueButton.addActionListener(e -> {
            if (thread0 != null && thread0.isAlive()) {
                System.out.println("resume timer");
                countingThread0.resumeThread();
            }
            if (thread1 != null && thread1.isAlive()) {
                System.out.println("resume intersection");
                countingThread1.resumeThread();
            }
            if (thread2 != null && thread2.isAlive()) {
                System.out.println("resume intersection");
                countingThread2.resumeThread();
            }
            if (thread3 != null && thread3.isAlive()) {
                System.out.println("resume intersection");
                countingThread3.resumeThread();
            }
            if (thread5 != null && thread5.isAlive()) {
                System.out.println("resume car");
                countingThread5.resumeThread();
            }
            if (thread6 != null && thread6.isAlive()) {
                System.out.println("resume car");
                countingThread6.resumeThread();
            }

            if (thread7 != null && thread7.isAlive()) {
                System.out.println("resume car");
                countingThread7.resumeThread();
            }
        });


        // Add action listener to the button
        startButton.addActionListener(e -> {
            if (thread0 == null || !thread0.isAlive()) {
                countingThread0 = new TimerThread(countLabel0, 1000); // Updates every 1sec
                thread0 = new Thread(countingThread0);
                thread0.start(); // Start the new thread
            }
            SwingUtilities.invokeLater(() -> {
                if (interList.size() < 1) {
                    addIntersectionButton.doClick(); // Simulate a button click
                }
                if (thread1 == null || !thread1.isAlive() && interList.get(0) != null) {
                    System.out.println("intersection: " + interList.get(0));
                    tls1 = new TrafficLightSimulator(TrafficLightColor.GREEN);
                    countingThread1 = new IntersectionThread(countLabel1, 0, tls1, interList.get(0)); // Updates every 700ms
                    thread1 = new Thread(countingThread1);
                    tsThread1 = new Thread(tls1);
                    thread1.start();
                    tsThread1.start();
                }
            });
            if (interList.size() >=2 ) {
                if (thread2 == null || !thread2.isAlive() && interList.get(1) != null) {
                    tls2 = new TrafficLightSimulator(TrafficLightColor.YELLOW);
                    countingThread2 = new IntersectionThread(countLabel2, 0, tls2, interList.get(1)); // Updates every 700ms
                    thread2 = new Thread(countingThread2);
                    tsThread2 = new Thread(tls2);
                    thread2.start();
                    tsThread2.start();
                }
            }
            if (interList.size() >=3 ) {
                if (thread3 == null || !thread3.isAlive() && interList.get(2) != null) {
                    tls3 = new TrafficLightSimulator(TrafficLightColor.RED);
                    countingThread3 = new IntersectionThread(countLabel3, 0, tls3, interList.get(2)); // Updates every 700ms
                    thread3 = new Thread(countingThread3);
                    tsThread3 = new Thread(tls3);
                    thread3.start();
                    tsThread3.start();
                }
            }

            // Ensure necessary imports and class setup is done

            SwingUtilities.invokeLater(() -> {
                if (carList.size() < 1) {
                    addCarButton.doClick(); // Simulate a button click
                }
                if (thread5 == null || !thread5.isAlive()) {
                    System.out.println("car 1: " + carList.get(0));
                    countingThread5 = new CarThread(countLabel5, 1000, interList, carList.get(0)); // Updates every 1000ms
                    thread5 = new Thread(countingThread5);
                    thread5.start();
                }

            });
            if (carList.size() >=2 ) {
                if (thread6 == null || !thread6.isAlive() && carList.get(1) != null) {
                    System.out.println("car 2: " + carList.get(1));
                    countingThread6 = new CarThread(countLabel6, 1000, interList, carList.get(1)); // Updates every 1000ms
                    thread6 = new Thread(countingThread6);
                    thread6.start();
                }
            }
            if (carList.size() >=3 ) {
                if (thread7 == null || !thread7.isAlive() && carList.get(2) != null) {
                    System.out.println("car 3: " + carList.get(2));
                    countingThread7 = new CarThread(countLabel7, 1000, interList, carList.get(2)); // Updates every 1000ms
                    thread7 = new Thread(countingThread7);
                    thread7.start();
                }
            }
        });

        stopButton.addActionListener(e -> {
            if (thread0 != null && thread0.isAlive()) {
                System.out.println("Stoping timer thread");
                countingThread0.cancel();
                thread0.interrupt();
            }
            if (thread1 != null && thread1.isAlive()) {
                System.out.println("Stopping intersection1 thread");
                tls1.cancel();
                countingThread1.cancel();
                thread1.interrupt();
            }
            if (thread2 != null && thread2.isAlive()) {
                System.out.println("Stopping intersection2 thread");
                tls2.cancel();
                countingThread2.cancel();
                thread2.interrupt();
            }
            if (thread3 != null && thread3.isAlive()) {
                System.out.println("Stopping intersection3 thread");
                tls3.cancel();
                countingThread3.cancel();
                thread3.interrupt();
            }
            if (thread5 != null && thread5.isAlive()) {
                System.out.println("Stopping car");
                countingThread5.cancel();
                thread5.interrupt();
            }
            if (thread6 != null && thread6.isAlive()) {
                System.out.println("Stopping car");
                countingThread6.cancel();
                thread6.interrupt();
            }

            if (thread7 != null && thread7.isAlive()) {
                System.out.println("Stopping car");
                countingThread7.cancel();
                thread7.interrupt();
            }
        });

        // continue
        // pause

        carCount = 1;
        carList = new ArrayList<>();
        // Ensure necessary imports and class setup is done
        addCarButton.addActionListener(e -> {
            if (carList.size() < 3) { // Ensuring max 3 cars
                System.out.println("Adding Car...");
                Car car = new Car("car-" + carCount, 0, "IDLE");

                switch (carCount) {
                    case 1:
                        updateLabel(countLabel5, car);
                        break;
                    case 2:
                        updateLabel(countLabel6, car);
                        break;
                    default:
                        updateLabel(countLabel7, car);
                        break;
                }
                carList.add(car);
                carCount++;
            } else {
                System.out.println("MAX 3 Cars");
            }
        });

        interCount = 1;
        interList = new ArrayList<>();
        addIntersectionButton.addActionListener(e -> {
            if (interList.size() < 3) { // Ensuring max 3 cars
                System.out.println("Adding Intersection...");
                Intersection inter = new Intersection("inter-" + interCount, 0,  "OFF");

                switch (interCount) {
                    case 1:
                        updateInterLabel(countLabel1, inter, 500);
                        break;
                    case 2:
                        updateInterLabel(countLabel2, inter, 1500);
                        break;
                    default:
                        updateInterLabel(countLabel3, inter, 2500);
                        break;
                }

                interList.add(inter);
                interCount++;
            } else {
                System.out.println("MAX 3 Intersections");
            }
        });
    }

    private void updateLabel(JLabel label, Car car) {
        label.setText(
                car.getName() + "      |     " + car.getSpeed() +  "      |     " + " (" + car.getX() + ", " + car.getY() + ") " + "      |     " + car.getStatus()
        );
    }
    private void updateInterLabel(JLabel label, Intersection inter, int distance) {
        inter.setDistance(distance);
        label.setText(inter.getIntersectionName() + "    |     " +  inter.getDistance() + "     |      " + inter.getCurrentLight());
    }

    public static void main(String[] args) {
        // Create and display the JFrame
        SwingUtilities.invokeLater(() -> {
            RefractoredDriver frame = new RefractoredDriver();
            frame.setVisible(true);
        });
    }
}
