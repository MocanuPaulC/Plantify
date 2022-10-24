package be.kdg.integration.plantifybackend.domain;

import com.fazecast.jSerialComm.SerialPort;

import java.io.IOException;

public class SerialArduinoConnection {
//    public static final int ARDUINO_PORT = 0;

    private SerialPort arduinoPort;

    public SerialArduinoConnection(int ARDUINO_PORT) {
        arduinoPort = SerialPort.getCommPorts()[ARDUINO_PORT];
        boolean result = arduinoPort.openPort();
        System.out.println(result ? "port opened!" : "port NOT opened!");

    }

    public byte[] receiveBytes() {

        byte[] newData = new byte[arduinoPort.bytesAvailable()];
        arduinoPort.readBytes(newData, newData.length);
        return newData;
    }

    public String showData() {

        try {
            arduinoPort.getOutputStream().write(Integer.valueOf(1).byteValue());
            arduinoPort.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            Thread.sleep(100);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        StringBuilder text = new StringBuilder();
        for (byte oneByte : this.receiveBytes()) {
            if((char)oneByte!='['&&(char)oneByte!=']') {
                text.append((char) oneByte);
            }
        }
        return text.toString();
    }
}
