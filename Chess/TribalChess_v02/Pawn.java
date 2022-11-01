/*
 * Pawn
 * 
 * Version 0.2
 *
 * Created by Daniel Hayes 01/12/2018
 *
 * Creative Commons Fair Use
 */
package TribalChess_v02;

/**
 * Creates list of all possible moves by pawns
 * @author Daniel Hayes
 * @version 0.2
 * @since 4/12/18
 */
public class Pawn {
    
    /**
     * Method to calculate the list of all possible moves by the white pawn in 
     * the position of the passed arguments
     * @param r integer that represent the row the pawn is in
     * @param c integer that represent the column the pawn is in
     * @return a list of all possible moves by the pawn specified
     */
    public static String possibleMovesWhite(int r, int c) {
        String list="", oldPiece;
        for (int i=-1; i<=1; i+=2) {
            // Capture moves
            try {
                if (Character.isLowerCase(Board.layout[r-1][c+i].charAt(0))
                        && r>=2) {
                    oldPiece=Board.layout[r-1][c+i];
                    Board.layout[r][c]=" ";
                    Board.layout[r-1][c+i]="P";
                    if (Board.kingSafeWhite()) {
                        list=list+r+c+(r-1)+(c+i)+oldPiece;
                    }
                    Board.layout[r][c]="P";
                    Board.layout[r-1][c+i]=oldPiece;
                }
            } catch (Exception e) {
            }
            // Capture and pawn promotion moves
            try {
                if (Character.isLowerCase(Board.layout[r-1][c+i].charAt(0))
                        && r<2) {
                    oldPiece=Board.layout[r-1][c+i];
                    Board.layout[r][c]=" ";
                    Board.layout[r-1][c+i]="Q";
                    if (Board.kingSafeWhite()) {
                        list=list+c+(c+i)+"PQE";
                    }
                    Board.layout[r][c]="P";
                    Board.layout[r-1][c+i]=oldPiece;
                    
                }
            } catch (Exception e) {
            }
            // En passant
            try{
                if("p".equals(Board.layout[r][c+i]) && r==3){
                    if(Move.lastMove.equals("1"+(c+i)+"3"+(c+i)+" ")){
                        Board.layout[2][c+i]="P";
                        Board.layout[3][c+i]=" ";
                        Board.layout[r][c]=" ";
                        if (Board.kingSafeWhite()) {
                            list=list+r+c+"2"+(c+i)+"N";
                        }
                        Board.layout[2][c+i]=" ";
                        Board.layout[3][c+i]="p";
                        Board.layout[r][c]="P";
                    }
                }
            }catch(Exception e){
            }
        }
        // One space forward moves
        try {
            if (" ".equals(Board.layout[r-1][c]) && r>=2) {
                oldPiece=Board.layout[r-1][c];
                Board.layout[r][c]=" ";
                Board.layout[r-1][c]="P";
                if (Board.kingSafeWhite()) {
                    list=list+r+c+(r-1)+c+oldPiece;
                }
                Board.layout[r][c]="P";
                Board.layout[r-1][c]=oldPiece;
            }
        } catch (Exception e) {
        }
        // One space forward and pawn promotion moves
        try {
            if (" ".equals(Board.layout[r-1][c]) && r<2) {
                oldPiece=Board.layout[r-1][c];
                Board.layout[r][c]=" ";
                Board.layout[r-1][c]="Q";
                if (Board.kingSafeWhite()) {
                    list=list+c+c+"PQE";
                }
                Board.layout[r][c]="P";
                Board.layout[r-1][c]=oldPiece;
            }
        } catch (Exception e) {
        }
        // Initial two space moves
        try {
            if (" ".equals(Board.layout[r-1][c])
                    && " ".equals(Board.layout[r-2][c]) && r>=6) {
                oldPiece=Board.layout[r-2][c];
                Board.layout[r][c]=" ";
                Board.layout[r-2][c]="P";
                if (Board.kingSafeWhite()) {
                    list=list+r+c+(r-2)+c+oldPiece;
                }
                Board.layout[r][c]="P";
                Board.layout[r-2][c]=oldPiece;
            }
        } catch (Exception e) {
        }
        return list;
    }

    /**
     * Method to calculate the list of all possible moves by the black pawn in 
     * the position of the passed arguments
     * @param r integer that represent the row the pawn is in
     * @param c integer that represent the column the pawn is in
     * @return a list of all possible moves by the pawn specified
     */
    public static String possibleMovesBlack(int r, int c) {
        String list="", oldPiece;
        for (int j=-1; j<=1; j+=2) {
            // Capture moves
            try {
                if (Character.isUpperCase(Board.layout[r+1][c+j].charAt(0))
                        && r<=6) {
                    oldPiece=Board.layout[r+1][c+j];
                    Board.layout[r][c]=" ";
                    Board.layout[r+1][c+j]="p";
                    if (Board.kingSafeBlack()) {
                        list=list+r+c+(r+1)+(c+j)+oldPiece;
                    }
                    Board.layout[r][c]="p";
                    Board.layout[r+1][c+j]=oldPiece;
                }
            } catch (Exception e) {
            }
            // Capture and pawn promotion moves
            try {
                if (Character.isUpperCase(Board.layout[r+1][c+j].charAt(0))
                        && r>5) {
                    oldPiece=Board.layout[r+1][c+j];
                    Board.layout[r][c]=" ";
                    Board.layout[r+1][c+j]="q";
                    if (Board.kingSafeBlack()) {
                        list=list+c+(c+j)+"pqe";
                    }
                    Board.layout[r][c]="p";
                    Board.layout[r+1][c+j]=oldPiece;
                    
                }
            } catch (Exception e) {
            }
            // En passant
            try{
                if("P".equals(Board.layout[r][c+j]) && r==4){
                    if(Move.lastMove.equals("6"+(c+j)+"4"+(c+j)+" ")){
                        Board.layout[5][c+j]="p";
                        Board.layout[4][c+j]=" ";
                        Board.layout[r][c]=" ";
                        if (Board.kingSafeBlack()) {
                            list=list+r+c+"5"+(c+j)+"n";
                        }
                        Board.layout[5][c+j]=" ";
                        Board.layout[4][c+j]="P";
                        Board.layout[r][c]="p";
                    }
                }
            }catch(Exception e){
            }
        }
        // One space moves
        try {
            if (" ".equals(Board.layout[r+1][c]) && r<=6) {
                oldPiece=Board.layout[r+1][c];
                Board.layout[r][c]=" ";
                Board.layout[r+1][c]="p";
                if (Board.kingSafeBlack()) {
                    list=list+r+c+(r+1)+c+oldPiece;
                }
                Board.layout[r][c]="p";
                Board.layout[r+1][c]=oldPiece;
            }
        } catch (Exception e) {
        }
        // One space and pawn promotion moves
        try {
            if (" ".equals(Board.layout[r+1][c]) && r>5) {
                oldPiece=Board.layout[r+1][c];
                Board.layout[r][c]=" ";
                Board.layout[r+1][c]="q";
                if (Board.kingSafeBlack()) {
                    list=list+c+c+"pqe";
                }
                Board.layout[r][c]="p";
                Board.layout[r+1][c]=oldPiece;

            }
        } catch (Exception e) {
        }
        // Initial two space moves
        try {
            if (" ".equals(Board.layout[r+1][c])
                    && " ".equals(Board.layout[r+2][c]) && r<=1) {
                oldPiece=Board.layout[r+2][c];
                Board.layout[r][c]=" ";
                Board.layout[r+2][c]="p";
                if (Board.kingSafeBlack()) {
                    list=list+r+c+(r+2)+c+oldPiece;
                }
                Board.layout[r][c]="p";
                Board.layout[r+2][c]=oldPiece;
            }
        } catch (Exception e) {
        }
        return list;
    }
}