import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Bienvenida extends JFrame {

    ImageIcon imgLogo;

    JLabel logo, labelIdTrabajador, labelContrasena;

    static Color fondo;

    JTextField fieldIdTrabajador;
    JPasswordField fieldContrasena;

    JCheckBox checkContrasena;
    char puntos;

    JButton btnIngresar, btnSalir;

    Font textos;

    static String nombre = "Daniel";

    Bienvenida() {

        iniciarGui();

        iniciarComponentes();

        ordenarComponentes();

        addComponentes();

    }

    public void iniciarGui() {
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(234, 29, 29));
        setIconImage(new ImageIcon(getClass().getResource("imagenes/icon.png")).getImage());
        setTitle("Bienvenido trabajador");
    }

    public void iniciarComponentes() {

        fondo = new Color(234, 29, 29);

        textos = new Font("Aharoni", 1, 14);

        imgLogo = new ImageIcon(getClass().getResource("imagenes/logo.png"));

        logo = new JLabel(imgLogo);

        labelIdTrabajador = new JLabel("Ingrese su ID de trabajador");
        labelContrasena = new JLabel("Ingrese su contraseña");

        fieldIdTrabajador = new JTextField();
        fieldContrasena = new JPasswordField();

        puntos = fieldContrasena.getEchoChar();

        btnIngresar = new JButton("Ingresar");
        btnSalir = new JButton("Salir");

        checkContrasena = new JCheckBox();

    }

    public void ordenarComponentes() {

        logo.setBounds(centrarX(470), 20, 470, 46);

        labelIdTrabajador.setBounds(centrarX(190), 150, 191, 25);
        labelIdTrabajador.setFont(textos);
        labelIdTrabajador.setForeground(Color.white);

        fieldIdTrabajador.setBounds(centrarX(250), 180, 250, 40);
        fieldIdTrabajador.setFont(textos);
        fieldIdTrabajador.setForeground(Color.red);
        fieldIdTrabajador.setBackground(Color.yellow);
        fieldIdTrabajador.addKeyListener(new Action());

        labelContrasena.setBounds(centrarX(158), 250, 158, 25);
        labelContrasena.setFont(textos);
        labelContrasena.setForeground(Color.white);

        fieldContrasena.setBounds(centrarX(250), 280, 250, 40);
        fieldContrasena.setFont(textos);
        fieldContrasena.setForeground(Color.red);
        fieldContrasena.setBackground(Color.yellow);
        fieldContrasena.addKeyListener(new Action());

        checkContrasena.setBounds(370, 287, 43, 31);
        checkContrasena.setIcon(new ImageIcon(getClass().getResource("imagenes/check0.png")));
        checkContrasena.setBackground(fondo);
        checkContrasena.addItemListener(new Checker());

        btnIngresar.setBounds(centrarX(200), 400, 200, 30);
        btnIngresar.setFont(textos);
        btnIngresar.setForeground(Color.red);
        btnIngresar.setBackground(Color.yellow);
        btnIngresar.addActionListener(new Action());

        btnSalir.setBounds(centrarX(200), 450, 200, 30);
        btnSalir.setFont(textos);
        btnSalir.setForeground(Color.red);
        btnSalir.setBackground(Color.yellow);
        btnSalir.addActionListener(new Action());

    }

    public void addComponentes() {
        add(logo);
        add(labelIdTrabajador);
        add(fieldIdTrabajador);
        add(labelContrasena);
        add(fieldContrasena);
        add(checkContrasena);
        add(btnIngresar);
        add(btnSalir);
    }

    public int centrarX(int tam) {

        return (getWidth() - 10) / 2 - (tam) / 2;
    }

    class Checker implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                fieldContrasena.setEchoChar((char) 0);
                checkContrasena.setIcon(new ImageIcon(getClass().getResource("imagenes/check1.png")));
            } else {
                fieldContrasena.setEchoChar(puntos);
                checkContrasena.setIcon(new ImageIcon(getClass().getResource("imagenes/check0.png")));

            }

        }

    }

    class Action extends KeyAdapter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnIngresar) {

                String id = fieldIdTrabajador.getText();
                String password = new String(fieldContrasena.getPassword());

                BDconnect miBD = new BDconnect();

                if(BDconnect.conectado){

                    if (miBD.validar(id, password)) {
                        nombre = miBD.getNombre(id);
    
                        Principal ventanaPrincipal = new Principal();
                        ventanaPrincipal.setVisible(true);
    
                        miBD.cerrar();
                        dispose();
                        
                    } else{
                        JOptionPane.showMessageDialog(null, "Revisa nuevamente los campos", "CREDENCIALES INVÁLIDOS", 2);
                    }

                }



            }
            if (e.getSource() == btnSalir) {
                System.exit(0);
            }

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (10 == e.getKeyCode()) {
                String id = fieldIdTrabajador.getText();
                String password = new String(fieldContrasena.getPassword());

                BDconnect miBD = new BDconnect();

                if(BDconnect.conectado){

                    if (miBD.validar(id, password)) {
                        nombre = miBD.getNombre(id);
    
                        Principal ventanaPrincipal = new Principal();
                        ventanaPrincipal.setVisible(true);
    
                        miBD.cerrar();
                        dispose();
                        
                    } else{
                        JOptionPane.showMessageDialog(null, "Revisa nuevamente los campos", "CREDENCIALES INVÁLIDOS", 2);
                    }

                }
            }
        }

    }

}
