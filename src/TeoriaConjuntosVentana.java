import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import com.github.venom.VennDiagram;

public class TeoriaConjuntosVentana extends JFrame {

    private JTextField conjuntoATextField;
    private JTextField conjuntoBTextField;
    private JButton unionButton;
    private JButton interseccionButton;
    private JButton diferenciaButton;
    private JButton diferenciaSimetricaButton;
    private JLabel vennDiagramLabel;

    public TeoriaConjuntosVentana() {
        // Configuración de la ventana
        setTitle("Operaciones de la Teoría de Conjuntos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLayout(new BorderLayout());

        // Crear JTextField para los conjuntos
        conjuntoATextField = new JTextField();
        conjuntoBTextField = new JTextField();

        // Crear los botones para las operaciones
        unionButton = new JButton("Unión");
        unionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarUnion();
            }
        });

        interseccionButton = new JButton("Intersección");
        interseccionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarInterseccion();
            }
        });

        diferenciaButton = new JButton("Diferencia");
        diferenciaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarDiferencia();
            }
        });

        diferenciaSimetricaButton = new JButton("Diferencia Simétrica");
        diferenciaSimetricaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarDiferenciaSimetrica();
            }
        });

        // Crear JLabel para el diagrama de Venn (usaremos una imagen para representarlo)
        vennDiagramLabel = new JLabel();

        // Crear un panel para los botones y el JTextField
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));
        buttonPanel.add(unionButton);
        buttonPanel.add(interseccionButton);
        buttonPanel.add(diferenciaButton);
        buttonPanel.add(diferenciaSimetricaButton);

        // Agregar los componentes a la ventana
        add(conjuntoATextField, BorderLayout.NORTH);
        add(conjuntoBTextField, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(vennDiagramLabel, BorderLayout.WEST);

        // Configurar la visibilidad de la ventana
        setVisible(true);
    }

    private void realizarUnion() {
        // Obtener los valores ingresados por el usuario en los JTextField
        String conjuntoA = conjuntoATextField.getText().trim();
        String conjuntoB = conjuntoBTextField.getText().trim();

        // Crear conjuntos vacíos
        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();

        // Agregar los elementos del conjunto A al setA
        setA.addAll(Arrays.asList(conjuntoA.split(",")));

        // Agregar los elementos del conjunto B al setB
        setB.addAll(Arrays.asList(conjuntoB.split(",")));

        // Realizar la operación de unión
        Set<String> union = new HashSet<>(setA);
        union.addAll(setB);

        // Generar el diagrama de Venn
        VennDiagram venn = new VennDiagram();
        venn.union(setA, setB);

        // Actualizar la imagen del diagrama de Venn
        vennDiagramLabel.setIcon(new ImageIcon(venn.getDiagram()));

        // Mostrar el resultado en el JTextArea
        String resultado = "Conjunto A: " + setA.toString() + "\n"
                        + "Conjunto B: " + setB.toString() + "\n"
                        + "Unión: " + union.toString();
        JOptionPane.showMessageDialog(this, resultado);
    }

    private void realizarInterseccion() {
        // Obtener los valores ingresados por el usuario en los JTextField
        String conjuntoA = conjuntoATextField.getText().trim();
        String conjuntoB = conjuntoBTextField.getText().trim();

        // Crear conjuntos vacíos
        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();

        // Agregar los elementos del conjunto A al setA
        setA.addAll(Arrays.asList(conjuntoA.split(",")));

        // Agregar los elementos del conjunto B al setB
        setB.addAll(Arrays.asList(conjuntoB.split(",")));

        // Realizar la operación de intersección
        Set<String> interseccion = new HashSet<>(setA);
        interseccion.retainAll(setB);

        // Generar el diagrama de Venn
        VennDiagram venn = new VennDiagram();
        venn.intersection(setA, setB);

        // Actualizar la imagen del diagrama de Venn
        vennDiagramLabel.setIcon(new ImageIcon(venn.getDiagram()));

        // Mostrar el resultado en el JTextArea
        String resultado = "Conjunto A: " + setA.toString() + "\n"
                        + "Conjunto B: " + setB.toString() + "\n"
                        + "Intersección: " + interseccion.toString();
        JOptionPane.showMessageDialog(this, resultado);
    }

    private void realizarDiferencia() {
        // Obtener los valores ingresados por el usuario en los JTextField
        String conjuntoA = conjuntoATextField.getText().trim();
        String conjuntoB = conjuntoBTextField.getText().trim();

        // Crear conjuntos vacíos
        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();

        // Agregar los elementos del conjunto A al setA
        setA.addAll(Arrays.asList(conjuntoA.split(",")));

        // Agregar los elementos del conjunto B al setB
        setB.addAll(Arrays.asList(conjuntoB.split(",")));

        // Realizar la operación de diferencia
        Set<String> diferencia = new HashSet<>(setA);
        diferencia.removeAll(setB);

        // Generar el diagrama de Venn
        VennDiagram venn = new VennDiagram();
        venn.difference(setA, setB);

        // Actualizar la imagen del diagrama de Venn
        vennDiagramLabel.setIcon(new ImageIcon(venn.getDiagram()));

        // Mostrar el resultado en el JTextArea
        String resultado = "Conjunto A: " + setA.toString() + "\n"
                        + "Conjunto B: " + setB.toString() + "\n"
                        + "Diferencia: " + diferencia.toString();
        JOptionPane.showMessageDialog(this, resultado);
    }

    private void realizarDiferenciaSimetrica() {
        // Obtener los valores ingresados por el usuario en los JTextField
        String conjuntoA = conjuntoATextField.getText().trim();
        String conjuntoB = conjuntoBTextField.getText().trim();

        // Crear conjuntos vacíos
        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();

        // Agregar los elementos del conjunto A al setA
        setA.addAll(Arrays.asList(conjuntoA.split(",")));

        // Agregar los elementos del conjunto B al setB
        setB.addAll(Arrays.asList(conjuntoB.split(",")));

        // Realizar la operación de diferencia simétrica
        Set<String> diferenciaSimetrica = new HashSet<>(setA);
        diferenciaSimetrica.addAll(setB);
        Set<String> interseccion = new HashSet<>(setA);
        interseccion.retainAll(setB);
        diferenciaSimetrica.removeAll(interseccion);

        // Generar el diagrama de Venn
        VennDiagram venn = new VennDiagram();
        venn.symmetricDifference(setA, setB);

        // Actualizar la imagen del diagrama de Venn
        vennDiagramLabel.setIcon(new ImageIcon(venn.getDiagram()));

        // Mostrar el resultado en el JTextArea
        String resultado = "Conjunto A: " + setA.toString() + "\n"
                        + "Conjunto B: " + setB.toString() + "\n"
                        + "Diferencia Simétrica: " + diferenciaSimetrica.toString();
        JOptionPane.showMessageDialog(this, resultado);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TeoriaConjuntosVentana();
            }
        });
    }
}