/*
 * User Interface
 * 
 * Version 0.2
 *
 * Created by Daniel Hayes 01/12/2018
 *
 * Creative Commons Fair Use
 */
package TribalChess_v02;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

/**
 * Creates a User Interface to represent board and pieces, monitors mouse
 * movement to pass to move class
 * @author Daniel Hayes
 * @version 0.2
 * @since 1/12/18
 */
public class UserInterface extends JPanel implements MouseListener, 
        MouseMotionListener{
    
    /**
     * Main method which outputs a dialog box displaying the creation details 
     * and asking the user if they would like to play a game.
     * Game board window shown once 'ok' button is clicked.
     * @param args 
     */
    public static void main(String[] args) {
        
        JOptionPane.showMessageDialog(null, "HND - Computing\n"
                + "Unit 47 - Game Design\n\n"
                + "Tribal Chess v0.2\n"
                + "(Minimum Viable Product)\n\n"
                + "By Daniel Hayes\n\n"
                + "Stockport College\n"
                + "Tutor: Leo Casillas\n\n"
                + "Play game?", "Tribal Chess",
                JOptionPane.INFORMATION_MESSAGE);
        JFrame f=new JFrame("Chess Tutorial");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UserInterface ui=new UserInterface();
        f.add(ui);
        f.setSize(527, 551);
        f.setVisible(true);
    }
    
    // Create integers which will be used to record the x and y position of the
    // curser on the board when the mouse is pressed and released
    static int mouseX, mouseY, newMouseX, newMouseY;
    // Create integer for generic square and piece size
    static int squareSize=64;
    
    /**
     * This method is called automatically by the system and paints an 8x8 grid
     * for the board and the pieces based on their position in the board array
     * @param g canvas to be painted
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        for (int i=0;i<64;i+=2) {
            g.setColor(new Color(255,200,100));
            g.fillRect((i%8+(i/8)%2)*squareSize, (i/8)*squareSize, squareSize, 
                    squareSize);
            g.setColor(new Color(150,50,30));
            g.fillRect(((i+1)%8-((i+1)/8)%2)*squareSize, ((i+1)/8)*squareSize, 
                    squareSize, squareSize);
        }
        ClassLoader classLoader = Thread.currentThread()
                .getContextClassLoader();
        URL resource = classLoader.getResource("img/ChessPieces.png");
        Image chessPiecesImage = new ImageIcon(resource).getImage();
        for (int i=0;i<64;i++) {
            int j=-1,k=-1;
            switch (Board.layout[i/8][i%8]) {
                case "P": j=5; k=0;
                    break;
                case "p": j=5; k=1;
                    break;
                case "R": j=2; k=0;
                    break;
                case "r": j=2; k=1;
                    break;
                case "K": j=4; k=0;
                    break;
                case "k": j=4; k=1;
                    break;
                case "B": j=3; k=0;
                    break;
                case "b": j=3; k=1;
                    break;
                case "Q": j=1; k=0;
                    break;
                case "q": j=1; k=1;
                    break;
                case "A": j=0; k=0;
                    break;
                case "a": j=0; k=1;
                    break;
            }
            if (j!=-1 && k!=-1) {
                g.drawImage(chessPiecesImage, (i%8)*squareSize, 
                        (i/8)*squareSize, (i%8+1)*squareSize, 
                        (i/8+1)*squareSize, j*64, k*64, (j+1)*64, (k+1)*64, 
                        this);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    /**
     * Method to set mouseX and mouseY to the position of the cursor when the 
     * mouse is pressed
     * @param e cursor details
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getX()<8*squareSize &&e.getY()<8*squareSize) {
            // get mouse position
            mouseX=e.getX();
            mouseY=e.getY();
        }
    }
    
    /**
     * Method to set newMouseX and newMouseY to the x and y position of the 
     * cursor when the mouse is released. mouseX, mouseY, newMouseX and 
     * newMouseY are used to generate the dragMove string which is passed as an
     * argument in the makeMove() method in the Move class. The repaint() method
     * is then used to call the paintCompent method to repaint the board with
     * the moved piece in its new position.
     * @param e cursor details
     */
    @Override
    public void mouseReleased(MouseEvent e) {
            if (e.getX()<8*squareSize &&e.getY()<8*squareSize) {
            newMouseX=e.getX();
            newMouseY=e.getY();
            if (e.getButton()==MouseEvent.BUTTON1) {
                String dragMove;
                if (newMouseY/squareSize==0 && mouseY/squareSize==1 
                        && "P".equals(Board.layout
                                [mouseY/squareSize][mouseX/squareSize])) {
                    dragMove=""+mouseX/squareSize+newMouseX/squareSize
                            +"PQE";
                }else if(newMouseY/squareSize==7 && mouseY/squareSize==6 
                        && "p".equals(Board.layout
                                [mouseY/squareSize][mouseX/squareSize])){
                    dragMove=""+mouseX/squareSize+newMouseX/squareSize
                            +"pqe";
                }else if(newMouseX/squareSize==2 && mouseX/squareSize==4 
                        && "A".equals(Board.layout
                                [mouseY/squareSize][mouseX/squareSize])){
                    dragMove="0234C";
                }else if(newMouseX/squareSize==6 && mouseX/squareSize==4 
                        && "A".equals(Board.layout
                                [mouseY/squareSize][mouseX/squareSize])){
                    dragMove="7654C";
                }else if(newMouseX/squareSize==2 && mouseX/squareSize==4 
                        && "a".equals(Board.layout
                                [mouseY/squareSize][mouseX/squareSize])){
                    dragMove="0234c";
                }else if(newMouseX/squareSize==6 && mouseX/squareSize==4 
                        && "a".equals(Board.layout
                                [mouseY/squareSize][mouseX/squareSize])){
                    dragMove="7654c";
                }else if(mouseX/squareSize != newMouseX/squareSize 
                        && newMouseY/squareSize==2 && mouseY/squareSize==3 
                        && "P".equals(Board.layout
                                [mouseY/squareSize][mouseX/squareSize])
                        && " ".equals(Board.layout
                                [newMouseY/squareSize][newMouseX/squareSize])){
                    dragMove=""+mouseY/squareSize+mouseX/squareSize
                            +newMouseY/squareSize+newMouseX/squareSize
                            +"N";
                }else if(mouseX/squareSize != newMouseX/squareSize 
                        && newMouseY/squareSize==5 && mouseY/squareSize==4 
                        && "p".equals(Board.layout
                                [mouseY/squareSize][mouseX/squareSize])
                        && " ".equals(Board.layout
                                [newMouseY/squareSize][newMouseX/squareSize])){
                    dragMove=""+mouseY/squareSize+mouseX/squareSize
                            +newMouseY/squareSize+newMouseX/squareSize
                            +"n";
                }else{
                    dragMove=""+mouseY/squareSize+mouseX/squareSize
                            +newMouseY/squareSize+newMouseX/squareSize
                            +Board.layout[newMouseY/squareSize]
                            [newMouseX/squareSize];
                }
                Move.makeMove(dragMove);
            }
        }
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}