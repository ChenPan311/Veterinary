package Model;

import Exceptions.MedicineNotExistException;
import Exceptions.MedicineQuantityInsufficient;
import Model.InterfaceModels.MedicineManagerInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicineManager implements MedicineManagerInterface {
    private Map<Medicine,Integer> medicinesAndQuantity;
    private static MedicineManager medicineManager=null;
    private static final String fileName="medicines.dat";

    public MedicineManager() {
        this.medicinesAndQuantity = new HashMap<>();
        readMedicinesFromFile();
    }

    public static MedicineManager singletonMedicineManager(){
        if(medicineManager==null) {
            medicineManager=new MedicineManager();
        }
        return medicineManager;
    }

    private void readMedicinesFromFile() {
        File file = new File(fileName);
        if (file.length() == 0) {
            return;
        }
        try (InputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            medicinesAndQuantity = (Map<Medicine,Integer>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeMedicineToFile(){
        try (OutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(medicinesAndQuantity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addMedicine(Medicine medicine,int quantity){ // either add new medicine or add quantity to existing medicine
        if (medicinesAndQuantity.containsKey(medicine)) {
            medicinesAndQuantity.put(medicine,medicinesAndQuantity.get(medicine)+quantity);
        }
        else{
            medicinesAndQuantity.put(medicine,quantity);
        }
        writeMedicineToFile();
    }

    public int getMedicineQuantity(Medicine medicine){
        return medicinesAndQuantity.getOrDefault(medicine,0);
    }

    public void removeMedicine(Medicine medicine){
        medicinesAndQuantity.remove(medicine);
        writeMedicineToFile();
    }


    public void decreaseQuantityFromMedicineStock(Medicine medicine,int quantity) throws MedicineNotExistException, MedicineQuantityInsufficient {
        if(medicinesAndQuantity.containsKey(medicine)){
            if(getMedicineQuantity(medicine)>=quantity) {
                medicinesAndQuantity.put(medicine, medicinesAndQuantity.get(medicine) - quantity);
                writeMedicineToFile();
            }
            else
                throw new MedicineQuantityInsufficient("Quantity insufficient Current quantity of "+medicine.getName()+" is "+getMedicineQuantity(medicine));
        }
        else
            throw new MedicineNotExistException("Medicine id:"+ "medicine.getId()"+" is not in the stock");
    }

    public List<Medicine> getMedicineList(){
        return new ArrayList<Medicine>(medicinesAndQuantity.keySet());
    }
    public List<Integer> getQuantityList(){
        return new ArrayList<Integer>(medicinesAndQuantity.values());
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


    public Map<Medicine, Integer> getMedicinesAndQuantity() {
        return new HashMap<>(medicinesAndQuantity);
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
