import java.util.*;

public class Practice {
    enum Patten {
        clover("클로버"),
        heart("하트"),
        Diamond("다이아몬드"),
        Space("스페이스");

        public String korName;

        Patten(String name) {
            this.korName = name;
        }

        String GetName() {
            return this.korName;
        }
    }

    enum Number {
        ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"),
        SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"),
        JACK("J"), QUEEN("Q"), KING("K"), ACE("A");

        private final String symbol;

        Number(String symbol) {
            this.symbol = symbol;
        }

        String GetNum() {
            return this.symbol;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("플레이어 숫자: ");
        int input = scanner.nextInt();

        int[] NumArray = new int[input];
        int[] PattenArray = new int[input];
        Random random = new Random();

        for (int i = 0; i < input; i++) {
            int number, patten;
            boolean isDuplicate;

            do {
                number = random.nextInt(13) + 2;
                patten = random.nextInt(4);
                isDuplicate = false;

                // 중복 확인
                for (int j = 0; j < i; j++) {
                    if (NumArray[j] == number && PattenArray[j] == patten) {
                        isDuplicate = true;
                        break;
                    }
                }
            } while (isDuplicate);

            NumArray[i] = number;
            PattenArray[i] = patten;
        }

        Patten[] pattenArray = new Patten[input];
        Number[] numberArray = new Number[input];

        for (int i = 0; i < input; i++) {
            pattenArray[i] = Patten.values()[PattenArray[i]];
            numberArray[i] = Number.values()[NumArray[i] - 2];
        }

        for (int i = 0; i < input; i++) {
            System.out.println("참가자" + (1 + i) + " : " + pattenArray[i].GetName() + numberArray[i].GetNum());
        }

        // 우승자 결정
        int winner = 0;
        for (int i = 1; i < input; i++) {
            if (NumArray[i] > NumArray[winner] ||
                (NumArray[i] == NumArray[winner] && pattenArray[i].ordinal() > pattenArray[winner].ordinal())) {
                winner = i;
            }
        }

        System.out.println("참가자 " + (winner + 1) + "가 이겼습니다.");
        scanner.close();
    }
}
