package org.example.model;

public class Field {
    private State state;
    private int value;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Field(State state, int value) {
        this.state = state;
        this.value = value;
    }

    public Field() {

    }
}
