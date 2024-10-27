package RUT.vokzal.Entity;

import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "route", schema = "public")
public class Route extends BaseEntity{
  private LocalTime timeDep;
  private LocalTime timeArr;
  private Platform depPlId;
  private Platform arrPlId;

  @Column(name = "timeDep", nullable = false)
	public LocalTime getTimeDep() {
		return timeDep;
	}

  @Column(name = "timeArr", nullable = false)
	public LocalTime getTimeArr() {
		return timeArr;
	}

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "depPlId", referencedColumnName = "id")
  public Platform getDepPlId() {
    return this.depPlId;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "arrPlId", referencedColumnName = "id")
  public Platform getArrPlId() {
    return this.arrPlId;
  }

  public void setTimeDep(LocalTime timeDep) {
		this.timeDep = timeDep;
	}

  public void setTimeArr(LocalTime timeArr) {
		this.timeArr = timeArr;
	}

  public void setArrPlId(Platform platform) {
		this.arrPlId = platform;
	}

  public void setDepPlId(Platform platform) {
		this.depPlId = platform;
	}
}