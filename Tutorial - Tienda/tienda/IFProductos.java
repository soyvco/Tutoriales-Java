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
   private JLabel[]          lblEtiquetas     =new JLabel[3];
   private String[]          titulosLabels    ={"Clave:","Nombre:","Precio:"};
   private String[]          ubicacionLabels  ={"cell 1 1, grow","cell 1 3, grow","cell 1 5, grow"};
   private JTextField[]      txtCampos        =new JTextField[3];
   private String[]          ubicacionCampos  ={"cell 3 1, grow","cell 3 3, grow","cell 3 5, grow"};
   private JButton[]         bAcciones        =new JButton[3];
   private String[]          titulosBotones   ={"Agregar","Modificar","Eliminar"};
   private String[]          ubicacionBotones ={"cell 1 7, grow","cell 3 7, grow","cell 5 7, grow"};
   private String[]          columnas         ={"Clave","Nombre","Precio"};
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
      getContentPane().setLayout(new MigLayout("", "[][grow][][grow][][grow][]", "[][grow][][grow][][grow][][grow][][grow][][grow][]"));
      /* Etiquetas */
      for(int i=0; i<lblEtiquetas.length; i++)
      {
         lblEtiquetas[i]=new JLabel(titulosLabels[i]);
         getContentPane().add(lblEtiquetas[i],ubicacionLabels[i]);
      }
      /* Campos */
      for(int i=0; i<txtCampos.length; i++)
      {
         txtCampos[i]=new JTextField();
         getContentPane().add(txtCampos[i],ubicacionCampos[i]);
      }
      /* Botones */
      for(int i=0; i<bAcciones.length; i++)
      {
         bAcciones[i]=new JButton(titulosBotones[i]);
         bAcciones[i].addActionListener(this);
         getContentPane().add(bAcciones[i],ubicacionBotones[i]);
      }
      /* Tabla */
      mdl=new DefaultTableModel();
      mdl.setColumnIdentifiers(columnas);
      table=new JTable(mdl);
      scrollpane=new JScrollPane();
      scrollpane.setViewportView(table);
      getContentPane().add(scrollpane,"cell 1 9 5 3,grow");
      JLabel lblImagen=new JLabel(new ImageIcon(IFInicioSesion.class.getResource("/icons/shop.png")));
      getContentPane().add(lblImagen,"cell 5 1 1 6,grow");
   }
   
   public void actionPerformed(ActionEvent pE)
   {
   }
}