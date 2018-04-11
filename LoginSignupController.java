package com.carpooling.view;

import java.io.IOException;

import com.carpooling.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class LoginSignupController extends Main {
	
	@FXML
	private  TextField username= new TextField();  
	@FXML
	private  TextField tmpname= new TextField(); 
	
	@FXML
	private  TextField password= new TextField();
	
	@FXML
	private TabPane tabPane = new TabPane();
	
	public static int selected=0;
	@FXML
	private  Label error= new Label();  
	
	public static String err;
	
	
	
//	@FXML
//	private  Button home = new Button();
	
	@FXML
	private void login() throws IOException {
		//System.out.println(username.getText() +password.getText());
		if(Main.userlogin.containsKey(username.getText())&&userlogin.get(username.getText()).equals(password.getText())) {
			Main.user=Main.userdetails.get(username.getText());
			Main.regHome();
		}else {
			Main.showLoginFailure();
		}
			
	}
	
	@FXML
	private void signup() throws IOException {
		//System.out.println(tmpname.getText());
		String tmp = tmpname.getText().trim();		//space will be trimmed
		if(null==tmp||("".equals(tmp))||Main.userlogin.containsKey(tmp)) {				//tmp no blank,null
			selected=1;						//to show sign up again
			err = "Username not available";
			Main.showSignupFailure();
		}else {
			
			ProfileController.usrnm=tmpname.getText();
			Main.createProfile();
		}
			
	}
	
	@FXML
	private void home() throws IOException {
		Main.showMainItems();
	}
	
	
	@FXML 
	private void initialize() {
		//System.out.println("init");
		//System.out.println(selected);
		tabPane.getSelectionModel().select(selected);
		error.setText(err);

	}
	
	

}
