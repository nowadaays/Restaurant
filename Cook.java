import java.util.concurrent.BlockingQueue;

class Cook implements Runnable {
    private BlockingQueue<Order> orderQueue;

    public Cook(BlockingQueue<Order> orderQueue) {
        this.orderQueue = orderQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Order order = orderQueue.take();
                System.out.println("Cook received an order. Cooking...");
                for (Dish dish : order.getDishes()) {
                    dish.cook();
                }
                System.out.println("Order is ready! Total price: " + order.getPrice());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
