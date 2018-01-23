package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Items;
import model.MySqlManager;

public class FloorController {

	private static Stage stage;
	private ObservableList<String> specialsObsList,ffObsList,desertObsList,drinksObsList;
	
	@FXML
	private ListView<String> specialslList, fastfoodList, desertList, drinkList;
	
	public void start(Stage mainStage) {
		stage = mainStage;
		MySqlManager mysql = MySqlManager.getInstance();
		specialsObsList = FXCollections.observableArrayList(mysql.getSpecials());
		drinksObsList = FXCollections.observableArrayList(mysql.getDrinks());
		desertObsList = FXCollections.observableArrayList(mysql.getDesert());
		ffObsList = FXCollections.observableArrayList(mysql.getFastFood());
	}
	
	public void showFastFood() {
		fastfoodList.setItems(ffObsList);
	}
	
	public void showSpecials() {
		specialslList.setItems(specialsObsList);
	}
	
	public void showDesert() {
		desertList.setItems(desertObsList);
	}
	
	public void showDrinks() {
		drinkList.setItems(drinksObsList);
	}
}
