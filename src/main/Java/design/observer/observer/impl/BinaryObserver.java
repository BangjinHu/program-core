package design.observer.observer.impl;

import design.observer.entity.Subject;
import design.observer.observer.Observer;

public class BinaryObserver extends Observer {
    
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: "
                + Integer.toBinaryString(subject.getState()));
    }
}
