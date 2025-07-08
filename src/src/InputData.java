import java.util.Scanner;

public class InputData {
    public static String getString(Scanner sc, String suggest){
        String message = "";
        while(true){
            System.out.println(suggest);
            message = sc.nextLine();
            if(message.isEmpty()){
                System.out.println("Please enter your message");
            } else {
                break;
            }
        }
        return message;
    }

}
