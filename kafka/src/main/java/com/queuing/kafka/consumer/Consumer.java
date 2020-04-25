package com.queuing.kafka.consumer;

public class Consumer extends AbstractConsumer {

	public Consumer(String consumerName) {
		super(consumerName);
	}

	@Override
	public void notify(String message) {
		System.out.println("Message '" + message + "' consumed by '" + this.getConsumerName() + "'.");
	}

}
