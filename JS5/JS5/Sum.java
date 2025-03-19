public class Sum {
    double profits[];

    Sum(int el) {
        profits = new double[el];
    }

    double totalBF(){
        double total=0;
        for(int i=0; i<profits.length; i++) {
            total = total+profits[i];
        }
        return total;
    }

    double totalDC(double arr[], int l, int r) {
        if(l==r){
            return arr[l];
        }

        int mid = (l+r)/2;
        double lsum = totalDC(arr, l, mid);
        double rsum = totalDC(arr, mid+1, r);
        return lsum+rsum;
    }
}