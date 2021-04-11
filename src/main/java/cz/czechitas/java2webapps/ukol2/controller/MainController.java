package cz.czechitas.java2webapps.ukol2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView citatDne() throws FileNotFoundException {

        String citatText;
        List<String> citatyDneSeznam = new ArrayList<>();
        List<String> obrazkyDneSeznam = new ArrayList<>();

        citatyDneSeznam = Arrays.asList("Největší chyba, kterou v životě můžete udělat, je mít pořád strach, že nějakou uděláte" +
                "", "Úspěch není konečný, neúspěch není fatální: odvaha pokračovat je to, co se počítá" +
                "", "Cesta k úspěchu a cesta k neúspěchu jsou téměř přesně stejné" +
                "", "Nebojte se vzdát dobrého kvůli skvělému" +
                "", "Nepokoušejte se stát úspěšnou osobou, ale raději se pokuste stát se hodnotnou osobou." +
                "", "Přestaňte se honit za penězi a začněte se honit za vášní." +
                "", "Úspěch je chůze od neúspěchu k neúspěchu bez ztráty nadšení." +
                "", "Pokud nejste ochotni mimořádně riskovat, musíte se spokojit s obyčejností." +
                "", "Veškerý pokrok se děje mimo zónu komfortu." +
                "", "Soustřeďte se na to, kam chcete jít, nikoli na to, čeho se bojíte.");

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


}
