package com.queuing.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.queuing.kafka.consumer.AbstractConsumer;
import com.queuing.kafka.service.KafkaService;
import com.queuing.kafka.topic.AbstractTopic;

@RestController
public class KafkaController {

	@Autowired
	KafkaService kafkaService;

	@RequestMapping(method = RequestMethod.POST, value = "/topic")
	public AbstractTopic addTopic(@RequestParam String topicName) {
		return kafkaService.addTopic(topicName);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/consumer")
	public AbstractConsumer addConsumer(@RequestParam String consumerName) {
		return kafkaService.addConsumer(consumerName);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/subscribe-consumer")
	public void subscribeConsumer(@RequestParam String topicName, @RequestParam String consumerName) {
		kafkaService.subscribeConsumer(topicName, consumerName);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topic-message")
	public void pushMessage(@RequestParam String topicName, @RequestParam String message) {
		kafkaService.pushMessage(topicName, message);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/random-messages")
	public void pushRandomMessage(@RequestParam int messageCount) {
		kafkaService.pushRandomMessage(messageCount);
	}

}