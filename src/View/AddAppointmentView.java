package View;

import Model.Medicine;
import View.Panels.TablePanel;
import com.github.lgooddatepicker.components.DateTimePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Locale;

public class AddAppointmentView extends JPanel {
    private JLabel customerId_tv, petId_tv, vetId_tv, dateAndTime_tv, treatment_tv, treatmentDescription_tv;
    private JTextField customerId_tf, petId_tf, vetId_tf, treatment_tf, treatmentDescription_tf;
    private DateTimePicker dateTimePicker;
    private JButton addBtn,deleteBtn,updateBtn;
//summaryView//
    private JButton addSummaryBtn, deleteSummaryBtn;
    private JLabel treatmentSummary_tv, recommendations_tv, medicines_tv, quantity_tv;
    private JTextArea treatmentSummary_tf, recommendations_tf;
    private JTextField quantity_tf;
    private JComboBox<String> medicines_cb;

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
        deleteBtn = new JButton("Delete");
        updateBtn = new JButton("Update");

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

        gbc.gridy = 7;
        add(deleteBtn,gbc);

        gbc.gridy = 8;
        add(updateBtn,gbc);


        //summaryView//

        medicines_cb = new JComboBox<>();

        treatmentSummary_tv = new JLabel("Treatment Summary: ");
        recommendations_tv = new JLabel("Recommendations: ");
        medicines_tv = new JLabel("Medicines: ");
        quantity_tv = new JLabel("Quantity : ");

        treatmentSummary_tf = new JTextArea(3, 20);
        recommendations_tf = new JTextArea(3, 20);
        quantity_tf = new JTextField(20);

        addSummaryBtn = new JButton("Add");
        deleteSummaryBtn = new JButton("Delete");


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 0;
        add(treatmentSummary_tv, gbc);

        gbc.gridheight = 2;
        gbc.gridwidth = 3;
        gbc.gridx = 3;
        gbc.gridy = 0;
        add(new JScrollPane(treatmentSummary_tf), gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        add(recommendations_tv, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        add(new JScrollPane(recommendations_tf), gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        add(medicines_tv, gbc);

        gbc.gridx = 3;
        gbc.gridy = 4;
        add(medicines_cb, gbc);

        gbc.gridx = 2;
        gbc.gridy = 5;
        add(quantity_tv, gbc);

        gbc.gridx = 3;
        gbc.gridy = 5;
        add(quantity_tf, gbc);

        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridy = 6;
        add(addSummaryBtn, gbc);
        gbc.gridy = 7;
        add(deleteSummaryBtn, gbc);

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

    //summary//


    public JTextArea getTreatmentSummary_tf() {
        return treatmentSummary_tf;
    }

    public JTextArea getRecommendations_tf() {
        return recommendations_tf;
    }

    public JTextField getQuantity_tf() {
        return quantity_tf;
    }

    public JComboBox<String> getMedicines_cb() {
        return medicines_cb;
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public JButton getDeleteBtn() {
        return deleteBtn;
    }

    public JButton getUpdateBtn() {
        return updateBtn;
    }

    public JButton getAddSummaryBtn() {
        return addSummaryBtn;
    }

    public JButton getDeleteSummaryBtn() {
        return deleteSummaryBtn;
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

    public boolean validateSummaryFields(){
        return !(treatmentSummary_tf.getText().equals("")||
                recommendations_tf.getText().equals("")||
                quantity_tf.getText().equals(""));
    }


    public void setMedicines(HashMap<Medicine, Integer> medicinesSet){
        int size = medicinesSet.size();
        String[] medicinesOptions = new String[size];
        int i = 0;

        for (Medicine medicine : medicinesSet.keySet()) {
            medicinesOptions[i++] = medicine.getName();
        }

        medicines_cb.setModel(new DefaultComboBoxModel<String>(medicinesOptions));

    }


}
