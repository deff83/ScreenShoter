/**
 * 
 */
package com.Deff83;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author 1
 *
 */
public class FileChoose extends JFrame {

	
	public FileChoose() throws HeadlessException {
		super("ScreenShoter");
		// TODO Auto-generated constructor stub
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JFileChooser fchoose = new JFileChooser();
		JPanel panel = new JPanel();
		
		JButton buttonChoose = new JButton("Выбор папки для сохранения");
		JTextField textf = new JTextField(3);
		JLabel label = new JLabel("Время промежутка сохранения в секундах");
		
		buttonChoose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fchoose.setDialogTitle("Выбор папки для сохранения");
				fchoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int result = fchoose.showOpenDialog(FileChoose.this);
				if(result==JFileChooser.APPROVE_OPTION) {
					File configfilest = new File("config.xml");
					if(!configfilest.exists()) {
								
							try {
								if(configfilest.createNewFile()) {
									String timerstr = "5";
									try {
										if (Integer.parseInt(textf.getText())>0) {
											timerstr = textf.getText();
										}
									}catch(Exception e1) {}
									FileWriter fw = new FileWriter(configfilest);
									fw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+Main.sp);
									fw.write("<ConfigRes>"+Main.sp);
									fw.write("<Path>"+fchoose.getSelectedFile()+"</Path>"+Main.sp);
									fw.write("<Timer>"+timerstr+"</Timer>"+Main.sp);
									fw.write("</ConfigRes>");
									fw.flush();
									fw.close();
								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						dispose();
						
					}
				}
			}
			
		});
		panel.add(buttonChoose);
		panel.add(label);
		panel.add(textf);
		
		setContentPane(panel);
		setSize(350,100);
		setVisible(true);
	}

	

}
