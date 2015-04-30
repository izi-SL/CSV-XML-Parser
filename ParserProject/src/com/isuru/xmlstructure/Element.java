package com.isuru.xmlstructure;

import java.util.Map;

public interface Element extends Node {

	String getTagName();

	void setTagName(String tagName);

	Map<String, String> getAttributes();

	void setAttributes(Map<String, String> attributes);

	String getAttributeValue(String name);

	
}
