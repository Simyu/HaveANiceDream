package sms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

public class SMSSendMethod {
	public void SMSSend(String rphone, String msg) {
		String action = "go";
//System.out.println(rphone);
		if (action.equals("go")) {

			String sms_url = "";
			// �ڵ�м� sms_url�� /�� ������ ����
			sms_url = "https://sslsms.cafe24.com/sms_sender.php"; // SMS ���ۿ�û	�Ľ��ҿ���.. 				// URL
			String user_id="akros"; //���̵�
			String secure ="5492e6e676d488f648e38150c11e2919";//����Ű (�����ϰų� ��� ���������� �ܿ�����Ƚ���� ������.)
			System.out.println(user_id);
			System.out.println(secure);
			try {
				user_id = SMSService.base64Encode(user_id);
				secure = SMSService.base64Encode(secure);// ����Ű
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} // SMS���̵�
			
			// String msg = "�׽�Ʈ����";
			// String rphone="010-4487-1321"
			//msg = "�׽�Ʈ����";
			//rphone = "010-4487-1321";
			String sphone1 = "010";
			String sphone2 = "8553";
			String sphone3 = "7314";
			String rdate = "";
			String rtime = "";
			String mode = "";
			
			System.out.println(msg);
			System.out.println(sms_url);
			System.out.println(rphone);
			System.out.println(sphone1);
			System.out.println(sphone2);
			System.out.println(sphone3);
			try {
				msg = SMSService.base64Encode(msg);
				rphone = SMSService.base64Encode(rphone);
				sphone1 = SMSService.base64Encode(sphone1);
				sphone2 = SMSService.base64Encode(sphone2);
				sphone3 = SMSService.base64Encode(sphone3);
				 rdate = SMSService.base64Encode(rdate);
			        rtime = SMSService.base64Encode(rtime);
			         mode = SMSService.base64Encode("1");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			String subject = "";
			String testflag = "";
			String destination = "";
			String repeatFlag = "";
			String repeatNum = "";
			String repeatTime = "";
			String returnurl = "";
			String nointeractive = "";
			String smsType = "";

			// ���ø�...
			String[] host_info = sms_url.split("/");// https:
			String host = host_info[2];// host=/sslsms.cafe24.com 
			String path = "/" + host_info[3];// path=/sms_sender.php
			int port = 80;

			// ������ ���� ���� ����
			String arrKey[] = new String[] { "user_id", "secure", "msg", "rphone", "sphone1", "sphone2", "sphone3",
					"rdate", "rtime", "mode", "testflag", "destination", "repeatFlag", "repeatNum", "repeatTime",
					"smsType", "subject" };
			String valKey[] = new String[arrKey.length];
			valKey[0] = user_id;
			valKey[1] = secure;
			valKey[2] = msg;
			valKey[3] = rphone;
			valKey[4] = sphone1;
			valKey[5] = sphone2;
			valKey[6] = sphone3;  //��������� �ʼ���ȣ
			valKey[7] = rdate;//�ʼ��ƴ�.. �׷���������
			valKey[8] = rtime;
			valKey[9] = mode;
			valKey[10] = testflag;
			valKey[11] = destination;
			valKey[12] = repeatFlag;
			valKey[13] = repeatNum;
			valKey[14] = repeatTime;
			valKey[15] = smsType;
			valKey[16] = subject;
			
			String boundary = "";
			Random rnd = new Random();
			String rndKey = Integer.toString(rnd.nextInt(32000));
			MessageDigest md = null;
			try {
				md = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] bytData = rndKey.getBytes();
			md.update(bytData);
			byte[] digest = md.digest();
			for (int i = 0; i < digest.length; i++) {
				boundary = boundary + Integer.toHexString(digest[i] & 0xFF);
			}
			boundary = "---------------------" + boundary.substring(0, 11);

			// ���� ����
			String data = "";
			String index = "";
			String value = "";
			for (int i = 0; i < arrKey.length; i++) {
				index = arrKey[i];
				value = valKey[i];
				data += "--" + boundary + "\r\n";
				data += "Content-Disposition: form-data; name=\"" + index + "\"\r\n";
				data += "\r\n" + value + "\r\n";
				data += "--" + boundary + "\r\n";
			}

			// out.println(data);
			// ��ȿ��üũ
			/*if (rphone.replaceAll("-", "").length() < 8 || rphone.replaceAll("-", "").length() > 11
					|| rphone.charAt(0) != '0') {
				System.out.print("<script>alert('�ڵ�����ȣ�� �ٸ��� �Է��ϼ���')</script>");
			} else {*/
				try {
					System.out.println("�������ι�������");
					InetAddress addr = InetAddress.getByName(host);
					Socket socket = new Socket(host, port);  // host=/sslsms.cafe24.com  port 80 
					// ��� ����
					BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
					wr.write("POST " + path + " HTTP/1.0\r\n"); // path=/sms_sender.php
					wr.write("Content-Length: " + data.length() + "\r\n");
					wr.write("Content-type: multipart/form-data, boundary=" + boundary + "\r\n");
					wr.write("\r\n");

					// ������ ����
					wr.write(data);
					wr.flush();

					// ����� ���
					BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
					String line;
					String alert = "";
					ArrayList tmpArr = new ArrayList();
					while ((line = rd.readLine()) != null) {
						tmpArr.add(line);
					}
					wr.close();
					rd.close();
					String tmpMsg = (String) tmpArr.get(tmpArr.size() - 1);
					String[] rMsg = tmpMsg.split(",");
					String Result = rMsg[0]; // �߼۰��
					String Count = ""; // �ܿ��Ǽ�
					if (rMsg.length > 1) {
						Count = rMsg[1];
					}

					// �߼۰�� �˸�
					if (Result.equals("success")) {
						alert = "���������� �߼��Ͽ����ϴ�.";
						alert += " �ܿ��Ǽ��� " + Count + "�� �Դϴ�.";
					} else if (Result.equals("reserved")) {
						alert = "���������� ����Ǿ����ϴ�";
						alert += " �ܿ��Ǽ��� " + Count + "�� �Դϴ�.";
					} else if (Result.equals("3205")) {
						alert = "�߸��� ��ȣ�����Դϴ�.";
					} else {
						alert = "[Error]" + Result;
					}
					System.out.println(nointeractive);

					if (nointeractive.equals("1") && !(Result.equals("Test Success!")) && !(Result.equals("success"))
							&& !(Result.equals("reserved"))) {
						System.out.println("<script>alert('" + alert + "')</script>");
					} else if (!(nointeractive.equals("1"))) {
						System.out.println("<script>alert('" + alert + "')</script>");
					}

					System.out.println("<script>location.href='" + returnurl + "';</script>");
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			
		}
	}

}
