import java.util.UUID;

public class uuid {
    public static void main(String[] args) {
//        数据库主键使用UUID生成唯一标识
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        str = str.replace("-","");
        System.out.println(str);
        System.out.println(str.length());
    }
}
