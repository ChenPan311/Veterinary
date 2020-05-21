package View;

import Model.TablesModels.AppointmentTableModel;
import Model.TablesModels.PersonTableModel;
import View.Panels.TablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class AppointmentsView extends JPanel {
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
        gbc.weightx=4;
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
}
