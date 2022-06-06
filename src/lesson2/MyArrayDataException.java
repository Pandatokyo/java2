package lesson2;

public class MyArrayDataException extends Exception {
    public int r;
    public int c;
    MyArrayDataException(int r, int c) {
        this.r = r;
        this.c = c;
    }

}
