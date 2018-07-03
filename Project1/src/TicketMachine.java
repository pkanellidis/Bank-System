
public class TicketMachine extends Thread{
	int total; //if we dont save the value of i and use the for value then the i will start over from zero causing duplicate tickets
	
	public TicketMachine() {
		super();
		this.total = 0;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){
			if (Main.B != 0){
				for(int i = 0; i < Main.B; i++){
					if(Main.Q.size() < Main.D){
						Main.Q.add(++total);
						Main.B--;
						System.out.printf("%33s %d, Expected wait time %d Seconds\n","Ticket No", total, 30/Main.C); //wait time = MaxServiceTime/number of ServicePoints
					}
				}
			}
		}
	}
	

}
