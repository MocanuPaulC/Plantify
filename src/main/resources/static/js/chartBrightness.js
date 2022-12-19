/*<![CDATA[*/
let brightnessArchive = [];
let brightnessForecast = [];

function getDataListBrightness(dataPassedThrough){
    brightnessArchive.push(['Timestamp','Lower bound (Minimal optimum)','brightness (in %)','Upper bound (maximal optimum)','Forecasted brightness in LUX'])
    for (let i = 0; i < dataPassedThrough.length; i++) {
        console.log(dataPassedThrough.at(i).lightavg);
        let timestamp = dataPassedThrough.at(i).refreshtime;
        timestamp = timestamp.toLocaleString().substring(0,10);
        brightnessArchive.push([timestamp,60,dataPassedThrough.at(i).lightavg,90,null]);
    }
}


function getForecastingDataBrightness(forecastedData){
    console.log(forecastedData)
    console.log("this is in charts.js")
    for (let i = 0; i < forecastedData.length; i++) {
        console.log(forecastedData.at(i));
        if (i === 0){
            brightnessArchive.push(["2022-12-14",60,forecastedData.at(0),90,forecastedData.at(i)]);
        }else {
            brightnessArchive.push(["2022-12-14",60,null,90,forecastedData.at(i)]);
        }
    }
}

console.log("//////////////////////////")
console.log(brightnessArchive);
console.log("//////////////////////////")
console.log(brightnessForecast);
console.log("//////////////////////////")

// Load the Visualization API and the corechart package.
google.charts.load('current', {'packages': ['corechart']});
// Set a callback to run when the Google Visualization API is loaded.
google.charts.setOnLoadCallback(drawChart);/*
google.charts.load('current', {'packages': ['corechart']});
google.charts.setOnLoadCallback(drawForecastingOfSoilMoisture);*/

// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.
function drawChart() {
    let data = google.visualization.arrayToDataTable(brightnessArchive);

    //set chart options
    var options = {
        title: 'Average soil moisture level per day',
        curveType: 'function',
        legend: {position: 'bottom'}
    };

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.LineChart(document.getElementById('pills-profile'));
    chart.draw(data, options);
}
