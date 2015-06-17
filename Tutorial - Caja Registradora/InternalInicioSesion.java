import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class InternalInicioSesion extends JInternalFrame implements ActionListener
{
   // "cell 4 0 2 2"
   private JLabel         lblEtiquetas[]        =new JLabel[3];
   private String         tituloEtiquetas[]     ={"Número del cajero:","Nombre del cajero:","Contraseña:"};
   private String         ubicaciónEtiquetas[]  ={"cell 1 1","cell 1 3","cell 1 5"};
   private String         iconosEtiquetas[]     ={""};
   private JTextField     txtCampos[]           =new JTextField[2];
   private String         ubicaciónTextfields[] ={"cell 3 1,grow","cell 3 3 3 1,grow"};
   private JLabel         imagen;
   private JPasswordField password;
   private JButton        bAcciones[]           =new JButton[2];
   
   public InternalInicioSesion()
   {
      /* Ajustes de la ventana */
      setTitle("INICIO DE SESIÓN DE CAJERO");
      setClosable(true);
      setSize(400,400);
      getContentPane().setLayout(new MigLayout("","[][][][grow][grow][][][]","[grow][][grow][][grow][][grow][]"));
      /* Etiquetas */
      for(int i=0; i<lblEtiquetas.length; i++)
      {
         lblEtiquetas[i]=new JLabel(tituloEtiquetas[i]);
         getContentPane().add(lblEtiquetas[i],ubicaciónEtiquetas[i]);
      }
      /* Textfields */
      for(int i=0; i<txtCampos.length; i++)
      {
         txtCampos[i]=new JTextField();
         getContentPane().add(txtCampos[i],ubicaciónTextfields[i]);
      }
      password=new JPasswordField();
      getContentPane().add(password,"cell 3 5 3 1,grow");
   }
   
   public void actionPerformed(ActionEvent pE)
   {
   }
}
