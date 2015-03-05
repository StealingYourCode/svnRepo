package dto;

import java.sql.Date;

public class RequestDTO implements IStorable {
	
	public enum BuyOrSell{
		BUY, SELL;
	}
	
	public enum Status{
		
	}
	
	int request_id;
	int parent_request_id;
	int shares_filled;
	int shareholder_id;
	Date request_date;
	BuyOrSell buy_or_sell;
	Status status;
	int stock_id;
	int shares;
	int minimum_shares;
	String time_in_force;
	double limit_price;
	double stop_price;

	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public int getParent_request_id() {
		return parent_request_id;
	}
	public void setParent_request_id(int parent_request_id) {
		this.parent_request_id = parent_request_id;
	}
	public int getShares_filled() {
		return shares_filled;
	}
	public void setShares_filled(int shares_filled) {
		this.shares_filled = shares_filled;
	}
	public int getShareholder_id() {
		return shareholder_id;
	}
	public void setShareholder_id(int shareholder_id) {
		this.shareholder_id = shareholder_id;
	}
	public Date getRequest_date() {
		return request_date;
	}
	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}
	public BuyOrSell getBuy_or_sell() {
		return buy_or_sell;
	}
	public void setBuy_or_sell(BuyOrSell buy_or_sell) {
		this.buy_or_sell = buy_or_sell;
	}
	
	public int getStock_id() {
		return stock_id;
	}
	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}
	public int getShares() {
		return shares;
	}
	public void setShares(int shares) {
		this.shares = shares;
	}
	public int getMinimum_shares() {
		return minimum_shares;
	}
	public void setMinimum_shares(int minimum_shares) {
		this.minimum_shares = minimum_shares;
	}
	public String getTime_in_force() {
		return time_in_force;
	}
	public void setTime_in_force(String time_in_force) {
		this.time_in_force = time_in_force;
	}
	public double getLimit_price() {
		return limit_price;
	}
	public void setLimit_price(double limit_price) {
		this.limit_price = limit_price;
	}
	public double getStop_price() {
		return stop_price;
	}
	public void setStop_price(double stop_price) {
		this.stop_price = stop_price;
	}
	
}
