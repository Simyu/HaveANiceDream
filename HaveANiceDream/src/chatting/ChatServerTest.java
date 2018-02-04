package chatting;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import note.dto.NoteDTO;
import note.service.NoteService;
import note.service.NoteServiceImpl;

@ServerEndpoint("/user/chat")
public class ChatServerTest {
	private static final String GUEST_PREFIX = "Guest";
	// 값이 저절로 증가하는 integer
	private static final AtomicInteger connectionIds = new AtomicInteger(0);
	/*
	 * CopyOnWriteArraySet은 Set의 구현체(Set interface를 구현한 클래스 중 하나)이다. 그런데
	 * CopyOnWriteArraySet은 copy-on-write array라는(실제 CopyOnWriteArraySet는
	 * CopyOnWriteArrayList를 멤버변수로 가지고 있고 add,remove,contains 등등 대부분의 메서드를 가지고
	 * 있다.) CopyOnWriteArraySet, CopyOnWriteArrayList의 핵심은 변경작업들, add,remove,
	 * set등의 작업에 대해 내부 배열변수에 복사본들 만들어 놓고, 해당 작업을 수행한다는 것이다. 이렇게 하면 interation시에
	 * 추가,삭제에 대해 동시성이 보장이 된다는 이점이 있다고 생각된다.
	 */
	// 아무튼 set!
	private static final Set<ChatServerTest> connections = new CopyOnWriteArraySet<ChatServerTest>();

	private final String nickname;
	private Session session;

	public ChatServerTest() {
		// 닉네임 자동생성
		nickname = GUEST_PREFIX + connectionIds.getAndIncrement();
	}

	@OnOpen // 누군가 접속했따!!!!
	public void start(Session session) {
		// 세션 가져와서
		this.session = session;
		// 내 연결정보 추가여~~
		connections.add(this);
		// 누구누구 님이 접속하셨습니다.
		//String message = String.format("* %s %s", nickname, "has joined");
		// 모든 커넥션에 방송하기
		//broadcast(message);
	}

	@OnClose // 누군가 나갔어여!!
	public void end() {
		// 내 연결 삭제
		connections.remove(this);
		// 누구누구 님이 나갔습니다.
		//String message = String.format("* %s %s", nickname, "has disconnected");
		// 모든 커넥션에 방송하기
		//broadcast(message);
	}

	@OnMessage // 메시지 왔숑!
	public void incoming(String message) {
		// 클라이언트를 믿지 말것!!!!!
		//String filteredMessage = HTMLFilter.filter(message.toString());
		JSONParser parser = new JSONParser();
		try {
			JSONObject object = (JSONObject) parser.parse(message);
			NoteDTO dto = new NoteDTO((String)object.get("from"), (String)object.get("to"), (String)object.get("text"));
			NoteService service = new NoteServiceImpl();
			service.noteInsert(dto);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 방송합니다!
		broadcast(message);
	}

	@OnError // 에러났어요!!!!
	public void onError(Throwable t) throws Throwable {
		System.out.println("Chat Error: " + t.toString());
	}

	private void broadcast(String message) {
		for (ChatServerTest client : connections) {
			try {
				// 동기화 처리
				synchronized (client) {
					// 한놈씩 보낸다
					client.session.getBasicRemote().sendText(message);
				}
			} catch (IOException e) {
				// 근데 실패 ㅎㅎ
				System.out.println("Chat Error: Failed to send message to client");
				e.printStackTrace();

				// 너 꺼졍!!
				connections.remove(client);

				try {
					// 세션을 닫습니다.
					client.session.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// 누구누구 님이 나갔습니다.
				String message1 = String.format("* %s %s", nickname, "has disconnected");
				// 모든 커넥션에 방송하기
				broadcast(message1);
			}
		}

	}
}
