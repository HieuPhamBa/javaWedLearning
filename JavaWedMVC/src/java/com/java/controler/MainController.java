/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.controler;

import com.java.Beans.Books;
import com.java.Model.BooksModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author PhamBaHieu
 */
@Controller
public class MainController {
    @RequestMapping(value = "Trang-chu", method = RequestMethod.GET)
    public String HomePagesController(ModelMap model){
        BooksModel bkm = new BooksModel();
        List<Books> lst = new ArrayList<>();
        lst = bkm.loadAll();
        model.addAttribute("BookInfor", new Books());
        model.addAttribute("BookLst", lst);
        model.addAttribute("id", "");
        return "Views/HomePages";
    }
    
    @RequestMapping("Delete.htm")
    public String DeleteBooksController(@ModelAttribute("id") int id, ModelMap model){
        BooksModel bkm = new BooksModel();
        bkm.DeleteBooks(id);
        return "index";
    }
    
    
    
    
}
