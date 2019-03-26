package kama.quoteapp.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MainController implements Initializable {

	@FXML
	private TextField titleText;

	@FXML
	private Button actionButton;

	@FXML
	private TextArea quoteArea;

	@FXML
	private ImageView imgArea;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		actionButtonPressed();
	}

	private void actionButtonPressed() {
		actionButton.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				quoteArea.clear();
				try {
					shuffle();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}

	private void shuffle() throws IOException {
		String fileName = "quotes.txt";
		FileReader fileReader = null;
		BufferedReader reader = null;
		int lines = 14;
		try {
			fileReader = new FileReader(fileName);
			reader = new BufferedReader(fileReader);

			List<String> quotes = new ArrayList<>();

			for (int i = 0; i < lines; i++) {
				quotes.add(reader.readLine());
			}
			int randomNumber = ThreadLocalRandom.current().nextInt(0, lines);
			quoteArea.appendText(quotes.get(randomNumber));
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}