package practice03;

public class Song {
	private String title; //노래 제목
	private String artist; //가수
	private String album; //앨범 제목
	private String composer; //작곡가
	private int year; //발표 연도
	private int track; //앨범 트랙 번호
	
	//오버로딩한 생성자(모든 song의 정보를 가져서 생성하던지, 필요한 정보만 가져와서 생성하던지 - 다형성)
	//방식은 같지만 시그니처만 다르게 생성자의 오버로딩한 케이스
	public Song(String title, String artist) {
		this(title, artist, "", "", 0, 0); //자기 자신 생성자 호출
	}
	
	//처음 생성한 생성자는 기본 생성자였지만, 이제는 파라미터 값들이 필요한 생성자를 만듦. 
	public Song(String title, String artist, String album, String composer, int year, int track) {
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.composer = composer;
		this.year = year;
		this.track = track;
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
	public int getTrack() {
		return track;
	}
	
	public void setTrack(int track) {
		this.track = track;
		//객체가 생성되는 런타임 때 어떤 메소드를 생성(m())한다고 가정하면, 
		//메서드는 동적 -> 객체가 생성된 후 실행되므로 생성된 객체를 참조하고자 하면
		//레퍼런싱을 가지고 있는건 프로그램 밖에 있을테니,
		//자기 자신을 참조하고 싶을 때 this를 내장시켜 자기 자신을 코드 내부에서 참조하고 싶을 때(참조 변수를 알 수 없는 걸 해결) 사용된다
		//실행되는 객체가 있을 때 그걸 내부에서 참조하고자 할 때 사용되는 키워드
		//= 런타임때 생성된 객체를 참조하는 키워드(자기자신)
	}
	
	
	public void show() {
		System.out.println(artist + " " + title + " " + 
	                       "( " + album + ", " + year + 
	                       ", " + track + "번 track, " + composer + "작곡 )"); 
							//this.artist로 불러도 되긴함
	}

}
