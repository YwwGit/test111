package com.jk.controller;

import java.util.ArrayList;
import java.util.List;

import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.model.Tree;


@Controller
@RequestMapping("tree")
public class TreeController {
	
	@Autowired
	private TreeService treeService;
	
	@RequestMapping("findTree")
	@ResponseBody
	public  List<Tree>  findTree(){
		List<Tree> list=treeService.findTree(0);
	
		List<Tree> parentTree = parentTree(list);
	
		return parentTree;
	}
	
	
	public  List<Tree> parentTree(List<Tree> list){
		List<Tree>  childList=new ArrayList<Tree>();
		
		for (int i = 0; i < list.size(); i++) {
			Tree menus = list.get(i);  
			
			List<Tree> findTree = treeService.findTree(menus.getId());
			//  判断他有没有子节点
			if(findTree.size()>0){   //  true
				//  当前 子节点的集合
				List<Tree> getchirdMenu = getchirdMenu(findTree);
				//  将子节点 数据装进  list
				menus.setNodes(getchirdMenu);
				childList.add(menus);
			}else{
				childList.add(menus);
			}
		}
		
		return  childList;
	}
	
	
	public  List<Tree> getchirdMenu(List<Tree> list){
		List<Tree>  childList=new ArrayList<Tree>();
		for (int i = 0; i < list.size(); i++) {
			Tree menus = list.get(i);  
			List<Tree> findTree = treeService.findTree(menus.getId());
			
			//  判断他有没有子节点
			if(findTree.size()>0){
				List<Tree> getchirdMenu = getchirdMenu(findTree);
				//  将子节点 数据装进  list
				menus.setNodes(getchirdMenu);
				childList.add(menus);
			}else{
				
				childList.add(menus);
			}
		}
		
		return   childList;
	};
	
}
