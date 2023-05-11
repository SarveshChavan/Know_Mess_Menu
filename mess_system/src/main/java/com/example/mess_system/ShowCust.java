package com.example.mess_system;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ShowCust implements Initializable {
    @FXML
    private TableView<newfile2> custtable;


    @FXML
    private TableColumn<newfile2, Integer> amt;

    @FXML
    private TableColumn<newfile2, Integer> att;

    @FXML
    private TableColumn<newfile2, String> custid;


    @FXML
    private TableColumn<newfile2, String> name;

    ObservableList<newfile2> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HelloController h=new HelloController();
        String user=h.userinfinity;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "mess", "452458459");
            String query ="select * from "+user+"Customer order by messid";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                this.oblist.add(new newfile2(rs.getString("messid"),rs.getString("name"),rs.getInt("attendance"),rs.getInt("amtpaid")));
            }
            this.amt.setCellValueFactory(new PropertyValueFactory("am"));
            this.att.setCellValueFactory(new PropertyValueFactory("at"));
            this.name.setCellValueFactory(new PropertyValueFactory("name"));
            this.custid.setCellValueFactory(new PropertyValueFactory("id"));

            this.custtable.setItems(this.oblist);

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
}
