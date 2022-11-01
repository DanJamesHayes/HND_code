/*
 * Rook
 * 
 * Version 0.2
 *
 * Created by Daniel Hayes 01/12/2018
 *
 * Creative Commons Fair Use
 */
package TribalChess_v02;

/**
 * Creates list of all possible moves by rooks also monitors if rooks are
 * unmoved for castling purposes
 * @author Daniel Hayes
 * @version 0.2
 * @since 4/12/18
 */
public class Rook {
    
    // Booleans used to record if each rook is yet to move for the purpose of
    // castling
    static boolean rook1MovedWhite = false;
    static boolean rook2MovedWhite = false;
    static boolean rook1MovedBlack = false;
    static boolean rook2MovedBlack = false;
    
    /**
     * Method to calculate the list of all possible moves by the white rook in 
     * the position of the passed arguments
     * @param r integer that represent the row the rook is in
     * @param c integer that represent the column the rook is in
     * @return a list of all possible moves by the rook specified
     */
    public static String possibleMovesWhite(int r, int c) {
        String list="", oldPiece;
        int temp=1;
        for (int j=-1; j<=1; j+=2) {
            try {
                // Moves to unnoccupied postions forwards and backwards
                while(" ".equals(Board.layout[r][c+temp*j]))
                {
                    oldPiece=Board.layout[r][c+temp*j];
                    Board.layout[r][c]=" ";
                    Board.layout[r][c+temp*j]="R";
                    if (Board.kingSafeWhite()) {
                        list=list+r+c+r+(c+temp*j)+oldPiece;
                    }
                    Board.layout[r][c]="R";
                    Board.layout[r][c+temp*j]=oldPiece;
                    temp++;
                }
                // Capture moves forwards and backwards
                if(Character.isLowerCase(Board.layout[r][c+temp*j].charAt(0))) {
                    oldPiece=Board.layout[r][c+temp*j];
                    Board.layout[r][c]=" ";
                    Board.layout[r][c+temp*j]="R";
                    if (Board.kingSafeWhite()) {
                        list=list+r+c+r+(c+temp*j)+oldPiece;
                    }
                    Board.layout[r][c]="R";
                    Board.layout[r][c+temp*j]=oldPiece;
                }
            } catch (Exception e) {
            }
            temp=1;
            try {
                // Moves to unoccuppied positions sideways
                while(" ".equals(Board.layout[r+temp*j][c]))
                {
                    oldPiece=Board.layout[r+temp*j][c];
                    Board.layout[r][c]=" ";
                    Board.layout[r+temp*j][c]="R";
                    if (Board.kingSafeWhite()) {
                        list=list+r+c+(r+temp*j)+c+oldPiece;
                    }
                    Board.layout[r][c]="R";
                    Board.layout[r+temp*j][c]=oldPiece;
                    temp++;
                }
                // Capture moves sideways
                if(Character.isLowerCase(Board.layout[r+temp*j][c].charAt(0))) {
                    oldPiece=Board.layout[r+temp*j][c];
                    Board.layout[r][c]=" ";
                    Board.layout[r+temp*j][c]="R";
                    if (Board.kingSafeWhite()) {
                        list=list+r+c+(r+temp*j)+c+oldPiece;
                    }
                    Board.layout[r][c]="R";
                    Board.layout[r+temp*j][c]=oldPiece;
                }
            } catch (Exception e) {
            }
            temp=1;
        }
        return list;
    }
    
    /**
     * Method to calculate the list of all possible moves by the black rook in 
     * the position of the passed arguments
     * @param r integer that represent the row the rook is in
     * @param c integer that represent the column the rook is in
     * @return a list of all possible moves by the rook specified
     */
    public static String possibleMovesBlack(int r, int c) {
        String list="", oldPiece;
        int temp=1;
        for(int j=-1; j<=1; j+=2) {
            try {
                // Moves to unoccupied positions forwards and backwards
                while(" ".equals(Board.layout[r][c+temp*j]))
                {
                    oldPiece=Board.layout[r][c+temp*j];
                    Board.layout[r][c]=" ";
                    Board.layout[r][c+temp*j]="r";
                    if(Board.kingSafeBlack()) {
                        list=list+r+c+r+(c+temp*j)+oldPiece;
                    }
                    Board.layout[r][c]="r";
                    Board.layout[r][c+temp*j]=oldPiece;
                    temp++;
                }
                // Capture moves forwards and backwards
                if(Character.isUpperCase(Board.layout[r][c+temp*j].charAt(0))) {
                    oldPiece=Board.layout[r][c+temp*j];
                    Board.layout[r][c]=" ";
                    Board.layout[r][c+temp*j]="r";
                    if (Board.kingSafeBlack()) {
                        list=list+r+c+r+(c+temp*j)+oldPiece;
                    }
                    Board.layout[r][c]="r";
                    Board.layout[r][c+temp*j]=oldPiece;
                }
            } catch (Exception e) {
            }
            temp=1;
            try {
                // Moves to unoccupied positions sideways
                while(" ".equals(Board.layout[r+temp*j][c]))
                {
                    oldPiece=Board.layout[r+temp*j][c];
                    Board.layout[r][c]=" ";
                    Board.layout[r+temp*j][c]="r";
                    if (Board.kingSafeBlack()) {
                        list=list+r+c+(r+temp*j)+c+oldPiece;
                    }
                    Board.layout[r][c]="r";
                    Board.layout[r+temp*j][c]=oldPiece;
                    temp++;
                }
                // Capture moves sideways
                if(Character.isUpperCase(Board.layout[r+temp*j][c].charAt(0))) {
                    oldPiece=Board.layout[r+temp*j][c];
                    Board.layout[r][c]=" ";
                    Board.layout[r+temp*j][c]="r";
                    if (Board.kingSafeBlack()) {
                        list=list+r+c+(r+temp*j)+c+oldPiece;
                    }
                    Board.layout[r][c]="r";
                    Board.layout[r+temp*j][c]=oldPiece;
                }
            } catch (Exception e) {
            }
            temp=1;
        }
        return list;
    }
}
