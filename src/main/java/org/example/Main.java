package org.example;

import org.example.model.Board;
import org.example.model.State;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.initializeFields();
        System.out.println(board.createStateTree(State.CROSS, 2));
    }
}