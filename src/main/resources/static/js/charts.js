
/*<![CDATA[*/
let archiveDaos = [];
let moistureArchive = [];

function getDataList(dataPassedThrough){
    moistureArchive.push(['Timestamp','Lower bound (Minimal optimum','Moisture (in %)','Upper bound (maximal optimum)'])
    for (let i = 0; i < dataPassedThrough.length; i++) {
        console.log(dataPassedThrough.at(i).moistureavg);
        let timestamp = dataPassedThrough.at(i).refreshtime;
        timestamp = timestamp.toLocaleString().substring(0,10);
        moistureArchive.push([timestamp,60,dataPassedThrough.at(i).moistureavg,90])
    }

}
console.log("//////////////////////////")
console.log(archiveDaos);
console.log("//////////////////////////")

// Load the Visualization API and the corechart package.
google.charts.load('current', {'packages': ['corechart']});
// Set a callback to run when the Google Visualization API is loaded.
google.charts.setOnLoadCallback(drawChart);

// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.
function drawChart() {
    data = google.visualization.arrayToDataTable(moistureArchive);

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