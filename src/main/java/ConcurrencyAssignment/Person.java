package ConcurrencyAssignment;

public class Person {
    private final Ticket ticket;
    private final FestivalGate gate;

    public Person (Ticket ticket, FestivalGate gate) {
        this.ticket = ticket;
        this.gate = gate;


    }
    public FestivalGate getGate(){
        return this.gate;

    }
    public Ticket getTicket(){
        return this.ticket;
    }
}
