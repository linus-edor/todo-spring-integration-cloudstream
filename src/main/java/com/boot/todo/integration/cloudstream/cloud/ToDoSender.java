package com.boot.todo.integration.cloudstream.cloud;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import com.boot.todo.integration.cloudstream.model.ToDo;

@Configuration
public class ToDoSender {
	@Bean
	public ApplicationRunner send(MessageChannel input) {
		return args -> {
			while (true) {
				input.send(MessageBuilder.withPayload(new ToDo("Read a Book")).build());
				Thread.sleep(3000);
			}
		};
	}
}