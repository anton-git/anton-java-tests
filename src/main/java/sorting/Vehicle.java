package sorting;

/**
 * Created with IntelliJ IDEA.
 * User: Anton
 * Date: 25/06/13
 * Time: 23:55
 */
public class Vehicle {

    private int id;
    private String registrationNumber;
    private String ownCity;

    public Vehicle() {
    }

    public Vehicle(int id, String registrationNumber, String ownCity) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.ownCity = ownCity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getOwnCity() {
        return ownCity;
    }

    public void setOwnCity(String ownCity) {
        this.ownCity = ownCity;
    }
}
