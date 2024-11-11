package RUT.vokzal.DTO;

import RUT.vokzal.DTO.View.PlatformOutDTO;

public class PlatformInDTO extends PlatformOutDTO{
    private int id;
    private int vokzalId;
    private int number;
    private String type;
    private String statusPlatform;

    public int getId() {
        return id;
    }

    public int getVokzalId() {
        return vokzalId;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public String getStatusPlatform() {
        return statusPlatform;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVokzalId(int vokzalId) {
        this.vokzalId = vokzalId;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatusPlatform(String statusPlatform) {
        this.statusPlatform = statusPlatform;
    }
}