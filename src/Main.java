import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException 
	{
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		File readFile = new File(args[1]);
		File writeFile = new File(args[2]);
		TextReader tr = new TextReader();
		Encryptor enc = new Encryptor();
		int key = Integer.parseInt(args[0]);
		String finalDoc[] = enc.encrypt(tr.read(readFile),key);
		TextWriter tw = new TextWriter();
		tw.write(finalDoc, writeFile);
	}

}
