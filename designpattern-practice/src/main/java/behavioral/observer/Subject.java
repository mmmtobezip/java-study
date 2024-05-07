package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject<T> {
  private T val;
  private List<Observer<T>> observerCollection = new ArrayList<>(); // val값을 감시하는

  // observer를 감시하는?
  public void registerObserver(Observer<T> observer) {
    observerCollection.add(observer);
  }

  // registerObserver의 반대 역할
  public void unregisterObser(Observer<T> observer) {
    observerCollection.remove(observer);
  }

  public void changeSubject(T val) {
    this.val = val; // 클라이언트와 subject를 만들고 val 값이 업데이트 되는
    notifyObservers();
  }

  // changeSubject에서 값이 변경되었을 때 observerCollection의 값을 update하는 알림용
  private void notifyObservers() {
    for (Observer<T> observer : observerCollection) {
      observer.update(val);
    }
  }

  // 등록하면서 익명의 클래스로 observer를 생성함.



}
