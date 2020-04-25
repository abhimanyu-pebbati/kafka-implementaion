package com.queuing.kafka.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.queuing.kafka.consumer.AbstractConsumer;
import com.queuing.kafka.consumer.Consumer;
import com.queuing.kafka.exceptionhandling.exception.InvalidConsumerException;
import com.queuing.kafka.model.ConsumerModel;
import com.queuing.kafka.util.StringFunctions;

public class ConsumerFactory {
	private static ConsumerFactory instance;
	private ConsumerModel consumerModel;
	private Logger logger = LoggerFactory.getLogger(ConsumerFactory.class);

	private ConsumerFactory() {
		consumerModel = ConsumerModel.getInstance();
	}

	public static ConsumerFactory getInstance() {
		if (instance == null)
			instance = new ConsumerFactory();
		return instance;
	}

	public AbstractConsumer createConsumer(String consumerName) {
		if (StringFunctions.isEmpty(consumerName)) {
			String err = "Consumer name cannot be empty.";
			logger.error(err);
			throw new InvalidConsumerException(err);
		} else if (consumerModel.consumerExists(consumerName)) {
			String err = "Consumer '" + consumerName + "' already exists.";
			logger.error(err);
			throw new InvalidConsumerException(err);
		}

		AbstractConsumer consumer = new Consumer(consumerName);
		consumerModel.addConsumer(consumer);

		return consumer;
	}
}
