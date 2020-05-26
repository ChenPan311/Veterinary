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


    public Boolean isSelected() {
        return (!male.isSelected() && !female.isSelected());
    }

    public String getId(){return petId_tf.getText();}
    public String getName(){return name_tf.getText();}
    public String getDateOfBirth(){return dateOfBirth_tf.getText();}
    public String getColor(){return color_tf.getText();}
    public String getWeight(){return weight_tf.getText();}
    public boolean getMale(){return male.isSelected();}
    public String getTypeOfPet(){return typeOfPet_tf.getText();}
    public String getInfo(){return info_tf.getText();}

    public void setId(String id){petId_tf.setText(id);}
    public void setName(String name){name_tf.setText(name);}
    public void setDateOfBirth(String date){dateOfBirth_tf.setText(date);}
    public void setColor(String color){color_tf.setText(color);}
    public void setWeight(String weight){weight_tf.setText(weight);}
    public void setMale(boolean gender){male.setSelected(gender);}
    public void setFemale(boolean gender){female.setSelected(gender);}
    public void setTypeOfPet(String type){typeOfPet_tf.setText(type);}
    public void setInfo(String info){info_tf.setText(info);}
}
