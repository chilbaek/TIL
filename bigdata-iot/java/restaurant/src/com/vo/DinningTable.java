package com.vo;

public class DinningTable {
	private int tableno;
	private String menus;
	public DinningTable() {
	}
	public DinningTable(int tableno, String menus) {
		this.tableno = tableno;
		this.menus = menus;
	}
	public int getTableno() {
		return tableno;
	}
	public void setTableno(int tableno) {
		this.tableno = tableno;
	}
	public String getMenus() {
		return menus;
	}
	public void setMenus(String menus) {
		this.menus = menus;
	}
	@Override
	public String toString() {
		return "DinningTable [tableno=" + tableno + ", menus=" + menus + "]";
	}
	
}
