package RUT.vokzal.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

import RUT.vokzal.DTO.View.TripOutDTO;

public class TripInDTO extends TripOutDTO{
    private int id;
    private LocalDate dateArr;
    private LocalDate dateDep;
    private int trainId;
    private int routeId;
    private String statusTrip;
    private boolean isDelayed;
    private LocalTime delayTime;

    public int getId() {
        return id;
    }

    public LocalDate getDateArr() {
        return dateArr;
    }

    public LocalDate getDateDep() {
        return dateDep;
    }

    public int getTrainId() {
        return trainId;
    }

    public int getRouteId() {
        return routeId;
    }

    public String getStatusTrip() {
        return statusTrip;
    }

    public boolean isDelayed() {
        return isDelayed;
    }

    public LocalTime getDelayTime() {
        return delayTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateArr(LocalDate dateArr) {
        this.dateArr = dateArr;
    }

    public void setDateDep(LocalDate dateDep) {
        this.dateDep = dateDep;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public void setStatusTrip(String statusTrip) {
        this.statusTrip = statusTrip;
    }

    public void setDelayed(boolean isDelayed) {
        this.isDelayed = isDelayed;
    }

    public void setDelayTime(LocalTime delayTime) {
        this.delayTime = delayTime;
    }
}