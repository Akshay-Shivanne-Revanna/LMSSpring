package com.gcit.lms.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;


import com.gcit.lms.entity.Branch;


public class BranchDAO extends BaseDAO implements ResultSetExtractor<List<Branch>>{

	
	
	//INSERT NEW BRANCH
	public void addBranch(Branch branch) throws ClassNotFoundException,SQLException{
		template.update("insert into tbl_library_branch (branchName,branchAddress) values (?,?)", new Object[] {branch.getBranchName(),branch.getBranchAddress()});
	}
	
	//UPDATE BRANCH
	public void updateBranch(Branch branch) throws ClassNotFoundException, SQLException{
		template.update("update tbl_library_branch set branchName =?,branchAddress=? where branchId =? ", new Object[] {branch.getBranchName(),branch.getBranchAddress(),branch.getBranchId()});
	}
	
	
	//DELETE BRANCH
	public void deleteBranch(Branch branch) throws ClassNotFoundException, SQLException{
		template.update("delete from tbl_library_branch where branchId = ?", new Object[] {branch.getBranchId()});
	}
	
	//READ BRANCH BY NAME
	public List<Branch> readBranchByName(String name,int pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		name="%"+name+"%";
		return (List<Branch>) template.query("select * from tbl_library_branch where branchName like ?", new Object[] {name},this);
	}
	
	
	public List<Branch> readAllBranches(int pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		return (List<Branch>) template.query("select * from tbl_library_branch",this);
	}

	public Branch readBranchByID(Integer branchId) throws ClassNotFoundException, SQLException{
		List<Branch> branches = (List<Branch>) template.query("select * from tbl_library_branch where branchId =?", new Object[] {branchId},this);
		if(branches!=null && branches.size()>0){
			return branches.get(0);
		}
		return null;
	}
	
	/*//GET COUNT OF NUMBER OF AUTHORS
	public Integer getCount() throws ClassNotFoundException, SQLException{
		return getCount("select count(*) from tbl_library_branch");
	}
	*/
	@Override
	public List<Branch> extractData(ResultSet rs) throws SQLException {
		List<Branch> branches = new ArrayList<Branch>();
		
		while(rs.next()){
			Branch br = new Branch();
			
			br.setBranchId(rs.getInt("branchId"));
			br.setBranchName(rs.getString("branchName"));
			br.setBranchAddress(rs.getString("branchAddress"));
			
			branches.add(br);
		}
		return branches;
	}
	

	
	
}
