package settings;

import java.io.Serializable;

public class Information implements Serializable {

    private String faebook_id;
    private String name;
    private String gitfolder;
    private String username;
    private String password;
    private String code_adding_path;
    private String html_search_path;
    private String gitHub_link;
    private String files;
    public Information()
    {

    }


    public String getFaebook_id() {
        return faebook_id;
    }

    public void setFaebook_id(String faebook_id) {
        this.faebook_id = faebook_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGitfolder() {
        return gitfolder;
    }

    public void setGitfolder(String gitfolder) {
        this.gitfolder = gitfolder;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode_adding_path() {
        return code_adding_path;
    }

    public void setCode_adding_path(String code_adding_path) {
        this.code_adding_path = code_adding_path;
    }

    public String getHtml_search_path() {
        return html_search_path;
    }

    public void setHtml_search_path(String html_search_path) {
        this.html_search_path = html_search_path;
    }

    public String getGitHub_link() {
        return gitHub_link;
    }

    public void setGitHub_link(String gitHub_link) {
        this.gitHub_link = gitHub_link;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }
}
