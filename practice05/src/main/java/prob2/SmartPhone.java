package prob2;

public class SmartPhone extends MusicPhone {
	@Override
	public void execute(String function) {
		if(function.equals("앱")) {
			runApp();
			return;
		}
		super.execute(function);
	}
	
	@Override
	public void playMusic() {
		System.out.println("다운로드해서 음악 재생");
	}
	
	public void runApp() {
		System.out.println("앱실행");
	}
}
