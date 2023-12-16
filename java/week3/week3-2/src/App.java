public class App {
    enum Patten {
        clover("클로버"),       //0은 클로버
        heart("하트"),         //1은 하트 
        Diamond("다이아몬드"),  //2는 다이야
        Space("스페이스");      //3은 스페이
      
        public String korName;

        Patten(String name){
          this.korName = name; 
        }
        String GetDayName(){
          return this.korName;
        }
    }

    public static void main(String[] args) throws Exception {

        int A_number = (int)((Math.random()*10000)%13) + 2;
        int A_patten = (int)((Math.random()*10000)%4);    

        int B_number = (int)((Math.random()*10000)%13) + 2;
        int B_patten = (int)((Math.random()*10000)%4);    
        while((B_number == A_number) && (B_patten == A_patten)){
            A_number = (int) ((Math.random() * 10000) % 13) + 2;
            A_patten = (int) ((Math.random() * 10000) % 4);

            B_number = (int) ((Math.random() * 10000) % 13) + 2;
            B_patten = (int) ((Math.random() * 10000) % 4);

        }

        String A_alphabet = " ";
        String B_alphabet = " ";
        if(A_number > 10){
            //TODO:
            switch (A_number){
                case 11: A_alphabet = "J";  break;
                case 12: A_alphabet = "Q";   break;
                case 13: A_alphabet = "K";   break;
                case 14: A_alphabet = "A";   break;
            }
        }
        if(B_number > 10){
            //TODO:
            switch (B_number){
                case 11: B_alphabet = "J";  break;
                case 12: B_alphabet = "Q";   break;
                case 13: B_alphabet = "K";   break;
                case 14: B_alphabet = "A";   break;
            }
        }

        Patten Apatten = Patten.values()[A_patten];
        Patten Bpatten = Patten.values()[B_patten];
        if(A_number > B_number){
            //TODO:
            if(A_number > 10 && B_number > 10){
                System.out.println("참가자 A : " + Apatten.GetDayName() + A_alphabet);
                System.out.println("참가자 B : " + Bpatten.GetDayName() + B_alphabet);
            }
            else if(A_number > 10){
                System.out.println("참가자 A : " + Apatten.GetDayName() + A_alphabet);
                System.out.println("참가자 B : " + Bpatten.GetDayName() + B_number);

            }
            else if(B_number > 10){
                System.out.println("참가자 A : " + Apatten.GetDayName() + A_number);
                System.out.println("참가자 B : " + Bpatten.GetDayName() + B_alphabet);

            }
            else {
                System.out.println("참가자 A : " + Apatten.GetDayName() + A_number);
                System.out.println("참가자 B : " + Bpatten.GetDayName() + B_number);
            }
            System.out.println("A가 이겼습니다.");
        }
        else if (A_number < B_number){
            //TODO:
            if(A_number > 10 && B_number > 10){
                System.out.println("참가자 A : " + Apatten.GetDayName() + A_alphabet);
                System.out.println("참가자 B : " + Bpatten.GetDayName() + B_alphabet);
            }
            else if(A_number > 10){
                System.out.println("참가자 A : " + Apatten.GetDayName() + A_alphabet);
                System.out.println("참가자 B : " + Bpatten.GetDayName() + B_number);

            }
            else if(B_number > 10){
                System.out.println("참가자 A : " + Apatten.GetDayName() + A_number);
                System.out.println("참가자 B : " + Bpatten.GetDayName() + B_alphabet);

            }
            else {
                System.out.println("참가자 A : " + Apatten.GetDayName() + A_number);
                System.out.println("참가자 B : " + Bpatten.GetDayName() + B_number);
            }
            System.out.println("B가 이겼습니다.");
        }
        else{
            if(A_patten > B_patten){
                //TODO:
                if (A_number > 10 && B_number > 10) {
                    System.out.println("참가자 A : " + Apatten.GetDayName() + A_alphabet);
                    System.out.println("참가자 B : " + Bpatten.GetDayName() + B_alphabet);
                } else if (A_number > 10) {
                    System.out.println("참가자 A : " + Apatten.GetDayName() + A_alphabet);
                    System.out.println("참가자 B : " + Bpatten.GetDayName() + B_number);

                } else if (B_number > 10) {
                    System.out.println("참가자 A : " + Apatten.GetDayName() + A_number);
                    System.out.println("참가자 B : " + Bpatten.GetDayName() + B_alphabet);

                } else {
                    System.out.println("참가자 A : " + Apatten.GetDayName() + A_number);
                    System.out.println("참가자 B : " + Bpatten.GetDayName() + B_number);
                }
                System.out.println("A가 이겼습니다.");
            }
            else if(A_patten < B_patten){
                //TODO:
                if (A_number > 10 && B_number > 10) {
                    System.out.println("참가자 A : " + Apatten.GetDayName() + A_alphabet);
                    System.out.println("참가자 B : " + Bpatten.GetDayName() + B_alphabet);
                } else if (A_number > 10) {
                    System.out.println("참가자 A : " + Apatten.GetDayName() + A_alphabet);
                    System.out.println("참가자 B : " + Bpatten.GetDayName() + B_number);

                } else if (B_number > 10) {
                    System.out.println("참가자 A : " + Apatten.GetDayName() + A_number);
                    System.out.println("참가자 B : " + Bpatten.GetDayName() + B_alphabet);

                } else {
                    System.out.println("참가자 A : " + Apatten.GetDayName() + A_number);
                    System.out.println("참가자 B : " + Bpatten.GetDayName() + B_number);
                }
                System.out.println("B가 이겼습니다.");
            }
            else{
                System.out.println("중복된 카드가 뽑혔습니다.");
            }
        }
        // System.out.println(patten);
        // System.out.println(number);

    }
}
