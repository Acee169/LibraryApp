package Database;
import java.sql. *;
import java.sql.PreparedStatement;

public class InsertData {
     public void insert(int a, String b, String c, int d, String e) {
        String sql = "INSERT INTO books(Id,Title,Author,Year,Category) VALUES(?,?,?,?,?)";
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/signup", "root", "");
        PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setInt(1,a);
            pst.setString(2,b);
            pst.setString(3,c);
            pst.setInt(4,d);
            pst.setString(5,e);
            pst.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    public void insert2(String a,String b,String c,String d,String e,String f,int g,String h,String i){
        String sql = "INSERT INTO Borrowedbooks(studentname,studentid,gender,department,year,booktitle,bookid,borrowdate,returndate) VALUES(?,?,?,?,?,?,?,?,?)";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:myDbFile.db");
        PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, a);
            pst.setString(2, b);
            pst.setString(3, c);
            pst.setString(4, d);
            pst.setString(5, e);
            pst.setString(6, f);
            pst.setInt(7, g);
            pst.setString(8, h);
            pst.setString(9, i);
            pst.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
