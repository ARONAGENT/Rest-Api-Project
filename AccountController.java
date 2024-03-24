package com.RestApi.SpringRestApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RestApi.SpringRestApi.Entities.Account;
import com.RestApi.SpringRestApi.Services.AccountServices;

@RestController
@RequestMapping("/restapi")
public class AccountController {
	
	@Autowired
	private AccountServices accServ;

	
	@GetMapping("/hello")
	public String test()
	{
		return "RestApi Spring Project Working Successfully";
	}

	@GetMapping("/allaccounts")
	public List<Account> allacc()
	{
		return accServ.getAllAccounts();
	}
	
	@GetMapping("/findbyaccno/{accno}")
	public Account findacc(@PathVariable int accno)
	{
		return accServ.searchaccount(accno);
	}
	
	@GetMapping("/findbyacctype/{acctype}")
	public List<Account> findacctype(@PathVariable String acctype)
	{
		return accServ.getacctype(acctype);
	}
	

	@PostMapping("/addaccount")
	public Account addAccount(@RequestBody Account acc)
	{
		return accServ.openAccount(acc);
	}
	
	@PutMapping("/updateAccount")
	public String depositacc(@RequestParam int accno,@RequestParam float balance)
	{
		String update=accServ.updateAccount(accno, balance);
		return update;
	}
	
	@DeleteMapping("/deleteAccount")
	public String delacc(@RequestParam int accno)
	{
		return accServ.removeAcc(accno);
		
	}
}
