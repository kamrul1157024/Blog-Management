package root_pacakge;

import filehandling.SolvedProblem;
import github.GistProcess;
import internet.Internet;
import javafx.fxml.FXML;

import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import settings.Information;
import settings.SaveSettings;
import settings.Settings;
import sun.security.util.Password;

public class Controller{

//This variable is in main anchor plane
@FXML private ProgressBar progress;
@FXML private Text connection;
@FXML private Text done;
@FXML private Rectangle rectangle;
@FXML private Text title;


//This varibles are for solved problem menu
@FXML private TextArea solvedproblemscode;
@FXML private HTMLEditor solverproblemsidea;
@FXML private TextField solvedproblemsname;
@FXML private TextField solvedproblemsociallink;
@FXML private TextField solvedproblemsproblemname;
@FXML private TextField solvedploblemsproblemlink;
@FXML private TextArea solvedploblemsgenratedlink;
@FXML private TextField solvedproblemextention;
//................................................//


//This variable is made for gist
@FXML private TextArea gistText;
@FXML private TextArea gistLink;
@FXML private TextField gistName;
/********************************/


/*******************************/
//This all are for settings
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private TextField gitFolderLink;
    @FXML private TextField code_adding_path;
    @FXML private TextField html_search_path;
    @FXML private TextField faebook_id;
    @FXML private TextField name;
    @FXML private TextField githublink;
    @FXML private TextField files;

    boolean passwordhide=true;







    void setSettings()
    {
        username.setText(Settings.username);
        password.setText(Settings.password);
        gitFolderLink.setText(Settings.gitFolderLink);
        html_search_path.setText(Settings.html_search_path);
        faebook_id.setText(Settings.faebook_id);
        name.setText(Settings.name);
        githublink.setText(Settings.githublink);
        files.setText(Settings.files);
        code_adding_path.setText(Settings.code_adding_path);
    }


    @FXML
    void showPass()
    {
        AnchorPane anchorPane=new AnchorPane();
        Text text=new Text("Sorry you can not see it");
        text.setX(150);
        text.setY(150);
        anchorPane.getChildren().add(text);
        Scene scene=new Scene(anchorPane,400,300);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


    }

    @FXML
    void notonSettings()
    {
        new Thread(() -> {
            Information information=new Information();
            information.setCode_adding_path(code_adding_path.getText());
            information.setFaebook_id(faebook_id.getText());
            information.setGitfolder(gitFolderLink.getText());
            information.setHtml_search_path(html_search_path.getText());
            information.setUsername(username.getText());
            information.setPassword(password.getText());
            information.setName(name.getText());
            information.setName(githublink.getText());
            information.setFiles(files.getText());
            new SaveSettings().saveInformations(information);
        }).start();

    }

    @FXML
    void puranSettings()
    {
        new Thread(() -> {
            Information information=new SaveSettings().restoreInformation();
            new SaveSettings().saveInformations(information);
        }).start();

        setSettings();

    }


void processStarted(){

    progress.setVisible(true);
    new Thread(() -> {
        for (double i=0;i<=1;i+=.1)
        {
            try {
                rectangle.setOpacity(1-i);
                title.setOpacity(1-i);
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }).start();



}


    void processStop(String pass){
    progress.setVisible(false);
        for (double i=1;i>=0;i-=.1)
        {
            try {
                rectangle.setOpacity(1-i);
                title.setOpacity(1-i);
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        done.setText(pass);
        for (double i=0;i<=1;i+=.1)
        {
            try {
                done.setOpacity(i);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (double i=1;i>=0;i-=.1)
        {
            try {
                done.setOpacity(i);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    @FXML
    void newGist()
    {
        gistLink.setText("");
        gistName.setText("");
        gistText.setText("");
    }

    @FXML
    void  createGist()
    {
        processStarted();
        Thread thread=new Thread(() -> {
            GistProcess gistProcess=new GistProcess();
            gistProcess.setContent(gistText.getText());
            gistProcess.setFilename(gistName.getText());
            gistProcess.addGist();
            gistLink.setText(gistProcess.getURl());
        });

        thread.start();

        new Thread(() -> {
            try {
                thread.join();
                processStop("New gist has been created copy above link to share it ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }


    @FXML
    void newProblem()
    {
        solvedproblemscode.setText("");
        solvedproblemsproblemname.setText("");
        solverproblemsidea.setHtmlText("");
        solvedploblemsproblemlink.setText("");
        solvedploblemsgenratedlink.setText("");
    }




    @FXML
    void submitSolvedProblem()
    {
        processStarted();
        SolvedProblem solvedProblem=new SolvedProblem();
        solvedProblem.setProblemTitle(solvedproblemsproblemname.getText());
        solvedProblem.setExt(solvedproblemextention.getText());
        solvedProblem.setAlgorithm(solverproblemsidea.getHtmlText());
        solvedProblem.setCode(solvedproblemscode.getText());
        solvedProblem.setSubmitterSocial(solvedproblemsociallink.getText());
        solvedProblem.setSubmitter(solvedproblemsname.getText());
        solvedProblem.setProblemLink(solvedploblemsproblemlink.getText());
        solvedProblem.getThread().start();

       Thread t= new Thread(() -> {
            try {
                solvedProblem.getThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            processStop("This problem is added to list Copy link to share it ");
        });
       t.start();

        solvedploblemsgenratedlink.setText(solvedProblem.getProblemLink());
    }


    @FXML
    void initialize() {
       // new CheckConnection();
        setSettings();
        new Thread(() -> {
            Internet internet=new Internet();
            while (true)
            {
                //System.out.println(CheckConnection.isConnected);

                if (Internet.isConnected&&internet!=null) {
                    connection.setText("Connected");
                }
                else
                {
                    connection.setText("No internet.Please check your settings.");
                }
            }

        }).start();

        solvedproblemsociallink.setText(Settings.faebook_id);
        solvedproblemsname.setText(Settings.name);
    }
}
