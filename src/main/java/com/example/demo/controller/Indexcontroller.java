package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Repo.CompetitionRepo;
import com.example.demo.Repo.CompetitionRepocompi;
import com.example.demo.Repo.ParticipantRegcompi;
import com.example.demo.model.CompetitionReg;
import com.example.demo.model.ParticipantReg;
import com.example.demo.model.User;

@Controller
public class Indexcontroller {
	
	@Autowired
	CompetitionRepo comprepo;
	@Autowired
	CompetitionRepocompi compirepo;
	@Autowired
	ParticipantRegcompi participantrepo;
	
	@PostMapping("/competition")
	public String userCompetition(@ModelAttribute CompetitionReg creg,Model model,@RequestParam("file") MultipartFile file)
	{
		System.out.print("Data..... : "+creg.getCity());
		
		
		
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			creg.setData(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		CompetitionReg reg = this.compirepo.save(creg);
		User user1 = comprepo.findById(creg.getMobileno()).get();
		
		user1.setHeld(user1.getHeld()+","+reg.get_id());
		
		comprepo.save(user1);
		
		return "registration_form";
	}
	
	
	@GetMapping("/myapplied/{id}")
	public String myapplied(Model model,@PathVariable String id)
	{
		User user1 = comprepo.findById(id).get();
		
		String[] res = user1.getApplied().split("[,]",0);
		Iterable<String> res5 = Arrays.asList(res);
		
		model.addAttribute("users",compirepo.findAllById(res5));
		return "myapplied";
	}
	
	
	@GetMapping("/applied/{id}")
	public String checkapplied(Model model,@PathVariable String id)
	{
		User user1 = comprepo.findById(id).get();
		//model.addAttribute("user",whoapp);
		
		
 		String[] res = user1.getHeld().split("[,]",0);
 		
 		Iterable<String> res5 = Arrays.asList(res);
 		
 		model.addAttribute("users",compirepo.findAllById(res5));
		
		/*
		String[] res1 = new String[res.length];
		String[] res2 = new String[res.length];
		
		class Abc
		{
			String name;
			String applied; 
		}
		
		List<Abc> res3 = new ArrayList<Abc>();
		*/
		
		for(int i=0;i<res.length;i++)
		{
			model.addAttribute("users",compirepo.findAllById(res5));
			/*
			CompetitionReg reg = compirepo.findById(res[i]).get();
			Abc a = new Abc();
			a.name = reg.getCompiname();
			a.applied = reg.getMobileno();
			
			res1[i] = reg.getCompiname();
			res2[i] = reg.getApplied();
			res3.add(a);
			*/
		}
		
		/*
		
		for(Abc b:res3)
		{
			System.out.print(b.name);
		}
		*/
		//List<String> res1 = Arrays.asList(res);
 		//model.addAttribute("users",res1);
 		//model.addAttribute("users1",res2);
		return "whoapplied";
	}
	
	@GetMapping("/apply/{id}/{id1}")
	public ResponseEntity<String> applycompi(Model model,@PathVariable String id,@PathVariable String id1)
	{
		User user1 = comprepo.findById(id).get();
		user1.setApplied(user1.getApplied()+","+id1);
		comprepo.save(user1);
		System.out.print("User1234 "+id1);
		CompetitionReg coreg = compirepo.findById(id1).get();
		coreg.setApplied(coreg.getApplied()+","+id);
		compirepo.save(coreg);
		return ResponseEntity.ok("Applied");
	}
	
	
	@GetMapping("/list")
	public String listofcompitition(Model model)
	{
		System.out.print("Data ===="+compirepo.findAll());
		model.addAttribute("users",compirepo.findAll());
		return "showcompi";
	}
	
	@GetMapping("/home")
	public String homepage(Model model)
	{
		model.addAttribute("users",compirepo.findAll());
		return "home";
	}
	
	@GetMapping("/signup")
	public String usignup(@ModelAttribute ParticipantReg creg,Model model)
	{
		System.out.print(creg);
		return "signup";
	}
	
	@PostMapping("/preg")
	public String preg(@ModelAttribute ParticipantReg preg,Model model)
	{
		System.out.print(preg);

			ParticipantReg reg = this.participantrepo.save(preg);
			return "registration_form";
	}
	
	
	
	@GetMapping("/xyz/{id}")
	public String uCompetition(@ModelAttribute CompetitionReg creg,Model model,@PathVariable String id)
	{
		System.out.print("Mobile no"+id);
		model.addAttribute("mobno",id);
		return "registration_form";
	}
	
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	@GetMapping("/viewdetail/{id}")
	public String viewdetails(@PathVariable String id,Model model)
	{
		model.addAttribute("competition",compirepo.findById(id).get());
		System.out.println("Object : "+compirepo.findById(id).get());
		return "Viewdetail";
	}
	
	@PostMapping("/login")
	public String userRegistration(@ModelAttribute User user,Model model)
	{
		System.out.print(user.toString());
		model.addAttribute("username", user.getUname());
		model.addAttribute("password", user.getPass());
		
		String username = user.getUname();
		User user1 = comprepo.findById(username).get();
		String pwd = user1.getPass();
		System.out.print("user : "+username+"pass : "+pwd);
		
		if(user.getPass().equals(pwd))
		{
			model.addAttribute("userno",user1);
			model.addAttribute("users",compirepo.findAll());
			return "home";
		}
		else
		{
			return "index";
		}
		
	}
	
	
	@PostMapping("/")
	public ResponseEntity<?> addUser(@RequestBody User user)
	{
		User save = this.comprepo.save(user);
		return ResponseEntity.ok(save);
	}
	
	@GetMapping("/abc")
	public String getUser(Model model)
	{
		model.addAttribute("compuser",this.comprepo.findAll());
		//return ResponseEntity.ok(this.comprepo.findAll());
		return "homepage";
	}
	
	
	
	
	
	

}
