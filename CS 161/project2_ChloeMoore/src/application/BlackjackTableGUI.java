package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BlackjackTableGUI extends Application {
	// Create initial components here, so they are accessible to all class methods
	// GUI controls
	private Label dealer_hand_lbl = new Label("Dealer Hand");
	private Label dealer_val_lbl = new Label("Value: 0");
	private Label dealer_score_lbl = new Label("Dealer Score: 0");
	private Label player_hand_lbl = new Label("Player Hand");
	private Label player_val_lbl = new Label("Value: 0");
	private Label player_score_lbl = new Label("Player Score: 0");
	private Label result_lbl = new Label();
	private Button start = new Button("Start");
	private Button hit = new Button("Hit");
	private Button stand = new Button("Stand");

	// hboxes for player/dealer hands, player/dealer labels, buttons and player, score/result labels
	private HBox dealer_lbl_box = new HBox(dealer_hand_lbl, dealer_val_lbl);
	private HBox player_lbl_box = new HBox(player_hand_lbl, player_val_lbl);
	private HBox dealer_hand_box = new HBox();
	private HBox player_hand_box = new HBox();
	private HBox button_box = new HBox(start, hit, stand);
	private HBox score_box = new HBox(player_score_lbl, result_lbl);

	// instantiating players
	private Player dealer = new Player();
	private Player player = new Player();

	@Override
	public void start(Stage stage) {
		// setting initial state for hit/stand buttons
		hit.setDisable(true);
		stand.setDisable(true);

		// formatting for score labels
		player_score_lbl.setPrefWidth(150);
		dealer_score_lbl.setPrefWidth(150);

		// formatting for hboxes
		dealer_lbl_box.setAlignment(Pos.CENTER);
		dealer_lbl_box.setSpacing(100);
		player_lbl_box.setAlignment(Pos.CENTER);
		player_lbl_box.setSpacing(100);
		button_box.setAlignment(Pos.CENTER);
		button_box.setSpacing(10);
		score_box.setSpacing(280);
		dealer_hand_box.setPrefSize(600, 150);
		player_hand_box.setPrefSize(600, 150);

		// adding controls to gridpane for GUI elements
		GridPane grid = new GridPane();
		grid.add(dealer_lbl_box, 0, 0);
		grid.add(dealer_hand_box, 0, 1);
		grid.add(player_lbl_box, 0, 2);
		grid.add(player_hand_box, 0, 3);
		grid.add(button_box, 0, 4);
		grid.add(score_box, 0, 5);
		grid.add(dealer_score_lbl, 0, 6);

		// formatting GUI container
		grid.getStyleClass().add("container");
		grid.setPadding(new Insets(10));
		grid.setVgap(10);

		// setting up scene and stage to display GUI
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm()); // gets CSS style sheet
		stage.setTitle("Blackjack");
		stage.setScene(scene);
		stage.show();

		//// BUTTON EVENT HANDLERS ////

		start.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				start_game();
			}
		});

		hit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				update_hand(player, player_hand_box, player_val_lbl);

				// ends game if player gets a 21 with first two cards
				if (player.get_hand().size() == 2 && player.get_hand_value() == 21) { // special win case: blackjack from first 2 cards
					end_game();
					result_lbl.setText("BLACKJACK!!!"); // called after end_game(), so it will "override" the regular result text

					// ends game if player busts
				} else if (player.bust()) {
					end_game();
				}
			}
		});

		stand.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// ends game if dealer busts
				if (dealer.bust()) {
					end_game();
					return; // exits function
				}

				// if dealer does NOT stand, update dealer hand, then calls stand action event again
				if (!dealer.stands(player.get_hand_value())) {
					update_hand(dealer, dealer_hand_box, dealer_val_lbl);
					stand.fireEvent(event);
				} else {
					end_game();
				}
			}
		});
	}

	public void start_game() {
		// disable start, activate hit and stand buttons
		start.setDisable(true);
		hit.setDisable(false);
		stand.setDisable(false);

		// reset labels from previous game
		result_lbl.setText("");
		dealer_val_lbl.setText("Value: 0");
		player_val_lbl.setText("Value: 0");

		// reset deck, player hands, previous game result
		player.get_deck().reset(); // only need to reset one, since deck is static
		player.clear_hand();
		dealer.clear_hand();
		dealer_hand_box.getChildren().clear();
		player_hand_box.getChildren().clear();

		// deals a card to the dealer, updates dealer hand and card display
		update_hand(dealer, dealer_hand_box, dealer_val_lbl);
	}

	public void update_hand(Player player, HBox box, Label val_lbl) {
		// THIS METHOD IS CALLED WHENEVER A "HIT" IS NEEDED (since the player.hit() method is embedded here) //
		// deals a new card to player
		player.hit();

		// get's last card of player's hand (card that was just added)
		Card new_card = player.get_hand().get(player.get_hand().size() - 1);

		// adds card to display, updates hand values on label
		box.getChildren().addAll(new_card);
		int hand_val = player.get_hand_value();
		val_lbl.setText(String.format("Value: %d", hand_val));
	}

	public void end_game() {
		// determine the winner of the round
		Player winner;

		//starts by checking for player bust, then dealer bust
		if (player.bust()) {
			player_val_lbl.setText(String.format("Value: %d (Bust!)", player.get_hand_value()));
			winner = dealer;
		} else if (dealer.bust()) {
			dealer_val_lbl.setText(String.format("Value: %d (Bust!)", dealer.get_hand_value()));
			winner = player;

		// if no bust, compares player and dealer scores to determine winner
		} else if (dealer.get_hand_value() > player.get_hand_value()) {
			winner = dealer;
		} else if (player.get_hand_value() > dealer.get_hand_value()) {
			winner = player;

		// if no bust and hand values are equal, no winner
		} else {
			winner = null;
		}

		// actions if dealer wins:
		if (winner == dealer) {
			// get current dealer score and add 1
			String string = dealer_score_lbl.getText();
			String[] string_split = string.split(" ");
			int score = Integer.parseInt(string_split[2]);
			score += 1;

			// update dealer score and result labels
			dealer_score_lbl.setText(String.format("Dealer Score: %d", score));
			result_lbl.setText("Dealer wins!");

		// actions if player wins:
		} else if (winner == player) {
			// get current player score and add 1
			String string = player_score_lbl.getText();
			String[] string_split = string.split(" ");
			int score = Integer.parseInt(string_split[2]);
			score += 1;

			// update player score  and result labels
			player_score_lbl.setText(String.format("Player Score: %d", score));
			result_lbl.setText("Player wins!");

		// action if a push:
		} else {
			// update result label
			result_lbl.setText("Push! No winner.");
		}

		// enable start button, disable hit and stand
		start.setDisable(false);
		hit.setDisable(true);
		stand.setDisable(true);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
