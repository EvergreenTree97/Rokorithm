### 👉TIP
----
#### 시간복잡도 유추
일반적으로 1억번(10^8) 이 1초라고 가정한다.
플로이드 워셜 같은 n^3 강제하는 알고리즘이나, 완전탐색 n! 등은 제외한다.

데이터가 10만개인 경우 NlogN까지는 최적화 하거나, 다른 접근 방식을 찾아야 한다

#### 공간복잡도 유추
주어지는 데이터의 범위를 보고, 어떠한 연산이 적용되는지 고려한다.
상황에따라 Long으로 설정 할수도 있고, 매핑을 해줄수도 있다

#### Comparator는 함수가 리턴하는 값에 따라 SWAP 여부를 결정한다

```kotlin
o1.compareTo(o2)
```
위 코드는 o1-o2를 반환한다. 음수는 No Swap이니까 위의 코드가 오름차순이다.
- 음수 : No Swap
- 0 : 동일
- 양수 : Swap
