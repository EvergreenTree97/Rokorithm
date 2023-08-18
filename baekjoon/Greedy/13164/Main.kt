fun main(){
    with(System.`in`.bufferedReader()){
        val (N,K) = readLine().split(" ").map(String::toInt)
        val students = readLine().split(" ").map(String::toInt).toIntArray()
        val diffs = IntArray(N-1)
        for(i in 1 until students.size){
            diffs[i-1] = students[i] - students[i-1]
        }
        if(N == K) print(0)
        else{
            diffs.sort()
            var sum = 0
            for(i in 0 until N-K){
                sum += diffs[i]
            }
            print(sum)
        }
    }
}

//K개 조의 비용의 합이 최소가 되기 위해서는? -> 각 조의 비용 합도 최소가 되어야 함
//조원이 1명인 경우는 비용이 0이다.

//인접한 학생들의 비용의 차를 구한다
//5 3
//1 3 5 6 10
//에서 2 2 1 4, 정렬하면 1 1 2 4
//N-K만큼 반복하여 앞에서 부터 더한다. 단, N==K이면 0이 되어야 한다.