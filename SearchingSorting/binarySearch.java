public class binarySearch{
    public static void main(String[] args) {
        solve();
    }

    public static void solve(){
        int[] arr = {10,20,30,40,50,60,70,80,90};
        System.out.println(binary1(arr, 0, arr.length-1, 50));
    }

    public static boolean binary1(int arr[], int l,int r, int x)
    {
        if(l > r){
            return false ;
        }

        int mid = l + (r - l) / 2;
        boolean isPresent = false;

        if (arr[mid] == x)
            isPresent = true;

        else if (arr[mid] > x)
            isPresent =  binary1(arr, l, mid - 1, x);

        else
            isPresent = binary1(arr, mid + 1, r, x);
        
 
        return isPresent;
    }

    public static int binary2(int arr[], int l,int r, int x)
    {
        if(l > r){
            return -1 ;
        }

        int mid = l + (r - l) / 2;

        if (arr[mid] == x)
            return mid;

        else if (arr[mid] > x)
            return binary2(arr, l, mid - 1, x);

        else
            return binary2(arr, mid + 1, r, x);
    }
    
}