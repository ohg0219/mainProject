package com.thisisthat.admin.board.vo;

import java.util.Date;

public class AnswerBoardVO {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private Date regDate;
	private Date updateDate;
	private int productNo;
	private String boardState;
	private boolean boardSecret;
	private int resultNo;
	private String boardImg1;
	private String boardImg2;
	private String boardImg3;
	private String boardImg4;
	private String boardType;
	
	
	
	
	@Override
	public String toString() {
		return "AnswerBoardVO [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardWriter=" + boardWriter + ", regDate=" + regDate + ", updateDate=" + updateDate
				+ ", productNo=" + productNo + ", boardState=" + boardState + ", boardSecret=" + boardSecret
				+ ", resultNo=" + resultNo + ", boardImg1=" + boardImg1 + ", boardImg2=" + boardImg2 + ", boardImg3="
				+ boardImg3 + ", boardImg4=" + boardImg4 + ", boardType=" + boardType + ", getBoardType()="
				+ getBoardType() + ", getBoardNo()=" + getBoardNo() + ", getBoardTitle()=" + getBoardTitle()
				+ ", getBoardContent()=" + getBoardContent() + ", getBoardWriter()=" + getBoardWriter()
				+ ", getRegDate()=" + getRegDate() + ", getUpdateDate()=" + getUpdateDate() + ", getProductNo()="
				+ getProductNo() + ", getBoardState()=" + getBoardState() + ", isBoardSecret()=" + isBoardSecret()
				+ ", getResultNo()=" + getResultNo() + ", getBoardImg1()=" + getBoardImg1() + ", getBoardImg2()="
				+ getBoardImg2() + ", getBoardImg3()=" + getBoardImg3() + ", getBoardImg4()=" + getBoardImg4()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public String getBoardType() {
		return boardType;
	}
	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getBoardState() {
		return boardState;
	}
	public void setBoardState(String boardState) {
		this.boardState = boardState;
	}
	public boolean isBoardSecret() {
		return boardSecret;
	}
	public void setBoardSecret(boolean boardSecret) {
		this.boardSecret = boardSecret;
	}
	public int getResultNo() {
		return resultNo;
	}
	public void setResultNo(int resultNo) {
		this.resultNo = resultNo;
	}
	public String getBoardImg1() {
		return boardImg1;
	}
	public void setBoardImg1(String boardImg1) {
		this.boardImg1 = boardImg1;
	}
	public String getBoardImg2() {
		return boardImg2;
	}
	public void setBoardImg2(String boardImg2) {
		this.boardImg2 = boardImg2;
	}
	public String getBoardImg3() {
		return boardImg3;
	}
	public void setBoardImg3(String boardImg3) {
		this.boardImg3 = boardImg3;
	}
	public String getBoardImg4() {
		return boardImg4;
	}
	public void setBoardImg4(String boardImg4) {
		this.boardImg4 = boardImg4;
	}
	
}
