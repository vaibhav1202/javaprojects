/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness_club;

import ECUtils.GUIValidator;
import fit_club.bean.fit_club;
import fit_club.dao.fitclubDAO;
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
public class UpdateFXMLController implements Initializable {
    static String id = "";
    GUIValidator v1 = new GUIValidator();
    @FXML
    private Button Update;
    @FXML
    private Button back;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtfees;
    
    public void populateData(){
        fit_club f1 = fitclubDAO.findById(id);
        txtID.setText(f1.getId());
        txtName.setText(f1.getMember_name());
        txtfees.setText(f1.getFees());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        v1.addRequiredValidator(txtID);
        v1.addRequiredValidator(txtName);
        v1.addRequiredValidator(txtfees);
        populateData();
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
                fit_club f1 = new fit_club();
                f1.setId(txtID.getText());
                f1.setMember_name(txtName.getText());
                f1.setFees(txtfees.getText());
                f1.setId(id);
                fitclubDAO.update(f1);
                JOptionPane.showMessageDialog(null, "Done!!");
                Stage stage = (Stage) back.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("SearchFXML.fxml"));
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
