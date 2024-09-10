package design.builder.impl;

import design.builder.Packing;

public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "wrapper";
    }
}
