import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;

public class IFCobros extends JInternalFrame
{
   private DefaultTableModel mdl;
   String[]          columnas ={"Código","Nombre","Precios"};
   Object[][]        datos    ={{"0001","Fabuloso",new Integer(20)},{"0002","Cloralex",new Integer(10)},{"0003","Pino",new Integer(40)}};
   private JTable      table;
   JScrollPane       scrollpane;
   
   public IFCobros()
   {
      /* Ajustes ventana */
      setClosable(true);
      setSize(600,600);
      getContentPane().setLayout(new MigLayout("","[][grow][][grow][][grow][][grow][][grow][]","[][grow][][grow][][grow][][grow][]"));
      /* Tabla */
      mdl=new DefaultTableModel(datos,columnas);
      table=new JTable(mdl);
      scrollpane=new JScrollPane();
      scrollpane.setViewportView(table);
      getContentPane().add(scrollpane,"cell 1 6 5 2,grow");
   }
}