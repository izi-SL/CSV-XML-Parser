package com.isuru.xmlstructure;

import java.util.List;

public class NodeImpl implements Node {
	private NodeImpl prevSibling;
	private NodeImpl nextSibling;
	private List<Node> childList;
	private NodeImpl parent;

	public NodeImpl getPrevSibling() {
		return prevSibling;
	}

	public void setPrevSibling(NodeImpl prevSibling) {
		this.prevSibling = prevSibling;
	}

	public void setParent(NodeImpl parent) {
		this.parent = parent;
	}

	public void setNextSibling(NodeImpl nextSibling) {
		this.nextSibling = nextSibling;
	}

	public void setChildList(List<Node> childList) {
		this.childList = childList;
	}

	@Override
	public int getType() {
		return 0;
	}

	@Override
	public Node getParent() {
		return parent;
	}

	@Override
	public Node getNextSibling() {
		return nextSibling;
	}

	@Override
	public Node getPreviousSibling() {
		return prevSibling;
	}

	@Override
	public List<Node> getChildList() {
		return childList;
	}

}
