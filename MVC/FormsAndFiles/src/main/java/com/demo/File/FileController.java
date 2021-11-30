package com.demo.File;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

    @RequestMapping(value = "/upload-multiple", method = RequestMethod.GET)
    public ModelAndView uploadMultiple() {
        return new ModelAndView("upload-multiple");
    }

    @RequestMapping(value = "/upload-multiple-selection", method = RequestMethod.GET)
    public String uploadMultipleSelection(Model model) {
        model.addAttribute("uploads", new com.demo.File.File());

        return "upload-multiple-selection";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public String download() {
        return "download";
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

    @RequestMapping(value = "/upload-multiple", method = RequestMethod.POST)
    public @ResponseBody String uploadMultiple(@RequestParam("name") String[] names, @RequestParam("file") MultipartFile[] files) throws IOException {
        String message = "";

        if(names.length != files.length) {
            return "Please provide all files and names";
        }

        for(int i = 0; i < files.length; i ++) {
            String name = names[i];
            MultipartFile file = files[i];

            byte[] bytes = file.getBytes();

            String path = servletContext.getRealPath(UPLOAD_DIR);

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path + File.separator + name)));

            stream.write(bytes);
            stream.close();

            message += "File Uploaded Successfully " + name;
        }

        return message;
    }

    @RequestMapping(value = "/upload-multiple-selection", method = RequestMethod.POST)
    public String uploadMultipleSelection(HttpServletRequest servletRequest, @ModelAttribute com.demo.File.File uploads, Model model) {
        List<String> names = new ArrayList<String>();
        List<MultipartFile> files = uploads.getFiles();

        if(files != null && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
                String name = multipartFile.getOriginalFilename();
                names.add(name);

                File file = new File(servletRequest.getServletContext().getRealPath("/uploads"), name);

                try {
                    multipartFile.transferTo(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        model.addAttribute("uploads", uploads);

        return "upload-multiple-selection-details";
    }

    @RequestMapping(value = "download", method = RequestMethod.POST)
    public void download(HttpServletRequest request, HttpServletResponse response, Model model) {
        String name = request.getParameter("name");

//        printed as log

        System.out.println("Downloading.." + name);

        String path = servletContext.getRealPath(UPLOAD_DIR);

        Path file = Paths.get(path, name);

        if(Files.exists(file)) {
            String extension = FilenameUtils.getExtension(name);

            switch(extension.toLowerCase()) {
                case "pdf":
                    response.setContentType("application/pdf");
                    break;
                case "jpeg":
                    response.setContentType("image/jpeg");
                    break;
                case "jpg":
                    response.setContentType("image/jpg");
                    break;
                case "png":
                    response.setContentType("image/png");
                    break;
                default:
                    break;
            }

            response.addHeader("Content-Disposition", "attachment; filename=" + name);

            try {
                Files.copy(file, response.getOutputStream());

                response.getOutputStream().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
