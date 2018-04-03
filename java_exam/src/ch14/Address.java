package ch14;

public class Address {
    private String city;
    private int bungi;

    public Address(String city, int bungi) {
        this.city = city;
        this.bungi = bungi;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getBungi() {
        return bungi;
    }

    public void setBungi(int bungi) {
        this.bungi = bungi;
    }
}
