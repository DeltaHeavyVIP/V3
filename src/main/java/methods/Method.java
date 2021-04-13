package methods;

import data.Data;

public abstract class Method {
    protected Data data;

    public Method(Data data) {
        this.data = data;
    }

    public abstract void count();

    public abstract double getAnswer(int n);

    public double function(double x, double e, int equation) {
        double ret = 0;
        switch (equation) {
            case 1:
                ret = x * x * x + 2 * x * x - 3 * x - 12;
                break;
            case 2:
                ret =(Math.sin(x) / x);
                break;
            case 3:
                ret = 1 / x;
                break;
            case 4:
                ret = x * x;
                break;
            default:
                ret = 0;
        }
        if(Double.isNaN(ret) || Double.isInfinite(ret)){
            ret = (function(x - e, e, equation) + function(x + e, e, equation)) / 2;
        }
        return ret;
    }
}
