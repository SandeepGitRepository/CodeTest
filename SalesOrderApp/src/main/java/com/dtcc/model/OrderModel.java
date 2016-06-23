package com.dtcc.model;


/**
 * 
 */
/**
 * @author sandeep
 *
 */public class OrderModel {
	
	
	private String sales_state_field;
	private Integer sales_order_id;
	
	public String getSales_state_field() {
		return sales_state_field;
	}
	public void setSales_state_field(String sales_state_field) {
		this.sales_state_field = sales_state_field;
	}
	public Integer getSales_order_id() {
		return sales_order_id;
	}
	public void setSales_order_id(Integer sales_order_id) {
		this.sales_order_id = sales_order_id;
	}
	public OrderModel(String sales_state_field, Integer sales_order_id) {
		super();
		this.sales_state_field = sales_state_field;
		this.sales_order_id = sales_order_id;
	}
	public OrderModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
