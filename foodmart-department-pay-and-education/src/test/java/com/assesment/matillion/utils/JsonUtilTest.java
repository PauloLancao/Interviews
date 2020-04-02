package com.assesment.matillion.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JsonUtilTest {

	@Test
	public void convertToJsonTest() {
		// arrange
		List<String> arrange = new ArrayList<>();
		arrange.add("<>json test <html<<>");
		
		// act
		String convertedList = JsonUtil.convertToJson(arrange);
		
		// assert
	    assertTrue(convertedList.contains("<>json test <html<<>"));
	}
}
