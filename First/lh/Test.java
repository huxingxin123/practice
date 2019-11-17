
import equipment.Package;
import role.Role;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("请输入人物姓名：");
        String name=in.nextLine();
        System.out.println("请输入人物生命值：");
        int health=in.nextInt();
        System.out.println("请输入人物攻击力：");
        int ATK=in.nextInt();
        System.out.println("请输入人物防御力：");
        int defense=in.nextInt();
        System.out.println("请输入人物敏捷度：");
        int agility=in.nextInt();
        Package pack=new Package();
        Role role=new Role(name,health,ATK,defense,agility);
        Judge judge=new Judge();
        role.registerObserver(judge);
        judge.start(Round.build(1,pack),role,pack);
        judge.start(Round.build(2,pack),role,pack);
        judge.start(Round.build(3,pack),role,pack);
        judge.start(Round.build(4,pack),role,pack);
        judge.start(Round.build(5,pack),role,pack);
        judge.start(Round.build(6,pack),role,pack);
        judge.start(Round.build(7,pack),role,pack);
        judge.start(Round.build(8,pack),role,pack);
        judge.start(Round.build(9,pack),role,pack);
        judge.start(Round.build(10,pack),role,pack);
        System.out.println("你已成功通关！");
    }
}
