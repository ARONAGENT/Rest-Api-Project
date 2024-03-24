package com.RestApi.SpringRestApi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestApi.SpringRestApi.Entities.Account;
import com.RestApi.SpringRestApi.Repository.AccountRepository;

@Service
public class AccountServices {
	
	@Autowired
	private AccountRepository accRepo;
	
	public List<Account> getAllAccounts()
	{
		List <Account> acclist=accRepo.findAll();
		return acclist;
	}
	 
	public Account searchaccount(int accno)
	{
		return accRepo.findByAccno(accno); 
	}

	public List<Account> getacctype(String acctype)
	{
		List<Account> acctypelist=accRepo.findByAcctype(acctype);		
		return acctypelist;
	}
	
	public Account openAccount(Account obj)
	{
		return accRepo.save(obj);
	}
	
	public String updateAccount(int accno,float balance)
	{
		Account obj=accRepo.findByAccno(accno);
		obj.setBalance(obj.getBalance()+balance);
		accRepo.save(obj);
		return "Update Successfully";
	}
	
	public String removeAcc(int accno)
	{
		Account obj=accRepo.findByAccno(accno);
		String status="";
		if(obj!=null)
		{
			accRepo.delete(obj);
			status="Account delete successfully";
		}
		else
		{
			status="failed! Invalied Account No ";
		}
			
		return status;
	}
}
