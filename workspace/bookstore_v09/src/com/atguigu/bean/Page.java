package com.atguigu.bean;

import java.util.List;

/**
 * 描述：用来封装颁信息
 * 开发者：Miss Wang
 * 2017年4月19日 下午3:07:07
 */
public class Page<T> {
	//页面显示的数据列表 
	List<T> list;
	//数据库中的总记录数
	int totalRecord;
	//当前页显示条数
	int pageSize;
	//当前页码
	int pageNo;
	//总页数
	//int totalPage;
	//索引
	//int index;
	//用来保存路径
	String path;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		if(pageNo<=1){
			pageNo=1;
		}
		if(pageNo>=getTotalPage()){
			pageNo=getTotalPage();
		}
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * 总记录数 / 每页条数 = 总页数
	 * 	10 / 2 = 5
	 * 	9  / 2 = 5
	 *  8  / 2 = 4
	 *  7  / 2 = 4
	 *  6  / 2 = 3
	 *  5  / 2 = 3
	 * @return
	 */
	public int getTotalPage() {
		int count = getTotalRecord() / getPageSize();
		if(getTotalRecord() % getPageSize() > 0){
			count++;
		}
		return count;
	}
	
	/**
	 * （当前页 - 1）* 每页条数 = 索引
	 * 	（1-1） * 3 = 0
	 *  （2-1）* 3 = 3
	 *  （3-1）* 3 = 6
	 * @return
	 */
	public int getIndex() {
		return (getPageNo()-1)*getPageSize();
	}
	@Override
	public String toString() {
		return "Page [list=" + list + ", totalRecord=" + totalRecord
				+ ", pageSize=" + pageSize + ", pageNo=" + pageNo + "]";
	}
	
	
}
