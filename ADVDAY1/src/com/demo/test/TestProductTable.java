package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.model.Product;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImp;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImp;

public class TestProductTable {

	public static void main(String[] args) {
		//Check user is valide or not
		Scanner sc=new Scanner(System.in);
		System.out.println("User name :");
		String uname=sc.next();
		System.out.println("Enter Password :");
		String passwd=sc.next();
		LoginService lservice=new LoginServiceImp();
		ProductService pservice=new ProductServiceImp();
		String role=lservice.validateUser(uname,passwd);
		if(role!=null) {
					if(role.equals("admin")) {
						System.out.println("you are admin");
						int choice=0;
						do {
						//display menu for crud application
						System.out.println("1. Add new Product\n2. Delete product by id\n3. Update product by id");
						System.out.println("4. Display All\n 5. Display by id \n 6. display in sorted order\n 7.exit\n Choice :");
						choice=sc.nextInt();
						switch(choice) {
						case 1->{
							boolean status=pservice.addNewProduct();
							if(status) {
								System.out.println("product aadded successfully");
							}else {
								System.out.println("error occured");
							}
						}
						case 2->{}
						case 3->{}
						case 4->{
							List<Product> plist=pservice.getAll();
							plist.forEach(System.out::println);
						}
						case 5->{}
						case 6->{}
						case 7->{
							System.out.println("Thank you for visiting .........");
							lservice.closeMyConnection();
						}
						default->{
							System.out.println("wrong choice");
						}
						}
					}while(choice!=7);
						
					}else if(role.equals("user")) {
						System.out.println("you are user role");
					}else {
						System.out.println("invalid Credentials, Pls relogin");
					}
		}else {
			System.out.println("invalid Credentials, Pls relogin");
		}
		

	}

}