package chapter03;

public class SongTest {

	public static void main(String[] args) {
		Song song01 = new Song("좋은날", "아이유", "real", "이민수", 3, 2010); //객체 생성 - 생성자를 이용한 초기화
		
		//setter를 이용한 생성자 초기화 
//		song01.setTitle("좋은날");
//		song01.setArtist("아이유");
//		song01.setAlbum("real");
//		song01.setComposer("이민수");
//		song01.setTrack(3);
//		song01.setYear(2010);		
		song01.show();
		
		Song song02 = new Song("Ditto", "New Jeans"); //필요한 값만 쓴 생성자 
		song02.show();

	}

}
