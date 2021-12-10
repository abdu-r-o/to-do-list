package tda;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextField TBusername;
    
    @FXML
    private PasswordField TBpassword;
    
    @FXML
    private void login(ActionEvent event) throws IOException {
        String username = TBusername.getText();
        String password = TBpassword.getText();
        Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB7","Db7User","1*Mr&bQ4");
            if(conn!=null){
                System.out.println("Database Successfully Connected");
            }
            Statement stmt = null;
            String query = "select username, password from LoginTable";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String usernameDB;
            String passwordDB;
            while (rs.next())
            {
                usernameDB =rs.getString("Username").trim();
                passwordDB =rs.getString("Password").trim();
                System.out.println(usernameDB + " " + passwordDB);
                if (username.equals(usernameDB) && password.equals(passwordDB))
                {
                    label.setText("Logged in");
                    Stage stage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("FXMLMain.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show(); 
                }
                else
                {
                    label.setText("Login failed, Try again");
                }
            }
        }
        catch(Exception ex){   
        }    
    }
    
    @FXML
    private void register(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
