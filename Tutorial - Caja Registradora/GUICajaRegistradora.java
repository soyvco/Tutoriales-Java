import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.Color;

public class GUICajaRegistradora extends JFrame implements ActionListener
{
   private JPanel       contenedor;
   private JMenuBar     barraMenus;
   private JMenu        menuCaja;
   private JMenuItem    itemCaja;
   private JDesktopPane pEscritorio;
   InternalInicioSesion ifIS =new InternalInicioSesion();
   
   public GUICajaRegistradora()
   {
      /* Configuración de la ventana */
      setIconImage(Toolkit.getDefaultToolkit().getImage(GUICajaRegistradora.class.getResource("/icons/terminal.png")));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("CAJA REGISTRADORA");
      setSize(800,700);
      setLocationRelativeTo(null);
      contenedor=new JPanel(new BorderLayout());
      setContentPane(contenedor);
      /* Barra de menus */
      barraMenus=new JMenuBar();
      contenedor.add(barraMenus,BorderLayout.NORTH);
      menuCaja=new JMenu("Cajero");
      barraMenus.add(menuCaja);
      itemCaja=new JMenuItem("Cobrar");
      itemCaja.addActionListener(this);
      menuCaja.add(itemCaja);
      /* DesktopPane para el JInternalFrame */
      pEscritorio=new JDesktopPane();
      pEscritorio.setBackground(Color.DARK_GRAY);
      pEscritorio.setOpaque(true);
      contenedor.add(pEscritorio,BorderLayout.CENTER);
   }
   
   public void actionPerformed(ActionEvent pE)
   {
      if(pE.getSource().equals(itemCaja))
      {
         /* Ajustes para centrar el internalFrame */
         int x=(pEscritorio.getWidth()/2)-(ifIS.getWidth()/2);
         int y=(pEscritorio.getHeight()/2)-(ifIS.getHeight()/2);
         if(ifIS.isShowing())
         {
            ifIS.setLocation(x,y);
         }
         else
         {
            pEscritorio.add(ifIS);
            ifIS.setLocation(x,y);
            ifIS.show();
         }
      }
   }
}
