package com.thisisthat.admin.orderManagement.vo;

import java.util.Date;

public class OrderManagementVO {

	
	//order_table
	private int order_no;//주문 번호 
	private Date order_date;//주문 일
	private String user_id;//고객 ID
	private String order_password;//결제 비밀번호
	private String order_email;//주문자 이메일
	private String receive_name;//수취인 이름
	private String receive_phone;//수취인 연락처
	private String receive_zipcode;//수취인 우편번호
	private String receive_first_address;//수취인 주소1
	private String receive_last_address;//수취인 주소2
	private String order_message;//배송 메시지
	private int original_price;//총 소비자가격
	private int use_point;//포인트 사용
	private int use_coupon;//쿠폰 사용
	private int order_price;//실제 결제 금액
	private String order_select;//결제 방식
	private String passbook_name;//무통장 입금 이름
	private String order_state;//주문 상태
	private int order_cancel;//취소유무
	private int invoice_no;//송장 번호
	private int waiting_point;//적립 예정 포인트
	
	//order_product테이블
	private int product_no;//상품번호
	private String order_size;//사이즈
	private int product_price;//상품 가격
	private int select_count;//상품 갯수
	
	//produc 테이블
	private String product_category;//카테고리
	private String product_name;//상품 명
	
	//검색 위한 키워드
	private String keyword;
	
	
	
	
	
	

	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOrder_password() {
		return order_password;
	}
	public void setOrder_password(String order_password) {
		this.order_password = order_password;
	}
	public String getOrder_email() {
		return order_email;
	}
	public void setOrder_email(String order_email) {
		this.order_email = order_email;
	}
	public String getReceive_name() {
		return receive_name;
	}
	public void setReceive_name(String receive_name) {
		this.receive_name = receive_name;
	}
	public String getReceive_phone() {
		return receive_phone;
	}
	public void setReceive_phone(String receive_phone) {
		this.receive_phone = receive_phone;
	}
	public String getReceive_zipcode() {
		return receive_zipcode;
	}
	public void setReceive_zipcode(String receive_zipcode) {
		this.receive_zipcode = receive_zipcode;
	}
	public String getReceive_first_address() {
		return receive_first_address;
	}
	public void setReceive_first_address(String receive_first_address) {
		this.receive_first_address = receive_first_address;
	}
	public String getReceive_last_address() {
		return receive_last_address;
	}
	public void setReceive_last_address(String receive_last_address) {
		this.receive_last_address = receive_last_address;
	}
	public String getOrder_message() {
		return order_message;
	}
	public void setOrder_message(String order_message) {
		this.order_message = order_message;
	}
	public int getOriginal_price() {
		return original_price;
	}
	public void setOriginal_price(int original_price) {
		this.original_price = original_price;
	}
	public int getUse_point() {
		return use_point;
	}
	public void setUse_point(int use_point) {
		this.use_point = use_point;
	}
	public int getUse_coupon() {
		return use_coupon;
	}
	public void setUse_coupon(int use_coupon) {
		this.use_coupon = use_coupon;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public String getOrder_select() {
		return order_select;
	}
	public void setOrder_select(String order_select) {
		this.order_select = order_select;
	}
	public String getPassbook_name() {
		return passbook_name;
	}
	public void setPassbook_name(String passbook_name) {
		this.passbook_name = passbook_name;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public int getOrder_cancel() {
		return order_cancel;
	}
	public void setOrder_cancel(int order_cancel) {
		this.order_cancel = order_cancel;
	}
	public int getInvoice_no() {
		return invoice_no;
	}
	public void setInvoice_no(int invoice_no) {
		this.invoice_no = invoice_no;
	}
	public int getWaiting_point() {
		return waiting_point;
	}
	public void setWaiting_point(int waiting_point) {
		this.waiting_point = waiting_point;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public String getOrder_size() {
		return order_size;
	}
	public void setOrder_size(String order_size) {
		this.order_size = order_size;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public int getSelect_count() {
		return select_count;
	}
	public void setSelect_count(int select_count) {
		this.select_count = select_count;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	@Override
	public String toString() {
		return "OrderManagementVO [order_no=" + order_no + ", order_date=" + order_date + ", user_id=" + user_id
				+ ", order_password=" + order_password + ", order_email=" + order_email + ", receive_name="
				+ receive_name + ", receive_phone=" + receive_phone + ", receive_zipcode=" + receive_zipcode
				+ ", receive_first_address=" + receive_first_address + ", receive_last_address=" + receive_last_address
				+ ", order_message=" + order_message + ", original_price=" + original_price + ", use_point=" + use_point
				+ ", use_coupon=" + use_coupon + ", order_price=" + order_price + ", order_select=" + order_select
				+ ", passbook_name=" + passbook_name + ", order_state=" + order_state + ", order_cancel=" + order_cancel
				+ ", invoice_no=" + invoice_no + ", waiting_point=" + waiting_point + ", product_no=" + product_no
				+ ", order_size=" + order_size + ", product_price=" + product_price + ", select_count=" + select_count
				+ ", product_category=" + product_category + ", product_name=" + product_name + ", keyword=" + keyword
				+ "]";
	}
	
	
	
	
	
	
	
	


}//end class
