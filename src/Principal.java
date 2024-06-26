import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Principal extends JFrame {

    String nombre = Bienvenida.nombre;

    ImageIcon img;

    static JMenuBar barraDeNavegacion;
    static JMenu menuOpciones, menuColorFondo;
    static JMenuItem itemRojo, itemAzul, itemNegro, itemSalir;

    JLabel labelBienvenido, labelNombre, labelimagen, labeltitulo;

    Color naranja;

    Font temaCooper, fontDefault;

    JButton botonCerrarSesion;

    Panel panelProductos, panelTrabajadores, panelClientes, panelFacturas;

    JButton btnCerrarSesion;

    public static void main(String[] args) {
        Principal xd = new Principal();
        xd.setVisible(true);
    }

    Principal(){
        iniciarGui();

        iniciarComponentes();

        ordenarComponentes();

        addComponentes();

        repintarPaneles();
    }

    public void iniciarGui(){
        setSize(1000,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setLayout(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("imagenes/icon.png")).getImage());
        setTitle("Sistema de gestión para trabajadores");
        
    }

    public void iniciarComponentes(){

        temaCooper = new Font("Cooper Black", 0, 35);

        fontDefault = new Font("Default", 1, 14);

        naranja = new Color(247, 122, 59);

        barraDeNavegacion = new JMenuBar();

        menuOpciones = new JMenu("OPCIONES EXTRA");
        menuColorFondo = new JMenu("Color de fondo");

        itemAzul = new JMenuItem("Azul");
        itemNegro = new JMenuItem("Negro");
        itemRojo = new JMenuItem("Rojo");

        itemSalir = new JMenuItem("Cerrar sesión");
        
        labelBienvenido = new JLabel("Bienvenido trabajador");
        labelNombre = new JLabel(nombre);
        labeltitulo = new JLabel("Sistema de gestión y control de la tienda");

        img = new ImageIcon(getClass().getResource("imagenes/logo.png"));
        labelimagen = new JLabel(img);

        String items[] = {"Seleccione una opción","Insertar","Eliminar","Modificar","Consultar"};
        
        panelClientes = new Panel("Para gestionar el control de los clientes", "Clientes",items);

        panelFacturas = new Panel("Para gestionar el control de las facturas", "Facturas",items);
        
        panelProductos = new Panel("Para gestionar el control de los productos", "Productos", items);
        
        panelTrabajadores = new Panel("Para gestionar el control de los trabajadores", "Trabajadores", items);

        btnCerrarSesion = new JButton("Cerrar sesión");
    }

    public void ordenarComponentes(){

        getContentPane().setBackground(Bienvenida.fondo);

        //Barra de navegación con sus items
        barraDeNavegacion.setBackground(new Color(247, 122, 59));

        menuOpciones.setFont(fontDefault);
        menuOpciones.setForeground(Color.white);
        barraDeNavegacion.add(menuOpciones);

        menuColorFondo.setFont(fontDefault);
        menuColorFondo.setForeground(naranja);
        menuOpciones.add(menuColorFondo);

        itemAzul.setFont(fontDefault);
        itemAzul.setForeground(naranja);
        itemAzul.addActionListener(new ItemAction());
        menuColorFondo.add(itemAzul);

        itemNegro.setFont(fontDefault);
        itemNegro.setForeground(naranja);
        itemNegro.addActionListener(new ItemAction());
        menuColorFondo.add(itemNegro);
        
        itemRojo.setFont(fontDefault);
        itemRojo.setForeground(naranja);
        itemRojo.addActionListener(new ItemAction());
        menuColorFondo.add(itemRojo);

        itemSalir.setFont(fontDefault);
        itemSalir.setForeground(naranja);
        itemSalir.addActionListener(new ItemAction());
        menuOpciones.add(itemSalir);
        
        //Componentes
        labelBienvenido.setBounds(20, 30, 400, 40);
        labelBienvenido.setFont(temaCooper);
        labelBienvenido.setForeground(Color.white);

        labelNombre.setBounds(20,70,500,30);
        labelNombre.setFont(temaCooper);
        labelNombre.setForeground(Color.white);

        labelimagen.setBounds(480, 30, 470, 46);

        labeltitulo.setBounds(143, 170, 713, 40);
        labeltitulo.setFont(temaCooper);
        labeltitulo.setForeground(Color.white);

        //Paneles 
        panelClientes.setBounds(40,300,200,250);

        panelFacturas.setBounds(280,300,200,250);

        panelProductos.setBounds(520, 300, 200, 250);

        panelTrabajadores.setBounds(760, 300, 200, 250);
    
        //Botón
        btnCerrarSesion.setBounds(400,590,200,30);
        btnCerrarSesion.setBackground(naranja);
        btnCerrarSesion.setForeground(Color.white);
        btnCerrarSesion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                Bienvenida ventBienvenida = new Bienvenida();
                ventBienvenida.setVisible(true);
                dispose();
            }
            
        });

    }

    public void addComponentes(){
        setJMenuBar(barraDeNavegacion);
        add(labelBienvenido);
        add(labelNombre);
        add(labelimagen);
        add(labeltitulo);
        add(panelClientes);
        add(panelFacturas);
        add(panelProductos);
        add(panelTrabajadores);
        add(btnCerrarSesion);
    }

    public void repintarPaneles(){
        panelClientes.setBackground(Bienvenida.fondo);
        panelFacturas.setBackground(Bienvenida.fondo);
        panelProductos.setBackground(Bienvenida.fondo);
        panelTrabajadores.setBackground(Bienvenida.fondo);
    }

    class Panel extends JPanel{
        JLabel parrafo;
        JButton btn;
        JComboBox comboRegistro;
        

        Panel(String textoParrafo, String textoBoton, String items[]){
            setLayout(null);
            btn = new JButton(textoBoton);
            parrafo = new JLabel("<html><center><p>"+textoParrafo+"</p></center><html>");
            comboRegistro = new JComboBox<>();
            parrafo.setForeground(Color.white);
            parrafo.setFont(fontDefault);

            for (int i = 0; i < items.length; i++) {
                comboRegistro.addItem(items[i]);
            }

            parrafo.setBounds(5, 0, 195, 160);

            comboRegistro.setBounds(15, 140, 170, 35);
            comboRegistro.setBackground(naranja);
            comboRegistro.setForeground(Color.white);

            
            btn.setBounds(15,190,170,35);
            btn.setBackground(naranja);
            btn.setForeground(Color.white);
            btn.addActionListener(new Action());

            setBorder(BorderFactory.createLineBorder(Color.yellow,2));
            setBackground(Bienvenida.fondo);
            add(comboRegistro);
            add(parrafo);
            add(btn);
        }
    
        class Action implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getActionCommand().equals("Clientes")){
                    System.out.println(comboRegistro.getSelectedItem());
                }
                if(e.getActionCommand().equals("Facturas")){
                    System.out.println(comboRegistro.getSelectedItem());
                }
                if(e.getActionCommand().equals("Productos")){
                    
                    if(comboRegistro.getSelectedItem().equals("Seleccione una opción")){
                        JOptionPane.showMessageDialog(null, "Seleccione una opción válida", "Advertencia", 1);
                    }

                    if(comboRegistro.getSelectedItem().equals("Eliminar")){
                        Borrar bor = new Borrar(); 
                        bor.setVisible(true);
                        dispose(); 
                   }
                   
                   if(comboRegistro.getSelectedItem().equals("Insertar")){
                       Insertar inser = new Insertar();  
                       inser.setVisible(true);
                       dispose(); 
                  }

                    if(comboRegistro.getSelectedItem().equals("Consultar")){
                        ConsultarProducto ventanaConsultarProducto = new ConsultarProducto();
                        ventanaConsultarProducto.setVisible(true);

                        dispose();
                    }

                    if(comboRegistro.getSelectedItem().equals("Modificar")){
                        ModificarProducto ventanaModificarProducto = new ModificarProducto();
                        ventanaModificarProducto.setVisible(true);

                        dispose();
                    }
                }
                if(e.getActionCommand().equals("Trabajadores")){
                    System.out.println(comboRegistro.getSelectedItem());
                }

            }
            
        }

    }

    class ItemAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == itemAzul){
                Color nuevoFondo = new Color(11, 113, 194);
                Bienvenida.fondo = nuevoFondo;
                getContentPane().setBackground(Bienvenida.fondo);
                repintarPaneles();
            }
            if(e.getSource() == itemNegro){
                Color nuevoFondo = new Color(32, 32, 32);
                Bienvenida.fondo = nuevoFondo;
                getContentPane().setBackground(Bienvenida.fondo);
                repintarPaneles();
            }
            if(e.getSource() == itemRojo){
                Color nuevoFondo = new Color(234, 29, 29);
                Bienvenida.fondo = nuevoFondo;
                getContentPane().setBackground(Bienvenida.fondo);
                repintarPaneles();
            }
            if(e.getSource() == itemSalir){
                Bienvenida ventBienvenida = new Bienvenida();
                ventBienvenida.setVisible(true);
                dispose();

            }
        }
        
    }

}
