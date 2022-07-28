package dio.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class RandomNumbers implements Subject {

    private List<Observer> observers;
    private int number;

    public RandomNumbers() {
        this.observers = new ArrayList<>();
    }

    public void random() {

        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                Random r = new Random();
                setNumber(r.nextInt(100));

                notifyObservers();
            }
        },0,2000);

        /*
        new Runnable() {

            @Override
            public void run() {
                
                Random r = new Random(100);
                setNumber(r.nextInt());

                notifyObservers();
                
            }
            
        }, 300;
        */
    }

    private void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if(i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(number);
        }
    }
}
