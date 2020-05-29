package View;

import Model.Medicine;
import Model.TablesModels.AppointmentTableModel;
import Model.TablesModels.PersonTableModel;
import View.Dialogs.AddAppointmentSummary;
import View.Panels.TablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class AppointmentsView extends JPanel{
    private TablePanel tablePanel;
    private AddAppointmentView view;



    public AppointmentsView() {
        view = new AddAppointmentView();
        tablePanel=new TablePanel(new AppointmentTableModel());


        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3,3,3,3);

        gbc.ipady=120;
        gbc.ipadx=3;
        gbc.weightx=8;
        gbc.weighty=5;
        gbc.gridx=0;
        gbc.gridy=0;
        add(tablePanel,gbc);


        gbc.ipady=3;
        gbc.weighty=1;
        gbc.gridy=1;
        add(view,gbc);






        setBackground(Color.ORANGE);
    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }

    public AddAppointmentView getView() {
        return view;
    }

    public void addSelectedRowListener(MouseListener mouseListener){
        tablePanel.getTable().addMouseListener(mouseListener);
    }

    public void addAppointmentListener(ActionListener actionListener){
        view.addAppointmentListener(actionListener);
    }

    public void deleteAppointmentListener(ActionListener actionListener){
        view.deleteAppointmentListener(actionListener);
    }

    public void updateAppointmentListener(ActionListener actionListener){
        view.updateAppointmentListener(actionListener);
    }

    public void addAppointmentSummaryListener(ActionListener actionListener){
        view.addAppointmentSummaryListener(actionListener);
    }

    public void deleteAppointmentSummaryListener(ActionListener actionListener){
        view.deleteAppointmentSummaryListener(actionListener);
    }


    public String getCustomerId(){
        return view.getCustomerId_tf().getText();
    }

    public String getPetId(){
        return view.getPetId_tf().getText();
    }

    public String getVetId(){
        return view.getVetId_tf().getText();
    }

    public String getDateFromDatePicker(){return view.getDateTimePicker().getDatePicker().getText();}

    public String getTimeFromDatePicker(){
        return view.getDateTimePicker().getTimePicker().getText();
    }

    public String getTreatment(){
        return view.getTreatment_tf().getText();
    }

    public String getTreatmentDescription(){
        return view.getTreatmentDescription_tf().getText();
    }


    public void setCustomerId(String id){
         view.getCustomerId_tf().setText(id);
    }

    public void setPetId(String id){
        view.getPetId_tf().setText(id);
    }

    public void setVetId(String id){
        view.getVetId_tf().setText(id);
    }

    public void setDateFromDatePicker(String date){view.getDateTimePicker().getDatePicker().setText(date);}

    public void setTimeFromDatePicker(String time){
        view.getDateTimePicker().getTimePicker().setText(time);
    }

    public void setTreatment(String treatment){
        view.getTreatment_tf().setText(treatment);
    }

    public void setTreatmentDescription(String treatmentDescription){
        view.getTreatmentDescription_tf().setText(treatmentDescription);
    }

    public void setTreatmentSummary(String summary){
        view.getTreatmentSummary_tf().setText(summary);
    }

    public void setRecommendations(String recommendations){
        view.getRecommendations_tf().setText(recommendations);
    }

    public void setMedicine(String medicine){
        view.getMedicines_cb().setSelectedItem(medicine);
    }

    public void setQuantity(String quantity){
        view.getQuantity_tf().setText(quantity);
    }

    public String getTreatmentSummary(){
        return view.getTreatmentSummary_tf().getText();
    }

    public String getRecommendations(){
        return view.getRecommendations_tf().getText();
    }

    public String getMedicine(){
        return (String)view.getMedicines_cb().getSelectedItem();
    }

    public String getQuantity(){
        return view.getQuantity_tf().getText();
    }





}