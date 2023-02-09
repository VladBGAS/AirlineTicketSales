public class Flight {
    public int id;
    public int flightId;
    public String flightNumber;
    public String departureTime;
    public String arrivalTime;
    public int availableSeats;
    public int airlineId;
    public int destinationId;

    public Flight(int flightId, String flightNumber, String departureTime, String arrivalTime, int availableSeats, int airlineId, int destinationId) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.availableSeats = availableSeats;
        this.airlineId = airlineId;
        this.destinationId = destinationId;
    }

    @Override
    public String toString() {
        return "id = " + id + "\nflightId = " + flightNumber + "\ndepartureTime = " + departureTime + "\narrivalTime = "+ arrivalTime+"\navailableSeats = " + availableSeats;
    }
}