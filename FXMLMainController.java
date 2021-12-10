package tda;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class FXMLMainController implements Initializable {

    @FXML
    private Button edittaskbutton;
    
    @FXML
    private Button addtaskbutton;
    
    @FXML
    private TextField editnameTB;
    
    @FXML
    private TextField editddTB;
    
    @FXML
    private TextField addtaskTB;
    
    @FXML
    private TextField addddTB;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}