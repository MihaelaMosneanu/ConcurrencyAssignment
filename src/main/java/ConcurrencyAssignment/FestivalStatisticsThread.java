package ConcurrencyAssignment;

import java.util.LinkedList;
import java.util.Queue;


class FestivalStatisticsThread extends Thread {
    private final FestivalGate gate;
    private volatile boolean running = true;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    public void stopThread() {
        running = false;
        synchronized (gate) {
            gate.notify();
        }
    }

    @Override
    public void run() {
        while (running) {
            synchronized (gate) {
                try {
                    gate.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Queue<Person> enteredPersonsCopy = new LinkedList<>(gate.getEnteredPersons());

                int totalPeopleEntered = enteredPersonsCopy.size();
                int fullTicketCount = 0;
                int fullVipTicketCount = 0;
                int freePassCount = 0;
                int oneDayTicketCount = 0;
                int oneDayVipTicketCount = 0;

                for (Person person : enteredPersonsCopy) {
                    TicketType ticketType = person.getTicket().getTicketType();
                    switch (ticketType) {
                        case FULL -> fullTicketCount++;
                        case FULL_VIP -> fullVipTicketCount++;
                        case FREE_PASS -> freePassCount++;
                        case ONE_DAY -> oneDayTicketCount++;
                        case ONE_DAY_VIP -> oneDayVipTicketCount++;
                    }
                }

                System.out.println("Statistics:");
                System.out.println("Total people entered: " + totalPeopleEntered);
                System.out.println(fullTicketCount + " people have full tickets");
                System.out.println(fullVipTicketCount + " people have full VIP tickets");
                System.out.println(freePassCount + " people have free passes");
                System.out.println(oneDayTicketCount + " people have one-day tickets");
                System.out.println(oneDayVipTicketCount + " people have one-day VIP tickets");
                System.out.println();
            }
        }
    }
}
