package dio.observer;

public class Par implements Observer {

    @Override
    public void update(int number) {
        
        if(number % 2 == 0) {
            System.out.println("Número par : " + number);
        }
        
    }
    
}
