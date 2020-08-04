package view;

import Model.ClockThread;

import javax.swing.*;
import java.awt.*;

public class DigitalClock extends JPanel {
    public JLabel jlabClock;
    public JLabel jlabDate;
    private ClockThread ct;
    public DigitalClock() {
        jlabClock = new JLabel("Time");
        jlabDate = new JLabel("Date");
        setLayout(new BorderLayout());
        jlabClock.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        jlabDate.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        jlabClock.setForeground(Color.WHITE);
        jlabDate.setForeground(Color.WHITE);
        ct=new ClockThread(this);
        add(jlabClock,BorderLayout.PAGE_START);
        add(jlabDate,BorderLayout.PAGE_END);
        setBorder(BorderFactory.createEtchedBorder());
        setBackground(Color.DARK_GRAY);
        setVisible(true);
    }
}
