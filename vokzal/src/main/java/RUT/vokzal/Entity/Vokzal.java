package RUT.vokzal.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vokzal", schema = "public")
public class Vokzal extends BaseEntity{
  private String name;
  private String city;
  private int capacity;

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

  	@Column(name = "city", nullable = false)
	public String getCity() {
		return city;
	}

  	@Column(name = "capacity", nullable = false)
	public int getCapacity() {
		return capacity;
	}

	public void setName(String name) {
		this.name = name;
	}

  	public void setCity(String city) {
		this.city = city;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}