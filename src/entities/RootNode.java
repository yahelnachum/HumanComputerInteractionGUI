package entities;

import java.util.ArrayList;
import java.util.Collections;

public class RootNode extends Node{

	public RootNode(String name) {
		super(name);
	}

	public void addCDTitle(String cdTitle, String artist, String genre){
		addChild(genre);
		getChild(genre).addChild(artist);
		getChild(genre).getChild(artist).addChild(cdTitle);
	}
	
	public Node getGenres(){
		return this;
	}
	
	public Node getArtists(String genre){
		for(Node gen: children){
			if(gen.getName().equals(genre)){
				return gen;
			}
		}
		
		return new Node("");
	}
	
	public Node getCDTitles(String artist){
		for(Node gen: children){
			for(Node art: gen.getChildren()){
				if(art.getName().equals(artist)){
					return art;
				}
			}
		}
		
		return new Node("");
	}
	
	public void sortEverything(){
		for(Node genre: children){
			for(Node artist: genre.getChildren()){
				artist.sortChildren();
			}
			
			genre.sortChildren();
		}
		
		this.sortChildren();
	}
}
