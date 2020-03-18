
class Number {
    private int number;

    Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

public class Main {
    public static void main(String[] args) {
        int number = 10;
        System.out.println(number);
        Number numb = new Number(20);
        System.out.println(numb.getNumber());
        test(numb, number);
        System.out.println(numb.getNumber());
    }

    public static void test(Number numb, int number) {
        System.out.println(number);
        number = 12;
        System.out.println(number);
        System.out.println(numb.getNumber());
        numb.setNumber(44);
        numb = new Number(33);
        System.out.println(numb.getNumber());
    }
}
