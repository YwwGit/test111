package com.jk.service.impl;

import java.util.List;

import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.dao.TreeMapper;
import com.jk.model.Tree;

@Service("treeService")
public class TreeServiceImpl implements TreeService {

	@Autowired
	private TreeMapper treeMapper;

	@Override
	public List<Tree> findTree(int i) {
		return treeMapper.findTree(i);
	}
}
