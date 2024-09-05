package lab6_ChloeMoore;

abstract class Car {
    // data fields
    private String id;
    private int year = 2007;
    protected double base_price;
    protected double commission;
    protected static double total_assets;

    // constructors
    public Car(){
    }

    public Car(String id, double price, int year, double commission) {
        this.id = id;
        this.year = year;
        base_price = price;
        this.commission = commission;
    }

    // methods
    public static double get_total_assets() {
        return total_assets;
    }

    public static void add_to_assets(double new_car) {
        total_assets += new_car;
    }

    public String print_out() {
        String str = String.format("Vehicle ID: %s\n"
                + "Model Year: %d\n"
                + "Base price: $%.2f\n"
                + "Commission: $%.2f\n",
                id, year, base_price, commission);

        return str;
    }

    // abstract methods
    public abstract void update_assets();
    public abstract double get_milage();
    public abstract String deal_rating();
}
