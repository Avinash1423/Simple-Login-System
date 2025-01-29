import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class NewUser  implements ActionListener {

    JFrame newframe = new JFrame();
    JLabel name = new JLabel();
    JLabel pass = new JLabel();
    JLabel pass2 = new JLabel();
    JTextField namefield = new JTextField();
    JTextField passfield = new JTextField();
    JTextField passfield2 = new JTextField();
    JLabel msglabel = new JLabel();
    JButton reset = new JButton();
    JButton confirm = new JButton();
    String enteredName;
    String enteredPassword;
    String enteredPassword2;

    public NewUser() {

        newframe.setVisible(true);
        newframe.setLayout(null);
        newframe.setSize(420, 420);
        newframe.setTitle("Create New Account");

        name.setText("Enter Your Name:");
        name.setBounds(40, 50, 100, 100);
        newframe.add(name);

        pass.setText("Enter a Pass Word:");
        pass.setBounds(40, 85, 120, 100);
        newframe.add(pass);

        namefield.setSize(100, 100);
        namefield.setBounds(170, 87, 120, 25);
        newframe.add(namefield);

        passfield.setBounds(170, 127, 120, 25);
        newframe.add(passfield);

        pass2.setText("Enter the Pass Word again:");
        pass2.setBounds(40, 125, 160, 100);
        newframe.add(pass2);

        passfield2.setBounds(210, 164, 120, 25);
        newframe.add(passfield2);

        msglabel.setBounds(85, 230, 230, 100);
        msglabel.setText("");
        msglabel.setFont(new Font("Cosmic Sans", Font.ITALIC, 20));
        newframe.add(msglabel);

        reset.setText("Reset");
        reset.setBounds(210, 220, 85, 20);
        reset.setFocusable(false);
        reset.addActionListener(this);
        newframe.add(reset);

        confirm.setText("Confirm");
        confirm.setBounds(100, 220, 85, 20);
        confirm.setFocusable(false);
        confirm.addActionListener(this);
        newframe.add(confirm);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == reset) {
            namefield.setText("");
            passfield.setText("");
            msglabel.setText("");
            passfield2.setText("");
        }

        enteredName = namefield.getText();
        enteredPassword = passfield.getText();
        enteredPassword2 = passfield2.getText();

        if (e.getSource() == confirm) {
            if (enteredPassword != "" && enteredPassword2 != "" && enteredName != "") {

                if(!check(enteredName)) {

                    if (enteredPassword.equals(enteredPassword2)) {

                        IdandPassword.addNewUser(enteredName, enteredPassword);
                        msglabel.setForeground(Color.GREEN);
                        msglabel.setText("Your Account is Created");
                    } else {
                        msglabel.setForeground(Color.RED);
                        msglabel.setText("Passwords do not match");
                    }
                } else
                    msglabel.setText("Name aldready exists");

            }
        }

    }

    public boolean check(String name) {
        Properties properties = new Properties();

        FileInputStream fis;

        try {
            fis = new FileInputStream(IdandPassword.filepath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String key : properties.stringPropertyNames())
            if (name.equals(key)) {
                return true;
                            }
         return false;


    }
}