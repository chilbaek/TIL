package w0724;

import java.util.ArrayList;

public class UserDb extends Db<String,User> {
	
	
	public UserDb() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDb(String ip, int port) {
		super(ip, port);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(User v) throws Exception {
		connect();
		if(v.getId().equals("serom")) {
			close();
			//throw new Exception("Duplicated ID..");
		}
		System.out.println("INSERTED: "+v);
		close();
		}

	@Override
	public void update(User v) throws Exception {
		connect();
		System.out.println("UPDATED: "+v);
		close();
		}

	@Override
	public void delete(String k) throws Exception {
		connect();
		System.out.println("DELETED: "+k);
		close();
		}

	@Override
	public User select(String k) throws Exception {
		User user = null;
		//k���� �̿��ؼ� ����� ������ �˻��Ѵ�.
		user = new User("id99", "pwd90", "�̸���");
		return user;
	}

	@Override
	public ArrayList<User> select() throws Exception {
		ArrayList<User> list = new ArrayList<>();
		list.add(new User("id01", "pwd01", "��"));
		list.add(new User("id02", "pwd02", "��"));
		list.add(new User("id03", "pwd03", "��"));
		list.add(new User("id04", "pwd04", "��"));
		list.add(new User("id05", "pwd06", "��"));
		return list;
	}

	

	
}
