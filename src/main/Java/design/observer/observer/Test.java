package design.observer.observer;

import design.observer.entity.Subject;
import design.observer.observer.impl.BinaryObserver;
import design.observer.observer.impl.HexaObserver;
import design.observer.observer.impl.OctalObserver;

public class Test {

    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("\n===========================\n");
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
