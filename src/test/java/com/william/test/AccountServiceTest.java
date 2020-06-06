package com.william.test;


import com.william.domain.Account;
import com.william.service.IAccountService;
import config.SpringConfigruation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit测试我们的配置
 *
 * Spring整合junit的配置：
 *      1.导入spring整合junit的jar包（pom.xml中配置）
 *      2.使用Junit提供的注解@Runwith把原有的main方法替换了，替换成spring提供的
 *      3.告知spring运行期，spring的ioc创建时基于xml的还是基于注解的，并且说明位置
 *              @ContextConfiguration
 *                      location:指定xml的文件位置，加上classpath关键字，标识在类路径下
 *                      classes:指定注解类所在位置
 *
 *
 *    当我们使用spring 5.x版本的时候，spring要求junit的jar包必须是4.12以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfigruation.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService ;


    @Test
    public void testFindAll() {
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfigruation.class);
//        IAccountService accountService = ac.getBean("accountService",IAccountService.class);
        List<Account> accounts = accountService.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindById() {
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfigruation.class);
//        IAccountService accountService = ac.getBean("accountService",IAccountService.class);
        Account account = accountService.findById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfigruation.class);
//        IAccountService accountService = ac.getBean("accountService",IAccountService.class);
        Account account = new Account();
        account.setId(4);
        account.setName("林作亮");
        account.setMoney(10000f);
        accountService.saveAccount(account);
        //System.out.println(account);
    }

    @Test
    public void testUpdate() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfigruation.class);
//        IAccountService accountService = ac.getBean("accountService",IAccountService.class);
        Account account = accountService.findById(4);
        account.setMoney(222222f);
        accountService.updateAccount(account);
    }

    @Test
    public void testDelete() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfigruation.class);
//        IAccountService accountService = ac.getBean("accountService",IAccountService.class);

        accountService.deteleAccount(4);
    }
}
