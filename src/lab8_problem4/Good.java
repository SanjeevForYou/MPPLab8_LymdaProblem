package lab8_problem4;

import java.util.ArrayList;
import java.util.List;

public class Good {

	public long countWords(List<String> words, char c, char d, int len)
	{
		long count = words.stream()
				.filter(w -> w.length()==len)
				.filter(w -> w.contains("" + c))
				.filter(w -> !(w.contains("" + d))).count();
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Good gd = new Good();
		List<String> strList = new ArrayList<String>();
		strList.add("Joe is human");
		strList.add("Cat is a pet animal");
		strList.add("San chief ee");  //valid
		
		long count = gd.countWords(strList, 'c', 'd', 12);
		System.out.println("Count is :"+count);
	}

}
