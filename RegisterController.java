package tda;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class RegisterController implements Initializable {

    @FXML
    private TextField TBRusername;
    
    @FXML
    private PasswordField TBRpassword1;
    
    @FXML
    private PasswordField TBRpassword2;
    
    @FXML
    private Label tester;
    
    @FXML
    private void Rregister(ActionEvent event) throws IOException
    {
        String Rusername = TBRusername.getText();
        String Rpassword1 = TBRpassword1.getText();
        String Rpassword2 = TBRpassword2.getText();
        
        Connection conn=null;
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB7","Db7User","1*Mr&bQ4");
            System.out.println("Database connected");
            if (Rpassword1.equals(Rpassword2))
            {
                Statement stmt = null;
                String query = "INSERT INTO LoginTable (username, password) VALUES ("+Rusername+", "+Rpassword1+")";
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                System.out.println("Account created");
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else
            {
                System.out.println("Passwords are not the same. Try again");
            }
        }
        catch(Exception ex)
        {   
        } 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
