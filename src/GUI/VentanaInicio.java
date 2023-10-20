package GUI;

import javax.swing.*;

import Bus.Autobus;
import Config.settingJSON;
import java.io.*;
import java.awt.*;
import java.util.List;
import Empresa.*;

public class VentanaInicio extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Flotilla Flotilla;
	private settingJSON configuracion;
	private List <Autobus> Autobuses;

    public VentanaInicio(settingJSON configuracion,List <Autobus> pAutobuses) {
    	this.configuracion = configuracion;
    	this.Autobuses = pAutobuses;
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
        JButton button1 = new JButton("Agregar Autobuses");
        button1.setBounds(160, 130, 220, 50); // Aumenta el tamaño del botón
        personalizarBoton(button1, new Font("Arial", Font.PLAIN, 20), new Color(50, 120, 220));

        
        JButton button2 = new JButton("Control Autobuses");
        button2.setBounds(160, 230, 220, 50); // Aumenta el tamaño del botón
        personalizarBoton(button2, new Font("Arial", Font.PLAIN, 20), new Color(240, 120, 40));
        
        JButton button3 = new JButton("Informacion Proximo Autobus");
        button3.setBounds(110, 330, 300, 50);
        personalizarBoton(button3, new Font("Arial", Font.PLAIN, 20), new Color(70, 0, 50)); // Puedes personalizar el color
        
        JButton button4 = new JButton("Guardar Datos");
        button4.setBounds(160, 430, 220, 50);
        personalizarBoton(button4, new Font("Arial", Font.PLAIN, 20), new Color(100, 20, 100)); // Puedes personalizar el color
        
        button1.addActionListener(e -> {
        	AgregarBus ventana1 = new AgregarBus(Flotilla,configuracion);
        	ventana1.setVisible(true);
        	
        });
        
        button2.addActionListener(e -> {
        	ControlFlotilla ventana2 = new ControlFlotilla(Flotilla.getBuses());
        	ventana2.setVisible(true);
        	
        	
        });
        
        button3.addActionListener(e -> {
        	SolicitarInformacion ventana3 = new SolicitarInformacion(Flotilla.getRutas());
        	ventana3.setVisible(true);
        	
        });
        
        button4.addActionListener(e -> {
        	// Guardar los Autobuses en un archivo binario
        	for(Autobus bus: Autobuses) {
        		bus.setUltimoViaje(null);
        	}
            try (FileOutputStream fileOutputStream = new FileOutputStream("Autobuses.bin");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(Autobuses);
            } catch (IOException x) {
                x.printStackTrace();
            }
        	
        });
        getContentPane().add(button1);

        getContentPane().add(button2);
        
        getContentPane().add(button3);
        
        getContentPane().add(button4);
    }

    // Método para personalizar un botón con un color de fondo
    private void personalizarBoton(JButton button, Font font, Color backgroundColor) {
        button.setFont(font);
        button.setForeground(Color.WHITE);
        button.setBackground(backgroundColor);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
    }
    
    public void setFlotilla(Flotilla pFlotilla) {
    	this.Flotilla = pFlotilla;
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
		



	


