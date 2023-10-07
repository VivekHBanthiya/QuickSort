import java.util.Scanner;

public class Main {
    public static void display(int[] arr)
    {
        //to display array

        for(int i =0; i< arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void swap(int[] arr, int i, int j)
    {
//        Swapping
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int partition(int[] arr, int low, int high)
    {
        //Here we are creating logic to create partition
        int pivot = arr[high];
        int swapIndex = (low-1);

        for(int j=low; j<high; j++)
        {
            if(arr[j] < pivot)
            {
                swapIndex++;
                swap(arr, swapIndex, j);
            }
        }
        swap(arr, swapIndex+1, high);
        return (swapIndex+1);
    }
    public static void quicksort(int[] arr, int low, int high)
    {
        //main function to perform quick sort
        if(low<high)
        {
//            Index has partition value
            int Index = partition(arr, low, high); //1st partition
            quicksort(arr, low, Index-1); //left partition
            quicksort(arr, Index+1, high); //right partition
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        for(int i=0; i<array.length; i++)
        {
            System.out.print("Enter " + i + " element in an array: ");
            array[i] = scanner.nextInt();
        }
        System.out.println("-----------------------------------------------------------");
        System.out.print("Before sorting: ");
        display(array);
        System.out.println("-----------------------------------------------------------");
        quicksort(array, 0, array.length-1);
        System.out.print("After sorting: ");
        display(array);
        System.out.print("-----------------------------------------------------------");

    }
}