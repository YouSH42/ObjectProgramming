package HashSet;

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
    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof Member))
            return false;
        Member member = (Member) o;
        if( ID == member.getID() && Objects.equals(ID, member.getID()) ){
            System.out.printf("ID %d is exist!!\n", ID);
            return true;
        }
        else
            return false;
    }
    @Override
    public int hashCode(){
        return Objects.hash(ID);
    }
}

class Program{
    private HashSet<Member> hashSet;

    Program(){
        hashSet = new HashSet<Member>();
    }
    public void addMember(Member input){
        hashSet.add(input);
    }
    public void removeMember(int ID){
        Iterator<Member> iter = hashSet.iterator();
        while(iter.hasNext()){
            Member tmp = iter.next();
            if(tmp.getID() == ID){
                System.out.println("ID" +tmp.getID()+ "delete complete");
                iter.remove();
                break;
            }
        }
    }
    public void printAll(){
        Iterator<Member> iter = hashSet.iterator();
        while(iter.hasNext()){
            Member tmp = iter.next();
            System.out.println("ID: " +tmp.getID() + " Name: "+tmp.getName()+"\n");
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
