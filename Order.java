import java.util.ArrayList;
import java.util.List;

class Order implements Orderable {
    private List<Dish> dishes;

    public Order() {
        this.dishes = new ArrayList<>();
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    @Override
    public double getPrice() {
        return dishes.stream().mapToDouble(Dish::getPrice).sum();
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
