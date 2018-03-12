package controller;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.CFingerPrint;

public class ClockInTimeController {

	private CFingerPrint m_finger1 = new CFingerPrint();
	private CFingerPrint m_finger2 = new CFingerPrint();
	private double finger1[] = new double[m_finger1.FP_TEMPLATE_MAX_SIZE];
	private double finger2[] = new double[m_finger2.FP_TEMPLATE_MAX_SIZE];
	private static Stage stage;

	@FXML
	private TextArea timeIO;

	public void start(Stage mainStage) {
		stage = mainStage;
	}

	public void clockIn() {
		timeIO.setText("Place your finger!");

	}

	public void clockOut() {

	}

	private boolean matchMessage() {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Match %");
		alert.setHeaderText(null);
		alert.setContentText(Double.toString(m_finger1.Match(finger1 , finger2,65,false)));
		alert.showAndWait();
		return true;
	}

	private void errorMessage() {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error Message");
		alert.setHeaderText(null);
		alert.setContentText("No match! try again");

		alert.showAndWait();
	}
}
