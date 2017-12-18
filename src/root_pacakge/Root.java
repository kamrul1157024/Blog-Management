package root_pacakge;


import settings.Settings;
import github.GitMain;
import internet.Internet;

public class Root {

    public static GitMain gitMain;
    public  boolean allLoaded=false;
    Root() throws Exception {

        //new GitMain();
        new Internet();
        new Settings();
        allLoaded=true;

    }
}
