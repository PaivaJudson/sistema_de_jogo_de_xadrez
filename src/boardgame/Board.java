package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece [][] pieces;

    public Board(int rows, int columns) {
        if (rows <1 || columns < 1){
            throw new BoardException("Erro na criação de Tabuleiro: É necesssário que haja pelo menos uma linha ou coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int colum){
        if (!positionExists(row, colum)){
            throw new BoardException("Posicao não existe ");
        }
        return pieces[row][colum];
    }

    public Piece piece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Posicao não existe no tabuleiro");
        }
        return  pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if (thereIsAPiece(position)){
            throw new BoardException("Já existe uma peça nessa posição");
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >=0 && column < columns;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Posicao não existe no tabuleiro");
        }
        return piece(position) != null;
    }

}
