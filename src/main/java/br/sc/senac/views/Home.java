package br.sc.senac.views;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.sc.senac.models.Imc;
import br.sc.senac.controllers.ControllerImc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.*;

public class Home extends JFrame implements ActionListener {
	private JPanel panel;
	private JTextField jtfWeight;
	private JTextField jtfHeigth;
	private JButton jbcalculate;
	private ImageIcon imageLogo;
	private JLabel containerImage;

	public Home() {
		this.build();
	}

	private void build() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 500);
		this.setLocationRelativeTo(null);

		panel = new JPanel();

		jtfWeight = new JTextField(30);
		jtfHeigth = new JTextField(30);
		jbcalculate = new JButton("Calcular");

		Path path = Paths.get("src/main/java/br/sc/senac/imgs/imc.png");

		imageLogo = new ImageIcon(path.toAbsolutePath().toString());
		containerImage = new JLabel(imageLogo);

		containerImage.setBounds(100, 0, 400, 200);

		jtfHeigth.setBounds(200, 200, 200, 30);
		jtfHeigth.setText("Altura");

		jtfWeight.setBounds(200, 255, 200, 30);
		jtfWeight.setText("Peso");

		jbcalculate.setBounds(200, 300, 200, 30);
		jbcalculate.setBorderPainted(false);
		jbcalculate.setBackground(new Color(207, 180, 101));

		// Adding Event ActionListener to elements
		jbcalculate.addActionListener(this);

		// Adding Elements in window
		panel.add(jtfHeigth);
		panel.add(jtfWeight);
		panel.add(jbcalculate);
		panel.add(containerImage);

		panel.setBackground(new Color(224, 224, 173));

		panel.setLayout(null);
		this.add(panel);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Home();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Imc imc = new Imc();

		try {
			imc.setHeigth(Double.parseDouble(this.jtfHeigth.getText()));
			imc.setWeight(Double.parseDouble(this.jtfWeight.getText()));

			ControllerImc controllerImc = new ControllerImc();

			double result = controllerImc.calculateImc(imc);

			JOptionPane.showMessageDialog(null, result);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Digite Somente Números");

		}

	}
}
