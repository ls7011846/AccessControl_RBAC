package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;


public class test_2 extends JFrame {
	JTextArea area;

	public test_2() {
		setTitle("test");
		setSize(300, 300);
		setLayout(new BorderLayout());
		area = new JTextArea();
		add(new JScrollPane(area), BorderLayout.CENTER);

		JButton button = new JButton("save");
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				save();
			}

		});
		add(button, BorderLayout.SOUTH);
	}

	public void save() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		chooser.setFileFilter(new FileFilter() {

			public boolean accept(File f) {
				return f.getName().toLowerCase().endsWith(".txt");
			}

			public String getDescription() {
				return "SAVE TO";
			}

		});
		int r = chooser.showSaveDialog(this);
		if (r != JFileChooser.APPROVE_OPTION)
			return;
		File f = chooser.getSelectedFile();
		String text = area.getText();
		String[] lines = text.trim().split("\n");
		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(f), true);
			for (String line : lines)
				out.println(line);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				JFrame frame = new test_2();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}

		});
	}
}