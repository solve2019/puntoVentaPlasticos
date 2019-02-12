package administracionFacturas;



import com.mysql.jdbc.ResultSetMetaData;
import conexion.conex;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class VisorFacturas extends JFrame {

	private JPanel contentPane;

	
	
	
	private TableRowSorter<TableModel> sorter;
	conex cn;		
	Object[] object6 = null;
	//static JTable table=null;
	TABLE_MODEL name;		
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txtbuscar;
	private JComboBox jccliente;
	private JComboBox cbestatus;
	
	class TABLE_MODEL extends DefaultTableModel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;	
		
		public boolean isCellEditable(int row, int column) {

            //return false;

            // identificada por fila,columna (row,column), sea o no editable

            //if(column == 0){

             //  return true;

            //}else{

                  return false;

            //}

        }
		
		
		public TABLE_MODEL(){
			addColumn("ID");
			addColumn("FACTURA");
			addColumn("CLIENTE");
			addColumn("RFC");
			addColumn("TOTAL");
			addColumn("FECHA REGISTRO");			
			addColumn("FECHA CANCELACION");		
			addColumn("ESTATUS");	
			String consulta="";

			String sql="",cliente="",estatus="";
			if(jccliente.getSelectedItem()==null){				
			}else{
				cliente=jccliente.getSelectedItem().toString();	
			}			
			if(cliente.equals("Selecciona..")){			
			}else if(cliente.equals("")){				
			}else{
				sql=" and to_facturas.idr_cliente='"+id_inicial(cliente)+"'";
			}
			
			if(cbestatus.getSelectedItem()==null){				
			}else{
				estatus=cbestatus.getSelectedItem().toString();	
			}
			/*if(estatus.equals("")){			
			}else{
				sql=sql+" and to_facturas.estatus='"+estatus+"'";
			}*/
			
			
			
			
			consulta="SELECT to_facturas.Id, to_facturas.factura, tc_clientes.razon_social, tc_clientes.rfc, to_facturas.Monto, to_facturas.FechaGeneracion, to_facturas.fecha_cancelacion,to_facturas.estatus from to_facturas, tc_clientes where to_facturas.idr_cliente=tc_clientes.idcliente"+sql+" and to_facturas.estatus!=2 order by to_facturas.factura desc limit 5000";	
			System.out.println(consulta);
			try {
			    conex conexion2;
				conexion2 = new conex();
			    PreparedStatement pstm = (PreparedStatement) conexion2.getConnection().prepareStatement(consulta);		 			
				ResultSet rs = (ResultSet) pstm.executeQuery();
				ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
				int cantidadColumnas = rsMd.getColumnCount();					
				 while (rs.next()) {					 
				  object6 = new Object[cantidadColumnas+1];
				  for (int i = 1; i <= cantidadColumnas; i++) {
					  //System.out.print(rs.getObject(i));
						  object6[i-1]=rs.getObject(i);						  	
					 }
				  //System.out.println("agrega");
				  addRow(object6);					  					 
				 }
				 rs.close();
				 conexion2.desconectar();
				} catch (Exception ex) {
				 ex.printStackTrace();
				} finally {
				}
		}
	}
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisorFacturas frame = new VisorFacturas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VisorFacturas() {
		setResizable(false);
		setTitle("Visor de Facturas");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/gemaltoico.png"))); 
		setLocationRelativeTo(this.getParent()); //coloca la ventana en el centro
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 908, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 902, 422);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 113, 882, 265);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtbuscar = new JTextField();
		txtbuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {				
				
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				filtrar();
			}
		});
		txtbuscar.setBounds(85, 42, 188, 25);
		panel.add(txtbuscar);
		txtbuscar.setColumns(10);
		
		JLabel lblFacturasEnEl = new JLabel("Facturas en el sistema");
		lblFacturasEnEl.setForeground(new Color(255, 165, 0));
		lblFacturasEnEl.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFacturasEnEl.setBounds(10, 12, 285, 23);
		panel.add(lblFacturasEnEl);
		
		JLabel lblBuscador = new JLabel("No. Factura");
		lblBuscador.setBounds(10, 42, 86, 25);
		panel.add(lblBuscador);
		
		JButton btnPdf = new JButton("Ver PDF");
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int fila=-1;
		        fila=table.getSelectedRow();
		        if(fila<=-1){		        	
			    	JOptionPane.showMessageDialog(null,"Falta seleccionar una factura.","Mensaje",JOptionPane.PLAIN_MESSAGE);   	
			    }else{				
			    }
				
				
				
			}
		});
		btnPdf.setBounds(806, 78, 86, 31);
		panel.add(btnPdf);
		
		JButton btnVerXml = new JButton("Ver XML");
		btnVerXml.setBounds(714, 78, 86, 31);
		panel.add(btnVerXml);
		
		JButton btnCancelarFactura = new JButton("Cancelar Factura");
		btnCancelarFactura.setBounds(753, 380, 139, 31);
		panel.add(btnCancelarFactura);
		
		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setBounds(10, 84, 86, 25);
		panel.add(lblEmpresa);
		
		jccliente = new JComboBox();
		jccliente.setBounds(85, 84, 188, 25);
		panel.add(jccliente);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showJtable();
			}
		});
		btnBuscar.setBounds(281, 84, 86, 25);
		panel.add(btnBuscar);
		
		JLabel lblEstatus = new JLabel("Estatus");
		lblEstatus.setBounds(283, 42, 73, 25);
		panel.add(lblEstatus);
		
		cbestatus = new JComboBox();
		cbestatus.setModel(new DefaultComboBoxModel(new String[] {"PAGADO", "CANCELADO"}));
		cbestatus.setBounds(330, 42, 104, 25);
		panel.add(cbestatus);
		showJtable();
		
		 cargarclientes();
	}
	
	
	public void showJtable(){
		System.out.println("CARGA TABLA");
		
		name=new TABLE_MODEL();				  
		name.removeTableModelListener(table);//quita la tabla para que no mande errores		 
		table.setModel(name);	
		
		
		
		
		table.clearSelection();//para borrar la tabla y refrescar
		table.removeAll();
		
		sorter = new TableRowSorter<TableModel>(name);
		table.setRowSorter(sorter);
		
		
	}
private void filtrar() {
        System.out.println(txtbuscar.getText());
        RowFilter<TableModel, Object> rf = null;
       try {
           rf = RowFilter.regexFilter("(?i)"+txtbuscar.getText(),1);
       }catch (java.util.regex.PatternSyntaxException e) {
       }
       sorter.setRowFilter(rf);
   }



public void cargarclientes(){
	
		jccliente.removeAllItems();  
		jccliente.addItem("Selecciona.."); 
	    //jccheckpoint.addItem("DHL"); 
	    //jccheckpoint.addItem("ESTAFETA"); 
	    //jccheckpoint.addItem("UPS"); 
	    
		conex con;
		con = new conex();
	                   
	    ResultSet rs = null;                      
	    String myQuery = "SELECT idcliente,razon_social from tc_clientes order by razon_social asc";   
	    
	    try {
	    PreparedStatement st = (PreparedStatement) con.getConnection().prepareStatement(myQuery);	    
	    rs = (ResultSet) st.executeQuery();    
	    while(rs.next()) {
	    	jccliente.addItem(rs.getString("idcliente")+"-"+rs.getString("razon_social")); 
	    }
	    rs.close(); 
	    con.desconectar();
	    } catch (SQLException ex) {                
	    }      
   }

	private String id_inicial(String id){
	    String ids=id;
	    String[] temp=ids.split("-");
	    for(int i=0;i<1;i++){
	        ids=temp[i];
	    }
	return ids;
	}


}
