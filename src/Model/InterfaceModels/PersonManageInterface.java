package Model.InterfaceModels;

import Exceptions.PersonAlreadyExistException;
import Exceptions.PersonNotExistException;
import Model.Person;

public interface PersonManageInterface {
    public boolean searchById(int id);
    public void addPerson(Person person) throws PersonAlreadyExistException;
    public void removePerson(Person appointment) throws PersonNotExistException;
    public boolean searchPetForCustomer(int customerId,int petId);

}
