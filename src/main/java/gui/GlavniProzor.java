package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GlavniProzor extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GlavniProzor dialog = new GlavniProzor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GlavniProzor() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("Unos vlasnika");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UnosVlasnika uv = new UnosVlasnika();
				uv.setVisible(true);
			}
		});
		btnNewButton.setBounds(26, 22, 147, 27);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Unos stana");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UnosStana us = new UnosStana();
				us.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(26, 70, 147, 27);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Brisanje zgrade");
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BrisanjeZgrade bz = new BrisanjeZgrade();
				bz.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(26, 125, 147, 27);
		contentPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Prikaz stanova vlasnika");
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PrikazStanovaVlasnika psv = new PrikazStanovaVlasnika();
				psv.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(26, 178, 147, 27);
		contentPanel.add(btnNewButton_3);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
