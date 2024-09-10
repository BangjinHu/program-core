package design.proxy.impl;

import design.proxy.Image;

public class ProxyImage implements Image {
    private final String fileName;
    //在内部需要一个真实实现类
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
