package design.observer.entity;

import design.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    //保存观察者
    private final List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    //这里表示数据变更，通知各个观察者
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();//通知
    }

    public void attach(Observer observer) {
        observers.add(observer);      //注册订阅者
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();//通知所有订阅者
        }
    }
}
