package com.isuru.xmlstructure;

public class TextImpl extends NodeImpl implements Text {

	private String textData;

	@Override
	public int getType() {
		return TEXT_NODE;
	}

	@Override
	public String getData() {
		return this.textData;
	}

	@Override
	public void setData(String data) {
		this.textData = data;

	}

}
