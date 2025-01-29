import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class LoginPage implements ActionListener {


    JFrame frame = new JFrame();
    JButton confirm = new JButton();
    JButton reset = new JButton();
    JTextField namefield = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel namelabel = new JLabel();
    JLabel passlabel = new JLabel();
    JLabel msglabel = new JLabel();
    JButton createNewAccount = new JButton();
    String name;

    HashMap<String, String> loginInfo = new HashMap<String, String>();


    LoginPage(HashMap<String, String> loginInfoOriginal) {

        loginInfo = loginInfoOriginal;


        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(420, 420);
        frame.setTitle("Login Page");

        namelabel.setText("Name: ");
        namelabel.setBounds(100, 50, 100, 100);
        frame.add(namelabel);

        passlabel.setText("PassWord: ");
        passlabel.setBounds(100, 85, 100, 100);
        frame.add(passlabel);

        namefield.setSize(100, 100);
        namefield.setBounds(150, 87, 120, 25);
        frame.add(namefield);

        namefield.setBounds(170, 87, 120, 25);
        frame.add(namefield);

        passwordField.setBounds(170, 127, 120, 25);
        frame.add(passwordField);

        confirm.setText("Confirm");
        confirm.setBounds(100, 180, 85, 20);
        confirm.setFocusable(false);
        confirm.addActionListener(this);
        frame.add(confirm);

        reset.setText("Reset");
        reset.setBounds(210, 180, 85, 20);
        reset.setFocusable(false);
        reset.addActionListener(this);
        frame.add(reset);

        msglabel.setBounds(150, 235, 200, 100);
        msglabel.setText("");
        msglabel.setFont(new Font("Cosmic Sans", Font.ITALIC, 20));

        frame.add(msglabel);
        createNewAccount.setText("Create New Account");
        createNewAccount.setBounds(100, 220, 200, 20);
        createNewAccount.setFocusable(false);
        createNewAccount.addActionListener(this);
        frame.add(createNewAccount);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == reset) {
            namefield.setText("");
            passwordField.setText("");
            msglabel.setText("");

        }

        if (e.getSource() == confirm) {


             name = namefield.getText();
            String pass = passwordField.getText();

            if (loginInfo.containsKey(name)) {

                if (loginInfo.get(name).equals(pass)) {
                    msglabel.setForeground(Color.GREEN);
                    msglabel.setText("Login Sucessful");
                    frame.dispose();
                    Welcomepage wp = new Welcomepage(name);
                } else {
                    msglabel.setForeground(Color.RED);
                    msglabel.setText("Invalid Credentials");
                }
            } else {
                msglabel.setForeground(Color.RED);
                msglabel.setText("Username not found");
            }

        }
        if (e.getSource() == createNewAccount) {
            frame.dispose();

            NewUser x = new NewUser();
        }
    }

}
