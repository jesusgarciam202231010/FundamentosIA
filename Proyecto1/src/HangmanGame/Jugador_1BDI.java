package HangmanGame;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import jadex.bdiv3.annotation.Belief;
import jadex.bdiv3.annotation.Plan;
import jadex.bdiv3.annotation.Trigger;
import jadex.bdiv3.features.IBDIAgentFeature;
import jadex.bridge.component.IExecutionFeature;
import jadex.micro.annotation.Agent;
import jadex.micro.annotation.AgentBody;
import jadex.micro.annotation.AgentCreated;
import jadex.micro.annotation.AgentFeature;
import jadex.micro.annotation.Description;

@Agent
@Description("Jugador 1 quien elige la palabra a adivinar")

public class Jugador_1BDI {

	@AgentFeature protected IBDIAgentFeature bdiFeature; 
	
	@AgentFeature protected IExecutionFeature execFeature; 
	
	@Belief // agregar trigger 
	protected List<String> palabras = new ArrayList<>();
	
	@Belief // agregar trigger 
	protected String palabra_random; 
	
	@Belief // agregar trigger - letra que envia el agnete 2 
	protected List letradivinada = new ArrayList();
	
	@Belief // agregar el como va a cambiar 
	protected int parteAhorcada; 
	
	@Belief(dynamic = true) // hacerlo dinamico, ver si tiene una propiedad dinamica 
	protected boolean findeJuego; // agregar el resultado del cual depende @AgentCreated public void init() { }
	
	@AgentCreated 
	public void init() throws FileNotFoundException, IOException { 
		/*File file = new File("/home/jesusgm/Downloads/prueba_texto.txt"); 
		try (BufferedReader br = new BufferedReader(new FileReader(file))) { 
			String st; while ((st = br.readLine()) != null) { 
				PalabrasEspanol.add(st);		
			} 
		}*/
		Scanner scanner = new Scanner(new File("/home/jesusgm/Downloads/prueba_texto.txt"));
	      
	    while (scanner.hasNext()) {
	    	palabras.add(scanner.nextLine());
	    }
	    
	    Random rand = new Random();
	    palabra_random = palabras.get(rand.nextInt(palabras.size()));
		
	} 
	
	@AgentBody
	public void body(){
		 System.out.println(palabras);
		 System.out.println(palabra_random);
	}
	
}
