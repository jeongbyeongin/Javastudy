
public class MainClass3 {
	public static void main(String[] args) {
		
		
		String s1 = "A" + "B"; // "AB"
		
	
	// 문자 ; char ch = 'A';
	// 문자열 ; String s = "ABC";
	String s = "A";
	String s2 = "";
	
	String s3 = "A" + "B"; // "AB"; (A + B) X
	// "" + 7 -> "" + "7" -> "7";
	//   숫자       - >     문자열
	// "" + 7 + 7 -> "7" + 7 -> "7" + "7" -> "77"
	// 7+7+"" ->  14+"" ->  "14" + "" -> "14"
	
	char ch = 'A';
	int i = 'A';
	
	String str = "";
	String str2 = "ABCD";
	String str3 = "123";
	String str4 = str2 +str3;
	
	
	System.out.println("" + 7+7);
	System.out.println(7+7+"");
	
	}
	
	

}

