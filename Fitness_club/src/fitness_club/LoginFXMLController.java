/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness_club;

import ECUtils.GUIValidator;
import fit_club.bean.login;
import fit_club.dao.userDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private TextField userid;
    @FXML
    private PasswordField pass;
    @FXML
    private Button btnlogin;
    @FXML
    private Button btnexit;

    GUIValidator g= new GUIValidator();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        g.addNameValidator(userid);
        g.addPassValidator(pass);
    }    

    @FXML
    private void he(ActionEvent event) {
        if (event.getSource() == btnexit) {
           try{
               Stage stage = (Stage) btnexit.getScene().getWindow();
                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                if (g.validateAll()) {
                    login u1;
                    u1 = userDAO.validate(userid.getText(), pass.getText());
                    if (u1 != null) {
                        Stage stage = (Stage) btnlogin.getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setMaximized(true);
                        stage.show();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid user name or password!");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}