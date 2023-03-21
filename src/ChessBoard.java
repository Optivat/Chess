import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class ChessBoard extends JFrame {

    public ChessLabel[][] labels = new ChessLabel[8][8];
    Point previousPoint;
    Point image_corner;
    ImageIcon currentImage;

    public ChessBoard() {
        display();
    }
    void display() {
        for (ChessLabel[] labelrow: labels) {
            for(ChessLabel square: labelrow) {
                square = new ChessLabel(" ");
            }
        }
        setTitle("LUCAS THE USELESS");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        GridLayout gridLayout = new GridLayout(8, 8);

        JPanel panel = (JPanel) add(new ChessPieceDragger(this));
        panel.setLayout(gridLayout);
        int sqrnum = 0;
        int row = -1;
        for (ChessLabel[] labelrow: labels) {
            for(ChessLabel square: labelrow) {
                if(sqrnum % 8 == 0) row ++; // increment row number
                if(row == 0 || row == 1) {
                    square = blackPieces(row, (sqrnum-(row*8)));
                    labels[row][(sqrnum-(row*8))] = square;
                } else if (row == 6 || row == 7) {
                    square = whitePieces(row, (sqrnum-(row*8)));
                    labels[row][(sqrnum-(row*8))] = square;
                } else {
                    square = new ChessLabel(" ");
                    labels[row][(sqrnum-(row*8))] = square;
                }
                System.out.println(row + ", " + (sqrnum-(row*8)));
                labels[row][(sqrnum-(row*8))].set(sqrnum,row);
                panel.add(labels[row][(sqrnum-(row*8))]);
                sqrnum++;
            }
        }
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    ChessLabel blackPieces(int row, int column) {
        String directory = "src/images/";
        if(row == 0) {
            switch (column) {
                case 0:
                case 7:
                    return new ChessLabel(new ImageIcon(directory + "rook_b.png"));
                case 1:
                case 6:
                    return new ChessLabel(new ImageIcon(directory + "knight_b.png"));
                case 2:
                case 5:
                    return new ChessLabel(new ImageIcon(directory + "bishop_b.png"));
                case 4:
                    return new ChessLabel(new ImageIcon(directory + "king_b.png"));
                case 3:
                    return new ChessLabel(new ImageIcon(directory + "queen_b.png"));
                default:
                    return null;

            }
        } else if (row == 1) {
            return new ChessLabel(new ImageIcon(directory + "pawn_b.png"));
        }
        return null;
    }
    ChessLabel whitePieces(int row, int column) {
        String directory = "src/images/";
        if(row == 7) {
            switch (column) {
                case 0:
                case 7:
                    return new ChessLabel(new ImageIcon(directory + "rook_w.png"));
                case 1:
                case 6:
                    return new ChessLabel(new ImageIcon(directory + "knight_w.png"));
                case 2:
                case 5:
                    return new ChessLabel(new ImageIcon(directory + "bishop_w.png"));
                case 4:
                    return new ChessLabel(new ImageIcon(directory + "king_w.png"));
                case 3:
                    return new ChessLabel(new ImageIcon(directory + "queen_w.png"));
                default:
                    return null;

            }
        } else if (row == 6) {
            return new ChessLabel(new ImageIcon(directory + "pawn_w.png"));
        }
        return null;
    }
    ImageIcon getImageClickedOn(int column, int row) {
        if (labels[row][column].getImageIcon() != null) {
            return labels[row][column].getImageIcon();
        }
        return null;
    }
}
