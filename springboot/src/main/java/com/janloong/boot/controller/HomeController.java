package com.janloong.boot.controller;

import com.janloong.boot.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * des: 描述xxx
 * <p>
 * 详细描述
 *
 * @author Janloong
 * @date 2017 -12-27 19:07
 */
@RestController
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * des: 描述
     * <p>
     * 详细描述
     *
     * @param user       用户
     * @param merchantId 商户id
     * @return the
     * @throws Exception 某异常
     * @author Janloong
     * @date 2017 -12-27 19:00
     */
    @RequestMapping("test11")
    public @ResponseBody
    User getddd(User user, @NotNull(message = "") String merchantId) throws Exception {

        logger.info("\nd - : " + "\n"
                + "user:" + user + "\n"
                + "merchantId:" + merchantId + "\n"
        );
        return user;
    }

    /**
     * des:
     *
     * @author Janloong
     * @date 2017-12-27 19:06
     **/
    @RequestMapping("test12")
    public @ResponseBody
    List<User> getdddd(List<User> user) {
        logger.info("\n-HomeController-getdd：" + "\n"
                + "user:" + user + "\n"
        );
        return user;
    }

    @RequestMapping("test1")
    public @ResponseBody
    String getdd(@RequestBody String user) {
        logger.info("\n-HomeController-getdd：" + "\n"
                + "user:" + user + "\n"
        );
        return user;
    }

    @RequestMapping("test2")
    public @ResponseBody
    User getdd2(@RequestBody User user) {
        logger.info("\n-HomeController-getdd：" + "\n"
                + "user:" + user + "\n"
        );
        return user;
    }


    @RequestMapping("test3")
    public @ResponseBody
    List<User> getdd22(@RequestBody List<User> user) {
        logger.info("\n-HomeController-getdd：" + "\n"
                + "user:" + user + "\n"
        );
        return user;
    }

    @RequestMapping(value = "test4")
    public @ResponseBody
    User getdd21(@RequestBody User user, @RequestBody String iid) {
        logger.info("\n-HomeController-getdd：" + "\n"
                + "user:" + user + "\n"
                + "iid:" + iid + "\n"
        );
        return user;
    }

    @RequestMapping("test5")
    public @ResponseBody
    List<User> getdd22d(@RequestBody List<User> user, String iid) {
        logger.info("\n-HomeController-getdd：" + "\n"
                + "user:" + user + "\n"
                + "iid:" + iid + "\n"
        );
        return user;
    }


    @RequestMapping("test6")
    public @ResponseBody
    String getdd22da(@RequestBody Map<String, String> map) {
        logger.info("\n-HomeController-getdd：" + "\n"
                + "map:" + map.toString() + "\n"
        );
        return map.toString();
    }

    /*分隔符----------------------------------------------*/
    @RequestMapping("test7")
    public @ResponseBody
    String getdd22daa(@RequestParam String name, @RequestParam Map<String, String> map, @RequestParam String na) {
        logger.info("\n-HomeController-getdd：" + "\n"
                + "map1:" + name + "\n"
                + "map2:" + map.toString() + "\n"
                + "map3:" + na + "\n"
        );
        return map.toString();
    }

    @RequestMapping("test77")
    public @ResponseBody
    String getdd22daa(@RequestParam Map<String, String> map) {
        logger.info("\n-HomeController-getdd：" + "\n"
                + "map2:" + map.toString() + "\n"
        );
        return map.toString();
    }

    @RequestMapping("test777")
    public @ResponseBody
    String getdd22daa(@RequestParam String name, @RequestParam String na) {
        logger.info("\n-HomeController-getdd：" + "\n"
                + "map2:" + name + "\n"
                + "map2:" + na + "\n"
        );
        return name;
    }

    //@RequestMapping(value = "test8",consumes = "Content-Type:application/json")
    @RequestMapping(value = "test8", consumes = "application/json")
    public @ResponseBody
    String getdd22daa(@RequestParam List<User> users) {
        logger.info("\n-HomeController-getdd：" + "\n"
                + "map:" + users.toString() + "\n"
        );
        //return ResultUtil.success("a");
        //throw new BussinesException(ResultEnum.PRIMARY_SCHOOL);

        return users.toString();
    }
}
