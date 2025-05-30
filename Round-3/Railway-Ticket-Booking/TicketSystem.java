import java.util.*;

public class TicketSystem {
    private final List<String> availableBerths = new ArrayList<>(Arrays.asList("L", "M", "U"));
    private final Queue<Passenger> racQueue = new LinkedList<>();
    private final Queue<Passenger> waitingListQueue = new LinkedList<>();
    private final List<Passenger> confirmedPassengers = new ArrayList<>();
    private int ticketCounter = 1;

    public void bookTicket(String name, int age, String gender, String berthPreference) {
        String ticketId = "T" + ticketCounter++;
        Passenger passenger;

        if (!availableBerths.isEmpty()) {
            String allocatedBerth = allocateBerth(age, gender, berthPreference);
            passenger = new Passenger(name, age, gender, berthPreference, allocatedBerth, ticketId);
            confirmedPassengers.add(passenger);
            availableBerths.remove(allocatedBerth);
            System.out.println("Ticket Confirmed: " + passenger);
        } else if (racQueue.size() < 1) {
            passenger = new Passenger(name, age, gender, berthPreference, "RAC", ticketId);
            racQueue.offer(passenger);
            System.out.println("Ticket in RAC: " + passenger);
        } else if (waitingListQueue.size() < 1) {
            passenger = new Passenger(name, age, gender, berthPreference, "Waiting List", ticketId);
            waitingListQueue.offer(passenger);
            System.out.println("Ticket in Waiting List: " + passenger);
        } else {
            System.out.println("No tickets available.");
        }
    }

    private String allocateBerth(int age, String gender, String preference) {
        if ((age >= 60 || gender.equalsIgnoreCase("female")) && availableBerths.contains("L")) {
            return "L";
        }
        if (availableBerths.contains(preference)) {
            return preference;
        }
        return availableBerths.get(0); // fallback
    }

    public void cancelTicket(String ticketId) {
        Passenger toRemove = null;

        for (Passenger p : confirmedPassengers) {
            if (p.ticketId.equals(ticketId)) {
                toRemove = p;
                break;
            }
        }

        if (toRemove != null) {
            confirmedPassengers.remove(toRemove);
            availableBerths.add(toRemove.allottedBerth);
            System.out.println("Cancelled ticket ID: " + ticketId);

            if (!racQueue.isEmpty()) {
                Passenger racPassenger = racQueue.poll();
                String newBerth = allocateBerth(racPassenger.age, racPassenger.gender, racPassenger.berthPreference);
                racPassenger.allottedBerth = newBerth;
                confirmedPassengers.add(racPassenger);
                availableBerths.remove(newBerth);
                System.out.println("RAC passenger confirmed: " + racPassenger);

                if (!waitingListQueue.isEmpty()) {
                    Passenger waitingPassenger = waitingListQueue.poll();
                    waitingPassenger.allottedBerth = "RAC";
                    racQueue.offer(waitingPassenger);
                    System.out.println("Waiting passenger moved to RAC: " + waitingPassenger);
                }
            }
        } else {
            System.out.println("Ticket ID not found.");
        }
    }

    public void printBookedTickets() {
        if (confirmedPassengers.isEmpty()) {
            System.out.println("No confirmed tickets.");
        } else {
            System.out.println("Confirmed Tickets:");
            for (Passenger p : confirmedPassengers) {
                System.out.println(p);
            }
        }
    }

    public void printAvailableTickets() {
        System.out.println("Available Berths: " + availableBerths);
        System.out.println("Available RAC: " + (1 - racQueue.size()));
        System.out.println("Available Waiting List: " + (1 - waitingListQueue.size()));
    }

    public void viewRacTickets() {
        if (racQueue.isEmpty()) {
            System.out.println("No RAC tickets.");
        } else {
            System.out.println("RAC Tickets:");
            for (Passenger p : racQueue) {
                System.out.println(p);
            }
        }
    }

    public void viewWaitingListTickets() {
        if (waitingListQueue.isEmpty()) {
            System.out.println("No Waiting List tickets.");
        } else {
            System.out.println("Waiting List Tickets:");
            for (Passenger p : waitingListQueue) {
                System.out.println(p);
            }
        }
    }
}
