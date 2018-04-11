package com.carpooling.view;


import java.io.IOException;

import com.carpooling.Main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class HomeController {
	
	
	@FXML
	private void register() throws IOException {
		
		Main.register();
			
	}
	
	

	@FXML
	private void updateProfile() throws IOException {
			ProfileController.usrnm=Main.user.username;
			Main.createProfile();
	}

	

	@FXML
	private void checkStatus() throws IOException {
		Main.checkStatus();
			
	}
	
	@FXML
	private void logoff() throws IOException {
		Main.user=null;
		Main.showMainItems();
			
	}

	
	
		

}
