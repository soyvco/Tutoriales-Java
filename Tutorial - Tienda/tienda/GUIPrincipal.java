package tienda;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GUIPrincipal extends JFrame implements ActionListener
{
   private JPanel      contenedor;
   private Escritorio  pEscr;
   private JMenu[]     menus        =new JMenu[2];
   private String[]    nomMenus     ={"Cobro","Productos"};
   private JMenuItem[] items        =new JMenuItem[2];
   private String[]    nomItemMenus ={"Cajero","Agregar"};
   private JMenuBar    barraMenus;
   IFInicioSesion      ifIS         =new IFInicioSesion();
   IFProductos         ifProductos  =new IFProductos();
   
   public GUIPrincipal()
   {
      /* Configuración de la ventana */
      setIconImage(Toolkit.getDefaultToolkit().getImage(GUIPrincipal.class.getResource("/tienda/icons/terminal.png")));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("CAJA REGISTRADORA");
      setSize(800,600);
      setLocationRelativeTo(null);
      contenedor=new JPanel(new BorderLayout());
      setContentPane(contenedor);
      /* Barra de menus */
      barraMenus=new JMenuBar();
      contenedor.add(barraMenus,BorderLayout.NORTH);
      for(int i=0; i<menus.length; i++)
      {
         menus[i]=new JMenu(nomMenus[i]);
         barraMenus.add(menus[i]);
         items[i]=new JMenuItem(nomItemMenus[i]);
         items[i].addActionListener(this);
         menus[i].add(items[i]);
      }
      /* DesktopPane para el JInternalFrame */
      pEscr=new Escritorio();
      contenedor.add(pEscr,BorderLayout.CENTER);
   }
   
   public void actionPerformed(ActionEvent pE)
   {
      if(pE.getSource().equals(items[0]))
      {
         /* Ajustes para centrar el internalFrame */
         int x=(pEscr.getWidth()/2)-(ifIS.getWidth()/2);
         int y=(pEscr.getHeight()/2)-(ifIS.getHeight()/2);
         if(ifIS.isShowing())
         {
            ifIS.setLocation(x,y);
         }
         else
         {
            pEscr.add(ifIS);
            ifIS.setLocation(x,y);
            ifIS.show();
         }
      }
      else if(pE.getSource().equals(items[1]))
      {
         int x=(pEscr.getWidth()/2)-(ifProductos.getWidth()/2);
         int y=(pEscr.getHeight()/2)-(ifProductos.getHeight()/2);
         if(ifProductos.isShowing())
         {
            ifProductos.setLocation(x,y);
         }
         else
         {
            pEscr.add(ifProductos);
            ifProductos.setLocation(x,y);
            ifProductos.show();
         }
      }
   }
}
