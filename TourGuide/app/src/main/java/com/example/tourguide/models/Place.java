package com.example.tourguide.models;

public class Place {

    private String name;
    private String description;
    private String address;
    private String phone;
    private String website;

    public Place(String[] data) {
        this.name = data[0];
        this.description = data[1];
        this.address = data[2];
        this.phone = data[3];
        this.website = data[4];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
