package com.queuing.kafka.topic;

import java.util.HashMap;
import java.util.Map;

import com.queuing.kafka.consumer.AbstractConsumer;

public abstract class AbstractTopic {
	private Map<String, AbstractConsumer> subscribedConsumers;
	private final String topicName;

	AbstractTopic(String topicName) {
		this.topicName = topicName;
		this.subscribedConsumers = new HashMap<String, AbstractConsumer>();
	}

	public boolean subscribeConsumer(AbstractConsumer consumer) {
		if (this.subscribedConsumers.containsKey(consumer.getConsumerName()))
			return false;
		else {
			this.subscribedConsumers.put(consumer.getConsumerName(), consumer);
			return true;
		}
	}

	public boolean unsubscribeConsumer(AbstractConsumer consumer) {
		if (!this.subscribedConsumers.containsKey(consumer.getConsumerName()))
			return false;
		else {
			this.subscribedConsumers.remove(consumer.getConsumerName());
			return true;
		}
	}

	public void notifyConsumers(String message) {
		Thread thread;
		for (AbstractConsumer consumer : subscribedConsumers.values()) {
			thread = new Thread() {
				public void run() {
					consumer.notify(message);
				}
			};
			thread.start();
		}
	}

	public void pushMessage(String message) {
		message = "Message pushed to " + this.getTopicName() + ": " + message;
		System.out.println(message);
		this.notifyConsumers(message);
	}

	public String getTopicName() {
		return topicName;
	}
}
