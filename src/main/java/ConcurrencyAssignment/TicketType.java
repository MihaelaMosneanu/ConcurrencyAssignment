package ConcurrencyAssignment;

import java.util.Random;

public enum TicketType {
    FULL,
    FULL_VIP,
    FREE_PASS,
    ONE_DAY,
    ONE_DAY_VIP;

    private static final Random random = new Random();

    public static TicketType getRandomTicketType() {
        TicketType[] ticketTypes = values();
        return ticketTypes[random.nextInt(ticketTypes.length)];
    }
}
