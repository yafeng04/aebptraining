package model;

public class Ticket {
    private boolean isValid;

    private String carNumber;

    public Ticket(boolean isValid) {
        this.isValid = isValid;
    }

    public Ticket(boolean isValid, String carNumber) {
        this.isValid = isValid;
        this.carNumber = carNumber;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public boolean getValid() {
        return isValid;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}
