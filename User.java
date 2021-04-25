package multiple;

import java.util.Scanner ;

// Half-duplex 
public class User  implements Runnable{
	
	Thread chatTarget ;
	String userName ;
	String message ;
	
	public User(String userName , User chatTarget) {
		this.userName = userName ;
		this.chatTarget = new Thread(chatTarget) ;
	}
	
	@Override
	public void run() {
		
		try (Scanner input = new Scanner(System.in)) {
			
			System.out.print("Enter message or \"q\" to quit ") ;
			
			while(input.hasNextLine()){
				
				System.out.print("message : ") ;
				message = input.nextLine() ;
				
				if (input.nextLine() == "q") {
					break ;
				}
				
				System.out.println("Waiting for reply ") ;
				chatTarget.join() ;
				
			}
			
			
		} catch (InterruptedException e) {
			e.printStackTrace() ;
		}
		
	}

	

}
