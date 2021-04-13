package methods;

import data.Data;
import record.Record;

public class LeftRectangleMethod extends Method {

    public LeftRectangleMethod(Data data) {
        super(data);
    }

    @Override
    public double getAnswer(int n) {
        double delta_x = (data.getB() - data.getA()) / n;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += function(data.getA() + delta_x * i, data.getE(), data.getEquation());
        }
        return delta_x * sum;
    }

}
