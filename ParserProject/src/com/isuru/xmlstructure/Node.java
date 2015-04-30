package com.isuru.xmlstructure;

import java.util.List;

public interface Node {
	static final int DOCUMENT_NODE = 1;
	static final int ELEMENT_NODE = 2;
	static final int TEXT_NODE = 3;

	int getType();

	Node getParent();

	List<Node> getChildList();

	Node getNextSibling();

	Node getPreviousSibling();

}
