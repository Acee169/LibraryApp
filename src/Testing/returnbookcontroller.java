package Testing;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class returnbookcontroller implements Initializable{
    Connection con;
    private Stage stage;
    private Scene scene;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField authortxt;

    @FXML
    private TextField loandatetxt;

    @FXML
    private Button searchbtn;

    @FXML
    private TextField titletxt;

    @FXML
    private TextField usernametxt;

    @FXML
    private TextField yeartxt;
    @FXML
    private TextField bookid;
    @FXML
    private TextField bookidtxt;
    @FXML
    private TextField categorytxt;


    @FXML
    public void search(ActionEvent event) throws IOException{
        ResultSet rs = null;
        PreparedStatement pst = null;
        ConnectToStudent();
        String id = bookid.getText();
        String sql = "select *from loanlist1 where id= '" + id + "'";
        try{
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                usernametxt.setText(rs.getString(2));
                titletxt.setText(rs.getString(4));
                authortxt.setText(rs.getString(5));
                yeartxt.setText(rs.getString(6));
                loandatetxt.setText(rs.getString(7));
                categorytxt.setText(rs.getString(8));
                bookidtxt.setText(rs.getString(1));
                rs.close();
                pst.close();
            }else {
                JOptionPane.showMessageDialog(null, "The book is not in the database");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {

            }
        }

    }

    public void Return() {
        ResultSet rs = null, rs1, rs2, rs3 = null;
        PreparedStatement pst = null, pst1, pst2, pst3 = null;
        ConnectToStudent();
        String reg = bookid.getText();

        String sql1 = "select *from loanlist1 where id = '" + reg + "'";
        String sql2 = "DELETE FROM loanlist1 where id = '"+reg+"'";
        String sql = "insert into books (Id,Title,Author,Year,Category) value(?,?,?,?,?)";
        try {
            ConnectToStudent();
            pst1 = con.prepareStatement(sql1);
            rs1 = pst1.executeQuery();
            if (rs1.next()) {
                try {
                    pst = con.prepareStatement(sql);
                    {
                        pst.setString(1, bookid.getText());
                        pst.setString(2, titletxt.getText());
                        pst.setString(3, authortxt.getText());
                        pst.setString(4, yeartxt.getText());
                        pst.setString(5, categorytxt.getText());
                        pst.execute();
                        pst.close();
                        JOptionPane.showMessageDialog(null, "Book Returned Successfully");
                        pst2 = con.prepareStatement(sql2);
                        pst2.executeUpdate(sql2);
                        pst2.close();
                        JOptionPane.showMessageDialog(null, "Removed book!");                       
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                        System.out.println("error");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Either the book ID or the Student Registration number is incorrect");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "sasa");
            }
        }

    public void ConnectToStudent(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:/signup","root","");
            System.out.println("sucessfully connected to student database yayyy");
        } catch (ClassNotFoundException ex) {
          System.out.println("hikhik");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    @FXML
    void goback(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Library.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
