package com.ecommerce.admin.controller;

import com.ecommerce.library.model.Category;
import com.ecommerce.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.ConstraintViolationException;
import java.security.Principal;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String categories(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("size", categories.size());
        model.addAttribute("title", "Manage Category");
        model.addAttribute("categoryNew", new Category());
        return "categories";
    }

    @PostMapping("/add-category")
    public String add(@ModelAttribute("categoryNew") Category category,Model model, RedirectAttributes attributes) {
        try {
            categoryService.save(category);
            attributes.addFlashAttribute("success", "Added Successfully!!!");
            //System.out.println(category.getName());
            return "redirect:/categories";
        } catch(ConstraintViolationException e) {
            e.printStackTrace();
            attributes.addFlashAttribute("error", "Can't add category because duplicate value!");
            return "redirect:/categories";
        } catch(Exception e) {
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Error server!");
        }
        return "redirect:/categories";
    }

    @RequestMapping(value = "/findById", method = {RequestMethod.PUT, RequestMethod.GET})
    @ResponseBody
    public Category findById(Long id) {
        return categoryService.findById(id);
    }

    @GetMapping("/update-category")
    public String update(Category category, RedirectAttributes attributes) {
        try {
            categoryService.update(category);
            attributes.addFlashAttribute("success", "Update success.");
        } catch(Exception e) {
            attributes.addFlashAttribute("error", "Pls try again late, server have wrong!");
        }
        return "redirect:/categories";
    }

    @RequestMapping(value = "/delete-category", method = {RequestMethod.PUT, RequestMethod.GET})
    public String delete(Long id, RedirectAttributes attributes) {
        try {
            categoryService.deleteById(id);
            attributes.addFlashAttribute("success", "Deleted success");
        } catch(Exception e) {
            attributes.addFlashAttribute("error", "Pls try again late, server have wrong");
        }
        return "redirect:/categories";
    }

    @RequestMapping(value="/enable-category", method = {RequestMethod.PUT, RequestMethod.GET})
    public String enable(Long id, RedirectAttributes attributes) {
        try {
            categoryService.enabledById(id);
            attributes.addFlashAttribute("success", "Enabled success");
        } catch(Exception e) {
            attributes.addFlashAttribute("error", "Pls try again late, server have wrong");
        }
        return "redirect:/categories";
    }

}
