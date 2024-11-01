# java-lotto-precourse

# 🍀 로또 발매기 🍀

| 완료여부 | 구분 | 주기능 | 주기능정의 | 세부기능                                                                                                                                                                                                                                                                      | 예외흐름                                                                                                                                                                  |
| --- | --- | --- | --- |---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|  | **1. 로또 구매** | **1.1 로또 구입 금액 입력** | 로또 구입 금액을 입력한다. | - `구입금액을 입력해 주세요.` 안내 문구 출력 후 사용자의 입력을 받는다. <br>- 사용자는 로또 1장 가격(1000)으로 나누어떨어지는 양의 정수를 입력한다. <br>- `1.2`로 간다.                                                                                                                                                             | - 이때, 아래 상황에서 예외 메세지가 출력되고 `1.1`을 다시 시작한다. <br>1. 빈 값일 때 <br>2. 양의 정수가 아닐 때 <br>3. 금액이 10자리를 초과할 때                                                                    |
   |  |  | **1.2 로또 구입 개수 확인** | 구입 금액에 해당하는 개수를 구한다. | - 구입 금액을 1000으로 나누어 개수를 구한다. <br>- `1.3`로 간다.                                                                                                                                                                                                                             | - 이때, 아래 상황에서 예외 메세지가 출력되고 `1.1`로 간다. <br>1. 1000으로 나누어 떨어지지 않을 때                                                                                                     |
   |  |  | **1.3 로또 발행** | 구입 개수만큼의 로또를 자동 발행한다. | - 로또 1장 당 1~45 사이의 중복되지 않은 오름차순의 정수를 6개 뽑아 발행한다.                                                                     <br>- `1.4`로 간다.                                                                                                                                     |                                                                                                                                                                       |
  |  |  | **1.4 발행된 로또 모두 출력** | 발행된 로또 수량 및 번호를 콘솔에 출력한다. | - `n개를 구매했습니다.` 문구를 출력한다. <br>- 발행한 로또 번호를 한 줄에 한 장씩, 오름차순으로 정렬하여 출력한다. <br>- 이때 한 장의 로또번호는 `[`와 `]`로 감싸져 있으며, 각 숫자는 `,` 으로 구분한다. <br>- `2.1`로 간다.                                                                                                                        |                                                                                                                                                                       |
  |  | **2. 당첨번호 및 보너스번호 추첨** | **2.1 당첨 번호 입력** | 당첨 번호 6개를 입력한다. | - `당첨 번호를 입력해 주세요.` 안내 문구 출력 후 사용자의 입력을 받는다. <br>- 사용자는 1~45 사이의 서로 중복되지 않는 정수 6개를 입력한다. 번호는 `,`를 기준으로 구분한다. <br>- `2.2`로 간다.                                                                                                                                             | - 이때, 아래 상황에서 예외 메세지가 출력되고 `2.1`을 다시 시작한다. <br>1.  빈 값일 때                                                                                                             |
    |  |  | **2.2 당첨 번호 저장** | 당첨 번호 6개를 확인하고 저장한다. | - 당첨 번호 6개를 각각 저장한다.                                                                                                                                <br>- 번호와 번호 사이에 띄어쓰기를 한 경우는 허용한다. (ex. `1,2,3, 4,35 ,6`)                                                             | - 이때, 아래 상황에서 예외 메세지가 출력되고 `2.1` 로 돌아간다. <br>1. 입력한 번호가 6개가 아닐 때 <br>2. 1~45 사이의 정수가 아닌 번호가 있을 때 <br>3. 중복된 번호가 있을 때 <br>4. 하나의 번호 안에 띄어쓰기를 할 때 (ex. `1,2,3,4,3 5,6`) |
   |  |  | **2.3 보너스 번호 입력** | 보너스번호 1개를 입력한다. | - `보너스 번호를 입력해 주세요.` 안내 문구 출력 후 사용자의 입력을 받는다. <br>- 사용자는 1~45 사이의 당첨번호 6개와 중복되지 않는 정수 1개를 입력한다.                                                                                                                                                                           | - 이때, 아래 상황에서 예외 메세지가 출력되고 `2.3`을 다시 시작한다. <br>1. 빈 값일 때 <br>2. 양의 정수가 아닐 때                                                                                           |
   |  |  | **2.4 보너스 번호 저장** | 보너스 번호 1개를 확인하고 저장한다. | - 보너스 번호 1개를 저장한다.                                                                                                                                                                                                                                                        | - 이때, 아래 상황에서 예외 메세지가 출력되고, `2.3`으로 돌아간다. <br>1. 1~45 사이의 정수가 아닐 때 <br>2. 앞선 당첨 번호 6개 중 중복된 번호가 있을 때                                                                  |
   |  | **3. 당첨 확인** | **3.1 당첨 번호와의 일치 개수 확인** | 각각의 발행한 로또 번호 6개 중 당첨번호와 일치한 개수를 확인한다. | - 각각의 발행한 로또 번호 6개 중 당첨 번호와 일치한 개수를 확인한다. <br>- 이때 개수가 5개라면, `3.2`로 간다. <br>- 그렇지 않으면 `3.3`로 간다.                                                                                                                                                                          |                                                                                                                                                                       |
  |  |  | **3.2 보너스 번호와의 일치 여부 확인** | 로또의 번호가 보너스 번호와 일치하는지 확인한다. | - 로또 번호가 보너스 번호와 일치하는지 확인한다.                                                                                                                                                                                   <br>- `3.3`로 간다.                                           |                                                                                                                                                                       |
  |  |  | **3.3 등수 확인** | 각각의 발행한 로또의 당첨 여부 및 등수를 저장한다. | - 각각의 발행한 로또의 당첨 여부, 그리고 당첨되었다면 등수를 확인해 저장한다. <br>- 로또의 가능한 상태에는 `1등`, `2등`, `3등`, `4등`, `5등`, 그리고 `당첨되지 않음` 이 있다. <br>- `4.1`로 간다.                                                                                                                                       |                                                                                                                                                                       |
  |  | **4. 당첨 통계 출력** | **4.1 당첨 개수 출력** | 일치 번호 개수별 당첨금과 당첨된 로또의 개수를 출력한다. | - `당첨 통계` 안내문구 출력 후, 일치 번호 개수별 당첨금과 당첨된 로또의 개수를 한 줄에 하나씩 출력한다. <br>- 일치 번호는 1~5등의 것만 취급한다. 즉, 0개, 1개, 2개 일치한 경우는 출력하지 않는다. <br>- 이때, `l개 일치 (m원) - n개` 의 형식으로 출력한다. <br>- `4.2`로 간다.                                                                                      |                                                                                                                                                                       |
  |  |  | **4.2 수익률 출력** | 총 수익률을 출력한다. | - `총 당첨금액 / 총 구입금액 * 100` 을 계산하여 수익률을 출력한다.                                                                                                                                                                                      <br>- 이때, `총 수익률은 nn.n%입니다.`의 형식으로 출력한다. |                                                                                                                                                                       |

> 사용자가 잘못된 값을 입력할 경우`IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.<br>
>`Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.