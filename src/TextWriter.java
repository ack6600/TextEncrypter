import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextWriter {
	public void write(String[] document,File file) throws IOException
	{
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i = 0; i<document.length; i++)
		{
		bw.write(document[i]);
		bw.newLine();
		}
		bw.close();
	}

}
