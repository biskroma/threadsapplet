import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class ColorSwirl extends java.applet.Applet implements Runnable
{
    Font f = new Font("TimesRoman",Font.BOLD,48);
    Color colors[] = new Color[50];
    Thread runThread;
    
    public void start()
    {
        if(runThread == null)
        {
            runThread = new Thread(this);
            runThread.start();
        }
    }
    
    public void stop()
    {
        if(runThread != null)
        {
            runThread.stop();
            runThread = null;
        }
    }
    
    public void run()
    {
        float c = 0;
        for(int i = 0; i < colors.length; i++)
        {
            colors[i] = Color.getHSBColor(c, (float)1.0, (float)1.0);
            c += 0.02;
        }
        
        int i = 0;
        while(true)
        {
            setForeground(colors[i]);
            repaint();
            i++;
            try
            {
                Thread.sleep(50);
            }
            catch(InterruptedException e)
            {
                System.out.println("Error " + e);
            }
            if (i == colors.length) i = 0;
        }
    }
    
    public void paint(Graphics g)
    {
        g.setFont(f);
        g.drawString("Colores",50,50);
    }
}