package entities;

import java.util.ArrayList;

public class RootNode extends Node{

	public RootNode(String name) {
		super(name, "Genres");
	}

	public void addCDTitle(String cdTitle, String artist, String genre){
		addChild(genre, "Artists");
		getChild(genre).addChild(artist, "CDs");
		getChild(genre).getChild(artist).addChild(cdTitle, "");
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
		
		return new Node("", "");
	}
	
	public Node getCDTitles(String artist){
		for(Node gen: children){
			for(Node art: gen.getChildren()){
				if(art.getName().equals(artist)){
					return art;
				}
			}
		}
		
		return new Node("", "");
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
	
	public Node getParent(String str, String category){
		if(category.equals("Artists")){
			return this;
		}
		else if(category.equals("CDs")){
			for(Node genre: this.getChildren()){
				for(Node artist: genre.getChildren()){
					for(Node cd: artist.getChildren()){
						if(cd.getName().equals(str)){
							return genre;
						}	
					}
				}
			}
		}
		else if(category.equals("")){
			for(Node genre: this.getChildren()){
				for(Node artist: genre.getChildren()){
					for(Node cd: artist.getChildren()){
						if(cd.getName().equals(str)){
							return artist;
						}	
					}
				}
			}
		}
		return null;
	}
	
	public ArrayList<Node> getAllCDs(){
		ArrayList<Node> allCds = new ArrayList<Node>();
		
		for(Node genre: this.getChildren()){
			for(Node artist: genre.getChildren()){
				allCds.addAll(artist.getChildren());
			}
		}
		
		return allCds;
	}
	
	public String getArtist(String cd){
		for(Node genre: this.getChildren()){
			for(Node artist: genre.getChildren()){
				for(Node cdNode: artist.getChildren()){
					if(cdNode.getName().equals(cd)){
						return artist.getName();
					}
				}
			}
		}
		
		return null;
	}
	
	public String getGenre(String artist){
		for(Node genre: this.getChildren()){
			for(Node artistNode: genre.getChildren()){
				if(artistNode.getName().equals(artist)){
					return genre.getName();
				}
			}
		}
		
		return null;
	}
}
