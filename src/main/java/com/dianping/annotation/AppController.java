package com.dianping.annotation;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.commons.io.IOUtils.toByteArray;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-4-8
 * Time: PM3:55
 * To change this template use File | Settings | File Templates.
 */

@Controller
//@RequestMapping("/spring-mvc")
public class AppController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "name", required = false, defaultValue = "soso") String name,  ModelMap model){

        model.put("isOk", true);
        model.put("message", "hello "+name);

        return "hello";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(User user, @RequestParam(value = "name") String name){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("isOk", true);
        modelAndView.addObject("message", "hello " + user.getName() + name);

        return modelAndView;
    }

    @RequestMapping(value = "/ajax/shop/{shopId}", method = RequestMethod.GET)
    public @ResponseBody Shop loadShop(@PathVariable("shopId") int shopId){

        Shop shop = new Shop();
        shop.setShopId(shopId);
        shop.setShopName("云中小雅");
        shop.setAddTime(new Date());

        return shop;
    }

    // Upload single file using Spring Controller
    @RequestMapping(value = "/addShopWithPic", method = RequestMethod.POST)
    public String addShopWithPic(@RequestParam(value = "shopname") String shopname,
                                  @RequestParam(value = "name1") String name1, @RequestParam(value = "file1") MultipartFile file1) throws IOException {

        return "index";
    }

    // Upload multiple file using Spring Controller
    @RequestMapping(value = "/addShopWithPics", method = RequestMethod.POST)
    public String addShopWithPics(@RequestParam(value = "shopname") String shopname,
                                  @RequestParam(value = "name") String[] names, @RequestParam(value = "file") MultipartFile[] files) throws IOException {

        return "index";
    }

    @RequestMapping(value = "/getpic", method = RequestMethod.GET )
    public void getpic(HttpServletResponse response) throws IOException {

        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = webApplicationContext.getServletContext();

        InputStream inputStream = servletContext.getResourceAsStream("/images/thumb3.jpg");

//        final HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.IMAGE_JPEG);
//        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
//        acceptableMediaTypes.add(MediaType.IMAGE_PNG);
//        acceptableMediaTypes.add(MediaType.IMAGE_JPEG);
//        headers.setAccept(acceptableMediaTypes);
//        return new ResponseEntity<byte[]>(IOUtils.toByteArray(inputStream), headers, HttpStatus.CREATED);
        //return ImageIO.read(inputStream);

        //response.setContentType("image/jpeg;charset=utf-8"); // image/png
        FileCopyUtils.copy(inputStream, response.getOutputStream());
        response.flushBuffer();
        inputStream.close();
    }


}
