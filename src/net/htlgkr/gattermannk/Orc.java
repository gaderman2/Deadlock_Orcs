package net.htlgkr.gattermannk;

import java.time.LocalTime;

public class Orc extends Thread {

    private Dagger rightDagger;
    private Dagger leftDagger;

    private String name;

    public Orc(String name, Dagger rightDagger, Dagger leftDagger) {
        this.name = name;
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
        Thread.sleep((long) (Math.random() * 200) + 100);
    }

    private void grabRightDagger() {
        debug("Trying to grab right dagger");
        rightDagger.occupy();
    }

    private void grabLeftDagger() {
        debug("Trying to grab left dagger");
        leftDagger.occupy();
    }

    private void feasting() throws InterruptedException {
        debug("Is having a feast");
        Thread.sleep((long) (Math.random() * 200) + 100);
    }

    private void releaseRightDagger() {
        rightDagger.release();
        debug("Right dagger released");
    }

    private void releaseLeftDagger() {
        leftDagger.release();
        debug("Left dagger released");
    }

    private void debug(String message){
        System.out.println(LocalTime.now() + " | " + name + ": " + message);
    }

}
