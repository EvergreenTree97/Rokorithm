import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int i = 0;
        while ( i < N && arr[i] < 1) {
            negative.add(arr[i]);
            i++;
        }
        while (i < N) {
            positive.add(arr[i]);
            i++;
        }
        Collections.sort(positive,Collections.reverseOrder());
        int ans = 0;

        //음수
        if(negative.size() == 1){
            ans += negative.get(0);
        }else if(negative.size() == 2){
            ans += (negative.get(0) * negative.get(1));
        }else{
            if(negative.size() % 2 == 0){
                for (int j = 0; j < negative.size(); j+= 2) {
                    ans += (negative.get(j) * negative.get(j+1));
                }
            }else{
                for (int j = 0; j < negative.size()-1; j+= 2) {
                    ans += (negative.get(j) * negative.get(j+1));
                }
                ans += negative.get(negative.size()-1);
            }
        }

        //양수
        if(positive.size() == 1){
            ans += positive.get(0);
        }else if(positive.size() == 2){
            if(positive.get(0) == 0 || positive.get(1) == 0){
                ans += positive.get(0) + positive.get(1);
            }else if(positive.get(0) == 1 || positive.get(1) == 1){
                ans += positive.get(0) + positive.get(1);
            }
            else{
                ans += (positive.get(0) * positive.get(1));
            }
        }else{
            if(positive.size() % 2 == 0){
                for (int j = 0; j < positive.size(); j+= 2) {
                    if(positive.get(j) == 0 || positive.get(j+1) == 0){
                        ans += positive.get(j) + positive.get(j+1);
                    }else if(positive.get(j) == 1 || positive.get(j+1) == 1){
                        ans += positive.get(j) + positive.get(j+1);
                    }else{
                        ans += (positive.get(j) * positive.get(j+1));
                    }
                }
            }else{
                for (int j = 0; j < positive.size()-1; j+= 2) {
                    if(positive.get(j) == 0 || positive.get(j+1) == 0){
                        ans += positive.get(j) + positive.get(j+1);
                    }else if(positive.get(j) == 1 || positive.get(j+1) == 1){
                        ans += positive.get(j) + positive.get(j+1);
                    }else{
                        ans += (positive.get(j) * positive.get(j+1));
                    }
                }
                ans += positive.get(positive.size()-1);
            }
        }
        System.out.println(ans);

    }
}
