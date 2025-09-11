//video 115
package streamInJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {
	
	@Test
	public void regular() {
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Ganesh");
		names.add("Ram");
		names.add("Krishna");
		names.add("Shankar");
		names.add("Vishnu");
		int count=0;
		
		for(String name:names) {
//			String actual= name;
			if(name.startsWith("G")) {
				count++;
			}
		}
		System.out.println(count);
		
		
	}

	@Test
	public void streamFilter() {
		ArrayList<String> names= new ArrayList<String>();
		names.add("Anup");
		names.add("akshay");
		names.add("varun");
		names.add("Mayank");
		names.add("Maithili");
		
//		int streamCount= (int) names.stream().filter(name->name.toLowerCase().startsWith("a")).count();
//		System.out.println("Stream "+streamCount);
		
		int streamCount = (int)Stream.of("Anup","akshay","varun","Mayank","Maithili").filter(name->
		name.toLowerCase().startsWith("a")).count();
        System.out.println(streamCount);
//      names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(2).forEach(s->System.out.println(s));
		
	}
	
	@Test
	public void streamMap() {
		ArrayList<String> name= new ArrayList<String>();
		name.add("Samarth");
		name.add("Sartak");
		name.add("Daksh");
		name.add("Devang");
		
		Stream.of("Anup","Shravani","varun","Mayank","Maithili").filter(s-> s.endsWith("i")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		//Array to arraylist
		List <String> name1= Arrays.asList("Anup","akshay","varun","Mayank","Maithili");
		name.stream().filter(s->s.startsWith("M")).sorted().map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		Stream<String>newStream=Stream.concat(name.stream(), name1.stream());
//		newStream.sorted().forEach(s->System.out.println(" newStream: "+s));
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Anup"));
		System.out.println(flag);
		Assert.assertTrue(flag,"string not present");
		
	}
	
	@Test
	public void streamCollect() {
		
		List<String> ls= Stream.of("Anup","Shravani","varun","Mayank","Maithili").filter(s->s.endsWith("i")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
//		List<Integer> values = Stream.of(1,2,2,3,4,5,5).distinct().collect(Collectors.toList());
//		System.out.println(values);
//		OR
		List <Integer>values=Arrays.asList(8,6,2,3,4,5,5,1,5,4,9);
		values.stream().distinct().forEach(s->System.out.println(s));
		
		List<Integer> li=values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("Third value is :"+li.get(2));
		
		
		
	}
	
	public static void main(String[] args) {

	
		test1 t1= new test1();
		t1.regular();
		t1.streamFilter();
		t1.streamMap();
		t1.streamCollect();
		
	}

}
