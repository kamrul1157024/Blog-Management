package github;

import settings.Settings;
import org.eclipse.egit.github.core.Gist;
import org.eclipse.egit.github.core.GistFile;
import org.eclipse.egit.github.core.service.GistService;

import java.io.IOException;
import java.util.Collections;

public class GistProcess {

   private String content;
   private String filename;
   private Gist gist;

    public  GistProcess()
    {

    }


    public boolean addGist()  {
        GistFile file = new GistFile();
        file.setContent(content);
        gist = new Gist();
        gist.setDescription(" ");
        gist.setFiles(Collections.singletonMap(filename, file));
        GistService service = new GistService();
        service.getClient().setCredentials(Settings.username, Settings.password);
        try {
            gist = service.createGist(gist); //returns the created gist
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }

        System.out.println();
        System.out.println(gist.getComments());
        return true;
    }


    public String getURl()
    {
        return  gist.getHtmlUrl();
    }


    public void setContent(String content) {
        this.content = content;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
