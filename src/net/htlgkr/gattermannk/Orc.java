package net.htlgkr.gattermannk;

import java.time.LocalTime;

public class Orc extends Thread {

    private Dagger rightDagger;
    private Dagger leftDagger;

    private String name;

    public Orc(String name, Dagger rightDagger, Dagger leftDagger) {
        this.rightDagger = rightDagger;
        this.leftDagger = leftDagger;
    }

    @Override
    public void run() {
        while (true) {
            try {
                drinking();

                grabRightDagger();
                grabLeftDagger();

                feasting();

                releaseRightDagger();
                releaseLeftDagger();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void drinking() throws InterruptedException {
        debug("Is drinking now...");
        Thread.sleep((long) (Math.random() * 2000) + 1000);
    }

    private void grabRightDagger() {
        rightDagger.setOccupied(true);
    }

    private void grabLeftDagger() {
        leftDagger.setOccupied(true);
    }

    private void feasting() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 2000) + 1000);
    }

    private void releaseLeftDagger() {
        rightDagger.setOccupied(false);
    }

    private void releaseRightDagger() {
        leftDagger.setOccupied(true);
    }

    private String debug(String message){
        return LocalTime.now() + " | " + name + ": " + message;
    }

}
