package br.net.neuromancer.benerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EntryPoint {
	
	private static Logger logger = LoggerFactory.getLogger(EntryPoint.class);

	public static void main (String[] args){
		logger.info("Hello World, Benerator!");
		
	}
	
}
