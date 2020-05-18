package View.Panels;

import javax.swing.*;
import java.awt.*;

public class CatPanel extends JPanel {
    private JLabel customerId_tv, petId_tv, name_tv, dateOfBirth_tv, color_tv, gender_tv, weight_tv, breed_tv, isCastrated_tv;
    private JTextField customerId_tf, petId_tf, name_tf, dateOfBirth_tf, color_tf, weight_tf, breed_tf;
    private ButtonGroup isCastrated_bg,gender_bg;
    private JRadioButton yes_ic, no_ic,male,female;
    private JPanel  castratedPanel,genderPanel;

    public CatPanel() {
        customerId_tv = new JLabel("Customer Id:");
        petId_tv = new JLabel("Pet Id:");
        name_tv = new JLabel("Name:");
        dateOfBirth_tv = new JLabel("Date of birth:");
        color_tv = new JLabel("Color:");
        gender_tv = new JLabel("Gender:");
        weight_tv = new JLabel("Weight:");
        breed_tv = new JLabel("Breed:");
        isCastrated_tv = new JLabel("Is castrated?:");


        customerId_tf = new JTextField(20);
        petId_tf = new JTextField(20);
        name_tf = new JTextField(20);
        dateOfBirth_tf = new JTextField(20);
        color_tf = new JTextField(20);
        weight_tf = new JTextField(20);
        breed_tf = new JTextField(20);

        yes_ic = new JRadioButton("Yes");
        no_ic = new JRadioButton("No");
        male=new JRadioButton("Male");
        female=new JRadioButton("Female");
        isCastrated_bg = new ButtonGroup();
        isCastrated_bg.add(yes_ic);
        isCastrated_bg.add(no_ic);
        gender_bg=new ButtonGroup();
        gender_bg.add(male);
        gender_bg.add(female);

        castratedPanel = new JPanel();
        castratedPanel.add(yes_ic);
        castratedPanel.add(no_ic);
        genderPanel=new JPanel();
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
        add(isCastrated_tv, gbc);
        gbc.gridx = 1;
        add(castratedPanel, gbc);

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

    public ButtonGroup getIsCastrated_bg() {
        return isCastrated_bg;
    }

    public ButtonGroup getGender_bg() {
        return gender_bg;
    }

    public JRadioButton getYes_ic() {
        return yes_ic;
    }

    public void setYes_ic(JRadioButton yes_ic) {
        this.yes_ic = yes_ic;
    }

    public JRadioButton getNo_ic() {
        return no_ic;
    }

    public void setNo_ic(JRadioButton no_ic) {
        this.no_ic = no_ic;
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

    public JPanel getGenderPanel() {
        return genderPanel;
    }

    public void setGenderPanel(JPanel genderPanel) {
        this.genderPanel = genderPanel;
    }

    public void setIsCastrated_bg(ButtonGroup isCastrated_bg) {
        this.isCastrated_bg = isCastrated_bg;
    }

    public JPanel getCastratedPanel() {
        return castratedPanel;
    }

    public void setCastratedPanel(JPanel castratedPanel) {
        this.castratedPanel = castratedPanel;
    }

    public Boolean isSelected(){
        return (!yes_ic.isSelected() && !no_ic.isSelected()) || (!male.isSelected() && !female.isSelected());
    }
}
