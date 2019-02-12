package administracionFacturas;

import com.mysql.jdbc.Statement;
import conexion.conex;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class RegistroFacturas extends JFrame {

	private JPanel contentPane;
	private JTextField txtrazonsocial;
	private JTextField txtcalle;
	private JTextField txtnoext;
	private JTextField txtnoint;
	private JTextField txtcp;
	private JTextField txtcolonia;
	private JTextField txtmunicipio;
	private JTextField txtciudad;
	private JTextField txtestado;
	private JTextField txtpais;
	private JTextField txtformapago;
	private JTextField txtnocuenta;
	private JTextField txtcantidad;
	private JTextField txtconcepto;
	private JTextField txtsubtotal;
	private JTextField txtiva;
	private JTextField txttotal;
	private JTable table;
	JComboBox cbcliente;
	private JTextField txtrfc;
	JComboBox cbmetodo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroFacturas frame = new RegistroFacturas();
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
	public RegistroFacturas() {
		setTitle("Registro de Factura");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/gemaltoico.png"))); 
		setLocationRelativeTo(this.getParent()); //coloca la ventana en el centro
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 761, 514);
		
		cbcliente = new JComboBox();
		cbcliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				obtendatoscliente();
			}
		});
		cbcliente.setBounds(82, 11, 388, 20);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 14, 62, 14);
		
		JLabel lblRaznSocial = new JLabel("Raz\u00F3n social:");
		lblRaznSocial.setBounds(10, 45, 75, 14);
		
		txtrazonsocial = new JTextField();
		txtrazonsocial.setEditable(false);
		txtrazonsocial.setBounds(83, 42, 654, 20);
		txtrazonsocial.setColumns(10);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setBounds(10, 71, 63, 14);
		
		txtcalle = new JTextField();
		txtcalle.setEditable(false);
		txtcalle.setBounds(83, 68, 654, 20);
		txtcalle.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("No. Ext.:");
		lblNewLabel.setBounds(10, 102, 63, 14);
		
		txtnoext = new JTextField();
		txtnoext.setEditable(false);
		txtnoext.setBounds(82, 99, 100, 20);
		txtnoext.setColumns(10);
		
		JLabel lblNoInterior = new JLabel("No. interior:");
		lblNoInterior.setBounds(270, 102, 69, 14);
		
		txtnoint = new JTextField();
		txtnoint.setEditable(false);
		txtnoint.setBounds(338, 99, 115, 20);
		txtnoint.setColumns(10);
		panel.setLayout(null);
		panel.add(cbcliente);
		panel.add(lblCliente);
		panel.add(lblRaznSocial);
		panel.add(txtrazonsocial);
		panel.add(lblCalle);
		panel.add(txtcalle);
		panel.add(lblNewLabel);
		panel.add(txtnoext);
		panel.add(lblNoInterior);
		panel.add(txtnoint);
		contentPane.add(panel);
		
		JLabel lblCp = new JLabel("C.P.:");
		lblCp.setBounds(536, 102, 37, 14);
		panel.add(lblCp);
		
		txtcp = new JTextField();
		txtcp.setEditable(false);
		txtcp.setBounds(576, 99, 161, 20);
		panel.add(txtcp);
		txtcp.setColumns(10);
		
		JLabel lblColonia = new JLabel("Colonia:");
		lblColonia.setBounds(10, 140, 46, 14);
		panel.add(lblColonia);
		
		txtcolonia = new JTextField();
		txtcolonia.setEditable(false);
		txtcolonia.setBounds(82, 137, 246, 20);
		panel.add(txtcolonia);
		txtcolonia.setColumns(10);
		
		JLabel lblMunicipio = new JLabel("Municipio:");
		lblMunicipio.setBounds(338, 140, 62, 14);
		panel.add(lblMunicipio);
		
		txtmunicipio = new JTextField();
		txtmunicipio.setEditable(false);
		txtmunicipio.setBounds(390, 137, 347, 20);
		panel.add(txtmunicipio);
		txtmunicipio.setColumns(10);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(10, 178, 46, 14);
		panel.add(lblCiudad);
		
		txtciudad = new JTextField();
		txtciudad.setEditable(false);
		txtciudad.setBounds(82, 175, 246, 20);
		panel.add(txtciudad);
		txtciudad.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(338, 178, 46, 14);
		panel.add(lblEstado);
		
		txtestado = new JTextField();
		txtestado.setEditable(false);
		txtestado.setBounds(390, 175, 152, 20);
		panel.add(txtestado);
		txtestado.setColumns(10);
		
		JLabel lblPais = new JLabel("Pais:");
		lblPais.setBounds(564, 178, 27, 14);
		panel.add(lblPais);
		
		txtpais = new JTextField();
		txtpais.setEditable(false);
		txtpais.setBounds(591, 175, 146, 20);
		panel.add(txtpais);
		txtpais.setColumns(10);
		
		JLabel label = new JLabel("_______________________________________________________________________________________________________________________");
		label.setBounds(10, 206, 727, 14);
		panel.add(label);
		
		JLabel lblNoCuenta = new JLabel("Metodo Pago:");
		lblNoCuenta.setBounds(10, 235, 89, 14);
		panel.add(lblNoCuenta);
		
		JLabel lblFormaDePago = new JLabel("Forma de Pago:");
		lblFormaDePago.setBounds(250, 234, 89, 14);
		panel.add(lblFormaDePago);
		
		cbmetodo = new JComboBox();
		cbmetodo.setModel(new DefaultComboBoxModel(new String[] {"Selecciona..", "DEPOSITO EN CUENTA", "CHEQUE", "TRANSFERENCIA", "TARJETA DE CREDITO", "TARJETA DE DEBITO"}));
		cbmetodo.setBounds(87, 231, 152, 20);
		panel.add(cbmetodo);
		
		txtformapago = new JTextField();
		txtformapago.setEditable(false);
		txtformapago.setText("PAGO EN UNA SOLA EXHIBICION");
		txtformapago.setBounds(349, 231, 168, 20);
		panel.add(txtformapago);
		txtformapago.setColumns(10);
		
		JLabel lblNoCuenta_1 = new JLabel("No. Cuenta:");
		lblNoCuenta_1.setBounds(557, 234, 75, 14);
		panel.add(lblNoCuenta_1);
		
		txtnocuenta = new JTextField();
		txtnocuenta.setBounds(623, 231, 114, 20);
		panel.add(txtnocuenta);
		txtnocuenta.setColumns(10);
		
		JLabel label_1 = new JLabel("_______________________________________________________________________________________________________________________");
		label_1.setBounds(10, 256, 727, 14);
		panel.add(label_1);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(10, 283, 63, 14);
		panel.add(lblCantidad);
		
		txtcantidad = new JTextField();
		txtcantidad.setEditable(false);
		txtcantidad.setText("1");
		txtcantidad.setBounds(82, 278, 75, 20);
		panel.add(txtcantidad);
		txtcantidad.setColumns(10);
		
		JLabel lblConcepto = new JLabel("Concepto:");
		lblConcepto.setBounds(200, 281, 63, 14);
		panel.add(lblConcepto);
		
		txtconcepto = new JTextField();
		txtconcepto.setEditable(false);
		txtconcepto.setText("SERVICIO DE ESTACIONAMIENTO");
		txtconcepto.setBounds(260, 278, 477, 20);
		panel.add(txtconcepto);
		txtconcepto.setColumns(10);
		
		JLabel lblSubtotal = new JLabel("Subtotal:");
		lblSubtotal.setBounds(550, 369, 63, 14);
		panel.add(lblSubtotal);
		
		txtsubtotal = new JTextField();
		txtsubtotal.setText("0.00");
		txtsubtotal.setBounds(622, 363, 115, 24);
		panel.add(txtsubtotal);
		txtsubtotal.setColumns(10);
		
		JLabel lblIva = new JLabel("Iva:");
		lblIva.setBounds(571, 404, 27, 14);
		panel.add(lblIva);
		
		txtiva = new JTextField();
		txtiva.setText("0.00");
		txtiva.setColumns(10);
		txtiva.setBounds(622, 399, 115, 24);
		panel.add(txtiva);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(562, 444, 40, 14);
		panel.add(lblTotal);
		
		txttotal = new JTextField();
		txttotal.setText("0.00");
		txttotal.setColumns(10);
		txttotal.setBounds(622, 438, 115, 24);
		panel.add(txttotal);
		
		JButton btnGenerar = new JButton("Guardar");
		//btnGenerar.setIcon(new ImageIcon(getClass().getResource("/Agregar.png")));
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtrfc.equals("")){
					JOptionPane.showMessageDialog(null, "Falta selecionar un cliente");
					
				}else{
					String patharchivos=new File ("").getAbsolutePath ()+"\\facturacion\\";					
					String idcliente=cbcliente.getSelectedItem().toString();
					idcliente=id_inicial(idcliente);
					
					
					
					int factura_nueva=0;					
					conex conn;
		            conn = new conex();
		            PreparedStatement pstm;
		            try {
		            		
		            	pstm = (PreparedStatement) conn.getConnection().prepareStatement("SELECT * from to_parametros where clave='FACTURA'");
						ResultSet rs100 = (ResultSet) pstm.executeQuery();
					    while (rs100.next()) {					    	
					    	factura_nueva=rs100.getInt("parametro"); 
						}
					    rs100.close();
		            	
					    factura_nueva=factura_nueva+1;
		            	
		                   pstm = (PreparedStatement) conn.getConnection().prepareStatement("insert into to_facturas (idr_cliente,noCuenta,MetodoPago,FormaPagos,cantidad,unidad,concepto,subtotal,iva, Monto, factura, FechaGeneracion) values ('"+idcliente+"','"+txtnocuenta.getText().trim()+"','"+cbmetodo.getSelectedItem().toString()+"','"+txtformapago.getText().trim()+"','"+txtcantidad.getText().trim()+"','SERVICIO','"+txtconcepto.getText().trim()+"','"+txtsubtotal.getText().trim()+"','"+txtiva.getText().trim()+"','"+txttotal.getText().trim()+"','"+factura_nueva+"',now())");
		                   pstm.executeUpdate();		                      
		               } catch (SQLException ex) {
		                      Logger.getLogger(GenerarFactura.class.getName()).log(Level.SEVERE, null, ex);
		              }
                                    try {
                                        conn.desconectar();
                                    } catch (SQLException ex) {
                                        Logger.getLogger(RegistroFacturas.class.getName()).log(Level.SEVERE, null, ex);
                                    }
		            
		            AgregarServiciosFactura factura=new AgregarServiciosFactura();
					factura.generarfactura(Integer.parseInt(idcliente),patharchivos,factura_nueva,"correo@hotmail.com","RAZON SOCIAL","tipo pago cliente","0");
				}
			}
		});
		btnGenerar.setBounds(591, 473, 146, 34);
		panel.add(btnGenerar);
		
		table = new JTable();
		table.setBounds(10, 342, 318, 165);
		panel.add(table);
		
		JLabel lblRfc = new JLabel("RFC:");
		lblRfc.setBounds(510, 14, 46, 14);
		panel.add(lblRfc);
		
		txtrfc = new JTextField();
		txtrfc.setEditable(false);
		txtrfc.setBounds(561, 11, 176, 20);
		panel.add(txtrfc);
		txtrfc.setColumns(10);
		
		cargarclientes();
	}
	
	
	public void cargarclientes(){
			cbcliente.removeAllItems();  
	        cbcliente.addItem("Selecciona.."); 
	        
	        conex con;
	        con = new conex();              	                           
	        String myQuery = "SELECT * from tc_clientes";   	        
	        try {
	        	PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement(myQuery);		 			
				ResultSet rs = (ResultSet) pstm.executeQuery();	        
	        while(rs.next()) {
	        	cbcliente.addItem(rs.getString("idcliente")+"-"+rs.getString("razon_social")); 
	        }
	        rs.close(); 
	        con.desconectar();
	        } catch (SQLException ex) {                
	        }  	        
	}
	
	public void obtendatoscliente(){
		String cliente=cbcliente.getSelectedItem().toString();
		
		if(cliente.equals("Selecciona..")){
			//JOptionPane.showMessageDialog(null, "Falta selecionar un cliente");	        		        
			txtrfc.setText("");	
			txtrazonsocial.setText("");	        
        	txtcalle.setText("");
        	txtnoext.setText("");	        
        	txtnoint.setText("");	        
        	txtcp.setText("");	        
        	txtcolonia.setText("");	        
        	txtmunicipio.setText("");	        
        	txtciudad.setText("");	        
        	txtestado.setText("");	        
        	txtpais.setText("");	 
		}else{
			cliente=id_inicial(cliente);
			conex con;
	        con = new conex();              	                           
	        String myQuery = "SELECT * from tc_clientes where idcliente="+cliente;   	        
	        try {
	        	PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement(myQuery);		 			
				ResultSet rs = (ResultSet) pstm.executeQuery();	        
	        while(rs.next()) {
	        	txtrfc.setText(rs.getString("rfc"));	        		        
	        	txtrazonsocial.setText(rs.getString("razon_social"));	        
	        	txtcalle.setText(rs.getString("calle"));
	        	txtnoext.setText(rs.getString("noext"));	        
	        	txtnoint.setText(rs.getString("no_interior"));	        
	        	txtcp.setText(rs.getString("cp"));	        
	        	txtcolonia.setText(rs.getString("colonia"));	        
	        	txtmunicipio.setText(rs.getString("municipio"));	        
	        	txtciudad.setText(rs.getString("ciudad"));	        
	        	txtestado.setText(rs.getString("estado"));	        
	        	txtpais.setText(rs.getString("pais"));	        
	        }
	        rs.close(); 
	        con.desconectar();
	        } catch (SQLException ex) {                
	        } 
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
