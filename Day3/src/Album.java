public class Album extends Music implements PlatinumSelling {

	String albumName;
	boolean award;
	boolean platinum;

	public Album() {
		super();
	}

	public Album(String name, String artist) {
		setName(name);
		setArtist(artist);
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public Type getType() {
		return genre;
	}

	@Override
	public boolean checkAward() {
		// TODO Auto-generated method stub
		return this.award;

	}

	@Override
	public void setAward(boolean award) {
		// TODO Auto-generated method stub
		this.award = award;

	}

	@Override
	public void setPlatinum(boolean platinum) {
		// TODO Auto-generated method stub
		this.platinum = platinum;
	}

	@Override
	public boolean checkPlatinum() {
		// TODO Auto-generated method stub
		return platinum;
	}

	public void setName(String name) {
		this.albumName = name;
	}

}
