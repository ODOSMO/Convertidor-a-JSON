package com.edu.mx.practica.uno.vista;

import com.edu.mx.practica.uno.controlador.Convertidor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI{
    //Atributos
    private JButton convertirButton;
    private JPanel panel1;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JComboBox comboBox1;

    Convertidor convertidor = new Convertidor();

    /**
     * Constructor
     */
    public GUI() {
        //Listener para ejecutar al hacer click
        convertirButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (comboBox1.getSelectedItem().toString().equals("XML")) {
                    String resultado = convertidor.xmlToJson(textArea1.getText());
                    if(resultado.equals("{}")){
                        JOptionPane.showMessageDialog(null,"Campos Vacios, por favor introduce un formato XML o Java","ERROR", 0);
                    }else{
                        textArea2.setText(resultado);
                    }
                }
                if (comboBox1.getSelectedItem().toString().equals("JAVA")) {
                    String resultado = convertidor.javaToGson(textArea1.getText());
                    if(resultado.equals("")){
                        JOptionPane.showMessageDialog(null,"Campos Vacios, por favor introduce un formato XML o Java","ERROR", 0);
                    }else{
                        textArea2.setText(resultado);
                    }
                }
            }
        });
        //Metodo solo para mostrar la clase Empleado que se convertira a JSON en el TextArea
        comboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comboBox1.getSelectedItem().toString().equals("JAVA")) {
                    textArea1.setText("package com.edu.mx.practica.uno.modelo;\n" +
                            "\n" +
                            "public class Empleado {\n" +
                            "    private String nombre;\n" +
                            "    private String apellido;\n" +
                            "    private int edad;\n" +
                            "    private float salario;\n" +
                            "\n" +
                            "    public String getNombre() {\n" +
                            "        return nombre;\n" +
                            "    }\n" +
                            "\n" +
                            "    public void setNombre(String nombre) {\n" +
                            "        this.nombre = nombre;\n" +
                            "    }\n" +
                            "\n" +
                            "    public String getApellido() {\n" +
                            "        return apellido;\n" +
                            "    }\n" +
                            "\n" +
                            "    public void setApellido(String apellido) {\n" +
                            "        this.apellido = apellido;\n" +
                            "    }\n" +
                            "\n" +
                            "    public int getEdad() {\n" +
                            "        return edad;\n" +
                            "    }\n" +
                            "\n" +
                            "    public void setEdad(int edad) {\n" +
                            "        this.edad = edad;\n" +
                            "    }\n" +
                            "\n" +
                            "    public float getSalario() {\n" +
                            "        return salario;\n" +
                            "    }\n" +
                            "\n" +
                            "    public void setSalario(float salario) {\n" +
                            "        this.salario = salario;\n" +
                            "    }\n" +
                            "}");
                }
            }
        });
    }

    public static void main(String[] args) {
        //Configuracion del Frame
        JFrame frame = new JFrame("controlador de JSON");
        frame.setContentPane(new GUI().panel1);
        frame.setDefaultCloseOperation(3);
        frame.setSize(new Dimension(1200,600));
        frame.setVisible(true);
    }


}
