package com.example.mess_system;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class showAttendance {
    @FXML
    Label days,paid;

    @FXML
    private Label b1;

    @FXML
    private Label b2;

    @FXML
    private Label cbwithprice;

    @FXML
    private Label d1;

    @FXML
    private Label messaddress;

    @FXML
    private Label rcwithprice;

    @FXML
    private Label sweet;

    @FXML
    private Label greet;

    public void changelabel(String att,String amt){
        days.setText(att);
        paid.setText(amt);
    }
    public void menulabel(String idets[]){
        b1.setText(idets[0]);
        b2.setText(idets[1]);
        d1.setText(idets[2]);
        sweet.setText(idets[3]);
        rcwithprice.setText("Rice Plate Price : "+idets[4]);
        cbwithprice.setText("Chapati-Bhaji Price : "+idets[5]);
    }

}
