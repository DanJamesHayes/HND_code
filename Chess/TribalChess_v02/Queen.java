/*
 * Queen
 * 
 * Version 0.2
 *
 * Created by Daniel Hayes 01/12/2018
 *
 * Creative Commons Fair Use
 */
package TribalChess_v02;

/**
 * Creates list of all possible moves by queens
 * @author Daniel Hayes
 * @version 0.2
 * @since 4/12/18
 */
public class Queen {
    
    /**
     * Method to calculate the list of all possible moves by the white queen in 
     * the position of the passed arguments
     * @param r integer that represent the row the queen is in
     * @param c integer that represent the column the queen is in
     * @return a list of all possible moves by the white queen
     */
    public static String possibleMovesWhite(int r, int c) {
        String list="", oldPiece;
        int temp=1;
        for (int j=-1; j<=1; j++) {
            for (int k=-1; k<=1; k++) {
                try {
                    // Moves to unoccupied positions
                    while(" ".equals(Board.layout[r+temp*j][c+temp*k]))
                    {
                        Board.layout[r][c]=" ";
                        Board.layout[r+temp*j][c+temp*k]="Q";
                        if (Board.kingSafeWhite()) {
                            list=list+r+c+(r+temp*j)+(c+temp*k)+" ";
                        }
                        Board.layout[r][c]="Q";
                        Board.layout[r+temp*j][c+temp*k]=" ";
                        temp++;
                    }
                    // Capture moves
                    if (Character.isLowerCase(Board.layout[r+temp*j][c+temp*k]
                            .charAt(0))) {
                        oldPiece=Board.layout[r+temp*j][c+temp*k];
                        Board.layout[r][c]=" ";
                        Board.layout[r+temp*j][c+temp*k]="Q";
                        if (Board.kingSafeWhite()) {
                            list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                        }
                        Board.layout[r][c]="Q";
                        Board.layout[r+temp*j][c+temp*k]=oldPiece;
                    }
                } catch (Exception e) {
                }
                temp=1;
            }
        }
        return list;
    }
    
    /**
     * Method to calculate the list of all possible moves by the black queen in 
     * the position of the passed arguments
     * @param r integer that represent the row the queen is in
     * @param c integer that represent the column the queen is in
     * @return a list of all possible moves by the black queen
     */
    public static String possibleMovesBlack(int r, int c){
        String list="", oldPiece;
        int temp=1;
        for (int j=-1; j<=1; j++) {
            for (int k=-1; k<=1; k++) {
                try {
                    // Moves to unnocupied possitions
                    while(" ".equals(Board.layout[r+temp*j][c+temp*k]))
                    {
                        Board.layout[r][c]=" ";
                        Board.layout[r+temp*j][c+temp*k]="q";
                        if (Board.kingSafeBlack()) {
                            list=list+r+c+(r+temp*j)+(c+temp*k)+" ";
                        }
                        Board.layout[r][c]="q";
                        Board.layout[r+temp*j][c+temp*k]=" ";
                        temp++;
                    }
                    // Capture moves
                    if (Character.isUpperCase(Board.layout[r+temp*j][c+temp*k]
                            .charAt(0))) {
                        oldPiece=Board.layout[r+temp*j][c+temp*k];
                        Board.layout[r][c]=" ";
                        Board.layout[r+temp*j][c+temp*k]="q";
                        if (Board.kingSafeBlack()) {
                            list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                        }
                        Board.layout[r][c]="q";
                        Board.layout[r+temp*j][c+temp*k]=oldPiece;
                    }
                } catch (Exception e) {
                }
                temp=1;
            }
        }
        return list;
    }
}