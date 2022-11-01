/*
 * Knight
 * 
 * Version 0.2
 *
 * Created by Daniel Hayes 01/12/2018
 *
 * Creative Commons Fair Use
 */
package TribalChess_v02;

/**
 * Creates list of all possible moves by knights
 * @author Daniel Hayes
 * @version 0.2
 * @since 4/12/18
 */
public class Knight {
    
    /**
     * Method to calculate the list of all possible moves by the white knight in 
     * the position of the passed arguments
     * @param r integer that represent the row the knight is in
     * @param c integer that represent the column the knight is in
     * @return a list of all possible moves by the knight specified
     */
    public static String possibleMovesWhite(int r, int c) {
        String list="", oldPiece;
        for (int j=-1; j<=1; j+=2) {
            for (int k=-1; k<=1; k+=2) {
                // Moves two columns and one row away
                try {
                    if(Character.isLowerCase(Board.layout[r+j][c+k*2].charAt(0))
                            || " ".equals(Board.layout[r+j][c+k*2])) {
                        oldPiece=Board.layout[r+j][c+k*2];
                        Board.layout[r][c]=" ";
                        Board.layout[r+j][c+k*2]="K";
                        if (Board.kingSafeWhite()) {
                            list=list+r+c+(r+j)+(c+k*2)+oldPiece;
                        }
                        Board.layout[r][c]="K";
                        Board.layout[r+j][c+k*2]=oldPiece;
                    }
                } catch (Exception e) {
                }
                // Moves two rows and one column away
                try {
                    if(Character.isLowerCase(Board.layout[r+j*2][c+k].charAt(0))
                            || " ".equals(Board.layout[r+j*2][c+k])) {
                        oldPiece=Board.layout[r+j*2][c+k];
                        Board.layout[r][c]=" ";
                        Board.layout[r+j*2][c+k]="K";
                        if (Board.kingSafeWhite()) {
                            list=list+r+c+(r+j*2)+(c+k)+oldPiece;
                        }
                        Board.layout[r][c]="K";
                        Board.layout[r+j*2][c+k]=oldPiece;
                    }
                } catch (Exception e) {
                }
            }
        }
        return list;
    }
    
    /**
     * Method to calculate the list of all possible moves by the black knight in 
     * the position of the passed arguments
     * @param r integer that represent the row the knight is in
     * @param c integer that represent the column the knight is in
     * @return a list of all possible moves by the knight specified
     */
    public static String possibleMovesBlack(int r, int c) {
        String list="", oldPiece;
        for (int j=-1; j<=1; j+=2) {
            for (int k=-1; k<=1; k+=2) {
                // Moves two columns and one row away
                try {
                    if (Character.isUpperCase(Board.layout[r+j][c+k*2]
                            .charAt(0)) 
                            || " ".equals(Board.layout[r+j][c+k*2])) {
                        oldPiece=Board.layout[r+j][c+k*2];
                        Board.layout[r][c]=" ";
                        Board.layout[r+j][c+k*2]="k";
                        if (Board.kingSafeBlack()) {
                            list=list+r+c+(r+j)+(c+k*2)+oldPiece;
                        }
                        Board.layout[r][c]="k";
                        Board.layout[r+j][c+k*2]=oldPiece;
                    }
                } catch (Exception e) {
                }
                // Moves two rows and one column away
                try {
                    if (Character.isUpperCase(Board.layout[r+j*2][c+k]
                            .charAt(0)) 
                            || " ".equals(Board.layout[r+j*2][c+k])) {
                        oldPiece=Board.layout[r+j*2][c+k];
                        Board.layout[r][c]=" ";
                        Board.layout[r+j*2][c+k]="k";
                        if (Board.kingSafeBlack()) {
                            list=list+r+c+(r+j*2)+(c+k)+oldPiece;
                        }
                        Board.layout[r][c]="k";
                        Board.layout[r+j*2][c+k]=oldPiece;
                    }
                } catch (Exception e) {
                }
            }
        }
        return list;
    }
}