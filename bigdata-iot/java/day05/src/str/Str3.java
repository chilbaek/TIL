package str;

public class Str3 {

	public static void main(String[] args) {
		String email = "jmlee@tonesol.com";
		//id��  ������ �и��Ͽ� ��Ʈ�� ����� ���
		int idx = email.indexOf("@");
		System.out.println("id: " + email.substring(0,idx));
		System.out.println("domain: " + email.substring(idx+1));
		
	}

}
