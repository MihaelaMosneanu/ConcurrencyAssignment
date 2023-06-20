package ConcurrencyAssignment;


public class FestivalMain {
    public static void main(String[] args) {

        FestivalGate gate = new FestivalGate();
        Festival festival = new Festival();
        festival.setGate(gate);

        int numAttendees = 100;

        for (int i = 0; i < numAttendees; i++) {
            FestivalAttendeeThread attendee = new FestivalAttendeeThread(gate);
            attendee.start();
        }

        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);
        statisticsThread.start();


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        statisticsThread.stopThread();
    }

}
