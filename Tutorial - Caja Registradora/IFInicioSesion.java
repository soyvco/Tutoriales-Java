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
   private JLabel         lblEtiquetas[]        =new JLabel[3];
   private String         tituloEtiquetas[]     ={"Número del cajero:","Nombre del cajero:","Contraseña:"};
   private String         ubicaciónEtiquetas[]  ={"cell 1 1","cell 1 3","cell 1 5"};
   private JTextField     txtCampos[]           =new JTextField[2];
   private String         ubicaciónTextfields[] ={"cell 3 1,grow","cell 3 3 3 1,grow"};
   private JLabel         lblImagen;
   private JPasswordField password;
   private JButton        bAcciones[]           =new JButton[2];
   private String         tituloBotones[]       ={"Entrar","Salir"};
   private String         ubicacionBotones[]    ={"cell 3 6","cell 4 6"};
   private String         numUsuario[]          ={"22","25"};
   private String         nomUsuario[]          ={"Víctor Romero","José Bichel"};
   private String         passUsuario[]         ={"probando","sucontraseña"};
   
   public IFInicioSesion()
   {
      setBorder(new EmptyBorder(0,0,0,0));
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
      txtCampos[0].addKeyListener(this);
      txtCampos[1].setEditable(false);
      /* Campo de la contraseña */
      password=new JPasswordField();
      getContentPane().add(password,"cell 3 5 3 1,grow");
      /* Botones */
      for(int i=0; i<bAcciones.length; i++)
      {
         bAcciones[i]=new JButton(tituloBotones[i]);
         bAcciones[i].addActionListener(this);
         getContentPane().add(bAcciones[i],ubicacionBotones[i]);
      }
      // Este label solo es para colocar un icono de usuario...
      lblImagen=new JLabel(new ImageIcon(IFInicioSesion.class.getResource("/icons/user-red.png")));
      getContentPane().add(lblImagen,"cell 4 0 4 2");
   }
   
   public void actionPerformed(ActionEvent pE)
   {
      if(pE.getSource().equals(bAcciones[0]))
      {
         // Creamos variables para almacenar la contraseña y validarla
         char[] passObtenido=password.getPassword();
         String validarContraseña="";
         for(int i=0; i<passObtenido.length; i++)
         {
            // Aquí concatenamos los caracteres que nos da la contraseña
            validarContraseña+=passObtenido[i];
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
      // Cuando presionamos enter en la casilla de número de cajero, se
      // escribirá el nombre del cajero en la segunda casilla
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
