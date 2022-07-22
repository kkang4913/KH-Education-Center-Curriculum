package common.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.conn.db.DBConn;

public abstract class AbstractDAO<C, E>  {

	protected SqlSession session = DBConn.getSqlSession();
	//제네릭 타입 생성:<안의 타입을 정해서 사용 가능 ex)string , integer >
	public abstract C selectAll();
	public abstract E selectId(E e);
	public abstract E selectId(int id);
	public abstract int rowCount();
	public abstract boolean insertDate(E e);
	public abstract boolean updateDate(E e);
	public abstract boolean deleteDate(int id);
	public abstract boolean deleteDate(E e);

	

	public void commit() {
		session.commit();
	}
	public void rollback() {
		session.rollback();
	}
	public void close() {
		session.close();
	}
}
