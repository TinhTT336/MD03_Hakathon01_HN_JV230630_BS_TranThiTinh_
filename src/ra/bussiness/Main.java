package ra.bussiness;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Book[] arrBook = new Book[100];

    static {
        arrBook[0] = new Book("Ông già và biển cả", "HW", "Ông già và biển cả...", 46000, 63000, true);
        arrBook[1] = new Book("Con mèo dạy hải âu bay", "HHHH", "Con mèo dạy hải âu bay...", 44000, 59000, true);
        arrBook[2] = new Book("Triệu phú khu ổ chuột", "WWWW", "Triệu phú khu ổ chuột...", 76000, 99000, true);
        arrBook[3] = new Book("Cây gậy và củ cà rốt", "AAA", "Cây gậy và củ cà rốt...", 56000, 70000, true);
    }

    static int index = 4;

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. Thoát");

            System.out.println("*******************************");
            System.out.println("Nhập lựa chọn của bạn (1-7)");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayAllBooks();
                    break;
                case 3:
                    sortByInterestIncrease();
                    break;
                case 4:
                    deleteByBookId();
                    break;
                case 5:
                    findBookByBookName();
                    break;
                case 6:
                    editBookByBookId();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Không có chức năng tương ứng với lựa chọn của bạn, vui lòng nhập lại");
                    break;

            }
        } while (true);
    }

    private static void editBookByBookId() {
        System.out.println("Nhập mã sách muốn chỉnh sửa");
        int editId = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < index; i++) {
            if (arrBook[i].getBookId() == editId) {
                arrBook[i].displayData();
                arrBook[i].inputData();
                return;
            }
        }
        System.out.println("Không tìm thấy sách với mã vừa nhập");
    }

    private static void findBookByBookName() {
        System.out.println("Nhập tên sách muốn tìm");
        String bookName = scanner.nextLine();

        for (int i = 0; i < index; i++) {
            if (arrBook[i].getBookName().toUpperCase().contains(bookName.toUpperCase())) {
                arrBook[i].displayData();
                return;
            }
        }
        System.out.println("Không tìm thấy sách với tên sách vừa nhập");
    }

    private static void deleteByBookId() {
        System.out.println("Nhập mã sách muốn xoá");
        int deleteId = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < index; i++) {
            if (arrBook[i].getBookId() == deleteId) {
                for (int j = i; j < index; j++) {
                    arrBook[j] = arrBook[j + 1];
                }
                System.out.println("Xoá thành công sách có mã sách " + deleteId);
                index--;
                return;
            }
        }
        System.out.println("Không tìm thấy sách với mã vừa nhập");
    }

    private static void sortByInterestIncrease() {
        for (int i = 0; i < index-1; i++) {
            for (int j = i+1; j < index; j++) {
                if (arrBook[i].getInterest() > arrBook[j].getInterest()) {
                    Book temp = arrBook[i];
                    arrBook[i] = arrBook[j];
                    arrBook[j] = temp;
                }
            }
        }
        System.out.println("Danh sách sau khi sắp xếp");
        for (int i = 0; i < index; i++) {
            arrBook[i].displayData();

        }
        System.out.println();


    }

    private static void displayAllBooks() {
        System.out.println("Danh sách tất cả sách hiện có");
        for (int i = 0; i < index; i++) {
            arrBook[i].displayData();
        }
        System.out.println();
    }

    private static void addBook() {
        System.out.println("Nhập số lượng sách muốn thêm mới");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Thêm mới sách thứ " + (i + 1));
            arrBook[index] = new Book();
            arrBook[index].inputData();
            index++;
            System.out.println("Thêm mới sách thành công");
            System.out.println();
        }
    }
}
