package tienda;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class Escritorio extends JDesktopPane
{
   private static Image IMG =new ImageIcon(Escritorio.class.getResource("/icons/fondoEscritorio.jpg")).getImage();
   
   public void paintChildren(Graphics g)
   {
      g.drawImage(IMG,0,0,getWidth(),getHeight(),this);
      super.paintChildren(g);
   }
}