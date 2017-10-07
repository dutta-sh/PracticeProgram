import java.util.Date;

class Main
{
    static boolean hasArrayTwoCandidates(int A[], int sum)
    {
        int l, r;

        l = 0;
        r = A.length -1;
        while (l < r)
        {
            if(A[l] + A[r] == sum)
                return true;
            else if(A[l] + A[r] < sum)
                l++;
            else // A[i] + A[j] > sum
                r--;
        }
        return false;
    }

    //main function
    public static void main(String args[])
    {
        System.out.println(new Date().getTime());

        int A[] = {10, 11, 19, 20};
        int n = 30;

        if( hasArrayTwoCandidates(A, n))
            System.out.println("Array has two "+
                    "elements with sum 16");
        else
            System.out.println("Array doesn't have "+
                    "two elements with sum 16 ");
    }
}