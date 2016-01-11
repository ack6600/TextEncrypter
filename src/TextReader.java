import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TextReader {

	public String[] read(File file) throws IOException
	{
		FileReader f = null;
		try {
			f = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Main.error(e);
			System.exit(0);
		}
		int lines = 0;
		BufferedReader b = new BufferedReader(f);
		b.mark(100);
		Scanner s = new Scanner(b);
		String line = null;
		while(true)
		{
			try
			{
			line = s.nextLine();
			}
			catch(NoSuchElementException e)
			{
//				e.printStackTrace();
				break;
			}
			System.out.println(line);
			lines++;
		}
		b.reset();
		System.out.println(lines);
		String document[] = new String[lines];
		System.out.println(document.length);
		for(int i = 0; i<document.length; i++)
		{
			document[i] = b.readLine();
			System.out.println(document[i]);
		}
		s.close();
		return document;
	}

}
