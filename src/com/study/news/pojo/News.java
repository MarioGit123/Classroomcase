package com.study.news.pojo;

import java.sql.Timestamp;

/**POJO类
 * @author SMILE
 */
public class News {
	private int newsid;
	private String title;
	private String content;
	private Timestamp newdate;
	private String author;
	private String resource;


	public int getNewsid() {
		return newsid;
	}
	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getNewdate() {
		return newdate;
	}
	public void setNewdate(Timestamp newdate) {
		this.newdate = newdate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public News(int newsid, String title, String content, Timestamp newdate, String author, String resource) {
		super();
		this.newsid = newsid;
		this.title = title;
		this.content = content;
		this.newdate = newdate;
		this.author = author;
		this.resource = resource;
	}
	
	public News() {
		
	}
	@Override
	public String toString() {
		return "News [newsid=" + newsid + ", title=" + title + ", content=" + content + ", newdate=" + newdate
				+ ", author=" + author + ", resource=" + resource + "]";
	}
	
	
}
