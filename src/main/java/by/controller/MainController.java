package by.controller;

import by.service.AnalyzerTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Controller
public class MainController {
    @Autowired
    private AnalyzerTextService analyzerTextService;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String main(){
        return "index";
    }
    @RequestMapping(value = "/check",method = RequestMethod.POST,params = "brackets")
    public String checkBrackets(@RequestParam("file")MultipartFile file,Model model) throws IOException {
        loadFile(file);
        String s=analyzerTextService.check(file.getOriginalFilename());
        model.addAttribute("s",s);
        return "index";
    }
    @RequestMapping(value = "/check",method = RequestMethod.POST,params = "words")
    public String checkFile(@RequestParam("file")MultipartFile file,Model model) throws IOException {
        loadFile(file);
        List<String> list=analyzerTextService.analyzer(file.getOriginalFilename());
        model.addAttribute("list",list);
        return "index";
    }
    public void loadFile(MultipartFile file) throws IOException {//This method loads a file
        byte[] bytes = file.getBytes();
        File newFile=new File("C:\\Users\\HP\\IdeaProjects\\RestSpringTokinaizer\\"+file.getOriginalFilename());
        newFile.createNewFile();
        BufferedOutputStream stream =
                new BufferedOutputStream(new FileOutputStream(newFile));
        stream.write(bytes);
        stream.close();
    }
}
