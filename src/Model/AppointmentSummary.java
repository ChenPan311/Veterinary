package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class AppointmentSummary implements Serializable {
    private String treatmentSummary,recommendations, medicines;

    public AppointmentSummary() {
        this.medicines = "";
        this.treatmentSummary = "";
        this.recommendations = "";
    }

    public AppointmentSummary(String treatmentSummary, String recommendations, String medicine) {
        this.medicines = medicine;
        this.treatmentSummary = treatmentSummary;
        this.recommendations = recommendations;
    }


    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public String getTreatmentSummary() {
        return treatmentSummary;
    }

    public void setTreatmentSummary(String treatmentSummary) {
        this.treatmentSummary = treatmentSummary;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }


    @Override
    public String toString() {
        return "AppointmentSummary{" +
                ", treatmentSummary='" + treatmentSummary + '\'' +
                ", recommendations='" + recommendations + '\'' +
                '}';
    }

}


