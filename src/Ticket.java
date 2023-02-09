public class Ticket {
    public int id;
    public int customerId;
    public int flightId;
    public String dateOfPurchase;
    public int numberOfSeats;

    public Ticket() {
    }

    public Ticket(int id, int customerId, int flightId, String dateOfPurchase, int numberOfSeats) {
        this.id = id;
        this.customerId = customerId;
        this.flightId = flightId;
        this.dateOfPurchase = dateOfPurchase;
        this.numberOfSeats = numberOfSeats;
    }
}
