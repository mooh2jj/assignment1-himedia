import java.util.Scanner;

public class AddressManager {

    private User[] users = null;
    private MenuManager menuManager = null;
    private final int USER_COUNT = 4;

    public AddressManager() {
        users = new User[USER_COUNT];
        users[0] = new User("도성곤", "010-1234-5678", "Seoul");
        users[1] = new User("aaa", "010-1234-5678", "Busan");
        users[2] = new User("bbb", "010-4445-4545", "Daegu");
        users[3] = new User("ccc", "010-5555-5555", "Incheon");
        this.menuManager = new MenuManager();
    }

    /**
     * 프로그램을 실행하는 메서드
     */
    public void run() {

        boolean endFlag = false;

        while (true) {
            menuManager.initMenu();
            int select = menuManager.selectInitMenu();
            switch (select) {
                case MenuManager.LOGIN:
                    if (this.loginProcess()) {
                        addressProcess();
                    }
                    break;
                case MenuManager.EXIT:
                    System.out.println("프로그램을 종료합니다.");
                    endFlag = true;
                    break;
            }

            if (endFlag) {
                return;
            }
        }
    }

    /**
     * 주소록 관리를 담당하는 메서드
     */
    private void addressProcess() {
        boolean endFlag = false;
        while (true) {
            menuManager.addressMenu();
            int select = menuManager.selectAddressMenu();
            switch (select) {
                case MenuManager.ADDRESS_SEARCH:
                    addressSearch();
                    break;
                case MenuManager.ALL_ADDRESS_SEARCH:
                    allAddressSearch();
                    break;
                case MenuManager.LOGOUT:
                    logout();
                    endFlag = true;
                    break;
            }

            if (endFlag) {
                return;
            }
        }
    }

    /**
     * 로그인을 담당하는 메서드
     * 로그인에 성공시 true, 실패시 false를 반환한다.
     * @return
     */
    public boolean loginProcess(){
        Scanner sc = new Scanner(System.in);
        System.out.println("아이디: ");
        String id = sc.nextLine();
        System.out.println("비밀번호: ");
        String pw = sc.nextLine();

        User admin = users[0];

        if (id.equals(admin.getId()) && pw.equals(admin.getPw())) {
            System.out.println("로그인 되었습니다.");
            System.out.println("이름: " + admin.getName() + "님 환영합니다!");
            admin.setLogin(true);
            return true;
        } else {
            System.out.println("로그인 실패하였습니다.");
            return false;
        }
    }

    /**
     * 주소 검색을 담당하는 메서드
     */
    public void addressSearch(){
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("주소 검색을 시작합니다.");
        System.out.print("검색할 유저이름을 입력하세요: ");
        String name = sc.nextLine();
        for (int i = 0; i < users.length; i++) {
            if (name.equals(users[i].getName())) {
                System.out.println("이름: " + users[i].getName());
                System.out.println("전화번호: " + users[i].getPhone());
                System.out.println("주소: " + users[i].getAddress());
                System.out.println();
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("입력하신 유저가 존재하지 않습니다.");
        }

    }

    /**
     * 모든 주소록을 출력하는 메서드
     */
    public void allAddressSearch(){
        for (int i = 1; i < users.length; i++) {
            System.out.println("이름: " + users[i].getName());
            System.out.println("전화번호: " + users[i].getPhone());
            System.out.println("주소: " + users[i].getAddress());
            System.out.println();
        }

    }

    /**
     * 현재의 유저의 로그아웃을 담당하는 메서드
     */
    public void logout(){
        users[0].logout();
        System.out.println("로그아웃 되었습니다.");
    }

}
