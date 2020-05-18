package View.Panels;

import javax.swing.*;
import java.awt.*;

public class DogPanel extends JPanel {
    private JLabel customerId_tv, petId_tv, name_tv, dateOfBirth_tv, color_tv, gender_tv, weight_tv, breed_tv, size_tv, isCastrated_tv, isGuidence_tv;
    private JTextField customerId_tf, petId_tf, name_tf, dateOfBirth_tf, color_tf, weight_tf, breed_tf, size_tf;
    private ButtonGroup isCastrated_bg, isGuidence_bg, gender_bg;
    private JRadioButton yes_ic, yes_ig, no_ic, no_ig, male, female;
    private JPanel castratedPanel, guidencePanel, genderPanel;

    public DogPanel() {
        customerId_tv = new JLabel("Customer Id:");
        petId_tv = new JLabel("Pet Id:");
        name_tv = new JLabel("Name:");
        dateOfBirth_tv = new JLabel("Date of birth:");
        color_tv = new JLabel("Color:");
        gender_tv = new JLabel("Gender:");
        weight_tv = new JLabel("Weight:");
        breed_tv = new JLabel("Breed:");
        size_tv = new JLabel("Size:");
        isCastrated_tv = new JLabel("Is castrated?:");
        isGuidence_tv = new JLabel("Is a guidence dog?:");


        customerId_tf = new JTextField(20);
        petId_tf = new JTextField(20);
        name_tf = new JTextField(20);
        dateOfBirth_tf = new JTextField(20);
        color_tf = new JTextField(20);
        weight_tf = new JTextField(20);
        breed_tf = new JTextField(20);
        size_tf = new JTextField(20);

        yes_ic = new JRadioButton("Yes");
        no_ic = new JRadioButton("No");
        yes_ig = new JRadioButton("Yes");
        no_ig = new JRadioButton("No");
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        isCastrated_bg = new ButtonGroup();
        isGuidence_bg = new ButtonGroup();
        gender_bg = new ButtonGroup();
        isCastrated_bg.add(yes_ic);
        isCastrated_bg.add(no_ic);
        isGuidence_bg.add(yes_ig);
        isGuidence_bg.add(no_ig);
        gender_bg.add(male);
        gender_bg.add(female);

        castratedPanel = new JPanel();
        castratedPanel.add(yes_ic);
        castratedPanel.add(no_ic);

        guidencePanel = new JPanel();
        guidencePanel.add(yes_ig);
        guidencePanel.add(no_ig);

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
        gbc.gridy = 0;
        add(customerId_tv, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(customerId_tf, gbc);

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
        add(breed_tv, gbc);
        gbc.gridx = 1;
        add(breed_tf, gbc);


        gbc.gridx = 0;
        gbc.gridy = 8;
        add(size_tv, gbc);
        gbc.gridx = 1;
        add(size_tf, gbc);


        gbc.gridx = 0;
        gbc.gridy = 9;
        add(isCastrated_tv, gbc);
        gbc.gridx = 1;
        add(castratedPanel, gbc);


        gbc.gridx = 0;
        gbc.gridy = 10;
        add(isGuidence_tv, gbc);
        gbc.gridx = 1;
        add(guidencePanel, gbc);
    }

    public JTextField getCustomerId_tf() {
        return customerId_tf;
    }

    public void setCustomerId_tf(JTextField customerId_tf) {
        this.customerId_tf = customerId_tf;
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

    public JTextField getBreed_tf() {
        return breed_tf;
    }

    public void setBreed_tf(JTextField breed_tf) {
        this.breed_tf = breed_tf;
    }

    public JTextField getSize_tf() {
        return size_tf;
    }

    public void setSize_tf(JTextField size_tf) {
        this.size_tf = size_tf;
    }

    public ButtonGroup getIsCastrated_bg() {
        return isCastrated_bg;
    }

    public void setIsCastrated_bg(ButtonGroup isCastrated_bg) {
        this.isCastrated_bg = isCastrated_bg;
    }

    public ButtonGroup getIsGuidence_bg() {
        return isGuidence_bg;
    }

    public void setIsGuidence_bg(ButtonGroup isGuidence_bg) {
        this.isGuidence_bg = isGuidence_bg;
    }

    public ButtonGroup getGender_bg() {
        return gender_bg;
    }

    public void setGender_bg(ButtonGroup gender_bg) {
        this.gender_bg = gender_bg;
    }

    public JPanel getCastratedPanel() {
        return castratedPanel;
    }

    public void setCastratedPanel(JPanel castratedPanel) {
        this.castratedPanel = castratedPanel;
    }

    public JPanel getGuidencePanel() {
        return guidencePanel;
    }

    public void setGuidencePanel(JPanel guidencePanel) {
        this.guidencePanel = guidencePanel;
    }


    public JPanel getGenderPanel() {
        return genderPanel;
    }

    public void setGenderPanel(JPanel genderPanel) {
        this.genderPanel = genderPanel;
    }

    public JRadioButton getYes_ic() {
        return yes_ic;
    }

    public JRadioButton getYes_ig() {
        return yes_ig;
    }

    public JRadioButton getNo_ic() {
        return no_ic;
    }

    public JRadioButton getNo_ig() {
        return no_ig;
    }

    public JRadioButton getMale() {
        return male;
    }

    public JRadioButton getFemale() {
        return female;
    }

    public Boolean isSelected() {
        return (!yes_ic.isSelected() && !no_ic.isSelected()) ||
                (!yes_ig.isSelected() && !no_ig.isSelected()) ||
                (!male.isSelected() && !female.isSelected());
    }
}
