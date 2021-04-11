package cz.czechitas.java2webapps.ukol2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView citatDne() throws IOException {

        String citatText;
        List<String> citatyDneSeznam = new ArrayList<>();
        citatyDneSeznam = readAllLines("citaty.txt");
        List<String> obrazkyDneSeznam = new ArrayList<>();

        obrazkyDneSeznam = Arrays.asList("CgyrwbE6Hm4","sKJ7zSylUao","MVr6pgZzlbY","YnNczu62rdk","JdjdIjzJl94","Jdem_eQTHTQ" +
                "","k88qpEjVJ1k","JdPHvI7VF0o","tuIedADlL_Q","d1RHYJ09Ur0");

        Random generatorCísla = new Random();
        int nahodneCisloCitaty = generatorCísla.nextInt(citatyDneSeznam.size());
        citatText = citatyDneSeznam.get(nahodneCisloCitaty);

        int nahodneCisloObrazky = generatorCísla.nextInt(obrazkyDneSeznam.size());
        String nahodnyObrazek = obrazkyDneSeznam.get(nahodneCisloObrazky);

        ModelAndView result = new ModelAndView("index");
        result.addObject("citatText", citatText);
        result.addObject("citatObrazek","background-image: url(https://source.unsplash.com/" +
                ""+nahodnyObrazek+"/1600x900)");
        return result;
    }

    private static List<String> readAllLines(String resource)throws IOException{
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
        try(InputStream inputStream=classLoader.getResourceAsStream(resource);
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))){
            Stream<String> streamRadku = reader.lines();
            List <String> listString = streamRadku.collect(Collectors.toList());

            return listString;
        }
    }

}
