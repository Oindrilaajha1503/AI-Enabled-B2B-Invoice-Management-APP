package com.highradius.model;

public class invoicee {
	
private String slno;
private String customer_order_id;
private String sales_org;
private  String distribution_channel;
private  String division;
private  String released_credit_value;
private  String purchase_order_type;
private  String company_code;
private String order_creation_date;
private String order_creation_time;
private  String credit_control_area;
private  String sold_to_party;
private String order_amount;
private  String requested_delivery_date;
private String order_currency;
private  String credit_status;
private  String customer_number;
private  String amount_in_usd;
private  String unique_cust_id;
public invoicee() {
	super();

}
public invoicee(String slno ,String customer_order_id2, String sales_org2, String distribution_channel, String division,
		String rELEASED_CREDIT_VALUE2, String purchase_order_type, String cOMPANY_CODE2,String order_creation_date,String order_creation_time,
		 String credit_control_area, String sOLD_TO_PARTY2, String oRDER_AMOUNT2,String requested_delivery_date,
	 String order_currency, String credit_status, String cUSTOMER_NUMBER2,
		String aMOUNT_IN_USD2, String uNIQUE_CUST_ID2) {
	super();
	this.slno = slno;
	this.customer_order_id = customer_order_id2;
	this.sales_org = sales_org2;
	this.distribution_channel = distribution_channel;
	this.division = division;
	this.released_credit_value = rELEASED_CREDIT_VALUE2;
	this.purchase_order_type = purchase_order_type;
	this.company_code = cOMPANY_CODE2;
	this.order_creation_date = order_creation_date;
	this.order_creation_time = order_creation_time;
	this.credit_control_area = credit_control_area;
	this.sold_to_party = sOLD_TO_PARTY2;
	this.order_amount = oRDER_AMOUNT2;
	this.requested_delivery_date = requested_delivery_date;
	this.order_currency = order_currency;
	this.credit_status = credit_status;
	this.customer_number = cUSTOMER_NUMBER2;
	this.amount_in_usd = aMOUNT_IN_USD2;
	this.unique_cust_id = uNIQUE_CUST_ID2;
}

public String getslno() {
	return slno;
}
public void setslno(String slno) {
	this.slno = slno;
}

public String getCustomer_order_id() {
	return customer_order_id;
}
public void setCustomer_order_id(String customer_order_id) {
	this.customer_order_id = customer_order_id;
}
public String getSales_org() {
	return sales_org;
}
public void setSales_org(String sales_org) {
	this.sales_org = sales_org;
}
public String getDistribution_channel() {
	return distribution_channel;
}
public void setDistribution_channel(String distribution_channel) {
	this.distribution_channel = distribution_channel;
}
public String getDivision() {
	return division;
}
public void setDivision(String division) {
	this.division = division;
}
public String getReleased_credit_value() {
	return released_credit_value;
}
public void setReleased_credit_value(String released_credit_value) {
	this.released_credit_value = released_credit_value;
}
public String getPurchase_order_type() {
	return purchase_order_type;
}
public void setPurchase_order_type(String purchase_order_type) {
	this.purchase_order_type = purchase_order_type;
}
public  String getCompany_code() {
	return company_code;
}
public void setCompany_code(String company_code) {
	this.company_code = company_code;
}
public String getOrder_creation_date() {
	return order_creation_date;
}
public void setOrder_creation_date(String order_creation_date) {
	this.order_creation_date = order_creation_date;
}
public String getOrder_creation_time() {
	return order_creation_time;
}
public void setOrder_creation_time(String order_creation_time) {
	this.order_creation_time = order_creation_time;
}
public  String getCredit_control_area() {
	return credit_control_area;
}
public void setCredit_control_area(String credit_control_area) {
	this.credit_control_area = credit_control_area;
}
public  String getSold_to_party() {
	return sold_to_party;
}
public void setSold_to_party(String sold_to_party) {
	this.sold_to_party = sold_to_party;
}
public  String getOrder_amount() {
	return order_amount;
}
public void setOrder_amount(String order_amount) {
	this.order_amount = order_amount;
}
public String getRequested_delivery_date() {
	return requested_delivery_date;
}
public void setRequested_delivery_date(String requested_delivery_date) {
	this.requested_delivery_date = requested_delivery_date;
}
public  String getOrder_currency() {
	return order_currency;
}
public void setOrder_currency(String order_currency) {
	this.order_currency = order_currency;
}
public String getCredit_status() {
	return credit_status;
}
public void setCredit_status(String credit_status) {
	this.credit_status = credit_status;
}
public  String getCustomer_number() {
	return customer_number;
}
public void setCustomer_number(String customer_number) {
	this.customer_number = customer_number;
}
public  String getAmount_in_usd() {
	return amount_in_usd;
}
public void setAmount_in_usd(String amount_in_usd) {
	this.amount_in_usd = amount_in_usd;
}
public  String getUnique_cust_id() {
	return unique_cust_id;
}
public void setUnique_cust_id(String unique_cust_id) {
	this.unique_cust_id = unique_cust_id;
}
@Override
public String toString() {
	return "invoicee [slno=" + slno + ", customer_order_id=" + customer_order_id + ", sales_org=" + sales_org
			+ ", distribution_channel=" + distribution_channel + ", division=" + division + ", released_credit_value="
			+ released_credit_value + ", purchase_order_type=" + purchase_order_type + ", company_code=" + company_code + ", order_creation_date=" + order_creation_date + ", order_creation_time=" + order_creation_time
			 
			+ ", credit_control_area=" + credit_control_area + ", sold_to_party=" + sold_to_party + ", order_amount="
			+ order_amount    + ", order_currency="
			+ order_currency + ", credit_status=" + credit_status + ", customer_number=" + customer_number
			+ ", amount_in_usd=" + amount_in_usd + ", unique_cust_id=" + unique_cust_id + "]";
}


}
