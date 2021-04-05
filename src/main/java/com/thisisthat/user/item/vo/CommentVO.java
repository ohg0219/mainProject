package com.thisisthat.user.item.vo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CommentVO {
	private int commentNo;	//PK
	private int boardNo;	
	private String content;
    private String writer;
    private Date regDate;
    private Date deleteDate;
    private int parentNo; //commentNo
    private String[] img;
    
    
	@Override
	public String toString() {
		return "CommentVO [commentNo=" + commentNo + ", boardNo=" + boardNo + ", content=" + content + ", writer="
				+ writer + ", regDate=" + regDate + ", deleteDate=" + deleteDate + ", parentNo=" + parentNo + ", img="
				+ Arrays.toString(img) + "]";
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	public int getParentNo() {
		return parentNo;
	}
	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
	}
	public String[] getImg() {
		return img;
	}
	public void setImg(String[] img) {
		this.img = img;
	}
    
    
    
	
}
