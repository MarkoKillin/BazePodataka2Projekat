package gui;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.VlasnikCrud;
import model.Dvlasnik;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UnosVlasnika extends JDialog {

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
			UnosVlasnika dialog = new UnosVlasnika();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setTitle("Unos vlasnika");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UnosVlasnika() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 450, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setBounds(164, 34, 195, 21);
			getContentPane().add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(164, 89, 195, 21);
			getContentPane().add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(164, 148, 195, 21);
			getContentPane().add(textField_2);
			
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 226, 450, 37);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("Unesi");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String ime = textField.getText();
						String prezime = textField_1.getText();
						String broj = textField_2.getText();
						Dvlasnik dv = new Dvlasnik();
						dv.setBrtel(broj);
						dv.setIme(ime);
						dv.setPrezime(prezime);
						vc.insertVlasnik(dv);
					}
				});;
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Zatvori");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JLabel lblNewLabel = new JLabel("Ime:");
		lblNewLabel.setBounds(32, 38, 58, 17);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prezime:");
		lblNewLabel_1.setBounds(32, 93, 58, 17);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Broj telefona:");
		lblNewLabel_2.setBounds(32, 152, 93, 17);
		getContentPane().add(lblNewLabel_2);
	}
}
