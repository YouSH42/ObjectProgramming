package TreeSet;

import java.util.*;

class MemberIDCompare implements Comparator<Member> {
    @Override
    public int compare(Member member1, Member member2){
        return member1.compareTo(member2)*-1;          // 글자 오름차순
        // return member2.getID() - member1.getID();   // ID 오름차순
    }
}

class Member implements Comparable<Member>{
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
    public int compareTo(Member member){
        return this.name.compareTo(member.getName());   // 글자 내림차순
        // return this.ID - member.ID;                  // ID 내림차순
    }
}

class Program{
    private TreeSet<Member> treeSet;

    Program(){
        treeSet = new TreeSet<Member>(new MemberIDCompare());
    }
    public void addMember(Member input){
        treeSet.add(input);
    }
    public void removeMember(int ID){
        Iterator<Member> iter = treeSet.iterator();
        while(iter.hasNext()){
            Member tmp = iter.next();
            if(tmp.getID() == ID){
                System.out.println("delete complete");
                iter.remove();
                break;
            }
        }
    }
    public void printAll(){
        Iterator<Member> iter = treeSet.iterator();
        while(iter.hasNext()){
            Member tmp = iter.next();
            System.out.println("ID: " +tmp.getID() + " Name: "+tmp.getName()+"\n");
        }
    }
}
public class App {
    public static void main(String[] args) {
        Program program = new Program();
        program.addMember(new Member(37, "zking"));
        program.addMember(new Member(56, "song"));
        program.addMember(new Member(12, "kim"));
        program.addMember(new Member(25, "park"));
        program.printAll();
        // program.removeMember(12);
        // program.printAll();
    }
}
