package com.gcit.lms.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;


import com.gcit.lms.entity.Borrower;




public class BorrowerDAO extends BaseDAO implements ResultSetExtractor<List<Borrower>>{

	
	
	//ADD BORROWER
	public void addBorrower(Borrower borr) throws ClassNotFoundException, SQLException{
		template.update("insert into tbl_borrower (name,address,phone) values (?,?,?)", new Object[] {borr.getName(),borr.getAddress(),borr.getPhone()});
	}
	
	//UPDATE BORROWER
	public void updateBorrower(Borrower borr) throws ClassNotFoundException, SQLException{
		template.update("update tbl_borrower set name = ?,address=?,phone=? where cardNo = ?", new Object[] {borr.getName(), borr.getAddress(),borr.getPhone(),borr.getCardNo()});
	}
	
	//DELETE BORROWER
	public void deleteBorrower(Borrower borr) throws ClassNotFoundException, SQLException{
		template.update("delete from tbl_borrower where cardNo = ?", new Object[] {borr.getCardNo()});
	}
	
	public List<Borrower> readAllBorrowers(int pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		return (List<Borrower>) template.query("select * from tbl_borrower", this);
	}
	
	//READ BORROWER BY NAME
	public List<Borrower> readBorrowerByName(String name,int pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		name="%"+name+"%";
		return (List<Borrower>) template.query("select * from tbl_borrower where name like ?", new Object[] {name},this);
	}
	
	
	/*//GET COUNT OF NUMBER OF AUTHORS
	public Integer getCount() throws ClassNotFoundException, SQLException{
		return getCount("select count(*) from tbl_borrower");
	}
	*/
	public Borrower readBorrowerByID(Integer cardNo) throws ClassNotFoundException, SQLException{
		List<Borrower> borrower = (List<Borrower>) template.query("select * from tbl_borrower where cardNo =?", new Object[] {cardNo},this);
		if(borrower!=null && borrower.size()>0){
			return borrower.get(0);
		}
		return null;
	}
	

	@Override
	public List<Borrower> extractData(ResultSet rs) throws SQLException {
		List<Borrower> borrower = new ArrayList<Borrower>();
		
		while(rs.next()){
			Borrower borr = new Borrower();
			borr.setCardNo(rs.getInt("cardNo"));
			borr.setName(rs.getString("name"));;
			borr.setAddress(rs.getString("address"));
			borr.setPhone(rs.getString("phone"));
			
			borrower.add(borr);
		}
		
		
		return borrower;
	}
	
	
	/*public int CheckCard(Integer cardNo) throws ClassNotFoundException, SQLException {
		System.out.println("In borrower Dao");
		return getCount2("select case when count(br.cardNo)>0 then 1 else 0 end from tbl_borrower as br where br.cardNo=?",new Object[] {cardNo});
		
	}*/

	
	
	
	
}

