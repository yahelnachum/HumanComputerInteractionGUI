package entities;

import java.util.ArrayList;
import java.util.Collections;

public class Node implements Comparable<Node>{

	String name;
	String childrensLevel;
	ArrayList<Node> children = new ArrayList<Node>();

	public Node(String name, String childrensLevel){
		this.name = name;
		this.childrensLevel = childrensLevel;
	}
	
	public boolean hasChild(String name){
		for(Node child: children){
			if(child.getName().equals(name)){
				return true;
			}
		}
		
		return false;
	}
	
	public void addChild(String name, String childrensString){
		if(!hasChild(name)){
			Node newNode = new Node(name, childrensString);
			children.add(newNode);
		}
	}
	
	public Node getChild(String name){
		for(Node child: children){
			if(child.getName().equals(name)){
				return child;
			}
		}
		
		return new Node("", "");
	}
	
	public ArrayList<Node> getChildren(){
		return children;
	}
	
	public ArrayList<String> getChildrenAsString(){
		ArrayList<String> list = new ArrayList<String>();
		for(Node n: children){
			list.add(n.name);
		}
		return list;
	}
	
	public String getName(){
		return name;
	}

	@Override
	public int compareTo(Node n) {
		return name.compareTo(n.getName());
	}
	
	public void sortChildren(){
		Collections.sort(children);
	}
	
	public String toString(){
		return name;
	}
	
	public String childrenToString(){
		String str = "";
		
		for(Node child: children){
			str += child.toString() + '\n';
		}
		
		return str;
	}
	
	public String getChildrensLevel(){
		return childrensLevel;
	}
}
