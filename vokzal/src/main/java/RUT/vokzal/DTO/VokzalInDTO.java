package RUT.vokzal.DTO;

import RUT.vokzal.DTO.View.VokzalOutDTO;

public class VokzalInDTO extends VokzalOutDTO{
    private int id;
    private String name;
    private String city;
    private int capacity;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setId(int id) {
        this.id = id;
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