package ex04_builder;

public class MainClass {

	public static void main(String[] age) {
		
		User user = User.builder()
						 .id("admin")
						 .pw("123456")
						 .Build();
		
		System.out.println(user);
		  
				
	}
	
}
