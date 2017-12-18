package settings;

import java.io.*;

public class SaveSettings {

    public SaveSettings()
    {

    }

    public void saveInformations(Information information)
    {
        try {
            FileOutputStream fout=new FileOutputStream("/home/kamrul/data");
            ObjectOutputStream out=new ObjectOutputStream(fout);


            out.writeObject(information);
            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Information getInformation()
    {
        try {
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("/home/kamrul/data"));
            Information information=(Information)in.readObject();
            return information;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Information restoreInformation()
    {
        try {
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("/home/kamrul/defdata"));
            Information information=(Information)in.readObject();
            return information;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }


}
