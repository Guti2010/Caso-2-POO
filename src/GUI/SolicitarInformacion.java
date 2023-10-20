package GUI;

import javax.swing.*;

import java.util.List;
import java.awt.*;
import Route.*;
import Trip.*;
public class SolicitarInformacion extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> busStopComboBox;
    private JComboBox<String> rutaComboBox;
    private List<Ruta> rutas;
    private Ruta rutaActual;
    public SolicitarInformacion(List<Ruta> rutas) {
    	this.rutas = rutas;
    	// Usa FondoPanel como el panel de contenido
        FondoPanel fondoPanel = new FondoPanel("C:\\Users\\windows\\Documents\\TransportePúblico\\src\\GUI\\maxresdefault.jpg");
        
        setContentPane(fondoPanel);
        setTitle("Solicitar Información");
        setSize(620, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(60, 60);

        ImageIcon imagenIcono = new ImageIcon("C:\\Users\\windows\\Documents\\TransportePúblico\\src\\GUI\\6398309.jpg");
        Image imagen = imagenIcono.getImage();
        Image nuevaImagen = imagen.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // Ajusta el tamaño de la imagen
        ImageIcon nuevaImagenIcono = new ImageIcon(nuevaImagen);
        
        JLabel imagenLabel = new JLabel(nuevaImagenIcono);
        imagenLabel.setBounds(150, 350, 320, 300);
        getContentPane().add(imagenLabel);

        JLabel label = new JLabel("Información");
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setForeground(Color.BLACK);
        label.setBounds(200, 10, 250, 100);
        getContentPane().setLayout(null);
        getContentPane().add(label);

        // Etiqueta y área de texto para "Ruta"
        JLabel rutaLabel = new JLabel("Ruta:");
        rutaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        rutaLabel.setForeground(Color.BLACK);
        rutaLabel.setBounds(40, 100, 70, 25);
        getContentPane().setLayout(null);
        getContentPane().add(rutaLabel);
        

        rutaComboBox = new JComboBox<>();
        for (Ruta ruta : rutas) {
        	rutaComboBox .addItem(ruta.getName());
        }
        rutaComboBox.setBounds(80, 100, 150, 30); // Ajusta el tamaño según tus necesidades
        
        busStopComboBox = new JComboBox<>();
        busStopComboBox.setBounds(400, 100, 180, 30); // Ajusta el tamaño según tus necesidades
        getContentPane().add(busStopComboBox);
        
        rutaComboBox.addActionListener(e -> {
        	 mostrarBusStops();
        });
        getContentPane().add(rutaComboBox);

        // Etiqueta y área de texto para "Autobús"
        JLabel autobusLabel = new JLabel("Ubicación actual:");
        autobusLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        autobusLabel.setForeground(Color.BLACK);
        autobusLabel.setBounds(270, 100, 130, 25);
        getContentPane().add(autobusLabel);

        
        // Botón para realizar acciones con la información ingresada
        JButton button1 = new JButton("Consultar");
        button1.setBounds(240, 250, 150, 50);
        personalizarBoton(button1, new Font("Arial", Font.PLAIN, 20), new Color(204, 153, 0));
        button1.addActionListener(e -> {
        	String ruta = rutaComboBox.getSelectedItem().toString();
        	String parada =  busStopComboBox.getSelectedItem().toString();
        	Ruta rutaSelecionada=null;
            for (Ruta rutaActual : rutas ) {
            	if (rutaActual.getName()==ruta) {
            		rutaSelecionada = rutaActual;
            	}
            }
            
            String mensaje = determinarBusStop(rutaSelecionada,parada) ;
            JOptionPane.showMessageDialog(this, mensaje, "Información Capturada", JOptionPane.INFORMATION_MESSAGE);
        });
        
            
            
        getContentPane().add(button1);
    }
    
    public void mostrarBusStops() {
    	String rutaSeleccionada = (String) rutaComboBox.getSelectedItem();
        

        for (Ruta ruta : rutas) {
            if (ruta.getName().equals(rutaSeleccionada)) {
                this.rutaActual = ruta;
                List<BusStop> busStopsForRuta = ruta.getBusStops();
                busStopComboBox.removeAllItems();
                for (BusStop busStop : busStopsForRuta) {
                    busStopComboBox.addItem(busStop.getUbicacion());
                }
                break;
            }
        }
        
    }
    
    public String determinarBusStop(Ruta pRutaSelec, String paradaUsuario) {
    	String mensaje = "";
    	Viaje viaje = pRutaSelec.getViajeActual();
    	BusStop parada = null;
    	for (BusStop x : viaje.getBusStops()) {
    		if(x.getUbicacion()==paradaUsuario) {
    			parada=x;
    		}
    	}
    	int paradaViaje = viaje.getBusStops().indexOf(viaje.getUbicacionBus());
    	int paradaParaConsultar = viaje.getBusStops().indexOf(parada);
    	if (paradaViaje<paradaParaConsultar) {
    		mensaje = "El autobus pasará por " + parada.getUbicacion() + 
    				", aprodimadamente a las " + parada.getHoraAproximada()+
    				". \nActualmente el autobus tiene " + viaje.getCantPasajeros()+" pasajeros";
    	}
    	
    	if (paradaViaje>=paradaParaConsultar) {
    		mensaje = "El autobus ya pasó por " + parada.getUbicacion() + 
    				", deberá esperar al proximo viaje";
    	}
    	return mensaje;
    }
    private void personalizarBoton(JButton button, Font font, Color backgroundColor) {
        button.setFont(font);
        button.setForeground(Color.WHITE);
        button.setBackground(backgroundColor);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
    }
    
    


}

    
