package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Field> fields = new ArrayList<>();

    public void initializeFields() {
        fields.add(new Field(State.EMPTY, 3));
        fields.add(new Field(State.EMPTY, 2));
        fields.add(new Field(State.EMPTY, 3));
        fields.add(new Field(State.EMPTY, 2));
        fields.add(new Field(State.EMPTY, 4));
        fields.add(new Field(State.EMPTY, 2));
        fields.add(new Field(State.EMPTY, 3));
        fields.add(new Field(State.EMPTY, 2));
        fields.add(new Field(State.EMPTY, 3));
    }

    public int calculateGameState(State player) {
        int state = 0;
        State opponentRole = player == State.CROSS ? State.CIRCLE : State.CROSS;
        for (Field field : fields) {
            if (field.getState() == player) {
                state = state + field.getValue();
            }
            if (field.getState() == opponentRole) {
                state = state - field.getValue();
            }
        }
        return state;
    }

    public Node createStateTree(State currentPlayer, int depth) {
        System.out.println("Creating Tree...");
        Node currentNode = new Node(this);
        currentNode.populateNode(currentPlayer, 3, 0);
        return currentNode;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
