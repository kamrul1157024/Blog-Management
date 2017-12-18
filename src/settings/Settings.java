package settings;

public class Settings {



    public static String username="kamrul1157024";
    public static String password="falsepassword";
    public static String gitFolderLink="/home/kamrul/Desktop/kamrul1157024.github.io/";
    public static String code_adding_path="Solutions/";
    public static String html_search_path="Solution_Searcher/";
    public static String faebook_id="https://www.facebook.com/kamrul1157024";
    public static String name="kamrul";
    public static String githublink="http://kamrul1157024.github.io/";
    public static String files="/home/kamrul/Desktop/kamrul1157024.github.io/files/";

    public Settings()
    {


        Information information=new SaveSettings().getInformation();
        username=information.getUsername();
        password=information.getPassword();
        gitFolderLink=information.getGitfolder();
        code_adding_path=information.getCode_adding_path();
        html_search_path=information.getHtml_search_path();
        faebook_id=information.getFaebook_id();
        name=information.getName();
        githublink=information.getGitHub_link();

    }


    @Override
    public void finalize()
    {
        Information information=new Information();
        information.setCode_adding_path(code_adding_path);
        information.setFaebook_id(faebook_id);
        information.setGitfolder(gitFolderLink);
        information.setHtml_search_path(html_search_path);
        information.setUsername(username);
        information.setPassword(password);
        information.setName(name);
        information.setGitHub_link(githublink);
        information.setFiles(files);
        new SaveSettings().saveInformations(information);

        System.out.println("Settings saved");

    }


}
