package com.carpooling;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.kvishalnie.BeanMapper.BeanMapper;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage primaryStage;
	private static BorderPane mainLayout;
	protected static Map<String,String> userlogin = new HashMap<String,String>();   //user name password
	protected static Map<String,User> userdetails = new HashMap<String,User>();     //user details
	public static Map<User,User> passengerMap = new HashMap<User,User>();			//passenger map & owner map
	public static Map<String,Integer> routeLogic = new HashMap<String,Integer>();	//starting point name &  id
	
	public static Map<User,List<User>> ownerMap = new HashMap<User,List<User>>();	//store list in file<>-> generic 4 collection array list of users
	public static List<User> usrlst= new ArrayList<User>();		//update profile, new, write file
	public static User user;
	@Override
	public void start(Stage primaryStage) throws IOException  {		// i/o exception if dint get stage. o/p is console
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Car Pooling");
		//initialize();
		showMainView();
		showMainItems();
	}
	
	
	
	private static void initializeMap() {
		try {
		
		//To load from existing file	
		List<User> userList=BeanMapper.beanMapperFile(User.class, "F:\\eclipse\\workspace\\CarPooling\\carpooling.txt");  // repository
		userList.forEach(s->{								//read from file n put in2 user list-> beam mapper lambda used here
			userlogin.put(s.username, s.password);
			userdetails.put(s.username, s);
			usrlst.add(s);
		});
		
		
		}catch(Exception e) {}				
		
		routeLogic.put("Harsha Hotel", 1);							//list of starting point
		routeLogic.put("Srinagar Garden", 2);
		routeLogic.put("Ramdev Hotel", 3);
		routeLogic.put("Channamma Circle", 4);
		routeLogic.put("Fish Market", 5);
		routeLogic.put(" 2nd Gate", 6);
		routeLogic.put("Guard Room", 1);
		routeLogic.put(" Mutaga", 2);
		routeLogic.put("Kudachi", 3);
		routeLogic.put("Gandhi Nagar", 4);
		routeLogic.put(" Fort Circle", 5);
		
		
		routeLogic.put("Manikbag", 1);
		routeLogic.put("Kapileshwar", 2);
		routeLogic.put("Tukaram Bank", 3);
		routeLogic.put("Dutta Mandir", 4);
		routeLogic.put("Goaves", 5);
		routeLogic.put("RPD", 6);
		routeLogic.put("3rd Gate", 7);
		
		
		routeLogic.put("Kumta", 1);
		routeLogic.put("Dhareshwar", 2);
		routeLogic.put("Haldipur", 3);
		routeLogic.put("Karki", 4);
		routeLogic.put("Ramthirtha", 5);
		routeLogic.put("Honnavar", 6);


		routeLogic.put("Ganesh Temple", 1);
		routeLogic.put("Sahyadri Nagar", 2);
		routeLogic.put("T.V.Center", 3);
		routeLogic.put("Sadashiv Nagar", 4);
		routeLogic.put("Bogar Ves", 5);

		
		
		
		
		
	}
	
	public static void saveUser(User user) {					//write into file
		if(!usrlst.contains(user)) {
		usrlst.add(user);}else {			//if-> new else->update
			usrlst.remove(user);
			usrlst.add(user);
		}
		try{
			
			BeanMapper.beanWriterFile(usrlst, "F:\\eclipse\\workspace\\CarPooling\\carpooling.txt");		//write 2 file
		}catch(Exception e) {
			
		}
		userlogin.put(user.username, user.password);
		userdetails.put(user.username, user);
		
	}
	public void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/Title.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout,800,600);
	
		primaryStage.setScene(scene); 
		primaryStage.show();
	}
	
	public static void showMainItems() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/LoginSignup1.fxml"));
		BorderPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
	}
	
	public static void showLoginFailure() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/LoginFailed1.fxml"));
		BorderPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
		
	}
	
	public static void showSignupFailure() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/SignupFailed1.fxml"));
		BorderPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
		
	}
	
	public static void createProfile() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/CreateProfile1.fxml"));
		AnchorPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
		
	}
	
	public static void register() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/Register1.fxml"));
		AnchorPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
		
	}
	
	public static void regHome() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/Home.fxml"));
		AnchorPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
		
	}
	
	public static void checkStatus() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/RegStatus.fxml"));
		AnchorPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
		
	}
	
	public static void displayError() throws IOException {
		System.out.println("inside Error");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/ErrorPage.fxml"));
		AnchorPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
		
	}

	
		public static void main(String[] args) {
			initializeMap();
			launch(args);
	}

}
