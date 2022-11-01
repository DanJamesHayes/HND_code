/*
 * King
 * 
 * Version 0.2
 *
 * Created by Daniel Hayes 01/12/2018
 *
 * Creative Commons Fair Use
 */
package TribalChess_v02;

import static TribalChess_v02.Board.kingPositionBlack;
import static TribalChess_v02.Board.kingPositionWhite;
import static TribalChess_v02.Board.layout;

/**
 * Creates list of all possible moves by kings also records if kings are unmoved
 * for castling purposes
 * @author Daniel Hayes
 * @version 0.2
 * @since 4/12/18
 */
public class King {
    
    // Booleans to record if either king is yet to move for castling purposes
    static boolean kingMovedWhite = false;
    static boolean kingMovedBlack = false;
    
    /**
     * Method to calculate the list of all possible moves by the white king in 
     * the position of the passed arguments
     * @param r integer that represent the row the king is in
     * @param c integer that represent the column the king is in
     * @return a list of all possible moves by the white king
     */
    public static String possibleMovesWhite(int r, int c) {
        String list="", oldPiece;
        for (int j=0; j<9; j++) {
            if (j!=4){
                // One space moves
                try {
                    if (Character.isLowerCase(Board.layout[r-1+j/3][c-1+j%3]
                            .charAt(0)) ||
                            " ".equals(Board.layout[r-1+j/3][c-1+j%3])){
                        oldPiece=Board.layout[r-1+j/3][c-1+j%3];
                        kingPositionWhite+=(j/3)*8+j%3-9;
                        Board.layout[r][c]=" ";
                        Board.layout[r-1+j/3][c-1+j%3]="A";
                        if (Board.kingSafeWhite()) {
                            list=list+r+c+(r-1+j/3)+(c-1+j%3)+oldPiece;
                        }
                        Board.layout[r][c]="A";
                        Board.layout[r-1+j/3][c-1+j%3]=oldPiece;
                        kingPositionWhite = 0;
                        while (!"A".equals(layout[kingPositionWhite/8]
                                [kingPositionWhite%8])) {
                            kingPositionWhite++;
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        // Queen side castling
        try{
            if(kingMovedWhite == false && Rook.rook1MovedWhite == false){
                if(" ".equals(Board.layout[7][1]) 
                        && " ".equals(Board.layout[7][2])
                        && " ".equals(Board.layout[7][3])){
                    Board.layout[r][c] = " ";
                    Board.layout[r][c-1] = "A";
                    if(Board.kingSafeWhite()) {
                        Board.layout[r][c-1] = " ";
                        Board.layout[r][c-2] = "A";
                        if(Board.kingSafeWhite()) {
                            list = list+"0234C";
                        }
                    }
                    Board.layout[r][c] = "A";
                    Board.layout[r][c-1] = " ";
                    Board.layout[r][c-2] = " ";
                    kingPositionWhite = 0;
                    while (!"A".equals(layout[kingPositionWhite/8]
                            [kingPositionWhite%8])) {
                        kingPositionWhite++;
                    }
                }
            }
        }catch(Exception e){
        }
        // King side castling
        try{
            if(kingMovedWhite == false && Rook.rook2MovedWhite == false){
                if(" ".equals(Board.layout[7][5]) 
                        && " ".equals(Board.layout[7][6])){
                    Board.layout[r][c] = " ";
                    Board.layout[r][c+1] = "A";
                    if(Board.kingSafeWhite()) {
                        Board.layout[r][c+1] = " ";
                        Board.layout[r][c+2] = "A";
                        if(Board.kingSafeWhite()) {
                            list = list+"7654C";
                        }
                    }
                    Board.layout[r][c] = "A";
                    Board.layout[r][c+1] = " ";
                    Board.layout[r][c+2] = " ";
                    kingPositionWhite = 0;
                    while (!"A".equals(layout[kingPositionWhite/8]
                            [kingPositionWhite%8])) {
                        kingPositionWhite++;
                    }
                }
            } 
        }catch(Exception e){
        }
        return list;
    }
    
    /**
     * Method to calculate the list of all possible moves by the black king in 
     * the position of the passed arguments
     * @param r integer that represent the row the king is in
     * @param c integer that represent the column the king is in
     * @return a list of all possible moves by the black king
     */
    public static String possibleMovesBlack(int r, int c) {
        String list="", oldPiece;
        for (int j=0; j<9; j++) {
            if (j!=4){
                // One space moves
                try {
                    if (Character.isUpperCase(Board.layout[r-1+j/3][c-1+j%3]
                            .charAt(0)) ||
                            " ".equals(Board.layout[r-1+j/3][c-1+j%3])){
                        oldPiece=Board.layout[r-1+j/3][c-1+j%3];
                        kingPositionBlack+=(j/3)*8+j%3-9;
                        Board.layout[r][c]=" ";
                        Board.layout[r-1+j/3][c-1+j%3]="a";
                        if (Board.kingSafeBlack()) {
                            list=list+r+c+(r-1+j/3)+(c-1+j%3)+oldPiece;
                        }
                        Board.layout[r][c]="a";
                        Board.layout[r-1+j/3][c-1+j%3]=oldPiece;
                        kingPositionBlack=0;
                        while (!"a".equals(layout[kingPositionBlack/8]
                                [kingPositionBlack%8])) {
                            kingPositionBlack++;
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        // Queen side castling
        try{
            if(kingMovedBlack == false && Rook.rook1MovedBlack == false){
                if(" ".equals(Board.layout[0][1]) 
                        && " ".equals(Board.layout[0][2])
                        && " ".equals(Board.layout[0][3])){
                    Board.layout[r][c] = " ";
                    Board.layout[r][c-1] = "a";
                    if(Board.kingSafeBlack()) {
                        Board.layout[r][c-1] = " ";
                        Board.layout[r][c-2] = "a";
                        if(Board.kingSafeBlack()) {
                            list = list+"0234c";
                        }
                    }
                    Board.layout[r][c] = "a";
                    Board.layout[r][c-1] = " ";
                    Board.layout[r][c-2] = " ";
                    kingPositionBlack = 0;
                    while (!"a".equals(layout[kingPositionBlack/8]
                            [kingPositionBlack%8])) {
                        kingPositionBlack++;
                    }
                }
            }
        }catch(Exception e){
        }
        // King side castling
        try{
            if(kingMovedBlack == false && Rook.rook2MovedBlack == false){
                if(" ".equals(Board.layout[0][5]) 
                        && " ".equals(Board.layout[0][6])){
                    Board.layout[r][c] = " ";
                    Board.layout[r][c+1] = "a";
                    if(Board.kingSafeBlack()) {
                        Board.layout[r][c+1] = " ";
                        Board.layout[r][c+2] = "a";
                        if(Board.kingSafeBlack()) {
                            list = list+"7654c";
                        }
                    }
                    Board.layout[r][c] = "a";
                    Board.layout[r][c+1] = " ";
                    Board.layout[r][c+2] = " ";
                    kingPositionBlack = 0;
                    while (!"a".equals(layout[kingPositionBlack/8]
                            [kingPositionBlack%8])) {
                        kingPositionBlack++;
                    }
                }
            }
        }catch(Exception e){
        }
        return list;
    }
}