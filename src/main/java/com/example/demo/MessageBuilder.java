package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MessageBuilder {
	private static final char STARTING_CHAR = 'A';
	private static final char ENDING_CHAR = 'Z';

	public String rebuildMessage(List<String> partList, char joiningChar) {
		String returnValue = "";
		if (partList.size() > 1) {
			String nextElement = getElementStartingWithChar(partList, joiningChar);
			String nextElementWithoutEndingChar = removeEndingChar(nextElement);
			char nextJoiningChar = getLastChar(nextElement);
			List<String> remainingList = removeItemFromList(partList, nextElement);
			returnValue = nextElementWithoutEndingChar + rebuildMessage(remainingList, nextJoiningChar);
		} else {
			if (partList.size() == 1 && partList.get(0).endsWith(Character.toString(ENDING_CHAR))) {
				returnValue = partList.get(0);
			}
		}
		return returnValue;
	}

	public String rebuildMessage(String[] stringArray) {
		List<String> partList = Arrays.asList(stringArray);
		String returnValue = "";
		String firstElement = getElementStartingWithChar(partList, STARTING_CHAR);
		String firstElementWithoutEndingChar = removeEndingChar(firstElement);
		char joiningChar = getLastChar(firstElement);
		List<String> stringListWithoutElement = removeItemFromList(partList, firstElement);
		String restOfTheString = rebuildMessage(stringListWithoutElement, joiningChar);
		returnValue = firstElementWithoutEndingChar + restOfTheString;
		return returnValue;
	}

	private String getElementStartingWithChar(List<String> list, char startingChar) {
		return list.stream().filter(el -> el.startsWith(Character.toString(startingChar))).collect(Collectors.toList())
				.get(0);
	}

	private List<String> removeItemFromList(List<String> list, String item) {
		return list.stream().filter(el -> !el.equals(item)).collect(Collectors.toList());
	}

	private String removeEndingChar(String s) {
		return s.substring(0, s.length() - 1);
	}

	private char getLastChar(String s) {
		return s.charAt(s.length() - 1);
	}
}
