package skapaProyect.ventanasPrimarias;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogController {
	private static Logger log = Logger.getLogger("LOG");
	
	public static void log (Level level, String msg, Throwable ex) throws SecurityException{
		FileHandler loghandler = null;
		log = Logger.getLogger(LogController.class.getName() );
		log.setLevel(Level.ALL);
		try {
			loghandler = new FileHandler("log.xml", true);
			log.addHandler(loghandler);
		}catch (Exception e) {
			log.log(Level.SEVERE, "No se pudo crear el fuchero log", e);
		}
		if (ex == null) {
			log.log(level, msg);
		}else {
			log.log(level, msg, ex);
		}
		
		if (loghandler != null) {
			loghandler.close();
		}
	}

}
