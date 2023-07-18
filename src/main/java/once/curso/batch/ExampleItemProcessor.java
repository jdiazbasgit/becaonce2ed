package once.curso.batch;

import java.util.StringTokenizer;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("process")
public class ExampleItemProcessor implements ItemProcessor<String, Integer> {

	public Integer process(String item) throws Exception {
		StringTokenizer stringTokenizer= new StringTokenizer(item,";");
		int numero1= Integer.parseInt(stringTokenizer.nextToken());
		int numero2= Integer.parseInt(stringTokenizer.nextToken());
		return numero1+numero2;
	}

}
