package com.queuing.kafka.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.queuing.kafka.exceptionhandling.exception.InvalidTopicException;
import com.queuing.kafka.model.TopicModel;
import com.queuing.kafka.topic.AbstractTopic;
import com.queuing.kafka.topic.Topic;
import com.queuing.kafka.util.StringFunctions;

public class TopicFactory {
	private static TopicFactory instance;
	private TopicModel topicModel;
	private Logger logger = LoggerFactory.getLogger(TopicFactory.class);

	private TopicFactory() {
		topicModel = TopicModel.getInstance();
	}

	public static TopicFactory getInstance() {
		if (instance == null)
			instance = new TopicFactory();
		return instance;
	}

	public AbstractTopic createTopic(String topicName) {
		if (StringFunctions.isEmpty(topicName)) {
			String err = "Topic name cannot be empty.";
			logger.error(err);
			throw new InvalidTopicException(err);
		} else if (topicModel.topicExists(topicName)) {
			String err = "Topic '" + topicName + "' already exists.";
			logger.error(err);
			throw new InvalidTopicException(err);
		}

		AbstractTopic topic = new Topic(topicName);
		topicModel.addTopic(topic);

		return topic;
	}
}
