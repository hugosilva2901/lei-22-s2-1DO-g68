package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializedFileExporter<T> implements Serializable {

    public SerializedFileExporter(){

    }

    @SuppressWarnings("unchecked")
    public List<T> readObjectFromSerializedFile(String directory) throws ClassNotFoundException {
        List<T> generics = new ArrayList<>();
        try {
            boolean objectExiste = true;
            File file = new File(directory);
            FileInputStream files = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(files);

            while (objectExiste) {
                Object object = input.readObject();
                if (object != null) {
                    generics.add((T) object);
                } else {
                    objectExiste = false;
                }
            }
        }catch (EOFException ignored) {
        }catch (IOException ex){
            System.out.println(ex.getMessage() + "  File not Found");
        }

        return generics;
    }

    public void toSerializedFile(List<T> list,File file) {
        try {
            FileOutputStream files = new FileOutputStream(file);
            ObjectOutputStream out  = new ObjectOutputStream(files);
            for(T object : list){
                out.writeObject(object);
            }
            out.flush();
            out.close();
            files.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
