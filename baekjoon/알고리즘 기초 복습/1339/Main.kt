fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val arr = Array(N){
        readLine()!!
    }
    val stringArr = Array(26){
        IntArray(2)
    }
    arr.forEach { s ->
        var mul = Math.pow(10.0,(s.length-1).toDouble()).toInt()
        for(i in s.indices){
            stringArr[s[i].code-'A'.code][0] = s[i].code-'A'.code
            stringArr[s[i].code-'A'.code][1] += mul
            mul /= 10
        }
    }
    stringArr.sortWith { o1, o2 ->
        o2[1].compareTo(o1[1])
    }
    val hashMap = HashMap<Char,Int>()
    var num = 9
    for (i in stringArr){
        if(i[1] == 0){
            break
        }
        hashMap['A'+i[0]] = num--
    }
    var sum = 0
    arr.forEach { s ->
        var mul = 1
        for (i in s.length-1 downTo 0){
            sum += hashMap.getOrDefault(s[i],0) * mul
            mul *= 10
        }
    }
    print(sum)
}

