package View.Panels;

import javax.swing.*;
import java.awt.*;

public class OtherPanel extends JPanel {
    private JLabel petId_tv, name_tv, dateOfBirth_tv, color_tv, gender_tv, weight_tv, typeOfPet_tv, info_tv;
    private JTextField petId_tf, name_tf, dateOfBirth_tf, color_tf, weight_tf, typeOfPet_tf, info_tf;
    private JPanel genderPanel;
    private ButtonGroup gender_bg;
    private JRadioButton male, female;

    public OtherPanel() {
        petId_tv = new JLabel("Pet Id:");
        name_tv = new JLabel("Name:");
        dateOfBirth_tv = new JLabel("Date of birth:");
        color_tv = new JLabel("Color:");
        gender_tv = new JLabel("Gender:");
        weight_tv = new JLabel("Weight:");
        typeOfPet_tv = new JLabel("Type of pet:");
        info_tv = new JLabel("More info:");

        petId_tf = new JTextField(20);
        name_tf = new JTextField(20);
        dateOfBirth_tf = new JTextField(20);
        color_tf = new JTextField(20);
        weight_tf = new JTextField(20);
        typeOfPet_tf = new JTextField(20);
        info_tf = new JTextField(20);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        gender_bg = new ButtonGroup();
        gender_bg.add(male);
        gender_bg.add(female);

        genderPanel = new JPanel();
        genderPanel.add(male);
        genderPanel.add(female);


        setBackground(Color.ORANGE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.ipady = 3;
        gbc.ipadx = 3;

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(petId_tv, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(petId_tf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(name_tv, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(name_tf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(dateOfBirth_tv, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(dateOfBirth_tf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(color_tv, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(color_tf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(gender_tv, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        add(genderPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(weight_tv, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        add(weight_tf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        add(typeOfPet_tv, gbc);
        gbc.gridx = 1;
        add(typeOfPet_tf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        add(info_tv, gbc);
        gbc.gridx = 1;
        add(info_tf, gbc);
    }

    public JTextField getPetId_tf() {
        return petId_tf;
    }

    public void setPetId_tf(JTextField petId_tf) {
        this.petId_tf = petId_tf;
    }

    public JTextField getName_tf() {
        return name_tf;
    }

    public void setName_tf(JTextField name_tf) {
        this.name_tf = name_tf;
    }

    public JTextField getDateOfBirth_tf() {
        return dateOfBirth_tf;
    }

    public void setDateOfBirth_tf(JTextField dateOfBirth_tf) {
        this.dateOfBirth_tf = dateOfBirth_tf;
    }

    public JTextField getColor_tf() {
        return color_tf;
    }

    public void setColor_tf(JTextField color_tf) {
        this.color_tf = color_tf;
    }

    public JTextField getWeight_tf() {
        return weight_tf;
    }

    public void setWeight_tf(JTextField weight_tf) {
        this.weight_tf = weight_tf;
    }

    public JTextField getTypeOfPet_tf() {
        return typeOfPet_tf;
    }

    public void setTypeOfPet_tf(JTextField typeOfPet_tf) {
        this.typeOfPet_tf = typeOfPet_tf;
    }

    public JTextField getInfo_tf() {
        return info_tf;
    }

    public void setInfo_tf(JTextField info_tf) {
        this.info_tf = info_tf;
    }

    public JPanel getGenderPanel() {
        return genderPanel;
    }

    public ButtonGroup getGender_bg() {
        return gender_bg;
    }

    public void setGenderPanel(JPanel genderPanel) {
        this.genderPanel = genderPanel;
    }

    public JRadioButton getMale() {
        return male;
    }

    public void setMale(JRadioButton male) {
        this.male = male;
    }

    public JRadioButton getFemale() {
        return female;
    }

    public void setFemale(JRadioButton female) {
        this.female = female;
    }

    public Boolean isSelected() {
        return (!male.isSelected() && !female.isSelected());
    }
}
