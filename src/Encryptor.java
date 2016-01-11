import java.util.Arrays;

public class Encryptor {
	public String[] encrypt(String[] document,int key) throws NullPointerException
	{
		String[] encryptedDoc = new String[document.length];
		char alphabet[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		Arrays.sort(alphabet);
		char encryptedLineArray[];
		for(int i = 0; i<document.length; i++)
		{
			char lineArray[] = document[i].toCharArray();
			encryptedLineArray = new char[lineArray.length];
			for(int j = 0;j<lineArray.length; j++)
			{
				String alph = new String(alphabet);
				if(alph.indexOf(lineArray[j]) != -1)
				{
					if(Arrays.binarySearch(alphabet, lineArray[j])+key <= alphabet.length)
					{
					encryptedLineArray[j] = alphabet[Arrays.binarySearch(alphabet, lineArray[j])+key];
//					System.out.println(encryptedLineArray[j]);
					}
					else
					{
						encryptedLineArray[j] = alphabet[((Arrays.binarySearch(alphabet, lineArray[j])+key)-alphabet.length)];
						System.out.println(Arrays.binarySearch(alphabet, lineArray[j])+key);
					}
				}
				else
				{
					encryptedLineArray[j] = lineArray[j];
				}
			}
			encryptedDoc[i] = new String(encryptedLineArray);
			System.out.println(encryptedDoc[i]);
		}
		
		return encryptedDoc;
	}

}
