package chapter03;

public class Song {
	
	private String title;
	private String artist;
	private String album;
	private String composer;
	private int year;
	private String track;
	
	public Song(String title, String artist, String composer, String album, int year, String track) {
		this.title = title;
		this.artist = artist;
		this.composer = composer;
		this.album = album;
		this.year = year;
		this.track = track;
		//some code...
		
	}
	public Song(String title, String artist) {
	//	this.title = title;
	//	this.artist = artist;
		//some code...
		
		this(title, artist, null, null, 0, null);
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	

	public void show() {
		System.out.println(artist+title+"("+album+", "+composer+", "+year+", "+track+")");
		
	}

}
