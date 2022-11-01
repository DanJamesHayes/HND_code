/*
 * Move
 * 
 * Version 0.2
 *
 * Created by Daniel Hayes 01/12/2018
 *
 * Creative Commons Fair Use
 */
package TribalChess_v02;

import javax.swing.JOptionPane;

/**
 * Checks if moves passed by user interface are valid and adjusts board array
 * Keeps a record of last move made for en passant purposes
 * @author Daniel Hayes
 * @version 0.2
 * @since 4/12/18
 */
public class Move {
    
    // Int to record the current move to be taken
    static int moveCount = 1;
    // String to record the last move made for en passant
    static String lastMove = "";
    
    
    /**
     * Method to alter the board array accordingly is passed move is valid
     * @param move 
     */
    public static void makeMove(String move) {
        
        // Ints to hold the row and column of the piece to be moved
        int row, column;
        // String to hold the list of possible moves for the piece to be moved
        String possibleMoves = "";
        
        // Check if castling, pawn promotion, or other is attempted and derive
        // the starting row and column from the appropriate dragMove format
        switch (move.charAt(4)) {
            case 'E':
                row = 1;
                column = Integer.valueOf(move.substring(0,1));
                break;
            case 'e':
                row = 6;
                column = Integer.valueOf(move.substring(0,1));
                break;
            case 'C':
                row = 7;
                column = Integer.valueOf(move.substring(3,4));
                break;
            case 'c':
                row = 0;
                column = Integer.valueOf(move.substring(3,4));
                break;
            default:
                row = Integer.valueOf(move.substring(0,1));
                column = Integer.valueOf(move.substring(1,2));
                break;
        }
        
        // If whites turn, determin what piece is trying to move and return the
        // list of possible moves for that piece
        if(moveCount%2 != 0){
            switch (Board.layout[row][column]){
                    case "P": 
                        possibleMoves=Pawn.possibleMovesWhite(row, column);
                        break;
                    case "R":
                        possibleMoves=Rook.possibleMovesWhite(row, column);
                        break;
                    case "K":
                        possibleMoves=Knight.possibleMovesWhite(row, column);
                        break;
                    case "B":
                        possibleMoves=Bishop.possibleMovesWhite(row, column);
                        break;
                    case "Q":
                        possibleMoves=Queen.possibleMovesWhite(row, column);
                        break;
                    case "A":
                        possibleMoves=King.possibleMovesWhite(row, column);
                        break;
            }
        // else blacks turn, determin what piece is trying to move and return 
        // the list of possible moves for that piece
        }else{
            switch (Board.layout[row][column]){
                    case "p": 
                        possibleMoves=Pawn.possibleMovesBlack(row, column);
                        break;
                    case "r":
                        possibleMoves=Rook.possibleMovesBlack(row, column);
                        break;
                    case "k":
                        possibleMoves=Knight.possibleMovesBlack(row, column);
                        break;
                    case "b":
                        possibleMoves=Bishop.possibleMovesBlack(row, column);
                        break;
                    case "q":
                        possibleMoves=Queen.possibleMovesBlack(row, column);
                        break;
                    case "a":
                        possibleMoves=King.possibleMovesBlack(row, column);
                        break;
            }
        }
        
        // Create strings for the options and choice of piece for a pop up
        // window in the event of pawn promotion
        String options[] = {"Queen", "Rook", "Knight", "Bishop"};
        String choice;
        
        // Check if move is valid by checking if move is in the list of possible
        // moves generated
        if(possibleMoves.replaceAll(move, "").length()<possibleMoves.length()){
            // Pawn promotion black
            switch (move.charAt(4)) {
                case 'e':
                    choice = (String) JOptionPane.showInputDialog(null,
                            "Choose a piece...", "Pawn Promotion", 
                            JOptionPane.QUESTION_MESSAGE, null, options,
                            options[0]);
                    switch (choice){
                        case "Queen":
                            Board.layout[6]
                                [Character.getNumericValue(move.charAt(0))]=" ";
                            Board.layout[7]
                                [Character.getNumericValue(move.charAt(1))]="q";
                            break;
                        case "Rook":
                            Board.layout[6]
                                [Character.getNumericValue(move.charAt(0))]=" ";
                            Board.layout[7]
                                [Character.getNumericValue(move.charAt(1))]="r";
                            break;
                        case "Knight":
                            Board.layout[6]
                                [Character.getNumericValue(move.charAt(0))]=" ";
                            Board.layout[7]
                                [Character.getNumericValue(move.charAt(1))]="k";
                            break;
                        case "Bishop":
                            Board.layout[6]
                                [Character.getNumericValue(move.charAt(0))]=" ";
                            Board.layout[7]
                                [Character.getNumericValue(move.charAt(1))]="b";
                            break;
                    }
                    moveCount++;
                    break;
                // Pawn promotion white
                case 'E':
                    choice = (String) JOptionPane.showInputDialog(null,
                            "Choose a piece...", "Pawn Promotion", 
                            JOptionPane.QUESTION_MESSAGE, null, options,
                            options[0]);
                    switch (choice){
                        case "Queen":
                            Board.layout[1]
                                [Character.getNumericValue(move.charAt(0))]=" ";
                            Board.layout[0]
                                [Character.getNumericValue(move.charAt(1))]="Q";
                            break;
                        case "Rook":
                            Board.layout[1]
                                [Character.getNumericValue(move.charAt(0))]=" ";
                            Board.layout[0]
                                [Character.getNumericValue(move.charAt(1))]="R";
                            break;
                        case "Knight":
                            Board.layout[1]
                                [Character.getNumericValue(move.charAt(0))]=" ";
                            Board.layout[0]
                                [Character.getNumericValue(move.charAt(1))]="K";
                            break;
                        case "Bishop":
                            Board.layout[1]
                                [Character.getNumericValue(move.charAt(0))]=" ";
                            Board.layout[0]
                                [Character.getNumericValue(move.charAt(1))]="B";
                            break;
                    }
                    moveCount++;
                    break;
                // Castling white
                case 'C':
                    Board.layout[7]
                            [Character.getNumericValue(move.charAt(0))]=" ";
                    Board.layout[7]
                            [Character.getNumericValue(move.charAt(1))]="A";
                    Board.layout[7]
                            [Character.getNumericValue(move.charAt(2))]="R";
                    Board.layout[7]
                            [Character.getNumericValue(move.charAt(3))]=" ";
                    moveCount++;
                    break;
                // Castling black
                case 'c':
                    Board.layout[0]
                            [Character.getNumericValue(move.charAt(0))]=" ";
                    Board.layout[0]
                            [Character.getNumericValue(move.charAt(1))]="a";
                    Board.layout[0]
                            [Character.getNumericValue(move.charAt(2))]="r";
                    Board.layout[0]
                            [Character.getNumericValue(move.charAt(3))]=" ";
                    moveCount++;
                    break;
                // En passant white
                case 'N':
                    Board.layout[3]
                            [Character.getNumericValue(move.charAt(1))]=" ";
                    Board.layout[3]
                            [Character.getNumericValue(move.charAt(3))]=" ";
                    Board.layout[2]
                            [Character.getNumericValue(move.charAt(3))]="P";
                    moveCount++;
                    break;
                // En passant black
                case 'n':
                    Board.layout[4]
                            [Character.getNumericValue(move.charAt(1))]=" ";
                    Board.layout[4]
                            [Character.getNumericValue(move.charAt(3))]=" ";
                    Board.layout[5]
                            [Character.getNumericValue(move.charAt(3))]="p";
                    moveCount++;
                    break;
                // Any standard move
                default:
                    Board.layout[Character.getNumericValue(move.charAt(2))]
                            [Character.getNumericValue(move.charAt(3))]
                            =Board.layout[Character.getNumericValue(move
                                    .charAt(0))]
                            [Character.getNumericValue(move.charAt(1))];
                    Board.layout[Character.getNumericValue(move.charAt(0))]
                            [Character.getNumericValue(move.charAt(1))]=" ";
                    moveCount++;
                    break;
            }
            // Update boolean if either white rook or white king has moved
            if(row == 7){
                switch (column) {
                    case 0:
                        Rook.rook1MovedWhite = true;
                        break;
                    case 4:
                        King.kingMovedWhite = true;
                        break;
                    case 7:
                        Rook.rook2MovedWhite = true;
                        break;
                    default:
                        break;
                }
            }
            // Update boolean if either black rook or black king has moved
            if(row == 0){
                switch (column) {
                    case 0:
                        Rook.rook1MovedBlack = true;
                        break;
                    case 4:
                        King.kingMovedBlack = true;
                        break;
                    case 7:
                        Rook.rook2MovedBlack = true;
                        break;
                    default:
                        break;
                }
            }
            // Update last moveMove string with move just made
            lastMove = move;
        }
    }
}