package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterCustomerView extends JPanel {
    private JLabel name_tv,phoneNumber_tv,email_tv,address_tv,id_tv;
    private JTextField name_tf,phoneNumber_tf,email_tf,address_tf,id_tf;
    private JButton addBtn,showBtn;

    public RegisterCustomerView() {
        name_tv=new JLabel("Name:");
        phoneNumber_tv=new JLabel("Phone Number:");
        email_tv=new JLabel("Email:");
        address_tv=new JLabel("Address:");
        id_tv=new JLabel("Id:");

        name_tf=new JTextField(20);
        phoneNumber_tf=new JTextField(10);
        email_tf=new JTextField();
        address_tf=new JTextField();
        id_tf=new JTextField(9);

        addBtn=new JButton("Add");
        showBtn=new JButton("Show");

        setBackground(Color.ORANGE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3,3,3,3);
        gbc.ipady=3;
        gbc.ipadx=3;

        gbc.gridx=0;
        gbc.gridy=0;
        add(id_tv,gbc);

        gbc.gridx=1;
        gbc.gridy=0;
        add(id_tf,gbc);

        gbc.gridx=0;
        gbc.gridy=1;
        add(name_tv,gbc);

        gbc.gridx=1;
        gbc.gridy=1;
        add(name_tf,gbc);

        gbc.gridx=0;
        gbc.gridy=2;
        add(phoneNumber_tv,gbc);

        gbc.gridx=1;
        gbc.gridy=2;
        add(phoneNumber_tf,gbc);

        gbc.gridx=0;
        gbc.gridy=3;
        add(address_tv,gbc);

        gbc.gridx=1;
        gbc.gridy=3;
        add(address_tf,gbc);

        gbc.gridx=0;
        gbc.gridy=4;
        add(email_tv,gbc);

        gbc.gridx=1;
        gbc.gridy=4;
        add(email_tf,gbc);

        gbc.fill=GridBagConstraints.CENTER;
        gbc.gridy=5;
        add(addBtn,gbc);

        gbc.fill=GridBagConstraints.CENTER;
        gbc.gridy=6;
        add(showBtn,gbc);

    }

    public JTextField getName_tf() {
        return name_tf;
    }

    public void setName_tf(JTextField name_tf) {
        this.name_tf = name_tf;
    }

    public JTextField getPhoneNumber_tf() {
        return phoneNumber_tf;
    }

    public void setPhoneNumber_tf(JTextField phoneNumber_tf) {
        this.phoneNumber_tf = phoneNumber_tf;
    }

    public JTextField getEmail_tf() {
        return email_tf;
    }

    public void setEmail_tf(JTextField email_tf) {
        this.email_tf = email_tf;
    }

    public JTextField getAddress_tf() {
        return address_tf;
    }

    public void setAddress_tf(JTextField address_tf) {
        this.address_tf = address_tf;
    }

    public JTextField getId_tf() {
        return id_tf;
    }

    public void setId_tf(JTextField id_tf) {
        this.id_tf = id_tf;
    }


    public JButton getAddBtn() {
        return addBtn;
    }

    public void setAddBtn(JButton addBtn) {
        this.addBtn = addBtn;
    }

    public JButton getShowBtn() {
        return showBtn;
    }

    public void setShowBtn(JButton showBtn) {
        this.showBtn = showBtn;
    }

    public void addNewCustomerListener(ActionListener actionListener){
        addBtn.addActionListener(actionListener);
    }

    public Boolean validateFields(){
        return !(getAddress_tf().getText().equals("") ||
                getEmail_tf().getText().equals("") ||
                getId_tf().getText().equals("") ||
                getName_tf().getText().equals("") ||
                getPhoneNumber_tf().getText().equals(""));
    }

    public void clearFields(){
        name_tf.setText("");
        id_tf.setText("");
        email_tf.setText("");
        address_tf.setText("");
        phoneNumber_tf.setText("");
    }
}
