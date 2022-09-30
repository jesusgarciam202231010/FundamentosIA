package HangmanGame;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import jadex.bdiv3.annotation.Belief;
import jadex.bdiv3.features.IBDIAgentFeature;
import jadex.bridge.component.IExecutionFeature;
import jadex.bridge.component.IMessageFeature;
import jadex.bridge.fipa.SFipa;
import jadex.bridge.service.types.message.MessageType;
import jadex.micro.annotation.Agent;
import jadex.micro.annotation.AgentCreated;
import jadex.micro.annotation.AgentFeature;
import jadex.micro.annotation.AgentMessageArrived;
import jadex.micro.annotation.Description;

@Agent
@Description("Jugador 2 quien debe adivinar la palabra")

public class Jugador_2BDI {

	@AgentFeature protected IBDIAgentFeature bdiFeature; 
	
	@AgentFeature protected IExecutionFeature execFeature; 
	
	@Belief // agregar trigger 
	protected String alfabeto = "abcdefghijklmnopqrstuvxz";
	
	@Belief // agregar trigger 
	protected String palabra_adivinada;
	
	@Belief // agregar trigger 
	protected String letras_utilizadas; 
	
	@Belief // agregar el como va a cambiar 
	protected int parteAhorcada; 
	
	@Belief(dynamic = true) // hacerlo dinamico, ver si tiene una propiedad dinamica 
	protected boolean findeJuego; // agregar el resultado del cual depende @AgentCreated public void init() { }
	
	@AgentCreated 
	public void init() throws FileNotFoundException, IOException {
		Random random = new Random();
		int index = random.nextInt(alfabeto.length());
		int guess = (int) alfabeto.charAt(index);
		alfabeto = alfabeto.substring(0,index) + alfabeto.substring(index+1);
		System.out.println("Guess = " + (char)guess);
		//return guess;
	}
	
	/*@AgentMessageArrived
	public void messageArrived(Map<String, Object> msg, final MessageType mt)
	{
		String perf = (String)msg.get(SFipa.PERFORMATIVE);
		if((SFipa.QUERY_IF.equals(perf) || SFipa.QUERY_REF.equals(perf)) 
			&& "hola".equals(msg.get(SFipa.CONTENT)))
		{
			Map<String, Object> reply = mt.createReply(msg);
			reply.put(SFipa.CONTENT, "alive");

			reply.put(SFipa.PERFORMATIVE, SFipa.INFORM);
			reply.put(SFipa.SENDER, agent.getComponentIdentifier());
			agent.getComponentFeature(IMessageFeature.class).sendMessage(reply, mt);
		}
		else
		{
			agent.getLogger().severe("Could not process message: "+msg);
		}
	}*/
	
}
