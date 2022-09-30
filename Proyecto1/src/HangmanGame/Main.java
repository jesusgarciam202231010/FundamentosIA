package HangmanGame;

import jadex.base.PlatformConfiguration;
import jadex.base.Starter;
import jadex.bridge.IComponentIdentifier;
import jadex.bridge.IExternalAccess;
import jadex.bridge.service.search.SServiceProvider;
import jadex.bridge.service.types.cms.CreationInfo;
import jadex.bridge.service.types.cms.IComponentManagementService;
import jadex.commons.SUtil;
import jadex.commons.future.IFuture;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*PlatformConfiguration config = PlatformConfiguration.getDefaultNoGui();
		config.addComponent("HangmanGame.Jugador_1BDI.class");
		Starter.createPlatform(config).get();*/
		
		PlatformConfiguration config = PlatformConfiguration.getDefaultNoGui();

		IExternalAccess platform = Starter.createPlatform(config).get();
		IFuture<IComponentManagementService> fut = SServiceProvider.getService(platform, IComponentManagementService.class);
		IComponentManagementService cms = fut.get();
		IComponentIdentifier cid = cms.createComponent("Jugador_1BDI", "HangmanGame.Jugador_1BDI.class", null).getFirstResult();
		//System.out.println("Jugador 1 creado id: " + cid);
		CreationInfo ci = new CreationInfo(SUtil.createHashMap(new String[]{"receiver"}, new Object[]{cid}));
		IComponentIdentifier cid2 = cms.createComponent("Jugador_2BDI", "HangmanGame.Jugador_2BDI.class", ci).getFirstResult();
		//System.out.println("Jugador 2 creado id: " + cid2);
		
	}
	
}