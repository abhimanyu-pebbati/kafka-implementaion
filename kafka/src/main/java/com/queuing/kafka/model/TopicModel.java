package com.queuing.kafka.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.queuing.kafka.exceptionhandling.exception.InvalidTopicException;
import com.queuing.kafka.topic.AbstractTopic;

public class TopicModel {
	private static TopicModel instance;
	private Map<String, AbstractTopic> topics;

	private TopicModel() {
		this.topics = new HashMap<String, AbstractTopic>();
	}

	public static TopicModel getInstance() {
		if (instance == null)
			instance = new TopicModel();
		return instance;
	}

	public boolean topicExists(String topicName) {
		return topics.containsKey(topicName);
	}

	public void addTopic(AbstractTopic topic) {
		topics.put(topic.getTopicName(), topic);
	}

	public AbstractTopic getTopic(String topicName) {
		if (!this.topicExists(topicName))
			throw new InvalidTopicException("Topic '" + topicName + "' does not exists.");
		return topics.get(topicName);
	}

	public List<AbstractTopic> getTopicsList() {
		return topics.values().stream().collect(Collectors.toList());
	}

}
