import java.util.*;

public class MergeSort {
static long mergeSort(int[] array){
return mergeSort(array, 0, array.length - 1, new int[array.length]);
}

private static long mergeSort(int[] array, int leftStart, int rightEnd, int[] temp){
if(leftStart == rightEnd) return 0;
int mid = (leftStart + rightEnd) / 2;
long a = mergeSort(array, leftStart, mid, temp);
long b = mergeSort(array, mid + 1, rightEnd, temp);
long c = merge(array, leftStart, mid, mid + 1, rightEnd, temp);
return a + b + c;
}

private static long merge(int[] array, int leftStart, int leftEnd, int rightStart, int rightEnd, int[] temp) {
int start = leftStart;
int tempStart = leftStart;  
long count = 0;
while(leftStart <= leftEnd && rightStart <= rightEnd){
    if(array[leftStart] <= array[rightStart]) {
    temp[tempStart] = array[leftStart];
    leftStart++;
    } else {
    temp[tempStart] = array[rightStart];
    rightStart++;
    count += (leftEnd - leftStart + 1);
    }
    tempStart++;
}
System.arraycopy(array, leftStart, temp, tempStart, leftEnd - leftStart + 1);
System.arraycopy(array, rightStart, temp, tempStart, rightEnd - rightStart + 1);
System.arraycopy(temp, start, array, start, rightEnd - start + 1);
return count;
}

public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int d = in.nextInt();

    while(d-- > 0) {
        int n = in.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
        array[i] = in.nextInt();
        }
        System.out.println(mergeSort(array));
    }
    in.close();
}
}
