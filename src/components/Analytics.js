import React, { useState, useEffect } from "react";
import Highcharts from "highcharts";
import HighchartsReact from "highcharts-react-official";
import axios from "axios";

const Analytics = () => {
  const [data, setData] = useState([]);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = () => {
    axios.get("http://localhost:8080/oindrila_h2h/read")
      .then(response => {
        setData(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  };

  const generateBarChartData = () => {
    // Prepare the data for the bar chart
    const barChartData = data.map(item => ({
      name: item.distributionChannel,
      y: item.orderAmount
    }));

    // Create the Highcharts options for the bar chart
    const options = {
      chart: {
        type: "column"
      },
      title: {
        text: "Bar Chart"
      },
      xAxis: {
        type: "category",
        title: {
          text: "Distribution Channel"
        }
      },
      yAxis: {
        title: {
          text: "Order Amount"
        }
      },
      series: [
        {
          name: "Order Amount",
          data: barChartData
        }
      ]
    };

    return options;
  };

  const generatePieChartData = () => {
    // Prepare the data for the pie chart
    const pieChartData = data.map(item => ({
      name: item.distribution_channel,
      y: item.customer_number
    }));

    // Create the Highcharts options for the pie chart
    const options = {
      chart: {
        type: "pie"
      },
      title: {
        text: "Pie Chart"
      },
      series: [
        {
          name: "Order Amount",
          data: pieChartData
        }
      ]
    };

    return options;
  };

  return (
    <div>
      <h2>Analytics View</h2>
      
      <div>
        <h3>Bar Chart</h3>
        <HighchartsReact highcharts={Highcharts} options={generateBarChartData()} />
      </div>
      
      <div>
        <h3>Pie Chart</h3>
        <HighchartsReact highcharts={Highcharts} options={generatePieChartData()} />
      </div>
    </div>
  );
};

export default Analytics;