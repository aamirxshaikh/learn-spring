package com.demo.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RequestMapping("/user")
@Controller
public class FileController implements ServletContextAware {
    private static final String UPLOAD_DIR = "/uploads";

    private ServletContext servletContext;

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public ModelAndView upload() {
        return new ModelAndView("upload");
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String upload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) throws IOException {
        if(! file.isEmpty()) {
            byte[] bytes = file.getBytes();

            String path = servletContext.getRealPath(UPLOAD_DIR);

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path + File.separator + name)));

            stream.write(bytes);
            stream.close();

            return "File Uploaded Successfully";
        } else {
            return "Cannot upload, File is empty";
        }
    }
}
