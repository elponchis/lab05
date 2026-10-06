# Lab05 - 사칙연산

모바일웹서비스프로젝트 실습5 과제.

1. TDD 방식으로 작성한 Python 사칙연산 모듈
2. 같은 로직을 사용하는 Android 사칙연산 앱 (Kotlin, View + XML)

## 구성

```
tdd_four_basic_opt/
  FourBasicOpt.py          사칙연산 클래스
  test_FourBasicOpt.py     unittest 8개
app/src/main/java/com/example/lab05/
  FourBasicOpt.kt          사칙연산 클래스 (Python과 동일한 로직)
  MainActivity.kt          입력, 연산, 결과 표시, 초기화
app/src/main/res/layout/
  activity_main.xml        화면 레이아웃
app/src/test/java/com/example/lab05/
  FourBasicOptTest.kt      JUnit 8개 (Python 테스트와 같은 케이스)
```

## 0으로 나누기

`divide(x, 0)`은 예외를 던지지 않고 0을 반환한다. Python에서 `x / 0`을 그대로
반환하면 `ZeroDivisionError`가 발생하고, Kotlin `Double`에서는 `Infinity`가 되므로
두 구현 모두 나누는 수가 0인 경우를 먼저 검사한다.

## 테스트 케이스

강의자료(48페이지)의 테스트 코드와 같은 케이스다.

| 테스트 | 입력 | 기댓값 |
|--------|------|--------|
| test_add_01 | add(100, 10) | 110 |
| test_add_02 | add(100, -10) | 90 |
| test_subtract_01 | subtract(100, 10) | 90 |
| test_subtract_02 | subtract(100, -10) | 110 |
| test_divide_01 | divide(100, 10) | 10 |
| test_divide_02 | divide(100, 0) | 0 |
| test_multiply_01 | multiply(100, 10) | 1000 |
| test_multiply_02 | multiply(100, 1) | 100 |

## 실행 방법

Python 테스트:

```
cd tdd_four_basic_opt
python -m unittest test_FourBasicOpt -v
```

Android 빌드와 유닛 테스트:

```
./gradlew assembleDebug
./gradlew test
```

`JAVA_HOME`이 설정되어 있지 않으면 Android Studio에 포함된 JDK를 지정한다.

```
export JAVA_HOME="/c/Program Files/Android/Android Studio/jbr"
```

## 앱 동작

- 화면 위쪽에 `[숫자 1] [연산자] [숫자 2]`가 가로로 놓이고 그 아래에 `= 결과`가 표시된다.
- 연산자 버튼(+, -, ×, ÷)을 누르면 가운데 연산자가 바뀌고 바로 계산한다.
- 입력칸이 하나라도 비어 있으면 "숫자 두 개를 모두 입력하세요" 안내를 띄운다.
- `-`나 `.`만 입력한 경우처럼 숫자로 변환되지 않으면 "올바른 숫자를 입력하세요" 안내를 띄운다.
- 결과는 소수점 아래 10자리에서 반올림하고, 정수면 소수점 없이 표시한다.
- 초기화 버튼은 입력칸, 연산자, 결과를 비운다.

## 실행 화면

`screenshots/` 폴더에 있다. 실제 기기(Galaxy SM-M336K, Android 15)에서 캡처했다.

| 파일 | 내용 |
|------|------|
| `unittest_result.png` | Python unittest 8개 통과 콘솔 |
| `android_divide_by_zero.png` | 100 ÷ 0 = 0 |
| `android_divide.png` | 10 ÷ 3 = 3.3333333333 |
