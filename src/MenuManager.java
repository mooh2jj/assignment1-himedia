import java.util.Scanner;

public class MenuManager {

    public final static int LOGIN = 1;
    public final static int EXIT = 2;

    public final static int ADDRESS_SEARCH = 1;
    public final static int ALL_ADDRESS_SEARCH = 2;
    public final static int LOGOUT = 3;

    public MenuManager() {
    }

    void initMenu(){
        System.out.println("<< 주소록 관리 프로그램 >>");
        System.out.println("1. 로그인");
        System.out.println("2. 종료");
    }
    void addressMenu(){
        System.out.println("<< 주소록 관리 프로그램 >>");
        System.out.println("1. 주소 검색");
        System.out.println("2. 전체 주소록 검색");
        System.out.println("3. 로그아웃");
    }
    int selectInitMenu(){
        Scanner sc = new Scanner(System.in);
        int select = 0;
        while (true) {
            System.out.print("메뉴 선택 : 1) 로그인, 2) 종료 >> ");
            select = sc.nextInt();
            if (select < LOGIN || select > EXIT) {
                System.out.println("잘못된 번호를 선택하였습니다! 다시 선택해주세요!");
                continue;
            } else {
                break;
            }
        }
        return select;
    }

    int selectAddressMenu(){
        Scanner sc = new Scanner(System.in);
        int select = 0;
        while (true) {
            System.out.print("메뉴 선택 : 1) 주소 검색, 2) 전체 주소록 검색, 3) 로그아웃 >> ");
            select = sc.nextInt();
            if (select < ADDRESS_SEARCH || select > LOGOUT) {
                System.out.println("잘못된 번호를 선택하였습니다! 다시 선택해주세요!");
                continue;
            } else {
                break;
            }
        }
        return select;
    }

}
