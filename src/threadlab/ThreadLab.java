package threadlab;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author Walker VanHouten
 * (forked from Hunter Lloyd's example for this lab)
 */

public class ThreadLab extends JFrame {

    CanvasPanel cp;
    public static boolean stopFlag = false;
    
    ThreadLab() {
        super("Thread Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        cp = new CanvasPanel();
        getContentPane().add(cp, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        ThreadLab tl = new ThreadLab();
        tl.animate();
    }
    
    public void animate() {
        Thread t = new Thread(cp);
        do {
            try {
                Thread.sleep(1000/30);
            } catch (InterruptedException ex) {}
            if(!stopFlag) {
                t.run();
            }
        } while(true);
        
    }
}
