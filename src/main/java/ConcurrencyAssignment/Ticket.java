package ConcurrencyAssignment;

import java.util.Random;

public class Ticket {
    private final int number;
    private final TicketType ticketType;

    public Ticket(TicketType ticketType) {
        Random random = new Random();
        this.number = random.nextInt();
        this.ticketType = ticketType;
    }

    public int getNumber() {
        return this.number;
    }

    public TicketType getTicketType() {
        return this.ticketType;
    }
}
