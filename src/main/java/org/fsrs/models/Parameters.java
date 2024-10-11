package org.fsrs.models;

public class Parameters {
    private double requestRetention;
    private int maximumInterval;
    private double[] w;

    public Parameters() {
        this(null, null, null);
    }

    public Parameters(Double[] w, Double requestRetention, Integer maximumInterval) {
        this.w = w != null ? toDoubleArray(w) : new double[]{
                0.4072, 1.1829, 3.1262, 15.4722, 7.2102, 0.5316, 1.0651, 0.0234, 1.616,
                0.1544, 1.0824, 1.9813, 0.0953, 0.2975, 2.2042, 0.2407, 2.9466, 0.5034, 0.6567
        };
        this.requestRetention = requestRetention != null ? requestRetention : 0.9;
        this.maximumInterval = maximumInterval != null ? maximumInterval : 36500;
    }

    private double[] toDoubleArray(Double[] array) {
        double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public double getRequestRetention() {
        return requestRetention;
    }

    public void setRequestRetention(double requestRetention) {
        this.requestRetention = requestRetention;
    }

    public int getMaximumInterval() {
        return maximumInterval;
    }

    public void setMaximumInterval(int maximumInterval) {
        this.maximumInterval = maximumInterval;
    }

    public double[] getW() {
        return w;
    }

    public void setW(double[] w) {
        this.w = w;
    }
}
