package homework9.exceptionss;

public class MyArray extends MyArrayException{

    public MyArray(String message, int x, int y) {
        super(message, x, y);
    }

    public static int processArrayInternal(String[][] arr) throws MyArraySizeException {

        if (arr.length > 4 || arr[0].length > 4)
            throw new MyArraySizeException("Некорректный размер массива.", arr.length, arr[0].length);

        int counter = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                try
                {
                    counter += parseElement(arr[i][j], i, j);
                }
                catch (MyArrayDataException ex){
                    System.out.printf("%s данных по индексу [%d][%d]\n",ex.getMessage(), i, j);
                }
            }
        }
        return  counter;
    }

    static int parseElement(String e, int x, int y) throws MyArrayDataException {
        try {
            return Integer.parseInt(e);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return x;
    }
}
