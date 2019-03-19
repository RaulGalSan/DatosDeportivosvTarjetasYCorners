package com.acing.iu;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.acing.eventos.Partido;
import com.esotericsoftware.tablelayout.Value;
import com.esotericsoftware.tablelayout.swing.Table;

public class EjemploJFrame extends JFrame {

	// JComboBox: es una lista que se despliega hacia abajo y nos permite elegir entre varias 
	// opciones diferentes.
	private JComboBox cb_VariosTipos;
	private JComboBox cb_EquipoLocal;
	private JComboBox cb_EquipoVisitante;
	
	// JCheckBox: permite implementar un cuadro de selección (básicamente un botón de dos estados).
	private JCheckBox ckb_ParaAlgo;
	
	// JTextField: es un componente utilizado para la captura de datos.
	private JTextField txt_Input;

	public EjemploJFrame() {
		super();
		initialize();
	}
	
	
	public static void main(String... args) {
		JFrame marco = new EjemploJFrame();
		marco.setVisible(true);
	}
	
	private void initialize() {
		setName("Ejemplo de Frame - Raul");
		// Especifica la región geográfica la clase Locale.(Idioma, Pais).
        setLocale(new Locale("es", "ES"));
        
        // Tamano minimo de la ventana. Especifica el ancho y alto mediante la clase Dimension. 
        setMinimumSize(new Dimension(500, 600));
        
        //Establece el tamaño limite de la Ventana. 
        // SetBounds es un método que mueve y cambia el tamaño de un componente para caber 
        // dentro de los parámetros de un rectángulo delimitador especificado. 
        setBounds(100, 100, 1100, 400); // x,y,ancho, alto.
        
        setTitle("Partido de Liga de 1º Division - Temporada 17/18");
        
      //Para que termine la ejecucion al cerrar, se debe cerrar siempre. NO hay que olvidarse.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      //Forma normal con swing
//      JPanel pn_Principal = new JPanel();
//      BoxLayout boxLayout = new BoxLayout(pn_Principal, BoxLayout.Y_AXIS);
//      pn_Principal.setLayout(boxLayout);
//      getContentPane().add(pn_Principal, BorderLayout.NORTH);
//      
//      JPanel pn_AccesoDirecto = new JPanel();
//      ((FlowLayout) pn_AccesoDirecto.getLayout()).setAlignment(FlowLayout.LEFT);
//      modificarValores = new BotonAccion("Añadir/Modificar Valores", "Modificar Valores");
//      pn_AccesoDirecto.add(modificarValores);
      
      //Componentes de mi Frame.
      
      // Etiquetas.
      JLabel lbl_Local = new JLabel("Equipo Local");
//    JLabel lbl_2 = new JLabel("Pinta toString() por defecto");
      JLabel lbl_Visitante = new JLabel("Equipo Visitante");
//    JLabel lbl_4 = new JLabel("Label 4");      
      JLabel lbl_Resultado = new JLabel("Resultado");
      
      JLabel lbl_fecha = new JLabel("Fecha");
      JLabel lbl_tjtAmarillas_Local = new JLabel("Tarjetas Amarillas - Local");
      
      
      // Mi prueba.
//    JLabel lbl_5 = new JLabel("Label 1");
      
      // Botones.
      JButton btn_resultado = new JButton("Resultado");
//      JButton btn_2 = new JButton("Botón 2");
      
      // Lista Desplegable, le asignamos valores de tipo String.
      JComboBox<String> cb_EquipoLocal = new JComboBox<>(new String[]{ "Primero", "Segundo" });
      JComboBox<String> cb_EquipoVisitante = new JComboBox<>(new String[]{ "Tercero", "Cuarto" });

      //Para usarlo en el combobox de abajo
      Object objetoPersonalizado = new Object() {
          @Override
          public String toString() {
              return "Mi Objeto especial";
          } };
      
      //Acceso desde otro scope (ambito).
//      cb_VariosTipos = new JComboBox<>(new Object[]{ "Primero", 2, true, objetoPersonalizado });
      
//      ckb_ParaAlgo = new JCheckBox("Es Algo (label CheckBox)");
      
      txt_Input = new JTextField();
      txt_Input.setText("Algo escrito para pruebas");
      
    //Listeners
      btn_resultado.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			lbl_Resultado.setText("Pulsado prueba raul: " + ((JButton)e.getSource()).getText()
					.toString());
		}
	});
//      btn_1.addActionListener(e -> lbl_Resultado.setText("Pulsado " + ((JButton)e.getSource()).getText().toString()));
      
      
//      btn_2.addActionListener(e -> lbl_Resultado.setText(validarInput()));
      
    //Layout (configuracion general)
      Table tabla = new Table();
      Value padding = new Value.FixedValue(5);
      tabla.top().left().pad(padding);
      tabla.defaults().pad(padding).left();
//    tabla.columnDefaults(1).width(new Value.FixedValue(100));
      tabla.columnDefaults(2).expandX();
      getContentPane().add(tabla);
      
      //Tamanhos
      Value anchoCombos = new Value.FixedValue(200);
      
      //Modo debug (se ven los bordes del layout)
//      tabla.debug(Debug.all);
      
      //Agregar los componentes
      tabla.addCell(lbl_Local); // Pinta "Label1"
      tabla.addCell(cb_EquipoLocal).width(anchoCombos); // Pinta lista desplegable con valores Primero", "Segundo".
      tabla.row();
      tabla.addCell(lbl_Visitante);// Pinta "Label3"
      tabla.addCell(cb_VariosTipos).fillX(); // Pinta "Primero", 2, true, "Mi Objeto especial".
//      tabla.addCell(lbl_2);//.expandX();// "Pinta toString() por defecto"
      tabla.row();
      tabla.addCell(new JLabel("Es Algo")); // Pinta "Es Algo"
//      ckb_ParaAlgo.setHorizontalTextPosition(SwingConstants.LEFT);
      tabla.addCell(ckb_ParaAlgo); // Pinta un checkbox "Es Algo (label CheckBox)"
      tabla.row();
//      tabla.addCell(lbl_4);//lbl_1); // Pinta "Label4"
      tabla.addCell(txt_Input).colspan(2).fillX(); // Pinta dentro deeun campo "Algo escrito para pruebas".
      tabla.row();
      tabla.addCell(btn_resultado).center(); // Pinta el botón 1, si se pulsa cambia el valor de lbl_Resultado. 
      tabla.addCell(lbl_Resultado).colspan(2); // Inicialmente Pinta "Resultado de una operación", luego varía su valor según se pulsa btn1 o btn2.
//      tabla.addCell(btn_2); // Pinta el botón 2, si se pulsa cambia el valor de lbl_Resultado.
//      lbl_Ciu.setText("Label 1 cambiada");
      // Prueba Raul.
      tabla.row();
//      tabla.addCell(lbl_5);
	}

	public void mostrarPartido(Partido partido) {
		txt_Input.setText(partido.toString());
//		txt_Input.setText(partido.getLocal().toString());
	}
	
	private String validarInput() {
		// Si el checkbox esta seleccionado devuelve el valor que tega el txt_Input, inicialmente
		// "Algo escrito para pruebas", sino me devuelve el valor del combobox que esté seleccionado en ese momento.
		return ckb_ParaAlgo.isSelected() ?
				txt_Input.getText() :
					cb_VariosTipos.getSelectedItem().toString();
	}
}
