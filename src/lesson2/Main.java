package lesson2;

public class Main {

    private static void main(String[] args) {

        String[][] arr = new String[][]{{"1", "2", "-1", "0"}, {"5", "-4", "2", "-3"}, {"1", "2", "3", "4"}, {"1", "0", "1", "12"}};
        try {
            try {
                int result = method(arr);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Неверный размер массива");
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Неверное значение в массиве");
            System.out.println("Ошибка в  " + e.r + "й строке и " + e.c + "м столбике");
        }

    }


    private static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return count;
    }

}
