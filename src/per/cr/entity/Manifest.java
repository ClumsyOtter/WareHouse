package per.cr.entity;

import java.util.Date;

public class Manifest {
	private int mid;
	private String type;
	private String id;
	private String cargo_id;
	private double num;
	private String operator;
	private Date time;
	private String store_id;

	public String getCargo_id() {
		return cargo_id;
	}

	public void setCargo_id(String cargo_id) {
		this.cargo_id = cargo_id;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getStore_id() {
		return store_id;
	}

	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getNum() {
		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}

	public int getMid() {
		return mid;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}



}
