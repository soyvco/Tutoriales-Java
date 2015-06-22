package tienda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;

public class IFUsuarios extends JInternalFrame implements ActionListener
{
   private JComboBox<String> cbTipoUsuario;
   private JPasswordField    passUsuario;
   private JTextField[]      campos             =new JTextField[2];
   private String[]          ubicacionCampos    ={"cell 3 3,grow"," cell 3 5,grow"};
   private JLabel[]          etiquetas          =new JLabel[4];
   private String[]          nomEtiquetas       ={"Tipo:","Clave:","Nombre:","Contraseña:"};
   private String[]          ubicacionEtiquetas ={"cell 1 1, grow"," cell 1 3, grow","cell 1 5, grow","cell 1 7, grow"};
   private Object[][]        datosUsuarios      ={{"22","Víctor Romero","123","Administrador"},{"69","Cesar Fuentes","456","Administrador"},{"07","Javier Aguilar","789","Administrador"}};
   private String[]          columnas           ={"Clave","Nombre","Contraseña","Tipo"};
   private JButton[]         botones            =new JButton[3];
   private String[]          titulosBotones     ={"Añadir","Editar","Eliminar"};
   private String[]          iconosBotones      ={"/tienda/icons/sign-add.png","/tienda/icons/sign-sync.png","/tienda/icons/sign-delete.png"};
   private String[]          ubicacionBotones   ={"cell 1 9, grow","cell 3 9, grow","cell 5 9, grow"};
   private DefaultTableModel mdl;
   private JTable            table;
   private JScrollPane       scrollpane;
   
   public IFUsuarios()
   {
      setTitle("Gestion de usuarios");
      setClosable(true);
      setBorder(new EmptyBorder(0,0,0,0));
      setSize(400,400);
      getContentPane().setLayout(new MigLayout("", "[][grow][][grow][][grow][]", "[][grow][][grow][][grow][][grow][][grow][][]"));
      /* Etiquetas */
      for(int i=0; i<etiquetas.length; i++)
      {
         etiquetas[i]=new JLabel(nomEtiquetas[i]);
         getContentPane().add(etiquetas[i],ubicacionEtiquetas[i]);
      }
      /* Campos */
      for(int i=0; i<campos.length; i++)
      {
         campos[i]=new JTextField();
         campos[i].setEnabled(false);
         getContentPane().add(campos[i],ubicacionCampos[i]);
      }
      /* Botones */
      for(int i=0; i<botones.length; i++)
      {
         botones[i]=new JButton(titulosBotones[i]);
         botones[i].addActionListener(this);
         botones[i].setIcon(new ImageIcon(IFProductos.class.getResource(iconosBotones[i])));
         getContentPane().add(botones[i],ubicacionBotones[i]);
      }
      /* ComboBox */
      cbTipoUsuario=new JComboBox<String>();
      getContentPane().add(cbTipoUsuario,"cell 3 1,growx");
      /* Campo contraseña */
      passUsuario=new JPasswordField();
      passUsuario.setEnabled(false);
      getContentPane().add(passUsuario,"cell 3 7,growx");
      /* Imagen */
      JLabel lblImagen=new JLabel(new ImageIcon(IFUsuarios.class.getResource("/tienda/icons/user-id1.png")));
      getContentPane().add(lblImagen,"cell 5 1 1 7,alignx center,aligny center");
      /* Tabla */
      mdl=new DefaultTableModel(datosUsuarios,columnas);
      table=new JTable(mdl);
      scrollpane=new JScrollPane();
      scrollpane.setViewportView(table);
      getContentPane().add(scrollpane,"cell 1 11 5 2,grow");
   }
   
   public void actionPerformed(ActionEvent pE)
   {
   }
}
