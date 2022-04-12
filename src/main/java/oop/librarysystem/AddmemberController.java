package oop.librarysystem;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Window;
import oop.librarysystem.DataClass.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Class.forName;

public class AddmemberController implements Initializable {

    @FXML
    public TextField Mname;
    @FXML
    public TextField Mid;
    @FXML
    public TextField Mage;
    @FXML
    public TextField Mgender;
    @FXML
    private Label welcome;
    @FXML
    public Button Cancel_B;
    @FXML
    public Button Save_B;
    @FXML
    public TextArea information;
    //private Executor = exec;

    public Connection con;
    public PreparedStatement pst;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //exec = Executor.newCachedThreadPool((runnable)->{
         //   Thread tr = new Thread(runnable);
         //   tr.setDaemon(true);
        //    return tr;
       // });
    }
    @FXML
    private void Savebutton(ActionEvent event) throws SQLException {
        //ArrayList<Member> member = new ArrayList<>();
        Member[] member = new Member[50];

    //cannot apply function

        if(Mname.getText().isEmpty()){
            information.appendText("Field please input Name !!!");
        }
        if(Mid.getText().isEmpty()){
            information.appendText("Field please input ID !!!");
        }
        if(Mage.getText().isEmpty()){
            information.appendText("Field please input Age !!!");
        }
        if(Mgender.getText().isEmpty())
        {
            information.appendText("ERROR!! please input Gender !!");
        }


        String empname = Mname.getText();
        String empid = Mid.getText();
        String  empage = Mage.getText();
        String empgender = Mgender.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","");
            pst = con.prepareStatement("insert into member(Name, ID, Age, Gender)values(?,?,?,?)");

            pst.setString(1,empname);
            pst.setString(3,empid);
            pst.setString(2,empage);
            pst.setString(4,empgender);

            int status = pst.executeUpdate();
            if(status==1){
                if(((Mgender.getText().equals("F")|| Mgender.getText().equals("f")||Mgender.getText().equals("M")||Mgender.getText().equals("m")))){
                    //information.appendText(member.toString() +"\n");
                    JOptionPane.showMessageDialog(null,"Record add");
                    Mname.setText("");
                    Mid.setText("");
                    Mage.setText("");
                    Mgender.setText("");
                    Mname.requestFocus();
                }
                else {
                    information.appendText("Wrong input please input gender as( m or M and f or F)");
                }

            }else {
                JOptionPane.showMessageDialog(null,"Record Filed");

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void Cancelbutton(ActionEvent event){
        Mname.setText("");
        Mage.setText(null);
        Mid.setText(null);
        Mgender.setText(null);
    }


    private static class JOptionPane {

        public static void showMessageDialog(Object o, String record_add) {

        }
    }
}

