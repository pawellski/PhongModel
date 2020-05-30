package logic;

public class Surface {

    private double KA;
    private double KD;
    private double KS;
    private double N;

    public Surface(double KA, double KD, double KS, double N) {
        this.KA = KA;
        this.KD = KD;
        this.KS = KS;
        this.N = N;
    }

    public double getKA() {
        return KA;
    }

    public double getKD() {
        return KD;
    }

    public double getKS() {
        return KS;
    }

    public double getN() {
        return N;
    }


    @Override
    public String toString() {
        return "Surface [KD=" + KD + " KS=" + KS + " N=" + N + "]";
    }

}
