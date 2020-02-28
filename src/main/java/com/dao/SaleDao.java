package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.stereotype.Repository;

import com.sale.Sale;

@Repository
public class SaleDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public SaleDao(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Sale> list(){
		
		String sql ="SELECT * FROM SALES";
		
		System.out.println("Hello in dao ");
		
		List<Sale> listsale =jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Sale.class));
		
		return listsale;
	}
	
	public void save (Sale sale) {
		
		SimpleJdbcInsert insertaction = new SimpleJdbcInsert(jdbcTemplate);
		insertaction.withTableName("sales").usingColumns("item","quantity","amount");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sale);
		
		insertaction.execute(param);
		
		
	}
	
	public Sale get(int id) {
		
		String sql = "SELECT * FROM SALES WHERE id = ?";
		
		Object[] args= {id};
		
		Sale sale = jdbcTemplate.queryForObject(sql, args ,
				                     BeanPropertyRowMapper.newInstance(Sale.class));
		
		return sale;
	}
	public void update (Sale sale){
		
		String sql = "UPDATE SALES SET item=:item, quantity=:quantity,"
			                     	+ "amount=:amount WHERE id =:id";
		
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sale);
		
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		template.update(sql, param);
		
		
	}
	
	public void delete (int id) {
		
		String sql = "DELETE FROM SALES WHERE id = ?";
		 
		jdbcTemplate.update(sql , id);
	
		
	}

}
