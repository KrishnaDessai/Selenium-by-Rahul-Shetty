
public class CoreJavaBrushUp {

	public static void main(String[] args) {
		int arr[]= {1,5,3,7,3};
		String [] name= {"krishna","Anup","varun","Akshay"};
		
//		for(int i=0;i<5;i++) {
//		
//		System.out.println(arr[i]);
//		}
		
		for (int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		//enhanced for loop
		for(String s :name) {
			System.out.println(s);
		}
	}

}
