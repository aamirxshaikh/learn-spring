package com.demo.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
public class FileController {
    private static final String UPLOAD_DIR = "/uploads";

    @RequestMapping("/upload")
    public ModelAndView upload() {
        return new ModelAndView("upload");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam CommonsMultipartFile file, HttpSession session) throws IOException {
        ServletContext context = session.getServletContext();

        String path = context.getRealPath(UPLOAD_DIR);

        System.out.println(path);

        byte[] bytes = file.getBytes();

        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path + File.separator + file.getOriginalFilename())));

        stream.write(bytes);
        stream.flush();
        stream.close();

        return new ModelAndView("upload", "success", "File Uploaded Successfully");
    }
}
