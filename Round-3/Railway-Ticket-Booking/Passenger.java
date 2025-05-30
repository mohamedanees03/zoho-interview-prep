public class Passenger {
    String name;
    int age;
    String gender;
    String berthPreference;
    String allottedBerth;
    String ticketId;

    public Passenger(String name, int age, String gender, String berthPreference, String allottedBerth, String ticketId) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berthPreference = berthPreference;
        this.allottedBerth = allottedBerth;
        this.ticketId = ticketId;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId + ", Name: " + name + ", Age: " + age +
                ", Gender: " + gender + ", Berth: " + allottedBerth;
    }
}
