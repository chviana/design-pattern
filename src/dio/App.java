package dio;

import dio.observer.Impar;
import dio.observer.Par;
import dio.observer.RandomNumbers;

public class App {
    public static void main(String[] args) throws Exception {
        
        RandomNumbers randomNumbers = new RandomNumbers();
        Par par = new Par();
        Impar impar = new Impar();

        randomNumbers.registerObserver(par);
        randomNumbers.registerObserver(impar);

        randomNumbers.random();
    }
}
