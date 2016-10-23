package com.chipatel.wsapis.bookkeeping.resources;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.chipatel.wsapis.bookkeeping.model.Income;
import com.chipatel.wsapis.bookkeeping.service.IncomeService;

/**
 *
 * @author cpatel
 *
 */

@Path("/income")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class IncomeResource {

	IncomeService incomeservice = new IncomeService();

	@POST
	@Path("add")
	public String addIncome(Income income) throws SQLException {
		System.out.println(income.toString());
		boolean result = incomeservice.addIncome(income.getName(), income.getAmount());
		if (result) {
			return "Record inseted sucessfully !!!";
		} else {
			return "Something went wrong while inserting record!!!";
		}
	}

	@GET
	public ArrayList<Income> getAllIncome() throws SQLException {
		return incomeservice.getAllIncome();
	}

	@GET
	@Path("id={id}")
	public Income getIncome(@PathParam("id") int id) throws SQLException {
		return incomeservice.getIncome(id);
	}

}
