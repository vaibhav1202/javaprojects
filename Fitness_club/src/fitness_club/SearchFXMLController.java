/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness_club;

import ECUtils.MyUtils;
import fit_club.bean.fit_club;
import fit_club.dao.fitclubDAO;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author computer
 */
public class SearchFXMLController implements Initializable {

    static String sc = "id";
    static String si = "";
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDel;
    @FXML
    private Button btnBack;
    @FXML
    private TableView<?> tblList;
    @FXML
    private TextField txtSi;
    @FXML
    private ComboBox<?> cmbSc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MyUtils.populateColumnNames(cmbSc, "fit_club");
        txtSi.setText(si);
        MyUtils.selectComboBoxValue(cmbSc, sc);
        refreshTbl();
    }

    @FXML
    private void he(ActionEvent event) {
        if (event.getSource() == btnBack) {
            try {
                Stage stage = (Stage) btnBack.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == btnDel) {
            try {
                String id = MyUtils.getSelColValue("id", tblList);
                if (id != null && !"".equals(id)) {
                    int ch = JOptionPane.showConfirmDialog(null, "Are you sure?");
                    if (ch == 0) {
                        fitclubDAO.delete(id);
                        refreshTbl();
                        JOptionPane.showMessageDialog(null, "Deleted.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == btnUpdate) {
            try {
                String id = MyUtils.getSelColValue("id", tblList);
                if (id != null && !"".equals(id)) {
                UpdateFXMLController.id=id;
                Stage stage = (Stage) btnBack.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("UpdateFXML.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();                    
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }        
    }

    @FXML
    private void kr(KeyEvent event) {
        si = txtSi.getText();
        refreshTbl();
    }

    @FXML
    private void cmbCh(ActionEvent event) {
        sc=cmbSc.getValue().toString();
        refreshTbl();
    }

    private void refreshTbl() {
        LinkedList<fit_club> res = fitclubDAO.search(cmbSc.getValue().toString(), txtSi.getText());
        MyUtils.populateTable(tblList, res, fit_club.class);
    }

}
