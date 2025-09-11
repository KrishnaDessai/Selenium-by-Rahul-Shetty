
public class StringObject {

	public static void main(String[] args) {
     //	string is an object that represent sequence of character
		
		//1.string literal- if ur having same data in multiple string object it won't create new memory allocation space for that object
		
		String s="Hello Krishna";
		String s2="Hello Krishna";
		
		
        //	2.using "new" Keyword -it will always create memory space 
		
		String s3= new String("welcome");
		String s4= new String("welcome");
		

		String s5= "Rahul shetty Academy";
		String [] splitedString = s5.split("shetty");
		
		System.out.println(splitedString[0]);
		System.out.println(splitedString[1]);
		System.out.println(splitedString[1].trim());
		
		for(int i=0;i<s5.length();i++ ) {
			System.out.println(s5.charAt(i));
		}
		
		
		//reverse string
		for(int i=s5.length()-1; i>=0;i--) {
			System.out.println(s5.charAt(i));
		}

	}

}
