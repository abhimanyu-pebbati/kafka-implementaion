package com.queuing.kafka.model;

import java.util.HashMap;
import java.util.Map;

import com.queuing.kafka.consumer.AbstractConsumer;

public class ConsumerModel {
	private static ConsumerModel instance;
	private Map<String, AbstractConsumer> consumers;

	private ConsumerModel() {
		this.consumers = new HashMap<String, AbstractConsumer>();
	}

	public static ConsumerModel getInstance() {
		if (instance == null)
			instance = new ConsumerModel();
		return instance;
	}

	public boolean consumerExists(String consumerName) {
		return consumers.containsKey(consumerName);
	}

	public void addConsumer(AbstractConsumer consumer) {
		consumers.put(consumer.getConsumerName(), consumer);
	}

	public AbstractConsumer getConsumer(String consumerName) {
		return consumers.get(consumerName);
	}

}
