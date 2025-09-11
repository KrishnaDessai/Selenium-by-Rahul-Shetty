
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LearningArraylist {

	public static void main(String[] args) {
		ArrayList<String> a= new ArrayList<String>();
		
		a.add("selenium");
		a.add("java");
		a.add("Rahul");
		a.add("Academy");
		
		System.out.println(a.get(0));
		System.out.println("****************");
		for(String arr: a) {
			System.out.println(arr);
		}
		
		System.out.println("****************");
		for(int i=0;i<a.size();i++) {
			System.out.println(a.get(i));
		}
		
		System.out.println("****************");
		System.out.println(a.contains("Rahul"));
		System.out.println("****************");
//		******************************
		String name[]= {"Krishna","Sandeep","Dessai"};
//		converting normal array to array list
		List<String> nameArrayList = Arrays.asList(name);
		System.out.println(nameArrayList.contains("Sandeep"));
	}

}
