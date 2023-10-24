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
import model.Dstan;
import model.Dvlasnik;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class PrikazStanovaVlasnika extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	VlasnikCrud vc = new VlasnikCrud();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PrikazStanovaVlasnika dialog = new PrikazStanovaVlasnika();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PrikazStanovaVlasnika() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 77, 344, 137);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Vlasnik");
		lblNewLabel.setBounds(47, 23, 58, 17);
		contentPanel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		List<Dvlasnik> svi = vc.sviVlasnici();
		for (Dvlasnik d : svi) {
			comboBox.addItem(d);
		}
		comboBox.setBounds(114, 18, 211, 26);
		contentPanel.add(comboBox);
		
		JButton btnNewButton = new JButton("Prikazi");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Dvlasnik dv = (Dvlasnik) comboBox.getSelectedItem();
				List<Dstan> stanoviVl = vc.stanoviVlasnika(dv);
				Tabela t = new Tabela(stanoviVl);
				table.setModel(t);
				table.setVisible(true);
			}
		});
		btnNewButton.setBounds(337, 18, 101, 27);
		contentPanel.add(btnNewButton);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
