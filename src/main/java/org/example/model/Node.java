package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private Board board;
    private List<Node> nodes = new ArrayList<>();


    public void populateNode(State currentPlayer, int depth, int currentDepth) {
        System.out.println("Populating nodes...");
        List<Board> blackList = new ArrayList<>();
        int thisDepth = currentDepth + 1;
        while(thisDepth <= depth) {
            for (int i = 0; i < 9 - currentDepth; i++){
                nodes.add(new Node());
            }
            for (Node node : this.getNodes()) {
                System.out.println("Populating node: " + node + "...");
                Board tempBoard = node.simulateMoves(currentPlayer, blackList);
                blackList.add(tempBoard);
                node.setBoard(tempBoard);
                node.populateNode(currentPlayer, depth - 1, thisDepth);
            }
        }
        System.out.println("Done populating");
    }

    public Board simulateMoves(State currentPlayer, List<Board> blackList) {
        System.out.println("Simulating moves...");
        for (Node node : this.nodes){
            Board newBoard = node.getBoard();
            for (Field field : newBoard.getFields()){
                if (field.getState() == State.EMPTY){
                    field.setState(currentPlayer);
                    if (!blackList.contains(node.getBoard())){
                        return node.getBoard();
                    }
                }
            }
        }
        return null;
    }


    public Node(Board board) {
        this.board = board;
    }

    public Node() {}
    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
