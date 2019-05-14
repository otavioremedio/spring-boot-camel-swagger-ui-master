package com.schulz.bennet.springbootswagger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
	
	@Transactional(readOnly = true)
	Funcionario findById(@Param("id") Integer id);

}