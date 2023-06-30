import React, { useState, useEffect } from "react";
import "../styles/body.css";
import Datagrid from "./Datagrid";
import AddData from "./AddData";
import Analytics from "./Analytics";


export default function HomePage() {
  const [activebtn, setActiveBtn] = useState(1);
  const [advancedbtn, setAdvancedBtn] = useState(true);
  const [searchValue, setSearchValue] = useState("");
  const [filteredRows, setFilteredRows] = useState([]);
  const [rows, setRows] = useState([]);

  const activebutton = (index) => {
    setActiveBtn(index);
  };

  const inputChange = (event) => {
    const value = event.target.value;
    setSearchValue(value);
    setAdvancedBtn(value.length === 0);
    setActiveBtn(3);
  };

  const clear = () => {
    setSearchValue("");
    setAdvancedBtn(true);
    setActiveBtn(1);
    setFilteredRows([]); // Clear the filtered rows
  };

  useEffect(() => {
    if (searchValue.length > 0) {
      const filtered = rows.filter((row) =>
  (row.customer_order_id).toLowerCase().includes(searchValue.toLowerCase())
);
      setFilteredRows(filtered);
    } else {
      setFilteredRows([]);
    }
  }, [searchValue, rows]);

  useEffect(() => {
    fetchInvoiceeData(1); // Pass the default page number
  }, []);

  const fetchInvoiceeData = async (pageNumber) => {
    try {
      const response = await fetch(
        `http://localhost:8080/oindrila_h2h/read`,
        { method: "GET" }
      );
      if (response.ok) {
        const data = await response.json();

        // Add a unique id for each row
        const rowsWithId = data.map((row, index) => ({
          ...row,
          id: index + 1,
        }));

        setRows(rowsWithId);
      } else {
        console.error("Failed to fetch data from the servlet.");
      }
    } catch (error) {
      console.error("Error while fetching data:", error);
    }
  };

  return (
    <div className="body-container">
      <div className="body-header">
        <div className="firsthalf">
          <button
            className={activebtn === 1 ? "btn-active" : "btn-inactive"}
            onClick={() => activebutton(1)}
          >
            HOME PAGE
          </button>
          <button
            className={activebtn === 2 ? "btn-active" : "btn-inactive"}
            onClick={() => activebutton(2)}
          >
            ADD DATA
          </button>
          <button
            className={activebtn === 3 ? "btn-active" : "btn-search"}
            onClick={() => activebutton(3)}
          >
            SEARCH RESULT
          </button>
          <button
            className={activebtn === 4 ? "btn-active" : "btn-inactive"}
            onClick={() => activebutton(4)}
          >
            ANALYTICS VIEW
          </button>
        </div>

        <div className="secondhalf">
          <input
            type="text"
            placeholder="Search Customer Order ID"
            onChange={inputChange}
            className="searchbox"
            value={searchValue}
          />
          <button
            className={advancedbtn ? "clear-btn-inactive" : "clear-btn"}
            onClick={clear}
          >
            Clear
          </button>
          <button
            className={advancedbtn ? "advanced-btn" : "advanced-btn-inactive"}
          >
            Advanced Search
          </button>
        </div>
      </div>
      <div className="main-content">
        {activebtn === 1 && <Datagrid rows={rows} />}
        {activebtn === 2 && <AddData />}
        {activebtn === 3 && <Datagrid rows={filteredRows} />}
        {activebtn === 4 && <Analytics />}
      </div>
    </div>
  );
}