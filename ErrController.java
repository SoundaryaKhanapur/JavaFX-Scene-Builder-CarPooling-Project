package com.carpooling.view;

import java.io.IOException;

import com.carpooling.Main;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ErrController {
	
	@FXML
	private  Label errMsg= new Label();
	
	public static String error;
	
	@FXML 
	private void initialize() {
		errMsg.setText(error);
	}
	
	@FXML
	private void home() throws IOException {
		if(null==Main.user)	{
			LoginSignupController.selected=1;
		Main.showMainItems();
		
		}else {
			Main.regHome();
		}
	}

}
