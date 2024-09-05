package lab6_ChloeMoore;

public class UsedCar extends Car {
    // data fields
    private double mileage;
    private double rate_of_dep;
    private static int used_car_count;
    private static double total_used_car_assets;

    // constructors
    public UsedCar(){
    }

    public UsedCar(String id, double price, int year, double commission, double mileage, double rate) {
        super(id, price, year, commission);
        this.mileage = mileage;
        rate_of_dep = rate;
        used_car_count += 1;
    }

    // methods
    public double calc_total() {
        double total = base_price - (mileage*rate_of_dep) + commission;
        return total;
    }

    @Override
    public String deal_rating() {
        if (commission > calc_total() * 0.04) {
            return "Good";
        } else {
            return "Bad";
        }
    }

    public static int get_used_car_count() {
        return used_car_count;
    }

    public static double get_total_assets() {
        return total_used_car_assets;
    }

    public String print_out() {
        String str = "Used Car:\n";
        str = str + super.print_out();
        str = str + String.format("Mileage: %.0f\n"
                + "Total cost: $%.2f\n"
                + "Deal rating: %s\n",
                mileage, calc_total(), deal_rating());

        return str;
    }

    @Override
    public void update_assets() {
        total_used_car_assets = get_total_assets() + calc_total();
        total_assets = super.get_total_assets() + calc_total();
    }

    @Override
    public double get_milage() {
        return mileage;
    }
}
