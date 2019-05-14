package com.schulz.bennet.springbootswagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> getUser(String id) {
		
		List<Funcionario> l = new ArrayList<>();
		l.add(this.funcionarioRepository.findById(Integer.valueOf(id)));
		return l;
	}

}
