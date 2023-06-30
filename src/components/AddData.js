import React, { useState } from "react";
import axios from "axios";
import "../styles/addData.css";

const AddData = () => {
  const [formData, setFormData] = useState({
    customerOrderId: "",
    salesOrg: "",
    distributionChannel: "",
    customerNumber: "",
    companyCode: "",
    orderCurrency: "",
    amountInUsd: "",
    orderCreationDate: "",
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const formParams = new URLSearchParams();

    for (let key in formData) {
      formParams.append(key, formData[key]);
    }

    axios
      .post("http://localhost:8080/oindrila_h2h/add", formParams)
      .then((response) => {
        // Handle success response

        alert("Data added successfully");
      })
      .catch((error) => {
        // Handle error
        alert("Error occurred while adding data", error);
      });
  };

  const clearForm = () => {
    setFormData({
      customerOrderId: "",
      salesOrg: "",
      distributionChannel: "",
      customerNumber: "",
      companyCode: "",
      orderCurrency: "",
      amountInUsd: "",
      orderCreationDate: "",
    });
  };

  return (
    <div>
      <div className="container">
        <div className="inp1 ">
          <input
            type="number"
            className="inputbox"
            placeholder="Customer Order ID"
            name="customerOrderId"
            value={formData.customerOrderId}
            onChange={handleChange}
          />
        </div>
        <div className="inp2 ">
          <input
            type="number"
            className="inputbox"
            placeholder="Sales Org"
            name="salesOrg"
            value={formData.salesOrg}
            onChange={handleChange}
          />
        </div>
        <div className="inp3">
          <input
            type="text"
            className="inputbox"
            placeholder="Distribution Channel"
            name="distributionChannel"
            value={formData.distributionChannel}
            onChange={handleChange}
          />
        </div>
        <div className="inp4 ">
          <input
            type="number"
            className="inputbox"
            placeholder="Customer Number"
            name="customerNumber"
            value={formData.customerNumber}
            onChange={handleChange}
          />
        </div>
        <div className="inp5 ">
          <input
            type="text"
            className="inputbox"
            placeholder="Company Code"
            name="companyCode"
            value={formData.companyCode}
            onChange={handleChange}
          />
        </div>
        <div className="inp6 ">
          <input
            type="text"
            className="inputbox"
            placeholder="Order Currency"
            name="orderCurrency"
            value={formData.orderCurrency}
            onChange={handleChange}
          />
        </div>
        <div className="inp7 ">
          <input
            type="number"
            className="inputbox"
            placeholder="Amount in USD"
            name="amountInUsd"
            value={formData.amountInUsd}
            onChange={handleChange}
          />
        </div>
        <div className="inp8 ">
          <input
            type="date"
            className="inputbox"
            placeholder="Order Creation Date"
            name="orderCreationDate"
            value={formData.orderCreationDate}
            onChange={handleChange}
          />
        </div>
      </div>
      <div className="form-button">
        <div className="btn1">
          <button className="form-btn button1" onClick={handleSubmit}>
            ADD
          </button>
        </div>
        <div className="btn2">
          <button className="form-btn button2" onClick={clearForm}>
            CLEAR DATA
          </button>
        </div>
      </div>
    </div>
  );
};

export default AddData;