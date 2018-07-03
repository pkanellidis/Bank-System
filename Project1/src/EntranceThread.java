import java.util.Random;
import java.util.concurrent.TimeUnit;

public class EntranceThread extends Thread{
	private int B, Entrance;
	private Random r;
	
	public EntranceThread(int Entrance){
		r = new Random();
		this.Entrance = Entrance;
	}
	
	@Override
	public void run() {
		super.run();
		while(true){
			B = r.nextInt((2) + 1);
			Main.B = Main.B + B;
			
//			for(int i = 0; i < B; i++){
//				Main.Q.add(temp = ++Main.Inc); //must make custom class with the waiting time
//				System.out.println("Customer Entered from " + Entrance + " Ticket No " + temp);
//			}
			System.out.printf("Customers Entered from %d\n", Entrance);
			try {
				TimeUnit.SECONDS.sleep(B*5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

