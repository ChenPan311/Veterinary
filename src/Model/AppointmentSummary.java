package Model;

import java.util.ArrayList;

public class AppointmentSummary {
    private ArrayList<Medicine> medicines;
    private String treatmentSummary,recommendations;

    public AppointmentSummary() {
    }

    public AppointmentSummary(String treatmentSummary, String recommendations) {
        this.medicines =new ArrayList<>();
        this.treatmentSummary = treatmentSummary;
        this.recommendations = recommendations;
    }


    public AppointmentSummary(ArrayList<Medicine> medicines, String treatmentSummary, String recommendations) {
        this.medicines = medicines;
        this.treatmentSummary = treatmentSummary;
        this.recommendations = recommendations;
    }

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(ArrayList<Medicine> medicines) {
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

    public void addMedicines(ArrayList<Medicine> medicinesToAdd ){ // add list of medicines
        this.medicines.addAll(medicinesToAdd);
    }
    public void addMedicine(Medicine medicine ){
        this.medicines.add(medicine);
    } // add one medicine


    @Override
    public String toString() {   // need to print also the medicine list
        return "AppointmentSummary{" +
                ", treatmentSummary='" + treatmentSummary + '\'' +
                ", recommendations='" + recommendations + '\'' +
                '}';
    }

}


