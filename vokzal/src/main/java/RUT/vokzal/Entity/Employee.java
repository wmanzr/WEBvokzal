package RUT.vokzal.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee", schema = "public")
public class Employee extends BaseEntity{
  private String post;
  private String login;
  private String password;
  private int experience;
  private Train trainId;

  public Employee() {}

  @ManyToOne(fetch = FetchType.LAZY,  optional = true)
  @JoinColumn(name = "trainId", referencedColumnName = "id")
  public Train getTrainId() {
    return this.trainId;
  }

  @Column(name = "post", nullable = false)
	public String getPost() {
		return post;
	}

  @Column(name = "login", nullable = false)
	public String getLogin() {
		return login;
	}

  @Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

  @Column(name = "experience", nullable = false)
	public int getExperience() {
		return experience;
	}

  public void setTrainId(Train train) {
		this.trainId = train;
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
}