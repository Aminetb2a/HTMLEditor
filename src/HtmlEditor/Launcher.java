package HtmlEditor;

/**
 * Created by Amine && Aissa on 10-Oct-14.
 */


import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;


public class Launcher extends JWindow
{

    private ImageIcon splashImage = new ImageIcon("images/splash.gif");
    private Image splashImg = splashImage.getImage();


    public Launcher()
    {
        try
        {
            setSize(633, 300);
            setLocationRelativeTo(null);
            show();
            Thread.sleep(5000);
            dispose();
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            HtmlEdit fr = new HtmlEdit();
            fr.setTitle("Html Editor");
            fr.setLocale(null);
            fr.setSize(1650,1080);
            fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            fr.setVisible(true);
            fr.pack();
        }
        catch(Exception exception)
        {
            javax.swing.JOptionPane.showMessageDialog((java.awt.Component)
                            null,"Error"+exception.getMessage(), "Error:",
                    javax.swing.JOptionPane.DEFAULT_OPTION);
        }
    }

    public void paint(Graphics g)
    {
        g.drawImage(splashImg,0,0,this);
    }

    public static void main(String[]args)
    {
        Launcher Execute =new Launcher();

    }
}
