import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String,Integer> grades = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("選單：");
            System.out.print("1. 新增學生成績, ");
            System.out.print("2. 查詢學生成績, ");
            System.out.print("3. 修改學生成績, ");
            System.out.print("4. 刪除學生成績, ");
            System.out.print("5. 列出所有學生成績, ");
            System.out.println("0. 離開");

            System.out.print("請選擇操作：");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addGrade(grades, scanner);
                    break;
                case 2:
                    queryGrade(grades, scanner);
                    break;
                case 3:
                    modifyGrade(grades, scanner);
                    break;
                case 4:
                    deleteGrade(grades, scanner);
                    break;
                case 5:
                    printGrades(grades);
                    break;
                case 0:
                    running = false;
                    System.out.println("程式已退出。");
                    break;
                default:
                    System.out.println("無效選擇，請重新選擇。");
                    break;
            }
        }

        scanner.close();
    }
    private static void addGrade(Map<String,Integer> grades, Scanner scanner) {
        System.out.print("請輸入要新增的學生名稱：");
        String studentName = scanner.nextLine();
        System.out.print("請輸入要新增的學生成績：");
        int grade = scanner.nextInt();
        scanner.nextLine(); // 消耗換行符
        grades.put(studentName, grade);
        System.out.println("新增成功！");
    }

    // 查詢學生成績
    private static void queryGrade(Map<String,Integer> grades, Scanner scanner) {
        System.out.print("請輸入要查詢成績的學生名稱：");
        String studentName = scanner.nextLine();
        if (grades.containsKey(studentName)) {
            System.out.println(studentName + "的成績是：" + grades.get(studentName));
        } else {
            System.out.println("沒有找到" + studentName + "的成績");
        }
    }
    private static void modifyGrade(Map<String,Integer> grades, Scanner scanner) {
        System.out.print("請輸入要修改成績的學生名稱：");
        String studentName = scanner.nextLine();
        if (grades.containsKey(studentName)) {
            System.out.print("請輸入" + studentName + "的新成績：");
            int newGrade = scanner.nextInt();
            scanner.nextLine(); // 消耗換行符
            grades.put(studentName, newGrade);
            System.out.println(studentName + "的成績已修改為：" + newGrade);
        } else {
            System.out.println("沒有找到" + studentName + "的成績，無法修改");
        }
    }

    // 刪除學生成績
    private static void deleteGrade(Map<String,Integer> grades, Scanner scanner) {
        System.out.print("請輸入要刪除成績的學生名稱：");
        String studentName = scanner.nextLine();
        if (grades.containsKey(studentName)) {
            grades.remove(studentName);
            System.out.println(studentName + "的成績已刪除");
        } else {
            System.out.println("沒有找到" + studentName + "的成績，無法刪除");
        }
    }
    private static void printGrades(Map<String,Integer> grades) {
        System.out.println("所有學生成績列表：");
        for (Map.Entry<String,Integer> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue() + "分");
        }
    }
}