import data.Data;
import entry.Entry;

public class Main {
    public static void main(String[] args) {

        Data data = new Entry().read();
        switch (data.getMet()) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            default: System.out.println("Я предложил тебе весь свой функционал, но ты выбрал какую-то фигню... \nИ вообще я мог бы найти лучшего пользователя... \nПрощай...");
        }
    }
}
