package com.ddlab.rnd.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ddlab.rnd.entity.Employee;

@EnableBinding(Source.class)
@RestController
public class PublishController {

	@Autowired
	private MessageChannel output;

	@PostMapping("/publish")
	public Employee publishEvent(@RequestBody Employee emp) {
		output.send(MessageBuilder.withPayload(emp).build());
		return emp;
	}
}
