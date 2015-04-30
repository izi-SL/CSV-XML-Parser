package com.isuru.xmlstructure;

public class DocumentImpl extends NodeImpl implements Document {

	private Element rootElement;

	private DocumentImpl() {
		rootElement = new ElementImpl();
	}

	@Override
	public int getType() {
		return DOCUMENT_NODE;
	}

	@Override
	public Element getElement() {

		return rootElement;
	}

	private Document processXMLStructure() {
		
		
		return null;
	}

}
