package methods;

import data.Data;
import record.Record;

public class TrapezoidMethod extends Method{

    public TrapezoidMethod(Data data) {
        super(data);
    }

    @Override
    public void count() {
        int n = 4;
        double answer = getAnswer(n * 2);
        while (Math.abs(answer - getAnswer(n)) >= data.getE()) {
            n *= 2;
            answer = getAnswer(n * 2);
        }
        Record.record(data.getOut(),answer,n);
    }

    @Override
    public double getAnswer(int n) {
        double delta_x = (data.getB() - data.getA()) / n;
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (function(data.getA() + delta_x * i, data.getE(), data.getEquation()) + function(data.getA() + delta_x * (i + 1), data.getE(),data.getEquation())) / 2;
        }
        return delta_x * sum;
    }
}
