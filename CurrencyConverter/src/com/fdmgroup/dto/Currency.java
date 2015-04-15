package com.fdmgroup.dto;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Currency
 *
 */
@Entity 

public class Currency implements Serializable {

	   
	@Id
	@GeneratedValue (strategy=GenerationType.SEQUENCE)
	private int currencyId;
	
//	@Column(name="RATE")
	private BigDecimal conversionRate;
	
//	@Column(name="NAME")
	private String currencyName;
	
	@Temporal(TemporalType.DATE)
	private Date currencyDate;
	
	private static final long serialVersionUID = 1L;

	public Currency() {
		super();
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public BigDecimal getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public Date getCurrencyDate() {
		return currencyDate;
	}

	public void setCurrencyDate(Date currencyDate) {
		this.currencyDate = currencyDate;
	}  
	
	
}
