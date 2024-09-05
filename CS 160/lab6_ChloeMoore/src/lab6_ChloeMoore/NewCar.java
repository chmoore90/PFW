package lab6_ChloeMoore;

public class NewCar extends Car {
    // data fields
    private double options_cost;
    private double rebate;
    private static int new_car_count;
    private static double total_new_car_assets;

    // constructors
    public NewCar() {
        super();
        new_car_count += 1;
    }

    public NewCar(String id, double price, int year, double commission, double options, double rebate) {
        super(id, price, year, commission);
        options_cost = options;
        this.rebate = rebate;
        new_car_count += 1;
    }

    // methods
    public double calc_total() {
        double total = base_price + options_cost + commission - rebate;
        return total;
    }

    @Override
    public String deal_rating() {
        if (commission > base_price * 0.08) {
            return "Good";
        } else {
            return "Bad";
        }
    }

    public static int get_new_car_count() {
        return new_car_count;
    }

    public static double get_total_assets() {
        return total_new_car_assets;
    }

    public String print_out() {
        String str = "New Car:\n";
        str = str + super.print_out();
        str = str + String.format("Options cost: $%.2f\n"
                + "Rebate: $%.2f\n"
                + "Total cost: $%.2f\n"
                + "Deal rating: %s\n",
                options_cost, rebate, calc_total(), deal_rating());

        return str;
    }

    @Override
    public void update_assets() {
        total_new_car_assets = get_total_assets() + calc_total();
        total_assets = super.get_total_assets() + calc_total();
    }

    @Override
    public double get_milage() {
        return 0;
    }
}
