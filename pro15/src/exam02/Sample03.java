package exam02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

public class Sample03 {
public static void main(String[] args) {
	
	Set<Integer> hashSet = new HashSet<Integer>();
	Set<Integer> linkedSet = new LinkedHashSet<Integer>();
	Set<Integer> treeSet = new TreeSet<Integer>();
	
	hashSet.add(300); hashSet.add(900); hashSet.add(500);
	hashSet.add(400); hashSet.add(100); hashSet.add(700);
	hashSet.add(200); hashSet.add(600); hashSet.add(800);
	
	linkedSet.add(300); linkedSet.add(900); linkedSet.add(500);
	linkedSet.add(400); linkedSet.add(100); linkedSet.add(700);
	linkedSet.add(200); linkedSet.add(600); linkedSet.add(800);
	
	treeSet.add(300); treeSet.add(900); treeSet.add(500);
	treeSet.add(400); treeSet.add(100); treeSet.add(700);
	treeSet.add(200); treeSet.add(600); treeSet.add(800);
	
	System.out.println(hashSet);
	System.out.println(linkedSet);
	System.out.println(treeSet);
	
	Iterator<Integer> iter = hashSet.iterator();
	while (iter.hasNext()) {
		System.out.print(iter.next() + "\t");
	}
	System.out.println();
	
	ListIterator<Integer> lter = (new ArrayList<Integer>(hashSet)).listIterator(hashSet.size());
	while (lter.hasPrevious()) {
		System.out.print(lter.previous() + "\t");
	}
	System.out.println();
	
}
}
