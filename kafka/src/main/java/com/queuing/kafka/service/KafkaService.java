package com.queuing.kafka.service;

import com.queuing.kafka.consumer.AbstractConsumer;
import com.queuing.kafka.topic.AbstractTopic;

public interface KafkaService {

	public AbstractTopic addTopic(String topicName);

	public AbstractConsumer addConsumer(String topicName);

	public void subscribeConsumer(String topicName, String consumerName);
	
	public void pushMessage(String topicName, String message);

	public void pushRandomMessage(int messageCount);

}
