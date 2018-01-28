package sms;

public class sendTest {

	public static void main(String[] args) {
		SMSSendMethod test = new SMSSendMethod();
		
		//�׽�Ʈ�뵵�� 
		String login_user_tel = "010-4487-1321";//�α��� �����(������) ������ dto���� ȹ���� ����
		String enroll_user_tel = "010-3939-5012";//��ǰ �����(�Ǹ���) ����ѻ���� dto���� ȹ���� ����
		String rphone=login_user_tel+","+enroll_user_tel;//����������� �������۰��� �ڵ��� ��ȣ��  ,�α��� 
		test.SMSSend(rphone, "test");//������ȣ,�Է��� ���ڳ���: [���Ź�ȣ ��ǰ]��  ���������� �ŷ���û�Ǿ����ϴ�. �ŷ�����Ʈ : [4000]
		                                   //[ ����] DB������;
	}

}
