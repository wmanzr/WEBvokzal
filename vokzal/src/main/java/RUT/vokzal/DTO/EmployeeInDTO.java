package RUT.vokzal.DTO;

import RUT.vokzal.DTO.View.EmployeeOutDTO;

public class EmployeeInDTO extends EmployeeOutDTO{
    private int id;
    private String post;
    private String login;
    private String password;
    private int experience;
    private int trainId;

    public int getId() {
        return id;
    }

    public String getPost() {
        return post;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getExperience() {
        return experience;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }
}