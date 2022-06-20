package homework9.exceptionss;

import java.util.Random;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) {

        /** Я в этом задании полностью запутался. В создании исключений проблем нет.
         А в понимании задания есть. Я до сих пор не понимаю суть данного задания..
         */


        for (int i = 0; i < 10; i++)
        {
            System.out.printf("\n***** Итерация %d *****\n\n", i + 1);
            generateArray();
        }

    }

    /**
     * Метод генерации двумерного массива строк
     * @return
     */
    public static String[][] generateArray(){
        int add = random.nextInt(2);
        String[][] arr = new String[3 + add][4 + add];

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (random.nextInt(11) < 2)
                    arr[i][j] = "abc";
                else
                    arr[i][j] =  Integer.toString(random.nextInt(100));
                System.out.printf("%s ", arr[i][j]);
            }
            System.out.println("\n");
        }
        return arr;
    }

    /**
     * Метод обработки массива
     * @param arr - двумерный массив строк
     * @return - сумма всех элементов массива
     * @throws MyArraySizeException - некорректный размер массива
     */
    public static int processArrayInternal(String[][] arr) throws MyArraySizeException {

        if (arr.length > 4 || arr[0].length > 4)
            throw new MyArraySizeException("Некорректный размер массива.", arr.length, arr[0].length);

        int counter = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                try
                {
                    counter += MyArray.parseElement(arr[i][j], i, j);
                }
                catch ( MyArrayDataException e){
                    System.out.println(e.getMessage());

                }

            }
        }
        return  counter;
    }

}