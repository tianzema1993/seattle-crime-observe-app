import React from 'react';
import Chart from "react-apexcharts";

class MyChart extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      series : props.series,
      options: {
        chart: {
          height: 350,
          type: 'line',
          dropShadow: {
            enabled: true,
            color: '#000',
            top: 18,
            left: 7,
            blur: 10,
            opacity: 0.2
          },
          toolbar: {
            show: false
          }
        },
        colors: ['#fc4903', '#036bfc', '#66ff33', '#000000'],
        dataLabels: {
          enabled: true,
        },
        stroke: {
          curve: 'smooth'
        },
        title: {
          text: 'Crime Type & Date',
          align: 'left'
        },
        grid: {
          borderColor: '#e7e7e7',
          row: {
            colors: ['#ffff00', 'transparent'], // takes an array which will be repeated on columns
            opacity: 0.5
          },
        },
        markers: {
          size: 1
        },
        xaxis: {
          categories: props.categories,
          title: {
            text: 'Date'
          }
        },
        yaxis: {
          title: {
            text: 'Crime Count'
          }
        },
        legend: {
          position: 'top',
          horizontalAlign: 'right',
          floating: true,
          offsetY: -25,
          offsetX: -5
        }
      },
    }
  }

  render() {
    return (
      <div id="chart">
        <Chart options={this.state.options} series={this.state.series} type="line" height={350} />
      </div>
    );
  }
}

export default MyChart;