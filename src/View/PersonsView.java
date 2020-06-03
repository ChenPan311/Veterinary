package View;

import Model.Customer;
import Model.TablesModels.PersonTableModel;
import View.Panels.TablePanel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class PersonsView extends JPanel implements Observer {
    private TablePanel tablePanel;
    private RegisterCustomerView view;

    public PersonsView() {
        view = new RegisterCustomerView();
        tablePanel=new TablePanel(new PersonTableModel());

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

    public RegisterCustomerView getView() {
        return view;
    }

    public void addSelectedRowListener(MouseListener mouseListener){
        tablePanel.getTable().addMouseListener(mouseListener);
    }

    public String getId(){return view.getId_tf().getText();}
    public String getName(){return view.getName_tf().getText();}
    public String getAddress(){return view.getAddress_tf().getText();}
    public String getPhoneNumber(){return view.getPhoneNumber_tf().getText();}
    public String getEmail(){return view.getEmail_tf().getText();}

    public void setId(String id){ view.getId_tf().setText(id);}
    public void setName(String  name){view.getName_tf().setText(name);}
    public void setAddress(String address){view.getAddress_tf().setText(address);}
    public void setPhoneNumber(String phoneNumber){view.getPhoneNumber_tf().setText(phoneNumber);}
    public void setEmail(String email){view.getEmail_tf().setText(email);}

    @Override
    public void update(Observable o, Object arg) {
        tablePanel.refresh();
    }
}
