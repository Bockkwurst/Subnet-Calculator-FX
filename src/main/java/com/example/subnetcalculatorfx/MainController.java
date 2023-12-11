package com.example.subnetcalculatorfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainController implements Initializable{
   @FXML
   private Button calcButton;
   @FXML
   private TextField ipTextfield;
   @FXML
   private ChoiceBox<String> snmBox;
   @FXML
   private Label ipLabel;
   @FXML
   private Label snmLabel;
   @FXML
   private Label netIDLabel;
   @FXML
   private Label bcLabel;
   @FXML
   private Label hostLabel;
   @FXML
   private Label rangeLabel;
   @FXML
   private Label errorLabel;
   private String[] snmArray = {"0.0.0.0", "128.0.0.0", "192.0.0.0", "224.0.0.0", "240.0.0.0", "248.0.0.0", "252.0.0.0", "254.0.0.0", "255.0.0.0",
           "255.128.0.0", "255.192.0.0", "255.224.0.0", "255.240.0.0", "255.248.0.0", "255.252.0.0", "255.254.0.0", "255.255.0.0",
           "255.255.128.0", "255.255.192.0", "255.255.224.0", "255.255.240.0", "255.255.248.0", "255.255.252.0", "255.255.254.0",
           "255.255.255.0", "255.255.255.128", "255.255.255.192", "255.255.255.224", "255.255.255.240", "255.255.255.248",
           "255.255.255.252", "255.255.255.254", "255.255.255.255"};



   public void ipInput(){

}
public MainApplication main;
public void setMain(MainApplication main){
   this.main = main;
}


   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {
      snmBox.getItems().addAll(snmArray);
   }

   public void validate(){
      String ipAddress = ipTextfield.getText();
      String selectedSubnetMask = (String) snmBox.getValue();
      if (isValidIpAddress(ipAddress) && isValidSubnetMask(selectedSubnetMask)){
         ipLabel.setText(ipAddress);
         snmLabel.setText(selectedSubnetMask);
         System.out.println("Eingabe valide");
   }else{
         errorLabel.setText("Falsche Eingabe!");
         System.out.println("eingabe nicht valide");
      }
   }
   private boolean isValidSubnetMask(String subnetMask) {
      for (String validSubnetMask : snmArray) {
         if (validSubnetMask.equals(subnetMask)) {
            return true;
         }
      }
      return false;
   }
   private boolean isValidIpAddress(String ipAddress){
   try{
      InetAddress inetAddress = Inet4Address.getByName(ipAddress);
      return true;
   }catch(UnknownHostException e){
      return false;
      }
   }
   public void calculate(ActionEvent e){
   validate();
   }
}