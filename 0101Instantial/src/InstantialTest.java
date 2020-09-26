import sun.misc.Unsafe;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * 论实例化一个类的方式
 * （1）通过构造方法实例化一个类
 * （2）通过Class实例化一个类
 * （3）通过反射实例化一个类
 * （4）通过克隆实例化一个类
 * （5）通过反序列化实例化一个类
 * （6）通过Unsafe实例化一个类
 *
 */
public class InstantialTest {

    private static Unsafe unsafe;
    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        // 1. 构造方法
        User user1 = new User();
        // 2. Class，里面实际也是反射
        User user2 = User.class.newInstance();
        // 3. 反射
        User user3 = User.class.getConstructor().newInstance();
        // 4. 克隆
        User user4 = (User) user1.clone();
        // 5. 反序列化
        User user5 = unserialize(user1);
        // 6. Unsafe
        User user6 = (User) unsafe.allocateInstance(User.class);

        System.out.println(user1.age);
        System.out.println(user2.age);
        System.out.println(user3.age);
        System.out.println(user4.age);
        System.out.println(user5.age);
        System.out.println(user6.age);
    }

    private static User unserialize(User user1) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\Dev\\object.txt"));
        oos.writeObject(user1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\Dev\\object.txt"));
        // 反序列化
        User user5 = (User) ois.readObject();
        ois.close();
        return user5;
    }

    static class User implements Cloneable, Serializable {
        private int age;

        public User() {
            this.age = 10;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}