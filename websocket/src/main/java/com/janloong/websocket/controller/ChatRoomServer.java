package com.janloong.websocket.controller;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * 趣味聊天的服务端程序
 * @author keven
 *
 */
//声明websocket某个服务端的地址
@ServerEndpoint("/chatRoomServer")
public class ChatRoomServer {

	private boolean firstFlag = true;
	private Session session ;
	private String userName;
	//记录此次聊天室的服务端有多少个连接
	//key代表此次客户端的session,value代表此次连接对象
	private static final HashMap<String,Object> connectMap = new HashMap<String,Object>();
	//保存所有的用户昵称信息，
	//key是sessionId,value才是用户名
	private static final HashMap<String,String> userMap = new HashMap<String,String>();
	
	//服务端收到客户端连接请求，连接成功后会执行此方法
	@OnOpen
	public void start(Session session){
		this.session = session;
		connectMap.put(session.getId(), this);
	}
	
	@OnMessage
	public void chat(String clientMessage,Session session){
		ChatRoomServer client = null;
		if(firstFlag){
			this.userName = clientMessage;
			//将新进来的用户保存到用户map
			userMap.put(session.getId(), userName);
			//构造发送给客户端的提示信息
			String message = htmlMessage("系统消息",userName+"进入聊天室");
			//将消息广播给所有的用户
			for(String connectKey:connectMap.keySet()){
				 client = (ChatRoomServer) connectMap.get(connectKey);
				 //给对应的web短发送一个文本信息（message）
				 try {
					client.session.getBasicRemote().sendText(message);
				} catch (IOException e) {
	 				e.printStackTrace();
				}
			}	
			//输入昵称以后 ,是不是代表firstFlag = false;
			firstFlag = false;
		}else{
			//构造发送给客户端的提示信息
			String message = htmlMessage(userMap.get(session.getId()),clientMessage);
			//将消息广播给所有的用户
			for(String connectKey:connectMap.keySet()){
				 client = (ChatRoomServer) connectMap.get(connectKey);				
				 //给对应的web短发送一个文本信息（message）
				 try {
					client.session.getBasicRemote().sendText(message);
				} catch (IOException e) {
	 				e.printStackTrace();
				}
			}	
		}
	}
	
	
	
	//ws.clos事件,会触发后台的标注OnClose的方法
	@OnClose
	public void close(Session session){
		//当某个用户退出时,对其他用户进行广播
		String message = htmlMessage("系统消息",userMap.get(session.getId())+"退出了聊天室");
		userMap.remove(session.getId());
		connectMap.remove(session.getId());
		ChatRoomServer client = null;
		//将消息广播给所有的用户
		for(String connectKey:connectMap.keySet()){
			 client = (ChatRoomServer) connectMap.get(connectKey);				
			 //给对应的web短发送一个文本信息（message）
			 try {
				client.session.getBasicRemote().sendText(message);
			} catch (IOException e) {
 				e.printStackTrace();
			}
		}	
		
		
	}
	
	public String htmlMessage(String userName,String message){
	       StringBuffer messageBuffer = new StringBuffer();
	       SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		      messageBuffer.append("<div class='record_item'>");
		      messageBuffer.append("<p class='record_item_time'>");
		      messageBuffer.append("<span>"+sf.format(new Date())+"</span>");
		      messageBuffer.append("</p>");
		      messageBuffer.append("<div class='record_item_txt'>");
		      messageBuffer.append("<span class='avatar'>"+userName+"</span>");
		      messageBuffer.append("<p>");
		      messageBuffer.append("<span class='txt'>"+message+"</span>");
		      messageBuffer.append("</p>");
		      messageBuffer.append("</div>");
		      messageBuffer.append("</div>");
		  return  messageBuffer.toString();
	    }
	
}
