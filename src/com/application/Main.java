package com.application;

import boardgame.Board;
import boardgame.Position;

public class Main {

    public static void main(String[] args) {

        Board board = new Board(5, 5);
        System.out.println(board.getColumns());

    }
}
