public class Destination {
    public int id;
    public String name;
    public String country;
    public String city;
    public String airportCode;

    public Destination() {
    }

    public Destination(int id, String name, String airportCode) {
        this.id = id;
        this.name = name;
        this.airportCode = airportCode;
    }

    @Override
    public String toString() {
        return "id = "+id +"\nname = "+name+"\nairportCode = "+ airportCode;
    }
}

