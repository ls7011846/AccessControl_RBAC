package test;

import java.util.ArrayList;
import java.util.List;

public class test3 {
public static void main(String[] args) {
	List<String> list=new ArrayList<String>();
	list.add("2产品经理");
	list.add("2");
	boolean index=list.contains("2");
	System.out.println(index);
}
}
