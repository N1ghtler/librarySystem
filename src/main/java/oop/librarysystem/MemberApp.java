package oop.librarysystem;

import javafx.scene.control.Menu;
import oop.librarysystem.DataClass.Member;

public class MemberApp {
    public static void main(String[] args){
        System.out.println("Information");
        Member member =new Member();

        member.setMemberName("Molyza");
        //member.setMemberID(1234);
        member.setMemberGender("Female");
        member.setMemberAge("19");
        System.out.print(member.toString());

    }
}
