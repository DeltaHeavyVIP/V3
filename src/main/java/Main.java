import data.Data;
import entry.Entry;
import methods.*;

public class Main {
    public static void main(String[] args) {

        Data data = new Entry().read();
        switch (data.getMet()) {
            case 1:
                LeftRectangleMethod leftRectangleMethod = new LeftRectangleMethod(data);
                leftRectangleMethod.count();
                break;
            case 2:
                RightRectangleMethod rightRectangleMethod = new RightRectangleMethod(data);
                rightRectangleMethod.count();
                break;
            case 3:
                MiddleRectangleMethod middleRectangleMethod = new MiddleRectangleMethod(data);
                middleRectangleMethod.count();
                break;
            case 4:
                TrapezoidMethod trapezoidMethod = new TrapezoidMethod(data);
                trapezoidMethod.count();
                break;
            case 5:
                SimpsonMethod simpsonMethod = new SimpsonMethod(data);
                simpsonMethod.count();
                break;
            default:
                System.out.println("Я предложил тебе весь свой функционал, но ты выбрал какую-то фигню... \nИ вообще я мог бы найти лучшего пользователя... \nПрощай...");
        }
    }
}
