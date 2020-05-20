package View;

import Model.Customer;
import Model.TablesModels.PersonTableModel;
import View.Panels.TablePanel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.MouseListener;

public class PersonsView extends JPanel {
    private TablePanel tablePanel;
    private AbstractTableModel tableModel;
    private RegisterCustomerView view;

    public PersonsView() {
        tableModel = new PersonTableModel();
        view = new RegisterCustomerView();
        tablePanel=new TablePanel(tableModel);

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

    public AbstractTableModel getTableModel() {
        return tableModel;
    }

    public RegisterCustomerView getView() {
        return view;
    }

    public void addSelectedRowListener(MouseListener mouseListener){
        tablePanel.getTable().addMouseListener(mouseListener);
    }
}
