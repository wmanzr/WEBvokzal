package RUT.vokzal.DTO;

import RUT.vokzal.DTO.View.TrainOutDTO;

public class TrainInDTO extends TrainOutDTO{
    private int id;
    private int number;
    private String type;
    private String model;
    private int capacity;
    private String statusTrain;
    private int maxSpeed;

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getStatusTrain() {
        return statusTrain;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setStatusTrain(String statusTrain) {
        this.statusTrain = statusTrain;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}