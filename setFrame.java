import java.awt.*;
import javax.swing.*;

class setFrame {
    setFrame(JFrame frame, String title, int dimx, int dimy) {
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setTitle(title);
        frame.setSize(new Dimension(dimx, dimy));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
}
