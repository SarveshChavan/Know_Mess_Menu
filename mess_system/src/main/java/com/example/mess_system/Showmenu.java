package com.example.mess_system;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Showmenu implements Initializable {

    @FXML
    private TableView<newfile1> menutable;

    @FXML
    private TableColumn<newfile1, String> itemn;


    @FXML
    private TableColumn<newfile1, Integer> srno;

    ObservableList<newfile1> oblist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HelloController h=new HelloController();
        String user=h.userinfinity;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "mess", "452458459");
            String query ="select * from "+user+"Menu order by serial_no";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                this.oblist.add(new newfile1(rs.getInt("Serial_no"),rs.getString("Item_name")));
            }
            this.srno.setCellValueFactory(new PropertyValueFactory("Sn"));
            this.itemn.setCellValueFactory(new PropertyValueFactory("It"));
            this.menutable.setItems(this.oblist);

        } catch (Exception e) {
            throw new RuntimeException(e);

        }

    }
}
