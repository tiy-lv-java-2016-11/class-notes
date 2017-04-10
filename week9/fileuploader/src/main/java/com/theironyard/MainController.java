package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by jeff on 1/23/17.
 */
@Controller
public class MainController {

    @Autowired
    UploadRepository uploadRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model){
        List<Upload> files = uploadRepository.findAll();
        model.addAttribute("files", files);

        return "home";
    }

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public String upload(MultipartFile file, String description) throws IOException {
        File dir = new File("public/files");
        dir.mkdirs();

        File f = File.createTempFile("file", file.getOriginalFilename(), dir);
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(file.getBytes());

        Upload upload = new Upload(description, file.getOriginalFilename(), f.getName());
        uploadRepository.save(upload);

        return "redirect:/";
    }
}
