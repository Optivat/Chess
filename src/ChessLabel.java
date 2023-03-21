import javax.swing.*;
import java.awt.*;

public class ChessLabel extends JLabel {
    Color bgLight = new Color(222, 184, 135);
    Color bgDark  = new Color(139, 69, 19);
    private ImageIcon imgIn;

    ChessLabel(String s)
    {
        super(s);
        imgIn = null;
    }
    ChessLabel(ImageIcon imageIcon) {
        super(imageIcon);
        imgIn = imageIcon;
        setCursor(Cursor.getPredefinedCursor(12));
    }

    void set(int idx, int row)
    {
        setOpaque(true);
        setBackground((idx + row)%2 == 0 ? bgLight : bgDark);
        setHorizontalAlignment( SwingConstants.CENTER );
    }
    public ImageIcon getImageIcon() {return imgIn;}
    public void setImageIcon (ImageIcon imageIcon) {imgIn = imageIcon; setIcon(imageIcon);}
}
