import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<Message> messages = new ArrayList<>();
        String userName;

        while(true){
            userName = InputData.getString(sc,"Nhập tên người gửi ( hoặc nhập exit để thoát ): ");

            if(userName.equalsIgnoreCase("exit")){
                // thoat chuong trinh
                System.exit(0);
            } else {
                // nhap noi dung tin nhan
                String noidung = InputData.getString(sc, "Nhập nội dung tin nhắn: ");

                // them vao danh sach
                messages.add(new Message(userName,noidung,LocalDate.now()));


                String question = InputData.getString(sc, "Nhập \"history\" để xem lịch sử, Nhập \"filter\" để lọc tin nhắn người gửi, Hoặc \"date\" để lọc theo ngày: ");

                switch(question){
                    case "history":
                        // neu nhap history se xuat danh sach tin nhan
                        messages.forEach(System.out::println);
                        break;

                    case "filter":
                        // neu nhap filter thi loc nguoi nhan
                        String sender = InputData.getString(sc,"Nhập tên người gửi để lọc: ");

                        // cho vong lap qua cac phan tu xem co trung nguoi nhan khong thi xuat ra
                        messages.forEach((e) -> {
                            if(e.getSender().equals(sender)){
                                System.out.println(e);
                            }
                        });
                        break;
                    case "date":
                        // cho nguoi dung nhap ngay can lap
                        String searchDate = InputData.getString(sc,"Nhập ngày (dd-MM-yyyy): ");
                        try{

                            List<Message> listDate = new ArrayList<>();

                            messages.forEach((e) -> {
//                                LocalDate smgDate = LocalDate.parse(e.getTimestamp(),dateFormat);
                                if(e.getTimestamp().format(dateFormat).equals(searchDate)){
                                    listDate.add(e);
                                }
                            });

                            if(listDate.isEmpty()){
                                System.out.println("Khong co lich su tin nhan trong ngay !");
                            } else {
                                listDate.forEach(System.out::println);
                            }
                        } catch (Exception e){
                            System.out.println("Dinh dang ngay khong hop le !");
                        }
                        break;
                    default:
                        System.out.println("Nhap sai du lieu !");

                }
            }
        }
    }
}


















//                if(question.equalsIgnoreCase("history")){
//                    // neu nhap history se xuat danh sach tin nhan
//                    messages.forEach(System.out::println);
//                } else if(question.equalsIgnoreCase("filter")){
//                    // neu nhap filter thi loc nguoi nhan
//                    String sender = InputData.getString(sc,"Nhập tên người gửi để lọc: ");
//
//                    // cho vong lap qua cac phan tu xem co trung nguoi nhan khong thi xuat ra
//                    messages.forEach((e) -> {
//                        if(e.getSender().equals(sender)){
//                            System.out.println(e);
//                        }
//                    });
//                } else if(question.equalsIgnoreCase("date")){
//                    // neu nhap date thi loc theo ngay va xuat tn ngay do
//                    String searchDate = InputData.getString(sc,"Nhập ngày (dd-MM-yyyy): ");
//                    messages.forEach((e) -> {
//                        if(e.getTimestamp().equals(searchDate.){}
//                    })
//                }
//            }
