package logic;

public class Surface {

    private double KD;
    private double KS;
    private double N;

    public Surface(double KD, double KS, double N) {
        this.KD = KD;
        this.KS = KS;
        this.N = N;
    }

    public double getKD() {
        return KD;
    }

    public void setKD(double KD) {
        this.KD = KD;
    }

    public double getKS() {
        return KS;
    }

    public void setKS(double KS) {
        this.KS = KS;
    }

    public double getN() {
        return N;
    }

    public void setN(double N) {
        this.N = N;
    }

    @Override
    public String toString() {
        return "Surface [KD=" + KD + " KS=" + KS + " N=" + N + "]";
    }

}
