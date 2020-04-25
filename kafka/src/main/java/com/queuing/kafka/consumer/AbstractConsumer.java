package com.queuing.kafka.consumer;

public abstract class AbstractConsumer {
	private final String consumerName;

	AbstractConsumer(String consumerName) {
		this.consumerName = consumerName;
	}

	public abstract void notify(String message);
	
	public String getConsumerName() {
		return consumerName;
	}
}
