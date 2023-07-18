package once.curso.batch;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import lombok.Data;


/**
 * Dummy {@link ItemWriter} which only logs data it receives.
 */
@Component("writer")
@Data
public class ExampleItemWriter implements ItemWriter<Integer> {

	private static final Log log = LogFactory.getLog(ExampleItemWriter.class);
	
	private PrintWriter printWriter;
	
	/**
	 * @see ItemWriter#write(java.util.List)
	 */
	public void write(List<? extends Integer> data) throws Exception {
		if(getPrintWriter()==null) {
			setPrintWriter(new PrintWriter(new FileOutputStream("salida.txt",true)));
		}
		getPrintWriter().println(data.get(0));
		System.out.println(data.get(0));
		getPrintWriter().flush();
		
		
	}

}
