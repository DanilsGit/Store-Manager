import java.awt.BorderLayout;
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
import javax.swing.JTextField;

public class Borrar extends JFrame {

    ImageIcon img;

    JMenuBar barraDeNavegacion;
    JMenu menuOpciones;
    JMenu menuColorFondo;
    JMenuItem itemRojo;
    JMenuItem itemAzul;
    JMenuItem itemNegro;
    JMenuItem itemSalir;

    Font calibri;

    Color anaranjado;

    JLabel labelimagen, labelTitulo, lblBuscar;

    JPanel containerTitulo, areaInformacion, panelBuscar;

    JButton btnConsultarTodo, btnEliminar, salir;
    JTextField iDbuscar;

    Borrar() {
        iniciarGui();

        iniciarComponentes();

        ordenarComponentes();

        addComponentes();
    }

    private void iniciarGui() {
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setLayout(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("imagenes/icon.png")).getImage());
        setTitle("Eliminar productos");
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

        panelBuscar = new JPanel();

        calibri = new Font("Calibro", 1, 20);

        anaranjado = new Color(255, 192, 9);

        labelTitulo = new JLabel("Eliminar producto");

        areaInformacion = new JPanel();

        btnConsultarTodo = new JButton("Consultar todos los productos");

        btnEliminar = new JButton("Eliminar");

        salir = new JButton("Volver...");

        iDbuscar = new JTextField();

        lblBuscar = new JLabel("Codigo del producto a eliminar");
    }

    private void ordenarComponentes() {

        getContentPane().setBackground(Bienvenida.fondo);

        //
        itemAzul.addActionListener(new ItemAction());
        itemNegro.addActionListener(new ItemAction());
        itemRojo.addActionListener(new ItemAction());
        itemSalir.addActionListener(new ItemAction());
        //

        labelimagen.setBounds(480, 30, 470, 46);

        labelTitulo.setFont(calibri);

        containerTitulo.setBounds(40, 100, 350, 40);
        containerTitulo.setBackground(anaranjado);
        containerTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));
        containerTitulo.add(labelTitulo);

        lblBuscar.setFont(calibri);

        panelBuscar.setBounds(40, 150, 350, 40);
        panelBuscar.setBackground(anaranjado);
        panelBuscar.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBuscar.add(lblBuscar);

        areaInformacion.setBounds(500, 100, 450, 500);
        areaInformacion.setBackground(anaranjado);
        areaInformacion.setLayout(new BorderLayout());

        btnConsultarTodo.setBounds(20, 450, 400, 35);
        btnConsultarTodo.setBackground(anaranjado);
        btnConsultarTodo.setFont(calibri);
        btnConsultarTodo.addActionListener(new Action());

        btnEliminar.setBounds(40, 250, 350, 35);
        btnEliminar.setBackground(anaranjado);
        btnEliminar.setFont(calibri);
        btnEliminar.addActionListener(new Action());

        salir.setBounds(40, 550, 150, 35);
        salir.setBackground(anaranjado);
        salir.setFont(calibri);
        salir.addActionListener(new Action());

        iDbuscar.setBounds(40, 200, 170, 30);
        iDbuscar.setFont(calibri);
        iDbuscar.setForeground(anaranjado);

    }

    private void addComponentes() {
        add(barraDeNavegacion);
        add(labelimagen);
        add(containerTitulo);
        add(areaInformacion);
        add(btnConsultarTodo);
        add(iDbuscar);
        add(btnEliminar);
        add(panelBuscar);
        add(salir);

    }

    class Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            BDconnect miBD = new BDconnect();

            if (e.getSource() == btnEliminar) {

                try {
                    miBD.eliminar(Integer.parseInt(iDbuscar.getText()));
                    System.out.println("Borrao");

                } catch (Exception ex) {
                    System.err.println(ex.getClass().getName() + " " + ex.getMessage());
                    System.out.println("algo va mal xd");
                }

            }
            if (e.getSource() == btnConsultarTodo) {

                try {

                    JOptionPane.showMessageDialog(null, miBD.consultarTodo());
                    System.out.println("xd");
                    repaint();

                } catch (Exception ex) {
                    System.err.println(ex.getClass().getName() + " " + ex.getMessage());
                    System.out.println("algo va mal xd");
                }

            }
            if (e.getSource() == salir) {

                try {
                    Principal p1 = new Principal();
                    p1.setVisible(true);
                    dispose();

                } catch (Exception ex) {
                    System.err.println(ex.getClass().getName() + " " + ex.getMessage());
                    System.out.println("algo va mal xd");
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
