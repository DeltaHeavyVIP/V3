package methods;

import data.Data;
import record.Record;

public class RightRectangleMethod extends Method {

    public RightRectangleMethod(Data data) {
        super(data);
    }

    @Override
    public double getAnswer(int n) {
        double delta_x = (data.getB() - data.getA()) / n;
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += function(data.getA() + delta_x * i, data.getE(), data.getEquation());
        }
        return delta_x * sum;
    }
}
