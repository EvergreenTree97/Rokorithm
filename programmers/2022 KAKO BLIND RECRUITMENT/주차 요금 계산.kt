fun main() {
    Solution().solution(
        intArrayOf(180, 5000, 10, 600),
        arrayOf("05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT")
    )
}

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val carInfoMap = hashMapOf<String, CarInfo>()
        val (normalTime, normalFee, unitTime, unitFee) = fees
        records.forEach {
            val (time, number, carState) = it.split(" ")
            when (val state = CarState.valueOf(carState)) {
                CarState.IN -> {
                    carInfoMap[number] = carInfoMap.getOrDefault(
                        number,
                        CarInfo(
                            state = state,
                            inTime = time.toTime(),
                            sumMinute = 0,
                            fee = 0,
                        )
                    ).copy(
                        state = CarState.IN,
                        inTime = time.toTime(),
                    )
                }

                CarState.OUT -> {
                    carInfoMap[number]!!.run {
                        val beforeTime = this.inTime
                        val afterTime = time.toTime()
                        val sumDiff = beforeTime.getDiff(afterTime)
                        carInfoMap[number] = this.copy(
                            state = CarState.OUT,
                            sumMinute = this.sumMinute + sumDiff,
                        )
                    }
                }
            }
        }
        carInfoMap.forEach { (t, u) ->
            if (u.state == CarState.IN) {
                carInfoMap[t]!!.run {
                    val beforeTime = carInfoMap[t]!!.inTime
                    val afterTime = Time(23 * 60 + 59)
                    val sumDiff = beforeTime.getDiff(afterTime)
                    val fee = (sumDiff + this.sumMinute).getFee(normalTime, normalFee, unitTime, unitFee)
                    carInfoMap[t] = this.copy(
                        state = CarState.OUT,
                        sumMinute = this.sumMinute + sumDiff,
                        fee = this.fee + fee,
                    )
                }
            }else{
                carInfoMap[t]!!.run{
                    val fee = (this.sumMinute).getFee(normalTime, normalFee, unitTime, unitFee)
                    carInfoMap[t] = this.copy(
                        state = CarState.OUT,
                        sumMinute = this.sumMinute,
                        fee = fee,
                    )
                }
            }
        }
        return carInfoMap.toSortedMap { o1, o2 -> o1.compareTo(o2) }.map { it.value.fee }.toIntArray()
    }
}

data class CarInfo(
    val state: CarState,
    val inTime: Time,
    val sumMinute: Int,
    val fee: Int,
)

enum class CarState {
    IN, OUT;
}

fun String.toTime(): Time {
    return this.split(":").map(String::toInt).let {
        Time(it[0] * 60 + it[1])
    }
}

fun Int.getFee(
    normalTime: Int, normalFee: Int, unitTime: Int, unitFee: Int
): Int {
    if (this <= normalTime) {
        return normalFee
    }
    val overFlowTime = this - normalTime
    var overCount = overFlowTime / unitTime
    val etc = overFlowTime % unitTime
    if (etc in 1 until unitTime) {
        overCount++
    }
    return normalFee + overCount * unitFee

}

data class Time(
    val minute: Int,
) {
    fun getDiff(otherTime: Time): Int {
        return otherTime.minute - minute
    }
}

