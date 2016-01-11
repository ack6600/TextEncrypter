import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
	public static File readFile;
	public static File writeFile;
	public static TextReader tr = new TextReader();
	public static Encryptor enc = new Encryptor();
	public static TextWriter tw = new TextWriter();
	public static int key;
	public static boolean isFinished = false;
	private static JFrame theJFrame;
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
				{
					public void run()
					{
						try {
							UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							error(e);
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							error(e);
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							error(e);
						} catch (UnsupportedLookAndFeelException e) {
							// TODO Auto-generated catch block
							error(e);
						}
						theJFrame = GUI.createGui();
					}
				});
		
		
	}
	public static void setReadFile(File f) throws IOException
	{
		readFile = f;		
		
	}
	public static void setWriteFile(File f) throws IOException
	{
		writeFile = f;
		
	}
	public static void setEncKey(int newKey)
	{
		key = newKey;
	}
	public static void encrypt()
	{
		try {
			tw.write(enc.encrypt(tr.read(readFile), key),writeFile);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			error(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			error(e);
		}
	}
	public static void error(Exception e)
	{
		System.out.println("Something went wrong");
		System.out.print("The error is as follows");
		e.printStackTrace();
		cleanup();
	}
	private static void cleanup()
	{
		theJFrame.dispose();
	}

}