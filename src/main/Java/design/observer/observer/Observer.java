package design.observer.observer;

import design.observer.entity.Subject;

public abstract class Observer {

    protected Subject subject;

    public abstract void update();
    
}
