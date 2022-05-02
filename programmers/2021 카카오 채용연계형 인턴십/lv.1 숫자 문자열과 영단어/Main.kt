fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    print(solve(s))
}

fun checkNumber(c: Char): Boolean {
    return (c >= '0') && (c <= '9')
}
fun solve(s: String) : Int {
    var i = 0
    val length = s.length
    var res = ""
    while (i < length) {
        if (checkNumber(s[i])) {
            res += s[i]
            i++
        } else {
            when (s[i]) {
                't' -> if (s[i + 1] == 'w') {
                    i += 3
                    res += '2'
                } else {
                    i += 5
                    res += '3'
                }
                'f' -> if (s[i + 1] == 'o') {
                    i += 4
                    res += '4'
                } else {
                    i += 4
                    res += '5'
                }
                's' -> if (s[i + 1] == 'i') {
                    i += 3
                    res += '6'
                } else {
                    i += 5
                    res += '7'
                }
                'z' -> {
                    i += 4
                    res += '0'
                }
                'o' -> {
                    i += 3
                    res += '1'
                }
                'e' -> {
                    i += 5
                    res += '8'
                }
                else -> {
                    i += 4
                    res += '9'
                }


            }
        }
    }
    return res.toInt()
}

