import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class GUI extends JPanel implements ActionListener,DocumentListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton readButton,writeButton,finishButton;
	JTextField tf;
	JFileChooser fc;
	JLabel jl;
	JSeparator js;
	File f;
	static Dimension screenSize;
	public GUI()
	{
		JPanel jp = new JPanel();
		JPanel jp2 = new JPanel();
		this.setBorder(new EmptyBorder(10,10,10,10));
		jp.setBorder(new EmptyBorder(10,10,10,10));
		jp2.setBorder(new EmptyBorder(10,10,10,10));
		jp.setLayout(new BorderLayout());
		jp2.setLayout(new BorderLayout());
		setLayout(new BorderLayout());
		jl = new JLabel();
		jl.setText("Encryption key");
		js = new JSeparator();
		fc = new JFileChooser();
		readButton = new JButton();
		writeButton = new JButton();
		finishButton = new JButton();
		tf = new JTextField();
		
		writeButton.setText("Set Write File");
		readButton.setText("Set Read File");
		finishButton.setText("Finish");
		readButton.addActionListener(this);
		writeButton.addActionListener(this);
		finishButton.addActionListener(this);
		tf.setText("1");
		Main.setEncKey(Integer.parseInt(tf.getText()));
		tf.getDocument().addDocumentListener(this);;
		jp.add(writeButton,BorderLayout.EAST);
		jp.add(readButton, BorderLayout.WEST);
		add(jp,BorderLayout.NORTH);
		
		jp2.add(tf,BorderLayout.EAST);
		jp2.add(jl, BorderLayout.WEST);
		
		add(jp2,BorderLayout.CENTER);
		add(finishButton,BorderLayout.SOUTH);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource() == readButton)
		{
			int val = fc.showOpenDialog(this);
			if(val==JFileChooser.APPROVE_OPTION)
			{
				try {
					Main.setReadFile(fc.getSelectedFile());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					Main.error(e1);
				}
			}
		}
		if(e.getSource() == writeButton)
		{
			int val = fc.showOpenDialog(this);
			if(val == JFileChooser.APPROVE_OPTION)
			{
				try {
					Main.setWriteFile(fc.getSelectedFile());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					Main.error(e1);
				}
			}
		}
		if(e.getSource() == finishButton)
		{
			Main.encrypt();
		}
		
		
	}
	public File getFile()
	{
		return f;
	}
	public static JFrame createGui()
	{
		JFrame j = new JFrame();
		screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		j.add(new GUI());
		j.pack();
		j.setLocation(0, 0);
		j.setVisible(true);
		j.setBackground(Color.WHITE);
		return j;
//		j.setUndecorated(true);
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(tf.getText());
		try
		{
			Main.setEncKey(Integer.parseInt(tf.getText()));
		}
		catch(NumberFormatException e)
		{
			Main.error(e);
		}
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}
	
	

}
