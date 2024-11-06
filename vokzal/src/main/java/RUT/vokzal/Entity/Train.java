package RUT.vokzal.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "train", schema = "public")
public class Train extends BaseEntity{
  private int number;
  private String type;
  private String model;
  private int capacity;
  private StatusTrain statusTrain;
  private int maxSpeed;

  public Train() {}

  	@Enumerated(EnumType.STRING)
    @Column(name = "status_train", nullable = false)
    public StatusTrain getStatusTrain() {
        return this.statusTrain;
    }

	@Column(name = "number", nullable = false)
	public int getNumber() {
		return number;
	}

  	@Column(name = "type", nullable = false)
	public String getType() {
		return type;
	}

	@Column(name = "model", nullable = false)
	public String getModel() {
		return model;
	}

	@Column(name = "capacity", nullable = false)
	public int getCapacity() {
		return capacity;
	}

	@Column(name = "max_speed", nullable = false)
	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setStatusTrain(StatusTrain statusTrain) {
        this.statusTrain = statusTrain;
    }

	public void setNumber(int number) {
		this.number = number;
	}

  	public void setType(String type) {
		this.type = type;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
}