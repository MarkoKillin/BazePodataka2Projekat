package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.VlasnikCrud;
import crud.ZgradaCrud;
import model.Dzgrada;

import javax.swing.JLabel;
import javax.swing.JComboBox;

public class BrisanjeZgrade extends JDialog {

	private final JPanel contentPanel = new JPanel();
	ZgradaCrud zc = new ZgradaCrud();
	VlasnikCrud vc = new VlasnikCrud();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BrisanjeZgrade dialog = new BrisanjeZgrade();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BrisanjeZgrade() {
		setBounds(100, 100, 441, 220);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Zgrada");
			lblNewLabel.setBounds(32, 61, 58, 17);
			contentPanel.add(lblNewLabel);
		}
		
		JComboBox comboBox = new JComboBox();
		List<Dzgrada> lista = vc.sveZgrade();
		for (Dzgrada z : lista) {
			comboBox.addItem(z);
		}
		comboBox.setBounds(129, 56, 268, 26);
		contentPanel.add(comboBox);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Brisi");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Dzgrada izabrana = (Dzgrada) comboBox.getSelectedItem();
						zc.deleteZgrada(izabrana);						
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
