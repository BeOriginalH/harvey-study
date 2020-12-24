package thread;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 获取线程信息
 *
 * @author harvey
 * @date 2020/6/16
 */
public class GetThreadInfoDemo{

    public static void main(String[] args) {


        String path = "sss"+File.separator+"ddd"+File.separator+"1.xxx";

        String sftpFilePath = path.substring(0, path.lastIndexOf(File.separator)+1);

        String fileName = path.substring(path.lastIndexOf(File.separator) + 1);
        String replace = sftpFilePath.replace("s", "vv");

        System.out.println(sftpFilePath);
        System.out.println(fileName);
        System.out.println(replace);

    }

}
