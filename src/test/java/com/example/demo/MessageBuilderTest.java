package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MessageBuilderTest {

	@Test
	public void testWithTwoMessages() {
		MessageBuilder message = new MessageBuilder();
		String[] stringArray = new String[2];
		stringArray[0] = "Ab";
		stringArray[1] = "bcZ";
		String parsedMessage = message.rebuildMessage(stringArray);
		assertEquals("AbcZ", parsedMessage);
	}
	
	@Test
	public void testWithTwoMessagesNotInOrder() {
		MessageBuilder message = new MessageBuilder();
		String[] stringArray = new String[2];
		stringArray[0] = "bcZ";
		stringArray[1] = "Ab";
		String parsedMessage = message.rebuildMessage(stringArray);
		assertEquals("AbcZ", parsedMessage);
	}
	
	@Test
	public void testWithMoreMessages() {
		MessageBuilder message = new MessageBuilder();
		String[] stringArray = new String[4];
		stringArray[0] = "*====#";
		stringArray[1] = "X-+-+-+-+-+-Z";
		stringArray[2] = "#______X";
		stringArray[3] = "A.........*";
		String parsedMessage = message.rebuildMessage(stringArray);
		assertEquals("A.........*====#______X-+-+-+-+-+-Z", parsedMessage);
	}
}
