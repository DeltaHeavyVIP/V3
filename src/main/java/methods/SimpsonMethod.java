package methods;

import data.Data;
import record.Record;

public class SimpsonMethod extends Method {

    public SimpsonMethod(Data data) {
        super(data);
    }

    @Override
    public double getAnswer(int n) {
        double delta_x = (data.getB() - data.getA()) / n;
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                sum += 4 * function(data.getA() + delta_x * i, data.getE(), data.getEquation());
            } else if (i == 0 || i == n) {
                sum += function(data.getA() + delta_x * i, data.getE(), data.getEquation());
            } else {
                sum += 2 * function(data.getA() + delta_x * i, data.getE(), data.getEquation());
            }
        }
        return delta_x * sum / 3;
    }
}
