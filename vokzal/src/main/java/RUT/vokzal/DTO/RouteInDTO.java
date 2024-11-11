package RUT.vokzal.DTO;

import java.time.LocalTime;

import RUT.vokzal.DTO.View.RouteOutDTO;

public class RouteInDTO extends RouteOutDTO{
    private int id;
    private LocalTime timeDep;
    private LocalTime timeArr;
    private int depPlId;
    private int arrPlId;

    public int getId() {
        return id;
    }

    public LocalTime getTimeDep() {
        return timeDep;
    }

    public LocalTime getTimeArr() {
        return timeArr;
    }

    public int getDepPlId() {
        return depPlId;
    }

    public int getArrPlId() {
        return arrPlId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimeDep(LocalTime timeDep) {
        this.timeDep = timeDep;
    }

    public void setTimeArr(LocalTime timeArr) {
        this.timeArr = timeArr;
    }

    public void setDepPlId(int depPlId) {
        this.depPlId = depPlId;
    }

    public void setArrPlId(int arrPlId) {
        this.arrPlId = arrPlId;
    }
}