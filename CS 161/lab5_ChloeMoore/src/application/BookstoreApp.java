package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class BookstoreApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // GUI labels, listview, menubar elements
        Label title = new Label("Welcome to the PFW Online Bookstore!");
        Label book_heading = new Label("Available books");
        Label cart_heading = new Label("Shopping cart");
        ListView<Book> book_list = new ListView<Book>();
        ListView<Book> cart_list = new ListView<Book>();
        cart_list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // needed to select all books in cart for checkout
        MenuBar menu_bar = new MenuBar();

        // set up formating for title label and listviews
        title.getStyleClass().add("label-title"); // gives title format from CSS file
        title.setPadding(new Insets(5));
        book_list.setPrefHeight(180);
        cart_list.setPrefHeight(180);

        //// MENU CREATION ////

        //// FILE MENU ////
        Menu file_menu = new Menu("File");

        // creating Load Books menu item
        MenuItem load_books = new MenuItem("Load Books");
        FileChooser file_chooser = new FileChooser(); //// file chooser for opening default folder to book titles file
        File directory = new File(System.getProperty("user.dir"));
        file_chooser.setInitialDirectory(directory); // sets default directory to user's directory

        // set up event handler for load books file option
        load_books.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                File book_file = file_chooser.showOpenDialog(new Stage()); // creates a file from a text file, chosen by the user
                ArrayList<Book> books_arr = get_books(book_file); // creates an arraylist of all the books
                ObservableList<Book> book_obs = FXCollections.observableArrayList(books_arr); // converts arraylist to observablelist
                book_list.getItems().setAll(book_obs);
            }
        });

        // creating Exit menu item
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add load books and exit menu items to the file menu
        file_menu.getItems().addAll(load_books, exit);


        //// SHOPPING MENU ////
        Menu shopping_menu = new Menu("Shopping");

        // create book selection menuitem
        MenuItem add_book = new MenuItem("Add Selected Book");
        add_book.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Book selected = book_list.getSelectionModel().getSelectedItem(); // registers book that user selected
                if (selected != null) {
                    cart_list.getItems().add(selected); // adds the book to the shopping cart listview
                }
            }
        });

        // create book removal menuitem
        MenuItem remove_book = new MenuItem("Remove Selected Book");
        remove_book.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Book selected = cart_list.getSelectionModel().getSelectedItem();
                if (selected != null) {
                    cart_list.getItems().remove(selected);
                }
            }
        });

        // create clear cart menuitem
        MenuItem clear_cart = new MenuItem("Clear Cart");
        clear_cart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                cart_list.getItems().clear();
            }
        });

        // create checkout menuitem
        MenuItem checkout = new MenuItem("Checkout");
        checkout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // selects all items in the shopping cart, creates an observablelist from them
                cart_list.getSelectionModel().selectAll();
                ObservableList<Book> book_list_ob = cart_list.getSelectionModel().getSelectedItems();

                // calculations (see methods)
                double total = calc_total(book_list_ob);
                double tax = calc_tax(total);
                double total_taxed = total + tax;

                // creating labels and button for cart window display
                Label subtotal_lab = new Label(String.format("Subtotal: $%.2f", total));
                Label tax_lab = new Label(String.format("Tax: $%.2f", tax));
                Label total_lab = new Label(String.format("Total: $%.2f", total_taxed));
                total_lab.getStyleClass().add("label-bold");
                Button ok_close = new Button("OK");

                // setting labels into vbox and putting it into a new stage (for a new window)
                VBox cart_box = new VBox(subtotal_lab, tax_lab, total_lab, ok_close);
                cart_box.setPrefWidth(150);
                cart_box.setPadding(new Insets(5));

                Scene checkout_scene = new Scene(cart_box);
                checkout_scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                Stage checkout_stage = new Stage();
                checkout_stage.setTitle("Checkout");
                checkout_stage.setScene(checkout_scene);
                checkout_stage.show();

                // event handling for OK button (closes window)
                ok_close.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        checkout_stage.close();
                    }
                });
            }
        });

        // adding menuitems to shopping menu
        shopping_menu.getItems().addAll(add_book, remove_book, clear_cart, checkout);

        // adding menus to menubar
        menu_bar.getMenus().addAll(file_menu, shopping_menu);

        // putting GUI elements into a gridpane
        GridPane grid = new GridPane();
        grid.add(menu_bar, 0, 0, 2, 1);
        grid.add(title, 0, 1, 2, 1);
        grid.add(book_heading, 0, 2);
        grid.add(book_list, 0, 3);
        grid.add(cart_heading, 1, 2);
        grid.add(cart_list, 1, 3);
        grid.setHgap(10);

        // setup main GUI scene and launch
        Scene scene = new Scene(grid);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); // gets CSS style sheet
        stage.setTitle("Bookstore Shopping Cart");
        stage.setScene(scene);
        stage.show();
    }

    ///// METHODS ////

    public ArrayList<Book> get_books(File file) {
        // reads file and returns an arraylist of books from file's information
        ArrayList<Book> books = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                // reads next line in file and gets title and price
                String line = scanner.nextLine();
                String[] lines = line.split(",");
                String title = lines[0];
                String price_str = lines[1];
                double price = Double.parseDouble(price_str);

                // creates new book and adds it to the books arraylist
                Book book = new Book(title, price);
                books.add(book);
            }
            // close scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return books;
    }

    public double calc_total(ObservableList<Book> list) {
        // calculate total cost of books in cart
        double total = 0;
        Book[] books = list.toArray(new Book[0]);
        for (Book book : books) {
            total += book.price;
        }

        return total;
    }

    public double calc_tax(double total) {
        // calculates taxes, based on total cost of books
        double total_tax = total * 0.07;
        return total_tax;
    }

}
