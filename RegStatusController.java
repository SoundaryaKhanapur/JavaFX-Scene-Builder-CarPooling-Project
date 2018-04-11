package com.carpooling.view;


import java.io.IOException;
import java.util.List;

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

public class RegStatusController extends Main {
	
	
	@FXML
	private  Label ownername= new Label();
	
	@FXML
	private  Label regStatus= new Label();
	
	@FXML
	private  Label stpt= new Label(); 
	
	@FXML
	private  Label mob= new Label(); 
	
	@FXML
	private  Label timing= new Label(); 
	
	@FXML 
	private void initialize() {							
		if(null!=Main.user.getTslot()) {
			User owner=Main.passengerMap.get(Main.user);
		if(null!=owner) {	
		ownername.setText(owner.fname+" "+owner.lname);
		mob.setText(owner.mobile);}else {
			ownername.setText("Owner not yet availabe");
			mob.setText("NA");
		}
		stpt.setText(Main.user.stpt);
		timing.setText(Main.user.getTslot());
		}else {
			regStatus.setText("Please Register First");
		}
	}
	
	@FXML
	private void okButton() throws IOException {
		
		Main.regHome();
	}
	
	@FXML
	private void cancelReg() throws IOException {
		if(null!=Main.user.getTslot()) {
		if(Main.user.getOp().equals("passenger")) {				
			
			if(null!=Main.passengerMap.get(Main.user)) {
		
		User owner=Main.passengerMap.get(Main.user);
		owner.setSeats(owner.getSeats() + 1);
		Main.ownerMap.get(owner).remove(Main.user);
			}
		Main.passengerMap.remove(Main.user);		
		Main.user.setOp(null);Main.user.setSeats(0);Main.user.setTslot(null);
		}
		else {
			List<User> usrlist=Main.ownerMap.get(Main.user);
			for(User user:usrlist) {
				Main.passengerMap.put(user, null);
			}
			Main.ownerMap.remove(Main.user);
			Main.user.setOp(null);Main.user.setSeats(0);Main.user.setTslot(null);
		}
		}
		Main.regHome();
	}
	
	

	
	

}
