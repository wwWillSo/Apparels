package dao;

import java.util.List;

public interface IDAO<T> {
	public boolean doCreate(T vo) throws Exception ;
	public boolean doDelete(int id) throws Exception ;
	public boolean doUpdate(T vo) throws Exception ;
	public T findById(int id) throws Exception ;
	public List<T> findAll() throws Exception ;
	public List<T> findAll(String keyWord) throws Exception ;
	public int getAllCount(String keyWord) throws Exception ;
}
