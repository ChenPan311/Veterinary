package Model;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FileManager<T> {
    private String fileName;
  //  private Set<T> dataSet;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }
    Set<T> readFromFile() {
        File file = new File(fileName);
        if (file.length() == 0) {
            return new HashSet<>();
        }
        try (InputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
             return (Set<T>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new HashSet<>();
    }

    void writeToFile(Set<T> dataSet) {
        try (OutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(dataSet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
