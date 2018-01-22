package com.jk.model;

import java.io.Serializable;
import java.util.List;

public class Tree implements Serializable{

	private static final long serialVersionUID = 3632911639853638162L;
	private int  id;
	
	private String text;
	
	private String url;
	
	private int pid;
	
	private List<Tree> nodes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public List<Tree> getNodes() {
		return nodes;
	}

	public void setNodes(List<Tree> nodes) {
		this.nodes = nodes;
	}

	
	
}
