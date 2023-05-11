package com.example.mess_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.security.cert.PolicyNode;
import java.sql.*;

public class HelloController {
    public static String userinfinity;
    static String usersave,mid;

    static Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String query;

    @FXML
    private AnchorPane Panel;
    @FXML
    private BorderPane BorderPanel;
    Stage stage=new Stage();

    @FXML
    private Button set_item;

    @FXML
    private Button set_price;


    @FXML
    private Button customer;

    @FXML
    private Button owner;

    @FXML
    private PasswordField pass;

    @FXML
    private TextField user;


    @FXML
    private TextField itemno;

    @FXML
    private TextField itemname;

    @FXML
    private TextField newitem;

    @FXML
    private TextField cbprice;

    @FXML
    private TextField rpprice;

    String custname,custpass,ownername,ownerpass;


    @FXML
    private TextField messid;

    @FXML
    private TextField muser;

    @FXML
    private TextField addcustomer;

    @FXML
    private TextField addid;

    @FXML
    private TextField amtpaid;

    @FXML
    void shiftcustomer(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StudentMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Mess system ");
        Image icon=new Image("C:\\Users\\Lomesh Wagh\\Desktop\\mess system\\icon.png");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void shiftowner(ActionEvent event) throws IOException {
        AnchorPane Pane = FXMLLoader.load(getClass().getResource("Owner.fxml"));
        Panel.getChildren().setAll(Pane);
    }

    public void LoginCustomer(ActionEvent actionEvent) throws IOException, ClassNotFoundException, SQLException {
        if(user.getText().equals(custname)&& pass.getText().equals(custpass)){
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StudentMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Mess system ");
            Image icon=new Image("C:\\Users\\Lomesh Wagh\\Desktop\\mess system\\icon.png");
            stage.getIcons().add(icon);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void LoginOwner(ActionEvent actionEvent) throws IOException, ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL" , "mess","452458459");
        query = "select username,password from messlogin where username= '"+user.getText()+"'";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        if (rs.next()) {
            ownername= rs.getString(1);
            ownerpass = rs.getString(2);
        } else {
            JOptionPane.showMessageDialog(null, "No Username found");
        }

        if(user.getText().equals(ownername)&& pass.getText().equals(ownerpass)){

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("OwnerMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Mess system ");
            Image icon=new Image("C:\\Users\\Lomesh Wagh\\Desktop\\mess system\\icon.png");
            stage.getIcons().add(icon);
            stage.setScene(scene);
            stage.show();
        }else{
            JOptionPane.showMessageDialog(null, "Password Incorrect");
        }
        userinfinity=user.getText();
    }
    public void Clear(ActionEvent actionEvent) {
        user.setText("");
        pass.setText("");
    }

    public void Update(ActionEvent actionEvent) throws IOException {
        AnchorPane Pane = FXMLLoader.load(getClass().getResource("Updation.fxml"));
        BorderPanel.setCenter(Pane);
    }

    public void Display(ActionEvent actionEvent) throws IOException {
        ScrollPane Pane = FXMLLoader.load(getClass().getResource("Displaymenu.fxml"));
        BorderPanel.setCenter(Pane);
    }
    @FXML
    void SetItem(ActionEvent event) throws IOException {
        AnchorPane Pane = FXMLLoader.load(getClass().getResource("setitem.fxml"));
        BorderPanel.setCenter(Pane);
    }

    @FXML
    void SetPrice(ActionEvent event) throws IOException {
        AnchorPane Pane = FXMLLoader.load(getClass().getResource("setprice.fxml"));
        BorderPanel.setCenter(Pane);
    }

    @FXML
    public void Attendance(ActionEvent actionEvent) throws IOException {
        AnchorPane Pane = FXMLLoader.load(getClass().getResource("attend.fxml"));
        BorderPanel.setCenter(Pane);
    }

    @FXML
    void addcust(ActionEvent event) throws IOException {
        AnchorPane Pane = FXMLLoader.load(getClass().getResource("custAdd.fxml"));
        BorderPanel.setCenter(Pane);
    }

    @FXML
    void detailDisplay(ActionEvent event) throws IOException {
        ScrollPane Pane = FXMLLoader.load(getClass().getResource("custDisplay.fxml"));
        BorderPanel.setCenter(Pane);
    }

    @FXML
    void insertItem(ActionEvent event) throws ClassNotFoundException, SQLException {

        int id=0;
        String password=null;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL" , "mess","452458459");
        query = "select password from messlogin where username= '"+user.getText()+"'";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        if (rs.next()) {
            password = rs.getString(1);
        } else {
            JOptionPane.showMessageDialog(null, "No Username found");
        }

        if (user.getText().equals("Shrinidhi")||user.getText().equals("shrinidhi")){
            try {
                query = "select itemNo1.nextval from dual";
                pst = con.prepareStatement(query);
                rs = pst.executeQuery();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Item Tabel is Full");
            }

            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                System.out.println("Insertion table is full");
            }
        } else if (user.getText().equals("Sugam")||user.getText().equals("sugam")) {
            try {
                query = "select itemNo2.nextval from dual";
                pst = con.prepareStatement(query);
                rs = pst.executeQuery();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Item Tabel is Full ");
            }

            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                System.out.println("Insertion table is full");
            }
        }else{
            JOptionPane.showMessageDialog(null, "something went wrong");
        }

        if(pass.getText().equals(password)&& id>0){
            query="insert into "+user.getText()+"Menu values ("+id+",'"+itemname.getText()+"')";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "Something Went Wrong");
            }
            JOptionPane.showMessageDialog(null, "Inserted Succesfully");
            user.setText("");
            pass.setText("");
            itemname.setText("");

        }else{
            JOptionPane.showMessageDialog(null, "Username or Password Invalid");
        }
    }
    @FXML
    void updateItem(ActionEvent event) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL" , "mess","452458459");
        query = "select password from messlogin where username= '"+user.getText()+"'";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        if (rs.next()) {
            ownerpass = rs.getString(1);
        } else {
            JOptionPane.showMessageDialog(null, "No Username found");
        }
        if(pass.getText().equals(ownerpass)){
            query="update "+user.getText()+"Menu set Item_name='"+newitem.getText()+"' where Serial_no="+itemno.getText();
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "Something Went Wrong");
            }
            JOptionPane.showMessageDialog(null, "Updated Succesfully");
            user.setText("");
            pass.setText("");
            newitem.setText("");
            itemno.setText("");

        }else{
            JOptionPane.showMessageDialog(null, "Username or Password Invalid");
        }

    }
    @FXML
    void updatePrice(ActionEvent event) throws ClassNotFoundException, SQLException {
        int id=0;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL" , "mess","452458459");
        query = "select password from messlogin where username= '"+user.getText()+"'";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        if (rs.next()) {
            ownerpass = rs.getString(1);
        } else {
            JOptionPane.showMessageDialog(null, "No Username found");
        }
        query="select id from messlogin where username='"+user.getText()+"'";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        if(rs.next()){
            id=rs.getInt(1);
        }else {
            JOptionPane.showMessageDialog(null, "No Username found");
        }
        if(pass.getText().equals(ownerpass)) {
            query = "update messprice set riceplate =" + rpprice.getText() + ",chapatibhaji=" + cbprice.getText() + "where id=" + id;
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "Something Went Wrong");
            }
            JOptionPane.showMessageDialog(null, "Updated Succesfully");
            user.setText("");
            pass.setText("");
            rpprice.setText("");
            cbprice.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Username or Password Invalid");
        }

    }

    @FXML
    void custadd(ActionEvent event) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL" , "mess","452458459");
        query = "select password from messlogin where username= '"+user.getText()+"'";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        if (rs.next()) {
            ownerpass = rs.getString(1);
        } else {
            JOptionPane.showMessageDialog(null, "No Username found");
        }
        if(pass.getText().equals(ownerpass)){
            query="insert into "+user.getText()+"Customer values('"+addid.getText()+"','"+addcustomer.getText()+"',"+0+","+amtpaid.getText()+")";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "Something Went Wrong");
            }
            JOptionPane.showMessageDialog(null, "Inserted Succesfully");
            user.setText("");
            pass.setText("");
            addid.setText("");
            addcustomer.setText("");
            amtpaid.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Username or Password Invalid");
        }
    }
    @FXML
    private TextField MessId;
    public void restarter() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("restartmonth.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Mess system ");
        Image icon=new Image("C:\\Users\\Lomesh Wagh\\Desktop\\mess system\\icon.png");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
//
    }
    @FXML
    void custPresent(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL" , "mess","452458459");
        query = "select password from messlogin where username= '"+user.getText()+"'";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        if (rs.next()) {
            ownerpass = rs.getString(1);
        } else {
            JOptionPane.showMessageDialog(null, "No Username found");
        }
        if(pass.getText().equals(ownerpass)){
            int att=0;
            query = "select attendance from "+user.getText()+"Customer where MessId='"+MessId.getText()+"'";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            if (rs.next()) {
                att = rs.getInt(1);
            } else {
                JOptionPane.showMessageDialog(null, "Attendance Problem");
            }
            usersave=user.getText();
            mid=MessId.getText();

            if(att<30){
                att++;

                query="update "+user.getText()+"Customer set Attendance ="+ att +" where MessId ='"+MessId.getText()+"'";
                pst = con.prepareStatement(query);
                rs = pst.executeQuery();
            }else{

                restarter();
            }

        }else{
            JOptionPane.showMessageDialog(null, "Username or Password Invalid");
        }

    }
    public void cut(ActionEvent actionEvent) {
        user.setText("");
        pass.setText("");
    }
    @FXML
    void AttLogin(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("custLogin.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Mess system ");
            Image icon = new Image("C:\\Users\\Lomesh Wagh\\Desktop\\mess system\\icon.png");
            stage.getIcons().add(icon);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    void gotoMess1(MouseEvent event) throws IOException, ClassNotFoundException, SQLException {
        String itemdets[]= new String[6];
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL" , "mess","452458459");
        query = "select item_name from ShrinidhiMenu";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        int i=0;
        while(rs.next()){
            itemdets[i]=rs.getString(1);
            i++;
        }
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL" , "mess","452458459");
        query = "select Riceplate,Chapatibhaji from messprice where id=1";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        if(rs.next()){
            itemdets[i]=rs.getString(1);
            itemdets[i+1]=rs.getString(2);
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Mess1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Mess system ");
        Image icon=new Image("C:\\Users\\Lomesh Wagh\\Desktop\\mess system\\icon.png");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
        showAttendance s=fxmlLoader.getController();
        s.menulabel(itemdets);

    }

    @FXML
    void gotoMess2(MouseEvent event) throws IOException, ClassNotFoundException, SQLException {
        String itemdets[]= new String[6];
        for(int i=0;i<6;i++)
        {
            itemdets[i]=null;
        }
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL" , "mess","452458459");
        query = "select item_name from SugamMenu";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        int i=0;
        while(rs.next()){
            itemdets[i]=rs.getString(1);
            if(i<=3)
            i++;
        }
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL" , "mess","452458459");
        query = "select Riceplate,Chapatibhaji from messprice where id=2";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        if(rs.next()){
            itemdets[i]=rs.getString("riceplate");
            itemdets[i+1]=rs.getString("chapatibhaji");
        }else {
            JOptionPane.showMessageDialog(null,"Menu is empty ");
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Mess2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Mess system ");
        Image icon=new Image("C:\\Users\\Lomesh Wagh\\Desktop\\mess system\\icon.png");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
        showAttendance s=fxmlLoader.getController();
        s.menulabel(itemdets);
    }

    @FXML
    void LoginCust(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        String amt = null,att = null;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL" , "mess","452458459");
        query = "select attendance,amtpaid from "+muser.getText()+"Customer where MessId='"+messid.getText()+"'";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        if(rs.next()){
            att=rs.getString(1);
            amt=rs.getString(2);
        }else{
            JOptionPane.showMessageDialog(null, "Mess Id or Mess Name is invalid");
        }
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("attmanu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Mess system ");
            Image icon=new Image("C:\\Users\\Lomesh Wagh\\Desktop\\mess system\\icon.png");
            stage.getIcons().add(icon);
            stage.setScene(scene);
            stage.show();
            showAttendance s=fxmlLoader.getController();
            s.changelabel(att,amt);

    }
    @FXML
    void clearcust(ActionEvent event) {
        messid.setText("");
        muser.setText("");
    }

    public void Exit(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL" , "mess","452458459");
        query= "commit";
        pst=con.prepareStatement(query);
        rs= pst.executeQuery();
        if(rs.next())
        {
            JOptionPane.showMessageDialog(null,"something went wrong");
            return;
        }
        JOptionPane.showMessageDialog(null,"commited Succesfully");
        con.close();
        System.out.println("ended");
        javafx.application.Platform.exit();
    }

    public void restart(ActionEvent actionEvent) throws SQLException {
        query="update "+usersave+"Customer set Attendance="+ 1 +" where MessId ='"+mid+"'";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        JOptionPane.showMessageDialog(null,"Restarted Succesfully");
        stage.close();
    }

    public void stop(ActionEvent actionEvent) throws SQLException {
        query="delete from "+usersave+"Customer where MessId ='"+mid+"'";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        JOptionPane.showMessageDialog(null,"Removed Succesfully");
        stage.close();
    }
}
