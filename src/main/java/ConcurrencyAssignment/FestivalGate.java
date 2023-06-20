package ConcurrencyAssignment;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FestivalGate {

    private final Queue<Person> enteredPersons = new ConcurrentLinkedQueue<>();

    public void validateTicket(Person person) {
        if(person.getGate().equals(this) && person.getTicket().getNumber() != 0){
            pass();
            enteredPersons.add(person);
        }
    }
    public Queue<Person> getEnteredPersons(){
        return this.enteredPersons;
    }
    private void pass(){
        System.out.println("The ticket is valid");
    }

}
