package com.codeaches.base64encoder;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

@EnableBinding(Processor.class)
public class DemoProcessor {

	private final static Logger logger = LoggerFactory.getLogger(DemoProcessor.class);

	@Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
	public Object setupRequest(String message) {

		String encodedVal = Base64.getEncoder().encodeToString((message).getBytes());
		logger.info("Input: " + message + ", Encoded Value: " + encodedVal);
		return encodedVal;
	}
}