import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Welcomepage implements ActionListener {
    JFrame welcome = new JFrame();
    JLabel welcomeLabel = new JLabel();
    JButton delete = new JButton();
    JButton logout = new JButton();
    String name3;

    public Welcomepage(String name2) {
        name3 = name2;
        welcome.setLayout(null);
        welcome.setVisible(true);
        welcome.setSize(420, 420);
        welcome.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        welcome.setTitle("Welcome Page");

        welcomeLabel.setText("Hi " + name2 + "! ");
        welcomeLabel.setForeground(Color.BLUE);
        welcomeLabel.setFont(new Font("Cosmic Sans", Font.BOLD, 20));
        welcome.add(welcomeLabel);
        welcomeLabel.setBounds(170, 25, 200, 100);

        delete.setText("DELETE ACCOUNT");
        delete.setBounds(80, 300, 150, 20);
        delete.addActionListener(this);
        delete.setFocusable(false);
        delete.setForeground(Color.RED);
        welcome.add(delete);

    }

    public void deleteAccount() {
        Properties properties = new Properties();


        FileOutputStream  fos;

        try {
            fos=new FileOutputStream(IdandPassword.filepath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        properties.remove(name3);

        try {
            properties.store(fos,"Account Deleted");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        welcome.dispose();
        JOptionPane.showMessageDialog(null,"Your account has been deleted.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == delete) {
            deleteAccount();
        }

    }
}
