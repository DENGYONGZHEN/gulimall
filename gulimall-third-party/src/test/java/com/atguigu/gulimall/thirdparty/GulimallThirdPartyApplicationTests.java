package com.atguigu.gulimall.thirdparty;


import com.aliyun.oss.OSSClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallThirdPartyApplicationTests {

    @Autowired
    OSSClient ossClient;

    /**
     * 文件上传步骤
     * 1、引入starter，具体引入在common模块
     * 2、在yml配置文件中配置相关的key，secret以及endpoint信息
     * 3、使用OSSClient进行相关操作
     * @throws FileNotFoundException
     */
    @Test
    public void testUpload()throws FileNotFoundException{
        InputStream inputStream = new FileInputStream("D:\\photo.jpg");
        ossClient.putObject("gulimall-tokyo","1.jpg",inputStream);
        ossClient.shutdown();
        System.out.println("上传成功");
    }

}
