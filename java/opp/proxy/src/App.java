
interface ISubject {
    void action();
}

class RealSubject implements ISubject {
    public void action() {
        System.out.println("원본 객체 액션 !!");
    }
}

class Proxy implements ISubject {
    private RealSubject subject; // 대상 객체를 composition

    Proxy(RealSubject subject) {
        this.subject = subject;
    }

    public void action() {
        subject.action(); // 위임
        /* do something */
        System.out.println("프록시 객체 액션 !!");
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        ISubject sub = new Proxy(new RealSubject());
        sub.action();

    }
}
