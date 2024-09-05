/*
 * Chloe Moore
 * CS 16000-01 03, Fall Semester 2023
 * Lab 7
 *
 */

package lab07_ChloeMoore;

import java.awt.Color;
import java.util.Random;
import javax.swing.*;

public class ESPGame {
	private String chosenColor;

	public static void main(String[] args) {
	}

	public Color chooseColor(int n) {
		Color color = null;
		switch (n) {
		case 1:
			color = Color.BLUE;
			chosenColor = "Blue";
			break;
		case 2:
			color = Color.YELLOW;
			chosenColor = "Yellow";
			break;
		case 3:
			color = Color.RED;
			chosenColor = "Red";
			break;
		case 4:
			color = Color.GREEN;
			chosenColor = "Green";
			break;
		case 5:
			color = Color.ORANGE;
			chosenColor = "Orange";
			break;
		case 6:
			color = Color.CYAN;
			chosenColor = "Cyan";
			break;
		case 7:
			color = Color.DARK_GRAY;
			chosenColor = "Dark Gray";
			break;
		case 8:
			color = Color.GRAY;
			chosenColor = "Gray";
			break;
		case 9:
			color = Color.PINK;
			chosenColor = "Pink";
			break;
		case 10:
			color = Color.MAGENTA;
			chosenColor = "Magenta";
			break;
		case 11:
			color = Color.WHITE;
			chosenColor = "White";
			break;
		case 12:
			color = Color.LIGHT_GRAY;
			chosenColor = "Light Gray";
			break;
		case 13:
			color = Color.BLACK;
			chosenColor = "Black";
			break;
		}
		return color;
	} // end chooseColor

	public void showColor(Color color) {
		JFrame frame = new JFrame("Guess this color");
		frame.setSize(200, 200);
		frame.setLocation(300, 300);
		JPanel panel = new JPanel();
		panel.setBackground(color);
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // end showColor

	public void guessColor() {
		String title = "ESP Game";
		int enter = 0;
		int count_all = 0;
		int count_right = 0;

		// initiate game
		enter = JOptionPane.showConfirmDialog(null, "Do you want to play the ESP Game?", title,
				JOptionPane.YES_NO_OPTION);

		// check for exit before entering game
		if (enter != 0) {
			System.out.println("ESP Game closed.");
			JOptionPane.showMessageDialog(null, "ESP Game closed.", title, JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}

		// main game loop
		while (enter == 0) {
			// randomly select color
			Random random = new Random();
			int new_int = random.nextInt(1, 14);

			// run choose and show methods
			Color new_color = chooseColor(new_int);
			showColor(new_color);

			// color selection pane
			String colors = "Blue\nYellow\nRed\nGreen\nOrange\nCyan\nDark Gray\nGray\nPink\nMagenta\nWhite\nLight Gray\nBlack";
			String colors_list[] = { "Blue", "Yellow", "Red", "Green", "Orange", "Cyan", "Dark Gray", "Gray", "Pink",
					"Magenta", "White", "Light Gray", "Black" };
			String user_input = (String) JOptionPane.showInputDialog(null, colors, title, JOptionPane.QUESTION_MESSAGE,
					null, colors_list, colors_list[0]);

			// check for cancel selection (exits loop)
			if (user_input == null) {
				break;
			}

			// update counters
			count_all++;
			if (user_input != chosenColor) {
				JOptionPane.showMessageDialog(null, "You guessed incorrectly.", title, JOptionPane.WARNING_MESSAGE);
			} else {
				count_right++;
				JOptionPane.showMessageDialog(null, "That's correct! Do you have ESP super powers?", title,
						JOptionPane.INFORMATION_MESSAGE);
			}

			// continue?
			enter = JOptionPane.showConfirmDialog(null, "Do you want to play again?", title, JOptionPane.YES_NO_OPTION);

		} // end game while loop

		// formulate and display results
		double success_rate = Double.valueOf(count_right) / count_all * 100;
		String message = String.format("Out of %d games, you guessed %d correctly.\nYour success rate is %.2f%%.",
				count_all, count_right, success_rate);
		System.out.println(message);
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);

		System.exit(0);
	} // end guessColor

} // end main