package multiple;

import java.util.Scanner ;

// Half-duplex ?
public class User  implements Runnable{
	
	Thread targetThread ;
	String userName ;
	String message ;
	User target ;
	
	public User(String userName) {
		
		this.userName = userName ;
	}
	
	public void probuctTarget(User target){
		targetThread = new Thread(target) ;
		this.target = target ;
	}
	
	public void printMessage(String message){
		System.out.println(userName + " : " + message) ;
	}

	@Override
	public void run() {
		
		try (Scanner input = new Scanner(System.in)) {
			
			System.out.println("Enter message or \"q\" to quit ") ;
				
			while(true){
				
				System.out.println(userName + " is typing message : ") ;
				
				message = input.nextLine() ;
				
				if (message == "q") {
					break ;
				}else{
					printMessage(message) ;
				}
				
				//System.out.println("Waiting for reply ") ;
			}
		}
		  //catch (InterruptedException e) {
			//e.printStackTrace() ;
		//}
		
	}
}
