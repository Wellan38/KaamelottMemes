/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexandre.kaamelottmemes.main;

import alexandre.kaamelottmemes.model.*;
import alexandre.kaamelottmemes.service.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandre
 */
public class Main
{
    public static void main(String[] args) throws Throwable
    {
//        List<String> tags = new ArrayList<>();
//        tags.add("C'est compliqué, mais c'est compliqué !");
//        tags.add("Perceval");
//        tags.add("Karadoc");
//        
//        Meme m = new Meme("https://scontent-cdg2-1.xx.fbcdn.net/v/t1.0-9/14691147_959823150806303_5424949022419471602_n.jpg?oh=02472c789a34f54557de5c8f1bd59fdc&oe=58DFF13F", tags);
//        
//        Boolean res = Service.createMeme(m);
//        
//        System.out.println(res);
        
        Meme m = Service.findMemeByLink("https://scontent-cdg2-1.xx.fbcdn.net/v/t1.0-9/14691147_959823150806303_5424949022419471602_n.jpg?oh=02472c789a34f54557de5c8f1bd59fdc&oe=58DFF13F");
        
        System.out.println(Service.removeMeme(m));
    }
}
