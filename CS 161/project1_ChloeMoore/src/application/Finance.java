package application;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Finance extends GridPane {
    // create labels and textfields
    Label title = new Label("Financing Information");
    Label price_lab = new Label("Base Price: $");
    Label downpay_lab = new Label("Down Payment: $");
    Label tax_lab = new Label("Sales Tax: %");
    TextField price_text = new TextField("0.0");
    TextField downpay_text = new TextField("0.0");
    TextField tax_text = new TextField("7.0");

    // constructor for this class
    public Finance() {
        // set title font weight to bold
        title.getStyleClass().add("label-bold");

        // placing objects inside this class (a gridpane)
        add(title, 0, 0);
        add(price_lab, 0, 1);
        add(downpay_lab, 0, 2);
        add(tax_lab, 0, 3);
        add(price_text, 1, 1);
        add(downpay_text, 1, 2);
        add(tax_text, 1, 3);

        // set the display settings
        setPadding(new Insets(5));
        setVgap(5);
    }

    // METHODS
    public double get_tax_rate() {
        // converts tax rate from textfield string to a double and returns it
        String tax_str = tax_text.getText();
        double tax = Double.parseDouble(tax_str)/100;
        return tax;
    }

    public double get_downpayment() {
        // converts down payment from textfield string to a double and returns it
        String down_str = downpay_text.getText();
        double downpay = Double.parseDouble(down_str);
        return downpay;
    }

    public double get_base_price() {
        // converts base price from textfield string to a double and returns it
        String price_str = price_text.getText();
        double price = Double.parseDouble(price_str);
        return price;
    }

    public void set_tax(double rate) {
        String tax_str = String.format("%f", rate);
        tax_text.setText(tax_str);
    }

    public void reset() {
        // resets textfields to their default values
        price_text.setText("0.0");
        downpay_text.setText("0.0");
        tax_text.setText("7.0");
    }
}
