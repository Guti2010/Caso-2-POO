package GUI;

import javax.swing.*;  

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Bus.*; 
import Trip.*;
public class ControlFlotilla extends JFrame {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private JComboBox<String> listaPlacas;
    private JTable infoAutobusTable;
    private JTable reportTable;
    private JScrollPane infoScrollPane;
    private JScrollPane reportScrollPane;
    private List<Autobus> listaDeAutobuses;
    private Autobus busSeleccionado;

    public ControlFlotilla(List<Autobus> autobuses) {
        listaDeAutobuses = autobuses;

        setTitle("Información de Autobuses");
        setSize(800, 622);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(60, 60);

        JLabel label = new JLabel("Información de Autobuses");
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setForeground(Color.BLACK);
        label.setBounds(90, 10, 550, 100);

        listaPlacas = new JComboBox<>();
        for (Autobus autobus : listaDeAutobuses) {
            listaPlacas.addItem(autobus.getPlaca());
        }

        listaPlacas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInfoAutobus();
            }
        });

        // Crear la tabla para mostrar la información de Autobus
        String[] columnNames = {"Característica", "Dato"};
        String[][] data = new String[4][2];
        infoAutobusTable = new JTable(data, columnNames);
        infoScrollPane = new JScrollPane(infoAutobusTable);

        // Crear la tabla para mostrar los informes de BusReport
     
        String[] reportColumnNames = {"Fecha y Hora", "Tipo de Avería", "Descripción", "Reparado"};
        String[][] reportData = new String[25][4]; 
        reportTable = new JTable(reportData, reportColumnNames);
        reportScrollPane = new JScrollPane(reportTable);

        // Configurar el diseño del contenedor
        setLayout(new BorderLayout());
        add(label, BorderLayout.NORTH);

        // Agregar el JComboBox y la tabla de información de Autobus al panel izquierdo
        // Después de agregar las tablas y el botón en el leftPanel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        
        // Agregar la tabla y el botón al leftPanel
        leftPanel.add(listaPlacas, BorderLayout.NORTH);
        leftPanel.add(infoScrollPane, BorderLayout.CENTER);
        leftPanel.add(reportScrollPane, BorderLayout.SOUTH);

        JButton button2 = new JButton("Reparar Autobus");
	    // Establecer la fuente con un tamaño de fuente más pequeño
	    Font buttonFont = new Font("Arial", Font.PLAIN, 16);
	    button2.setFont(buttonFont);
	
	    // Establecer el tamaño del botón
	    button2.setPreferredSize(new Dimension(150, 40)); // Ajusta el tamaño según tus preferencias
	
	    personalizarBoton(button2, new Font("Arial", Font.PLAIN, 12), new Color(220, 0, 60));
	    button2.addActionListener(e -> {
	        repararBus();
	        mostrarInfoAutobus();
	    });

        leftPanel.add(button2,BorderLayout.EAST);
        add(leftPanel, BorderLayout.CENTER);
    
    }
    
    private void personalizarBoton(JButton button, Font font, Color backgroundColor) {
        button.setFont(font);
        button.setForeground(Color.WHITE);
        button.setBackground(backgroundColor);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
    }

    private void mostrarInfoAutobus() {
    	String placaSeleccionada = (String) listaPlacas.getSelectedItem();
        

        for (Autobus autobus : listaDeAutobuses) {
            if (autobus.getPlaca().equals(placaSeleccionada)) {
                this.busSeleccionado = autobus;
                
                break;
            }
        }

        if (busSeleccionado != null) {
        	int row = 0;
            for (BusReport report : busSeleccionado.getBusReports()) {
            	
                reportTable.setValueAt(report.getFecha().toString(), row, 0);
                reportTable.setValueAt(report.getTipoAveria().toString(), row, 1);
                reportTable.setValueAt(report.getDescripcion(), row, 2);
                reportTable.setValueAt(report.getEstado() ? "Sí" : "No", row, 3);
                row++;
            }
            // Actualizar la tabla de información de Autobus
            String[][] autobusData = {
                {"Placa:", busSeleccionado.getPlaca()},
                {"Conductor:", busSeleccionado.getConductor()},
                {"Capacidad Máxima:", String.valueOf(busSeleccionado.getCapacidadMaxima())},
                {"Disponibilidad:", busSeleccionado.getDisponibilidad() ? "Disponible" : "No Disponible"}
            };
            row = 0 ;
            for (;row < autobusData.length; row++) {
                for (int col = 0; col < autobusData[0].length; col++) {
                    infoAutobusTable.setValueAt(autobusData[row][col], row, col);
                }
            }    
            
        } else {
            // Limpiar las tablas si no se selecciona ningún autobús
            for (int row = 0; row < infoAutobusTable.getRowCount(); row++) {
                for (int col = 0; col < infoAutobusTable.getColumnCount(); col++) {
                    infoAutobusTable.setValueAt("", row, col);
                }
            }

            for (int row = 0; row < reportTable.getRowCount(); row++) {
                for (int col = 0; col < reportTable.getColumnCount(); col++) {
                    reportTable.setValueAt("", row, col);
                }
            }
        }
    }
    
    public void repararBus() {
    	
    	if (busSeleccionado != null & busSeleccionado.getBusReports().get(
    			busSeleccionado.getBusReports().size()-1).getEstado()==true  ) {
    		
    	}
    	else {
    		busSeleccionado.setDisponibilidad(true);
    		busSeleccionado.getBusReports().get(busSeleccionado.getBusReports().size()-1).setEstado(true);
    		
    	}
    }
    
}






