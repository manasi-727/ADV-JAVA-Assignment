package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.demo.dao.Product;
import com.demo.dao.ProductImp;
//import com.demo.model.Product;

public class ProductServiceImp implements ProductService{
   private Product pdao;

   public ProductServiceImp() {
	//this.pdao = new ProductImp();
   }
   @Override
	public boolean addNewProduct() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter pid");
		int pid=sc.nextInt();
		System.out.println("enetr name");
		String nm=sc.next();
		System.out.println("enter qty");
		int qty=sc.nextInt();
		System.out.println("enter price");
		double pr=sc.nextDouble();
		System.out.println("enetr mfg date (dd/mm/yyyy)");
		String dt=sc.next();
		LocalDate ldt=LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		//Product p=new Product(pid,nm,qty,pr,ldt);
		return pdao.saveProduct(pr);
		
	}


   @Override
   public List getAll() {
	return pdao.findAll();
   }
   
}