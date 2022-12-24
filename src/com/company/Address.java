package com.company;

public class Address implements Comparable<Address> {
    private int streetNum;
    private String streetName;
    private int zipCode;

    public Address() {
        setStreetName("");
        setStreetNum(0);
        setZipCode(0);
    }

    public Address(int streetNum, String streetName, int zipCode) {
        setStreetName(streetName);
        setStreetNum(streetNum);
        setZipCode(zipCode);
    }

    // Setters
    public void setStreetNum(int streetNum) {
        this.streetNum = streetNum;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    // Getters
    public int getStreetNum() {
        return streetNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getZipCode() {
        return zipCode;
    }

    // Functions
    public String toString() {
        return getStreetNum() + " " + getStreetName() + " " + getZipCode() + "\n";
    }

    @Override
    public int compareTo(Address inputAddress) {
        if (inputAddress.getStreetNum() == this.getStreetNum() && inputAddress.getStreetName().toLowerCase().contains(this.getStreetName().toLowerCase()) && inputAddress.getZipCode() == this.getZipCode())
            return 0;
        return 1;
    }
}
