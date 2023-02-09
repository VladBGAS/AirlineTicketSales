public class Sale {
    public int id;
    public int employeeId;
    public int ticketId;
    public String date;
    public double revenue;

    public Sale() {
    }

    public Sale(int id, int employeeId, int ticketId, String date, double revenue) {
        this.id = id;
        this.employeeId = employeeId;
        this.ticketId = ticketId;
        this.date = date;
        this.revenue = revenue;
    }
}

