package View;

import com.github.lgooddatepicker.components.DateTimePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Locale;

public class AddAppointmentView extends JPanel {
    private JLabel customerId_tv, petId_tv, vetId_tv, dateAndTime_tv, treatment_tv, treatmentDescription_tv;
    private JTextField customerId_tf, petId_tf, vetId_tf, treatment_tf, treatmentDescription_tf;
    private DateTimePicker dateTimePicker;
    private JButton addBtn;

    public AddAppointmentView() {
        customerId_tv = new JLabel("Customer Id: ");
        petId_tv = new JLabel("Pet Id: ");
        vetId_tv = new JLabel("Vet Id: ");
        dateAndTime_tv = new JLabel("Date And Time: ");
        treatment_tv = new JLabel("Treatment: ");
        treatmentDescription_tv = new JLabel("Treatment Description: ");

        customerId_tf = new JTextField(20);
        petId_tf = new JTextField();
        vetId_tf = new JTextField();
        treatment_tf = new JTextField();
        treatmentDescription_tf = new JTextField();

        dateTimePicker = new DateTimePicker();

        addBtn = new JButton("Add");

        setBackground(Color.ORANGE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.ipady = 3;
        gbc.ipadx = 3;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(customerId_tv,gbc);
        gbc.gridx=1;
        add(customerId_tf,gbc);

        gbc.gridx=0;
        gbc.gridy=1;
        add(petId_tv,gbc);
        gbc.gridx=1;
        add(petId_tf,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(vetId_tv,gbc);
        gbc.gridx=1;
        add(vetId_tf,gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(dateAndTime_tv,gbc);
        gbc.gridx=1;
        add(dateTimePicker,gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(treatment_tv,gbc);
        gbc.gridx=1;
        add(treatment_tf,gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(treatmentDescription_tv,gbc);
        gbc.gridx=1;
        add(treatmentDescription_tf,gbc);


        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridy = 6;
        gbc.gridx=1;
        add(addBtn,gbc);
    }

    public JTextField getCustomerId_tf() {
        return customerId_tf;
    }

    public JTextField getPetId_tf() {
        return petId_tf;
    }

    public JTextField getVetId_tf() {
        return vetId_tf;
    }

    public JTextField getTreatment_tf() {
        return treatment_tf;
    }

    public JTextField getTreatmentDescription_tf() {
        return treatmentDescription_tf;
    }

    public DateTimePicker getDateTimePicker() {
        return dateTimePicker;
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public boolean validateFields(){
        return !(customerId_tf.getText().equals("")||
                petId_tf.getText().equals("")||
                vetId_tf.getText().equals("")||
                dateTimePicker.getDatePicker().getText().equals("")||
                dateTimePicker.getTimePicker().getText().equals("")||
                treatment_tf.getText().equals("")||
                treatmentDescription_tf.getText().equals(""));
    }

    public void addAppointmentListener(ActionListener actionListener){
        addBtn.addActionListener(actionListener);
    }
}
