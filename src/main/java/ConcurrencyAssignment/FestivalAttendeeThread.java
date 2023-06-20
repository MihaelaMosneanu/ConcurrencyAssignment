package ConcurrencyAssignment;

public class FestivalAttendeeThread extends Thread {
    private final FestivalGate gate;

    public FestivalAttendeeThread(FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        TicketType randomTicketType = TicketType.getRandomTicketType();
        Ticket ticket = new Ticket(randomTicketType);
        Person person = new Person(ticket, gate);
        gate.validateTicket(person);
    }
}
