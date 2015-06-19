import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class IFInicioSesion extends JInternalFrame implements ActionListener,KeyListener
{
   private JPasswordField passwordField;
   private JLabel         lblEtiquetas[]        =new JLabel[3];
   private String         tituloEtiquetas[]     ={"Clave:","Nombre:","Contraseña:"};
   private String         ubicacionEtiquetas[]  ={"cell 1 1","cell 1 3","cell 1 5"};
   private JTextField     txtCampos[]           =new JTextField[2];
   private String         ubicacionTextfields[] ={"cell 3 1, growx","cell 3 3 2 1, growx"};
   private JButton        bAcciones[]           =new JButton[2];
   private String         tituloBotones[]       ={"Entrar","Salir"};
   private String         ubicacionBotones[]    ={"cell 1 7","cell 4 7"};
   private String         numUsuario[]          ={"22","25"};
   private String         nomUsuario[]          ={"Víctor Romero","José Bichel"};
   private String         passUsuario[]         ={"probando","suContrasena"};
   
   public IFInicioSesion()
   {
      setBorder(new EmptyBorder(0,0,0,0));
      /* Ajustes de la ventana */
      setTitle("INICIO DE SESIóN DE CAJERO");
      setClosable(true);
      setSize(280,250);
      getContentPane().setLayout(new MigLayout("","[][][][grow][]","[grow][][grow][][grow][][grow][][grow]"));
      /* Etiquetas */
      for(int i=0; i<lblEtiquetas.length; i++)
      {
         lblEtiquetas[i]=new JLabel(tituloEtiquetas[i]);
         getContentPane().add(lblEtiquetas[i],ubicacionEtiquetas[i]);
      }
      /* Textfields */
      for(int i=0; i<txtCampos.length; i++)
      {
         txtCampos[i]=new JTextField();
         getContentPane().add(txtCampos[i],ubicacionTextfields[i]);
      }
      txtCampos[0].addKeyListener(this);
      txtCampos[1].setEditable(false);
      /* Campo de la Contrasena */
      passwordField=new JPasswordField();
      getContentPane().add(passwordField,"cell 3 5 2 1,growx");
      /* Botones */
      for(int i=0; i<bAcciones.length; i++)
      {
         bAcciones[i]=new JButton(tituloBotones[i]);
         bAcciones[i].addActionListener(this);
         getContentPane().add(bAcciones[i],ubicacionBotones[i]);
      }
      JLabel label=new JLabel(new ImageIcon(IFInicioSesion.class.getResource("/icons/user-male.png")));
      getContentPane().add(label,"cell 4 1");
   }
   
   public void actionPerformed(ActionEvent pE)
   {
      if(pE.getSource().equals(bAcciones[0]))
      {
         // Creamos variables para almacenar la Contrasena y validarla
         char[] passObtenido=passwordField.getPassword();
         String validarContrasena="";
         for(int i=0; i<passObtenido.length; i++)
         {
            // AquÃ­ concatenamos los caracteres que nos da la Contrasena
            validarContrasena+=passObtenido[i];
         }
      }
      else if(pE.getSource().equals(bAcciones[1]))
      {
         dispose();
      }
   }
   
   public void keyTyped(KeyEvent pE)
   {
   }
   
   @SuppressWarnings("static-access")
   public void keyPressed(KeyEvent pE)
   {
      // Cuando presionamos enter en la casilla de nÃºmero de cajero, se
      // escribirÃ¡ el nombre del cajero en la segunda casilla
      if(pE.getKeyCode()==pE.VK_ENTER)
      {
         for(int i=0; i<numUsuario.length; i++)
         {
            if(txtCampos[0].getText().equals(numUsuario[i]))
            {
               txtCampos[1].setText(nomUsuario[i]);
            }
         }
      }
   }
   
   public void keyReleased(KeyEvent pE)
   {
   }
}
