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
        if (x == 0 && (equation == 2 || equation == 3)) {
            return (function(x - e, e, equation) + function(x + e, e, equation)) / 2;
        }
        switch (equation) {
            case 1:
                return x * x * x + 2 * x * x - 3 * x - 12;
            case 2:
                return (Math.sin(x) / x);
            case 3:
                return 1 / x;
            case 4:
                return x * x;
            default:
                return 0;
        }
    }
}
