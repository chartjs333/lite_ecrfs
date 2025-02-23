package net.mdsgene.admin.admintool.business;

public class CityCoordinate {

    private String name;

    private double latitude;

    private double longitude;

    private int index;

    private String infoAboutCity;



    public CityCoordinate(String name, double latitude, double longitude, int index) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.index = index;
    }

    public CityCoordinate(String name, double latitude, double longitude, int index, String infoAboutCity) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.index = index;
        this.infoAboutCity = infoAboutCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    public String getInfoAboutCity() {
        return infoAboutCity;
    }

    public void setInfoAboutCity(String infoAboutCity) {
        this.infoAboutCity = infoAboutCity;
    }


}
