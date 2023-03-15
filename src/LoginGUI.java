import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JLabel LoginLabel = new JLabel("LOGIN");
    private JLabel UserLabel = new JLabel("Username:");
    private JLabel PasswordLabel = new JLabel("Password:");
    private JTextField UserField = new JTextField();
    private JPasswordField PasswordField = new JPasswordField();
    private JButton LoginButton = new JButton("OK");
    private JButton CancelButton = new JButton("Cancel");
    private JPanel titlePanel = new JPanel();
    private JPanel mainPanel = new JPanel();

    public LoginGUI()
    {
        setTitle("Вікно входу"); setSize(450,320); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setLayout(new BorderLayout());
        setLocationRelativeTo(null); setResizable(false);

        titlePanel.add(LoginLabel);
        LoginLabel.setFont(new Font("Copperplate", Font.BOLD, 30));
        add(titlePanel, BorderLayout.NORTH);
        mainPanel.setLayout(null);
        mainPanel.add(UserLabel); mainPanel.add(UserField); mainPanel.add(PasswordLabel); mainPanel.add(PasswordField);
        UserLabel.setBounds(100,40,70,20); UserField.setBounds(100,60,240,28); mainPanel.add(UserField);
        PasswordLabel.setBounds(100,100,70,20); PasswordField.setBounds(100,120,240,28);
        LoginButton.setBounds(130,170,90,25); LoginButton.setForeground(Color.WHITE); LoginButton.setBackground(Color.BLACK);
        CancelButton.setBounds(230,170,90,25); CancelButton.setForeground(Color.WHITE); CancelButton.setBackground(Color.BLACK);
        CancelButton.addActionListener(new ButtonCancelEventListener()); mainPanel.add(CancelButton);
        LoginButton.addActionListener(new ButtonOKEventListener()); mainPanel.add(LoginButton);

        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }
    class ButtonOKEventListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(UserField.getText().equals("") || PasswordField.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Invalid login or password!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            else {
                String message = "Successfully!";
                message += "\nYour login: " + UserField.getText() + "\nYour password: " + PasswordField.getText();
                JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
                UserField.setText(null); PasswordField.setText(null);
            }
        }
    }
    class ButtonCancelEventListener implements  ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            UserField.setText(null);
            PasswordField.setText(null);
            JOptionPane.showMessageDialog(null, "Cleared", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
