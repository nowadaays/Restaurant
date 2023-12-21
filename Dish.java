class Dish implements Cookable, Orderable {
    private String name;
    private double price;
    private int cookTime;

    public Dish(String name, double price, int cookTime) {
        this.name = name;
        this.price = price;
        this.cookTime = cookTime;
    }

    @Override
    public void cook() {
        try {
            System.out.println("Cooking: " + name);
            Thread.sleep(cookTime * 1000);
            System.out.println(name + " is ready!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public double getPrice() {
        return price;
    }
}
