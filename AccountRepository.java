package com.RestApi.SpringRestApi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestApi.SpringRestApi.Entities.Account;

public interface AccountRepository extends JpaRepository<Account,Integer > {
 Account findByAccno(int accno);
List<Account> findByAcctype(String acctype);
}
