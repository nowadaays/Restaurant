import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class MainClass {
    public static void main(String[] args) {
        BlockingQueue<Order> orderQueue = new ArrayBlockingQueue<>(10);

        Thread cookThread = new Thread(new Cook(orderQueue));
        cookThread.start();

        Dish pasta = new Dish("Pasta", 15.99, 7);
        Dish stake = new Dish("Stake", 30.00, 45);
        Dish salad = new Dish("Salad", 5.99, 3);

        Order order1 = new Order();
        order1.addDish(pasta);
        order1.addDish(salad);

        try {
            orderQueue.put(order1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}