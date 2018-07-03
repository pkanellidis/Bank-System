import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ServPoint extends Thread{
	private int ServicePoint, ServedNo;
	private Random r;
	
	public ServPoint(int ServicePoint) {
		r = new Random();
		this.ServicePoint = ServicePoint;
		try {
			sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run(){
		super.run();	
		while(true){
			synchronized(this){
				if(!Main.Q.isEmpty()){
					ServedNo = Main.Q.remove(); //dont use poll because it throws exception if the Queue is empty
					System.out.printf("%71s %d is serving %d\n","Point",ServicePoint, ServedNo);
				}
				
				//Is not in critical Section
				try {
					TimeUnit.SECONDS.sleep(r.nextInt(30) + 1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.printf("%92s %d done with Ticket %d\n","Point",ServicePoint,ServedNo);
			}
				
		}
		

	}
	
}
