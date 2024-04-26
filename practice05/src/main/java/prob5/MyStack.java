package prob5;

public class MyStack {
	
	//string이 들어오면 
	//push()를 만들어서 넣고
	//top++ -> top=0에서 top=1 ? 
	//버퍼사이즈3이니까 초과될 시 push를 다시 호출하기 전
	//사이즈 체크 필요 -> buffer.legth로 확인가능
	//resize()라는 메서드를 통해 버퍼의 크기를 늘려줌(2배, 3배 등 자체선택)
	//tmp = new String[size*2]를 한 후, tmp = 6개가 잡힐거고, 기존 버퍼에 있는 값은 복사시켜야함.
	//buffer = tmp;
	//처음에 있는 3사이즈 buffer는 날리고 
	//배열로 스택을 구현하면 리사이즈는 알아서 해야함?
	//isEmpty()체크 
	//top = -1 -> empty(), pop() -> 젤 위에 있는 값 꺼내기 
	// 
}