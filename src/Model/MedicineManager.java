package Model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MedicineManager {
    private HashMap<Medicine,Integer> medicinesAndQuantity;

    public MedicineManager() {
        this.medicinesAndQuantity = new HashMap<>();
    }

    public void addMedicine(Medicine medicine,int quantity){ // either add new medicine or add quantity to existing medicine
        if (medicinesAndQuantity.containsKey(medicine)) {
            medicinesAndQuantity.put(medicine,medicinesAndQuantity.get(medicine)+quantity);
        }
        else{
            medicinesAndQuantity.put(medicine,quantity);
        }
    }

    public void removeMedicine(Medicine medicine){
        medicinesAndQuantity.remove(medicine);
    }
    public int getMedicineQuantity(Medicine medicine){
        return medicinesAndQuantity.getOrDefault(medicine,0);
    }

    public void decreaseQuantityFromMedicineStock(Medicine medicine,int quantity) throws MedicineNotExistException,MedicineQuantityInsufficient{
        if(medicinesAndQuantity.containsKey(medicine)){
            if(getMedicineQuantity(medicine)>=quantity)
                medicinesAndQuantity.put(medicine,medicinesAndQuantity.get(medicine)-quantity);
            else
                throw new MedicineQuantityInsufficient("Quantity insufficient Current quantity of "+medicine.getName()+" is "+getMedicineQuantity(medicine));
        }
        else
            throw new MedicineNotExistException("Medicine id:"+ "medicine.getId()"+" is not in the stock");
    }

    @Override
    public String toString() { // need to improve this toString
        StringBuilder stringBuilderResult=new StringBuilder();
        for (Map.Entry<Medicine, Integer> entry : medicinesAndQuantity.entrySet()) {
            Medicine medicine = entry.getKey();
            int quantity = entry.getValue();
            stringBuilderResult.append(medicine.toString() +" "+quantity+"\n");
        }
        return stringBuilderResult.toString();
        }


    public HashMap<Medicine, Integer> getMedicinesAndQuantity() {
        return medicinesAndQuantity;
    }

    public void setMedicinesAndQuantity(HashMap<Medicine, Integer> medicinesAndQuantity) {
        this.medicinesAndQuantity = medicinesAndQuantity;
    }

    public boolean findMedicineId(String id){
        for(Medicine medicine:medicinesAndQuantity.keySet()){
            if(medicine.getId().equals(id))
                return true;
        }
        return false;
    }


}
