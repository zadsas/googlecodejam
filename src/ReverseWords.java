import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.io.IOUtils;

public class ReverseWords {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		String intputFilePath = args[0];
		String outputFilePath = args[0].substring(0, args[0].lastIndexOf(".")) + ".out";
		
		File outputFile = new File(outputFilePath);
		FileWriter outputFileWriter = new FileWriter(outputFile);
		
		File intpuFile = new File(intputFilePath);
		List<String> lines = IOUtils.readLines(new FileInputStream(intpuFile));
		
		for (int i = 1 ; i < lines.size() ; i++) {
			
			String actualLine = lines.get(i);
			List<String> listOfWords = Arrays.asList(actualLine.split(" "));
			outputFileWriter.write("Case #" + i + ":");
			
			ListIterator<String> iterator = listOfWords.listIterator(listOfWords.size());
			while(iterator.hasPrevious()){
				outputFileWriter.write(" " + iterator.previous());				
			}
			
			outputFileWriter.write("\n");
		}
		
		outputFileWriter.close();
		
	}

}
