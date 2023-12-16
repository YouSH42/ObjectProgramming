package Collection;

import java.util.*;

class Member {
    private int ID;
    private String name;

    Member (int ID, String name){
        this.ID = ID;
        this.name = name;
    }
    public int getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
}

class Program{
    private ArrayList<Member> arr;

    Program(){
        arr = new ArrayList<Member>();
    }

    public void addMember(Member input){
        boolean IsSame = false;
        int length = arr.size();
        for(int i = 0; i < length; i++){
            Member tmp = arr.get(i);
            if(tmp.getID() == input.getID()){
                IsSame = true;
                break;
            }
        }
        if(!IsSame){
            arr.add(input);
        }
    }

    public void removeMember(int ID){
        int length = arr.size();
        for(int i = 0; i < length; i++){
            Member tmp = arr.get(i);
            if(tmp.getID() == ID){
                arr.remove(i);
                System.out.println("delete complete");
                break;
            }
        }
    }
    public void printAll(){
        for(int i = 0; i < arr.size(); i++){
            Member tmp = arr.get(i);
            System.out.printf("ID : %d Name: %s\n",tmp.getID(), tmp.getName());
        }
    }

}

public class App {
    public static void main(String[] args) {
        Program program = new Program();
        program.addMember(new Member(12, "kim"));
        program.addMember(new Member(12, "you"));
        program.addMember(new Member(25, "park"));
        program.addMember(new Member(37, "song"));
        program.printAll();
        program.removeMember(12);
        program.printAll();
    }
}
