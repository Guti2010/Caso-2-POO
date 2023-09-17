package GUI;

import javax.swing.*;
import java.awt.*;


public class VentanaInicio extends JFrame {
    private JTextArea textArea;
    private SolicitarInformacion ventana1;
    private ControlFlotilla ventana2;
    

    public VentanaInicio() {
        setTitle("Ventana de Inicio");
        setSize(550, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(60, 60);

        // Usa FondoPanel como el panel de contenido
        FondoPanel fondoPanel = new FondoPanel("C:\\Users\\windows\\Documents\\TransportePúblico\\src\\GUI\\maxresdefault.jpg");
        setContentPane(fondoPanel);

        JLabel label = new JLabel("Inicio");
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setForeground(Color.BLACK);
        label.setBounds(220, 10, 150, 100);
        getContentPane().setLayout(null);
        getContentPane().add(label);

        // Botón "Control de Flotilla"
        JButton button1 = new JButton("Control de Flotilla");
        button1.setBounds(60, 230, 220, 50); // Aumenta el tamaño del botón
        personalizarBoton(button1, new Font("Arial", Font.PLAIN, 20), new Color(50, 120, 220));

        
        
        JButton button2 = new JButton("Información de rutas");
        button2.setBounds(280, 230, 220, 50); // Aumenta el tamaño del botón
        personalizarBoton(button2, new Font("Arial", Font.PLAIN, 20), new Color(240, 120, 40));

        button1.addActionListener(e -> {
        	ControlFlotilla ventana2 = new ControlFlotilla();
        	ventana2.setVisible(true);
        });
        
        button2.addActionListener(e -> {
        	SolicitarInformacion ventana1 = new SolicitarInformacion();
        	ventana1.setVisible(true);
        	
        });
        getContentPane().add(button1);

        getContentPane().add(button2);
    }

    // Método para personalizar un botón con un color de fondo
    private void personalizarBoton(JButton button, Font font, Color backgroundColor) {
        button.setFont(font);
        button.setForeground(Color.WHITE);
        button.setBackground(backgroundColor);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
           
            public void run() {
                VentanaInicio ventanaInicio = new VentanaInicio();
                ventanaInicio.setVisible(true);
            }
        });
    }
    
}

/* ACUERDO
 * eso alejandro, está muy bien la investigación que hiciste, solo detallemos esto:
En primer lugar, permitiría saber si un bus va a salir a la hora que informa el sistema, 
la ruta que este tomará dependiendo de la zona seleccionada, además mostrará información en tiempo real de 
la ubicación de cierto autobús que en ese momento se encuentre ofreciendo el servicio, así como de su capacidad, 
de esta forma se controla el transporte de sus usuarios que además se podrá seleccionar una opción para pagar automáticamente, 
permitirá conocer el estado del servicio y también como fuente de información para la empresa que ofrece el servicio. El usuario podrá reportar daños o 
retrasos en el autobús actual, preguntar por un autobús y zona específica, y como resultado obtendrá la información solicitada.

quitemos lo que es pago de la solución a hacer, quedémonos con solo el monitoreo de las unidades
pero vamos a tener que agregar algo

algo donde registrar los buses con su horario y choferes, eso es algo que no lo veo ahi redactando, el mantenimiento de buses y choferes.
tener la información en tiempo real de los buses , ruta y su estado actual, cantidad de gente y todo lo que mencionas ahi

poder visualizar dicha información en la aplicación

únicamente, no metamos ni pago ni reporte de daños, para no hacerlo tan grande
 * 
 * 
 
 * 
 * 
 * 
 * 	
 */
		



	


