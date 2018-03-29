package controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.CFingerPrint;
import model.DialogBoxHelper;
import model.MySqlManager;

public class ClockInTimeController {

	private CFingerPrint m_finger1 = new CFingerPrint();
	private CFingerPrint m_finger2 = new CFingerPrint();
	private double finger1[] = new double[m_finger1.FP_TEMPLATE_MAX_SIZE];
	private double finger2[] = new double[m_finger2.FP_TEMPLATE_MAX_SIZE];
	private static Stage stage;
	private MySqlManager mysql;

	@FXML
	private TextArea timeIO;
	@FXML
	private TextField empID;

	public void start(Stage mainStage) {
		stage = mainStage;
		mysql = MySqlManager.getInstance();
	}

	public void clockIn() {
		
		// Query data base and pass the ID number entered by employee
		String idNum = empID.getText();
		
		if(idNum.isEmpty()) {
			DialogBoxHelper.emptyFieldException();
			return;
		}
		timeIO.setText("Place your finger!");
		
		System.out.println(mysql.getUserBiometricPrint(idNum).equals(idNum));
		System.out.println("from DBMS: "+mysql.getUserBiometricPrint(idNum));
		System.out.println("from user: "+idNum);
		timeIO.setText("Match!");

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
	
	public void exit() throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/hostpanel.fxml"));
		AnchorPane root = (AnchorPane)loader.load();


		HostpanelController userController = 
				loader.getController();
		userController.start(stage);
		
		Scene scene = new Scene(root,600,600);
		stage.setScene(scene);
		stage.show();
	}
}
