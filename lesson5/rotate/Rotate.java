package lesson5.rotate;
public class Rotate {

    int c;//используем переменную класса для инициализации массива
    int d;//зададим размер стороны матрицы

    public Rotate (int c, int d){

        this.c = c;
        this.d = d;

    }

    //смотрим на массив
    public void watchIt(int[][] arr){

        for (int i = 0; i < d; i++){
            for (int j = 0; j < d; j++){
                System.out.print(arr[i][j]+"\t");//после каждого значения табуляция
            }
            System.out.println();//после каждой строки перенос на новую строку
        }
    }

    //заполняем массив
    public void fillArray (int[][] arr){

        for (int i = 0; i < d; i++){
            for (int j =0; j < d; j++){
                arr[i][j] = ++c;//каждый следующий элемент на 1 больше предыдущего
            }
        }

    }

    //начинаем крутить
    public void toRotate (int[][] arr){

        d = arr.length; // Размер стороны матрицы
        System.out.println("это ленгс "+d);

        for (int i = 0; i < d/2; i++) { //цикл индексирует точки входа в новый радиус
                                        // и заканчивает работу дойдя до центра
            System.out.println("\t"+"начинам крутить "+ (i+1) +" радиус");
            for (int j = i; j < d-i-1; j++) {   //спускаемся по диагонали за счет приравнивания j и i, это первый элемент
                                                //количество итераций на 1 меньше количества элементов стороны радиуса
                                                //d-i-1 дает число большее чем количество итераций,
                                                // но первый элемент в цикле уже на i отступает от левого края
                                                //остается ограничить цикл на i справа
                int tmp = 0;//используем tmp чтобы менять ячейки местами
                tmp = arr[i][j];//1
                System.out.print("1 действ. перемещаем "+arr[i][j]);
                System.out.println(" из ячейки "+"arr["+i+"]["+j+"]");

                arr[i][j] = arr[d-j-1][i];//2
                System.out.print("2 действ. перемещаем "+arr[d-j-1][i]);
                System.out.println(" из ячейки "+"arr["+(d-j-1)+"]["+i+"]");

                arr[d-j-1][i] = arr[d-i-1][d-j-1];//3
                System.out.print("3 действ. перемещаем "+arr[d-i-1][d-j-1]);
                System.out.println(" из ячейки "+"arr["+(d-i-1)+"]["+(d-j-1)+"]");

                arr[d-i-1][d-j-1] = arr[j][d-i-1];//4
                System.out.print("4 действ. перемещаем "+arr[j][d-i-1]);
                System.out.println(" из ячейки "+"arr["+j+"]["+(d-i-1)+"]");

                arr[j][d-i-1] = tmp;//5
                System.out.print("5 действ. перемещаем "+tmp);
                System.out.println(" из вспомогательной ячейки "+"\n");
            }
        }

    }
}