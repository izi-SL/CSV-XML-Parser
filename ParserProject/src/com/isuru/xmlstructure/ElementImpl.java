package com.isuru.xmlstructure;

import java.util.Map;

public class ElementImpl extends NodeImpl implements Element{

	private String tagName;
	private Map<String, String> attributes;
	
	
	@Override
	public String getTagName() {
		return this.tagName;
	}

	@Override
	public void setTagName(String tagName) {
		this.tagName=tagName;
		
	}

	@Override
	public Map<String, String> getAttributes() {
		return this.attributes;
	}

	@Override
	public void setAttributes(Map<String, String> attributes) {
		this.attributes=attributes;
		
	}

	@Override
	public String getAttributeValue(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
