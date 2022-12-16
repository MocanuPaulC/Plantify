package be.kdg.integration.plantifybackend.Util;

import java.util.List;

public class MovingAverage {
    public static double calculate(List<Integer> values, int period) {
        if (values.size() < period) {
            return Double.NaN;
        }
        double sum = 0;
        for (int i = values.size() - period; i < values.size(); i++) {
            sum += values.get(i);
        }
        return sum / period;
    }
}