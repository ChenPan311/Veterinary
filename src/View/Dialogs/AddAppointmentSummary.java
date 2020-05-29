package View.Dialogs;

import Model.Medicine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class AddAppointmentSummary extends JPanel {
    private JButton addBtn, deleteBtn, updateBtn;
    private JLabel treatmentSummary_tv, recommendations_tv, medicines_tv, quantity_tv;
    private JTextArea treatmentSummary_tf, recommendations_tf;
    private JTextField quantity_tf;
    private JComboBox<String> medicines_cb;

    public AddAppointmentSummary() {
        create();
        setBackground(Color.ORANGE);
        this.setVisible(true);
    }

    public void create() {
        medicines_cb = new JComboBox<>();

        treatmentSummary_tv = new JLabel("Treatment Summary: ");
        recommendations_tv = new JLabel("Recommendations: ");
        medicines_tv = new JLabel("Medicines: ");
        quantity_tv = new JLabel("Quantity : ");

        treatmentSummary_tf = new JTextArea(3, 20);
        recommendations_tf = new JTextArea(3, 20);
        quantity_tf = new JTextField(20);

        addBtn = new JButton("Add");
        deleteBtn = new JButton("Delete");


        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(treatmentSummary_tv, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(treatmentSummary_tf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(recommendations_tv, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(recommendations_tf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(medicines_tv, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(medicines_cb, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(quantity_tv, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(quantity_tf, gbc);

        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridy = 5;
        add(addBtn, gbc);
        gbc.gridy = 6;
        add(deleteBtn, gbc);

        setSize(new Dimension(600,300));



    }

    public void addAppointmentSummaryListener(ActionListener actionListener){
        addBtn.addActionListener(actionListener);
    }

    public void deleteAppointmentSummaryListener(ActionListener actionListener){
        deleteBtn.addActionListener(actionListener);
    }

    public JComboBox<String> getMedicines_cb() {
        return medicines_cb;
    }

    void setTreatmentSummary(String summary){
        treatmentSummary_tf.setText(summary);
    }

    void setRecommendations(String recommendations){
        recommendations_tf.setText(recommendations);
    }

    void setMedicine(String medicine){
        medicines_cb.setSelectedItem(medicine);
    }

    void setQuantity(String quantity){
        quantity_tf.setText(quantity);
    }

    public String getTreatmentSummary(){
        return treatmentSummary_tf.getText();
    }

    public String getRecommendations(){
        return recommendations_tf.getText();
    }

    public String getMedicine(){
        return (String)medicines_cb.getSelectedItem();
    }

    public String getQuantity(){
        return quantity_tf.getText();
    }

    public boolean validateFields(){
        return !(getTreatmentSummary().equals("") ||
                getRecommendations().equals("") ||
                getQuantity().equals(""));
    }

    public JComboBox<String> setMedicines(HashMap<Medicine, Integer> medicinesSet){
        int size = medicinesSet.size();
        String[] medicinesOptions = new String[size];
        int i = 0;

        for (Medicine medicine : medicinesSet.keySet()) {
            medicinesOptions[i++] = medicine.getName();
        }

        return new JComboBox<>(medicinesOptions);
    }

}
