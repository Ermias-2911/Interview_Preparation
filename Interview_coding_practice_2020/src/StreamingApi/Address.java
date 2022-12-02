package StreamingApi;

public class Address {
    private String street;
    private String city;
    private int zipcode;
    private String state;

    public Address(String street, String city, int zipcode, String state) {
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipcode=" + zipcode +
                ", state='" + state + '\'' +
                '}';
    }
}
