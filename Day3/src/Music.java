public abstract class Music implements AwardWinning {

	static Type genre = Type.NOTYPE;
	 String artist = "";

	public Music() {
		super();
	}

	public enum Type {
		CLASSICAL, HIPHOP, ROCK, NOTYPE;
	}

	public void setType(Type type) {
		this.genre = type;
	}

	public abstract Type getType();

	public abstract void setArtist(String artist);
}
