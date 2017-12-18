package filehandling;

import settings.Settings;

import java.io.*;

public class ProblemAdder {



    private String outputFileName="output.html";


    public ProblemAdder(String problemname,String problemlink,String submitter,String submitterlink)
    {

        addItem(problemname,problemlink,submitter,submitterlink);

       clearFile();
        write(Settings.files+"prefix.txt");
        write(Settings.gitFolderLink+Settings.html_search_path+"itemslist.txt");
        write(Settings.files+"postfix.txt");
    }


    void write(String string)  {

        try(FileWriter fw = new FileWriter(Settings.gitFolderLink+Settings.html_search_path+outputFileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            FileReader in=new FileReader(string))
        {

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }

        } catch (IOException e) {
            System.out.println(e);
        }


    }


    void  clearFile()
    {
        try(FileOutputStream fileOutputStream=new FileOutputStream(Settings.gitFolderLink+Settings.html_search_path+outputFileName))
        {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void writeString(String str)
    {
        try(FileWriter fw = new FileWriter(Settings.gitFolderLink+Settings.html_search_path+"itemslist.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.write(str);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void addItem(String problemname,String problemlink,String submitter,String submitterlink)
    {

        String item=" <li>\n" +
                "                            <a href=\"";

        item+=problemlink;
        item+="\">";
        item+=problemname;
        item+="(\n" +
                "                                <a herf=\"";
        if(submitterlink!=null)
        {
            item+=submitterlink;
        }

        item+="\">";
        item+=submitter;
        item+="</a>)\n" +
                "                            </a>\n" +
                "                        </li>\n";

        writeString(item);



    }




}

