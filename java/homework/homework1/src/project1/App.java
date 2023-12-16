package project1;
import java.util.*;

class Phone {
    // members
    private String name, number;
    // Constructor
    public Phone(String name, String number) {
        this.name = name;
        this.number = number;
    }
    // methods
    public void PrintInfo() {
        System.out.printf("[이름: %s] [전화번호: %s]\n", this.name, this.number);
    }
    public String GetName() {
        return this.name;
    }
    public String GetNumber() {
        return this.number;
    }
}

class PhoneUniv extends Phone {
    // members
    private String major;
    private int grade;
    // constructor
    public PhoneUniv(String name, String number, String major, int grade) {
        super(name, number);
        this.major = major;
        this.grade = grade;
    }
    // methods
    public void PrintInfo() {
        System.out.printf("[이름: %s] [전화번호: %s] [전공: %s] [학년: %d]\n", GetName(), GetNumber(), this.major, this.grade);
    }
}

class PhoneComp extends Phone {
    // members
    private String company;
    // constructor
    public PhoneComp(String name, String number, String company) {
        super(name, number);
        this.company = company;
    }
    // methods
    public void PrintInfo() {
        System.out.printf("[이름: %s] [전화번호: %s] [회사: %s]\n", GetName(), GetNumber(), this.company);
    }
}

class PhoneManager {
    // members
    private Vector<Phone> phonelist = new Vector<Phone>(10);
    Scanner scanner = new Scanner(System.in);

    // constructor
    PhoneManager(){
        phonelist = new Vector<Phone>(100);
    }
    // method
    public void InsertData(){
        System.out.printf("어떤 사용자인가요?[1 - 일반 / 2 - 대학 / 3 - 회사] : ");
        int choice, grade;
        String name, company, major, number;
        choice = scanner.nextInt();
        switch(choice){
            case 1:
                System.out.println("[정보를 입력하세요]");
                System.out.printf("이름 : ");
                name = scanner.next();
                System.out.printf("전화번호 : ");
                number = scanner.next();
                phonelist.add(new Phone(name, number));
                break;
            case 2:
                System.out.println("[정보를 입력하세요]");
                System.out.printf("이름 : ");
                name = scanner.next();
                System.out.printf("전화번호 : ");
                number = scanner.next();
                System.out.printf("전공 : ");
                major = scanner.next();
                System.out.printf("학년 : ");
                grade = scanner.nextInt();
                phonelist.add(new PhoneUniv(name, number, major, grade));
                break;
            case 3:
                System.out.println("[정보를 입력하세요]");
                System.out.printf("이름 : ");
                name = scanner.next();
                System.out.printf("전화번호 : ");
                number = scanner.next();
                System.out.printf("회사명 : ");
                company = scanner.next();
                phonelist.add(new PhoneComp(name, number, company));
                break;
        }
    }
    public void SearchData(){
        System.out.printf("찾을 사람의 이름: ");
        String name = scanner.next();
        int index = phonelist.size();
        for(int i = 0; i < index; i++){
            if(name.equals(phonelist.get(i).GetName())){
                System.out.println("[" + name + "의 정보");
                phonelist.get(i).PrintInfo();
                return;
            }
        }
        System.out.println("!!찾는 사람이 없습니다!!");
    }
    public void DeleteData(){
        System.out.printf("삭제할 사람 이름: ");
        String name = scanner.next();
        int index = phonelist.size();
        for(int i = 0; i < index; i++){
            if(name.equals(phonelist.get(i).GetName())){
                phonelist.remove(i);
                System.out.println("[" + name + "의 정보를 삭제했습니다.]");
                return;
            }
        }
        System.out.println("!!삭제할 사람이 없습니다!!");
    }
    public void PrintData(){
        int index = phonelist.size();
        if(index == 0){
            System.out.printf("[출력할 데이터가 없습니다]\n");
            return ;
        }
        System.out.println("전체 데이터 출력");
        for(int i = 0; i < index; i++){
            System.out.printf("%d : ", i+1);
            phonelist.get(i).PrintInfo();
        }
    }
}

public class App {
    static void PrintMenu(){
            System.out.println("1. 데이터 입력");
            System.out.println("2. 데이터 검색");
            System.out.println("3. 데이터 삭제");
            System.out.println("4. 전체 데이터 출력");
            System.out.println("5. 프로그램 종료");
            System.out.print("메뉴를 선택하세요: ");
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        PhoneManager pm = new PhoneManager();
        boolean roof = true;
        while (roof) {
            PrintMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:   // 데이터 입력 구현
                pm.InsertData();
                break;
                case 2:   // 데이터 검색 구현
                pm.SearchData();
                    break;
                case 3:   // 데이터 삭제 구현
                pm.DeleteData();
                    break;
                case 4:   // 전체 데이터 출력 구현
                pm.PrintData();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    roof = false;
                    break;
                default:
                    System.out.println("올바른 메뉴를 선택하세요.");
            }
        }
        scanner.close();
    }
}
