import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

//A is the number of entrances and C is the number of service points
public class Main {
	public static volatile int B, Inc = 0, C = 5, D = 30;
	public static volatile Queue<Integer> Q = new ArrayBlockingQueue<Integer>(D); //so the queue can fit in 100 customers
	public static void main(String[] args) {
		int A = 4;
		ArrayList<EntranceThread> entrances = new ArrayList<EntranceThread>();
		ArrayList<ServPoint> Points = new ArrayList<ServPoint>();
		
		//Create a thread for each entrance
		for(int i = 0;i < A; i++){
			entrances.add(new EntranceThread(i+1));
			entrances.get(i).start();
		}
		//Customers Enter and create a queue for the ticket machine so we can make it in another thread
		TicketMachine m = new TicketMachine();
		m.start();
		
		for(int i = 0; i < C; i++){
			Points.add(new ServPoint(i+1));
			Points.get(i).start();
		}
		
		

	}
}
