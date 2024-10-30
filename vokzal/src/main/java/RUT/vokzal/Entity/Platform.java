package RUT.vokzal.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "platform", schema = "public")
public class Platform extends BaseEntity{
  private Vokzal vokzalId;
  private int number;
  private String type;
  private StatusPlatform statusPlatform;

  public Platform() {}

  @Enumerated(EnumType.STRING)
  @Column(name = "status_platform", nullable = false)
  public StatusPlatform getStatusPlatform() {
      return statusPlatform;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "vokzalId", referencedColumnName = "id")
  public Vokzal getVokzalId() {
    return this.vokzalId;
  }

  @Column(name = "number", nullable = false)
	public int getNumber() {
		return number;
	}

  @Column(name = "type", nullable = false)
	public String getType() {
		return type;
	}

  public void setVokzalId(Vokzal vokzal) {
		this.vokzalId = vokzal;
	}

  public void setType(String type) {
		this.type = type;
	}

  public void setNumber(int number) {
		this.number = number;
	}

  public void setStatusPlatform(StatusPlatform statusPlatform) {
    this.statusPlatform = statusPlatform;
  }
}