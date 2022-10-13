package be.kdg.integration.plantifybackend.domain;

public class Arduino {
    private String series;
    private SerialArduinoConnection connection;

    public Arduino(int arduinoPort, String series) {
        this.series=series;
        this.connection = new SerialArduinoConnection(arduinoPort);
    }

    public String getData(){
        return connection.showData();
    }

    public void buffer(){
        connection.showData();
        connection.showData();
        connection.showData();
        connection.showData();
    }


}
