package View.Dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginDialog extends JFrame {
    private JTextField username_tf;
    private JPasswordField password_pf;
    private JButton signInBtn;
    private JRadioButton customer_rb, vet_rb;
    private ButtonGroup identity;
    private JPanel identityPanel;



    public LoginDialog(String title) {
        super(title);
        username_tf = new JTextField(20);
        password_pf = new JPasswordField(20);
        signInBtn = new JButton("Login");
        customer_rb = new JRadioButton("Customer");
        vet_rb = new JRadioButton("Vet");
        identity = new ButtonGroup();
        identityPanel = new JPanel();

        identity.add(customer_rb);
        identity.add(vet_rb);
        identityPanel.add(customer_rb);
        identityPanel.add(vet_rb);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(6, 3, 6, 3);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Username: "), gbc);
        gbc.gridx = 1;
        add(username_tf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Password: "), gbc);
        gbc.gridx = 1;
        add(password_pf, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        add(new JLabel("I Am: "), gbc);
        gbc.gridx = 1;
        add(identityPanel, gbc);

        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridy = 3;
        add(signInBtn, gbc);

        setSize(new Dimension(400, 300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JTextField getUsername_tf() {
        return username_tf;
    }

    public JPasswordField getPassword_pf() {
        return password_pf;
    }

    public JButton getSignInBtn() {
        return signInBtn;
    }

    public JRadioButton getCustomer_rb() {
        return customer_rb;
    }

    public JRadioButton getVet_rb() {
        return vet_rb;
    }

    public ButtonGroup getIdentity() {
        return identity;
    }

    public void addSignInListener(ActionListener actionListener) {
        signInBtn.addActionListener(actionListener);
    }

}
