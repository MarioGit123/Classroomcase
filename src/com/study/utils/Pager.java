package com.study.utils;

import java.util.List;

/**分页的所有信息
 * @author SMILE
 */
public class Pager<E> {
	private Integer pageno;//当前页
	private Integer total;//总条数
	private Integer pagesize;//每页数量
	private List<E> data;//分页数据

	/**是否首页
	 * @return
	 */
	public boolean getFirst() {
		if(pageno==1)
			return true;
		return false;
	}
	
	/**是否尾页
	 * @return
	 */
	public boolean getLast() {
		if(pageno==getPagecount())
			return true;
		return false;
	}
	
	/**获取前一页
	 * @return
	 */
	public Integer getPrev() {
		if(pageno==1)
			return pageno;
		return pageno-1;
	}
	
	
	/**获取下一页
	 * @return
	 */
	public Integer getNext() {
		return pageno==getPagecount()?pageno:pageno+1;
	}
	
	/**根据总记录数和每页条数，获取的总页码数
	 * @return
	 */
	public Integer getPagecount() {
		return total%pagesize==0?total/pagesize:
			(total/pagesize)+1;
	}
	
	
	public Integer getPageno() {
		return pageno;
	}
	public void setPageno(Integer pageno) {
		this.pageno = pageno;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public List<E> getData() {
		return data;
	}
	public void setData(List<E> data) {
		this.data = data;
	}

	public Pager(Integer pageno, Integer total, Integer pagesize, List<E> data) {
		this.pageno = pageno;
		this.total = total;
		this.pagesize = pagesize;
		this.data = data;
	}

	public Pager() {
	}
}
