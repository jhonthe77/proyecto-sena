package interfaz;

import clases.*;
import arreglo.*;

import java.text.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import java.awt.CardLayout;
import java.awt.List;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.ComponentOrientation;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Cursor;

@SuppressWarnings({ "serial", "unused" })
public class tienda extends JFrame {

	private JPanel contentPane;
	Arreglos1 arreglo1 = new Arreglos1();
	Arreglos2 arreglo2 = new Arreglos2();
	Arreglos arreglo3 = new Arreglos();
	Arreglo4 td3 = new Arreglo4();

	DefaultTableModel tabla2 = new DefaultTableModel();
	DefaultTableModel tabla1 = new DefaultTableModel();
	DefaultTableModel tabla3 = new DefaultTableModel();
	DefaultTableModel tabla4 = new DefaultTableModel();

//---------------CLASE PARA CALCULAR EL TOTAL DE LAS VENTAS EL PROMEDIO Y LA CANTIDA-------------------------

	class calculo {

		private void calcular_tota() {

			double total = 0;

			int cantida_produtos = 0;

			int puesto = 0;

			for (int i = 0; i < table.getRowCount(); i++) {

				double columna;

				puesto++;

				int cantida = (int) table.getValueAt(i, 3);

				cantida_produtos += cantida;

				columna = (double) table.getValueAt(i, 4);

				total +=  columna;

			}

			DecimalFormat formato = new DecimalFormat();

			formato.setMaximumFractionDigits(0);

			txttotalT1.setText(formato.format(total));

			txtpromedio.setText(formato.format(total / puesto));

			txtcantida_productoT1.setText(String.valueOf(cantida_produtos));

		}

		private void calcular_tota1() {

			double total = 0;

			int cantida_produtos = 0;

			int puesto = 0;

			for (int i = 0; i < table_1.getRowCount(); i++) {

				double columna;

				puesto++;

				int cantida = (int) table_1.getValueAt(i, 3);

				cantida_produtos = cantida_produtos + cantida;

				columna = (double) table_1.getValueAt(i, 4);

				total = total + columna;

			}

			DecimalFormat formato = new DecimalFormat();

			formato.setMaximumFractionDigits(0);

			txttotalT3.setText(formato.format(total));

			txtpromedioT3.setText(formato.format(total / puesto));

			txtcantidaT3.setText(String.valueOf(cantida_produtos));

		}

		private void calcular_tota2() {

			double total1 = 0;

			int cantida_produtos1 = 0;

			int puesto1 = 0;

			for (int i = 0; i < table_2.getRowCount(); i++) {

				double columna1;

				puesto1++;

				int cantida1 = (int) table_2.getValueAt(i, 3);

				cantida_produtos1 = cantida_produtos1 + cantida1;

				columna1 = (double) table_2.getValueAt(i, 4);

				total1 = total1 + columna1;

			}

			DecimalFormat formato1 = new DecimalFormat();

			formato1.setMaximumFractionDigits(0);

			txttotalT2.setText(formato1.format(total1));

			txtpromedioT2.setText(formato1.format(total1 / puesto1));

			txtcantidaT2.setText(String.valueOf(cantida_produtos1));
			System.out.println("aqui");
		}

		private void calcular_totarp() {

			double total1 = 0;

			int cantida_produtos1 = 0;

			int puesto1 = 0;

			for (int i = 0; i < table_1.getRowCount(); i++) {

				double columna1;

				puesto1++;

				int cantida1 = (int) table_1.getValueAt(i, 3);

				cantida_produtos1 = cantida_produtos1 + cantida1;

				columna1 = (double) table_1.getValueAt(i, 4);

				total1 = total1 + columna1;

			}

			DecimalFormat formato1 = new DecimalFormat();

			formato1.setMaximumFractionDigits(0);

			txttotalv_rp.setText(formato1.format(total1));

			txtpromedio_rp.setText(formato1.format(total1 / puesto1));

			txtcantida_producto_rp.setText(String.valueOf(cantida_produtos1));
			System.out.println("aqui");
		}

	}

	calculo c = new calculo();

//---------------------------------FIN------------------------------------------------------------------------	

//--------------------CLASE PARA GENER REPORTE TOTAL DE LAS TIENDAS------------------------------------------

	class reportetotal extends calculo {

		public reportetotal(ArrayList<tiendas> ti) {

		}

	}

//---------------------------------------FIN --------------------------------------------------------------------	

	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txtcanti_hambur;
	private JTextField txtcantidaperro;
	private JTextField txtcantidaempanada;
	private JLabel lblNewLabel;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tienda frame = new tienda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JPanel tienda3 = new JPanel();
	JPanel tienda2 = new JPanel();
	JPanel tienda1 = new JPanel();
	JLayeredPane layeredPane = new JLayeredPane();
	private JTextField txtcantida_hamburgesat2;
	private JTextField txtcantidad_perrot2;
	private JTextField txtcantida_empanadat2;
	private JTextField txtcantida_hamburgesaT3;
	private JTextField txtcantida_peroT3;
	private JTextField txtcantida_empanadT3;
	private JTable table_1;
	private JTextField txttotalT1;
	private JTextField txtpromedio;
	private JTextField txtcantida_productoT1;
	private JTextField txtcantidaT2;
	private JTextField txttotalT2;
	private JTextField txtpromedioT2;
	private JTextField txtcantidaT3;
	private JTextField txttotalT3;
	private JTextField txtpromedioT3;
	private JTextField txtcantida_producto_rp;
	private JTextField txttotalv_rp;
	private JTextField txtpromedio_rp;
	private JTable table_3;

	public void cambiopanel(JPanel panel) {

		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	/**
	 * Create the frame.
	 */
	public tienda() {
		setForeground(Color.ORANGE);
		setFont(new Font("Poor Richard", Font.ITALIC, 20));
		setTitle("FAST FOOD JHON");
		setResizable(false);
		setBackground(Color.ORANGE);
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(tienda.class.getResource("/imagenes/tienda (1).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(370, 140, 1014, 658);
		contentPane = new JPanel();
		contentPane.setVerifyInputWhenFocusTarget(false);
		contentPane.setSize(new Dimension(1000, 600));
		contentPane.setMaximumSize(new Dimension(1000, 600));
		contentPane.setPreferredSize(new Dimension(1000, 600));
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		contentPane.add(layeredPane, "name_304676435425900");
		layeredPane.setLayout(new CardLayout(0, 0));

		JPanel adm_tiendas = new JPanel();
		adm_tiendas.setBackground(Color.ORANGE);
		layeredPane.add(adm_tiendas, "name_304524363076600");
		adm_tiendas.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(tienda.class
				.getResource("/imagenes/42190826-restaurante-de-comida-r\u00E1pida-ilustraci\u00F3n-3d.png")));
		lblNewLabel_1.setBounds(41, 93, 238, 210);
		adm_tiendas.add(lblNewLabel_1);

		JLabel lblNewLabel_1_3 = new JLabel("New label");
		lblNewLabel_1_3.setIcon(new ImageIcon(tienda.class
				.getResource("/imagenes/42190826-restaurante-de-comida-r\u00E1pida-ilustraci\u00F3n-3d.png")));
		lblNewLabel_1_3.setBounds(341, 159, 229, 201);
		adm_tiendas.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("New label");
		lblNewLabel_1_4.setIcon(new ImageIcon(tienda.class
				.getResource("/imagenes/42190826-restaurante-de-comida-r\u00E1pida-ilustraci\u00F3n-3d.png")));
		lblNewLabel_1_4.setBounds(635, 93, 238, 210);
		adm_tiendas.add(lblNewLabel_1_4);

		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/cajero.png")));
		lblNewLabel_6.setBounds(149, 436, 130, 128);
		adm_tiendas.add(lblNewLabel_6);

//----------------------------CAMBIO DE PANEL------------------------------------------------------------------------		

		JPanel REPORTE_GENERAL = new JPanel();
		JButton btnNewButton_3 = new JButton("REPORTE TOTAL");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cambiopanel(REPORTE_GENERAL);
			}
		});

//--------------------------------FIN----------------------------------------------------------------------

		btnNewButton_3.setBackground(Color.ORANGE);
		btnNewButton_3.setBounds(289, 499, 163, 29);
		adm_tiendas.add(btnNewButton_3);

		// ----------------------------CAMBIO DE
		// PANEL------------------------------------------------------------------------
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setBackground(Color.DARK_GRAY);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cambiopanel(tienda1);
			}
		});

//---------------------------------------FIN---------------------------------------------------------------------------------

		btnNewButton_5.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/first.png")));
		btnNewButton_5.setBounds(89, 301, 46, 44);
		adm_tiendas.add(btnNewButton_5);

//----------------------------CAMBIO DE PANEL------------------------------------------------------------------------		

		JButton btnNewButton_5_2 = new JButton("");
		btnNewButton_5_2.setBackground(Color.DARK_GRAY);
		btnNewButton_5_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiopanel(tienda3);
			}
		});

//-----------------------------------FIN--------------------------------------------------------------------	

		btnNewButton_5_2.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/third.png")));
		btnNewButton_5_2.setBounds(722, 329, 57, 41);
		adm_tiendas.add(btnNewButton_5_2);

//----------------------------CAMBIO DE PANEL------------------------------------------------------------------------		

		JButton btnNewButton_5_1 = new JButton("");
		btnNewButton_5_1.setBackground(Color.DARK_GRAY);
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiopanel(tienda2);
			}
		});

//--------------------------------FIN------------------------------------------------------------------------------

		btnNewButton_5_1.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/second.png")));
		btnNewButton_5_1.setBounds(434, 370, 55, 49);
		adm_tiendas.add(btnNewButton_5_1);

		JLabel lblNewLabel_8 = new JLabel("ADM Tiendas");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_8.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/fast-food (3).png")));
		lblNewLabel_8.setBounds(391, 32, 238, 80);
		adm_tiendas.add(lblNewLabel_8);

		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_9.setBackground(Color.ORANGE);
		btnNewButton_9.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/salida.png")));
		btnNewButton_9.setBounds(788, 10, 46, 44);
		adm_tiendas.add(btnNewButton_9);

		JLabel btn_tienda1 = new JLabel("New label");
		btn_tienda1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_tienda1.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/thumb-1920-571391.jpg")));
		btn_tienda1.setBounds(0, 0, 990, 616);
		adm_tiendas.add(btn_tienda1);

		tienda1.setAutoscrolls(true);
		layeredPane.add(tienda1, "name_304759159750100");
		tienda1.setLayout(null);

		JLabel jlbnombretienda1 = new JLabel("TIENDA 1");
		jlbnombretienda1.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/fast-food (2).png")));
		jlbnombretienda1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		jlbnombretienda1.setBounds(444, 10, 254, 170);
		tienda1.add(jlbnombretienda1);

		JLabel jlb1nombre_hambur = new JLabel("Hamburguesas");
		jlb1nombre_hambur.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlb1nombre_hambur.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/burger.png")));
		jlb1nombre_hambur.setBounds(48, 179, 132, 139);
		tienda1.add(jlb1nombre_hambur);
		JLabel jlbprecio_hamburgesa1 = new JLabel("5000");
		JButton btnhamburguesa1 = new JButton("VENDER");
		btnhamburguesa1.addActionListener(new ActionListener() {

			// ------------GENERAR VENTA DE HAMBURGUESAS
			// TIENDA1-----------------------------------------------------

			public void actionPerformed(ActionEvent e) {

				/*
				 * String nombre = jlbnombretienda1.getText();
				 * 
				 * String nombre_produto = jlb1nombre_hambur.getText();
				 * 
				 * int cantida = Integer.parseInt(txtcanti_hambur.getText());
				 * 
				 * double precio = Double.parseDouble(jlbprecio_hamburgesa1.getText());
				 * 
				 * tiendas t = new tiendas(nombre, nombre_produto, cantida, precio);
				 * 
				 * arreglo1.adicionar(t);
				 * 
				 * tabla2.setRowCount(0);
				 * 
				 * for (int i = 0; i < arreglo1.tamaño(); i++) {
				 * 
				 * Object[] fila = {
				 * 
				 * arreglo1.odtener(i).getNombre(), arreglo1.odtener(i).getProducto(),
				 * 
				 * arreglo1.odtener(i).getPrecio(), arreglo1.odtener(i).getCantida(),
				 * arreglo1.odtener(i).getTotal()
				 * 
				 * };
				 * 
				 * tabla2.addRow(fila);
				 * 
				 * txtcanti_hambur.setText("");
				 * 
				 * }
				 */
				
				Ventas v = new Ventas();
				v.vender(jlbnombretienda1, jlb1nombre_hambur, txtcanti_hambur, jlbprecio_hamburgesa1);
				txtcanti_hambur.setText("");
				v.consulatar(table,jlbnombretienda1);
			}

			// --------------------------FIN-------------------------------------------------------------------------------

		});
		btnhamburguesa1.setBackground(Color.ORANGE);
		btnhamburguesa1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnhamburguesa1.setBounds(61, 328, 85, 21);
		tienda1.add(btnhamburguesa1);

		JLabel jlbnombreperros_calientes = new JLabel("perros calientes");
		jlbnombreperros_calientes.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlbnombreperros_calientes.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/hot-dog.png")));
		jlbnombreperros_calientes.setBounds(340, 179, 132, 139);
		tienda1.add(jlbnombreperros_calientes);

//---------------------GENERAR VENTAS PERROS-----------------------------------------------------		

		JLabel jlbprecio_perros1 = new JLabel("4000");

		JButton btnperros1 = new JButton("VENDER");

		btnperros1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				/*
				 * String nombre = jlbnombretienda1.getText();
				 * 
				 * String nombre_produto = jlbnombreperros_calientes.getText();
				 * 
				 * int cantida = Integer.parseInt(txtcantidaperro.getText());
				 * 
				 * double precio = Double.parseDouble(jlbprecio_perros1.getText());
				 * 
				 * tiendas t = new tiendas(nombre, nombre_produto, cantida, precio);
				 * 
				 * arreglo1.adicionar(t);
				 * 
				 * tabla2.setRowCount(0);
				 * 
				 * for (int i = 0; i < arreglo1.tamaño(); i++) {
				 * 
				 * Object[] fila = {
				 * 
				 * arreglo1.odtener(i).getNombre(), arreglo1.odtener(i).getProducto(),
				 * 
				 * arreglo1.odtener(i).getPrecio(), arreglo1.odtener(i).getCantida(),
				 * arreglo1.odtener(i).getTotal()
				 * 
				 * };
				 * 
				 * if (jlbnombretienda1.getText().equalsIgnoreCase(nombre))
				 * 
				 * tabla2.addRow(fila);
				 * 
				 * txtcantidaperro.setText(""); }
				 */
				Ventas v = new Ventas();
				v.vender(jlbnombretienda1, jlbnombreperros_calientes, txtcantidaperro, jlbprecio_perros1);
				 txtcantidaperro.setText("");
				 v.consulatar(table,jlbnombretienda1);
			}
		});

//--------------------------FIN-------------------------------------------------------------------------------			

		btnperros1.setBackground(Color.ORANGE);
		btnperros1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnperros1.setBounds(369, 328, 85, 21);
		tienda1.add(btnperros1);

		JLabel jlbnombreEmpanadas = new JLabel("Empanadas");
		jlbnombreEmpanadas.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlbnombreEmpanadas.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/empanada.png")));
		jlbnombreEmpanadas.setBounds(669, 196, 132, 97);
		tienda1.add(jlbnombreEmpanadas);

//---------------------------GENERAR VENTAS EMPANADS --------------------------------------------------------------
		JLabel jlbprecio_empanada1 = new JLabel("800");

		JButton btn_empanadas1 = new JButton("VENDER");

		btn_empanadas1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * String nombre = jlbnombretienda1.getText();
				 * 
				 * String nombre_produto = jlbnombreEmpanadas.getText();
				 * 
				 * int cantida = Integer.parseInt(txtcantidaempanada.getText());
				 * 
				 * double precio = Double.parseDouble(jlbprecio_empanada1.getText());
				 * 
				 * tiendas t = new tiendas(nombre, nombre_produto, cantida, precio);
				 * 
				 * arreglo1.adicionar(t);
				 * 
				 * 
				 * 
				 * 
				 * 
				 * tabla2.setRowCount(0);
				 * 
				 * for (int i = 0; i < arreglo1.tamaño(); i++) {
				 * 
				 * Object[] fila = {
				 * 
				 * arreglo1.odtener(i).getNombre(), arreglo1.odtener(i).getProducto(),
				 * 
				 * arreglo1.odtener(i).getPrecio(), arreglo1.odtener(i).getCantida(),
				 * arreglo1.odtener(i).getTotal()
				 * 
				 * }; if (jlbnombretienda1.getText().equalsIgnoreCase(nombre))
				 * 
				 * tabla2.addRow(fila);
				 * 
				 * txtcantidaempanada.setText(""); }
				 */

				Ventas v = new Ventas();
				v.vender(jlbnombretienda1, jlbnombreEmpanadas, txtcantidaempanada, jlbprecio_empanada1);
				txtcantidaempanada.setText("");
				v.consulatar(table,jlbnombretienda1);
			}
		});

		btn_empanadas1.setBackground(Color.ORANGE);
		btn_empanadas1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_empanadas1.setBounds(670, 317, 85, 21);
		tienda1.add(btn_empanadas1);

		JLabel caja = new JLabel(" CAJA $");
		caja.setFont(new Font("Tahoma", Font.BOLD, 16));
		caja.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/cajero.png")));
		caja.setBounds(10, 376, 202, 139);
		tienda1.add(caja);

//----------------------------CAMBIO DE PANEL------------------------------------------------------------------------

		JButton btnsalir = new JButton("");
		btnsalir.setBackground(Color.ORANGE);
		btnsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cambiopanel(adm_tiendas);
			}
		});
//-----------------------------------FIN----------------------------------------------------------------		
		btnsalir.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/salida.png")));
		btnsalir.setBounds(846, 26, 64, 33);
		tienda1.add(btnsalir);

		jlbprecio_hamburgesa1.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlbprecio_hamburgesa1.setBounds(93, 159, 64, 21);
		tienda1.add(jlbprecio_hamburgesa1);

		jlbprecio_perros1.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlbprecio_perros1.setBounds(340, 150, 79, 30);
		tienda1.add(jlbprecio_perros1);

		jlbprecio_empanada1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jlbprecio_empanada1.setBounds(708, 170, 39, 34);
		tienda1.add(jlbprecio_empanada1);

		scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.DARK_GRAY);
		scrollPane.setBackground(Color.ORANGE);
		scrollPane.setBounds(500, 392, 461, 205);
		tienda1.add(scrollPane);

		table = new JTable();
		table.setGridColor(Color.BLACK);
		table.setSelectionForeground(Color.ORANGE);
		table.setBackground(Color.ORANGE);
		table.setEnabled(false);

		scrollPane.setViewportView(table);
		tabla2.addColumn("TIENDA 1");
		tabla2.addColumn("PRODCTO");
		tabla2.addColumn("PRECIO");
		tabla2.addColumn("CANTIDA");
		tabla2.addColumn("TOTAL");
		table.setModel(tabla2);

		txtcanti_hambur = new JTextField();
		txtcanti_hambur.setFocusTraversalPolicyProvider(true);
		txtcanti_hambur.setFocusCycleRoot(true);
		txtcanti_hambur.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		txtcanti_hambur.setBackground(Color.ORANGE);
		txtcanti_hambur.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtcanti_hambur.setBounds(190, 246, 96, 29);
		tienda1.add(txtcanti_hambur);
		txtcanti_hambur.setColumns(10);

		txtcantidaperro = new JTextField();
		txtcantidaperro.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		txtcantidaperro.setBackground(Color.ORANGE);
		txtcantidaperro.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtcantidaperro.setColumns(10);
		txtcantidaperro.setBounds(500, 242, 96, 29);
		tienda1.add(txtcantidaperro);

		txtcantidaempanada = new JTextField();
		txtcantidaempanada.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		txtcantidaempanada.setBackground(Color.ORANGE);
		txtcantidaempanada.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtcantidaempanada.setColumns(10);
		txtcantidaempanada.setBounds(816, 242, 96, 29);
		tienda1.add(txtcantidaempanada);

		lblNewLabel = new JLabel("CANTIDA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(190, 207, 85, 33);
		tienda1.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("CANTIDA");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(500, 199, 85, 33);
		tienda1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("CANTIDA");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(816, 199, 85, 33);
		tienda1.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("$");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(143, 162, 33, 14);
		tienda1.add(lblNewLabel_4);

		JLabel lblNewLabel_4_2 = new JLabel("$");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_2.setBounds(389, 159, 33, 14);
		tienda1.add(lblNewLabel_4_2);

		JLabel lblNewLabel_4_3 = new JLabel("$");
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_3.setBounds(747, 180, 33, 14);
		tienda1.add(lblNewLabel_4_3);

		JLabel jlb_totalT1 = new JLabel(" TOTAL VENTAS");
		jlb_totalT1.setHorizontalAlignment(SwingConstants.LEFT);
		jlb_totalT1.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlb_totalT1.setBounds(215, 503, 122, 33);
		tienda1.add(jlb_totalT1);

		txttotalT1 = new JTextField();
		txttotalT1.setDisabledTextColor(Color.BLACK);
		txttotalT1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttotalT1.setHorizontalAlignment(SwingConstants.RIGHT);
		txttotalT1.setBackground(Color.ORANGE);
		txttotalT1.setEnabled(false);
		txttotalT1.setBounds(357, 506, 132, 28);
		tienda1.add(txttotalT1);
		txttotalT1.setColumns(10);

		JLabel jlbpromedio = new JLabel("PROMDIO DE PRECIOS");
		jlbpromedio.setHorizontalAlignment(SwingConstants.LEFT);
		jlbpromedio.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlbpromedio.setBounds(180, 564, 167, 33);
		tienda1.add(jlbpromedio);

		txtpromedio = new JTextField();
		txtpromedio.setHorizontalAlignment(SwingConstants.RIGHT);
		txtpromedio.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpromedio.setDisabledTextColor(Color.BLACK);
		txtpromedio.setEnabled(false);
		txtpromedio.setColumns(10);
		txtpromedio.setBackground(Color.ORANGE);
		txtpromedio.setBounds(357, 567, 132, 28);
		tienda1.add(txtpromedio);

		JButton btngenerar_repoteT1 = new JButton("REPORTE GENRAL");
		btngenerar_repoteT1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//c.calcular_tota();
				Ventas v = new Ventas();
				v.consulatar(table, jlbnombretienda1);
				v.sumar(table, txttotalT1,txtcantida_productoT1,txtpromedio);
				v.calculototal(txttotalT1, jlbnombretienda1, txtcantida_productoT1);

			}
		});
		btngenerar_repoteT1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btngenerar_repoteT1.setBackground(Color.ORANGE);
		btngenerar_repoteT1.setBounds(10, 525, 142, 21);
		tienda1.add(btngenerar_repoteT1);

		txtcantida_productoT1 = new JTextField();
		txtcantida_productoT1.setEditable(false);
		txtcantida_productoT1.setFocusCycleRoot(true);
		txtcantida_productoT1.setFocusTraversalPolicyProvider(true);
		txtcantida_productoT1.setHorizontalAlignment(SwingConstants.RIGHT);
		txtcantida_productoT1.setBackground(Color.ORANGE);
		txtcantida_productoT1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtcantida_productoT1.setBounds(410, 447, 79, 28);
		tienda1.add(txtcantida_productoT1);
		txtcantida_productoT1.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("CANTIDA P");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(303, 449, 85, 22);
		tienda1.add(lblNewLabel_5);

		JLabel fondo = new JLabel("");
		fondo.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		fondo.setFont(new Font("Tahoma", Font.BOLD, 18));
		fondo.setIconTextGap(5);
		fondo.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/thumb-1920-571391.jpg")));
		fondo.setBounds(0, 0, 990, 616);
		tienda1.add(fondo);

		tienda2.setLayout(null);
		layeredPane.add(tienda2, "name_306971531426500");

		JLabel jlbnombre_tienda2 = new JLabel("TIENDA 2");
		jlbnombre_tienda2.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/fast-food (2).png")));
		jlbnombre_tienda2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		jlbnombre_tienda2.setBounds(421, 0, 237, 139);
		tienda2.add(jlbnombre_tienda2);

		JLabel jlbnon_phamburt2 = new JLabel("Hamburguesas");
		jlbnon_phamburt2.setFont(new Font("Tahoma", Font.BOLD, 16));
		jlbnon_phamburt2.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/burger.png")));
		jlbnon_phamburt2.setBounds(51, 159, 128, 139);
		tienda2.add(jlbnon_phamburt2);

//------------------------GENERAR VENTA HAMBURGUESA TIENDA 2-----------------------------------------------------

		JButton btnhamburgesat2 = new JButton("VENDER");
		txtcantida_hamburgesat2 = new JTextField();
		JLabel jlbprecio_hamburgesa1_1 = new JLabel("5000");
		btnhamburgesat2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * String nombre = jlbnombre_tienda2.getText();
				 * 
				 * String nombre_produto = jlbnon_phamburt2.getText();
				 * 
				 * int cantida = Integer.parseInt(txtcantida_hamburgesat2.getText());
				 * 
				 * double precio = Double.parseDouble(jlbprecio_hamburgesa1_1.getText());
				 * 
				 * tiendas t = new tiendas(nombre, nombre_produto, cantida, precio);
				 * arreglo2.adicionar(t);
				 * 
				 * tabla1.setRowCount(0);
				 * 
				 * for (int i = 0; i < arreglo2.tamaño(); i++) {
				 * 
				 * Object[] fila = {
				 * 
				 * arreglo2.odtener(i).getNombre(), arreglo2.odtener(i).getProducto(),
				 * 
				 * arreglo2.odtener(i).getPrecio(), arreglo2.odtener(i).getCantida(),
				 * arreglo2.odtener(i).getTotal()
				 * 
				 * };
				 * 
				 * tabla1.addRow(fila); txtcantida_hamburgesat2.setText(""); }
				 */
				Ventas v = new Ventas();
				v.vender(jlbnombre_tienda2, jlbnon_phamburt2, txtcantida_hamburgesat2, jlbprecio_hamburgesa1_1);
				txtcantida_hamburgesat2.setText("");
				v.consulatar(table_2,jlbnombre_tienda2);

			}
		});

		// ---------------------------------------------------FIN----------------------------------------------------------------

		btnhamburgesat2.setBackground(Color.ORANGE);
		btnhamburgesat2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnhamburgesat2.setBounds(72, 308, 97, 35);
		tienda2.add(btnhamburgesat2);

		JLabel jlbnom_p_perrost2 = new JLabel("perros calientes");
		jlbnom_p_perrost2.setFont(new Font("Tahoma", Font.BOLD, 10));
		jlbnom_p_perrost2.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/hot-dog.png")));
		jlbnom_p_perrost2.setBounds(338, 169, 135, 128);
		tienda2.add(jlbnom_p_perrost2);

//------------------------GENERAR VENTA PERROS TIENDA 2-----------------------------------------------------		

		JButton btn_vender_perrost2 = new JButton("VENDER");
		JLabel jlbprecio_perrost2 = new JLabel("4000");

		btn_vender_perrost2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * String nombre = jlbnombre_tienda2.getText();
				 * 
				 * String nombre_produto = jlbnom_p_perrost2.getText();
				 * 
				 * int cantida = Integer.parseInt(txtcantidad_perrot2.getText());
				 * 
				 * double precio = Double.parseDouble(jlbprecio_perrost2.getText());
				 * 
				 * tiendas t = new tiendas(nombre, nombre_produto, cantida, precio);
				 * arreglo2.adicionar(t);
				 * 
				 * tabla1.setRowCount(0);
				 * 
				 * for (int i = 0; i < arreglo2.tamaño(); i++) {
				 * 
				 * Object[] fila = {
				 * 
				 * arreglo2.odtener(i).getNombre(), arreglo2.odtener(i).getProducto(),
				 * 
				 * arreglo2.odtener(i).getPrecio(), arreglo2.odtener(i).getCantida(),
				 * arreglo2.odtener(i).getTotal()
				 * 
				 * };
				 * 
				 * tabla1.addRow(fila);
				 * 
				 * txtcantidad_perrot2.setText(""); }
				 */
				Ventas v = new Ventas();
				v.vender(jlbnombre_tienda2, jlbnom_p_perrost2, txtcantidad_perrot2, jlbprecio_perrost2);
				 txtcantidad_perrot2.setText("");
				 v.consulatar(table_2,jlbnombre_tienda2);
			}
		});

		// -------------------------------------FIN-----------------------------------------------------------------------------

		btn_vender_perrost2.setBackground(Color.ORANGE);
		btn_vender_perrost2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_vender_perrost2.setBounds(384, 324, 97, 35);
		tienda2.add(btn_vender_perrost2);

		JLabel jlbnom_p_empanadat2 = new JLabel("Empanadas");
		jlbnom_p_empanadat2.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlbnom_p_empanadat2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		jlbnom_p_empanadat2.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/empanada.png")));
		jlbnom_p_empanadat2.setBounds(656, 175, 128, 105);
		tienda2.add(jlbnom_p_empanadat2);

//------------------------GENERAR VENTA EMPANADAS TIENDA 2-----------------------------------------------------		

		JButton btnvender_empanast2 = new JButton("VENDER");

		JLabel jlbprecio_empanadat2 = new JLabel("800");

		btnvender_empanast2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * String nombre = jlbnombre_tienda2.getText();
				 * 
				 * String nombre_produto = jlbnom_p_empanadat2.getText();
				 * 
				 * int cantida = Integer.parseInt(txtcantida_empanadat2.getText());
				 * 
				 * double precio = Double.parseDouble(jlbprecio_empanadat2.getText());
				 * 
				 * tiendas t = new tiendas(nombre, nombre_produto, cantida, precio);
				 * arreglo2.adicionar(t);
				 * 
				 * tabla1.setRowCount(0);
				 * 
				 * for (int i = 0; i < arreglo2.tamaño(); i++) {
				 * 
				 * Object[] fila = {
				 * 
				 * arreglo2.odtener(i).getNombre(), arreglo2.odtener(i).getProducto(),
				 * 
				 * arreglo2.odtener(i).getPrecio(), arreglo2.odtener(i).getCantida(),
				 * arreglo2.odtener(i).getTotal()
				 * 
				 * };
				 * 
				 * tabla1.addRow(fila); txtcantida_empanadat2.setText(""); }
				 */
				
				Ventas v= new Ventas();
				v.vender(jlbnombre_tienda2, jlbnom_p_empanadat2, txtcantida_empanadat2, jlbprecio_empanadat2);
				 txtcantida_empanadat2.setText("");
				 v.consulatar(table_2,jlbnombre_tienda2);
			}
		});

//-------------------------FIN------------------------------------------------------------------		
		btnvender_empanast2.setBackground(Color.ORANGE);
		btnvender_empanast2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnvender_empanast2.setBounds(670, 277, 112, 34);
		tienda2.add(btnvender_empanast2);

		JLabel lblNewLabel_9_1 = new JLabel("CAJA$");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_9_1.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/cajero.png")));
		lblNewLabel_9_1.setBounds(10, 369, 135, 139);
		tienda2.add(lblNewLabel_9_1);

//----------------------------CAMBIO DE PANEL------------------------------------------------------------------------		

		JButton btnNewButton_8_1 = new JButton("");
		btnNewButton_8_1.setBackground(Color.ORANGE);
		btnNewButton_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiopanel(adm_tiendas);
			}
		});

//------------------------------FIN---------------------------------------------------------------------------

		btnNewButton_8_1.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/salida.png")));
		btnNewButton_8_1.setBounds(872, 36, 56, 41);
		tienda2.add(btnNewButton_8_1);

		JLabel lblNewLabel_9 = new JLabel("CANTIDA");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(196, 200, 85, 33);
		tienda2.add(lblNewLabel_9);

		jlbprecio_hamburgesa1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlbprecio_hamburgesa1_1.setBounds(86, 128, 48, 21);
		tienda2.add(jlbprecio_hamburgesa1_1);

		JLabel lblNewLabel_10 = new JLabel("CANTIDA");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(487, 200, 85, 33);
		tienda2.add(lblNewLabel_10);

		jlbprecio_empanadat2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jlbprecio_empanadat2.setBounds(832, 159, 39, 31);
		tienda2.add(jlbprecio_empanadat2);

		JLabel lblNewLabel_11 = new JLabel("CANTIDA");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_11.setBounds(832, 200, 85, 33);
		tienda2.add(lblNewLabel_11);

		jlbprecio_perrost2.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlbprecio_perrost2.setBounds(348, 129, 48, 30);
		tienda2.add(jlbprecio_perrost2);

		txtcantida_hamburgesat2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtcantida_hamburgesat2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		txtcantida_hamburgesat2.setColumns(10);
		txtcantida_hamburgesat2.setBackground(Color.ORANGE);
		txtcantida_hamburgesat2.setBounds(195, 237, 96, 29);
		tienda2.add(txtcantida_hamburgesat2);

		txtcantidad_perrot2 = new JTextField();
		txtcantidad_perrot2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtcantidad_perrot2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		txtcantidad_perrot2.setColumns(10);
		txtcantidad_perrot2.setBackground(Color.ORANGE);
		txtcantidad_perrot2.setBounds(483, 243, 96, 29);
		tienda2.add(txtcantidad_perrot2);

		txtcantida_empanadat2 = new JTextField();
		txtcantida_empanadat2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtcantida_empanadat2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		txtcantida_empanadat2.setColumns(10);
		txtcantida_empanadat2.setBackground(Color.ORANGE);
		txtcantida_empanadat2.setBounds(842, 243, 96, 29);
		tienda2.add(txtcantida_empanadat2);

		JLabel lblNewLabel_4_3_1 = new JLabel("$");
		lblNewLabel_4_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_3_1.setBounds(133, 128, 33, 21);
		tienda2.add(lblNewLabel_4_3_1);

		JLabel lblNewLabel_4_3_2 = new JLabel("$");
		lblNewLabel_4_3_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_3_2.setBounds(396, 128, 33, 31);
		tienda2.add(lblNewLabel_4_3_2);

		JLabel lblNewLabel_4_3_3 = new JLabel("$");
		lblNewLabel_4_3_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_3_3.setBounds(872, 162, 33, 24);
		tienda2.add(lblNewLabel_4_3_3);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(452, 369, 510, 217);
		tienda2.add(scrollPane_1);

		table_2 = new JTable();
		table_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_2.setBackground(Color.ORANGE);
		table_2.setSelectionForeground(Color.BLACK);
		table_2.setEnabled(false);
		scrollPane_1.setViewportView(table_2);
		tabla1.addColumn("TIENDA 2");
		tabla1.addColumn("PRODCTO");
		tabla1.addColumn("PRECIO");
		tabla1.addColumn("CANTIDA");
		tabla1.addColumn("TOTAL");
		table_2.setModel(tabla1);

		JLabel lblNewLabel_5_1 = new JLabel("CANTIDA P");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_1.setBounds(256, 438, 85, 22);
		tienda2.add(lblNewLabel_5_1);

		txtcantidaT2 = new JTextField();
		txtcantidaT2.setHorizontalAlignment(SwingConstants.RIGHT);
		txtcantidaT2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtcantidaT2.setFocusTraversalPolicyProvider(true);
		txtcantidaT2.setFocusCycleRoot(true);
		txtcantidaT2.setEditable(false);
		txtcantidaT2.setColumns(10);
		txtcantidaT2.setBackground(Color.ORANGE);
		txtcantidaT2.setBounds(363, 436, 79, 28);
		tienda2.add(txtcantidaT2);

		JLabel jlb_totalT1_1 = new JLabel(" TOTAL VENTAS");
		jlb_totalT1_1.setHorizontalAlignment(SwingConstants.LEFT);
		jlb_totalT1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlb_totalT1_1.setBounds(168, 492, 122, 33);
		tienda2.add(jlb_totalT1_1);

		txttotalT2 = new JTextField();
		txttotalT2.setHorizontalAlignment(SwingConstants.RIGHT);
		txttotalT2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttotalT2.setEnabled(false);
		txttotalT2.setDisabledTextColor(Color.BLACK);
		txttotalT2.setColumns(10);
		txttotalT2.setBackground(Color.ORANGE);
		txttotalT2.setBounds(310, 495, 132, 28);
		tienda2.add(txttotalT2);

		txtpromedioT2 = new JTextField();
		txtpromedioT2.setHorizontalAlignment(SwingConstants.RIGHT);
		txtpromedioT2.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpromedioT2.setEnabled(false);
		txtpromedioT2.setDisabledTextColor(Color.BLACK);
		txtpromedioT2.setColumns(10);
		txtpromedioT2.setBackground(Color.ORANGE);
		txtpromedioT2.setBounds(310, 556, 132, 28);
		tienda2.add(txtpromedioT2);

		JLabel jlbpromedio_1 = new JLabel("PROMDIO DE PRECIOS");
		jlbpromedio_1.setHorizontalAlignment(SwingConstants.LEFT);
		jlbpromedio_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlbpromedio_1.setBounds(133, 553, 167, 33);
		tienda2.add(jlbpromedio_1);

		JButton btngenerar_repoteT1_1 = new JButton("REPORTE GENRAL");
		btngenerar_repoteT1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//c.calcular_tota2();
				Ventas v = new Ventas();
				v.consulatar(table_2, jlbnombre_tienda2);
				v.sumar(table_2, txttotalT2,txtcantidaT2,txtpromedioT2);
				v.calculototal(txttotalT2, jlbnombre_tienda2, txtcantidaT2);

			}
		});
		btngenerar_repoteT1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btngenerar_repoteT1_1.setBackground(Color.ORANGE);
		btngenerar_repoteT1_1.setBounds(3, 522, 142, 21);
		tienda2.add(btngenerar_repoteT1_1);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("");
		lblNewLabel_1_1_1_2.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/thumb-1920-571391.jpg")));
		lblNewLabel_1_1_1_2.setBounds(0, 0, 990, 616);
		tienda2.add(lblNewLabel_1_1_1_2);

		tienda3.setLayout(null);
		layeredPane.add(tienda3, "name_309749899784100");

		JLabel jlbnombre_tiendaT3 = new JLabel("TIENDA 3");
		jlbnombre_tiendaT3.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/fast-food (2).png")));
		jlbnombre_tiendaT3.setFont(new Font("Tahoma", Font.ITALIC, 18));
		jlbnombre_tiendaT3.setBounds(413, 10, 237, 139);
		tienda3.add(jlbnombre_tiendaT3);

		JLabel jlbnomb_pro_ht3 = new JLabel("Hamburguesas");
		jlbnomb_pro_ht3.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/burger.png")));
		jlbnomb_pro_ht3.setFont(new Font("Tahoma", Font.BOLD, 16));
		jlbnomb_pro_ht3.setBounds(51, 159, 138, 139);
		tienda3.add(jlbnomb_pro_ht3);

//------------------------GENERAR VENTA HAMBURGESA TIENDA 3------------------------------------------------------				

		JButton btnvender_hamburesaT3 = new JButton("VENDER");
		JLabel jlbprecio_hamburgesaT3 = new JLabel("5000");
		btnvender_hamburesaT3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * String nombre = jlbnombre_tiendaT3.getText();
				 * 
				 * String nombre_produto = jlbnomb_pro_ht3.getText();
				 * 
				 * int cantida = Integer.parseInt(txtcantida_hamburgesaT3.getText());
				 * 
				 * double precio = Double.parseDouble(jlbprecio_hamburgesaT3.getText());
				 * 
				 * tiendas t = new tiendas(nombre, nombre_produto, cantida, precio);
				 * arreglo3.adicionar(t);
				 * 
				 * tabla3.setRowCount(0);
				 * 
				 * for (int i = 0; i < arreglo3.tamaño(); i++) {
				 * 
				 * Object[] fila = {
				 * 
				 * arreglo3.odtener(i).getNombre(), arreglo3.odtener(i).getProducto(),
				 * 
				 * arreglo3.odtener(i).getPrecio(), arreglo3.odtener(i).getCantida(),
				 * arreglo3.odtener(i).getTotal()
				 * 
				 * };
				 * 
				 * tabla3.addRow(fila); txtcantida_hamburgesaT3.setText(""); }
				 */
				Ventas v = new Ventas();
				v.vender(jlbnombre_tiendaT3, jlb1nombre_hambur, txtcantida_hamburgesaT3, jlbprecio_hamburgesaT3);
				txtcantida_hamburgesaT3.setText(""); 
				v.consulatar(table_1,jlbnombre_tiendaT3);
			}
		});

//-------------------------------------------FIN--------------------------------------------------------------------

		btnvender_hamburesaT3.setBackground(Color.ORANGE);
		btnvender_hamburesaT3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnvender_hamburesaT3.setBounds(72, 308, 85, 21);
		tienda3.add(btnvender_hamburesaT3);

		JLabel jlbnombre_perroT3 = new JLabel("perros calientes");
		jlbnombre_perroT3.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/hot-dog.png")));
		jlbnombre_perroT3.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlbnombre_perroT3.setBounds(322, 180, 138, 133);
		tienda3.add(jlbnombre_perroT3);

//------------------------GENERAR VENTA PERROS TIENDA 3------------------------------------------------------		

		JButton btnvender_perroT3 = new JButton("VENDER");
		JLabel jlbprecio_perrosT3 = new JLabel("4000");

		btnvender_perroT3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * String nombre = jlbnombre_tiendaT3.getText();
				 * 
				 * String nombre_produto = jlbnombre_perroT3.getText();
				 * 
				 * int cantida = Integer.parseInt(txtcantida_peroT3.getText());
				 * 
				 * double precio = Double.parseDouble(jlbprecio_perrosT3.getText());
				 * 
				 * tiendas t = new tiendas(nombre, nombre_produto, cantida, precio);
				 * arreglo3.adicionar(t);
				 * 
				 * tabla3.setRowCount(0);
				 * 
				 * for (int i = 0; i < arreglo3.tamaño(); i++) {
				 * 
				 * Object[] fila = {
				 * 
				 * arreglo3.odtener(i).getNombre(), arreglo3.odtener(i).getProducto(),
				 * 
				 * arreglo3.odtener(i).getPrecio(), arreglo3.odtener(i).getCantida(),
				 * arreglo3.odtener(i).getTotal()
				 * 
				 * };
				 * 
				 * tabla3.addRow(fila); txtcantida_peroT3.setText(""); }
				 */
				Ventas v = new Ventas();
				v.vender(jlbnombre_tiendaT3, jlbnombre_perroT3, txtcantida_peroT3, jlbprecio_perrosT3);
				txtcantida_peroT3.setText("");
				v.consulatar(table_1,jlbnombre_tiendaT3);
			}
		});

//-------------------------------------------FIN--------------------------------------------------------------------		

		btnvender_perroT3.setBackground(Color.ORANGE);
		btnvender_perroT3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnvender_perroT3.setBounds(450, 329, 85, 21);
		tienda3.add(btnvender_perroT3);

		JLabel jlbnombre_empanadaT3 = new JLabel("Empanadas");
		jlbnombre_empanadaT3.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/empanada.png")));
		jlbnombre_empanadaT3.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlbnombre_empanadaT3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		jlbnombre_empanadaT3.setBounds(660, 171, 131, 112);
		tienda3.add(jlbnombre_empanadaT3);

		// ------------------------GENERAR VENTA EMPANADAS TIENDA
		// 3------------------------------------------------------

		JButton btnvender_empandasT3 = new JButton("VENDER");
		JLabel jlbprecio_empanadaT3 = new JLabel("800");
		btnvender_empandasT3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * String nombre = jlbnombre_tiendaT3.getText();
				 * 
				 * String nombre_produto = jlbnombre_empanadaT3.getText();
				 * 
				 * int cantida = Integer.parseInt(txtcantida_empanadT3.getText());
				 * 
				 * double precio = Double.parseDouble(jlbprecio_empanadaT3.getText());
				 * 
				 * tiendas t = new tiendas(nombre, nombre_produto, cantida, precio);
				 * arreglo3.adicionar(t);
				 * 
				 * tabla3.setRowCount(0);
				 * 
				 * for (int i = 0; i < arreglo3.tamaño(); i++) {
				 * 
				 * Object[] fila = {
				 * 
				 * arreglo3.odtener(i).getNombre(), arreglo3.odtener(i).getProducto(),
				 * 
				 * arreglo3.odtener(i).getPrecio(), arreglo3.odtener(i).getCantida(),
				 * arreglo3.odtener(i).getTotal()
				 * 
				 * };
				 * 
				 * tabla3.addRow(fila); txtcantida_empanadT3.setText(""); }
				 */
				Ventas v = new Ventas();
				v.vender(jlbnombre_tiendaT3, jlbnombre_empanadaT3, txtcantida_empanadT3, jlbprecio_empanadaT3);
				txtcantida_empanadT3.setText("");
				v.consulatar(table_1,jlbnombre_tiendaT3);
			}
		});

//-------------------------------------------FIN--------------------------------------------------------------------			

		btnvender_empandasT3.setBackground(Color.ORANGE);
		btnvender_empandasT3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnvender_empandasT3.setBounds(685, 308, 85, 21);
		tienda3.add(btnvender_empandasT3);

		JLabel lblNewLabel_9_1_1 = new JLabel("CAJA$");
		lblNewLabel_9_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_9_1_1.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/cajero.png")));
		lblNewLabel_9_1_1.setBounds(10, 383, 138, 139);
		tienda3.add(lblNewLabel_9_1_1);

//----------------------------CAMBIO DE PANEL------------------------------------------------------------------------
		JButton btnNewButton_8_1_1 = new JButton("");
		btnNewButton_8_1_1.setBackground(Color.ORANGE);
		btnNewButton_8_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiopanel(adm_tiendas);
			}
		});

//---------------------------------FIN--------------------------------------------------------------------------

		btnNewButton_8_1_1.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/salida.png")));
		btnNewButton_8_1_1.setBounds(886, 10, 63, 39);
		tienda3.add(btnNewButton_8_1_1);

		txtcantida_hamburgesaT3 = new JTextField();
		txtcantida_hamburgesaT3.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtcantida_hamburgesaT3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		txtcantida_hamburgesaT3.setColumns(10);
		txtcantida_hamburgesaT3.setBackground(Color.ORANGE);
		txtcantida_hamburgesaT3.setBounds(199, 249, 96, 29);
		tienda3.add(txtcantida_hamburgesaT3);

		txtcantida_peroT3 = new JTextField();
		txtcantida_peroT3.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtcantida_peroT3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		txtcantida_peroT3.setColumns(10);
		txtcantida_peroT3.setBackground(Color.ORANGE);
		txtcantida_peroT3.setBounds(493, 256, 96, 29);
		tienda3.add(txtcantida_peroT3);

		txtcantida_empanadT3 = new JTextField();
		txtcantida_empanadT3.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtcantida_empanadT3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		txtcantida_empanadT3.setColumns(10);
		txtcantida_empanadT3.setBackground(Color.ORANGE);
		txtcantida_empanadT3.setBounds(815, 237, 96, 29);
		tienda3.add(txtcantida_empanadT3);

		JLabel lblNewLabel_9_2 = new JLabel("CANTIDA");
		lblNewLabel_9_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9_2.setBounds(199, 206, 85, 33);
		tienda3.add(lblNewLabel_9_2);

		JLabel lblNewLabel_9_3 = new JLabel("CANTIDA");
		lblNewLabel_9_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9_3.setBounds(488, 206, 85, 33);
		tienda3.add(lblNewLabel_9_3);

		JLabel lblNewLabel_9_4 = new JLabel("CANTIDA");
		lblNewLabel_9_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9_4.setBounds(815, 194, 85, 33);
		tienda3.add(lblNewLabel_9_4);

		JLabel lblNewLabel_4_3_3_1 = new JLabel("$");
		lblNewLabel_4_3_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_3_3_1.setBounds(137, 125, 33, 24);
		tienda3.add(lblNewLabel_4_3_3_1);

		JLabel lblNewLabel_4_3_3_2 = new JLabel("$");
		lblNewLabel_4_3_3_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_3_3_2.setBounds(502, 172, 33, 24);
		tienda3.add(lblNewLabel_4_3_3_2);

		JLabel lblNewLabel_4_3_3_3 = new JLabel("$");
		lblNewLabel_4_3_3_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_3_3_3.setBounds(865, 160, 33, 24);
		tienda3.add(lblNewLabel_4_3_3_3);

		jlbprecio_hamburgesaT3.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlbprecio_hamburgesaT3.setBounds(90, 128, 48, 21);
		tienda3.add(jlbprecio_hamburgesaT3);

		jlbprecio_perrosT3.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlbprecio_perrosT3.setBounds(450, 169, 48, 30);
		tienda3.add(jlbprecio_perrosT3);

		jlbprecio_empanadaT3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jlbprecio_empanadaT3.setBounds(829, 159, 39, 31);
		tienda3.add(jlbprecio_empanadaT3);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(437, 383, 523, 195);
		tienda3.add(scrollPane_2);

		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_1.setBackground(Color.ORANGE);
		table_1.setEnabled(false);
		scrollPane_2.setViewportView(table_1);
		tabla3.addColumn("TIENDA 3");
		tabla3.addColumn("PRODCTO");
		tabla3.addColumn("PRECIO");
		tabla3.addColumn("CANTIDA");
		tabla3.addColumn("TOTAL");
		table_1.setModel(tabla3);

		JLabel lblNewLabel_5_2 = new JLabel("CANTIDA P");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_2.setBounds(241, 458, 85, 22);
		tienda3.add(lblNewLabel_5_2);

		txtcantidaT3 = new JTextField();
		txtcantidaT3.setDisabledTextColor(Color.BLACK);
		txtcantidaT3.setEnabled(false);
		txtcantidaT3.setHorizontalAlignment(SwingConstants.RIGHT);
		txtcantidaT3.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtcantidaT3.setFocusTraversalPolicyProvider(true);
		txtcantidaT3.setFocusCycleRoot(true);
		txtcantidaT3.setEditable(false);
		txtcantidaT3.setColumns(10);
		txtcantidaT3.setBackground(Color.ORANGE);
		txtcantidaT3.setBounds(348, 456, 79, 28);
		tienda3.add(txtcantidaT3);

		JLabel jlb_totalT1_2 = new JLabel(" TOTAL VENTAS");
		jlb_totalT1_2.setHorizontalAlignment(SwingConstants.LEFT);
		jlb_totalT1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlb_totalT1_2.setBounds(153, 512, 122, 33);
		tienda3.add(jlb_totalT1_2);

		txttotalT3 = new JTextField();
		txttotalT3.setHorizontalAlignment(SwingConstants.RIGHT);
		txttotalT3.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttotalT3.setEnabled(false);
		txttotalT3.setDisabledTextColor(Color.BLACK);
		txttotalT3.setColumns(10);
		txttotalT3.setBackground(Color.ORANGE);
		txttotalT3.setBounds(295, 515, 132, 28);
		tienda3.add(txttotalT3);

		txtpromedioT3 = new JTextField();
		txtpromedioT3.setHorizontalAlignment(SwingConstants.RIGHT);
		txtpromedioT3.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpromedioT3.setEnabled(false);
		txtpromedioT3.setDisabledTextColor(Color.BLACK);
		txtpromedioT3.setColumns(10);
		txtpromedioT3.setBackground(Color.ORANGE);
		txtpromedioT3.setBounds(295, 576, 132, 28);
		tienda3.add(txtpromedioT3);

		JLabel jlbpromedio_2 = new JLabel("PROMDIO DE PRECIOS");
		jlbpromedio_2.setHorizontalAlignment(SwingConstants.LEFT);
		jlbpromedio_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlbpromedio_2.setBounds(118, 573, 167, 33);
		tienda3.add(jlbpromedio_2);

		JButton btngenerar_repoteT1_2 = new JButton("REPORTE GENRAL");
		btngenerar_repoteT1_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//c.calcular_tota1();
				Ventas v = new Ventas();
				v.consulatar(table_1, jlbnombre_tiendaT3);
				v.sumar(table_1, txttotalT3,txtcantidaT3,txtpromedioT3);
				v.calculototal(txttotalT3, jlbnombre_tiendaT3, txtcantidaT3);

			

			}
		});
		btngenerar_repoteT1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btngenerar_repoteT1_2.setBackground(Color.ORANGE);
		btngenerar_repoteT1_2.setBounds(153, 398, 142, 21);
		tienda3.add(btngenerar_repoteT1_2);

		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("New label");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_2_1.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/thumb-1920-571391.jpg")));
		lblNewLabel_1_1_1_2_1.setBounds(0, 0, 990, 616);
		tienda3.add(lblNewLabel_1_1_1_2_1);

		layeredPane.add(REPORTE_GENERAL, "name_1459377650100");
		REPORTE_GENERAL.setLayout(null);

		JLabel lblNewLabel_12 = new JLabel("REPORTE TOTAL DE VENTAS");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lblNewLabel_12.setBounds(387, 49, 312, 46);
		REPORTE_GENERAL.add(lblNewLabel_12);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBackground(Color.ORANGE);
		scrollPane_3.setBounds(112, 211, 702, 227);
		REPORTE_GENERAL.add(scrollPane_3);
		
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		tabla4.addColumn("TIENDA 3");
		tabla4.addColumn("PRODCTO");
		tabla4.addColumn("PRECIO");
		tabla4.addColumn("CANTIDA");
		tabla4.addColumn("TOTAL");

//----------------------------CAMBIO DE PANEL------------------------------------------------------------------------

		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cambiopanel(adm_tiendas);
			}
		});

//----------------------------FIN--------------------------------------------------------------------------------------

		btnNewButton.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/salida.png")));
		btnNewButton.setBounds(847, 45, 72, 46);
		REPORTE_GENERAL.add(btnNewButton);

//-----------------------GENERAR REPORTE TOTAL DE VENTAS--------------------------------------------------------		

		JButton btnreportegeneral = new JButton("GENERAR");
		btnreportegeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * tabla4.setRowCount(0);
				 * 
				 * for (int i = 0; i < arreglo1.tamaño(); i++) {
				 * 
				 * Object[] fila = {
				 * 
				 * arreglo1.odtener(i).getNombre(), arreglo1.odtener(i).getProducto(),
				 * 
				 * arreglo1.odtener(i).getPrecio(), arreglo1.odtener(i).getCantida(),
				 * arreglo1.odtener(i).getTotal()
				 * 
				 * };
				 * 
				 * tabla4.addRow(fila);
				 * 
				 * c.calcular_totarp();
				 * 
				 * }
				 * 
				 * for (int i = 0; i < arreglo2.tamaño(); i++) {
				 * 
				 * Object[] fila = {
				 * 
				 * arreglo2.odtener(i).getNombre(), arreglo2.odtener(i).getProducto(),
				 * 
				 * arreglo2.odtener(i).getPrecio(), arreglo2.odtener(i).getCantida(),
				 * arreglo2.odtener(i).getTotal()
				 * 
				 * };
				 * 
				 * tabla4.addRow(fila);
				 * 
				 * c.calcular_totarp();
				 * 
				 * }
				 * 
				 * for (int i = 0; i < arreglo3.tamaño(); i++) {
				 * 
				 * Object[] fila = {
				 * 
				 * arreglo3.odtener(i).getNombre(), arreglo3.odtener(i).getProducto(),
				 * 
				 * arreglo3.odtener(i).getPrecio(), arreglo3.odtener(i).getCantida(),
				 * arreglo3.odtener(i).getTotal()
				 * 
				 * };
				 * 
				 * tabla4.addRow(fila); c.calcular_totarp();
				 * 
				 * }
				 */
				
				Ventas v = new Ventas();
				
				v.consulta(table_3);
				v.sumar2(table_3, txttotalv_rp, txtcantida_producto_rp, txtpromedio_rp);
				
				

			}
		});

//----------------------------------------------FIN---------------------------------------------------------------------

		btnreportegeneral.setBackground(Color.ORANGE);
		btnreportegeneral.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnreportegeneral.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/cash.png")));
		btnreportegeneral.setBounds(130, 114, 227, 87);
		REPORTE_GENERAL.add(btnreportegeneral);

//----------------------BORRO TODA LA INFORMACION DE LAS TIENDEAS----------------------------------------------------------------		

		JButton btnNewButton_1 = new JButton("BORRAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * int filas = table_3.getRowCount(); int filas2 = table.getRowCount(); int
				 * filas3 = table_1.getRowCount(); int filas4 = table_2.getRowCount();
				 * 
				 * for (int i = filas - 1; i >= 0; i--) {
				 * 
				 * tabla4.removeRow(i);
				 * 
				 * }
				 * 
				 * for (int l = filas4 - 1; l >= 0; l--) { tabla1.removeRow(l); } for (int k =
				 * filas3 - 1; k >= 0; k--) { tabla3.removeRow(k); } for (int j = filas2 - 1; j
				 * >= 0; j--) { tabla2.removeRow(j);
				 * 
				 * }
				 * 
				 * for (int m = 0; m < arreglo1.tamaño(); m++) {
				 * 
				 * arreglo1.borrar();
				 * 
				 * }
				 * 
				 * for (int i = 0; i < arreglo2.tamaño(); i++) { arreglo2.borrar(); }
				 * 
				 * for (int j = 0; j < arreglo3.tamaño(); j++) { arreglo3.borrar(); }
				 */

				txttotalv_rp.setText("");
				txtcantida_producto_rp.setText("");
				txtpromedio_rp.setText(null);

			}
		});

//-----------------------------------------------------------------FIN--------------------------------------------------

		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/delete-file (1).png")));
		btnNewButton_1.setBounds(537, 114, 217, 87);
		REPORTE_GENERAL.add(btnNewButton_1);

		JLabel lblNewLabel_5_2_1 = new JLabel("CANTIDA DE PRODUCTOS");
		lblNewLabel_5_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_2_1.setBounds(32, 553, 196, 22);
		REPORTE_GENERAL.add(lblNewLabel_5_2_1);

		txtcantida_producto_rp = new JTextField();
		txtcantida_producto_rp.setHorizontalAlignment(SwingConstants.RIGHT);
		txtcantida_producto_rp.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtcantida_producto_rp.setFocusTraversalPolicyProvider(true);
		txtcantida_producto_rp.setFocusCycleRoot(true);
		txtcantida_producto_rp.setEnabled(false);
		txtcantida_producto_rp.setEditable(false);
		txtcantida_producto_rp.setDisabledTextColor(Color.BLACK);
		txtcantida_producto_rp.setColumns(10);
		txtcantida_producto_rp.setBackground(Color.ORANGE);
		txtcantida_producto_rp.setBounds(238, 552, 79, 26);
		REPORTE_GENERAL.add(txtcantida_producto_rp);

		txttotalv_rp = new JTextField();
		txttotalv_rp.setHorizontalAlignment(SwingConstants.RIGHT);
		txttotalv_rp.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttotalv_rp.setEnabled(false);
		txttotalv_rp.setDisabledTextColor(Color.BLACK);
		txttotalv_rp.setColumns(10);
		txttotalv_rp.setBackground(Color.ORANGE);
		txttotalv_rp.setBounds(487, 551, 132, 28);
		REPORTE_GENERAL.add(txttotalv_rp);

		JLabel jlb_totalT1_2_1 = new JLabel(" TOTAL VENTAS");
		jlb_totalT1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		jlb_totalT1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlb_totalT1_2_1.setBounds(355, 548, 122, 33);
		REPORTE_GENERAL.add(jlb_totalT1_2_1);

		JLabel jlbpromedio_2_1 = new JLabel("PROMDIO DE PRECIOS");
		jlbpromedio_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		jlbpromedio_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlbpromedio_2_1.setBounds(647, 547, 167, 33);
		REPORTE_GENERAL.add(jlbpromedio_2_1);

		txtpromedio_rp = new JTextField();
		txtpromedio_rp.setHorizontalAlignment(SwingConstants.RIGHT);
		txtpromedio_rp.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpromedio_rp.setEnabled(false);
		txtpromedio_rp.setDisabledTextColor(Color.BLACK);
		txtpromedio_rp.setColumns(10);
		txtpromedio_rp.setBackground(Color.ORANGE);
		txtpromedio_rp.setBounds(828, 550, 132, 28);
		REPORTE_GENERAL.add(txtpromedio_rp);

		JLabel fondo_1 = new JLabel("New label");
		fondo_1.setIcon(new ImageIcon(tienda.class.getResource("/imagenes/thumb-1920-571391.jpg")));
		fondo_1.setBounds(0, 0, 1000, 620);
		REPORTE_GENERAL.add(fondo_1);
	}
}
