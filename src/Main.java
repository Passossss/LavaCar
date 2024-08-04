import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JTextField horasTextField;
    private JLabel resultadoLabel;

    public Main() {
        setTitle("Calculadora de Serviços");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        JLabel horasLabel = new JLabel("Fale a quantidade de horas:");
        horasTextField = new JTextField();
        JButton calcularButton = new JButton("Calcular");
        resultadoLabel = new JLabel("O valor total do serviço é R$ 0.00");

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularValor();
            }
        });

        add(horasLabel);
        add(horasTextField);
        add(calcularButton);
        add(resultadoLabel);
    }

    private void calcularValor() {
        try {
            double horasTrabalhadas = Double.parseDouble(horasTextField.getText());
            Servico servico = new Servico();
            double valorTotal = servico.calcularValor(horasTrabalhadas);
            resultadoLabel.setText("O valor total do serviço é R$ " + valorTotal);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}