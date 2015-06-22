package tienda;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GUIPrincipal extends JFrame implements ActionListener
{
   private JPanel      contenedor;
   private Escritorio  pEscr;
   private JMenu[]     menus        =new JMenu[3];
   private String[]    nomMenus     ={"Caja","Productos","Usuarios"};
   private String[]    iconosMenus  ={"/tienda/icons/calculator.png","/tienda/icons/carton.png","/tienda/icons/profile.png"};
   private JMenuItem[] items        =new JMenuItem[3];
   private String[]    nomItemMenus ={"Cobrar","Administrar","Administrar"};
   private String[]    iconosItems  ={"/tienda/icons/money.png","/tienda/icons/box-in.png","/tienda/icons/profile-group.png"};
   private JMenuBar    barraMenus;
   static IFProductos  ifPr         =new IFProductos();
   static IFCobros     ifCo         =new IFCobros();
   static IFUsuarios   ifUs         =new IFUsuarios();
   
   public GUIPrincipal()
   {
      /* Configuración de la ventana */
      setIconImage(Toolkit.getDefaultToolkit().getImage(GUIPrincipal.class.getResource("/tienda/icons/shop.png")));
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
         menus[i].setIcon(new ImageIcon(GUIPrincipal.class.getResource(iconosMenus[i])));
         barraMenus.add(menus[i]);
         items[i]=new JMenuItem(nomItemMenus[i]);
         items[i].addActionListener(this);
         items[i].setIcon(new ImageIcon(GUIPrincipal.class.getResource(iconosItems[i])));
         menus[i].add(items[i]);
      }
      /* DesktopPane para el JInternalFrame */
      pEscr=new Escritorio();
      contenedor.add(pEscr,BorderLayout.CENTER);
   }
   
   public void actionPerformed(ActionEvent pE)
   {
      pEscr.removeAll();
      pEscr.repaint();
      pEscr.doLayout();
      if(pE.getSource().equals(items[0]))
      {
         /* Ajustes para centrar el internalFrame */
         int x=(pEscr.getWidth()/2)-(ifCo.getWidth()/2);
         int y=(pEscr.getHeight()/2)-(ifCo.getHeight()/2);
         if(ifCo.isShowing())
         {
            ifCo.setLocation(x,y);
         }
         else
         {
            pEscr.add(ifCo);
            ifCo.setLocation(x,y);
            ifCo.show();
         }
      }
      else if(pE.getSource().equals(items[1]))
      {
         int x=(pEscr.getWidth()/2)-(ifPr.getWidth()/2);
         int y=(pEscr.getHeight()/2)-(ifPr.getHeight()/2);
         if(ifPr.isShowing())
         {
            ifPr.setLocation(x,y);
         }
         else
         {
            pEscr.add(ifPr);
            ifPr.setLocation(x,y);
            ifPr.show();
         }
      }
      else if(pE.getSource().equals(items[2]))
      {
         int x=(pEscr.getWidth()/2)-(ifUs.getWidth()/2);
         int y=(pEscr.getHeight()/2)-(ifUs.getHeight()/2);
         if(ifUs.isShowing())
         {
            ifUs.setLocation(x,y);
         }
         else
         {
            pEscr.add(ifUs);
            ifUs.setLocation(x,y);
            ifUs.show();
         }
      }
   }
}
