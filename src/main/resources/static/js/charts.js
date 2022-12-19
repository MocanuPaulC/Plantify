
/*<![CDATA[*/
let moistureArchive = [];
let moistureForecast = [];
/*function getDataList(dataPassedThrough){
    moistureArchive.push(['Timestamp','Lower bound (Minimal optimum','Moisture (in %)','Upper bound (maximal optimum)'])
    for (let i = 0; i < dataPassedThrough.length; i++) {
        console.log(dataPassedThrough.at(i).moistureavg);
        let timestamp = dataPassedThrough.at(i).refreshtime;
        timestamp = timestamp.toLocaleString().substring(0,10);
        moistureArchive.push([timestamp,60,dataPassedThrough.at(i).moistureavg,90]);
    }
}*/
function getDataList(dataPassedThrough){
    moistureArchive.push(['Timestamp','Lower bound (Minimal optimum','Moisture (in %)','Upper bound (maximal optimum)','Forecasted soil moisture in %'])
    for (let i = 0; i < dataPassedThrough.length; i++) {
        console.log(dataPassedThrough.at(i).moistureavg);
        let timestamp = dataPassedThrough.at(i).refreshtime;
        timestamp = timestamp.toLocaleString().substring(0,10);
        moistureArchive.push([timestamp,60,dataPassedThrough.at(i).moistureavg,90,null]);
    }
}


function getForecastingData(forecastedData){
    console.log(forecastedData)
    console.log("this is in charts.js")
    for (let i = 0; i < forecastedData.length; i++) {
        console.log(forecastedData.at(i));
        if (i === 0){
            moistureArchive.push(["2022-12-14",60,forecastedData.at(0),90,forecastedData.at(i)]);
        }else {
             moistureArchive.push(["2022-12-14",60,null,90,forecastedData.at(i)]);
        }
    }
}
/*
function getForecastingData(forecastedData){
    console.log(forecastedData)
    console.log("this is in charts.js")
    moistureForecast.push(['Timestamp','Lower bound (Minimal optimum','Moisture (in %)','Upper bound (maximal optimum)'])
    for (let i = 0; i < forecastedData.length; i++) {
        console.log(forecastedData.at(i));
        moistureForecast.push(["2022-12-14",60,forecastedData.at(i),90]);
    }
}*/
console.log("//////////////////////////")
console.log(moistureArchive);
console.log("//////////////////////////")
console.log(moistureForecast);
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
    let data = google.visualization.arrayToDataTable(moistureArchive);

    //set chart options
    var options = {
        title: 'Average soil moisture level per day',
        curveType: 'function',
        legend: {position: 'bottom'}
    };

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.LineChart(document.getElementById('pills-home'));
    chart.draw(data, options);
}

function drawForecastingOfSoilMoisture(){

    let data = google.visualization.arrayToDataTable(moistureForecast);

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
