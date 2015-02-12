public class Song extends Album {

	String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Song(String songName, String albumName, String artistName) {
		super(albumName, artistName);
		setTitle(songName);

	}

}
