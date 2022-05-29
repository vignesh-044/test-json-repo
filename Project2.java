import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
public class Project2 {

	public static void main(String[] args) throws IOException {
        File input = new File("C:\\Users\\ACAL\\Videos\\New folder\\BZA05\\Employee_Salary.csv");
        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
        CsvMapper csvMapper = new CsvMapper();
        // Read data from CSV file
        List<Object> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValues(input).readAll();
        ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		// Write JSON formated data to output.json file			
		   for (Object row : readAll) {			
		Map<String, String> map = (Map<String, String>) row;			
		String fileName = map.get("File1");			
		File output = new File("F:\\interview\\New folder"+fileName+".txt");			
		 mapper.writerWithDefaultPrettyPrinter().writeValue(output, row);
}

	}

}
