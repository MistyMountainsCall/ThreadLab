package threadlab;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Walker VanHouten
 * (forked from Hunter Lloyd's example for this lab)
 */
public class CanvasPanel extends JPanel implements ActionListener, Runnable{
    int x, y;
    int offset = 25;
    CanvasPanel()
    {
        Button b = new Button("Quit");
        b.addActionListener(this);
        add(b);
        x = 50;
        y = 50;
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.fillOval(x, y, 50, 50);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        ThreadLab.stopFlag = true;
    }

    @Override
    public void run() {
        if(y>420)
            offset = -25;
        else if(y < 10)
            offset = 25;
        y += offset;
        repaint();
    }
  
}
