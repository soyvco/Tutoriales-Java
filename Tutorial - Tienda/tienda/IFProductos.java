package tienda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.EmptyBorder;

public class IFProductos extends JInternalFrame implements ActionListener
{
   private JLabel[]          etiquetas          =new JLabel[3];
   private String[]          nombreEtiquetas    ={"Clave:","Nombre:","Precio:"};
   private String[]          ubicacionEtiquetas ={"cell 1 1, grow","cell 1 3, grow","cell 1 5, grow"};
   private JTextField[]      campos             =new JTextField[3];
   private String[]          ubicacionCampos    ={"cell 3 1, grow","cell 3 3, grow","cell 3 5, grow"};
   private JButton[]         botones            =new JButton[3];
   private String[]          nombreBotones      ={"Agregar","Modificar","Eliminar"};
   private String[]          iconosBotones      ={"/tienda/icons/sign-add.png","/tienda/icons/sign-sync.png","/tienda/icons/sign-delete.png"};
   private String[]          ubicacionBotones   ={"cell 1 7, grow","cell 3 7, grow","cell 5 7, grow"};
   private String[]          columnas           ={"Clave","Nombre","Precio","Cantidad"};
   private DefaultTableModel mdl;
   private JTable            table;
   private JScrollPane       scrollpane;
   
   public IFProductos()
   {
      setTitle("PRODUCTOS");
      setBorder(new EmptyBorder(0,0,0,0));
      /* Ajustes ventana */
      setClosable(true);
      setSize(400,400);
      getContentPane().setLayout(new MigLayout("","[][grow][][grow][][grow][]","[][grow][][grow][][grow][][grow][][grow][][grow][]"));
      /* Etiquetas */
      for(int i=0; i<etiquetas.length; i++)
      {
         etiquetas[i]=new JLabel(nombreEtiquetas[i]);
         getContentPane().add(etiquetas[i],ubicacionEtiquetas[i]);
      }
      /* Campos */
      for(int i=0; i<campos.length; i++)
      {
         campos[i]=new JTextField();
         getContentPane().add(campos[i],ubicacionCampos[i]);
      }
      /* Botones */
      for(int i=0; i<botones.length; i++)
      {
         botones[i]=new JButton(nombreBotones[i]);
         botones[i].addActionListener(this);
         botones[i].setIcon(new ImageIcon(IFProductos.class.getResource(iconosBotones[i])));
         getContentPane().add(botones[i],ubicacionBotones[i]);
      }
      /* Tabla */
      mdl=new DefaultTableModel();
      mdl.setColumnIdentifiers(columnas);
      table=new JTable(mdl);
      scrollpane=new JScrollPane();
      scrollpane.setViewportView(table);
      getContentPane().add(scrollpane,"cell 1 9 5 3,grow");
      JLabel lblImagen=new JLabel(new ImageIcon(IFProductos.class.getResource("/tienda/icons/basket.png")));
      getContentPane().add(lblImagen,"cell 5 1 1 6,grow");
   }
   
   public void actionPerformed(ActionEvent pE)
   {
   }
}