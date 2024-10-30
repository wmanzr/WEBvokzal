package RUT.vokzal.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "trip", schema = "public")
public class Trip extends BaseEntity{
  private LocalDate date;
  private Train trainId;
  private Route routeId;
  private StatusTrip statusTrip;
  private boolean isDelayed;
  private LocalTime delayTime;

  public Trip() {}

  @Enumerated(EnumType.STRING)
  @Column(name = "status_trip", nullable = false)
  public StatusTrip getStatusTrip() {
      return this.statusTrip;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "trainId", referencedColumnName = "id")
  public Train getTrain() {
    return this.trainId;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "routeId", referencedColumnName = "id")
  public Route getRoute() {
    return this.routeId;
  }

  @Column(name = "date", nullable = false)
	public LocalDate getDate() {
		return date;
	}

  @Column(name = "is_delayed", nullable = false)
    public boolean isDelayed() {
        return isDelayed;
    }

  @Column(name = "delay_time", nullable = true)
  public LocalTime getDelayTime() {
      return delayTime;
    }

  public void setStatusTrip(StatusTrip statusTrip) {
    this.statusTrip = statusTrip;
    } 

  public void setTrain(Train train) {
		this.trainId = train;
	}

  public void setRoute(Route route) {
		this.routeId = route;
	}

  public void setDate(LocalDate date) {
		this.date = date;
	}

  public void setDelayed(boolean isDelayed) {
    this.isDelayed = isDelayed;
  }

  public void setDelayTime(LocalTime delayTime) {
    this.delayTime = delayTime;
  }
}