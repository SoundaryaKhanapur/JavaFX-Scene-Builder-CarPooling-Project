package com.carpooling.view;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.carpooling.Main;
import com.carpooling.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class RegisterController extends Main {


	ObservableList<String> selectTime = FXCollections.observableArrayList("08:15", "10:15", "16:15", "21:15");
	ObservableList<String> seatList ;




	@FXML
	private ComboBox time;


	@FXML
	private  ComboBox seat;

	@FXML
	private CheckBox oBox;

	@FXML
	private CheckBox pBox;


	@FXML
	private void makeRegistration() throws IOException {		

		Main.user.setSeats((int) Integer.parseInt((String) seat.getValue()));		//string 2 int
		Main.user.setTslot((String) time.getValue());		
		if(Main.user.getOp().equals("passenger")) {
			for(User owner:Main.ownerMap.keySet()) {			//sees owner stpt n seat n time
				if(owner.stpt.equals(Main.user.stpt)&&owner.getTslot().equals(Main.user.getTslot())
						&&owner.getSeats()>0	) {
					owner.setSeats(owner.getSeats() - 1);
					Main.passengerMap.put(Main.user, owner);
					Main.ownerMap.get(owner).add(Main.user);

				}
			}

			if(null == Main.passengerMap.get(Main.user)) {					
				for(User owner:Main.ownerMap.keySet()) {		
					if(owner.route.equals(Main.user.route)&&owner.getTslot().equals(Main.user.getTslot())
							&&(Main.routeLogic.get(owner.stpt)<Main.routeLogic.get((Main.user.stpt)))
							&&owner.getSeats()>0	) {
						owner.setSeats(owner.getSeats() - 1);
						Main.passengerMap.put(Main.user, owner);
						Main.ownerMap.get(owner).add(Main.user);

					}
				}
			}

		}
		if(Main.user.getOp().equals("owner"))
		{
			List<User> usrlst= new ArrayList<User>();

			Main.ownerMap.put(Main.user, usrlst);
		}

		Main.regHome();
	}



	@FXML
	private void handleoBox() {						//either owner checkbox else passenger

		if(oBox.isSelected()) {

			pBox.setSelected(false);
			Main.user.setOp("owner");
			seatList= FXCollections.observableArrayList("2", "4", "6");
			seat.setValue("2");
			seat.setItems(seatList);

		}
	}

	@FXML
	private void handlepBox() {

		if(pBox.isSelected()) {
			oBox.setSelected(false);
			Main.user.setOp("passenger");
			seatList= FXCollections.observableArrayList("1");
			seat.setValue("1");
			seat.setItems(seatList);
		}
	}





	
	@FXML 
	private void initialize() {


		time.setValue("08:15");
		time.setItems(selectTime);
		pBox.setSelected(true);
		Main.user.setOp("passenger");
		seatList= FXCollections.observableArrayList("1");
		seat.setValue("1");
		seat.setItems(seatList);


	}


}
