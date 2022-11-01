/*
 * Board
 * 
 * Version 0.2
 *
 * Created by Daniel Hayes 01/12/2018
 *
 * Creative Commons Fair Use
 */
package TribalChess_v02;

/**
 * Creates an array of the board layout and also checks if the kings are safe
 * @author Daniel Hayes
 * @version 0.2
 * @since 4/12/18
 */
public class Board {
    
    static String layout[][]={
        {"r","k","b","q","a","b","k","r"}, // 0  1  2  3  4  5  6  7
        {"p","p","p","p","p","p","p","p"}, // 8  9  10 11 12 13 14 15
        {" "," "," "," "," "," "," "," "}, // 16 17 18 19 20 21 22 23
        {" "," "," "," "," "," "," "," "}, // 24 25 26 27 28 29 30 31
        {" "," "," "," "," "," "," "," "}, // 32 33 34 35 36 37 38 39
        {" "," "," "," "," "," "," "," "}, // 40 41 42 43 44 45 46 47
        {"P","P","P","P","P","P","P","P"}, // 48 49 50 51 52 53 54 55
        {"R","K","B","Q","A","B","K","R"}  // 56 57 58 59 60 61 62 63
    };
    
    // Integers created to continually track the current position of each king
    static int kingPositionWhite, kingPositionBlack;
    
    /**
     * Method to check if white king is in check with the board in its current
     * state
     * @return true if king is safe, false if in check
     */
    public static boolean kingSafeWhite() {
        // Update kingPositionWhite integer
        kingPositionWhite=0;
        while (!"A".equals(layout[kingPositionWhite/8][kingPositionWhite%8])) {
            kingPositionWhite++;
        }
        int temp=1;
        // Check for unobstructed opposition bishops or queen diagonally
        // away from king
        for (int i=-1; i<=1; i+=2) {
            for (int j=-1; j<=1; j+=2) {
                try {
                    while(" ".equals(layout[kingPositionWhite/8+temp*i]
                            [kingPositionWhite%8+temp*j])) {
                        temp++;
                    }
                    if ("b".equals(layout[kingPositionWhite/8+temp*i]
                            [kingPositionWhite%8+temp*j]) 
                            || "q".equals(layout[kingPositionWhite/8+temp*i]
                                    [kingPositionWhite%8+temp*j])) {
                        return false;
                    }
                } catch (Exception e) {
                }
                temp=1;
            }
        }
        for (int i=-1; i<=1; i+=2) {
            // Check for unobstructed opposition rooks or queens sideways from
            // king
            try {
                while(" ".equals(layout[kingPositionWhite/8]
                        [kingPositionWhite%8+temp*i])) {
                    temp++;
                }
                if ("r".equals(layout[kingPositionWhite/8]
                        [kingPositionWhite%8+temp*i]) 
                        || "q".equals(layout[kingPositionWhite/8]
                                [kingPositionWhite%8+temp*i])) {
                    return false;
                }
            } catch (Exception e) {
            }
            temp=1;
            // Check for unobstructed opposition rooks or queens forwards or
            // backwards from king
            try {
                while(" ".equals(layout[kingPositionWhite/8+temp*i]
                        [kingPositionWhite%8])) {
                    temp++;
                }
                if ("r".equals(layout[kingPositionWhite/8+temp*i]
                        [kingPositionWhite%8]) 
                        || "q".equals(layout[kingPositionWhite/8+temp*i]
                                [kingPositionWhite%8])) {
                    return false;
                }
            } catch (Exception e) {
            }
            temp=1;
        }
        for (int i=-1; i<=1; i+=2) {
            for (int j=-1; j<=1; j+=2) {
                // Check for opposition knights one row and two columns away
                // from king
                try {
                    if ("k".equals(layout[kingPositionWhite/8+i]
                            [kingPositionWhite%8+j*2])) {
                        return false;
                    }
                } catch (Exception e) {
                }
                // Check for opposition knights two rows and one column away
                // from king
                try {
                    if ("k".equals(layout[kingPositionWhite/8+i*2]
                            [kingPositionWhite%8+j])) {
                        return false;
                    }
                } catch (Exception e) {
                }
            }
        }
        // Check if a black pawn is one space diagonally up the board
        if (kingPositionWhite>=16) {
            try {
                if ("p".equals(layout[kingPositionWhite/8-1]
                        [kingPositionWhite%8-1])) {
                    return false;
                }
            } catch (Exception e) {
            }
            try {
                if ("p".equals(layout[kingPositionWhite/8-1]
                        [kingPositionWhite%8+1])) {
                    return false;
                }
            } catch (Exception e) {
            }
        }
        // Check if opposition king is within one space
        for (int i=-1; i<=1; i++) {
            for (int j=-1; j<=1; j++) {
                if (i!=0 || j!=0) {
                    try {
                        if ("a".equals(layout[kingPositionWhite/8+i]
                                [kingPositionWhite%8+j])) {
                            return false;
                        }
                    } catch (Exception e) {
                    }
                }
            }
            }
        return true;
    }
    
    /**
     * Method to check if black king is in check with the board in its current
     * state
     * @return true if king is safe, false if in check
     */
    public static boolean kingSafeBlack() {
        // Update kingPositionBlack integer
        kingPositionBlack=0;
        while (!"a".equals(layout[kingPositionBlack/8][kingPositionBlack%8])) {
            kingPositionBlack++;
        }
        int temp=1;
        // Check for unobstructed opposition bishops or queen diagonally
        // away from king
        for (int i=-1; i<=1; i+=2) {
            for (int j=-1; j<=1; j+=2) {
                try {
                    while(" ".equals(layout[kingPositionBlack/8+temp*i]
                            [kingPositionBlack%8+temp*j])) {
                        temp++;
                    }
                    if ("B".equals(layout[kingPositionBlack/8+temp*i]
                            [kingPositionBlack%8+temp*j]) 
                            || "Q".equals(layout[kingPositionBlack/8+temp*i]
                                    [kingPositionBlack%8+temp*j])) {
                        return false;
                    }
                } catch (Exception e) {
                }
                temp=1;
            }
        }
        for (int i=-1; i<=1; i+=2) {
            // Check for unobstructed opposition rooks or queens sideways from
            // king
            try {
                while(" ".equals(layout[kingPositionBlack/8]
                        [kingPositionBlack%8+temp*i])) {
                    temp++;
                }
                if ("R".equals(layout[kingPositionBlack/8]
                        [kingPositionBlack%8+temp*i]) 
                        || "Q".equals(layout[kingPositionBlack/8]
                                [kingPositionBlack%8+temp*i])) {
                    return false;
                }
            } catch (Exception e) {
            }
            temp=1;
            // Check for unobstructed opposition rooks or queens forwards or
            // backwards from king
            try {
                while(" ".equals(layout[kingPositionBlack/8+temp*i]
                        [kingPositionBlack%8])) {
                    temp++;
                }
                if ("R".equals(layout[kingPositionBlack/8+temp*i]
                        [kingPositionBlack%8]) 
                        || "Q".equals(layout[kingPositionBlack/8+temp*i]
                                [kingPositionBlack%8])) {
                    return false;
                }
            } catch (Exception e) {
            }
            temp=1;
        }
        for (int i=-1; i<=1; i+=2) {
            for (int j=-1; j<=1; j+=2) {
                // Check for opposition knights one row and two columns away
                // from king
                try {
                    if ("K".equals(layout[kingPositionBlack/8+i]
                            [kingPositionBlack%8+j*2])) {
                        return false;
                    }
                } catch (Exception e) {
                }
                // Check for opposition knights two rows and one column away
                // from king
                try {
                    if ("K".equals(layout[kingPositionBlack/8+i*2]
                            [kingPositionBlack%8+j])) {
                        return false;
                    }
                } catch (Exception e) {
                }
            }
        }
        // Check if a white pawn is one space diagonally down the board
        if (kingPositionBlack<=47) {
            try {
                if ("P".equals(layout[kingPositionBlack/8+1]
                        [kingPositionBlack%8-1])) {
                    return false;
                }
            } catch (Exception e) {
            }
            try {
                if ("P".equals(layout[kingPositionBlack/8+1]
                        [kingPositionBlack%8+1])) {
                    return false;
                }
            } catch (Exception e) {
            }
        }
        // Check if opposition king is within one space
        for (int i=-1; i<=1; i++) {
            for (int j=-1; j<=1; j++) {
                if (i!=0 || j!=0) {
                    try {
                        if ("A".equals(layout[kingPositionBlack/8+i]
                                [kingPositionBlack%8+j])) {
                            return false;
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        return true;
    }
}