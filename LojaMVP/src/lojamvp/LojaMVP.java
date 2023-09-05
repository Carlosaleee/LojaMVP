
package lojamvp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LojaMVP {
    private static JTextField valorVendaField;
    private static JButton calcularButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Loja MVP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel valorVendaLabel = new JLabel("Valor da Venda:");
        valorVendaLabel.setBounds(20, 20, 100, 20);
        frame.add(valorVendaLabel);

        valorVendaField = new JTextField();
        valorVendaField.setBounds(120, 20, 150, 20);
        frame.add(valorVendaField);

        calcularButton = new JButton("Calcular");
        calcularButton.setBounds(120, 50, 150, 30);
        frame.add(calcularButton);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularValorTotal();
            }
        });

        frame.setSize(300, 150);
        frame.setVisible(true);
    }

    private static void calcularValorTotal() {
        double valorVenda = Double.parseDouble(valorVendaField.getText());

        if (valorVenda > 500) {
            String percentualDescontoStr = JOptionPane.showInputDialog(null, "Digite o percentual de desconto:", "Desconto", JOptionPane.INFORMATION_MESSAGE);
            if (percentualDescontoStr == null || percentualDescontoStr.trim().isEmpty()) {
                return;
            }

            double percentualDesconto = Double.parseDouble(percentualDescontoStr);
            double valorComDesconto = valorVenda - (valorVenda * percentualDesconto / 100);

            JOptionPane.showMessageDialog(null, "Valor Total com Desconto: R$" + valorComDesconto, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Valor Total: R$" + valorVenda, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

