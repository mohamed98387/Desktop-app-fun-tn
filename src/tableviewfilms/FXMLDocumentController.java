/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableviewfilms;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohamed
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private TableView<films> Table_films;

    @FXML
    private TableColumn<films, Integer> col_id;

    @FXML
    private TableColumn<films, String> col_title;

    @FXML
    private TableColumn<films, String> col_about;

    @FXML
    private TableColumn<films, String> col_cover;

    @FXML
    private TableColumn<films, String> col_gallery;

    @FXML
    private TableColumn<films, String> col_trailer;

    @FXML
    private TableColumn<films, String> col_date;

    @FXML
    private TableColumn<films, String> col_country;

    @FXML
    private TableColumn<films, String> col_categorie;

    @FXML
    private TableColumn<films, Integer> col_duration;
    
    @FXML
    private TextField txt_id;
    
    @FXML
    private TextField txt_title;

    @FXML
    private TextField txt_about;

    @FXML
    private TextField txt_cover;

    @FXML
    private TextField txt_gallery;

    @FXML
    private TextField txt_trailer;

    @FXML
    private TextField txt_date;

    @FXML
    private TextField txt_country;

    @FXML
    private TextField txt_categorie;

    @FXML
    private TextField txt_duration;
    
    
    
    
    ObservableList<films> listM;
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public void Add_films(){
        conn = mysqlconnect.ConnectDb();
        String sql= "insert into films(title,about,cover,gallery,trailer,date,country,categorie,duration) values (?,?,?,?,?,?,?,?,?)";
        try{
            pst = conn.prepareStatement(sql);
       
             pst.setString(1,txt_title.getText());
              pst.setString(2,txt_about.getText());
               pst.setString(3,txt_cover.getText());
                pst.setString(4,txt_gallery.getText());
                 pst.setString(5,txt_trailer.getText());
                  pst.setString(6,txt_date.getText());
                   pst.setString(7,txt_country.getText());
                    pst.setString(8,txt_categorie.getText());
                     pst.setString(9,txt_duration.getText());
                     pst.execute();
                     JOptionPane.showMessageDialog(null, "film add succes");
                     UpdateTable();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    ////methode select films///
    
    @FXML
    public void getSelected(){
        index = Table_films.getSelectionModel().getSelectedIndex();
        if(index<=-1){
            return ;
            
        }
        
        txt_id.setText(col_id.getCellData(index).toString());
        txt_title.setText(col_title.getCellData(index).toString());
        txt_about.setText(col_about.getCellData(index).toString());
        txt_cover.setText(col_cover.getCellData(index).toString());
        txt_gallery.setText(col_gallery.getCellData(index).toString());
        txt_trailer.setText(col_trailer.getCellData(index).toString());
        txt_date.setText(col_date.getCellData(index).toString());
        txt_country.setText(col_country.getCellData(index).toString());
        txt_categorie.setText(col_categorie.getCellData(index).toString());
        txt_duration.setText(col_duration.getCellData(index).toString());
        
        
    }
    public void Edit(){
        
        try{
           conn= mysqlconnect.ConnectDb();
           String value1 = txt_id.getText();
           String value2 = txt_title.getText();
           String value3 = txt_about.getText();
              String value4 = txt_cover.getText();
                String value5 = txt_gallery.getText();
                  String value6 = txt_trailer.getText();
                    String value7 = txt_date.getText();
                      String value8 = txt_country.getText();
                        String value9 = txt_categorie.getText();
                          String value10 = txt_duration.getText();
 String sql="update films set id='"+value1+"' , title='"+value2+"' ,about ='"+value3+"' ,cover ='"+value4+"' ,gallery='"+value5+"' ,trailer='"+value6+"' ,date='"+value7+"' ,country='"+value8+"' ,categorie='"+value9+"' ,duration='"+value10+"' where id='"+value1+"' ";
              pst=conn.prepareStatement(sql);
              pst.execute();
              JOptionPane.showMessageDialog(null, "Update");
              UpdateTable();
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
        } }
    
     public void Delete(){
    conn = mysqlconnect.ConnectDb();
    String sql = "delete from films where id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_id.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");
            UpdateTable();
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    
    
    public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<films,Integer>("id"));
        col_title.setCellValueFactory(new PropertyValueFactory<films,String>("title"));
        col_about.setCellValueFactory(new PropertyValueFactory<films,String>("about"));
        col_cover.setCellValueFactory(new PropertyValueFactory<films,String>("cover"));
        col_gallery.setCellValueFactory(new PropertyValueFactory<films,String>("gallery"));
         col_trailer.setCellValueFactory(new PropertyValueFactory<films,String>("trailer"));
          col_date.setCellValueFactory(new PropertyValueFactory<films,String>("date"));
          col_country.setCellValueFactory(new PropertyValueFactory<films,String>("country"));
           col_categorie.setCellValueFactory(new PropertyValueFactory<films,String>("categorie"));
          col_duration.setCellValueFactory(new PropertyValueFactory<films,Integer>("duration"));
          
          listM= mysqlconnect.getDatafilms();
          Table_films.setItems(listM);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         UpdateTable();
         
    }    
    
}
