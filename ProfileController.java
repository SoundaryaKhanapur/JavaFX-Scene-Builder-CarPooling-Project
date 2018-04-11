package com.carpooling.view;


import java.io.IOException;

import com.carpooling.Main;
import com.carpooling.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class ProfileController extends Main {
	
	
	ObservableList<String> routeList = FXCollections.observableArrayList("Route1", "Route2", "Route3", "Route4", "Route5");
	
	ObservableList<String> routeOneList = FXCollections.observableArrayList("Harsha Hotel","Srinagar Garden","Ramdev Hotel", "Channamma Circle", "Fish Market", " 2nd Gate"	);
	
	ObservableList<String> routeTwoList = FXCollections.observableArrayList("Guard Room", " Mutaga", "Kudachi", "Gandhi Nagar", " Fort Circle");
	
	
	ObservableList<String> routeThreeList =FXCollections.observableArrayList ("Manikbag","Kapileshwar","Tukaram Bank","Dutta Mandir","Goaves","RPD","3rd Gate");
	
	
	ObservableList<String> routeFourList  =   FXCollections.observableArrayList ("Kumta","Dhareshwar","Haldipur","Karki","Ramthirtha","Honnavar");
	
	
	ObservableList<String> routeFiveList   =   FXCollections.observableArrayList ("Ganesh Temple","Sahyadri Nagar","T.V.Center","Sadashiv Nagar","Bogar Ves");
	
	
	

	
	
	
	@FXML
	private  Label username= new Label();  
	@FXML
	private  TextField fname= new TextField(); 
	
	@FXML
	private  TextField lname= new TextField(); 
	
	@FXML
	private  TextField password= new TextField();

	@FXML
	private  TextField mobile= new TextField();
	
	public static String usrnm;
	
	@FXML
	private ComboBox route;

	@FXML
	private ComboBox startingPt;
	
	@FXML
	private void cancelProfile() throws IOException {
		
		Main.showMainItems();
	}
	
	

	
	@FXML
	private void RouteChoice() {
		
		
		if(route.getValue().equals("Route1")) {
			startingPt.setValue("Harsha Hotel");
			startingPt.setItems(routeOneList);
			
		}
		else if(route.getValue().equals("Route2")) {
			startingPt.setValue("Guard Room");
			startingPt.setItems(routeTwoList);
		}
		
		else if(route.getValue().equals("Route3")) {
			startingPt.setValue("Manikbag");
			startingPt.setItems(routeThreeList);
		}
		
		else if(route.getValue().equals("Route4")) {
			startingPt.setValue("Kumta");
			startingPt.setItems(routeFourList);
		}
		
		
		else if(route.getValue().equals("Route5")) {
			startingPt.setValue("Ganesh Temple");
			startingPt.setItems(routeFiveList);
		}

		
	}
	
	@FXML
	private void create() throws IOException {
		System.out.println(fname.getText());
		System.out.println(lname.getText());
		System.out.println(password.getText());
		System.out.println(mobile.getText());
		System.out.println(route.getValue());
		System.out.println(startingPt.getValue());
		System.out.println(mobile.getText().trim().length());

		
		
		ErrController.error = null;					//valid mobile number
		try {
			Long mob= Long.parseLong(mobile.getText().trim());
			System.out.println(mob);
			}catch(Exception e) {
				ErrController.error="Enter 10 digits";
				System.out.println(ErrController.error);
				//Main.displayError();
			}
		if(mobile.getText().trim().length()==10 && ErrController.error == null) {
			
			
		
		
		//create user
		try {
		User user= new User();
		//int mob = Integer.parseInt(mobile.getText());
		user.username=username.getText().trim();user.password=password.getText().trim();user.fname=fname.getText().trim();
		user.lname=lname.getText().trim();user.mobile=mobile.getText().trim();user.route=(String) route.getValue();user.stpt=(String) startingPt.getValue();
		Main.saveUser(user);
		LoginSignupController.selected = 0;
		Main.showMainItems();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		}
		else {
			if(ErrController.error == null)
			{ErrController.error="Mobile# length should be 10";}
			
			System.out.println("else");
			
			System.out.println(ErrController.error);
			Main.displayError();
			
			
		}
	}
	
	@FXML 
	private void initialize() {
		username.setText(usrnm);
		
		route.setValue("Route1");
		route.setItems(routeList);
		
		startingPt.setValue("Harsha Hotel");
		startingPt.setItems(routeOneList);

		if(null!=Main.user) {
			fname.setText(Main.user.fname);
			lname.setText(Main.user.lname);
			mobile.setText(Main.user.mobile);
			
			if(Main.user.route.equals("Route1"))
			startingPt.setItems(routeOneList);
			
			if(Main.user.route.equals("Route2"))
			startingPt.setItems(routeOneList);
			route.setValue(Main.user.route);
			startingPt.setValue(Main.user.stpt);
			
			if(Main.user.route.equals("Route3"))
				startingPt.setItems(routeThreeList);
				route.setValue(Main.user.route);
				startingPt.setValue(Main.user.stpt);
				
				
				if(Main.user.route.equals("Route4"))
					startingPt.setItems(routeFourList);
					route.setValue(Main.user.route);
					startingPt.setValue(Main.user.stpt);
					
					if(Main.user.route.equals("Route5"))
						startingPt.setItems(routeFiveList);
						route.setValue(Main.user.route);
						startingPt.setValue(Main.user.stpt);
		}

	}

	

}
