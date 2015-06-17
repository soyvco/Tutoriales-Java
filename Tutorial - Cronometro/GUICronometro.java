import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;

public class GUICronometro extends JFrame implements ActionListener
{
   private JPanel      contentPane;
   private JPanel      pPie;
   private JLabel      lblCronometro;
   private JButton     bAcciones[]        =new JButton[3];
   private String      nombresBotones[]   ={"Iniciar","Pausar","Reiniciar"};
   private String      nombreIconos[]     ={"/PNG/Play Green Button.png","/PNG/Pause Green Button.png","/PNG/Stop Green Button.png"};
   private String      ubicacionBotones[] ={"cell 1 1","cell 3 1","cell 5 1"};
   private TCronometro cronometro;
   
   public GUICronometro()
   {
      setTitle("Cronometro");
      setIconImage(Toolkit.getDefaultToolkit().getImage(GUICronometro.class.getResource("/PNG/Mr. Bomb.png")));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(500,300);
      setLocationRelativeTo(null);
      setResizable(false);
      /* Paneles */
      contentPane=new JPanel(new BorderLayout());
      setContentPane(contentPane);
      pPie=new JPanel();
      contentPane.add(pPie,BorderLayout.SOUTH);
      pPie.setLayout(new MigLayout("","[grow][][grow][][grow][][grow]","[][grow][]"));
      /* Label */
      lblCronometro=new JLabel("00:00:00",SwingConstants.CENTER);
      lblCronometro.setIcon(new ImageIcon(GUICronometro.class.getResource("/PNG/History.png")));
      lblCronometro.setFont(new Font("Dialog",Font.BOLD,80));
      contentPane.add(lblCronometro,BorderLayout.CENTER);
      /* Botones */
      for(int i=0; i<bAcciones.length; i++)
      {
         bAcciones[i]=new JButton(nombresBotones[i]);
         bAcciones[i].setIcon(new ImageIcon(GUICronometro.class.getResource(nombreIconos[i])));
         bAcciones[i].addActionListener(this);
         pPie.add(bAcciones[i],ubicacionBotones[i]);
      }
      bAcciones[1].setEnabled(false);
      bAcciones[2].setEnabled(false);
   }
   
   @SuppressWarnings({"static-access","deprecation"})
   public void actionPerformed(ActionEvent pE)
   {
      if(pE.getSource().equals(bAcciones[0]))
      {
         if(cronometro.flag==0)
         {
            cronometro.flag=1;
            cronometro=new TCronometro(lblCronometro);
            cronometro.start();
            lblCronometro.setIcon(new ImageIcon(GUICronometro.class.getResource("/PNG/Appointment Urgent.png")));
         }
         else if(cronometro.flag==2)
         {
            cronometro.flag=1;
            cronometro.resume();
            lblCronometro.setIcon(new ImageIcon(GUICronometro.class.getResource("/PNG/Appointment Urgent.png")));
         }
         bAcciones[0].setEnabled(false);
         bAcciones[1].setEnabled(true);
         bAcciones[2].setEnabled(true);
      }
      else if(pE.getSource().equals(bAcciones[1]))
      {
         if(cronometro.flag==1)
         {
            cronometro.flag=2;
            cronometro.suspend();
            lblCronometro.setIcon(new ImageIcon(GUICronometro.class.getResource("/PNG/Appointment Cool.png")));
         }
         bAcciones[0].setText("Reanudar");
         bAcciones[0].setEnabled(true);
         bAcciones[1].setEnabled(false);
         bAcciones[2].setEnabled(true);
      }
      else if(pE.getSource().equals(bAcciones[2]))
      {
         if(cronometro.flag==1||cronometro.flag==2)
         {
            cronometro.flag=0;
            cronometro.stop();
            lblCronometro.setText("00:00:00");
            lblCronometro.setIcon(new ImageIcon(GUICronometro.class.getResource("/PNG/History.png")));
         }
         bAcciones[0].setEnabled(true);
         bAcciones[1].setEnabled(false);
         bAcciones[2].setEnabled(false);
      }
   }
}