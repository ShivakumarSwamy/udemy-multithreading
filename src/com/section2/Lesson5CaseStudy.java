package com.section2;

import java.util.Random;
import java.util.stream.Stream;

public class Lesson5CaseStudy {
    private static final int MAX_PASSWORD = 9999;


    public static void main(String[] args) {
        Random random = new Random();
        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));

        Stream.of(new AscendingHackerThread(vault), new DescendingHackerThread(vault), new PoliceThread())
                .forEach(Thread::start);
    }

    private static class Vault {

        private final int password;


        public Vault(int password) {
            this.password = password;
        }

        public boolean isCorrectPassword(int guess) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                // intentionally ignored
            }
            return this.password == guess;
        }

    }

    private static abstract class HackerThread extends Thread {

        protected final Vault vault;


        public HackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void start() {
            System.out.println("Starting Thread '" + this.getName() + "'");
            super.start();
        }

    }

    private static class AscendingHackerThread extends HackerThread {

        public AscendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int guess = 0; guess < MAX_PASSWORD; guess++) {
                if (this.vault.isCorrectPassword(guess)) {
                    System.out.println(this.getName() + " guessed the password " + guess);
                    System.exit(0);
                }
            }
        }

    }

    private static class DescendingHackerThread extends HackerThread {

        public DescendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int guess = MAX_PASSWORD; guess > 0; guess--) {
                if (this.vault.isCorrectPassword(guess)) {
                    System.out.println(this.getName() + " guessed the password " + guess);
                    System.exit(0);
                }
            }
        }
    }

    private static class PoliceThread extends Thread {

        @Override
        public void run() {
            for (int countdown = 10; countdown > 0; countdown--) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // intentionally ignored
                }
                System.out.println(countdown);
            }
            System.out.println("Game over for you hackers");
            System.exit(0);
        }
    }
}

