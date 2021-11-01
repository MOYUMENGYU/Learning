package experiment_third;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlOperation {
	
	public static ArrayList<Student> queryStudent(String sql){
		Statement state=null;
		ResultSet result=null;
		Student student=null;
		ArrayList<Student>studentList=new ArrayList<>();
		try {
			 state=SqlConnection.getConnection().createStatement();
			 result=state.executeQuery(sql);
			 while(result.next()) {
				 student=new Student();
				 student.setNumber(result.getString("number"));
				 student.setName(result.getString("name"));
				 student.setSex(result.getString("sex"));
				 student.setAccount(result.getString("account"));
				 student.setPassword(result.getString("password"));
				 student.setPhone(result.getString("phone"));
				 student.setMail(result.getString("mail"));
				 student.setAddress(result.getString("address"));
				 student.setgrade(result.getString("Grade"));
				 student.setMajor(result.getString("major"));
				 student.setClassNumber(result.getString("classNumber"));
				 student.setRemark(result.getString("remark"));
				 studentList.add(student);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(state!=null) {
				try {
					state.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return studentList;
	}
	
	public static int saveStudent(Student student) {
		PreparedStatement prepare=null;
		String sql="insert into tb_student values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int i=0;
		try {
			 prepare=SqlConnection.getConnection().prepareStatement(sql);
			 prepare.setObject(1,null);
			 prepare.setString(2,student.getNumber());
			 prepare.setString(3,student.getName());
			 prepare.setString(4,student.getSex());
			 prepare.setString(5,student.getAccount());
			 prepare.setString(6,student.getPassword());
			 prepare.setString(7,student.getPhone());
			 prepare.setString(8,student.getMail());
			 prepare.setString(9,student.getAddress());
			 prepare.setString(10,student.getgrade());
			 prepare.setString(11,student.getMajor());
			 prepare.setString(12,student.getClassNumber());
			 prepare.setString(13,student.getRemark());
			 i=prepare.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public static int updateStudent(Student student) {
		PreparedStatement prepare=null;
		int i=0;
		String sql="update tb_student set number=?,name=?,sex=?,account=?,password=?,phone=?,mail=?,address=?,"
				+ "Grade=?,major=?,classNumber=?,remark=? where number=?";
		try {
			prepare=SqlConnection.getConnection().prepareStatement(sql);
			 prepare.setString(1,student.getNumber());
			 prepare.setString(2,student.getName());
			 prepare.setString(3,student.getSex());
			 prepare.setString(4,student.getAccount());
			 prepare.setString(5,student.getPassword());
			 prepare.setString(6,student.getPhone());
			 prepare.setString(7,student.getMail());
			 prepare.setString(8,student.getAddress());
			 prepare.setString(9,student.getgrade());
			 prepare.setString(10,student.getMajor());
			 prepare.setString(11,student.getClassNumber());
			 prepare.setString(12,student.getRemark());
			 prepare.setString(13,student.getNumber());
			 i=prepare.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}	
	
	public static int deleteStudent(String name) {
		String sql="delete from tb_student where name=?";
		PreparedStatement preparedStatement=null;
		int result=0;
		try {
			preparedStatement=SqlConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1,name);
			result=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList<Student> allStudents=SqlOperation.queryStudent("select * from tb_student");
		System.out.println("姓名 性别 电话 绩点 ");
		for(Student student:allStudents){
			System.out.println(student.getName()+"    "+student.getSex()+"   "+student.getPhone()+"   "+student.getgrade());
		}
		ArrayList<Student> students=SqlOperation.queryStudent("select * from tb_student where id=1");
		System.out.println("姓名 性别 电话 绩点 ");
		for(Student student:allStudents){
			System.out.println(student.getName()+"    "+student.getSex()+"   "+student.getPhone()+"   "+student.getgrade());
		}
		Student tom=new Student();
		tom.setNumber("23");
		tom.setName("tom");
		tom.setSex("男");
		tom.setAccount("345634");
		tom.setPassword("23423");
		tom.setPhone("235346");
		tom.setMail("463");
		tom.setAddress("34535");
		tom.setgrade("23");
		tom.setMajor("sdfdsf");
		tom.setClassNumber("2");
		tom.setRemark("345");
		int x=SqlOperation.saveStudent(tom);
		if(x>0){
			System.out.println("插入数据成功！");
		}
		tom.setgrade("3456ertre");
		int y=SqlOperation.updateStudent(tom);
		if(y>0){
			System.out.println("更新数据成功！");
		}
		int z=SqlOperation.deleteStudent(tom.name);
		if(z>0){
			System.out.println("删除成功！");
		}
	}
}
