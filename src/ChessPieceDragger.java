import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class ChessPieceDragger extends JPanel {
    Point previousPoint;
    Point image_corner;
    ImageIcon currentImage;
    ChessBoard chessBoard;
    public ChessPieceDragger(ChessBoard chessBoard) {
        addMouseMotionListener(new ChessDragListener());
        addMouseListener(new ChessClickListener());
        this.chessBoard = chessBoard;

        image_corner = new Point(0,0);
    }
    public void paintComponent(Graphics g) {
        if (currentImage != null) {
            super.paintComponent(g);
            currentImage.paintIcon(this, g, (int) image_corner.getX(), (int) image_corner.getY());

        }

    }
    private class ChessClickListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            int SquareX = e.getX() / (getWidth()/8);
            int SquareY = e.getY() / (getHeight()/8);
            System.out.println(SquareX + "," + SquareY);
            previousPoint = e.getPoint();
            currentImage = chessBoard.getImageClickedOn(SquareX, SquareY);
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            previousPoint = new Point(0,0);
        }
    }
    private class ChessDragListener extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            if (currentImage != null) {
                Point currentPoint = new Point(e.getX()-30, e.getY()-30);
                image_corner = currentPoint;//((int)(currentPoint.getX() - previousPoint.getX()), (int)(currentPoint.getY() - previousPoint.getY()));
                previousPoint = currentPoint;
                repaint();
            }
        }

    }
}