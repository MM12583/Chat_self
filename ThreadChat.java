package multiple;

public class ThreadChat {

	public static void main(String[] args) {
		
		User George = new User("George") ;
		User Marry = new User("Marry") ;
		
		George.probuctTarget(Marry) ;
		Marry.probuctTarget(George) ;
		
		Thread session1 = new Thread(George) ;
		Thread session2 = new Thread(Marry) ;
		
		session1.start() ;
		session2.start() ;
		
	}
}

