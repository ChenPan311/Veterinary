package View;

import Model.TablesModels.AppointmentTableModel;
import View.Panels.TablePanel;
import com.github.lgooddatepicker.components.DateTimePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CustomerMainView extends JFrame {
    private JLabel name_tv, phoneNumber_tv, email_tv, address_tv, id_tv;
    private JTextField name_tf, phoneNumber_tf, email_tf, address_tf, id_tf;
    private JButton updateCustomerBtn;
    private JPanel menuCustomer, appointmentsView;

    //Appointments View//
    private JLabel petId_tv, vetId_tv, dateAndTime_tv, treatment_tv, treatmentDescription_tv;
    private JTextField petId_tf, vetId_tf, treatment_tf, treatmentDescription_tf;
    private DateTimePicker dateTimePicker;
    private JButton addBtn, deleteBtn;
    private TablePanel tablePanel;
    private JPanel appointmentDetails;

    public CustomerMainView(String title) {
        super(title);
        menuCustomer = new JPanel();

        name_tv = new JLabel("Name:");
        name_tv.setForeground(Color.WHITE);
        phoneNumber_tv = new JLabel("Phone Number:");
        phoneNumber_tv.setForeground(Color.WHITE);
        email_tv = new JLabel("Email:");
        email_tv.setForeground(Color.WHITE);
        address_tv = new JLabel("Address:");
        address_tv.setForeground(Color.WHITE);
        id_tv = new JLabel("Id:");
        id_tv.setForeground(Color.WHITE);

        name_tf = new JTextField(20);
        phoneNumber_tf = new JTextField(10);
        email_tf = new JTextField();
        address_tf = new JTextField();
        id_tf = new JTextField(9);

        updateCustomerBtn = new JButton("Update");

        menuCustomer.setBackground(Color.DARK_GRAY);
        menuCustomer.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.ipady = 3;
        gbc.ipadx = 3;

        gbc.gridx = 0;
        gbc.gridy = 0;
        menuCustomer.add(id_tv, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        menuCustomer.add(id_tf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        menuCustomer.add(name_tv, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        menuCustomer.add(name_tf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        menuCustomer.add(phoneNumber_tv, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        menuCustomer.add(phoneNumber_tf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        menuCustomer.add(address_tv, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        menuCustomer.add(address_tf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        menuCustomer.add(email_tv, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        menuCustomer.add(email_tf, gbc);

        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridy = 5;
        menuCustomer.add(updateCustomerBtn, gbc);


        //////////////////////////

        appointmentsView = new JPanel();
        appointmentsView.setBackground(Color.ORANGE);
        appointmentsView.setLayout(new GridBagLayout());

        tablePanel = new TablePanel(new AppointmentTableModel());

        GridBagConstraints gbcB = new GridBagConstraints();
        gbcB.ipady = 120;
        gbcB.ipadx = 950;
        gbcB.weightx = 8;
        gbcB.weighty = 5;
        gbcB.gridx = 0;
        gbcB.gridy = 0;
        appointmentsView.add(tablePanel, gbcB);


        petId_tv = new JLabel("Pet Id: ");
        vetId_tv = new JLabel("Vet Id: ");
        dateAndTime_tv = new JLabel("Date And Time: ");
        treatment_tv = new JLabel("Treatment: ");
        treatmentDescription_tv = new JLabel("Treatment Description: ");

        petId_tf = new JTextField();
        vetId_tf = new JTextField();
        treatment_tf = new JTextField();
        treatmentDescription_tf = new JTextField();

        dateTimePicker = new DateTimePicker();

        addBtn = new JButton("Add");
        deleteBtn = new JButton("Delete");

        appointmentDetails = new JPanel();
        appointmentDetails.setLayout(new GridBagLayout());
        appointmentDetails.setBackground(Color.ORANGE);

        GridBagConstraints gbcA = new GridBagConstraints();
        gbcA.fill = GridBagConstraints.HORIZONTAL;
        gbcA.insets = new Insets(3, 3, 3, 3);
        gbcA.ipady = 3;
        gbcA.ipadx = 3;


        gbcA.gridx = 0;
        gbcA.gridy = 1;
        appointmentDetails.add(petId_tv, gbcA);
        gbcA.gridx = 1;
        appointmentDetails.add(petId_tf, gbcA);

        gbcA.gridx = 0;
        gbcA.gridy = 2;
        appointmentDetails.add(vetId_tv, gbcA);
        gbcA.gridx = 1;
        appointmentDetails.add(vetId_tf, gbcA);

        gbcA.gridx = 0;
        gbcA.gridy = 3;
        appointmentDetails.add(dateAndTime_tv, gbcA);
        gbcA.gridx = 1;
        appointmentDetails.add(dateTimePicker, gbcA);

        gbcA.gridx = 0;
        gbcA.gridy = 4;
        appointmentDetails.add(treatment_tv, gbcA);
        gbcA.gridx = 1;
        appointmentDetails.add(treatment_tf, gbcA);

        gbcA.gridx = 0;
        gbcA.gridy = 5;
        appointmentDetails.add(treatmentDescription_tv, gbcA);
        gbcA.gridx = 1;
        appointmentDetails.add(treatmentDescription_tf, gbcA);


        gbcA.fill = GridBagConstraints.CENTER;
        gbcA.gridy = 6;
        gbcA.gridx = 1;
        appointmentDetails.add(addBtn, gbcA);

        gbcA.gridy = 7;
        appointmentDetails.add(deleteBtn, gbcA);


        gbcB.ipady = 3;
        gbcB.ipadx = 3;
        gbcB.weighty = 1;
        gbcB.weightx = 1;
        gbcB.gridy = 1;

        appointmentsView.add(appointmentDetails, gbcB);

        setLayout(new BorderLayout());
        add(menuCustomer, BorderLayout.LINE_START);
        add(appointmentsView, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }

    public String getName() {
        return name_tf.getText();
    }

    public String getPhoneNumber() {
        return phoneNumber_tf.getText();
    }

    public String getEmail() {
        return email_tf.getText();
    }

    public String getAddress() {
        return address_tf.getText();
    }

    public String getId() {
        return id_tf.getText();
    }

    public JPanel getMenuCustomer() {
        return menuCustomer;
    }

    public JPanel getAppointmentsView() {
        return appointmentsView;
    }


    public String getPetId() {
        return petId_tf.getText();
    }

    public String getVetId() {
        return vetId_tf.getText();
    }

    public String getTreatment() {
        return treatment_tf.getText();
    }

    public String getTreatmentDescription() {
        return treatmentDescription_tf.getText();
    }

    public String getDatePicker() {
        return dateTimePicker.getDatePicker().getText();
    }

    public String getTimePicker() {
        return dateTimePicker.getTimePicker().getText();
    }

    public void setName(String name) {
        this.name_tf.setText(name);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber_tf.setText(phoneNumber);
    }

    public void setEmail(String email) {
        this.email_tf.setText(email);
    }

    public void setAddress(String address) {
        this.address_tf.setText(address);
    }

    public void setId(String id) {
        this.id_tf.setText(id);
    }

    public void setPetId(String id) {
        this.petId_tf.setText(id);
    }

    public void setVetId(String id) {
        this.vetId_tf.setText(id);
    }

    public void setTreatment(String treatment) {
        this.treatment_tf.setText(treatment);
    }

    public void setTreatmentDescription(String treatmentDescription) {
        this.treatmentDescription_tf.setText(treatmentDescription);
    }

    public void setDatePicker(String date) {
        dateTimePicker.getDatePicker().setText(date);
    }

    public void setTimePicker(String time) {
        dateTimePicker.getTimePicker().setText(time);
    }



    public void addAppointmentListener(ActionListener actionListener){
        addBtn.addActionListener(actionListener);
    }

    public void deleteAppointmentListener(ActionListener actionListener){
        deleteBtn.addActionListener(actionListener);
    }

    public void updateCustomerData(ActionListener actionListener){
        updateCustomerBtn.addActionListener(actionListener);
    }

    public boolean validateFields(){
        return !(petId_tf.getText().equals("")||
                vetId_tf.getText().equals("")||
                dateTimePicker.getDatePicker().getText().equals("")||
                dateTimePicker.getTimePicker().getText().equals("")||
                treatment_tf.getText().equals("")||
                treatmentDescription_tf.getText().equals(""));
    }
}


