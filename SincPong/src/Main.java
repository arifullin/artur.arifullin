package ru.itis.group403.arifullin;

public class Main {
    public static void main(String[] args) {
        final PingPong obj = new PingPong();
        Thread Ping = new Thread(){
            public void run(){
                synchronized (obj){
                    while (true){
                        obj.notify();
                        obj.Ping();
                        try {
                            sleep(900);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Thread Pong = new Thread(){
            public void run() {
                synchronized (obj){
                    while (true){
                        obj.notify();
                        obj.Pong();
                        try {
                            sleep(900);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Ping.start();
        Pong.start();
    }
}
