/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness_club;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnexit;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void he(ActionEvent event) {
        
        if (event.getSource() == btnAdd) {
            try {
                Stage stage = (Stage) btnAdd.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("AddFXML.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == btnSearch)  {
            try {
                Stage stage = (Stage) btnSearch.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("SearchFXML.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(event.getSource() == btnDelete){
            try {
                Stage stage = (Stage) btnDelete.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("SearchFXML.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                Stage stage = (Stage) btnexit.getScene().getWindow();
                stage.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }
    }

