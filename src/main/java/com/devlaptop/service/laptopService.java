package com.devlaptop.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.devlaptop.model.laptop;
import com.devlaptop.repository.laptopRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class laptopService {
	
	
	//dependency injection for repository
		@Autowired
		private laptopRepository laprepo;
		//adding laptop to db
		public String addLaptop(laptop l1) {
			String msg=null;
			laptop _l2=laprepo.save(l1);
			if(_l2!=null) {
				msg= "laptop added!... @"+new Date();
			}
			else {
				msg=null;
			}
			return msg;
		}
		
		//retriving list of laptops
		public List<laptop> getLaptop(){
			return laprepo.findAll();
		}
			
		//updating the existing laptop in db
		public String updateLaptop(laptop l1)
		{
			laptop _l2=laprepo.save(l1);
			if(_l2!=null) {
				return "laptop updated "+new Date();
			}
			else {
				return null;
			}
		}
		
		//deleting laptop based on lapid if it is existed in db
		public String deleteLaptop(int lapid) {
			
			Optional<laptop> _l1=laprepo.findById(lapid);
			if(_l1!=null) {
				laprepo.deleteById(lapid);
				return "laptop deleted";
			}
			else {
				return null;
			}
		}
		
		//sorting the list of laptops based on a specific field of a table
		public List<laptop> getLaptops(String field){
			
			
			return laprepo.findAll(Sort.by(Direction.DESC,field));
			
			
		}

}
