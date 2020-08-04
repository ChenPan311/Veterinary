package Model;

import view.DigitalClock;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClockThread extends Thread {
    DigitalClock dc;
    int hour, second, minute;
    int year,month,day;

    public ClockThread(DigitalClock dc) {
        this.dc = dc;
        start();
    }

    @Override
    public void run() {
        while (true) {
            Calendar cal = Calendar.getInstance();
            hour = cal.get(Calendar.HOUR_OF_DAY);
            minute = cal.get(Calendar.MINUTE);
            second = cal.get(Calendar.SECOND);

            year = cal.get(Calendar.YEAR);
            month = cal.get(Calendar.MONTH);
            day = cal.get(Calendar.DAY_OF_MONTH);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdf24 = new SimpleDateFormat("HH:mm:ss");
            Date date = cal.getTime();
            String time24 = sdf24.format(date);
            String date24 = dateFormat.format(date);

            dc.jlabClock.setText(time24);
            dc.jlabDate.setText(date24);
        }
    }
}
