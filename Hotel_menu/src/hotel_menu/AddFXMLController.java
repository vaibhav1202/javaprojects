/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_menu;

import ECUtils.GUIValidator;
import hotel_menu.bean.Menu;
import hotel_menu.dao.MenuDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author computer
 */
public class AddFXMLController implements Initializable {
    GUIValidator v1 = new GUIValidator();
 
    @FXML
    private Button add;
    @FXML
    private Button back;
    @FXML
    private TextField txtFName;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtQuantity;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        v1.addRequiredValidator(txtFName);
        v1.addRequiredValidator(txtPrice);
        v1.addRequiredValidator(txtQuantity);
    }

    @FXML
    private void he(ActionEvent event) {
        if (event.getSource() == back) {
            try {
                Stage stage = (Stage) back.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                if(v1.validateAll()){
                Menu p1 = new Menu();
                p1.setF_name(txtFName.getText());
                p1.setPrice(txtPrice.getText());
                p1.setQuantity(txtQuantity.getText());
                MenuDAO.insert(p1);
                JOptionPane.showMessageDialog(null, "Done!!");
                Stage stage = (Stage) back.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
