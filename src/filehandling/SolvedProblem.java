package filehandling;

import Algorithm.EditDistance;
import github.GistProcess;
import settings.Settings;

import java.io.*;

public class SolvedProblem implements Runnable{


    private String problemTitle;
    private String problemLink;
    private String submitter;
    private String submitterSocial;

    private String ext;

    private String code;
    private String algorithm;


    private String outputFileName="";


    private Thread t;

    public SolvedProblem()
    {

        t=new Thread(this,"SolvedProblem");

    }


    @Override
    public void run() {
        genpOutputFilename();
        clearFile();
        write();
        addTolist();
    }


    void genpOutputFilename()
    {
        outputFileName+=problemTitle+".html";
    }




    void addTolist()
    {


        ProblemAdder problemAdder=new ProblemAdder(problemTitle,convertFileNameToLink(Settings.code_adding_path+outputFileName),submitter,submitterSocial);
    }



    public String getProblemLink()
    {
        return convertFileNameToLink(Settings.githublink+Settings.html_search_path+Settings.code_adding_path+outputFileName);
    }


    void write()
    {
        write(Settings.files+"soleved_problems_prefix1.txt");
        writeString(problemTitle);
        write(Settings.files+"solved_problem_prefix2.txt");
        writeTitle();
        write(Settings.files+"solved_problem_mid1.txt");
        writeSocial();
        write(Settings.files+"solved_problems_mid2.txt");
        writeAlgorithm();
        writeCode();
        write(Settings.files+"solved_problem_suffix1.txt");
        WriteComments();
        write(Settings.files+"solved_problems_suffix2.txt");
    }




    String makeItEmbeded(String url)
    {
        String prefix="<script src=\"";
        String suffix=".js\"></script>";
        return prefix+url+suffix;
    }

    String convertFileNameToLink(String string)
    {

        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<string.length();i++)
        {
            char c=string.charAt(i);
            if(c!=' ')
            {
                stringBuilder.append(c);
            }
            else
            {
                stringBuilder.append("%20");
            }
        }

        return stringBuilder.toString();
    }

    void writeCode()
    {
        GistProcess gistProcess=new GistProcess();
        if (ext.charAt(0)!='.')
            ext="."+ext;
        gistProcess.setFilename(problemTitle+ext);
        gistProcess.setContent(code);
        System.out.println(gistProcess.addGist());

        String url=null;
        url=gistProcess.getURl();

        url=makeItEmbeded(url);

        writeString(url);


    }


    void writeAlgorithm()
    {

        EditDistance editDistance=new EditDistance();

        String  predef="<html dir=\"ltr\"><head></head><body contenteditable=\"true\"><div contenteditable=\"true\"></div></body></html>";
        if(algorithm!=null&&!algorithm.isEmpty()&&!algorithm.equals(predef)&&editDistance.editDistDP(predef,algorithm)>=30)
        {
            String prefix="<div class=\"w3-panel w3-pale-blue w3-leftbar w3-rightbar w3-border-blue\">";
            String suffix="</div>\n";

            writeString(prefix+algorithm+suffix);

        }

        else {
            String notProvided="<div class=\"w3-panel w3-pale-red w3-leftbar w3-border-red\">\n" +
                    "    <h3>Solver doesn't provide an algorithm .Sorry about that.</h3>\n" +
                    "  </div>";

            writeString(notProvided);
        }

    }

    void WriteComments()
    {

        String str=Settings.githublink+convertFileNameToLink(problemTitle)+"\" ";
        try(FileWriter fw = new FileWriter("solved_problems_output.html", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.write(str);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void writeSocial()
    {
        String string="<h4 class=\"center\">Solution Submitted By :<a href=\"";
        if(!submitterSocial.isEmpty())
            string+=submitterSocial;
        string+="\">";
        string+=submitter;
        string+="</a></h4>";

        writeString(string);
    }



    void writeTitle()
    {
        String str="<a href=\"";
        str+=problemLink;
        str+="\">";
        str+=problemTitle;
        str+="</a>";

        writeString(str);
    }



    void writeString(String str)
    {
        try(FileWriter fw = new FileWriter(Settings.gitFolderLink+Settings.html_search_path+Settings.code_adding_path+outputFileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.write(str);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }








    void write(String string)  {

        try(FileWriter fw = new FileWriter(Settings.gitFolderLink+Settings.html_search_path+Settings.code_adding_path+outputFileName, true);
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
        try(FileOutputStream fileOutputStream=new FileOutputStream(Settings.gitFolderLink+Settings.html_search_path+Settings.code_adding_path+outputFileName))
        {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    public void setProblemTitle(String problemTitle) {
        this.problemTitle = problemTitle;
    }

    public void setProblemLink(String problemLink) {
        this.problemLink = problemLink;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public void setSubmitterSocial(String submitterSocial) {
        this.submitterSocial = submitterSocial;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Thread getThread() {
        return t;
    }
}
