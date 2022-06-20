package homework9.exceptionss;

public class MyArrayException extends Exception {
    private final int x;
    private final int y;

    public MyArrayException(String message, int x, int y) {
        super(message);
        this.x = x;
        this.y = y;
    }

    int getX(){
        return x;
    }

    int getY(){
        return y;
    }

}
class MyArraySizeException extends  MyArrayException{
    public MyArraySizeException(String message, int x, int y) {
        super(message, x, y);
    }

}
class MyArrayDataException  extends  MyArrayException{

    public MyArrayDataException(String message, int x, int y) {
        super(message, x, y);
    }

}
