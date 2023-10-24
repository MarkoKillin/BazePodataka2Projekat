package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.VlasnikCrud;
import model.Dvlasnik;
import model.Dzgrada;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class UnosStana extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	VlasnikCrud vc = new VlasnikCrud();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UnosStana dialog = new UnosStana();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setTitle("Unos stana");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UnosStana() {
		setBounds(100, 100, 364, 379);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Zgrada");
		lblNewLabel.setBounds(25, 30, 60, 20);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Vlasnik");
		lblNewLabel_1.setBounds(25, 80, 60, 20);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Broj stana");
		lblNewLabel_2.setBounds(25, 130, 60, 20);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sprat");
		lblNewLabel_3.setBounds(25, 180, 60, 20);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Kvadratura");
		lblNewLabel_4.setBounds(25, 230, 80, 20);
		contentPanel.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		List<Dzgrada> zgrade = vc.sveZgrade();
		for(Dzgrada d : zgrade) {
			comboBox.addItem(d);
		}
		comboBox.setBounds(140, 30, 180, 25);
		contentPanel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		List<Dvlasnik> vlasnici = vc.sviVlasnici();
		for(Dvlasnik v : vlasnici) {
			comboBox_1.addItem(v);
		}
		comboBox_1.setBounds(140, 80, 180, 25);
		contentPanel.add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(140, 130, 180, 25);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(140, 180, 180, 25);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(140, 230, 180, 25);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Unesi");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Dzgrada a = (Dzgrada) comboBox.getSelectedItem();
						Dvlasnik b = (Dvlasnik) comboBox_1.getSelectedItem();
						int br = Integer.parseInt(textField.getText());
						int sp = Integer.parseInt(textField_1.getText());
						double kv = Double.parseDouble(textField.getText());
						vc.insertStan(b, a, br, kv, sp);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Zatvori");
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
