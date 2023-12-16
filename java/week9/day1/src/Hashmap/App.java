package Hashmap;

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
    private HashMap<Integer, Member> hashMap;

    Program(){
        hashMap = new HashMap<Integer, Member>(new MemberIDCompare());
    }
    public void addMember(Integer id, Member input){
        if(hashMap.containsKey(id) && hashMap.containsValue(input)){
            System.out.println(id + " is exist!!");
            return;
        }
        hashMap.put(id, input);
    }
    public void removeMember(int id){
        Set<Integer> ks = treeMap.keySet();
        Iterator<Integer> itr = ks.iterator()
        for(Integer i : itr.hasNext(); ){
            Member tmp = treeMap.get(i.next());
            if(tmp.getID() == id){
                treeMap.remove(id);
                System.out.println("delete complete ID: " + id);
                return ;
            }
        }
        System.out.println("ID " + id+ " is not exist!!");
    }
    public void printAll(){
        Set<Integer> ks = treeMap.keySet();
        for(Iterator<Integer> itr = ks.iterator(); itr.hasNext(); ){
            Member tmp = treeMap.get(itr.next());
            System.out.println(tmp.getID() + ": "+ tmp.getName());
        }
    }
}
public class App {
    public static void main(String[] args) {
        Program program = new Program();
        program.addMember(12, new Member(12, "kim"));
        program.addMember(12, new Member(12, "you"));
        program.addMember(25, new Member(25, "park"));
        program.addMember(37, new Member(37, "song"));
        program.printAll();
        program.removeMember(12);
        program.printAll();
    }
}
