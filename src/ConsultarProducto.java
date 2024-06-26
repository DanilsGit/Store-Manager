import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ConsultarProducto extends JFrame{
    
    ImageIcon img;

    JMenuBar barraDeNavegacion;
    JMenu menuOpciones;
    JMenu menuColorFondo;
    JMenuItem itemRojo;
    JMenuItem itemAzul;
    JMenuItem itemNegro;
    JMenuItem itemSalir;

    JTextField fieldId;

    Font calibri;

    Color anaranjado;

    JLabel labelIdBuscar, labeltodo, labelimagen, labelTitulo;

    JPanel containerTitulo;

    JButton btnConsultarTodo, btnConsultarPorID, btnAtras;

    JScrollPane informacion;


    ConsultarProducto(){
        iniciarGui();

        iniciarComponentes();

        ordenarComponentes();

        addComponentes();
    }

    private void iniciarGui() {
        setSize(1000,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setLayout(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("imagenes/icon.png")).getImage());
        setTitle("Consultas de productos");
    }

    private void iniciarComponentes() {
        barraDeNavegacion = Principal.barraDeNavegacion;
        menuOpciones = Principal.menuOpciones;
        menuColorFondo = Principal.menuColorFondo;
        itemRojo = Principal.itemRojo;
        itemAzul = Principal.itemAzul;
        itemNegro = Principal.itemNegro;
        itemSalir = Principal.itemSalir;

        img = new ImageIcon(getClass().getResource("imagenes/logo.png"));
        labelimagen = new JLabel(img);

        containerTitulo = new JPanel();

        calibri = new Font("Calibro", 1, 20);

        anaranjado = new Color(255,192,9);

        labelTitulo = new JLabel("Consultas");

        informacion = new JScrollPane();

        btnConsultarTodo = new JButton("Consultar");

        labelIdBuscar = new JLabel("Consulta los datos de un producto por ID");

        btnConsultarPorID = new JButton("Consultar");

        labeltodo = new JLabel("Consultar todos los productos");

        fieldId = new JTextField();

        btnAtras = new JButton("Atrás");
    }

    private void ordenarComponentes() {

        getContentPane().setBackground(Bienvenida.fondo);
        
        //
        barraDeNavegacion.add(menuOpciones);

        menuOpciones.add(menuColorFondo);

        menuColorFondo.add(itemAzul);
        menuColorFondo.add(itemNegro);
        menuColorFondo.add(itemRojo);

        menuOpciones.add(itemSalir);
        //
        itemAzul.addActionListener(new ItemAction());
        itemNegro.addActionListener(new ItemAction());
        itemRojo.addActionListener(new ItemAction());
        itemSalir.addActionListener(new ItemAction());
        //
        labelimagen.setBounds(480, 30, 470, 46);
        
        labelTitulo.setFont(calibri);
        
        containerTitulo.setBounds(40,30,350,40);
        containerTitulo.setBackground(anaranjado);
        containerTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));
        containerTitulo.add(labelTitulo);

        informacion.setBounds(500, 110, 450, 500);

        labeltodo.setBounds(20, 510, 400, 35);
        labeltodo.setFont(calibri);
        labeltodo.setForeground(Color.white);

        btnConsultarTodo.setBounds(20,550,400,35);
        btnConsultarTodo.setBackground(anaranjado);
        btnConsultarTodo.setFont(calibri);
        btnConsultarTodo.addActionListener(new Action());

        labelIdBuscar.setBounds(20, 210, 400, 30);
        labelIdBuscar.setFont(calibri);
        labelIdBuscar.setForeground(Color.white);

        fieldId.setBounds(20, 250, 400, 35);

        btnConsultarPorID.setBounds(20, 300, 400, 35);
        btnConsultarPorID.setBackground(anaranjado);
        btnConsultarPorID.addActionListener(new Action());
        btnConsultarPorID.setFont(calibri);

        btnAtras.setBounds(580, 625, 300, 30);
        btnAtras.setBackground(anaranjado);
        btnAtras.setFont(calibri);
        btnAtras.addActionListener(new Action());

    }

    public void addComponentes() {
        add(barraDeNavegacion);
        add(labelimagen);
        add(containerTitulo);
        add(informacion);
        add(labeltodo);
        add(btnConsultarTodo);
        add(labelIdBuscar);
        add(fieldId);
        add(btnConsultarPorID);
        add(btnAtras);
    }

    class Action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource() == btnConsultarTodo){
                BDconnect miBD = new BDconnect();

                remove(informacion);
    
                informacion = miBD.consultarTodo();
    
                informacion.setBounds(500, 110, 450, 500);
                informacion.setBackground(anaranjado);
    
                add(informacion);
    
                miBD.cerrar();
            }

            if(e.getSource() == btnConsultarPorID){

                if(!(fieldId.getText().trim().equals(""))){
                    
                    try {

                        int id = Integer.parseInt(fieldId.getText().trim());
                        
                        BDconnect miBD = new BDconnect();

                        remove(informacion);
            
                        informacion = miBD.consultarPorID(id);

                        informacion.setBounds(500, 110, 450, 500);
                        informacion.setBackground(anaranjado);
            
                        add(informacion);
            
                        miBD.cerrar();
                        
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Entrada de dato inválida", "Error",2);
                        
                    }

                }else{
                    JOptionPane.showMessageDialog(null, "Campo vacío", "Error",1);
                }

            }

            if(e.getSource() == btnAtras){
                Principal ventanaPrincipal = new Principal();
                ventanaPrincipal.setVisible(true);

                dispose();
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
            }
            if(e.getSource() == itemNegro){
                Color nuevoFondo = new Color(32, 32, 32);
                Bienvenida.fondo = nuevoFondo;
                getContentPane().setBackground(Bienvenida.fondo);
            }
            if(e.getSource() == itemRojo){
                Color nuevoFondo = new Color(234, 29, 29);
                Bienvenida.fondo = nuevoFondo;
                getContentPane().setBackground(Bienvenida.fondo);
            }
            if(e.getSource() == itemSalir){
                Bienvenida ventBienvenida = new Bienvenida();
                ventBienvenida.setVisible(true);
                dispose();

            }
        }
        
    }



}
