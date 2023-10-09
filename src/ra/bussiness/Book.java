package ra.bussiness;

import java.util.Scanner;

public class Book {
    Scanner scanner = new Scanner(System.in);
    private int bookId;
    private static int count = 1;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;

    //constructor

    public Book() {
        this.bookId = Book.count++;
        this.bookStatus=true;

    }

    public Book(String bookName, String author, String descriptions, double importPrice, double exportPrice, boolean bookStatus) {
        this.bookId = Book.count++;
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = (float) calInterest(this.exportPrice,this.importPrice);
        this.bookStatus = true;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }


    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public double calInterest(double exportPrice,double importPrice) {
        return exportPrice - importPrice;
    }

    public void inputData() {
        while (true) {
            System.out.println("Nhâp tên sách");
            this.bookName = scanner.nextLine();
            if (this.bookName.isEmpty()) {
                System.out.println("Tên sách không được để trống, vui lòng nhập lại");
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("Nhập tên tác giả");
            this.author = scanner.nextLine();
            if (this.author.isEmpty()) {
                System.out.println("Tên tác giả không được để trống, vui lòng nhập lại");
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("Nhập mô tả sách");
            this.descriptions = scanner.nextLine();
            if (this.descriptions.isEmpty()) {
                System.out.println("Mô tả sách không được để trống");
            } else {
                if (this.descriptions.length() < 10) {
                    System.out.println("Mô tả sách ít nhất 10 ký tự");
                } else {
                    break;
                }
            }
        }

        while (true) {
            System.out.println("Điền giá nhập");
            this.importPrice = Double.parseDouble(scanner.nextLine());
            if (this.importPrice < 0) {
                System.out.println("Giá nhập phải lớn hơn 0");
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("Điền giá bán");
            this.exportPrice = Double.parseDouble(scanner.nextLine());
            if (this.exportPrice < this.importPrice * 1.2) {
                System.out.println("Giá bán phải lớn hơn 1.2 lần giá nhập");
            } else {
                break;
            }
        }
//
//        System.out.println("Nhập trạng thái sách (true/false)");
//        this.bookStatus = Boolean.parseBoolean(scanner.nextLine());
    }



    //phuong thuc displayData hien thi thong tin tat ca sach
    public void displayData(){
        System.out.println("Sách{" +
                "Mã sách =" + bookId +
                ", Tên sách ='" + bookName + '\'' +
                ", Tác giả ='" + author + '\'' +
                ", Mô tả sách ='" + descriptions + '\'' +
                ", Giá nhập =" + importPrice +
                ", Giá bán =" + exportPrice +
                ", Lợi nhuận =" + calInterest(exportPrice,importPrice) +
                ", Tình trạng sách =" + (bookStatus?"Còn hàng":"Hết hàng") +
                '}');
    }
}
