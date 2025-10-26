import java.util.Scanner;

import frameworks.desktop.nhan2so.GUINhan2So;
import frameworks.desktop.cong2so.GUICong2So;
import frameworks.desktop.tru2so.GUITru2So;
import frameworks.desktop.chia2so.GUIChia2So;

public class App {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.println("Vui lòng chọn chức năng:");
        System.out.println("  1. Nhân 2 số");
        System.out.println("  2. Cộng 2 số");
        System.out.println("  3. Trừ 2 số");
        System.out.println("  4. Chia 2 số");
        System.out.println("  0. Thoát chương trình");
        System.out.print("Nhập lựa chọn của bạn: ");
        
        try {
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("\nĐang khởi chạy chức năng Nhân 2 số...");
                    new GUINhan2So();
                    break;
                case 2:
                    System.out.println("\nĐang khởi chạy chức năng Cộng 2 số...");
                    new GUICong2So();
                    break;
                case 3:
                    System.out.println("\nĐang khởi chạy chức năng Trừ 2 số...");
                    new GUITru2So();
                    break;
                case 4:
                    System.out.println("\nĐang khởi chạy chức năng Chia 2 số...");
                    new GUIChia2So();
                    break;
                case 0:
                    System.out.println("\nCảm ơn bạn đã sử dụng chương trình!");
                    System.out.println("Chương trình đã thoát.");
                    break;
                default:
                    System.out.println("\nLựa chọn không hợp lệ! Vui lòng chọn từ 0-4.");
            }
        } catch (Exception e) {
            System.out.println("\nLỗi: Vui lòng nhập số nguyên hợp lệ!");
            scanner.nextLine(); // Clear buffer
        }
		scanner.close();
	}
}
