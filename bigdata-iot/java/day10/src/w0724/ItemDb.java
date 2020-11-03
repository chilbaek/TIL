package w0724;

import java.util.ArrayList;

public class ItemDb extends Db<String, Item> {

	@Override
	public void insert(Item v) throws Exception {
		connect();
		if(v.getId().equals("it01")) {
			close();
			//throw new Exception("Duplicated ID..");
		}
		System.out.println("INSERTED: "+v);
		close();
	}

	@Override
	public void update(Item v) throws Exception {
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
	public Item select(String k) throws Exception {
		Item item = null;
		//k���� �̿��ؼ� ����� ������ �˻��Ѵ�.
		item = new Item("it01", "����", 0101);
		return item;
	}

	@Override
	public ArrayList<Item> select() throws Exception {
		
		
		return null;
	}

}
